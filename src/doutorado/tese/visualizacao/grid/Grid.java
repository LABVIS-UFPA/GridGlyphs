/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.grid;

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
//        setOpaque(false);
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
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        System.out.println(this.getParent().getPreferredSize());
        this.setPreferredSize(this.getParent().getPreferredSize());
        this.setSize(this.getParent().getSize());
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

//        System.out.println("quantHoriz: " + getQuantHoriz());
        if (getSize().width == 0 || getSize().height == 0 || getQuantVert() == 0) return;
        
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
