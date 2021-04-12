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

import static com.example.listadepersonagens.ui.activities.ConstantesActivities.CHAVE_PERSONAGEM;

public class FormularioPersonagemActivity extends AppCompatActivity {

    //Constantes
    public static final String TITULO_APPBAR_NOVO_PERSONAGEM = "Formulário de Personagens";
    public static final String TITULO_APPBAR_EDITA_PERSONAGEM = "Editar Personagem";
    //Pegando os ID's dos campos para toda classe//
    private EditText campoNome;
    private EditText campoAltura;
    private EditText campoNascimento;
    //criando um banco de data do personagem
    private final PersonagemDAO dao = new PersonagemDAO();
    private Personagem personagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_personagem);
        InicializacaoDeCampos(); //Metodo que possui a inicialização dos editTexts
        configuraBotaoSalvar(); //Metodo do botão salvar
        carregaPersonagem(); //Metodo Do Intent do personagem
    }

    private void configuraBotaoSalvar() {
        Button botaoSalvar = findViewById(R.id.botaoEnviar); //aqui estamos pegando o botão para colocar um listener de ações nele, no caso, o click//
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finalizarFormulario();
            }
        });
    }
    private void finalizarFormulario() {
        preencherPersonagem();
        if(personagem.IDValido()){
            dao.editar(personagem);
            finish();
        } else {
            dao.salvar(personagem);
        }
        finish();
    }
    private void carregaPersonagem() {
        Intent dados = getIntent();
        if(dados.hasExtra(CHAVE_PERSONAGEM)){
            setTitle(TITULO_APPBAR_EDITA_PERSONAGEM); //Setando o titulo
            personagem = (Personagem) dados.getSerializableExtra(CHAVE_PERSONAGEM);
            preencheCampos();
        } else{ //Caso o usuario apenas deixe os campos em branco, isso ira acontecer
            setTitle(TITULO_APPBAR_NOVO_PERSONAGEM); //Setando o titulo
            personagem = new Personagem();
        }
    }
    private void preencheCampos() {
        campoNome.setText(personagem.getNome());
        campoAltura.setText(personagem.getAltura());
        campoNascimento.setText(personagem.getNascimento());
    }
    private void InicializacaoDeCampos() {
        //setando os editText com determinados elementos do Hud//
        campoNome = findViewById(R.id.editTextName);
        campoAltura = findViewById(R.id.editTextAltura);
        campoNascimento = findViewById(R.id.editTextNascimento);
    }
    private void preencherPersonagem(){
        //Convertendo o texto dos campos em strings//
        String nome = campoNome.getText().toString();
        String altura = campoAltura.getText().toString();
        String nascimento = campoNascimento.getText().toString();

        //buscando para modificar informações
        personagem.setNome(nome);
        personagem.setAltura(altura);
        personagem.setNascimento(nascimento);
    }

}