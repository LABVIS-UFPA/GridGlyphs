/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.glyph;

import java.awt.Color;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author Anderson
 */
@Deprecated
public class Constantes_ {

    public final static String PROGRESS = "progress";
    public final static String VALUE_SAME_SIZE = "\t1";
    private static boolean showGlyph = false;
    private static boolean showLegenda = false;
    private static boolean showStarGlyph = false;
    public static Color ALICE_BLUE = Color.decode("#F0F8FF");

    
//    private static Color[] cores = {Color.BLUE, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.YELLOW};
    private static String[] cor = {
        "#4169E1","#B22222","#ff9900","#109618","#990099","#0099c6","#dd4477",
        "#66aa00","#b82e2e","#316395","#994499","#22aa99","#9F7050","#6633cc",
        "#e67300","#8b0707","#651067","#329262","#5574a6", "#3b3eac","#F0F8FF"
    };

    private static String[] corGlyphs = {
        "#1f77b4","#ff7f0e","#2ca02c","#d62728",
        "#9467bd","#8c564b","#e377c2","#7f7f7f",
        "#bcbd22","#17becf","#c6dbef","#a1d99b"
    };
    
    private static String[] corFormas = {
        "#FF0101","#174580",
        "#0A8300","#8C8589",
        "#F8D930","#00A1D7",
        "#FF3797","#000000"
    };
    
     private static String[] corFormas2 = {
         "#B40000","#3B70A2",
         "#2CB01C","#D1D0CA",
         "#CDB5","#70C2E8",
         "FF95C9","#62354C"
        
    };
     
    private static String[] corFormas3 = {
        "#00FEFE","#F8D930","#E8BA7F","#FF5E28",
        "#F57CFF","#F57CFF","#00C868","#FFFFFF"
    };
    
    private static String[] corFormas4 = {
        "#00FEFE","#F8D930","#E8BA7F","#FF5E28",
        "#F57CFF","#F57CFF","#00C868","#FFFFFF"
    };
    

    public final static String[] TIPO_TEXTURA = {
        "PATTERN_HORIZONTAL",
        "PATTERN_VERTICAL",
        "PATTERN_DIAG_RIGHT_LEFT",
        "PATTERN_DIAG_LEFT_RIGHT",
        "PATTERN_CROSS_LINES",
        "PATTERN_DIAG_CROSS_LINES",
        "PATTERN_RIGHT",
        "PATTERN_UP"
    };
    /**
     * 0 - "OCTOGONO", 1 - "ELLIPSE", 2 - "CRUZ", 3 - "LOSANGO", 4 -
     * "PENTAGONO", 5 - "TRAPEZIO", 6 - "HEXAGONO", 7 - "RETANGULO", 8 -
     * "CIRCULO"
     */
    public final static String[] TIPOS_FORMAS_GEOMETRICAS = {
      "ARCO","ELLIPSE", "CRUZ", "LOSANGO", "PENTAGONO", "TRAPEZIO", "HEXAGONO", "RETANGULO", "CIRCULO"

    };

    public final static String[] LETRAS_ALFABETO = {
        "A", "B", "C", "D", "E", "F", "G", "H"
    };

    public final static String[] NUMEROS = {
        "1", "2", "3", "4", "5", "6", "7", "8" 
    };
    
//     public final static String[] ANGLE = {
//        "1","2","3","4","5","6","7","8"
//    };   
//    public final static String[] visivel = {
//        "0","1"
//    };
//    
    public static final int LIMITE_TESTES = 100;

    public enum NivelGlyph {
        NIVEL_1(1),
        NIVEL_2(2),
        NIVEL_3(3),
        NIVEL_4(4),
        NIVEL_5(5),
        NIVEL_6(6),
        NIVEL_7(7);

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
    public static String[] getCor() {
        return cor;
    }

    /**
     * @return the corGlyphs
     */
    public static String[] getCorGlyphs() {
        return corGlyphs;
    }

    public static String[] getCorFormas() {
        return corFormas;
    }

    public static String[] getCorFormas2() {
        return corFormas2;
    }

    
    
    

}
