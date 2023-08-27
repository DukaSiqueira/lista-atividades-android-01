package com.example.exampleactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.exampleactivity.model.Aluno;

public class CadastroAlunoActivity extends AppCompatActivity {

    private Button btSalvar;

    private EditText edRaAluno, edNomeAluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_aluno);

        btSalvar = findViewById(R.id.btSalvar);
        edNomeAluno = findViewById(R.id.edNome);
        edRaAluno = findViewById(R.id.edRa);


        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarAluno();
            }
        });
    }

    private void salvarAluno() {
        // Validação dos campos
        if (edRaAluno.getText().toString().isEmpty()) {
            edRaAluno.setError("Informe o R.A. do aluno!");
            return;
        }

        if (edNomeAluno.getText().toString().isEmpty()) {
            edNomeAluno.setError("Informe o Nome do aluno!");
            return;
        }

        // Cria o objeto aluno e atribui seus campos
        Aluno aluno = new Aluno();
        aluno.setRa(Integer.parseInt(edRaAluno.getText().toString()));
        aluno.setNome(edNomeAluno.getText().toString());

        Controller.getInstance().salvarAluno(aluno);

        this.finish();
    }
}