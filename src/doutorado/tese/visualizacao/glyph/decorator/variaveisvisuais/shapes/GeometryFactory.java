/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.shapes;

/**
 *
 * @author Gustavo
 */
public class GeometryFactory {

    public static final class FORMAS {

        public enum GLYPH_FORMAS {
            RETANGULO("RETANGULO"), //0
            CIRCULO("CIRCULO"),     //1
            LOSANGO("LOSANGO"),     //2
            ESTRELA("ESTRELA"),     //3
            CRUZ("CRUZ");           //4
//            ELLIPSE("ELLIPSE"),
//            HEXAGONO("HEXAGONO"),
//            PENTAGONO("PENTAGONO"),
//            TRAPEZIO("TRAPEZIO"),

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

    public static DrawBehavior create(FORMAS.GLYPH_FORMAS forma) {
        switch (forma) {
            case RETANGULO:
                return new Retangulo();
             case ESTRELA:
                return new Estrela();
            case CRUZ:
                return new Cruz();
            case CIRCULO:
                return new Circulo();
            case LOSANGO:
                return new Losango();
//            case ELLIPSE:
//                return new Ellipse();
//            case HEXAGONO:
//                return new Hexagono();
//            case PENTAGONO:
//                return new Pentagono();
//            case TRAPEZIO:
//                return new Trapezio();
        
            default:
                return null;
        }
    }
}
