package org.example.controller;

import org.example.dominio.Funcionario;
import org.example.repository.FuncionarioRepository;
import org.example.validations.ValidarCamposNulos;

import java.time.LocalDate;
import java.util.List;

public class FuncionarioController {
    private final FuncionarioRepository funcionarioRepository = new FuncionarioRepository();

    public List<Funcionario> showFuncionarios() {
        List<Funcionario> funcionarios = funcionarioRepository.funcionarios();
        
        return funcionarios;
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

    public boolean updateFuncionario(Funcionario funcionario, Integer id){
        if(!ValidarCamposNulos.existeNulos(funcionario).isEmpty()){
            return false;
        }
        return funcionarioRepository.updateFuncionario(funcionario,id)
                .map(funcionarioUpdated -> true)
                .orElse(false);

    }

    public boolean deleteFuncionario(Integer id) {
        return funcionarioRepository.deleteFuncionario(id);
    }
}
