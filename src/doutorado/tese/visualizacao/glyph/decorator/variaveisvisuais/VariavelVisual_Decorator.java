/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais;

import doutorado.tese.visualizacao.glyph.Glyph;
import java.awt.Graphics;

/**
 *
 * @author Anderson Soares
 */
public abstract class VariavelVisual_Decorator extends Glyph{

    protected Glyph glyph;

    public VariavelVisual_Decorator(Glyph glyph) {
        this.glyph = glyph;
    }
    
    @Override
    public abstract void paint(Graphics g);
    
}
