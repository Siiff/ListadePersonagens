package com.example.listadepersonagens.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listadepersonagens.R;
import com.example.listadepersonagens.dao.PersonagemDAO;
import com.example.listadepersonagens.model.Personagem;

import java.io.Serializable;

public class FormularioPersonagemActivity extends AppCompatActivity {

    //Pegando os ID's dos campos para toda classe//
    private EditText campoNome;
    private EditText campoAltura;
    private EditText campoNascimento;
    //criando um banco de data do personagem
    private final PersonagemDAO dao = new PersonagemDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_personagem);
        //Setando o titulo
        setTitle("Formulário de Personagens");

        //setando os editText com determinados elementos do Hud//
        campoNome = findViewById(R.id.editTextName);
        campoAltura = findViewById(R.id.editTextAltura);
        campoNascimento = findViewById(R.id.editTextNascimento);


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

                //utilizando o metodo salvar para salvar o personagem nesse banco
                dao.salvar(personagemsalvo);
                //Terminando o formulário
                finish();

                //abrindo nova activity//
                    //startActivity(new Intent(FormularioPersonagemActivity.this, ListaPersonagensActivity.class) );

                //Juntando tudo e instanciando o personagem//
                //new Personagem(nome,altura,nascimento);

                personagemsalvo.setNome(nome);
                personagemsalvo.setAltura(altura);
                personagemsalvo.setNascimento(nascimento);
                dao.editar(personagemsalvo);

                Intent dados = getIntent();
                Personagem personagem = (Personagem) dados.getSerializableExtra("personagem");
                campoNome.setText(personagem.getNome());
                campoAltura.setText(personagem.getAltura());
                campoNascimento.setText(personagem.getNascimento());

                /*//Toast utilizando os gets para pegar as variaveis//
                Toast.makeText(FormularioPersonagemActivity.this,
                        personagemsalvo.getNome() + " - " + personagemsalvo.getAltura() + " - " +
                                personagemsalvo.getNascimento(), Toast.LENGTH_SHORT).show();

                //checando se o botão Enviar esta funcionando e criando sua função através do java//
                //Toast.makeText(FormularioPersonagemActivity.this,"Estou funcionando", Toast.LENGTH_SHORT).show();*/

            }
        });
    }


}