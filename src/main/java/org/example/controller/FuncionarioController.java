package org.example.controller;

import org.example.dominio.Funcionario;
import org.example.repository.FuncionarioRepository;
import org.example.validations.ValidarCamposNulos;

import java.time.LocalDate;
import java.util.List;

public class FuncionarioController {
    private final FuncionarioRepository funcionarioRepository = new FuncionarioRepository();

    public void showFuncionarios() {
        List<Funcionario> funcionarios = funcionarioRepository.funcionarios();
        if(funcionarios.isEmpty()){
            System.out.println("No hay funcionarios en la DB");
        }else {
            funcionarios.forEach(System.out::println);
        }
    }

    public Funcionario createFuncionario(Funcionario funcionario) {

            if(ValidarCamposNulos.existeNulos(funcionario).isEmpty()) {
                return funcionarioRepository.createFuncionario(funcionario);
            }
            return null;

    }

    public String findOneById(Integer id) {
        return funcionarioRepository.findOne(id)
                .map(Funcionario::toString)
                .orElse("No se encontró este funcionario con ID = " +id);
    }

    public String updateFuncionario(Funcionario funcionario, Integer id){
        if(!ValidarCamposNulos.existeNulos(funcionario).isEmpty()){
            return ValidarCamposNulos.existeNulos(funcionario).toString();
        }
        return funcionarioRepository.updateFuncionario(funcionario,id)
                .map(Funcionario::toString)
                .orElse("No existe ningún funcionario con ID = " +id+" para ser actualizado" +
                        " o algo salió mal");

    }

    public String deleteFuncionario(Integer id) {
        return funcionarioRepository.deleteFuncionario(id)
                ? "Funcionario eliminado satisfactoriamente"
                : "No existe ningún funcionario con ID = " + id+ " para ser eliminado" +
                " o algo salió mal";

    }
}
