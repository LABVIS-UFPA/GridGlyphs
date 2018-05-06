/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.shapes;

import doutorado.tese.visualizacao.glyph.Glyph;
import java.awt.Rectangle;

/**
 *
 * @author Gustavo
 */
public class GeometryFactory {

    public static final class FORMAS {

        public enum GLYPH_FORMAS {
            CRUZ("CRUZ"),
            ELLIPSE("ELLIPSE"),
            HEXAGONO("HEXAGONO"),
            LOSANGO("LOSANGO"),
            PENTAGONO("PENTAGONO"),
            TRAPEZIO("TRAPEZIO"),
            RETANGULO("RETANGULO"),
            CIRCULO("CIRCULO");

            private final String nome;

            GLYPH_FORMAS(String nome) {
                this.nome = nome;
            }

            private String nome() {
                return nome;
            }
        }
    }

    private GeometryFactory() {
    }

    public static DrawBehavior create(Glyph absGlyph, Rectangle bounds, FORMAS.GLYPH_FORMAS forma) {
        switch (forma) {
            case RETANGULO:
                return new Retangulo(bounds);
            case CRUZ:
                return new Cruz();
            case ELLIPSE:
                return new Ellipse(bounds);
            case CIRCULO:
                return new Circulo(bounds);
            case HEXAGONO:
                return new Hexagono(bounds);
            case LOSANGO:
                return new Losango(bounds);
            case PENTAGONO:
                return new Pentagono(bounds);
            case TRAPEZIO:
                return new Trapezio(bounds);
            default:
                return null;
        }
    }
}
