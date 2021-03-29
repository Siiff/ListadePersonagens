package com.example.listadepersonagens.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Personagem implements Serializable {
    //pegando as variaveis//
    private final String nome;
    private final String altura;
    private final String nascimento;

    public Personagem(String nome, String altura, String nascimento) {
        //setando elas
        this.nome=nome;
        this.altura=altura;
        this.nascimento=nascimento;

    }

    //pegando as variaveis//
    //Desabilitado pois n estamos mais usando o toast//
    /*public String getNome() {return nome;}
    public String getAltura() {return altura;}
    public String getNascimento() {return nascimento;}*/

    //covertendo o nome para um string para exibição//
    @NonNull
    @Override
    public String toString(){return nome;
    }
}
