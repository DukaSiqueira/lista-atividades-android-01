package com.example.exampleactivity.model;

public class Materia {

    private String descricao;

    private Double cargaHoraria;

    private Professor professor;

    public Materia() {}

    public Materia(int codDisciplina, String descricao, Double cargaHoraria, Professor professor) {
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
