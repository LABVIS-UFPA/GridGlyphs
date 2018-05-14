/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.grid;

import doutorado.tese.util.io.ManipuladorArquivo;
import doutorado.tese.visualizacao.glyph.Glyph;
import doutorado.tese.visualizacao.glyph.GlyphConcrete;
import doutorado.tese.visualizacao.glyph.GlyphManager;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.color.Cor;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.letters.Letra;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.numbers.Numeral;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.texture.Textura;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.HierarchyBoundsAdapter;
import java.awt.event.HierarchyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    private boolean decision = false;
    private ItemGrid[] itensGrid;
    private final GlyphManager glyphManager;
    private String[] variaveisVisuaisEscolhidas;
    private float porcetagem;

    public Grid() {
         this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println(e.getX() + " ," + e.getY());

                int g = 0;
                int size = Math.min(getWidth() - 4, getHeight() - 4) / getQuantVert();
                for (int i = 0; i < getQuantHoriz(); i++) {
                    for (int j = 0; j < getQuantVert(); j++) {
                        if (matrizGlyph[i][j].getBounds().contains(e.getX(), e.getY())) {
                            while (g < itensGrid.length) {
                                //System.out.println(itensGrid[g].getGlyph().getBounds());
                                //System.out.println(itensGrid[g].getGlyph().toString());
                                //System.out.println(itensGrid[g].getGlyph());
                                break;
                            }
                            g++;
                            ArrayList<Glyph> list = new ArrayList<>();
                            matrizGlyph[i][j].getChildren(list);
                            System.out.println("glyph"+list.toString());
                            
                            Glyph glyph;
                            glyph = new Cor();
                            Cor cor = (Cor) glyph;
                            cor.setCor(Color.decode("#3366cc"));
                            System.out.println(list.contains(cor));
                            System.out.println("achou item!");
                            break;
                        }
                    }
                }
            }

        });
        glyphManager = new GlyphManager();
        glyphManager.setPorcetagem(porcetagem);

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
                g2d.setClip(0, 0, getSize().width, getSize().height);
            }
        }
        g2d.dispose();
    }

    /**
     * Metodo responsavel por configurar os glyphs do grid. Varre a matriz de
     * glyphs, mata todos os filhos antigos, e adiciona os novos filhos de
     * acordo com a hierarquia passada através do variaveisVisuaisEscolhidas.
     * Por fim, é definido o tamanho de cada item do grid.
     *
     * @param itensHierarquia
     */
    public void setCofig() {
        glyphManager.setVariaveisVisuaisEscolhidas(getVariaveisVisuaisEscolhidas());
        glyphManager.analyseLayers();
        for (ItemGrid itensGrid : getItensGrid()) {
            glyphManager.configLayers(itensGrid);
        }
    }

    /**
     * Metodo que cria a matriz de glyphs e relaciona cada item do grid com a
     * matriz. Por fim, define o tamanho (bounds) dos glyphs
     *
     * @param itensGrid vetor de itens do grid
     * @return matriz de glyphs
     */
    public Glyph[][] loadMatrizGlyphs() {
        int size = Math.min(getWidth() - 4, getHeight() - 4) / getQuantVert();
        matrizGlyph = new Glyph[getQuantHoriz()][getQuantVert()];
        int g = 0;
        for (int i = 0; i < getQuantHoriz(); i++) {
            for (int j = 0; j < getQuantVert(); j++) {
                while (g < itensGrid.length) {
                    matrizGlyph[i][j] = new GlyphConcrete();
                    int x = i * size;
                    int y = j * size;
                    matrizGlyph[i][j].setBounds(new Rectangle(x, y, size, size));
                    itensGrid[g].setGlyph(matrizGlyph[i][j]);
//                    System.out.println("Montando matrix=z: " + itensGrid[g].getGlyph().getBounds());
                    break;
                }
                g++;
            }
        }
        return matrizGlyph;
    }

    public void setAtributosEscolhidos(List<Object> atributosEscolhidos) {
        //TODO
    }

    public ItemGrid[] criarItens(){
        int totalItens = getQuantHoriz() * getQuantVert();
        setItensGrid(new ItemGrid[totalItens]);
        for (int i = 0; i < getItensGrid().length; i++) {
            getItensGrid()[i] = new ItemGrid();
        }
        return getItensGrid();
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

    /**
     * @return the itensGrid
     */
    public ItemGrid[] getItensGrid() {
        return itensGrid;
    }

    /**
     * @param itensGrid the itensGrid to set
     */
    public void setItensGrid(ItemGrid[] itensGrid) {
        this.itensGrid = itensGrid;
    }

    /**
     * @return the variaveisVisuaisEscolhidas
     */
    public String[] getVariaveisVisuaisEscolhidas() {
        return variaveisVisuaisEscolhidas;
    }

    /**
     * @param variaveisVisuaisEscolhidas the variaveisVisuaisEscolhidas to set
     */
    public void setVariaveisVisuaisEscolhidas(String[] variaveisVisuaisEscolhidas) {
        this.variaveisVisuaisEscolhidas = variaveisVisuaisEscolhidas;
    }

    public float getPorcetagem() {
        return porcetagem;
    }

    public void setPorcetagem(float porcetagem) {
        this.porcetagem = porcetagem;
    }
    
    
}
