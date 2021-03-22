package com.example.listadepersonagens.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.listadepersonagens.R;
import com.example.listadepersonagens.model.Personagem;

public class FormularioPersonagemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_personagem);

        //Pegando os ID's dos campos//
        EditText campoNome = findViewById(R.id.editTextName);
        EditText campoAltura = findViewById(R.id.editTextAltura);
        EditText campoNascimento = findViewById(R.id.editTextNascimento);


        //aqui estamos pegando o botão para colocar um listener de ações nele, no caso, o click//
        Button botaoEnviar = findViewById(R.id.botaoEnviar);
        botaoEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Convertendo o texto dos campos em strings//
                String nome = campoNome.getText().toString();
                String altura = campoAltura.getText().toString();
                String nascimento = campoNascimento.getText().toString();

                Personagem personagemsalvo = new Personagem(nome,altura,nascimento);

                //Toast utilizando os gets para pegar as variaveis//
                Toast.makeText(FormularioPersonagemActivity.this,
                        personagemsalvo.getNome() + " - " + personagemsalvo.getAltura() + " - " +
                                personagemsalvo.getNascimento(), Toast.LENGTH_SHORT).show();

                //Juntando tudo e instanciando o personagem//
                new Personagem(nome,altura,nascimento);

                //checando se o botão Enviar esta funcionando e criando sua função através do java//
                //Toast.makeText(FormularioPersonagemActivity.this,"Estou funcionando", Toast.LENGTH_SHORT).show();



            }
        });
    }
}