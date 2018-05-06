/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.shapes;

import doutorado.tese.visualizacao.glyph.Glyph;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Anderson Soares
 */
public class FormaGeometrica extends Glyph {

    private Rectangle bounds;
    private GeometryFactory.FORMAS.GLYPH_FORMAS name;
    private Color cor;
    private DrawBehavior drawBehavior;

    public FormaGeometrica() {
        this.drawBehavior = new DrawBehavior() {
            @Override
            public void paint(Graphics g) {
                
            }

            @Override
            public int getArea() {
                return 0;
            }

            @Override
            public void setBounds(Rectangle bounds) {
                
            }
        };
    }    
    
    @Override
    public void paint(Graphics g) {
        drawBehavior.paint(g);
        super.paint(g);
    }

    public void setColor(Color cor) {
        this.cor = cor;
    }

    @Override
    public Rectangle getBounds() {
        return bounds;
    }

    @Override
    public void setBounds(Rectangle bounds) {
        super.setBounds(bounds);
        drawBehavior.setBounds(bounds);
    }

    
    public DrawBehavior getDrawBehavior() {
        return drawBehavior;
    }

    public void setDrawBehavior(DrawBehavior drawBehavior) {
        this.drawBehavior = drawBehavior;
    }

    public int getArea() {
        return 0;
    }
}
