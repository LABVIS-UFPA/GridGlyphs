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
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.texture.Textura;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.HierarchyBoundsAdapter;
import java.awt.event.HierarchyEvent;
import java.util.ArrayList;
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
        matrizGlyph = loadMatrizGlyphs();
        
        int size = Math.min(getWidth() - 4, getHeight() - 4) / getQuantVert();

        for (int i = 0; i < getQuantHoriz(); i++) {
            for (int j = 0; j < getQuantVert(); j++) {
                int x = i * size;
                int y = j * size;
                g2d.drawRect(x, y, size, size);
                matrizGlyph[i][j].setBounds(new Rectangle(x, y, size, size));
            }
        }
        
//        for (int x = 0; x < getQuantHoriz(); x++) {
//            for (int y = 0; y < getQuantVert(); y++) {
//                matrizGlyph[x][y].paint(g);
//                ArrayList<Glyph> list = new ArrayList<>();
//                matrizGlyph[x][y].getChildren(list);
//                System.out.println("++++++++++" + list);
//            }
//        }

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
                    System.out.println("++++++++++" + list);
                }
                matrizGlyph[i][j].setBounds(matrizGlyph[i][j].getBounds());
            }
        }
    }

    public Glyph configLayers(String classe) {
        Glyph glyph = null;
        switch (classe) {
            case "Color":
                glyph = new Cor();
//                System.out.println("criou cor");
                break;
            case "Letter":
                glyph = new Letra();
//                System.out.println("criou letra");
                break;
            case "Number":
                glyph = new Numeral();
//                System.out.println("criou numero");
                break;
            case "Shape":
                glyph = new FormaGeometrica();
//                System.out.println("criou forma");
                break;
            case "Texture":
                glyph = new Textura();
                break;
            default:
                throw new AssertionError();
        }
        return glyph;
    }

    public void putGlyphs() {
        Graphics2D g2d = (Graphics2D) this.getGraphics().create();
                
        for (int x = 0; x < getQuantHoriz(); x++) {
            for (int y = 0; y < getQuantVert(); y++) {
                matrizGlyph[x][y].paint(g2d);
                ArrayList<Glyph> list = new ArrayList<>();
                matrizGlyph[x][y].getChildren(list);
                System.out.println("++++++++++" + list);
            }
        }
    }

    private Glyph[][] loadMatrizGlyphs() {
        matrizGlyph = new Glyph[getQuantHoriz()][getQuantVert()];
        for (int i = 0; i < getQuantHoriz(); i++) {
            for (int j = 0; j < getQuantVert(); j++) {
                matrizGlyph[i][j] = new GlyphConcrete();
            }
        }
        return matrizGlyph;
    }
}
