/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.shapes;

import doutorado.tese.visualizacao.glyph.Glyph;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.VariavelVisual_Decorator;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Anderson Soares
 */
public class FormaGeometrica extends VariavelVisual_Decorator {

    private Rectangle bounds;
    private GeometryFactory.FORMAS.GLYPH_FORMAS name;
    private Color cor;

    public FormaGeometrica(Glyph absGlyph, Rectangle bounds, GeometryFactory.FORMAS.GLYPH_FORMAS nomeForma) {
        super(absGlyph);
        this.bounds = bounds;
        this.name = nomeForma;
    }

    @Override
    public void paint(Graphics g) {
        System.out.print("Desenhando forma geometrica ...");
        FormaGeometrica forma = GeometryFactory.create(glyph, bounds, name);
        forma.paint(g);
    }

    public void setColor(Color cor) {
        this.cor = cor;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public int getArea() {
        return 0;
    }

//    @Override
//    public abstract void paint(Graphics g);
}
