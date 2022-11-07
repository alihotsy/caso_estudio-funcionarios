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
        funcionarioController.showFuncionarios().forEach(System.out::println);
        System.out.println("===========================================================");

        //CREA UN FUNCIONARIO
        /*Funcionario newFuncionario = new Funcionario();
        newFuncionario.setId(102265498);
        newFuncionario.setTipoId("Cédula de ciudadanía");
        newFuncionario.setNombre("Andy");
        newFuncionario.setApellido("Hertzfeld");
        newFuncionario.setEstadoCivil("Casado");
        newFuncionario.setSexo('M');
        newFuncionario.setDireccion("CRA 32 # 11 A 59");
        newFuncionario.setTelefono("59759841");
        newFuncionario.setFechaNacimiento(LocalDate.of(1983, 4,16));

        System.out.println("Crea un funcionario: "+funcionarioController.createFuncionario(newFuncionario));
        System.out.println("===========================================================");*/

        //BUSCA UN FUNCIONARIO POR EL ID DADO
        /*System.out.println("Encuentra un funcionario por Id: "+funcionarioController.findOneById(-12));
        System.out.println("===========================================================");*/

        //ACTUALIZAR UN FUNCIONARIO:
        /*Funcionario funcionario = new Funcionario();
        funcionario.setId(10225669);
        funcionario.setTipoId("Cédula de ciudadanía");
        funcionario.setNombre("Jhon");
        funcionario.setApellido("Wick");
        funcionario.setEstadoCivil("Viudo");
        funcionario.setSexo('M');
        funcionario.setDireccion("CRA 23 # 12 A 30");
        funcionario.setTelefono("25569871");
        funcionario.setFechaNacimiento(LocalDate.of(1998, 6,5));
        System.out.println("Actualiza un funcionario: "+funcionarioController.updateFuncionario(funcionario,10225669));*/
        System.out.println("===========================================================");

        //ELIMINAR UN FUNCIONARIO
        System.out.println(funcionarioController.deleteFuncionario(10225669));
    }
}