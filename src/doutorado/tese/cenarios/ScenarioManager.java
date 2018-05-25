/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.cenarios;

import doutorado.tese.visualizacao.glyph.Glyph;
import doutorado.tese.visualizacao.glyph.GlyphConcrete;
import doutorado.tese.visualizacao.grid.Grid;
import javax.swing.JPanel;

/**
 *
 * @author Anderson Soares
 */
public class ScenarioManager {
    
    private Grid gridPanel;

    public ScenarioManager() {
    }

    public ScenarioManager(Grid gridPanel) {
        this.gridPanel = gridPanel;
    }
    
    public Pergunta carregarCenario(String nomeCenario) {
        Pergunta p1 = null;
        switch (nomeCenario) {
            case "cenario1":
                Cenario cenario1 = new Cenario();
                p1 = new Pergunta("Qual glyph no grid é azul?");
                Resposta r1 = new Resposta(new GlyphConcrete());
                p1.setResposta(r1);
                gridPanel.setGlyphOverlappingModel(true);//definir glyph model
                //TODO definir tam grid
                    gridPanel.setQuantVert(5);
                    gridPanel.setQuantHoriz(10);
                //TODO definir porcentagem de Overlap - depende o Glyph Model
                    gridPanel.setQuantOlverlap(0.8f);
                //TODO criar itens
                    gridPanel.criarItens();
                //TODO definir variaveis visuais envolvidas
                    String [] variaveisVisuaisEscolhidas = {"Texture", "Color"};
                //TODO definir variaveis visuais
                    gridPanel.setVariaveisVisuaisEscolhidas(variaveisVisuaisEscolhidas);
                //TODO 
                    gridPanel.loadMatrizGlyphs();
                //TODO configurando glyphs
                    gridPanel.setCofig();
                    gridPanel.repaint();
                break;
            case "cenario2":

                break;
            case "cenario3":

                break;
            case "cenario4":

                break;
            default:
                throw new AssertionError();
        }
        return p1;
    }

    public static void main(String[] args) {
        Cenario cenario1 = new Cenario();
        Pergunta p1 = new Pergunta("Qual glyph abaixo é azul?");
        Resposta r1 = new Resposta(new GlyphConcrete());
        p1.setResposta(r1);

        System.out.println("Pergunta: " + p1.getQuestao());
        System.out.println("Resposta: " + p1.getResposta().getGlyphResposta());
    }
}
