/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.texture;

import doutorado.tese.visualizacao.glyph.Glyph;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;

/**
 *
 * @author Anderson Soares
 */
public class Textura extends Glyph {

    private int[] xPoints;
    private int[] yPoints;
    private String nomeTextura;
    TMPatternFactory textura;
    private Color cor;
    private Color backgroundColor;

    public Textura() {
        textura = TMPatternFactory.getInstance(Color.BLACK, Color.WHITE);
    }    
    
    public Textura(Color cor, Color backgroundColor) {
        textura = TMPatternFactory.getInstance(cor, backgroundColor);
    }

    @Override
    public void paint(Graphics2D g2d) {
        drawTextura(g2d);
        super.paint(g2d);
    }

    private void drawTextura(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setPaint(textura.get(getNomeTextura()));

        g2d.fillRect(xPoints[0], yPoints[0], xPoints[1], yPoints[1]);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(xPoints[0], yPoints[0], xPoints[1], yPoints[1]);
    }

    @Override
    public void setBounds(Rectangle rect) {
        super.setBounds(rect);
        montarRetangulo();
    }

    public int getArea() {
        return xPoints[1] * yPoints[1];
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
     * @return the nomeTextura
     */
    public String getNomeTextura() {
        return nomeTextura;
    }

    /**
     * @param nomeTextura the nomeTextura to set
     */
    public void setNomeTextura(String nomeTextura) {
        this.nomeTextura = nomeTextura;
    }

    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @Override
    public Shape getClipShape() {
        return getBounds();
    }
    
    
}
