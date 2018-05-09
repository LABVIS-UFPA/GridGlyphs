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
import java.util.Arrays;
import java.util.HashMap;
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
    private Letra letra;
    private Numeral numero;
    private boolean decision = false;

    private HashMap<String, Boolean> ativeMap;

    public Grid() {
        ativeMap = new HashMap<>();
        ativeMap.put("Texture", false);
        ativeMap.put("Color", false);
        ativeMap.put("Number", false);
        ativeMap.put("Letter", false);
        ativeMap.put("Shape", false);
        
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
        ativeMap.put("Number",false);
        ativeMap.put("Letter",false);
        ativeMap.put("Shape",false);
        ativeMap.put("Color",false);
        ativeMap.put("Texture",false);

        for (String i : itensHierarquia) {
            ativeMap.put(i, true);
        }
                    
        for (int i = 0; i < getQuantHoriz(); i++) {
            for (int j = 0; j < getQuantVert(); j++) {
                matrizGlyph[i][j].killAllChild();
                for (String itensHierarquia1 : itensHierarquia) {
                    Glyph configLayers = configLayers(itensHierarquia1);


                    matrizGlyph[i][j].appendChild(configLayers);

                    ArrayList<Glyph> list = new ArrayList<>();
                    matrizGlyph[i][j].getChildren(list);
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
                Cor cor = (Cor) glyph;
                cor.setCor(Color.decode("#3366cc"));
                break;
            case "Letter":
                glyph = new Letra();
                letra = (Letra) glyph;
                if (numero != null && ativeMap.get("Number")) {
                    System.out.println((numero != null) + "&" + (numero.isLetraAtiva()));
                    System.out.println("numero ativo");
                    letra.setLetra("3A");
                } else {
                    letra.setLetra("A");
        
                }
                break;
            case "Number":
                glyph = new Numeral();
                numero = (Numeral) glyph;
                if (letra != null && ativeMap.get("Letter")) {
                    System.out.println((letra != null) + "&" + (letra.isAtivo()));
                    System.out.println("letra ativa");
                    numero.setNumero("A3");
                   
                } else {
                    numero.setNumero("3");
               
                }
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
