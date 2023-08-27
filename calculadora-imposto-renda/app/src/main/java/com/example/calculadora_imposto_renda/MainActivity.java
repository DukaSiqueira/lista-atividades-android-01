package com.example.calculadora_imposto_renda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btCalcular;
    private EditText etRendaBrutaMensal;
    private EditText etDependentes;
    private EditText etDeducoes;
    private TextView tvResp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etRendaBrutaMensal = findViewById(R.id.etRendaBrutaMensal);
        etDependentes = findViewById(R.id.etDependentes);
        etDeducoes = findViewById(R.id.etDeducoes);
        tvResp = findViewById(R.id.tvResp);

        btCalcular = findViewById(R.id.btCalcular);
        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularImpostoRenda();
            }
        });
    }

    private void calcularImpostoRenda() {
        double rendaBrutaMensal = Double.parseDouble(etRendaBrutaMensal.getText().toString());
        if (rendaBrutaMensal < 18000.00) {
            tvResp.setText("Imposto: 0,00");
        } else if (rendaBrutaMensal >= 18000.01 && rendaBrutaMensal <= 27000) {
            tvResp.setText("Em andamento");
        }
    }
}