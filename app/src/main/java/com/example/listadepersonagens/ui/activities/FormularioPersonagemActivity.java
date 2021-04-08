package com.example.listadepersonagens.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.listadepersonagens.R;
import com.example.listadepersonagens.dao.PersonagemDAO;
import com.example.listadepersonagens.model.Personagem;

public class FormularioPersonagemActivity extends AppCompatActivity {

    //Pegando os ID's dos campos para toda classe//
    private EditText campoNome;
    private EditText campoAltura;
    private EditText campoNascimento;

    //criando um banco de data do personagem
    private final PersonagemDAO dao = new PersonagemDAO();
    private Personagem Personagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_personagem);
        //Setando o titulo
        setTitle("Formulário de Personagens");

        //Metodo que possui a inicialização dos editTexts
        InicializacaoDeCampos();

        //aqui estamos pegando o botão para colocar um listener de ações nele, no caso, o click//
        Button botaoEnviar = findViewById(R.id.botaoEnviar);

        //Metodo do botão salvar
        configuraBotao(botaoEnviar);
    }

    private void configuraBotao(Button botaoEnviar) {
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

                personagemsalvo.setNome(nome);
                personagemsalvo.setAltura(altura);
                personagemsalvo.setNascimento(nascimento);
                dao.editar(personagemsalvo);

                Intent dados = getIntent();
                if(dados.hasExtra("personagem")){
                    Personagem personagem = (Personagem) dados.getSerializableExtra("personagem");
                    campoNome.setText(personagem.getNome());
                    campoAltura.setText(personagem.getAltura());
                    campoNascimento.setText(personagem.getNascimento());
                } else{ //Caso o usuario apenas deixe os campos em branco, isso ira acontecer
                    Personagem = new Personagem();
                }
            }
        });
    }

    private void InicializacaoDeCampos() {
        //setando os editText com determinados elementos do Hud//
        campoNome = findViewById(R.id.editTextName);
        campoAltura = findViewById(R.id.editTextAltura);
        campoNascimento = findViewById(R.id.editTextNascimento);
    }
}