/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.glyph;

import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.color.Cor;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.letters.Letra;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.numbers.Numeral;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.shapes.FormaGeometrica;
import doutorado.tese.visualizacao.glyph.decorator.overlap.Overlap;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.shapes.Cruz;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.texture.Textura;
import doutorado.tese.visualizacao.grid.ItemGrid;
import java.awt.Color;
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
    private float perctOverlap;

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
                cor.setPectSobreposicao(perctOverlap);
                break;
            case "Letter":
                glyph = new Letra();
                letra = (Letra) glyph;
                letra.setLetra("H");
                letra.setPectSobreposicao(perctOverlap);
                break;
            case "Shape":
                glyph = new FormaGeometrica();
                FormaGeometrica forma = (FormaGeometrica) glyph;
                forma.setDrawBehavior(new Cruz());
//                forma.setDrawBehavior(new Ellipse());
//                forma.setDrawBehavior(new Trapezio());
                forma.setPectSobreposicao(perctOverlap);
//                System.out.println("criou forma");
                break;
            case "Texture":
                glyph = new Textura(Color.GRAY, new Color(255, 0, 0, 0));
                Textura textura = (Textura) glyph;
                textura.setNomeTextura("PATTERN_HORIZONTAL");
                textura.setPectSobreposicao(perctOverlap);
                break;
            case "Overlap":
                glyph = new Overlap();
                Overlap overlap = (Overlap) glyph;
                overlap.setCor(Color.WHITE);
                overlap.setPectSobreposicao(getPerctOverlap());
                break;
            default:
                throw new AssertionError();
        }

        return glyph;
    }

    public void configLayers(ItemGrid item) {
        Glyph father = item.getGlyph();
        father.killAllChild();
        for (String varVisual : getVariaveisVisuaisEscolhidas()) {
            Glyph child = setLayerInGlyph(varVisual);
            father.appendChild(child);
//            ArrayList<Glyph> list = new ArrayList<>();
//            father.getChildren(list);
//            if (father.child.getClass().getSimpleName().equals("Textura")) {
//                System.out.println("Cor Textura: "+((Textura) father.child).getCor());
//            }
        }
        father.setBounds(father.getBounds());
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
        activeLayers.put("Overlap", false);

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

    public float getPerctOverlap() {
        return perctOverlap;
    }

    public void setPerctOverlap(float perctOverlap) {
        this.perctOverlap = perctOverlap;
    }
}
