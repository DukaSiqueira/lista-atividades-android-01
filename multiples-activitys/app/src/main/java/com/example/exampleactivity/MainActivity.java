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

    private Button btCadastrarAluno;
    private TextView tvAlunosCadastrados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCadastrarAluno = findViewById(R.id.btCadastrarAluno);
        tvAlunosCadastrados = findViewById(R.id.tvAlunosCadastrados);

        btCadastrarAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCadastroAluno();
            }
        });

    }

    private void abrirCadastroAluno() {
        Intent intent = new Intent(this, CadastroAlunoActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        String texto = "";

        for (Aluno aluno : Controller.getInstance().retornarAlunos()) {
            texto += "R.A.: " + aluno.getRa() + " Nome: " + aluno.getNome() + "\n";
        }
        tvAlunosCadastrados.setText(texto);
    }

}