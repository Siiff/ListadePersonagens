package com.example.listadepersonagens.model;

public class Personagem {
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
    @Override
    public String toString(){return nome;
    }
}
