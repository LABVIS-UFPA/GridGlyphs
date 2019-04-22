/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.glyph;

import doutorado.tese.util.Constantes;
import doutorado.tese.visualizacao.glyph.decorator.overlap.Overlap;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.arrows.Arrow;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.arrows.ArrowFactory;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.textures.Textura;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.textures.TexturesFactory;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.color.Cor;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.letters.Letra;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.shapes.FormaGeometrica;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.shapes.GeometryFactory;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.orientation.Orientacao;
import doutorado.tese.visualizacao.grid.ItemGrid;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    private int orientacaoSorteada = -1;
    private int corSorteada = -1;
    private int corSaturadaSorteada = -1;
    private int formaSorteada = -1;
    private int letraSorteada = -1;
    private int texturaSorteada = -1;
    private int setaSorteada = -1;
    private int saturacaoSorteada = -1;
    private int quantValoresVarVisuais;
    private Color[] cores;
    private Color[] saturacoes;
    private Integer[] orientacoes;
    private String[] letras;
    private GeometryFactory.FORMAS.GLYPH_FORMAS[] formaGeometricas;
    private TexturesFactory.Textute.GLYPH_TEXTURAS[] texturas;
    private List<String> listNomeOrientacoesSorteada;
    private ArrowFactory.Arrow.GLYPH_ARROWS[] setas;

    public GlyphManager() {
        activeLayers = new HashMap<>();
        quantValoresVarVisuais = 5;
        resetActiveLayers();
    }

    public Glyph setLayerInGlyph(String varVisual) {
        Glyph glyph = null;

        switch (varVisual) {
            case "Color":
                glyph = defineRandomColor();
                break;
            case "Arrows":
                glyph = defineRandomArrows();
               
                break;
            case "Saturation":
                glyph = defineRandomColorSaturation();
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
            case "Orientation":
                glyph = defineRandomOrientation();//aqui era a antiga textura
                break;

            case "Overlap":
                glyph = new Overlap();
                Overlap overlap = (Overlap) glyph;
//                overlap.setCor(Color.WHITE);
//                overlap.setCor(Color.decode("#d3d3d3"));
//                overlap.setCor(Color.decode("#A9A9A9"));//darkgray
                overlap.setCor(Color.decode("#dddddd"));//darkgray
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
        if (item.hasGlyphResposta(father)) {
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
        orientacaoSorteada = -1;
        corSorteada = -1;
        formaSorteada = -1;
        letraSorteada = -1;
        corSaturadaSorteada = -1;
        texturaSorteada = -1;
        saturacaoSorteada = -1;
        cores = null;
        setSaturacoes(null);
        orientacoes = null;
        formaGeometricas = null;
        texturas = null;
        setLetras(null);
    }

    private Glyph defineRandomOrientation() {
        if (getOrientacoes() == null) {
            switch (quantValoresVarVisuais) {
                case 3:
                    orientacoes = new Integer[]{0, 3, 1};
                    break;
                case 4:
                    orientacoes = new Integer[]{0, 1, 3, 4};
                    break;
                case 5:
                    orientacoes = new Integer[]{0, 1, 2, 3, 4};
                    break;
                default:
                    definirConjuntoOrientation(quantValoresVarVisuais);
            }
        }
        int random = (int) (Math.random() * quantValoresVarVisuais);
        while (random == orientacaoSorteada) {
            random = (int) (Math.random() * quantValoresVarVisuais);
        }
//        Glyph glyph = new Orientacao(Color.BLACK, new Color(0, 0, 0, 0));
        Glyph glyph = new Orientacao(Color.BLACK, Color.WHITE);
        Orientacao orientacao = (Orientacao) glyph;
        if (orientacaoSorteada == -1) {
            orientacaoSorteada = random;
            orientacao.setGlyphResposta(true);
        }
        orientacao.setNomeOrientacao(Constantes.TIPO_ORIENTATION[orientacoes[random]]);
        orientacao.setPectSobreposicao(perctOverlap);
        orientacao.setOverlappingActivated(overlappingActivated);
        return glyph;
    }
    
    public void definirConjuntoOrientation(int quantValoresVarVisuais) {
        ArrayList<Integer> sorteados = new ArrayList<>();
        listNomeOrientacoesSorteada = new ArrayList<>();
        for (int i = 0; i < quantValoresVarVisuais; i++) {
            int random;
            do {
                random = (int) (Math.random() * Constantes.TIPO_ORIENTATION.length);
            } while (sorteados.contains(random));
            sorteados.add(random);
            getListNomeOrientacoesSorteada().add(Constantes.TIPO_ORIENTATION[random]);
        }
        orientacoes = sorteados.toArray(new Integer[]{});
    }

    private Glyph defineRandomArrows() {
        if (getArrows()== null) {
            switch (quantValoresVarVisuais) {
                case 3:
                    setas= new ArrowFactory.Arrow.GLYPH_ARROWS[]{ArrowFactory.Arrow.GLYPH_ARROWS.values()[0],
                                                                            ArrowFactory.Arrow.GLYPH_ARROWS.values()[2],
                                                                            ArrowFactory.Arrow.GLYPH_ARROWS.values()[4]};
                    break;
                case 4:
                    setas= new ArrowFactory.Arrow.GLYPH_ARROWS[]{ArrowFactory.Arrow.GLYPH_ARROWS.values()[0],
                                                                            ArrowFactory.Arrow.GLYPH_ARROWS.values()[2],
                                                                            ArrowFactory.Arrow.GLYPH_ARROWS.values()[3],
                                                                            ArrowFactory.Arrow.GLYPH_ARROWS.values()[4]};
                    break;
                case 5:
                    setas= new ArrowFactory.Arrow.GLYPH_ARROWS[]{ArrowFactory.Arrow.GLYPH_ARROWS.values()[0],
                                                                            ArrowFactory.Arrow.GLYPH_ARROWS.values()[1],
                                                                            ArrowFactory.Arrow.GLYPH_ARROWS.values()[2],
                                                                            ArrowFactory.Arrow.GLYPH_ARROWS.values()[3],
                                                                            ArrowFactory.Arrow.GLYPH_ARROWS.values()[4]};
                    break;
                default:
                    definirConjuntoSetas(quantValoresVarVisuais);
            }
        }
        int random = (int) (Math.random() * quantValoresVarVisuais);
        while (random == setaSorteada) {
            random = (int) (Math.random() * quantValoresVarVisuais);
        }
        Glyph glyph = new Arrow();
        Arrow arrow = (Arrow) glyph;
        if (setaSorteada == -1) {
            setaSorteada = random;
            arrow.setGlyphResposta(true);
        }
        if (getArrows().length != 0) {
            arrow.setDrawBehavior(ArrowFactory.create(getArrows()[random]));
        } else {
            quantValoresVarVisuais = 8;
            random = (int) (Math.random() * quantValoresVarVisuais);
            arrow.setDrawBehavior(ArrowFactory.create(ArrowFactory.Arrow.GLYPH_ARROWS.values()[random]));
        }
        arrow.setPectSobreposicao(perctOverlap);
        arrow.setOverlappingActivated(overlappingActivated);
        return glyph;
    }

    
    private Glyph defineRandomTexture() {
        if (getTexturas() == null) {
            switch (quantValoresVarVisuais) {
                case 3:
                    texturas = new TexturesFactory.Textute.GLYPH_TEXTURAS[]{TexturesFactory.Textute.GLYPH_TEXTURAS.values()[0],
                                                                            TexturesFactory.Textute.GLYPH_TEXTURAS.values()[2],
                                                                            TexturesFactory.Textute.GLYPH_TEXTURAS.values()[4]};
                    break;
                case 4:
                    texturas = new TexturesFactory.Textute.GLYPH_TEXTURAS[]{TexturesFactory.Textute.GLYPH_TEXTURAS.values()[0],
                                                                            TexturesFactory.Textute.GLYPH_TEXTURAS.values()[2],
                                                                            TexturesFactory.Textute.GLYPH_TEXTURAS.values()[3],
                                                                            TexturesFactory.Textute.GLYPH_TEXTURAS.values()[4]};
                    break;
                case 5:
                    texturas = new TexturesFactory.Textute.GLYPH_TEXTURAS[]{TexturesFactory.Textute.GLYPH_TEXTURAS.values()[0],
                                                                            TexturesFactory.Textute.GLYPH_TEXTURAS.values()[1],
                                                                            TexturesFactory.Textute.GLYPH_TEXTURAS.values()[2],
                                                                            TexturesFactory.Textute.GLYPH_TEXTURAS.values()[3],
                                                                            TexturesFactory.Textute.GLYPH_TEXTURAS.values()[4]};
                    break;
                default:
                    definirConjuntoTexturas(quantValoresVarVisuais);
            }
        }
        int random = (int) (Math.random() * quantValoresVarVisuais);
        while (random == texturaSorteada) {
            random = (int) (Math.random() * quantValoresVarVisuais);
        }
        Glyph glyph = new Textura();
        Textura textura = (Textura) glyph;
        if (texturaSorteada == -1) {
            texturaSorteada = random;
            textura.setGlyphResposta(true);
        }
        if (getTexturas().length != 0) {
            textura.setDrawBehavior(TexturesFactory.create(getTexturas()[random]));
        } else {
            quantValoresVarVisuais = 8;
            random = (int) (Math.random() * quantValoresVarVisuais);
            textura.setDrawBehavior(TexturesFactory.create(TexturesFactory.Textute.GLYPH_TEXTURAS.values()[random]));
        }
        textura.setPectSobreposicao(perctOverlap);
        textura.setOverlappingActivated(overlappingActivated);
        return glyph;
    }
    
    
    public void definirConjuntoSetas(int quantValoresVarVisuais) {
        ArrayList<ArrowFactory.Arrow.GLYPH_ARROWS> sorteados = new ArrayList<>();
        for (int i = 0; i < quantValoresVarVisuais; i++) {
            int random;
            do {
                random = (int) (Math.random() * ArrowFactory.Arrow.GLYPH_ARROWS.values().length);
            } while (sorteados.contains(ArrowFactory.Arrow.GLYPH_ARROWS.values()[random]));
            sorteados.add(ArrowFactory.Arrow.GLYPH_ARROWS.values()[random]);
        }
        setas = sorteados.toArray(new ArrowFactory.Arrow.GLYPH_ARROWS[]{});
    }

    public void definirConjuntoTexturas(int quantValoresVarVisuais) {
        ArrayList<TexturesFactory.Textute.GLYPH_TEXTURAS> sorteados = new ArrayList<>();
        for (int i = 0; i < quantValoresVarVisuais; i++) {
            int random;
            do {
                random = (int) (Math.random() * TexturesFactory.Textute.GLYPH_TEXTURAS.values().length);
            } while (sorteados.contains(TexturesFactory.Textute.GLYPH_TEXTURAS.values()[random]));
            sorteados.add(TexturesFactory.Textute.GLYPH_TEXTURAS.values()[random]);
        }
        texturas = sorteados.toArray(new TexturesFactory.Textute.GLYPH_TEXTURAS[]{});
    }

    private Glyph defineRandomColor() {
        if (getCores() == null) {
            switch (quantValoresVarVisuais) {
                case 3:
                    cores = new Color[]{Color.decode(Constantes.getCorGlyphs()[0]),
                                        Color.decode(Constantes.getCorGlyphs()[1]),
                                        Color.decode(Constantes.getCorGlyphs()[2])};
                    break;
                case 4:
                    cores = new Color[]{Color.decode(Constantes.getCorGlyphs()[0]),
                                        Color.decode(Constantes.getCorGlyphs()[1]),
                                        Color.decode(Constantes.getCorGlyphs()[2]),
                                        Color.decode(Constantes.getCorGlyphs()[3])};
                    break;
                case 5:
                    cores = new Color[]{Color.decode(Constantes.getCorGlyphs()[0]),
                                        Color.decode(Constantes.getCorGlyphs()[1]),
                                        Color.decode(Constantes.getCorGlyphs()[2]),
                                        Color.decode(Constantes.getCorGlyphs()[3]),
                                        Color.decode(Constantes.getCorGlyphs()[4])};
                    break;
                default:
                    definirConjuntoCores(quantValoresVarVisuais);
            }
        }
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

        cor.setCor(getCores()[random]);
        cor.setPectSobreposicao(perctOverlap);
        cor.setOverlappingActivated(overlappingActivated);
        return glyph;
    }

    private Glyph defineRandomColorSaturation() {
        if (getSaturacoes() == null) {
            switch (quantValoresVarVisuais) {
                case 3:
                    saturacoes = new Color[]{Color.decode(Constantes.getCorSaturation()[0]),
                                        Color.decode(Constantes.getCorSaturation()[2]),
                                        Color.decode(Constantes.getCorSaturation()[4])};
                    break;
                case 4:
                    saturacoes = new Color[]{Color.decode(Constantes.getCorSaturation()[0]),
                                        Color.decode(Constantes.getCorSaturation()[1]),
                                        Color.decode(Constantes.getCorSaturation()[2]),
                                        Color.decode(Constantes.getCorSaturation()[4])};
                    break;
                case 5:
                    saturacoes = new Color[]{Color.decode(Constantes.getCorSaturation()[0]),
                                        Color.decode(Constantes.getCorSaturation()[1]),
                                        Color.decode(Constantes.getCorSaturation()[2]),
                                        Color.decode(Constantes.getCorSaturation()[3]),
                                        Color.decode(Constantes.getCorSaturation()[4])};
                    break;
                default:
                    definirConjuntoCoresSaturacao(quantValoresVarVisuais);
            }
        }
        int random = (int) (Math.random() * quantValoresVarVisuais);
        while (random == corSaturadaSorteada) {
            random = (int) (Math.random() * quantValoresVarVisuais);
        }
        Glyph glyph = new Cor();
        Cor saturacaoCor = (Cor) glyph;
        if (corSaturadaSorteada == -1) {
            corSaturadaSorteada = random;
            saturacaoCor.setGlyphResposta(true);
        }
//        saturacaoCor.setCor(Color.decode(Constantes.getCorSaturation()[random]));
        saturacaoCor.setCor(getSaturacoes()[random]);
        saturacaoCor.setPectSobreposicao(perctOverlap);
        saturacaoCor.setOverlappingActivated(overlappingActivated);
        return glyph;
    }

    private Glyph defineRandomShape() {
        if (getFormaGeometricas() == null) {
            switch (quantValoresVarVisuais) {
                case 3:
                    formaGeometricas = new GeometryFactory.FORMAS.GLYPH_FORMAS[]{GeometryFactory.FORMAS.GLYPH_FORMAS.values()[0],
                                                                                 GeometryFactory.FORMAS.GLYPH_FORMAS.values()[1],
                                                                                 GeometryFactory.FORMAS.GLYPH_FORMAS.values()[2]};
                    break;
                case 4:
                    formaGeometricas = new GeometryFactory.FORMAS.GLYPH_FORMAS[]{GeometryFactory.FORMAS.GLYPH_FORMAS.values()[0],
                                                                                 GeometryFactory.FORMAS.GLYPH_FORMAS.values()[1],
                                                                                 GeometryFactory.FORMAS.GLYPH_FORMAS.values()[2],
                                                                                 GeometryFactory.FORMAS.GLYPH_FORMAS.values()[3]};
                    break;
                case 5:
                    formaGeometricas = new GeometryFactory.FORMAS.GLYPH_FORMAS[]{GeometryFactory.FORMAS.GLYPH_FORMAS.values()[0],
                                                                                 GeometryFactory.FORMAS.GLYPH_FORMAS.values()[1],
                                                                                 GeometryFactory.FORMAS.GLYPH_FORMAS.values()[2],
                                                                                 GeometryFactory.FORMAS.GLYPH_FORMAS.values()[3],
                                                                                 GeometryFactory.FORMAS.GLYPH_FORMAS.values()[4]};
                    break;
                default:
                    definirConjuntoFormas(quantValoresVarVisuais);
            }
        }
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
        if (getFormaGeometricas().length != 0) {
            forma.setDrawBehavior(GeometryFactory.create(getFormaGeometricas()[random]));
        } else {
            quantValoresVarVisuais = 8;
            random = (int) (Math.random() * quantValoresVarVisuais);
            forma.setDrawBehavior(GeometryFactory.create(GeometryFactory.FORMAS.GLYPH_FORMAS.values()[random]));
        }
        forma.setPectSobreposicao(perctOverlap);
        forma.setOverlappingActivated(overlappingActivated);
        forma.setColor(Color.BLACK);
        return glyph;
    }

    private Glyph defineRandomLetter() {
        if (getLetras() == null) {
            switch (quantValoresVarVisuais) {
                case 3:
                    letras = new String[]{Constantes.LETRAS_ALFABETO[0],
                                          Constantes.LETRAS_ALFABETO[1],
                                          Constantes.LETRAS_ALFABETO[2]};
                    break;
                case 4:
                    letras = new String[]{Constantes.LETRAS_ALFABETO[0],
                                          Constantes.LETRAS_ALFABETO[1],
                                          Constantes.LETRAS_ALFABETO[2],
                                          Constantes.LETRAS_ALFABETO[3]};
                    break;
                case 5:
                    letras = new String[]{Constantes.LETRAS_ALFABETO[0],
                                          Constantes.LETRAS_ALFABETO[1],
                                          Constantes.LETRAS_ALFABETO[2],
                                          Constantes.LETRAS_ALFABETO[3],
                                          Constantes.LETRAS_ALFABETO[4]};
                    break;
                default:
                    definirConjuntoLetras(quantValoresVarVisuais);
            }
        }
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

    public void definirConjuntoLetras(int quantValoresVarVisuais) {
        ArrayList<String> sorteados = new ArrayList<>();
        for (int i = 0; i < quantValoresVarVisuais; i++) {
            int random;
            do {
                random = (int) (Math.random() * Constantes.LETRAS_ALFABETO.length);
            } while (sorteados.contains(Constantes.LETRAS_ALFABETO[random]));
            sorteados.add(Constantes.LETRAS_ALFABETO[random]);
        }
        setLetras(sorteados.toArray(new String[]{}));
    }

    public void definirConjuntoFormas(int quantValoresVarVisuais) {
        ArrayList<GeometryFactory.FORMAS.GLYPH_FORMAS> sorteados = new ArrayList<>();
        for (int i = 0; i < quantValoresVarVisuais; i++) {
            int random;
            do {
                random = (int) (Math.random() * GeometryFactory.FORMAS.GLYPH_FORMAS.values().length);
            } while (sorteados.contains(GeometryFactory.FORMAS.GLYPH_FORMAS.values()[random]));
            sorteados.add(GeometryFactory.FORMAS.GLYPH_FORMAS.values()[random]);
        }
        formaGeometricas = sorteados.toArray(new GeometryFactory.FORMAS.GLYPH_FORMAS[]{});
    }

    public void setQuantValoresVarVisuais(int quantValoresVarVisuais) {
        this.quantValoresVarVisuais = quantValoresVarVisuais;
    }

    public void definirConjuntoCoresSaturacao(int quantValoresVarVisuais) {
        ArrayList<Color> sorteados = new ArrayList<>();

        for (int i = 0; i < quantValoresVarVisuais; i++) {
            int random;
            do {
                random = (int) (Math.random() * Constantes.getCorSaturation().length);
            } while (sorteados.contains(Color.decode(Constantes.getCorSaturation()[random])));
            sorteados.add(Color.decode(Constantes.getCorSaturation()[random]));
        }
        setSaturacoes(sorteados.toArray(new Color[]{}));
    }

    public void definirConjuntoCores(int quantValoresVarVisuais) {
        ArrayList<Color> sorteados = new ArrayList<>();

        for (int i = 0; i < quantValoresVarVisuais; i++) {
            int random;
            do {
                random = (int) (Math.random() * Constantes.getCorGlyphs().length);
            } while (sorteados.contains(Color.decode(Constantes.getCorGlyphs()[random])));
            sorteados.add(Color.decode(Constantes.getCorGlyphs()[random]));
        }
        setCores(sorteados.toArray(new Color[]{}));
    }

    /**
     * @return the cores
     */
    public Color[] getCores() {
        return cores;
    }

    /**
     * @param cores the cores to set
     */
    public void setCores(Color[] cores) {
        this.cores = cores;
    }

    /**
     * @return the texturas
     */
    public Integer[] getOrientacoes() {
        return orientacoes;
    }

    /**
     * @return the formaGeometricas
     */
    public GeometryFactory.FORMAS.GLYPH_FORMAS[] getFormaGeometricas() {
        return formaGeometricas;
    }

    public TexturesFactory.Textute.GLYPH_TEXTURAS[] getTexturas() {
        return texturas;
    }
    
    public ArrowFactory.Arrow.GLYPH_ARROWS[] getArrows() {
        return setas;
    }
    

    public String[] getLetras() {
        return letras;
    }

    public void setLetras(String[] letras) {
        this.letras = letras;
    }

    /**
     * @return the saturacoes
     */
    public Color[] getSaturacoes() {
        return saturacoes;
    }

    /**
     * @param saturacoes the saturacoes to set
     */
    public void setSaturacoes(Color[] saturacoes) {
        this.saturacoes = saturacoes;
    }

    /**
     * @return the listNomeOrientacoesSorteada
     */
    public List<String> getListNomeOrientacoesSorteada() {
        return listNomeOrientacoesSorteada;
    }

}
