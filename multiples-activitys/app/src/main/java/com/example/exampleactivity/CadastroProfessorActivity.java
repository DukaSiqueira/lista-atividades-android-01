package com.example.exampleactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.exampleactivity.model.Professor;

public class CadastroProfessorActivity extends AppCompatActivity {

    private Button btSalvar;

    private EditText edMatricula, edNome, edCpf, edDataNascimento, edDataAdmissao;

    private TextView tvProfessoresCadastrados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_professor);

        btSalvar = findViewById(R.id.btSalvar);

        edMatricula = findViewById(R.id.edMatricula);
        edNome = findViewById(R.id.edNome);
        edCpf = findViewById(R.id.edCpf);
        edDataNascimento = findViewById(R.id.edDataNascimento);
        edDataAdmissao = findViewById(R.id.edDataAdmissao);
        tvProfessoresCadastrados = findViewById(R.id.tvProfessoresCadastrados);

        this.atualizarListaProfessores();

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarProfessor();
            }
        });
    }

    private void salvarProfessor() {
        // Validação dos campos
        if (edMatricula.getText().toString().isEmpty()) {
            edMatricula.setError("Informe a matrícula do professor!");
            return;
        }

        if (edNome.getText().toString().isEmpty()) {
            edNome.setError("Informe o Nome do professor!");
            return;
        }

        if (edCpf.getText().toString().isEmpty()) {
            edCpf.setError("Informe o CPF do professor!");
            return;
        }

        if (edDataNascimento.getText().toString().isEmpty()) {
            edDataNascimento.setError("Informe a data de nascimento do professor!");
            return;
        }

        if (edDataAdmissao.getText().toString().isEmpty()) {
            edDataAdmissao.setError("Informe a data de admissão do professor!");
            return;
        }

        Professor professor = new Professor();
        professor.setMatricula(Integer.parseInt(edMatricula.getText().toString()));
        professor.setNome(edNome.getText().toString());
        professor.setCpf(edCpf.getText().toString());
        professor.setDataNascimento(edDataNascimento.getText().toString());
        professor.setDataAdmissao(edDataAdmissao.getText().toString());

        ControllerProfessor.getInstance().salvarProfessor(professor);

        Toast.makeText(this, "Professor cadastrado com sucesso", Toast.LENGTH_SHORT).show();

        this.finish();
    }

    private void atualizarListaProfessores() {
        String texto = "";

        for (Professor professor : ControllerProfessor.getInstance().retornarProfessores()) {
            texto += "Matrícula: " + professor.getMatricula() + "\n" +
                    "Nome: " + professor.getNome() + "\n" +
                    "CPF:" + professor.getCpf() + "\n" +
                    "Data Nasc.:" + professor.getDataNascimento() + "\n" +
                    "Data Admissão: " + professor.getDataAdmissao() + "\n" +
                    "_________________________________" + "\n";
        }
        tvProfessoresCadastrados.setText(texto);
    }
}