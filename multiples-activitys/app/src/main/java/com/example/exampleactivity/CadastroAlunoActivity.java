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

    private EditText edRaAluno, edNomeAluno, edCpf, edDataNascimento;

    private TextView tvAlunosCadastrados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_aluno);

        btSalvar = findViewById(R.id.btSalvar);
        edNomeAluno = findViewById(R.id.edNome);
        edRaAluno = findViewById(R.id.edRa);
        edCpf = findViewById(R.id.edCpf);
        edDataNascimento = findViewById(R.id.edDataNascimento);
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

        if (edCpf.getText().toString().isEmpty()) {
            edCpf.setError("Informe o CPF do aluno!");
            return;
        }

        if (edDataNascimento.getText().toString().isEmpty()) {
            edDataNascimento.setError("Informe a data de nascimento do aluno!");
            return;
        }

        // Cria o objeto aluno e atribui seus campos
        Aluno aluno = new Aluno();
        aluno.setRa(Integer.parseInt(edRaAluno.getText().toString()));
        aluno.setNome(edNomeAluno.getText().toString());
        aluno.setCpf(edCpf.getText().toString());
        aluno.setDataNascimento(edDataNascimento.getText().toString());

        ControllerAluno.getInstance().salvarAluno(aluno);

        Toast.makeText(this, "Aluno cadastrado com sucesso", Toast.LENGTH_SHORT).show();

        this.finish();
    }

    private void atualizarListaAlunos() {
        String texto = "";

        for (Aluno aluno : ControllerAluno.getInstance().retornarAlunos()) {
            texto += "R.A.: " + aluno.getRa() + "\n" +
                "Nome: " + aluno.getNome() + "\n" +
                "CPF:" + aluno.getCpf() + "\n" +
                "Data Nasc.:" + aluno.getDataNascimento() + "\n" +
            "_________________________________" + "\n";
        }
        tvAlunosCadastrados.setText(texto);
    }
}