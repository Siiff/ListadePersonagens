package com.example.listadepersonagens.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.listadepersonagens.R;
import com.example.listadepersonagens.dao.PersonagemDAO;
import com.example.listadepersonagens.model.Personagem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import static com.example.listadepersonagens.ui.activities.ConstantesActivities.CHAVE_PERSONAGEM;


public class ListaPersonagensActivity extends AppCompatActivity{
    //Constantes
    public static final String TITULO_APPBAR = "Lista de Personagens";
    //referenciando o index de dao para poder utiliza-lo//
    private final PersonagemDAO dao = new PersonagemDAO();
    //criando um override para a lista de personagens
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_personagem);
        setTitle(TITULO_APPBAR); //Setando o titulo
        configuraFabNovoPersonagem(); //Met Novo personagem
    }

    private void configuraFabNovoPersonagem() {
        //pegando o floatingActionbutton//
        FloatingActionButton botaoNovoPersonagem = findViewById(R.id.iconeAdd);
        botaoNovoPersonagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abreFormulario();
            }
        });
    }
    private void abreFormulario() {
        startActivity(new Intent(ListaPersonagensActivity.this, FormularioPersonagemActivity.class) );
    }

    //Fazendo uma proteção para os dados, assim eles não são apagados ao dar Back//
    @Override
    protected void onResume(){
        super.onResume();

        ListView listaDePersonagens = findViewById(R.id.lista_personagens);
        final List<Personagem> personagens = dao.todos(); //referenciando o dao.todos() como personagens para poder acessar os dados
        listaDePersonagens(listaDePersonagens, personagens); //Metodo Para Setar o personagem na lista
        configuraItemPorClick(listaDePersonagens);
    }

    private void configuraItemPorClick(ListView listaDePersonagens) {
        //setando os personagens na lista(in app)
        listaDePersonagens.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            //Metodo para seleção do personagem//
            @Override
            public void onItemClick (AdapterView<?> adapterView, View view, int posicao, long id){
                Personagem personagemEscolhido = (Personagem) adapterView.getItemAtPosition(posicao);
                abreFormularioEditar(personagemEscolhido);
            }
        });
    }
    private void abreFormularioEditar(Personagem personagemEscolhido) {
        Intent vaiParaOFormulario = new Intent (ListaPersonagensActivity.this,  FormularioPersonagemActivity.class);
        vaiParaOFormulario.putExtra(CHAVE_PERSONAGEM, personagemEscolhido);
        startActivity(vaiParaOFormulario);
    }
    private void listaDePersonagens(ListView listaDePersonagens, List<Personagem> personagens) {
        listaDePersonagens.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, personagens));
    }
}
