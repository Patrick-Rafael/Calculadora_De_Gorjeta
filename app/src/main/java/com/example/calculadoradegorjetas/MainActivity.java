package com.example.calculadoradegorjetas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editVaor;
    private TextView textPorcentagem;
    private TextView textGorjeta;
    private TextView textTotal;
    private SeekBar seekBarGorjeta;

    private double porcentagem =  0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editVaor = findViewById(R.id.textValor);
        textPorcentagem = findViewById(R.id.textPorcentagem);
        textGorjeta = findViewById(R.id.textGorgeja);
        textTotal = findViewById(R.id.textTotal);
        seekBarGorjeta = findViewById(R.id.seekBar3);


        //Adcionar Listner Seekar
        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                porcentagem = progress;
                textPorcentagem.setText(Math.round(porcentagem) + "%");
                calcular();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    public void calcular(){

        String valoRecuperado = editVaor.getText().toString();

        if(valoRecuperado == null || valoRecuperado.equals("")){

            Toast.makeText(
                    getApplicationContext(),
                    "Digite um valor prineiro",
                    Toast.LENGTH_LONG).show();
        }else{

            //Converter para double

            double valorDigitado = Double.parseDouble(valoRecuperado);

            //Calcular Gorjeta

            double gorjeta = valorDigitado * (porcentagem/100);
            double totalRecebe = gorjeta + valorDigitado;

            //Exibir gorjeta

            textGorjeta.setText("R$ " + Math.round(gorjeta));
            textTotal.setText("R$ " + Math.round(totalRecebe));

        }


    }

}