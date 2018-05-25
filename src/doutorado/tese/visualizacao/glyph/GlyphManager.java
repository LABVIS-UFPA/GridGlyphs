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
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.shapes.Ellipse;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.shapes.GeometryFactory;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.shapes.Losango;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.shapes.Trapezio;
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
    private boolean overlappingActivated;

    public GlyphManager() {
        activeLayers = new HashMap<>();
        resetActiveLayers();
    }

    public Glyph setLayerInGlyph(String varVisual) {
        Glyph glyph = null;
        int random;
        Cor cor;

        switch (varVisual) {
            case "Color":
//                for (int j = 0; j < Constantes.getCorFormas().length - 1; j++) {
                    glyph = new Cor();
                    cor = (Cor) glyph;
                    random = 1 + (int) (Math.random() * Constantes.getCorFormas().length - 1);
                    cor.setCor(Color.decode(Constantes.getCorFormas()[random]));
                    cor.setPectSobreposicao(perctOverlap);
                    cor.setOverlappingActivated(overlappingActivated);
//                }
                break;
            case "Color2":
//                for (int j = 0; j < Constantes.getCorFormas2().length - 1; j++) {
                    glyph = new Cor();
                    cor = (Cor) glyph;
                    random = 1 + (int) (Math.random() * Constantes.getCorFormas2().length - 1);
                    cor.setCor(Color.decode(Constantes.getCorFormas2()[random]));
                    cor.setPectSobreposicao(perctOverlap);
//                }
                break;
            case "Letter":
//                for (int j = 0; j < Constantes.LETRAS_ALFABETO.length - 1; j++) {
                    random = 1 + (int) (Math.random() * Constantes.LETRAS_ALFABETO.length - 1);
                    glyph = new Letra();
                    letra = (Letra) glyph;
                    letra.setLetra(Constantes.LETRAS_ALFABETO[random]);
                    letra.setPectSobreposicao(perctOverlap);
                    letra.setOverlappingActivated(overlappingActivated);
//                }
                break;
            case "Shape":
                glyph = new FormaGeometrica();
//                for (int j = 0; j < GeometryFactory.FORMAS.GLYPH_FORMAS.values().length - 1; j++) {                    
                    random = 1 + (int) (Math.random() * GeometryFactory.FORMAS.GLYPH_FORMAS.values().length - 1);
                    FormaGeometrica forma = (FormaGeometrica) glyph;
                    forma.setDrawBehavior(GeometryFactory.create(GeometryFactory.FORMAS.GLYPH_FORMAS.values()[random]));
                    forma.setPectSobreposicao(perctOverlap);
                    forma.setOverlappingActivated(overlappingActivated);
//                }
                break;
            case "Texture":
//                for (int j = 0; j < Constantes.TIPO_TEXTURA.length - 1; j++) {
                    random = 1 + (int) (Math.random() * Constantes.TIPO_TEXTURA.length - 1);
                    glyph = new Textura(Color.gray, new Color(255, 0, 0, 0));
                    Textura textura = (Textura) glyph;
                    textura.setNomeTextura(Constantes.TIPO_TEXTURA[random].toString());
                    textura.setPectSobreposicao(perctOverlap);
//                }
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

    public void configGlyphDesingModel(boolean overlappingActivated) {
        this.overlappingActivated = overlappingActivated;
    }
}
