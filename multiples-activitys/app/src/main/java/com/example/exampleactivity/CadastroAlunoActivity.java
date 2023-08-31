package com.example.exampleactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.exampleactivity.model.Aluno;

public class CadastroAlunoActivity extends AppCompatActivity {

    private Button btSalvar;

    private EditText edRaAluno, edNomeAluno;

    private TextView tvAlunosCadastrados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_aluno);

        btSalvar = findViewById(R.id.btSalvar);
        edNomeAluno = findViewById(R.id.edNome);
        edRaAluno = findViewById(R.id.edRa);
        tvAlunosCadastrados = findViewById(R.id.tvAlunosCadastrados);

        this.atualizarListaAlunos();

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

        Toast.makeText(this, "Aluno cadastrado com sucesso", Toast.LENGTH_SHORT).show();

        this.finish();
    }

    private void atualizarListaAlunos() {
        String texto = "";

        for (Aluno aluno : Controller.getInstance().retornarAlunos()) {
            texto += "R.A.: " + aluno.getRa() + " Nome: " + aluno.getNome() + "\n";
        }
        tvAlunosCadastrados.setText(texto);
    }
}