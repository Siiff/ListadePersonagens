package com.example.listadepersonagens.model;

public class Personagem {
    //pegando as variaveis
    private final String nome;
    private final String altura;
    private final String nascimento;
    public Personagem(String nome, String altura, String nascimento) {
        //setando elas
        this.nome=nome;
        this.altura=altura;
        this.nascimento=nascimento;

    }
    //pegando as variaveis
    public String getNome() {return nome;}
    public String getAltura() {return altura;}
    public String getNascimento() {return nascimento;}
}
