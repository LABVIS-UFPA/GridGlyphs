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

    private Resposta respostaCerta;
    private Resposta respostaUsuario;
    private String questao;

    public Pergunta(String questao) {
        this.questao = questao;
    }

    public Resposta getRespostaCerta() {
        return respostaCerta;
    }

    public void setRespostaCerta(Resposta respostaCerta) {
        this.respostaCerta = respostaCerta;
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

    /**
     * @return the respostaUsuario
     */
    public Resposta getRespostaUsuario() {
        return respostaUsuario;
    }

    /**
     * @param respostaUsuario the respostaUsuario to set
     */
    public void setRespostaUsuario(Resposta respostaUsuario) {
        this.respostaUsuario = respostaUsuario;
    }

}
