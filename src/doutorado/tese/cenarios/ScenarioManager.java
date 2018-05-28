/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.cenarios;

import doutorado.tese.visualizacao.glyph.Glyph;
import doutorado.tese.visualizacao.glyph.GlyphConcrete;
import doutorado.tese.visualizacao.grid.Grid;
import doutorado.tese.visualizacao.grid.ItemGrid;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
    private String[] vetorVarVisuais = {"Texture", "Color", "Shape", "Letter", "Color2","Overlap"};
    //private String[] vetorVarVisuais2 = {"Color","Overlap","Color2"};
    private String[] vetorTipoTarefa = {"Identificação", "Localização"};
    private String[] vetorQuestoes = {"Encontre o elemento abaixo na visualização:",
        "Encontre o grupo de elementos abaixo na visualização:"};
    private JTextPane perguntaAtual_TextPanel;
    private Pergunta perguntaAtual;
    private Resposta respostaAtual;
    private long inicioTempo, fimTempo;
    private Resposta respostaCerta;

    private Thread t1;

    public ScenarioManager() {
    }

    public ScenarioManager(Grid gridPanel, JTextPane painelPergunta) {
        this.gridPanel = gridPanel;
        this.perguntaAtual_TextPanel = painelPergunta;
    }

    public void carregarCenarios(String nomeCenario) {
        switch (nomeCenario) {
            case "cenario1":
                carregarCenario1();
                break;
            case "cenario2":
                System.out.println("cenario 2 selecionado");
                break;
            case "cenario3":
            carregarCenario3();                
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
//                    System.out.print("Tam GRID: " + vetorTamGridVertical[t] + " x " + vetorTamGridHorizontal[t]);
                    for (int p = 0; p < vetorQuantPercentOverlapping.length; p++) {
                        gridPanel.setQuantOlverlap(vetorQuantPercentOverlapping[p]);
//                        System.out.print("\tPerct Overlapping: " + vetorQuantPercentOverlapping[p]);
                        for (int tarefa = 0; tarefa < vetorTipoTarefa.length; tarefa++) {
                            for (int i = 0; i < vetorVarVisuais.length - 2; i++) {
                                for (int j = 0; j < numVisualizacoes; j++) {
                                    respostaCerta = new Resposta();
                                    
                                    gridPanel.setVariaveisVisuaisEscolhidas(new String[]{vetorVarVisuais[i], vetorVarVisuais[vetorVarVisuais.length - 1]});
                                    gridPanel.criarItens();
                                    gridPanel.loadMatrizGlyphs();
//                                    System.out.println("\t" + j + " - Var: " + vetorVarVisuais[i]);
                                    respostaCerta.setItensResposta(gridPanel.setCofigItensGrid());
//                                    ArrayList<ItemGrid> setCofigItensGrid = gridPanel.setCofigItensGrid();
                                    gridPanel.shufflePosition();
                                    gridPanel.defineBoundsFromIndex();
                                    gridPanel.repaint();
                                    
                                    setPerguntaAtual(new Pergunta(vetorQuestoes[tarefa]));
                                    getPerguntaAtual().setRespostaCerta(respostaCerta);
                                                                        
                                    perguntaAtual_TextPanel.setText(getPerguntaAtual().getQuestao());
//                                    inicioTempo = ((System.currentTimeMillis() / (1000*60)) % 60);
                                    inicioTempo = System.currentTimeMillis();
                                    System.out.println("Tempo inicio: "+inicioTempo);
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
    
      private void carregarCenario3() {
        Cenario cenario1 = new Cenario();
        gridPanel.setGlyphOverlappingModel(true);//definir glyph model
        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int t = 0; t < vetorTamGridHorizontal.length; t++) {
                    gridPanel.setGridSize(vetorTamGridVertical[t], vetorTamGridHorizontal[t]);
//                    System.out.print("Tam GRID: " + vetorTamGridVertical[t] + " x " + vetorTamGridHorizontal[t]);
                    for (int p = 0; p < vetorQuantPercentOverlapping.length; p++) {
                        gridPanel.setQuantOlverlap(vetorQuantPercentOverlapping[p]);
//                        System.out.print("\tPerct Overlapping: " + vetorQuantPercentOverlapping[p]);
                        for (int tarefa = 0; tarefa < vetorTipoTarefa.length; tarefa++) {
                                for (int j = 0; j < numVisualizacoes; j++) {
                                    respostaCerta = new Resposta();
                                    gridPanel.setVariaveisVisuaisEscolhidas(new String[]{vetorVarVisuais[1], vetorVarVisuais[vetorVarVisuais.length - 2]});
                                    gridPanel.criarItens();
                                    gridPanel.loadMatrizGlyphs();  
                                    
                                    respostaCerta.setItensResposta(gridPanel.setCofigItensGrid());
//                                    gridPanel.setCofigItensGrid();
                                    gridPanel.shufflePosition();
                                    gridPanel.defineBoundsFromIndex();
                                    gridPanel.repaint();
                                    
                                    setPerguntaAtual(new Pergunta(vetorQuestoes[tarefa]));
                                    getPerguntaAtual().setRespostaCerta(respostaCerta);
                                                                        
                                    perguntaAtual_TextPanel.setText(getPerguntaAtual().getQuestao());
//                                    inicioTempo = ((System.currentTimeMillis() / (1000*60)) % 60);
                                    inicioTempo = System.currentTimeMillis();
                                    System.out.println("Tempo inicio: "+inicioTempo);
                                    try {
                                        synchronized (t1) {
                                            t1.wait();
                                        }
                                    } catch (InterruptedException ex) {
                                        Logger.getLogger(ScenarioManager.class.getName()).log(Level.SEVERE, null, ex);
                                    }}}}}}
        });
        t1.start();
        
    }

    /**
     * Metodo que varre os itensGrid procurando os que foram selecionados pelo usuario.
     * Um vez encontrado os glyphs selecionados pelo usuario, estes sao adicionados em uma lista
     * de glyphs representando as respostas dos usuarios, e por fim essa lista é repassada para a 
     * pergunta atual. Desta forma é possível comparar as respostas dos usuarios com as respostas
     * corretas.
     */
    public void nextStep() {
        Resposta respostaUsuario = new Resposta();
        
        for (ItemGrid itemGrid : gridPanel.getItensGrid()) {
            if(itemGrid.isPossuiGlyphResposta()){
                respostaUsuario.getItensResposta().add(itemGrid);
            }
        }        
        getPerguntaAtual().setRespostaUsuario(respostaUsuario);
        //TODO comparar a resposta do usuario com a resposta certa
        for (ItemGrid itemGabarito : perguntaAtual.getRespostaCerta().getItensResposta()) {
            for (ItemGrid itemRespostaUsuario : perguntaAtual.getRespostaUsuario().getItensResposta()) {
                if(itemGabarito == itemRespostaUsuario){
                    System.out.println("resposta certa: \n"+itemGabarito +" == "+ itemRespostaUsuario);
                }
            }
        }
        gridPanel.getGlyphManager().resetValoresSorteados();
        synchronized (t1) {
            t1.notify();
        }
    }
    
//    public static void main(String[] args) {
//        Cenario cenario1 = new Cenario();
//        Pergunta p1 = new Pergunta("Qual glyph abaixo é azul?");
//        Resposta r1 = new Resposta(new GlyphConcrete());
//        p1.setResposta(r1);
//
//        System.out.println("Pergunta: " + p1.getQuestao());
//        System.out.println("Resposta: " + p1.getResposta().getGlyphResposta());
//    }

    /**
     * @return the perguntaAtual
     */
    public Pergunta getPerguntaAtual() {
        return perguntaAtual;
    }

    /**
     * @param perguntaAtual the perguntaAtual to set
     */
    public void setPerguntaAtual(Pergunta perguntaAtual) {
        this.perguntaAtual = perguntaAtual;
    }

    /**
     * @return the respostaAtual
     */
    public Resposta getRespostaAtual() {
        return respostaAtual;
    }

    /**
     * @param respostaAtual the respostaAtual to set
     */
    public void setRespostaAtual(Resposta respostaAtual) {
        this.respostaAtual = respostaAtual;
    }

}
