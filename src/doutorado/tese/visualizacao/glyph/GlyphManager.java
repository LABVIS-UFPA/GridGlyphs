/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.glyph;

import doutorado.tese.util.Constantes;
import doutorado.tese.visualizacao.glyph.decorator.overlap.Overlap;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.color.Cor;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.letters.Letra;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.shapes.FormaGeometrica;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.shapes.GeometryFactory;
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
    private final HashMap<String, Boolean> activeLayers;
    private String[] variaveisVisuaisEscolhidas;
    private float perctOverlap;
    private boolean overlappingActivated;
    private int texturaSorteada = -1;
    private int corSorteada = -1;
    private int cor2Sorteada = -1;
    private int formaSorteada = -1;
    private int letraSorteada = -1;
    private int quantValoresVarVisuais;

    public GlyphManager() {
        activeLayers = new HashMap<>();
        resetActiveLayers();
    }

    public Glyph setLayerInGlyph(String varVisual) {
         Glyph glyph = null;

        switch (varVisual) {
            case "Color":
                glyph = defineRandomColor();
                break;
            case "Color2":
                glyph = defineRandomColorOvelerlap();
                break;
            case "Letter":
                glyph = defineRandomLetter();
                break;
            case "Shape":
                glyph = defineRandomShape();
                break;
            case "Texture":
                glyph = defineRandomTexture();
                break;
            case "Overlap":
                glyph = new Overlap();
                Overlap overlap = (Overlap) glyph;
                overlap.setCor(Color.WHITE);
                overlap.setPectSobreposicao(getPerctOverlap());
                overlap.setOverlappingActivated(overlappingActivated);
                break;
            default:
                throw new AssertionError();
        }

        return glyph;
    }

    /**
     * Recebe um ItemGrid, mata todos os seus filhos antigos, e adiciona seus
     * novos filhos de acordo com a hierarquia passada atraves da funcao
     * variaveisVisuaisEscolhidas(). Por fim, é definido o tamanho de cada item
     * do grid.
     *
     * @param item
     * @return item com as layers configuradas
     */
    public ItemGrid configLayers(ItemGrid item) {
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
//            System.out.println(list.toString());
        }
        father.setBounds(father.getBounds());
        if(item.hasGlyphResposta(father)){
            item.setPossuiGlyphResposta(true);
        }
        return item;
    }

    /**
     * Metodo que atualiza o mapa de layers ativas do glyph
     */
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

    public void resetValoresSorteados() {
        texturaSorteada = -1;
        corSorteada = -1;
        formaSorteada = -1;
        letraSorteada = -1;
        cor2Sorteada = -1;
    }

    private Glyph defineRandomTexture() {
        int random = (int) (Math.random() * quantValoresVarVisuais);
        while (random == texturaSorteada) {
            random = (int) (Math.random() * quantValoresVarVisuais);
        }
        Glyph glyph = new Textura(Color.gray, new Color(255, 0, 0, 0));
        Textura textura = (Textura) glyph;
        if (texturaSorteada == -1) {
            texturaSorteada = random;
            textura.setGlyphResposta(true);
        }
        textura.setNomeTextura(Constantes.TIPO_TEXTURA[random]);
        textura.setPectSobreposicao(perctOverlap);
        textura.setOverlappingActivated(overlappingActivated);
        return glyph;
    }

    private Glyph defineRandomColor() {
        int random = (int) (Math.random() * quantValoresVarVisuais);
        while (random == corSorteada) {
            random = (int) (Math.random() * quantValoresVarVisuais);
        }
        Glyph glyph = new Cor();
        Cor cor = (Cor) glyph;
        if (corSorteada == -1) {
            corSorteada = random;
            cor.setGlyphResposta(true);
        
        }
        cor.setCor(Color.decode(Constantes.getCorGlyphs()[random]));
        cor.setPectSobreposicao(perctOverlap);
        cor.setOverlappingActivated(overlappingActivated);
        return glyph;
    }
    
    private Glyph defineRandomColorOvelerlap() {
        int random = (int) (Math.random() * quantValoresVarVisuais);
        while (random == cor2Sorteada) {
            random = (int) (Math.random() * quantValoresVarVisuais);
        }
        Glyph glyph = new Cor();
        Cor cor = (Cor) glyph;
        if (cor2Sorteada == -1) {
            cor2Sorteada = random;
            cor.setGlyphResposta(true);
        }
        cor.setCor(Color.decode(Constantes.getCorOverlap()[random]));
        cor.setPectSobreposicao(perctOverlap);
        cor.setOverlappingActivated(overlappingActivated);
        return glyph;
    }

    private Glyph defineRandomShape() {
        int random = (int) (Math.random() * quantValoresVarVisuais);
        while (random == formaSorteada) {
            random = (int) (Math.random() * quantValoresVarVisuais);
        }
        Glyph glyph = new FormaGeometrica();
        FormaGeometrica forma = (FormaGeometrica) glyph;
        if (formaSorteada == -1) {
            formaSorteada = random;
            forma.setGlyphResposta(true);
        }
        forma.setDrawBehavior(GeometryFactory.create(GeometryFactory.FORMAS.GLYPH_FORMAS.values()[random]));
        forma.setPectSobreposicao(perctOverlap);
        forma.setOverlappingActivated(overlappingActivated);
        return glyph;
    }

    private Glyph defineRandomLetter() {
        int random = (int) (Math.random() * quantValoresVarVisuais);
        while (random == letraSorteada) {
            random = (int) (Math.random() * quantValoresVarVisuais);
        }
        Glyph glyph = new Letra();
        letra = (Letra) glyph;
        if (letraSorteada == -1) {
            letraSorteada = random;
            letra.setGlyphResposta(true);
        }        
        letra.setLetra(Constantes.LETRAS_ALFABETO[random]);
        letra.setPectSobreposicao(perctOverlap);
        letra.setOverlappingActivated(overlappingActivated);
        return glyph;
    }

    public void setQuantValoresVarVisuais(int quantValoresVarVisuais) {
        this.quantValoresVarVisuais = quantValoresVarVisuais;
    }
}
