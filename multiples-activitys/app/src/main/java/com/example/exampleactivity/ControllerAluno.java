package com.example.exampleactivity;

import com.example.exampleactivity.model.Aluno;

import java.util.ArrayList;

public class ControllerAluno {

    private static ControllerAluno instancia;

    private static ArrayList<Aluno> listAlunos;

    // Garante que seja criado apenas uma instância da classe global
    public static ControllerAluno getInstance() {
        if (instancia == null)
            return instancia = new ControllerAluno();
        else
            return  instancia;
    }

    // Cria o array list da classe
    private ControllerAluno(){
        listAlunos = new ArrayList<>();
    }

    public void salvarAluno(Aluno aluno) {
        listAlunos.add(aluno);
    }

    public ArrayList<Aluno> retornarAlunos() {
        return listAlunos;
    }
}
