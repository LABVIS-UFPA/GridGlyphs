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
import javax.swing.JPanel;
import javax.swing.JTextPane;

/**
 *
 * @author Anderson Soares
 */
public class ScenarioManager {

    private Grid gridPanel;
    private int numVisualizacoes = 10;
    private int[] vetorTamGridVertical = {5, 6, 10};
    private int[] vetorTamGridHorizontal = {10, 18, 10};
    private float[] vetorQuantPercentOverlapping = {0.65f, 0.8f, 0f};
    private String[] vetorVarVisuais = {"Texture", "Color", "Shape", "Letter", "Color2","Overlap"};
    private String[] vetorTipoTarefa = {"Identificação"};//, "Localização"
    private String[] vetorQuestoes = {"Find the unique element in the visualization:"};
//            , "Encontre o grupo de elementos abaixo na visualização:"};
    private JTextPane perguntaAtual_TextPanel;
    private Pergunta perguntaAtual;
    private Resposta respostaAtual;
    private Resposta respostaCerta;
    private long inicioTempo, fimTempo;
    private JPanel painelValoresVarVisuais;
    private Thread t1;
    private Thread threadTime;

    public ScenarioManager() {
    }

    public ScenarioManager(Grid gridPanel, JTextPane painelPergunta, JPanel painelValoresVarVisuais) {
        this.gridPanel = gridPanel;
        this.perguntaAtual_TextPanel = painelPergunta;
        this.painelValoresVarVisuais = painelValoresVarVisuais;
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
                                    setPerguntaAtual(new Pergunta(vetorQuestoes[tarefa]));
                                    respostaCerta = new Resposta();
                                    
                                    gridPanel.criarItens();
                                    gridPanel.setVariaveisVisuaisEscolhidas(new String[]{vetorVarVisuais[i], vetorVarVisuais[vetorVarVisuais.length - 1]});
                                    gridPanel.loadMatrizGlyphs();
                                    
                                    respostaCerta.setListItens(gridPanel.setCofigItensGrid());
                                    
                                    gridPanel.shufflePosition();
                                    gridPanel.defineBoundsFromIndex();
                                    gridPanel.repaint();
                                    
                                    getPerguntaAtual().setRespostaCerta(respostaCerta);
                                                                        
                                    perguntaAtual_TextPanel.setText(getPerguntaAtual().getQuestao());
//                                    inicioTempo = ((System.currentTimeMillis() / (1000*60)) % 60);
                                    inicioTempo = System.currentTimeMillis();
                                    System.out.println("Tempo inicio: "+inicioTempo);
                                    showVisualVariablesValues();
                                    try {
                                        synchronized (t1) {
                                            threadTime = new Thread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    try {
                                                        Thread.sleep(5*1000);
                                                    } catch (InterruptedException ex) {
                                                        Logger.getLogger(ScenarioManager.class.getName()).log(Level.SEVERE, null, ex);
                                                    }
                                                    JOptionPane.showMessageDialog(null, "Your time is over!");
                                                }});
                                            threadTime.start();
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
                                    setPerguntaAtual(new Pergunta(vetorQuestoes[tarefa]));
                                    respostaCerta = new Resposta();
                                    gridPanel.criarItens();
                                    gridPanel.setVariaveisVisuaisEscolhidas(new String[]{vetorVarVisuais[1], vetorVarVisuais[vetorVarVisuais.length - 2]});
                                    gridPanel.loadMatrizGlyphs();  
                                    
                                    respostaCerta.setListItens(gridPanel.setCofigItensGrid());
                                    
                                    gridPanel.shufflePosition();
                                    gridPanel.defineBoundsFromIndex();
                                    gridPanel.repaint();
                                    
                                    getPerguntaAtual().setRespostaCerta(respostaCerta);
                                                                        
                                    perguntaAtual_TextPanel.setText(getPerguntaAtual().getQuestao());
//                                    inicioTempo = ((System.currentTimeMillis() / (1000*60)) % 60);
                                    inicioTempo = System.nanoTime();
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

    private void showVisualVariablesValues() {
        //TODO criar um classe que herde de JPanel para poder desenhar os valores das var visuais
//        painelValoresVarVisuais
    }
    
    /**
     * Metodo que varre os itensGrid procurando os que foram selecionados pelo usuario.
     * Um vez encontrado os glyphs selecionados pelo usuario, estes sao adicionados em uma lista
     * de glyphs representando as respostas dos usuarios, e por fim essa lista é repassada para a 
     * pergunta atual. Desta forma é possível comparar as respostas dos usuarios com as respostas
     * corretas.
     */
    public void nextStep() {
        fimTempo = System.nanoTime();
        System.out.println("Fim tempo: "+fimTempo);
        analisarRespostas();
        gridPanel.getGlyphManager().resetValoresSorteados();
        synchronized (t1) {
//            threadTime.s
            t1.notify();
        }
    }
    
    public void analisarRespostas(){
        Resposta respostaUsuario = new Resposta();
        
        for (ItemGrid itemGrid : gridPanel.getItensGrid()) {
            if(itemGrid.isSelectedByUser()){
                respostaUsuario.getListItens().add(itemGrid);
            }
        }       
        getPerguntaAtual().setRespostaUsuario(respostaUsuario);
        if(getPerguntaAtual().getRespostaCerta().getListItens().size() ==
                getPerguntaAtual().getRespostaUsuario().getListItens().size()){
            for (ItemGrid itemGabarito : perguntaAtual.getRespostaCerta().getListItens()) {
                for (ItemGrid itemRespostaUsuario : perguntaAtual.getRespostaUsuario().getListItens()) {
                    if(itemGabarito == itemRespostaUsuario){
                        //TODO escrever no LOG o tempo de resposta, se ele acertou, num de usuário, numero da tarefa, e a configuracao
                        System.out.println("resposta certa: \n"+itemGabarito +" == "+ itemRespostaUsuario);
                    }
                }
            }
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
