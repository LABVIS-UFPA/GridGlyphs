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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    private int numVisualizacoes = 6;
    private int[] vetorTamGridVertical = {10, 5, 5};
    private int[] vetorTamGridHorizontal = {16, 10, 10};
    private double[] vetorTamScala = {1.5, 1.25, 1};
    private float[] vetorQuantPercentOverlapping = {0.5f, 0.55f, 0.6f, 0.65f, 0.7f, 0f};//0%, 50%, 60%, 70%
    private int[] vetorQuantConjVarVisuais = {3, 4, 5};
    private String[] vetorVarVisuais = {"Texture", "Color", "Shape", "Saturation", "Orientation", "Letter", "Color2", "Overlap"};
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

    public void carregarCenariosTreinamento(String nomeCenario) {
        this.gridPanel.setScenarioManager(this);
        switch (nomeCenario) {
            case "0%":
                carregarTreinamentoOclusao(vetorQuantPercentOverlapping.length - 1);//{0.5f, 0.55f, 0.6f, 0.65f, 0.7f, 0f}
                break;
            case "50%":
                carregarTreinamentoOclusao(vetorQuantPercentOverlapping.length - 6);
                break;
            case "55%":
                carregarTreinamentoOclusao(vetorQuantPercentOverlapping.length - 5);
                break;
            case "60%":
                carregarTreinamentoOclusao(vetorQuantPercentOverlapping.length - 4);
                break;
            case "65%":
                carregarTreinamentoOclusao(vetorQuantPercentOverlapping.length - 3);
                break;
            case "70%":
                carregarTreinamentoOclusao(vetorQuantPercentOverlapping.length - 2);
                break;
            default:
                throw new AssertionError();
        }
    }

    private String[] shufflerVarVisuais() {
        String[] vetor = new String[vetorVarVisuais.length - 2];
        List<Integer> listaRejeitados = new ArrayList();
        int indiceSorteado = -1;
        for (int i = 0; i < vetor.length; i++) {
            do {
                indiceSorteado = (int) (Math.random() * vetor.length);
            } while (listaRejeitados.contains(indiceSorteado));
            listaRejeitados.add(indiceSorteado);
            vetor[i] = vetorVarVisuais[indiceSorteado];
        }
        return vetor;
    }

    private void carregarTreinamentoOclusao(int posicaoVetorPorcentagemOclusao) {
        boolean treinamento = true;
        gridPanel.setGlyphOverlappingModel(true);//definir glyph model
        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int posicaoVetorTamanho = 2;//posicao 2 do vetor indica grade pequena
                int posicaoVetorQuestoes = 0;
                int posicaoVetorQuantConjVarVisuais = 0;
                for (int i = 0; i < vetorVarVisuais.length - 2; i++) {
                    setConfigCenario(treinamento, posicaoVetorTamanho, posicaoVetorPorcentagemOclusao,
                            posicaoVetorQuestoes, posicaoVetorQuantConjVarVisuais,
                            new String[]{vetorVarVisuais[i], vetorVarVisuais[vetorVarVisuais.length - 1]});
                }
                JOptionPane.showMessageDialog(null, "Thanks for participate!", "Thanks!", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        });
        t1.start();
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
            case "0%":
                carregarCenarioOclusao(vetorQuantPercentOverlapping.length - 1);//{0.5f, 0.55f, 0.6f, 0.65f, 0.7f, 0f}
                break;
            case "50%":
                carregarCenarioOclusao(vetorQuantPercentOverlapping.length - 6);
                break;
            case "55%":
                carregarCenarioOclusao(vetorQuantPercentOverlapping.length - 5);
                break;
            case "60%":
                carregarCenarioOclusao(vetorQuantPercentOverlapping.length - 4);
                break;
            case "65%":
                carregarCenarioOclusao(vetorQuantPercentOverlapping.length - 3);
                break;
            case "70%":
                carregarCenarioOclusao(vetorQuantPercentOverlapping.length - 2);
                break;
            default:
                throw new AssertionError();
        }
    }

    private void setConfigCenario(boolean treinamento, int escala, int perctOverlapping, int questao, int quantValoresVar, String... varEscolhidas) {
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
        if (!treinamento) {
            preencherLinhaLog(quantValoresVar, varEscolhidas[0], perctOverlapping);
        }
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
                linhaLog[12] = Arrays.asList(gridPanel.getGlyphManager().getTexturas()).toString().replace(",", ";");
                break;
            case "Color":
                linhaLog[12] = Arrays.toString(gridPanel.getGlyphManager().getCores()).replace("java.awt.Color", "").replace(",", ";");
                break;
            case "Shape":
                linhaLog[12] = Arrays.toString(gridPanel.getGlyphManager().getFormaGeometricas()).replace(",", ";");
                break;
            case "Saturation":
                linhaLog[12] = Arrays.toString(gridPanel.getGlyphManager().getSaturacoes()).replace("java.awt.Color", "").replace(",", ";");
                break;
            case "Orientation":
                linhaLog[12] = Arrays.asList(gridPanel.getGlyphManager().getListNomeOrientacoesSorteada()).toString().replace(",", ";");
                break;
            case "Letter":
//                System.out.println(Arrays.asList(gridPanel.getGlyphManager().getLetras()));
                linhaLog[12] = Arrays.toString(gridPanel.getGlyphManager().getLetras()).replace(",", ";");
                break;
            default:
                System.err.println("Opcao de variavel visual incorreta!");
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
                                        setConfigCenario(false, t, p, questao, q, new String[]{vetorVarVisuais[i], vetorVarVisuais[vetorVarVisuais.length - 1]});
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

    private void carregarCenarioOclusao(int posicaoVetorPorcentagemOclusao) {
        gridPanel.setGlyphOverlappingModel(true);//definir glyph model
        String[] shufflerVarVisuais = shufflerVarVisuais();

        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int posicaoVetorTamanho = 2;
                for (int questao = 0; questao < vetorQuestoes.length; questao++) {
                    for (int i = 0; i < shufflerVarVisuais.length; i++) {
                        for (int q = 0; q < vetorQuantConjVarVisuais.length; q++) {
                            switch (shufflerVarVisuais[i]) {
                                case "Texture":

                                    break;
                                case "Color":

                                    break;
                                case "Shape":

                                    break;
                                case "Saturation":

                                    break;
                                case "Orientation":

                                    break;
                                case "Letter":

                                    break;
                                default:
                                    throw new AssertionError();
                            }

                            for (int j = 0; j < numVisualizacoes; j++) {
                                setConfigCenario(false, posicaoVetorTamanho, posicaoVetorPorcentagemOclusao, questao, q,
                                        new String[]{shufflerVarVisuais[i], vetorVarVisuais[vetorVarVisuais.length - 1]});
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
                                    setConfigCenario(false, t, p, tarefa, vetorQuantConjVarVisuais[q], new String[]{vetorVarVisuais[1], vetorVarVisuais[vetorVarVisuais.length - 2]});
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
        } else {
            linhaLog[9] = "" + 30 * 1000;
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
