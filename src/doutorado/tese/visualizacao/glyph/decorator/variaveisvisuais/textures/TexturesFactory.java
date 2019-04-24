/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.textures;

/**
 *
 * @author Gustavo
 */
public class TexturesFactory {

    public static final class Textute {

        public enum GLYPH_TEXTURAS {
            CIRCULO_10X10("CIRCULO_10X10"),//0
            CIRCULO_8X8("CIRCULO_8X8"),    //1
            CIRCULO_6X6("CIRCULO_6X6"),    //2
            CIRCULO_4X4("CIRCULO_4X4"),    //3
            CIRCULO_2X2("CIRCULO_2X2");    //4

            private final String nome;

            GLYPH_TEXTURAS(String nome) {
                this.nome = nome;
            }

            private String nome() {
                return nome;
            }
        }
    }

    private TexturesFactory() {
    }

    public static DrawBehavior create(Textute.GLYPH_TEXTURAS forma) {
        switch (forma) {
            case CIRCULO_10X10:
                return new CirculoTextura_10x10();
            case CIRCULO_8X8:
                return new CirculoTextura_8x8();
            case CIRCULO_6X6:
                return new CirculoTextura_6x6();
             case CIRCULO_4X4:
                return new CirculoTextura_4x4();
            case CIRCULO_2X2:
                return new CirculoTextura_2x2();
        
            default:
                return null;
        }
    }
}
