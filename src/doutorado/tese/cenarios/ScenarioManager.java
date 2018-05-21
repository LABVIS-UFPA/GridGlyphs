/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.cenarios;

import doutorado.tese.visualizacao.glyph.Glyph;
import doutorado.tese.visualizacao.glyph.GlyphConcrete;

/**
 *
 * @author Anderson Soares
 */
public class ScenarioManager { 

    public void definirCenario() {
        Cenario cenario1 = new Cenario();

    }

    public static void main(String[] args) {
        Cenario cenario1 = new Cenario();
        Pergunta p1 = new Pergunta("Qual glyph abaixo é azul?");
        Resposta r1 = new Resposta(new GlyphConcrete());
        p1.setResposta(r1);
        
        System.out.println("Pergunta: "+p1.getQuestao());
        System.out.println("Resposta: "+p1.getResposta().getGlyphResposta());
    }
}
