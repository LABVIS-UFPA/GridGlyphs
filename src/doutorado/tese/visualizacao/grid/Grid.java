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
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.shapes.FormaGeometrica;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.shapes.Trapezio;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.texture.Textura;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.HierarchyBoundsAdapter;
import java.awt.event.HierarchyEvent;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Anderson Soares
 */
public class Grid extends JPanel {

    private Rectangle rect;
    private int quantVert;
    private int quantHoriz;
    private Glyph[][] matrizGlyph;

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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setPreferredSize(this.getParent().getPreferredSize());
        this.setSize(this.getParent().getSize());
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
        g2d.setColor(Color.BLACK);
        for (int i = 0; i < getQuantHoriz(); i++) {
            for (int j = 0; j < getQuantVert(); j++) {
                int x = matrizGlyph[i][j].getBounds().x;
                int y = matrizGlyph[i][j].getBounds().y;
                int w = matrizGlyph[i][j].getBounds().width;
                int h = matrizGlyph[i][j].getBounds().height;
                g2d.drawRect(x, y, w, h);

                ArrayList<Glyph> list = new ArrayList<>();
                matrizGlyph[i][j].paint(g2d);
                matrizGlyph[i][j].getChildren(list);
            }
        }
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

    public void setCofig(String[] itensHierarquia) {
        for (int i = 0; i < getQuantHoriz(); i++) {
            for (int j = 0; j < getQuantVert(); j++) {
                matrizGlyph[i][j].killAllChild();
                for (String itensHierarquia1 : itensHierarquia) {
                    matrizGlyph[i][j].appendChild(configLayers(itensHierarquia1));
                    ArrayList<Glyph> list = new ArrayList<>();
                    matrizGlyph[i][j].getChildren(list);
                }
                matrizGlyph[i][j].setBounds(matrizGlyph[i][j].getBounds());
            }
        }
    }

    public Glyph configLayers(String classe) {
        Glyph glyph = null;
        Letra letra = null;
        switch (classe) {
            case "Color":
                glyph = new Cor();
                Cor cor = (Cor) glyph;
                cor.setCor(Color.decode("#3366cc"));
                break;
            case "Letter":
                glyph = new Letra();
                letra = (Letra) glyph;
                letra.setLetra("A");
                letra.setAtivo(true);
                break;
            case "Number":
                glyph = new Numeral();
                Numeral numero = (Numeral) glyph;
                numero.setNumero("A3");
                break;
            case "Shape":
                glyph = new FormaGeometrica();
                FormaGeometrica forma = (FormaGeometrica) glyph;
//                forma.setDrawBehavior(new Cruz());
//                forma.setDrawBehavior(new Ellipse());
                forma.setDrawBehavior(new Trapezio());
//                System.out.println("criou forma");
                break;
            case "Texture":
                glyph = new Textura();
                Textura textura = (Textura) glyph;
                textura.setNomeTextura("PATTERN_HORIZONTAL");
                break;
            default:
                throw new AssertionError();
        }
        return glyph;
    }

    /**
     * Metodo que cria a matriz de glyphs e define o tamanho (bounds) dos glyphs
     *
     * @return matriz de glyphs
     */
    public Glyph[][] loadMatrizGlyphs() {
        int size = Math.min(getWidth() - 4, getHeight() - 4) / getQuantVert();
        matrizGlyph = new Glyph[getQuantHoriz()][getQuantVert()];
        for (int i = 0; i < getQuantHoriz(); i++) {
            for (int j = 0; j < getQuantVert(); j++) {
                matrizGlyph[i][j] = new GlyphConcrete();
                int x = i * size;
                int y = j * size;
                matrizGlyph[i][j].setBounds(new Rectangle(x, y, size, size));
            }
        }
        return matrizGlyph;
    }

}
