package com.example.listadepersonagens.dao;

import com.example.listadepersonagens.model.Personagem;

import java.util.ArrayList;
import java.util.List;

public class PersonagemDAO {

    private final static List<Personagem> personagens = new ArrayList<>();
    //Numerando os personagens//
    private static int contadorDeId = 1;

    public void salvar (Personagem personagemSalvo){
        personagemSalvo.setId(contadorDeId);
        personagens.add(personagemSalvo);
        contadorDeId++;
    }

    //Pedaço do código voltado a edição do personagem//
    public void editar(Personagem personagem){
        Personagem personagemEscolhido = null;
        for (Personagem p: personagens){
            if (p.getId() == personagem.getId()) {
                personagemEscolhido = p;
            }
        }
        if(personagemEscolhido != null){
            int posicaoDoPersonagem = personagens.indexOf(personagemEscolhido);
            personagens.set(posicaoDoPersonagem, personagem);
        }
    }

    public List<Personagem> todos(){
        return new ArrayList<>(personagens);
    }

}
