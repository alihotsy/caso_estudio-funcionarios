package org.example.validations;

import org.example.dominio.Funcionario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidarCamposNulos {

    public static List<String> existeNulos(Funcionario funcionario) {
        List<String> mensajes = new ArrayList<>();
        Map<String,String> funcionarioMap = new HashMap<>();

        funcionarioMap.put("tipo id",funcionario.getTipoId());
        funcionarioMap.put("nombre",funcionario.getNombre());
        funcionarioMap.put("apellido",funcionario.getApellido());
        funcionarioMap.put("estado_civil",funcionario.getEstadoCivil());
        funcionarioMap.put("sexo",funcionario.getSexo().toString());
        funcionarioMap.put("direccion",funcionario.getDireccion());
        funcionarioMap.put("telefono",funcionario.getTelefono());
        funcionarioMap.put("fecha_nacimiento",funcionario.getFechaNacimiento().toString());

        funcionarioMap.forEach((k,v) -> {
            if(v.trim().isEmpty()) {
                mensajes.add(k+" no puede ser vacío");
            }
        });
        if(funcionario.getId() <= 0) {
            mensajes.add("El id no puede ser un valor inferior o igual a 0");
        }

        return mensajes;

    }
}
