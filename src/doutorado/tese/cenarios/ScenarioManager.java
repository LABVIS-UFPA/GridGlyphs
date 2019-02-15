/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.cenarios;

import doutorado.tese.legenda.Legenda;
import doutorado.tese.util.io.Escritor;
import doutorado.tese.visualizacao.grid.Grid;
import doutorado.tese.visualizacao.grid.ItemGrid;
import java.util.Arrays;
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
    private int numVisualizacoes = 1;
    private int[] vetorTamGridVertical = {10, 5, 5};
    private int[] vetorTamGridHorizontal = {16, 10, 10};
    private double[] vetorTamScala = {1.5, 1.25, 1};
    private float[] vetorQuantPercentOverlapping = {0.65f, 0.8f, 0f};
    private int[] vetorQuantConjVarVisuais = {3, 4, 5};
    private String[] vetorVarVisuais = {"Texture", "Color", "Shape", "Color2", "Overlap"};
    private String[] vetorTipoTarefa = {"Localização"};//, "Identificação"
    private String[] vetorQuestoes = {"Find the element below in the visualization:"};
//            , "Encontre o grupo de elementos abaixo na visualização:"};
    private JTextPane perguntaAtual_TextPanel;
    private Pergunta perguntaAtual;
    private Resposta respostaAtual;
    private Resposta respostaCerta;
    private long inicioTempo, fimTempo;
