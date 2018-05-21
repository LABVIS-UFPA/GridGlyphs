/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.cenarios;

import java.util.ArrayList;

/**
 *
 * @author Anderson Soares
 */
public class Cenario {

    private ArrayList<Pergunta> perguntas;

    public Cenario() {
        perguntas = new ArrayList<>();
    }

    public ArrayList<Pergunta> getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(ArrayList<Pergunta> perguntas) {
        this.perguntas = perguntas;
    }

    
}
