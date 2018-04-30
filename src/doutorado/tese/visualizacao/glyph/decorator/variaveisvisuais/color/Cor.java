/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.color;

import doutorado.tese.visualizacao.glyph.Glyph;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.VariavelVisual_Decorator;
import java.awt.Graphics;

/**
 *
 * @author Anderson Soares
 */
public class Cor extends VariavelVisual_Decorator{
    
    public Cor(Glyph absGlyph) {
        super(absGlyph);
    }

    @Override
    public void paint(Graphics g) {
        drawCor(g);
        glyph.paint(g);
    }
    
    private void drawCor(Graphics g){
        System.out.println("Desenhando cor.");
    }
    
}
