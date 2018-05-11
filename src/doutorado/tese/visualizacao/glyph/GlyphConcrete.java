/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.glyph;

import java.awt.Rectangle;
import java.awt.Shape;
import java.util.HashMap;

/**
 *
 * @author Anderson Soares
 */
public class GlyphConcrete extends Glyph {

    private Rectangle bounds;
        
    @Override
    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
        if (this.glyphChild != null) {
            this.glyphChild.setBounds(new Rectangle(bounds));
        }
    }

    @Override
    public Rectangle getBounds() {
        return bounds;
    }

    @Override
    public Shape getClipShape() {
        return null;
    }


}