//    private JPanel painelValoresVarVisuais;
    private Thread t1;
    private Thread threadTime;
    private Legenda legendaPainel;
    private int taskTime;
    private String[] linhaLog;
    private StringBuilder bufferLog;

    public ScenarioManager() {
    }

    public ScenarioManager(Grid gridPanel, JTextPane painelPergunta) {
        this.taskTime = 30 * 1000;
        this.gridPanel = gridPanel;
        this.perguntaAtual_TextPanel = painelPergunta;
//        this.painelValoresVarVisuais = painelValoresVarVisuais;
        linhaLog = new String[13];
        bufferLog = new StringBuilder();
        bufferLog.append("ID_USER, ID_CONJ_VAR_VIS, ID_VAR_VIS, HAS_OVERLAP, ID_OVERLAP, ID_GRID, AREA_ITEM, TIPO_TAREFA, ACURACIA, TEMP_RES, RESPOSTA_CERTA, RESPOSTA_USER, CONJ_VAR_VIS");
        bufferLog.append("\n");
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

    private void setConfigCenario(int escala, int perctOverlapping, int questao, int quantValoresVar, String... varEscolhidas) {
        setPerguntaAtual(new Pergunta(vetorQuestoes[questao]));
        respostaCerta = new Resposta();

        gridPanel.setGridSize(vetorTamGridVertical[0], vetorTamGridHorizontal[0]);
        gridPanel.setQuantOlverlap(vetorQuantPercentOverlapping[perctOverlapping]);
        gridPanel.criarItens();
        gridPanel.setVariaveisVisuaisEscolhidas(varEscolhidas);
        gridPanel.loadMatrizGlyphs();
        gridPanel.setQuantValoresVarVisuais(vetorQuantConjVarVisuais[quantValoresVar]);

        respostaCerta.setListItens(gridPanel.setCofigItensGrid());

        gridPanel.shufflePosition();
        gridPanel.defineBoundsFromIndex(vetorTamScala[escala]);
        gridPanel.repaint();

        getPerguntaAtual().setRespostaCerta(respostaCerta);

        perguntaAtual_TextPanel.setText(getPerguntaAtual().getQuestao());

        inicioTempo = System.currentTimeMillis();
        preencherLinhaLog(quantValoresVar, varEscolhidas[0], perctOverlapping);
        showLegend();
        acionarControleThreads();
    }

    private void preencherLinhaLog(int quantValoresVar, String varEscolhida, int perctOverlapping) {
        float area = getPerguntaAtual().getRespostaCerta().getListItens().get(0).getGlyph().getBounds().width
                * getPerguntaAtual().getRespostaCerta().getListItens().get(0).getGlyph().getBounds().height;
        linhaLog[0] = System.getProperty("user.name");
        linhaLog[1] = vetorQuantConjVarVisuais[quantValoresVar] + "";
        linhaLog[2] = varEscolhida;
        linhaLog[3] = gridPanel.getGlyphOverlappingModel() + "";
        linhaLog[4] = vetorQuantPercentOverlapping[perctOverlapping] + "";
        linhaLog[5] = vetorTamGridVertical[0] + "x" + vetorTamGridHorizontal[0];
        linhaLog[6] = area + "";
        linhaLog[7] = vetorTipoTarefa[0];
        linhaLog[10] = getPerguntaAtual().getRespostaCerta().getListItens().get(0).getGlyph().getChild().getVarValue();
        switch (varEscolhida) {
            case "Texture":
                linhaLog[12] = Arrays.toString(gridPanel.getGlyphManager().getTexturas()).replace(",", ";");
                break;
            case "Color":
                linhaLog[12] = Arrays.toString(gridPanel.getGlyphManager().getCores()).replace("java.awt.Color", "").replace(",", ";");
                break;
            case "Shape":
                linhaLog[12] = Arrays.toString(gridPanel.getGlyphManager().getFormaGeometricas()).replace(",", ";");
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
                for (int t = 0; t < vetorTamScala.length; t++) {
                    for (int p = 0; p < vetorQuantPercentOverlapping.length; p++) {
                        for (int questao = 0; questao < vetorQuestoes.length; questao++) {
                            for (int i = 0; i < vetorVarVisuais.length - 2; i++) {
                                for (int q = 0; q < vetorQuantConjVarVisuais.length; q++) {
                                    for (int j = 0; j < numVisualizacoes; j++) {
                                        setConfigCenario(t, p, questao, q, new String[]{vetorVarVisuais[i], vetorVarVisuais[vetorVarVisuais.length - 1]});
                                    }
                                }
                            }
                        }
                    }
                }
                JOptionPane.showMessageDialog(null, "Thanks for participate!", "Thanks!", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
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
                            for (int q = 0; q < vetorQuantConjVarVisuais.length; q++) {
                                for (int j = 0; j < numVisualizacoes; j++) {
                                    setConfigCenario(t, p, tarefa, vetorQuantConjVarVisuais[q], new String[]{vetorVarVisuais[1], vetorVarVisuais[vetorVarVisuais.length - 2]});
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

    private void showLegend() {
        legendaPainel.setRespostaCerta(getPerguntaAtual().getRespostaCerta());
        legendaPainel.repaint();
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
        linhaLog[9] = (fimTempo - inicioTempo) + "";
        analisarRespostas();
        if (!getPerguntaAtual().getRespostaUsuario().getListItens().isEmpty()) {
            linhaLog[11] = getPerguntaAtual().getRespostaUsuario().getListItens().get(0).getGlyph().getChild().getVarValue();
        }else{
            linhaLog[11] = "null-TIME_OVER";
        }
        gridPanel.getGlyphManager().resetValoresSorteados();
        String linha = Arrays.toString(linhaLog).replace("[", "").replace("]", "");
        bufferLog.append(linha).append("\n");
        Escritor.escreverArquivo("log_GRID_Glyphs", bufferLog.toString());
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
                        linhaLog[8] = "true";
                    } else {
                        linhaLog[8] = "false";
                    }
                }
            }
        }
    }

    private void acionarControleThreads() {
        try {
            synchronized (t1) {
                threadTime = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(taskTime);
                            JOptionPane.showMessageDialog(null, "Your time is over!", "Tic-tac, Tic-tac...!", JOptionPane.WARNING_MESSAGE);
                            linhaLog[8] = "TIME_OVER";
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

    public Legenda getLegendaPainel() {
        return legendaPainel;
    }

    public void setLegendaPainel(Legenda legendaPainel) {
        this.legendaPainel = legendaPainel;
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
