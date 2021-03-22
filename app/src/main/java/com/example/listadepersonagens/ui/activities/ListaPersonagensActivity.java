package com.example.listadepersonagens.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.listadepersonagens.R;
import com.example.listadepersonagens.dao.PersonagemDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ListaPersonagensActivity extends AppCompatActivity{

     //Aula 11/03
    //criando um override para a lista de personagens
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_personagem);
        //Setando o titulo
        setTitle("Lista de Personagens");

        //referenciando o index de dao para poder utiliza-lo//
        PersonagemDAO dao = new PersonagemDAO();

        //pegando o floatingActionbutton//
        FloatingActionButton botaoNovoPersonagem = findViewById(R.id.iconeAdd);
        botaoNovoPersonagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListaPersonagensActivity.this, FormularioPersonagemActivity.class) );
            }
        });

        //lista de array
        //List<String> personagens = new ArrayList<>(Arrays.asList("Alex","Pedro","João","Dom Pedro II Imperador Delas"));

        ListView listaDePersonagens = findViewById(R.id.lista_personagens);
        //setando os personagens na lista(in app)
        listaDePersonagens.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dao.todos()));


        /*TextView primeiroPersonagem = findViewById(R.id.Perso1);
        TextView segundoPersonagem = findViewById(R.id.Perso2);
        TextView terceiroPersonagem = findViewById(R.id.Perso3);
        primeiroPersonagem.setText(personagens.get(0));
        segundoPersonagem.setText(personagens.get(2));
        terceiroPersonagem.setText(personagens.get(3));*/
    }

}
