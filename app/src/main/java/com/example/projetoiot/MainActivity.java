package com.example.projetoiot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button ligar;
    private Button desligar;

    private Integer desligamentoForcado = 0;
    private Integer ativacaoForcada = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        ligar = findViewById(R.id.btLigar);
        desligar = findViewById(R.id.btDesligar);

        ligar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ligar.getText().equals("LIGAR") || ativacaoForcada == 0) {
                    ligar.setBackgroundResource(R.drawable.background_button_ligado);
                    ligar.setText("LIGADO");
                    desligar.setBackgroundResource(R.drawable.background_button_desativado);
                    desligar.setText("DESLIGAR");
                    ativacaoForcada = 5;
                }else{

                    Toast.makeText(MainActivity.this, "Comando não executado (BOMBA LIGADA). Pressione mais ["+ativacaoForcada+"] em caso de emergência!!", Toast.LENGTH_SHORT).show();
                    ativacaoForcada--;

                }
            }
        });

        desligar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(desligar.getText().equals("DESLIGAR") || desligamentoForcado == 0){

                    desligar.setBackgroundResource(R.drawable.background_button_desligado);
                    desligar.setText("DESLIGADO");
                    ligar.setBackgroundResource(R.drawable.background_button_desativado);
                    ligar.setText("LIGAR");
                    desligamentoForcado = 5;

                }else{

                    Toast.makeText(MainActivity.this, "Comando não executado (BOMBA DESLIGADA). Pressione mais ["+desligamentoForcado+"] em caso de emergência!!", Toast.LENGTH_SHORT).show();
                    desligamentoForcado--;
                }

            }
        });

    }
}