package com.example.exampleactivity;

import com.example.exampleactivity.model.Materia;

import java.util.ArrayList;

public class ControllerMateria {

    private static ControllerMateria instancia;

    private static ArrayList<Materia> listMaterias;

    // Garante que seja criado apenas uma instância da classe global
    public static ControllerMateria getInstance() {
        if (instancia == null)
            return instancia = new ControllerMateria();
        else
            return  instancia;
    }

    // Cria o array list da classe
    private ControllerMateria(){
        listMaterias = new ArrayList<>();
    }

    public void salvarMateria(Materia materia) {
        listMaterias.add(materia);
    }

    public ArrayList<Materia> retornarMaterias() {
        return listMaterias;
    }
}
