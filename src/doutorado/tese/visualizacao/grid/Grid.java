/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.grid;

import doutorado.tese.visualizacao.glyph.Glyph;
import doutorado.tese.visualizacao.glyph.GlyphConcrete;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.color.Cor;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.letters.Letra;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.numbers.Numeral;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.texture.Textura;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.shapes.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.HierarchyBoundsAdapter;
import java.awt.event.HierarchyEvent;
import javax.swing.GroupLayout;
import javax.swing.JPanel;

/**
 *
 * @author Anderson Soares
 */
public class Grid extends JPanel {

    private Rectangle rect;
    private int quantVert;
    private int quantHoriz;

    public Grid() {
        addHierarchyBoundsListener(new HierarchyBoundsAdapter() {
            @Override
            public void ancestorResized(HierarchyEvent e) {
                setPreferredSize(getParent().getPreferredSize());
                setSize(getParent().getSize());
                rect.height = getParent().getPreferredSize().height;
                rect.width = getParent().getPreferredSize().width;
            }
        });
        this.rect = new Rectangle(0, 0, 0, 0);
    }

    public Grid(Rectangle rect) {
        this.rect = rect;
        setLayout(new GroupLayout(this));
        setBounds(this.rect);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setPreferredSize(this.getParent().getPreferredSize());
        this.setSize(this.getParent().getSize());
        //testeando patter decorator
        Glyph glyph = new Textura(new FormaGeometrica(new Cor(new Letra(new Numeral(new GlyphConcrete()))), null, GeometryFactory.FORMAS.GLYPH_FORMAS.HEXAGONO));
        glyph.paint(g);

        Glyph glyph2 = new Cor(new FormaGeometrica(new GlyphConcrete(), null, GeometryFactory.FORMAS.GLYPH_FORMAS.CRUZ));
        glyph2.paint(g);

        Glyph glyph3 = new FormaGeometrica(new Textura(new Cor(new GlyphConcrete())), rect, GeometryFactory.FORMAS.GLYPH_FORMAS.LOSANGO);
        glyph3.paint(g);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (getSize().width == 0 || getSize().height == 0 || getQuantVert() == 0) {
            return;
        }

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.decode("#f0f8ff"));
        g2d.fillRect(0, 0, getSize().width, getSize().height);

        g2d.setColor(Color.red);
        int size = Math.min(getWidth() - 4, getHeight() - 4) / getQuantVert();
//        System.out.println("size:" + size);

        for (int x = 0; x < getQuantHoriz() * size; x += size) {
            for (int y = 0; y < getQuantVert() * size; y += size) {
                g2d.drawRect(x, y, size, size);
            }
        }
//        System.out.println("size:" + size);
        g2d.dispose();
    }

    public int getQuantVert() {
        return quantVert;
    }

    public void setQuantVert(int quantVert) {
        this.quantVert = quantVert;
    }

    public int getQuantHoriz() {
        return quantHoriz;
    }

    public void setQuantHoriz(int quantHoriz) {
        this.quantHoriz = quantHoriz;
    }

}
