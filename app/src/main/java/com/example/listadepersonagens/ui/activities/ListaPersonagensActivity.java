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


public class ListaPersonagensActivity extends AppCompatActivity{

    //referenciando o index de dao para poder utiliza-lo//
    private final PersonagemDAO dao = new PersonagemDAO();
     //Aula 11/03
    //criando um override para a lista de personagens
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_personagem);
        //Setando o titulo
        setTitle("Lista de Personagens");

        //Temporario
        dao.salvar(new Personagem("Dom Pedro II, Rei Delas", "1,90","030373"));
        dao.salvar(new Personagem("Dom Casmurro", "1,74","131273"));

        metodoBotãoNovoPersonagem();

    }

    private void metodoBotãoNovoPersonagem() {
        //pegando o floatingActionbutton//
        FloatingActionButton botaoNovoPersonagem = findViewById(R.id.iconeAdd);
        botaoNovoPersonagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListaPersonagensActivity.this, FormularioPersonagemActivity.class) );
            }
        });
    }

    //Fazendo uma proteção para os dados, assim eles não são apagados ao dar Back//
    @Override
    protected void onResume(){
        super.onResume();

        ListView listaDePersonagens = findViewById(R.id.lista_personagens);
        //referenciando o dao.todos() como personagens para poder acessar os dados
        List<Personagem> personagens = dao.todos();
        //Metodo Para Setar o personagem na lista
        personagemNaLista(listaDePersonagens, personagens);
    }

    private void personagemNaLista(ListView listaDePersonagens, List<Personagem> personagens) {
        //setando os personagens na lista(in app)
        listaDePersonagens.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, personagens));
        listaDePersonagens.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            //Metodo para seleção do personagem//
            @Override
            public void onItemClick (AdapterView<?> adapterView, View view, int posicao, long id){
                Personagem personagemEscolhido = personagens.get(posicao);
                Intent indoParaFormulario = new Intent (ListaPersonagensActivity.this, FormularioPersonagemActivity.class);
                indoParaFormulario.putExtra("personagem", personagemEscolhido);
                startActivity(indoParaFormulario);
            }
        });
    }
}
