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

    
    //tons de amarelo
    private static String[] corSaturation = {  
        "#808080",
        "#9F8F60",
        "#BF9F40",
        "#DFAF20",
        "#FFC000"

    };
    
    private static String[] corGlyphs3 = {
        "#FF0101",//vermelho 0
        "#2C2CFF",//azul     1
        "#EBC089"//beje      2
    };

    private static String[] corGlyphs4 = {
        "#FF0101",//vermelho 0
        "#2C2CFF",//azul     1
        "#EBC089",//beje     2
        "#FFFF01"//amarelo   3
    };

    //luminosidade tons de roxo
    private static String[] corGlyphs5 = {
      "#000000",
      "#FF00FF",
      "#FFFFFF",
      "#7F007F",
      "#FF80FF"
              
    };
    
    public final static String[] TIPO_ORIENTATION = {
        "180graus",//0
        "45graus" ,//1
        "72graus" ,//2
        "108graus",//3
        "135graus" //4
    };
    
    public final static String[] LETRAS_ALFABETO = {
        "C", 
        "M", 
        "K", 
        "A", 
        "J"
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
     * @return the corGlyphs5
     */
    public static String[] getCorGlyphs() {
        return corGlyphs5;
    }

}
