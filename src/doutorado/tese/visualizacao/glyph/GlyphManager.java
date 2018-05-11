/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.glyph;

import doutorado.tese.util.io.ManipuladorArquivo;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.color.Cor;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.letters.Letra;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.numbers.Numeral;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.shapes.FormaGeometrica;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.shapes.Trapezio;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.texture.Textura;
import doutorado.tese.visualizacao.grid.ItemGrid;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Anderson Soares
 */
public class GlyphManager {

    private Letra letra;
    private Numeral numero;
    private final HashMap<String, Boolean> activeLayers;
    private String[] variaveisVisuaisEscolhidas;

    public GlyphManager() {
        activeLayers = new HashMap<>();
        resetActiveLayers();
    }

    public Glyph setLayerInGlyph(String varVisual) {
        Glyph glyph = null;

        switch (varVisual) {
            case "Color":
                glyph = new Cor();
                Cor cor = (Cor) glyph;
                cor.setCor(Color.decode("#3366cc"));
                break;
            case "Letter":
                glyph = new Letra();
                letra = (Letra) glyph;
                if (activeLayers.get("Number")) {
                    letra.setLetra("I");
                } else {
                    letra.setLetra("I");
                }
                break;
            case "Number":
                glyph = new Numeral();
                numero = (Numeral) glyph;
                if (activeLayers.get("Letter")) {
                    numero.setNumero("3");
                } else {
                    numero.setNumero("3");
                }
                break;
            case "Shape":
                glyph = new FormaGeometrica();
                FormaGeometrica forma = (FormaGeometrica) glyph;
//                forma.setDrawBehavior(new Cruz());
//                forma.setDrawBehavior(new Ellipse());
                forma.setDrawBehavior(new Trapezio());
//                System.out.println("criou forma");
                break;
            case "Texture":
                glyph = new Textura(Color.GRAY, new Color(255, 0, 0, 0));
                Textura textura = (Textura) glyph;                
                textura.setNomeTextura("PATTERN_HORIZONTAL");
                break;
            default:
                throw new AssertionError();
        }

        return glyph;
    }

    public void configLayers(ItemGrid item) {
        Glyph glyph = item.getGlyph();
        glyph.killAllChild();
        for (String varVisual : getVariaveisVisuaisEscolhidas()) {
            glyph.appendChild(setLayerInGlyph(varVisual));
            ArrayList<Glyph> list = new ArrayList<>();
            glyph.getChildren(list);
        }
        glyph.setBounds(glyph.getBounds());
    }

    public void analyseLayers() {        
        resetActiveLayers();
        for (String i : getVariaveisVisuaisEscolhidas()) {
            activeLayers.put(i, true);
        }
    }

    private void resetActiveLayers() {
        activeLayers.put("Number", false);
        activeLayers.put("Letter", false);
        activeLayers.put("Shape", false);
        activeLayers.put("Color", false);
        activeLayers.put("Texture", false);
    }

    /**
     * @return the variaveisVisuaisEscolhidas
     */
    public String[] getVariaveisVisuaisEscolhidas() {
        return variaveisVisuaisEscolhidas;
    }

    /**
     * @param variaveisVisuaisEscolhidas the variaveisVisuaisEscolhidas to set
     */
    public void setVariaveisVisuaisEscolhidas(String[] variaveisVisuaisEscolhidas) {
        this.variaveisVisuaisEscolhidas = variaveisVisuaisEscolhidas;
    }
}
