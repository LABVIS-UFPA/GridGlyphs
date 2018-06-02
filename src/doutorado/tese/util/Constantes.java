/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.util;

import java.awt.Color;

/**
 *
 * @author Anderson
 */
public class Constantes {

    public final static String PROGRESS = "progress";
    public final static String VALUE_SAME_SIZE = "\t1";
    public final static int COR_TREEMAP = -1;
    private static boolean showGlyph = false;
    private static boolean showLegenda = false;
    private static boolean showStarGlyph = false;
    public static Color ALICE_BLUE = Color.decode("#F0F8FF");
    public static final int PRESENCA_TEXTURA = 0;
    public static final int PRESENCA_COR_FORMA = 1;
    public static final int PRESENCA_FORMA = 2;//SP -SHAPE PRESENCE
    public static final int PRESENCA_LETRA = 3;
    public static final int PRESENCA_NUMERO = 4;
    public static final int FEATURE_ALTURA = 5;
    public static final int FEATURE_LARGURA = 6;
    public static final int FEATURE_AREA = 7;//TIA - TOTAL ITEM AREA
    public static final int FEATURE_ASPECT = 8;
    public static final int PRESENCA_COR_TREEMAP = 9;//
    public static final int AREA_TEXTURA = 10;//TA - TEXTURE AREA
    public static final int AREA_CIRCULO_COLORIDO = 11;//CCA - Colored circle area
    public static final int AREA_SHAPE = 12;//SA - SHAPE AREA
    public static final int AREA_LETRA = 13;
    public static final int AREA_NUMERO = 14;//NA - NUMBER AREA
    public static final int PRESENTE = 1;
    public static final int AUSENTE = 0;

    private static String[] corOverlap = {
        "#B40000", "#3B70A2",
        "#2CB01C", "#D1D0CA",
        "#CDB5", "#70C2E8",
        "#FF95C9", "#62354C"
    };

//    private static String[] corGlyphs = {
//        "#FF0101", "#174580",
//        "#0A8300", "#8C8589",
//        "#F8D930", "#00A1D7",
//        "#FF3797", "#000000"
//    };
    
    private static String[] corGlyphs = {
        "#B40000", "#F8D930",
        "#174580", "#00A1D7",
        "#2CB01C", "#FF95C9",
        "#636066", "#000000"
    };

    public final static String[] TIPO_TEXTURA = {
        "PATTERN_DIAG_RIGHT_LEFT",
        "PATTERN_HORIZONTAL",
        "PATTERN_VERTICAL",
        "PATTERN_UP",
        "PATTERN_DIAG_LEFT_RIGHT",
        "PATTERN_RIGHT",
        "PATTERN_DIAG_CROSS_LINES",
        "PATTERN_CROSS_LINES"
    };

    public final static String[] LETRAS_ALFABETO = {
        "A", "B", "C", "D", "E", "F", "G", "H"
    };

    public final static String[] NUMEROS = {
        "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"
    };
    public static final int LIMITE_TESTES = 100;

    public enum NivelGlyph {
        NIVEL_1(1),
        NIVEL_2(2),
        NIVEL_3(3),
        NIVEL_4(4),
        NIVEL_5(5);

        private final int nivelGlyph;

        NivelGlyph(int nivelGlyph) {
            this.nivelGlyph = nivelGlyph;
        }

        private double nivel() {
            return nivelGlyph;
        }
    }

    public static boolean isShowGlyph() {
        return showGlyph;
    }

    public static void setShowGlyph(boolean aShowGlyph) {
        showGlyph = aShowGlyph;
    }

    public static boolean isShowLegenda() {
        return showLegenda;
    }

    public static void setShowLegenda(boolean aShowLegenda) {
        showLegenda = aShowLegenda;
    }

    public static boolean isShowStarGlyph() {
        return showStarGlyph;
    }

    public static void setShowStarGlyph(boolean aShowStarGlyph) {
        showStarGlyph = aShowStarGlyph;
    }

    /**
     * Vetor de cores usado no segundo nivel de glyphs e na dimensao cores do
     * treemap
     *
     * @return
     */
    public static String[] getCorOverlap() {
        return corOverlap;
    }

    /**
     * @return the corGlyphs
     */
    public static String[] getCorGlyphs() {
        return corGlyphs;
    }

}
