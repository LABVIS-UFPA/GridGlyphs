/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.grid;

import doutorado.tese.util.coluna.Coluna;
import doutorado.tese.visualizacao.glyph.Glyph;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Anderson Soares
 */
public class ItemGrid {

    protected HashMap<Coluna, String> mapaDadosItem;
    private Glyph glyph;
    private boolean possuiGlyphResposta;
    private boolean selectedByUser;

    public ItemGrid() {
        mapaDadosItem = new HashMap<>();
    }

    /**
     * Verifica se pelo menos um dos filhos do glyph pai é um dos glyphs sorteados
     * @param pai
     * @return True se encontrar um filho sorteado, falso caso contrário.
     */
    public boolean hasGlyphResposta(Glyph pai) {
        Glyph filho = pai.getChild();
        if (!pai.getChildren().isEmpty()) {
            if (filho.isGlyphResposta()) {
                return true;
            } else {
                return hasGlyphResposta(filho);
            }
        } else {
            return false;
        }
    }

    /**
     * Metodo que retorna todos a composicao de um glyph, desde um glyph
     * concreto ate a ultima camada do glyph. Dessa forma, o metodo retorna, de
     * forma recursiva uma lista contendo todos os glyphs filhos (familia) de um
     * dado glyph.
     *
     * @param glyph objeto de pesquisa da familia
     * @param familia lista que ira armazenar a familia do obj pesquisado
     * @return lista contendo a familia do obj glyph pesquisado.
     */
    public List<Glyph> getGlyphFamily(Glyph glyph, List<Glyph> familia) {
        familia.add(glyph);
        boolean semFilhos = glyph.getChildren().isEmpty();
        if (!semFilhos) {
            return getGlyphFamily(glyph.getChild(), familia);
        } else {
            return familia;
        }
    }

    /**
     * @return retorna o valor do item folha.
     */
    public HashMap<Coluna, String> getMapaDadosItem() {
        return mapaDadosItem;
    }

    /**
     * @param mapaDadosItem the mapaDadosItem to set
     */
    public void setMapaDadosItem(HashMap<Coluna, String> mapaDadosItem) {
        this.mapaDadosItem = mapaDadosItem;
    }

    /**
     * @return the glyph
     */
    public Glyph getGlyph() {
        return glyph;
    }

    /**
     * @param glyph the glyph to set
     */
    public void setGlyph(Glyph glyph) {
        this.glyph = glyph;
    }

    /**
     * Metodo usado para indicar que o ItemGrid em questão possui um gliph com 
     * pelo menos um de seus filhos sendo a resposta correta (gabarito) da 
     * questão (pergunta) proposta.
     * @return the possuiGlyphResposta
     */
    public boolean isPossuiGlyphResposta() {
        return possuiGlyphResposta;
    }

    /**
     * 
     * @param possuiGlyphResposta the possuiGlyphResposta to set
     */
    public void setPossuiGlyphResposta(boolean possuiGlyphResposta) {
        this.possuiGlyphResposta = possuiGlyphResposta;
    }

    /**
     * @return the selectedByUser
     */
    public boolean isSelectedByUser() {
        return selectedByUser;
    }

    /**
     * @param selectedByUser the selectedByUser to set
     */
    public void setSelectedByUser(boolean selectedByUser) {
        this.selectedByUser = selectedByUser;
    }
}
