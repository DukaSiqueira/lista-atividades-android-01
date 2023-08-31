package com.example.exampleactivity;

import com.example.exampleactivity.model.Professor;

import java.util.ArrayList;

public class ControllerProfessor {

    private static ControllerProfessor instancia;

    private static ArrayList<Professor> listProfessores;

    // Garante que seja criado apenas uma instância da classe global
    public static ControllerProfessor getInstance() {
        if (instancia == null)
            return instancia = new ControllerProfessor();
        else
            return  instancia;
    }

    // Cria o array list da classe
    private ControllerProfessor(){
        listProfessores = new ArrayList<>();
    }

    public void salvarProfessor(Professor aluno) {
        listProfessores.add(aluno);
    }

    public ArrayList<Professor> retornarProfessores() {
        return listProfessores;
    }
}
