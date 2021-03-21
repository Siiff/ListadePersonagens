package com.example.listadepersonagens.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.listadepersonagens.R;

public class FormularioPersonagemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_personagem);

        Button botaoEnviar = findViewById(R.id.botaoEnviar);
        botaoEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //checando se o botão Enviar esta funcionando e criando sua função através do java//
                Toast.makeText(FormularioPersonagemActivity.this,"Estou funcionando", Toast.LENGTH_SHORT).show();
            }
        });
    }
}