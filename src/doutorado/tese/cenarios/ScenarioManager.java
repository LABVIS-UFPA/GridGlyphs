/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.cenarios;

import doutorado.tese.visualizacao.glyph.GlyphConcrete;
import doutorado.tese.visualizacao.grid.Grid;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextPane;

/**
 *
 * @author Anderson Soares
 */
public class ScenarioManager {

    private Grid gridPanel;
    private int numVisualizacoes = 10;
    private int[] vetorTamGridVertical = {5, 10, 10};
    private int[] vetorTamGridHorizontal = {10, 27, 30};
    private float[] vetorQuantPercentOverlapping = {0.8f, 0.7f, 0.6f};
    private String[] vetorVarVisuais = {"Texture", "Color", "Shape", "Letter", "Overlap"};
    private String[] vetorTipoTarefa = {"Identificação", "Localização"};
    private String[] vetorQuestoes = {"Encontre o elemento abaixo na visualização:",
        "Encontre o grupo de elementos abaixo na visualização:"};
    private JTextPane perguntaAtual;

    private Thread t1;

    public ScenarioManager() {
    }

    public ScenarioManager(Grid gridPanel, JTextPane painelPergunta) {
        this.gridPanel = gridPanel;
        this.perguntaAtual = painelPergunta;
    }

    public void carregarCenarios(String nomeCenario) {
        switch (nomeCenario) {
            case "cenario1":
                carregarCenario1();
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
    }

    private void carregarCenario1() {
        Cenario cenario1 = new Cenario();
        gridPanel.setGlyphOverlappingModel(true);//definir glyph model
        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int t = 0; t < vetorTamGridHorizontal.length; t++) {
                    gridPanel.setGridSize(vetorTamGridVertical[t], vetorTamGridHorizontal[t]);
                    System.out.print("Tam GRID: " + vetorTamGridVertical[t] + " x " + vetorTamGridHorizontal[t]);
                    for (int p = 0; p < vetorQuantPercentOverlapping.length; p++) {
                        gridPanel.setQuantOlverlap(vetorQuantPercentOverlapping[p]);
                        System.out.println("\tPerct Overlapping: " + vetorQuantPercentOverlapping[p]);
                        for (int tarefa = 0; tarefa < vetorTipoTarefa.length; tarefa++) {
                            for (int i = 0; i < vetorVarVisuais.length - 1; i++) {
                                for (int j = 0; j < numVisualizacoes; j++) {
                                    gridPanel.setVariaveisVisuaisEscolhidas(new String[]{vetorVarVisuais[i], vetorVarVisuais[vetorVarVisuais.length - 1]});
                                    gridPanel.criarItens();
                                    gridPanel.loadMatrizGlyphs();
                                    gridPanel.setCofigItensGrid();
                                    gridPanel.repaint();

                                    Pergunta pergunta = new Pergunta(vetorQuestoes[tarefa]);
                                    Resposta r1 = new Resposta(new GlyphConcrete());
                                    pergunta.setResposta(r1);
                                    perguntaAtual.setText(pergunta.getQuestao());
                                    System.out.println("\t" + j + " - Var: " + vetorVarVisuais[i]);
                                    try {
                                        synchronized (t1) {
                                            t1.wait();
                                        }
                                    } catch (InterruptedException ex) {
                                        Logger.getLogger(ScenarioManager.class.getName()).log(Level.SEVERE, null, ex);
                                    }}}}}}}
        });
        t1.start();
    }

    public void nextStep() {
        synchronized (t1) {
            t1.notify();
            //varrer itensGrid e procurar os que estao selecionados
        }
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
