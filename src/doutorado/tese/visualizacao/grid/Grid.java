/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.grid;

import doutorado.tese.visualizacao.glyph.Glyph;
import doutorado.tese.visualizacao.glyph.GlyphConcrete;
import doutorado.tese.visualizacao.glyph.GlyphManager;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.HierarchyBoundsAdapter;
import java.awt.event.HierarchyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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
    private float quantOlverlap;
    private ArrayList<ItemGrid> gabarito;

    public Grid() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                mouseClickedMouseListener(e);
            }
        });
        glyphManager = new GlyphManager();
        glyphManager.setPerctOverlap(quantOlverlap);

        addHierarchyBoundsListener(new HierarchyBoundsAdapter() {
            @Override
            public void ancestorResized(HierarchyEvent e) {
                ancestorResizedHierarchyBoundsListener();
            }
        });
        this.rect = new Rectangle(0, 0, 0, 0);
    }

    private void ancestorResizedHierarchyBoundsListener() {
        setPreferredSize(getParent().getPreferredSize());
        setSize(getParent().getSize());
        rect.height = getParent().getPreferredSize().height;
        rect.width = getParent().getPreferredSize().width;
    }

    private void mouseClickedMouseListener(MouseEvent e) {
        if (itensGrid != null) {
            for (ItemGrid itemGrid : itensGrid) {
                if (itemGrid.getGlyph().getBounds().contains(e.getX(), e.getY())) {
                    if (!itemGrid.getGlyph().getSelectedByUser()) {
                        itemGrid.getGlyph().setSelectedByUser(true);
                        itemGrid.setSelectedByUser(true);
                        Graphics2D g2d = (Graphics2D) getGraphics().create();
                        g2d.setStroke(new BasicStroke(3f));
                        g2d.setColor(Color.decode("#B22222"));

                        g2d.drawRect(itemGrid.getGlyph().getBounds().x,
                                itemGrid.getGlyph().getBounds().y,
                                itemGrid.getGlyph().getBounds().width,
                                itemGrid.getGlyph().getBounds().height);
                        g2d.dispose();
                    } else {
                        itemGrid.getGlyph().setSelectedByUser(false);
                        itemGrid.setSelectedByUser(false);
                        Graphics2D g2d = (Graphics2D) getGraphics().create();
                        g2d.setStroke(new BasicStroke(3f));
                        g2d.setColor(Color.decode("#F0F8FF"));

                        g2d.drawRect(itemGrid.getGlyph().getBounds().x,
                                itemGrid.getGlyph().getBounds().y,
                                itemGrid.getGlyph().getBounds().width,
                                itemGrid.getGlyph().getBounds().height);

                        g2d.setStroke(new BasicStroke(0.1f));
                        g2d.setColor(Color.BLACK);
                        g2d.drawRect(itemGrid.getGlyph().getBounds().x,
                                itemGrid.getGlyph().getBounds().y,
                                itemGrid.getGlyph().getBounds().width,
                                itemGrid.getGlyph().getBounds().height);

                        g2d.dispose();
                    }
                }
            }
        }
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

                ArrayList<Glyph> list = new ArrayList<>();
                matrizGlyph[i][j].paint(g2d);
                matrizGlyph[i][j].getChildren(list);
                g2d.setClip(0, 0, getSize().width, getSize().height);
                g2d.drawRect(x, y, w, h);
            }
        }
        g2d.dispose();
    }

    /**
     * Metodo responsavel por configurar os glyphs do grid. Varre o vetor de
     * Itens do Grid, setando para cada obj ItemGrid seu respectivo valor de
     * overlapping e chama a funcao que configura as layers dos glyphs. Por fim,
     * verifica se o item possui um glyph com um de seus filhos sendo a resposta 
     * de uma pergunta, caso sim, o item é adicionado ao gabarito (ArrayList<ItemGrid>)
     * @return retorna o gabarito
     */
    public ArrayList<ItemGrid> setCofigItensGrid() {
        gabarito = new ArrayList();
        getGlyphManager().setVariaveisVisuaisEscolhidas(getVariaveisVisuaisEscolhidas());
//        glyphManager.analyseLayers();
        for (ItemGrid itemGrid : getItensGrid()) {
            getGlyphManager().setPerctOverlap(quantOlverlap);
            getGlyphManager().configLayers(itemGrid);
            if(itemGrid.isPossuiGlyphResposta()){
                getGabarito().add(itemGrid);
            }
        }
        return getGabarito();
    }

    /**
     * Metodo que cria a matriz de glyphs e relaciona cada item do grid com a
     * matriz. Por fim, define o tamanho (bounds) dos glyphs
     *
     * @param itensGrid vetor de itens do grid
     * @return matriz de glyphs
     */
    public Glyph[][] loadMatrizGlyphs() {
        matrizGlyph = new Glyph[getQuantHoriz()][getQuantVert()];
        int g = 0;
        for (int i = 0; i < getQuantHoriz(); i++) {
            for (int j = 0; j < getQuantVert(); j++) {
                if (g < itensGrid.length) {
                    matrizGlyph[i][j] = new GlyphConcrete();
//                    int x = i * size;
//                    int y = j * size;
//                    matrizGlyph[i][j].setBounds(new Rectangle(x, y, size, size));
                    itensGrid[g].setGlyph(matrizGlyph[i][j]);
//                    System.out.println("Montando matrix=z: " + itensGrid[g].getGlyph().getBounds());
//                    break;
                }
                g++;
            }
        }
        defineBoundsFromIndex();
        return matrizGlyph;
    }

    public void defineBoundsFromIndex() {
        int size = Math.min(getWidth() - 4, getHeight() - 4) / getQuantVert();

        for (int i = 0; i < getQuantHoriz(); i++) {
            for (int j = 0; j < getQuantVert(); j++) {
                int x = i * size;
                int y = j * size;
                matrizGlyph[i][j].setBounds(new Rectangle(x, y, size, size));
            }
        }
    }

    public void shufflePosition() {
        int n = getQuantHoriz() * getQuantVert() * 10;
        int cont = 0;
        while (cont < n) {
            int x1 = (int) (Math.random() * getQuantHoriz()), x2 = (int) (Math.random() * getQuantHoriz()),
                    y1 = (int) (Math.random() * getQuantVert()), y2 = (int) (Math.random() * getQuantVert());
            Glyph tempGlyph = matrizGlyph[x1][y1];
            matrizGlyph[x1][y1] = matrizGlyph[x2][y2];
            matrizGlyph[x2][y2] = tempGlyph;
            cont++;
        }
    }

    public void setGlyphOverlappingModel(boolean overlappingActivated) {
        getGlyphManager().configGlyphDesingModel(overlappingActivated);
    }

    public ItemGrid[] criarItens() {
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

    /**
     * @return the quantOlverlap
     */
    public float getQuantOlverlap() {
        return quantOlverlap;
    }

    /**
     * @param quantOlverlap the quantOlverlap to set
     */
    public void setQuantOlverlap(float quantOlverlap) {
        this.quantOlverlap = quantOlverlap;
    }

    public void setGridSize(int vert, int horiz) {
        setQuantVert(vert);
        setQuantHoriz(horiz);
    }

    /**
     * @return the glyphManager
     */
    public GlyphManager getGlyphManager() {
        return glyphManager;
    }
    
    /**
     * @return the gabarito
     */
    public ArrayList<ItemGrid> getGabarito() {
        return gabarito;
    }

    /**
     * @param gabarito the gabarito to set
     */
    public void setGabarito(ArrayList<ItemGrid> gabarito) {
        this.gabarito = gabarito;
    }

}
