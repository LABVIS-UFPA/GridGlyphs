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
    private int numVisualizacoes = 5;
    private int[] vetorTamGridVertical = {5, 5, 5};
    private int[] vetorTamGridHorizontal = {10, 10, 10};
    private double[] vetorTamScala = {1.5, 1.25, 1};
    private float[] vetorQuantPercentOverlapping = {0.65f, 0.8f, 0f};
    private String[] vetorVarVisuais = {"Texture", "Color", "Shape", "Letter", "Color2", "Overlap"};
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
        this.gridPanel.setScenarioManager(this);
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

    private void setConfigCenario(int escala, int perctOverlapping, int tarefa, String... varEscolhidas) {
        setPerguntaAtual(new Pergunta(vetorQuestoes[tarefa]));
        respostaCerta = new Resposta();

        gridPanel.setGridSize(vetorTamGridVertical[0], vetorTamGridHorizontal[0]);
        gridPanel.setQuantOlverlap(vetorQuantPercentOverlapping[perctOverlapping]);
        gridPanel.criarItens();
        gridPanel.setVariaveisVisuaisEscolhidas(varEscolhidas);
        gridPanel.loadMatrizGlyphs();

        respostaCerta.setListItens(gridPanel.setCofigItensGrid());

        gridPanel.shufflePosition();
        gridPanel.defineBoundsFromIndex(vetorTamScala[escala]);
        gridPanel.repaint();

        getPerguntaAtual().setRespostaCerta(respostaCerta);

        perguntaAtual_TextPanel.setText(getPerguntaAtual().getQuestao());
        inicioTempo = System.currentTimeMillis();
        showVisualVariablesValues();
        acionarControleThreds();
    }

    private void carregarCenario1() {
        Cenario cenario1 = new Cenario();
        gridPanel.setGlyphOverlappingModel(true);//definir glyph model
        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int t = 0; t < vetorTamScala.length; t++) {
                    for (int p = 0; p < vetorQuantPercentOverlapping.length; p++) {
                        for (int tarefa = 0; tarefa < vetorTipoTarefa.length; tarefa++) {
                            for (int i = 0; i < vetorVarVisuais.length - 2; i++) {
                                for (int j = 0; j < numVisualizacoes; j++) {
                                    setConfigCenario(t, p, tarefa, new String[]{vetorVarVisuais[i], vetorVarVisuais[vetorVarVisuais.length - 1]});
                                }
                            }
                        }
                    }
                }
                JOptionPane.showMessageDialog(null, "Thanks for participate!", "Thanks!", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        t1.start();
    }

    private void carregarCenario3() {//TODO refatprar esse metodo
        Cenario cenario2 = new Cenario();
        gridPanel.setGlyphOverlappingModel(true);//definir glyph model
        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int t = 0; t < vetorTamScala.length; t++) {
                    for (int p = 0; p < vetorQuantPercentOverlapping.length; p++) {
                        for (int tarefa = 0; tarefa < vetorTipoTarefa.length; tarefa++) {
                            for (int j = 0; j < numVisualizacoes; j++) {
                                setConfigCenario(t, p, tarefa, new String[]{vetorVarVisuais[1], vetorVarVisuais[vetorVarVisuais.length - 2]});
                            }
                        }
                    }
                }
                JOptionPane.showMessageDialog(null, "Thanks for participate!", "Thanks!", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        t1.start();
    }

    private void showVisualVariablesValues() {
        //TODO criar um classe que herde de JPanel para poder desenhar os valores das var visuais
//        painelValoresVarVisuais
    }

    /**
     * Metodo que varre os itensGrid procurando os que foram selecionados pelo
     * usuario. Um vez encontrado os glyphs selecionados pelo usuario, estes sao
     * adicionados em uma lista de glyphs representando as respostas dos
     * usuarios, e por fim essa lista é repassada para a pergunta atual. Desta
     * forma é possível comparar as respostas dos usuarios com as respostas
     * corretas.
     */
    public void nextStep() {
        fimTempo = System.currentTimeMillis();
        analisarRespostas();
        gridPanel.getGlyphManager().resetValoresSorteados();
        synchronized (t1) {
            threadTime.interrupt();
            t1.notify();
        }
    }

    public void analisarRespostas() {
        Resposta respostaUsuario = new Resposta();

        for (ItemGrid itemGrid : gridPanel.getItensGrid()) {
            if (itemGrid.isSelectedByUser()) {
                respostaUsuario.getListItens().add(itemGrid);
            }
        }
        getPerguntaAtual().setRespostaUsuario(respostaUsuario);
        if (getPerguntaAtual().getRespostaCerta().getListItens().size()
                == getPerguntaAtual().getRespostaUsuario().getListItens().size()) {
            for (ItemGrid itemGabarito : perguntaAtual.getRespostaCerta().getListItens()) {
                for (ItemGrid itemRespostaUsuario : perguntaAtual.getRespostaUsuario().getListItens()) {
                    if (itemGabarito == itemRespostaUsuario) {
                        //TODO escrever no LOG o tempo de resposta, se ele acertou, num de usuário, numero da tarefa, e a configuracao
                        System.out.println("resposta certa: \n" + itemGabarito + " == " + itemRespostaUsuario);
                    }
                }
            }
        }
    }

    private void acionarControleThreds() {
        try {
            synchronized (t1) {
                threadTime = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(20 * 1000);
                            JOptionPane.showMessageDialog(null, "Your time is over!", "Tic-tac, Tic-tac...!", JOptionPane.WARNING_MESSAGE);
                            nextStep();
                        } catch (InterruptedException ex) {
                        }
                    }
                });
                threadTime.start();
                t1.wait();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ScenarioManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
