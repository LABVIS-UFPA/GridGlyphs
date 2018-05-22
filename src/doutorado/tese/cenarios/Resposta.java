/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.cenarios;

import doutorado.tese.visualizacao.glyph.Glyph;
import java.util.ArrayList;

/**
 *
 * @author Anderson Soares
 */
public class Resposta {

    private ArrayList<Glyph> glyphsResposta;
    private Glyph glyphResposta;

    public Resposta(Glyph glyphResposta) {
        this.glyphResposta = glyphResposta;
    }

    public Resposta(ArrayList<Glyph> glyphsResposta) {
        this.glyphsResposta = glyphsResposta;
    }

    /**
     * @return the glyphsResposta
     */
    public ArrayList<Glyph> getGlyphsResposta() {
        return glyphsResposta;
    }

    /**
     * @param glyphsResposta the glyphsResposta to set
     */
    public void setGlyphsResposta(ArrayList<Glyph> glyphsResposta) {
        this.glyphsResposta = glyphsResposta;
    }

    /**
     * @return the glyphResposta
     */
    public Glyph getGlyphResposta() {
        return glyphResposta;
    }

    /**
     * @param glyphResposta the glyphResposta to set
     */
    public void setGlyphResposta(Glyph glyphResposta) {
        this.glyphResposta = glyphResposta;
    }
    
    
}
