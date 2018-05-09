/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.letters;

import doutorado.tese.visualizacao.glyph.Glyph;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;

/**
 *
 * @author Anderson Soares
 */
public class Letra extends Glyph {

    private int[] xPoints;
    private int[] yPoints;
    private int widthLetra;
    private int heightLetra;
//    private Rectangle rect;
    private String letra;
    private Font fonte;
    private boolean legenda;
    private boolean ativo;

    public Letra() {
    }

    @Override
    public void paint(Graphics g) {
        int fontSize = Math.round(getBounds().height * 0.99f);
        setFonte(new Font("Arial black", Font.PLAIN, fontSize));
        drawLetra(g);
        super.paint(g);
    }

    private void drawLetra(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setFont(getFonte());
        //calculode centro das letras
        Point centroLetra = calcularFontMetrics(g);
        int x = centroLetra.x;
        int y = centroLetra.y;
//        if (!legenda) {
//            g.drawRect(x, y - fm.getAscent(), (int) rect.getWidth(), (int) rect.getHeight());
//        }
        g.setColor(Color.white);
        g.fillRect(xPoints[0], yPoints[0], xPoints[1], yPoints[1]);
        g2d.setColor(Color.black);
        g2d.drawString(getLetra(), x, y);
        if (legenda) {
            g2d.setColor(Color.black);
            g2d.setFont(getFonte());
            g2d.drawString(getLetra(), calcularFontMetrics(g).x, calcularFontMetrics(g).y);
        }
    }

    /**
     * Calculo do centro das letras
     *
     * @return
     */
    private Point calcularFontMetrics(Graphics g) {
        FontMetrics metrics = g.getFontMetrics(getFonte());

        heightLetra = metrics.getHeight();
        widthLetra = metrics.stringWidth(getLetra());

        int pX = getBounds().x + (getBounds().width - widthLetra) / 2;
        int pY = getBounds().y + ((getBounds().height - heightLetra) / 2) + metrics.getAscent();

        return new Point(pX, pY);
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
     * @return the fonte
     */
    public Font getFonte() {
        return fonte;
    }

    /**
     * @param fonte the fonte to set
     */
    public void setFonte(Font fonte) {
        this.fonte = fonte;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    /**
     * @return the ativo
     */
    public boolean isAtivo() {
        return ativo;
    }
    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    public int getArea() {
        return heightLetra * widthLetra;
    }

}
