package com.example.exampleactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.exampleactivity.model.Aluno;

public class MainActivity extends AppCompatActivity {

    private Button btCadastrarAluno, btCadastrarProfessor, btCadastrarMateria, btCadastrarTurma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCadastrarAluno = findViewById(R.id.btCadastrarAluno);
        btCadastrarProfessor = findViewById(R.id.btCadastrarProfessor);
        btCadastrarMateria = findViewById(R.id.btCadastrarMateria);
        btCadastrarTurma = findViewById(R.id.btCadastrarTurma);

        btCadastrarAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCadastroAluno();
            }
        });

        btCadastrarProfessor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { abrirCadastroProfessor(); }
        });

        btCadastrarMateria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCadastroMateria();
            }
        });

        btCadastrarTurma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { abrirCadastroTurma(); }
        });

    }

    private void abrirCadastroProfessor() {
        Intent intent = new Intent(this, CadastroProfessorActivity.class);
        startActivity(intent);
    }

    private void abrirCadastroAluno() {
        Intent intent = new Intent(this, CadastroAlunoActivity.class);
        startActivity(intent);
    }

    private void abrirCadastroMateria() {
        Intent intent = new Intent(this, CadastroMateriaActivity.class);
        startActivity(intent);
    }

    private void abrirCadastroTurma() {
        Intent intent = new Intent(this, CadastroTurmaActivity.class);
        startActivity(intent);
    }

}