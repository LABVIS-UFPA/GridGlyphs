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

    private static String[] corSaturation = {
//        "#EDC9E5",
//        "#D2A1C1",
//        "#C48EB2",
//        "#9D6D97",
//        "#7C4D79"
        "#EEC9E5",
        "#D6A6C6",
        "#BC86A9",
        "#986995",
        "#7C4D79"
    };


    private static String[] corGlyphs = {
        "#41BA2F",
        "#FFFF01",
        "#FF0101",
        "#2C2CFF",
        "#EBC089"
    };
    

    public final static String[] TIPO_ORIENTATION = {
        "180graus",
        "72graus",
        "135graus",
        "108graus",
        "45graus",
    };
    
        public final static String[] TIPO_TEXTURE = {
            "PATTERN_CIRCLE_1",
            "PATTERN_CIRCLE_2",
            "PATTERN_CIRCLE_3",
            "PATTERN_CIRCLE_4",
            "PATTERN_CIRCLE_5"      
    };
    

    public final static String[] LETRAS_ALFABETO = {
        "A", "C", "E", "K", "J"//, "F", "G", "H"
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

    public static int getAREA_CIRCULO_COLORIDO() {
        return AREA_CIRCULO_COLORIDO;
    }

    /**
     * Vetor de cores usado no segundo nivel de glyphs e na dimensao cores do
     * treemap
     *
     * @return
     */
    public static String[] getCorSaturation() {
        return corSaturation;
    }

    /**
     * @return the corGlyphs
     */
    public static String[] getCorGlyphs() {
        return corGlyphs;
    }

}
