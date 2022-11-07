package org.example.repository;

import org.example.dominio.Funcionario;

import java.util.List;
import java.util.Optional;

public interface FuncionarioCrudRepository {
    List<Funcionario> funcionarios();

    Funcionario createFuncionario(Funcionario funcionario);

    Optional<Funcionario> updateFuncionario(Funcionario funcionario, Integer id);


    boolean deleteFuncionario(Integer id);

    Optional<Funcionario> findOne(Integer id);


}
