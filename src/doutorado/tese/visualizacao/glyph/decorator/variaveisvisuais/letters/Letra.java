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
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.image.BufferedImage;

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
    private boolean ativo = false;

    public Letra() {
    }

    @Override
    public void paint(Graphics2D g2d) {
        int fontSize = Math.round(getBounds().height * 1.2f);
        setFonte(new Font("Arial black", Font.PLAIN, fontSize));
        drawLetra(g2d);

        super.paint(g2d);
    }

    private void drawLetra(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        g2d.setFont(getFonte());
        //calculode centro das letras
        Point centroLetra = calcularFontMetrics(g2d);
        int x = centroLetra.x;
        int y = centroLetra.y;

        g2d.setColor(new Color(0, 255, 0, 0));
        g2d.fillRect(xPoints[0], yPoints[0], xPoints[1], yPoints[1]);
        g2d.setColor(Color.black);
        g2d.drawString(getLetra(), x, y);
    }

    /**
     * Calculo do centro das letras
     *
     * @return
     */
    private Point calcularFontMetrics(Graphics2D g2d) {
        FontMetrics metrics = g2d.getFontMetrics(getFonte());
        heightLetra = metrics.getHeight();
        widthLetra = metrics.stringWidth(getLetra());
        int pX = Math.round(getBounds().x + (getBounds().width - widthLetra) / 2);
        int pY = Math.round(getBounds().y + ((getBounds().height - heightLetra) / 2) + metrics.getAscent());
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

    @Override
    public Shape getClipShape() {
        BufferedImage textImage = new BufferedImage(
                getBounds().width,
                getBounds().height,
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = textImage.createGraphics();
        FontRenderContext frc = g2d.getFontRenderContext();
        Point centroLetra = calcularFontMetrics(g2d);
        int x = centroLetra.x;
        int y = centroLetra.y;
        return getFonte().createGlyphVector(frc, letra).getOutline(x, y);
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

    @Override
    public Paint getTexturePaint() {
        return null;
    }
}
