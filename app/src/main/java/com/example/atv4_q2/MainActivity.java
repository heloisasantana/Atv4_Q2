package com.seuusuario.appcentenadezenaunidade;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/*
 *@author:Heloísa Santana da Silva
 */

public class MainActivity extends AppCompatActivity {

    private EditText editTextNumero;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referenciando os componentes da interface
        editTextNumero = findViewById(R.id.editTextNumero);
        Button buttonCalcular = findViewById(R.id.buttonCalcular);
        textViewResultado = findViewById(R.id.textViewResultado);

        // Configurando o evento de clique no botão "Calcular"
        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularCentenaDezenaUnidade();
            }
        });
    }

    private void calcularCentenaDezenaUnidade() {
        try {
            // Obtendo o número inserido pelo usuário
            int numero = Integer.parseInt(editTextNumero.getText().toString());

            // Verificando se o número está no intervalo de 100 a 999
            if (numero < 100 || numero > 999) {
                textViewResultado.setText("Por favor, insira um número entre 100 e 999.");
                return;
            }

            // Calculando a centena, dezena e unidade
            int centena = numero / 100;
            int dezena = (numero / 10) % 10;
            int unidade = numero % 10;

            // Exibindo o resultado
            textViewResultado.setText(String.format("CENTENA = %d\nDEZENA = %d\nUNIDADE = %d", centena, dezena, unidade));
        } catch (NumberFormatException e) {
            textViewResultado.setText("Por favor, insira um número válido.");
        }
    }
}
