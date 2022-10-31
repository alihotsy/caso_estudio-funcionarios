package org.example;


import org.example.controller.FuncionarioController;
import org.example.dominio.Funcionario;
import org.example.repository.FuncionarioRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //LISTA TODOS LOS FUNCIONARIOS
        FuncionarioController funcionarioController = new FuncionarioController();
        funcionarioController.showFuncionarios();
        System.out.println("===========================================================");

        //CREA UN FUNCIONARIO
        /*Funcionario newFuncionario = new Funcionario();
        newFuncionario.setId(10225669);
        newFuncionario.setTipoId("Cédula de ciudadanía");
        newFuncionario.setNombre("Jhon");
        newFuncionario.setApellido("Wick");
        newFuncionario.setEstadoCivil("Viudo");
        newFuncionario.setSexo('F');
        newFuncionario.setDireccion("CRA 41 # 23 A 44");
        newFuncionario.setTelefono("4551023");
        newFuncionario.setFechaNacimiento(LocalDate.of(1993, 2,9));

        System.out.println("Crea un funcionario: "+funcionarioController.createFuncionario(newFuncionario));*/
        System.out.println("===========================================================");

        //BUSCA UN FUNCIONARIO POR EL ID DADO
        System.out.println("Encuentra un funcionario por Id "+funcionarioController.findOneById(10599873));
        System.out.println("===========================================================");
        //ACTUALIZAR UN FUNCIONARIO:
        Funcionario funcionario = new Funcionario();
        funcionario.setId(10998520);
        funcionario.setTipoId("Cédula de ciudadanía");
        funcionario.setNombre("Angella");
        funcionario.setApellido("Montoya");
        funcionario.setEstadoCivil("Soltera");
        funcionario.setSexo('M');
        funcionario.setDireccion("CRA 32 # 20 A 66");
        funcionario.setTelefono("44521032");
        funcionario.setFechaNacimiento(LocalDate.of(1998, 6,5));
        System.out.println("Actualiza un funcionario: "+funcionarioController.updateFuncionario(funcionario,10225669));
        System.out.println("===========================================================");

        //ELIMINAR UN FUNCIONARIO
        System.out.println(funcionarioController.deleteFuncionario(10599876));
    }
}