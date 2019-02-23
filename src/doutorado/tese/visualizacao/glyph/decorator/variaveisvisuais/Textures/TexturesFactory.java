/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.Textures;

import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.shapes.*;

/**
 *
 * @author Gustavo
 */
public class TexturesFactory {

    public static final class FORMAS {

        public enum GLYPH_FORMAS {
            CIRCULO_10X10("CIRCULO_10X10"),
            CIRCULO_8X8("CIRCULO_8X8"),
            CIRCULO_5X5("CIRCULO_5X5"),
            CIRCULO_3X3("CIRCULO_3X3"),
            CIRCULO_4X4("CIRCULO_4X4");

            private final String nome;

            GLYPH_FORMAS(String nome) {
                this.nome = nome;
            }

            private String nome() {
                return nome;
            }
        }
    }

    private TexturesFactory() {
    }

    public static DrawBehavior create(FORMAS.GLYPH_FORMAS forma) {
        switch (forma) {
            case CIRCULO_10X10:
                return new CirculoTextura_10x10();
            case CIRCULO_8X8:
                return new CirculoTextura_8x8();
            case CIRCULO_5X5:
                return new CirculoTextura_5x5();
             case CIRCULO_3X3:
                return new CirculoTextura_3x3();
            case CIRCULO_4X4:
                return new CirculoTextura_4x4();
        
            default:
                return null;
        }
    }
}
