/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.arrows;

import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.textures.*;


public class ArrowFactory {

    public static final class Arrow {

        public static class Textute {

            public Textute() {
            }
        }

        public enum GLYPH_ARROWS {
            ARROW180("ARROW180"),    //4
            ARROW135("ARROW135"),//135
            ARROW90("ARROW90"),//90
            ARROW45("ARROW45"),//45
            ARROW0("ARROW0");//0

            private final String nome;

            GLYPH_ARROWS(String nome) {
                this.nome = nome;
            }

            private String nome() {
                return nome;
                
                
            }
        }
    }

    private ArrowFactory() {
    }

    public static DrawBehavior create(Arrow.GLYPH_ARROWS forma) {
        switch (forma) {
            case ARROW0:
                return new Arrow0();
            case ARROW45:
                return new Arrow45();
            case ARROW90:
                return new Arrow90();
             case ARROW135:
                return new Arrow135();
            case ARROW180:
                return new Arrow180();
        
            default:
                return null;
        }
    }
}
