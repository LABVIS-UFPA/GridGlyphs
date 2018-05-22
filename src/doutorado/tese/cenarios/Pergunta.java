/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.cenarios;

/**
 *
 * @author Anderson Soares
 */
public class Pergunta {

    private Resposta resposta;
    private String questao;

    public Pergunta(String questao) {
        this.questao = questao;
    }

    public Resposta getResposta() {
        return resposta;
    }

    public void setResposta(Resposta resposta) {
        this.resposta = resposta;
    }

    /**
     * @return the questao
     */
    public String getQuestao() {
        return questao;
    }

    /**
     * @param questao the questao to set
     */
    public void setQuestao(String questao) {
        this.questao = questao;
    }

}
