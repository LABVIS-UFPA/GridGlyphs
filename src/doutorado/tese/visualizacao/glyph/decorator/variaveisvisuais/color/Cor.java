/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.color;

import doutorado.tese.visualizacao.glyph.Glyph;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

/**
 *
 * @author Anderson Soares
 */
public class Cor extends Glyph{
    private int[] xPoints;
    private int[] yPoints;
    private Color cor;
    
    @Override
    public void paint(Graphics g) {
        drawCor(g);
        super.paint(g);
    }
    
    private void drawCor(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(getCor());
        g2d.fillRect(xPoints[0], yPoints[0], xPoints[1], yPoints[1]);
    }
    
    @Override
    public void setBounds(Rectangle rect) {
        super.setBounds(rect);
        montarRetangulo();
    }
    
    private void montarRetangulo() {
        int[] points = new int[2];

        points[0] = getBounds().width;
        points[1] = getBounds().height;

        int width = Math.round(points[0] * 0.95f);
        int height = Math.round(points[1] * 0.95f);

        xPoints = new int[2];
        yPoints = new int[2];

        xPoints[0] = getBounds().x + getBounds().width / 2 - width / 2;
        yPoints[0] = getBounds().y + getBounds().height / 2 - height / 2;

        xPoints[1] = width;
        yPoints[1] = height;
    }

    /**
     * @return the cor
     */
    public Color getCor() {
        return cor;
    }

    /**
     * @param cor the cor to set
     */
    public void setCor(Color cor) {
        this.cor = cor;
    }
    
}
