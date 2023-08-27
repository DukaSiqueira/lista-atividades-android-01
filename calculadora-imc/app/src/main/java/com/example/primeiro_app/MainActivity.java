package com.example.primeiro_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText altura, peso;

    private TextView result;
    private Button btHomem;
    private Button btMulher;
    private Button btLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btHomem = findViewById(R.id.calcularHomem);
        btMulher = findViewById(R.id.calcularMulher);
        btLimpar = findViewById(R.id.limpar);

        altura = findViewById(R.id.alturaPessoa);
        peso = findViewById(R.id.pesoPessoa);
        result = findViewById(R.id.tvResult);

        btHomem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcImcHomem();
            }
        });

        btMulher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcImcMulher();
            }
        });

        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpar();
            }
        });
    }

    protected void limpar() {
        altura.setText("");
        peso.setText("");
        result.setText("");
    }

    protected void calcImcHomem() {
        double altura = Double.parseDouble(this.altura.getText().toString());
        double peso = Double.parseDouble(this.peso.getText().toString());

        DecimalFormat df = new DecimalFormat("#.##");
        double imc = Double.parseDouble(df.format(peso / (altura * altura)));

        if (imc < 20.7) {
            result.setText("Peso abaixo do normal\n IMC: " + imc);
        } else if (imc >= 20.7 && imc <= 26.4) {
            result.setText("Peso normal\n IMC: " + imc);
        } else if (imc > 26.4 && imc <= 27.8) {
            result.setText("Peso levemente acima do normal\n IMC: " + imc);
        } else if (imc > 27.8 && imc <= 31.1) {
            result.setText("Peso acima do ideal\n IMC: " + imc);
        } else if (imc > 31.1) {
            result.setText("Obeso\n IMC: " + imc);
        } else {
            result.setText("Erro ao calcular IMC");
        }

    }

    private void calcImcMulher() {
        double altura = Double.parseDouble(this.altura.getText().toString());
        double peso = Double.parseDouble(this.peso.getText().toString());

        DecimalFormat df = new DecimalFormat("#.##");
        double imc = Double.parseDouble(df.format(peso / (altura * altura)));

        if (imc < 19.1) {
            result.setText("Peso abaixo do normal\n IMC: " + imc);
        } else if (imc >= 19.1 && imc <= 25.8) {
            result.setText("Peso normal\n IMC: " + imc);
        } else if (imc > 25.8 && imc <= 27.3) {
            result.setText("Peso levemente acima do normal\n IMC: " + imc);
        } else if (imc > 27.3 && imc <= 32.3) {
            result.setText("Peso acima do ideal\n IMC: " + imc);
        } else if (imc > 32.3) {
            result.setText("Obeso\n IMC: " + imc);
        } else {
            result.setText("Erro ao calcular IMC");
        }

    }
}