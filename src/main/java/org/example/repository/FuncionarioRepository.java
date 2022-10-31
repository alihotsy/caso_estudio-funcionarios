package org.example.repository;

import org.example.configuration.DataBaseConfiguration;
import org.example.dominio.Funcionario;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FuncionarioRepository implements FuncionarioCrudRepository {
    private final DataSource dataSource;

    public FuncionarioRepository() {
        DataBaseConfiguration dbConnection = new DataBaseConfiguration();
        dataSource = dbConnection.dataSource();
    }

    @Override
    public List<Funcionario> funcionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        String sqlQuery = "SELECT * FROM funcionarios";
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement(sqlQuery);
                ResultSet rs = ps.executeQuery();
                ){
            while (rs.next()){
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getInt("id_funcionario"));
                funcionario.setTipoId(rs.getString("tipo_id"));
                funcionario.setNombre(rs.getString("nombre"));
                funcionario.setApellido(rs.getString("apellidos"));
                funcionario.setEstadoCivil(rs.getString("estado_civil"));
                funcionario.setSexo(rs.getString("sexo").charAt(0));
                funcionario.setDireccion(rs.getString("direccion"));
                funcionario.setTelefono(rs.getString("telefono"));
                funcionario.setFechaNacimiento(LocalDate.parse(rs.getString("fecha_nacimiento")));
                funcionarios.add(funcionario);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return funcionarios;
    }

    @Override
    public Funcionario createFuncionario(Funcionario funcionario) {
        String sqlQuery = "INSERT INTO funcionarios(id_funcionario,tipo_id,nombre,apellidos,estado_civil,\n" +
                "\t\t\t\t\t\tsexo,direccion,telefono,fecha_nacimiento) VALUES(?,?,?,?,?,?,?,?,?)";
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement(sqlQuery);
                ) {
            ps.setInt(1,funcionario.getId());
            ps.setString(2,funcionario.getTipoId());
            ps.setString(3,funcionario.getNombre());
            ps.setString(4,funcionario.getApellido());
            ps.setString(5,funcionario.getEstadoCivil());
            ps.setString(6,funcionario.getSexo().toString());
            ps.setString(7,funcionario.getDireccion());
            ps.setString(8,funcionario.getTelefono());
            ps.setDate(9,java.sql.Date.valueOf(funcionario.getFechaNacimiento()));
            ps.execute();
            return funcionario;
        }  catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public Optional<Funcionario> updateFuncionario(Funcionario funcionario, Integer id) {
        return findOne(id)
                .map(funcionarioFound -> {
                    String sqlQuery = "UPDATE funcionarios SET id_funcionario = ?," +
                            "tipo_id = ?,nombre = ?,apellidos = ?,estado_civil = ?," +
                            "sexo = ?,direccion = ?,telefono = ?, fecha_nacimiento = ?" +
                            "WHERE id_funcionario = ?";
                    try(
                            Connection connection = dataSource.getConnection();
                            PreparedStatement ps = connection.prepareStatement(sqlQuery)
                            ){
                        ps.setInt(1,funcionario.getId());
                        ps.setString(2,funcionario.getTipoId());
                        ps.setString(3,funcionario.getNombre());
                        ps.setString(4,funcionario.getApellido());
                        ps.setString(5,funcionario.getEstadoCivil());
                        ps.setString(6,funcionario.getSexo().toString());
                        ps.setString(7,funcionario.getDireccion());
                        ps.setString(8,funcionario.getTelefono());
                        ps.setDate(9,java.sql.Date.valueOf(funcionario.getFechaNacimiento()));
                        ps.setInt(10,id);
                        ps.execute();
                        return funcionario;
                    }catch (Exception e) {
                        e.printStackTrace();
                       return null;
                    }

                });
    }

    @Override
    public boolean deleteFuncionario(Integer id) {
        return findOne(id)
                .map(funcionario -> {
                    String sqlQuery = "DELETE FROM funcionarios WHERE id_funcionario = ?";
                    try(
                            Connection connection = dataSource.getConnection();
                            PreparedStatement ps = connection.prepareStatement(sqlQuery);
                            ){
                        ps.setInt(1,id);
                        ps.execute();
                    }catch (SQLException e){
                        throw new Error("Algo salió mal =( "+e.getMessage());
                    }
                    return true;
                }).orElse(false);
    }

    @Override
    public Optional<Funcionario> findOne(Integer id) {
        Funcionario funcionario = null;
        String sqlQuery = "SELECT * FROM funcionarios WHERE id_funcionario = ?";
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement(sqlQuery)
                ){
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
          if(rs.next()){
            funcionario = new Funcionario();
              funcionario.setId(rs.getInt("id_funcionario"));
              funcionario.setTipoId(rs.getString("tipo_id"));
              funcionario.setNombre(rs.getString("nombre"));
              funcionario.setApellido(rs.getString("apellidos"));
              funcionario.setEstadoCivil(rs.getString("estado_civil"));
              funcionario.setSexo(rs.getString("sexo").charAt(0));
              funcionario.setDireccion(rs.getString("direccion"));
              funcionario.setTelefono(rs.getString("telefono"));
              funcionario.setFechaNacimiento(LocalDate.parse(rs.getString("fecha_nacimiento")));
          }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.ofNullable(funcionario);
    }
}
