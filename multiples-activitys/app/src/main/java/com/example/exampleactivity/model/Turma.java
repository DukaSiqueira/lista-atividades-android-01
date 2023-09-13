package com.example.exampleactivity.model;

import java.util.ArrayList;

public class Turma {

    private String descricao;
    private  String sistema;
    private String periodo;
    ArrayList<Materia> materias;
    ArrayList<Aluno> alunos;

    public Turma() {
    }

    public Turma(String descricao, String sistema, String periodo, ArrayList<Materia> materias, ArrayList<Aluno> alunos) {
        this.descricao = descricao;
        this.sistema = sistema;
        this.periodo = periodo;
        this.materias = materias;
        this.alunos = alunos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public ArrayList<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(ArrayList<Materia> materias) {
        this.materias = materias;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }
}
