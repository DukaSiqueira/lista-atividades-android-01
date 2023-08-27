package com.example.exampleactivity;

import com.example.exampleactivity.model.Aluno;

import java.util.ArrayList;

public class Controller {

    private static Controller instancia;

    private static ArrayList<Aluno> listAlunos;

    // Garante que seja criado apenas uma instância da classe global
    public static Controller getInstance() {
        if (instancia == null)
            return instancia = new Controller();
        else
            return  instancia;
    }

    // Cria o array list da classe
    private Controller(){
        listAlunos = new ArrayList<>();
    }

    public void salvarAluno(Aluno aluno) {
        listAlunos.add(aluno);
    }

    public ArrayList<Aluno> retornarAlunos() {
        return listAlunos;
    }
}
