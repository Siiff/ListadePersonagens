package com.example.listadepersonagens;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity{    

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<String> personagens = new ArrayList<>(Arrays.asList("Alex","Pedro","João","Dom Pedro II Imperador Delas"));

        ListView listaDePersonagens = findViewById(R.id.lista_personagens);
        listaDePersonagens.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, personagens));

        /*TextView primeiroPersonagem = findViewById(R.id.Perso1);
        TextView segundoPersonagem = findViewById(R.id.Perso2);
        TextView terceiroPersonagem = findViewById(R.id.Perso3);
        primeiroPersonagem.setText(personagens.get(0));
        segundoPersonagem.setText(personagens.get(2));
        terceiroPersonagem.setText(personagens.get(3));*/
    }

}
