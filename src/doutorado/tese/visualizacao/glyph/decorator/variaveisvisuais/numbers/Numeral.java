/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.numbers;

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
public class Numeral extends Glyph {

    private int[] xPoints;
    private int[] yPoints;
    private String numero;
    private String letra;
    private boolean letraAtiva;
    private Font fonte;
    private boolean legenda;
    private int heightNumero;
    private int widthNumero;

    public Numeral() {
    }

    @Override
    public void paint(Graphics g) {
        int area = getBounds().height * getBounds().width;
        int fontSize = Math.round(getBounds().width * 0.7f);
        setFonte(new Font("Arial black", Font.PLAIN, fontSize));
        drawNumero(g);
        super.paint(g);
    }

    private void drawNumero(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setFont(getFonte());

        //calculode centro das letras
        Point centroLetra = calcularFontMetrics(g);
        int x = centroLetra.x;
        int y = centroLetra.y;

        g.setColor(Color.white);
        g.fillRect(xPoints[0], yPoints[0], xPoints[1], yPoints[1]);
        g2d.setColor(Color.black);
        g2d.drawString(getNumero(), x, y);

        if (legenda) {
            g2d.setColor(Color.black);
            g2d.setFont(getFonte());
            g2d.drawString(getNumero(), calcularFontMetrics(g).x, calcularFontMetrics(g).y);
        }
    }

    /**
     * Calculo do centro das letras
     *
     * @return
     */
    private Point calcularFontMetrics(Graphics g) {
        FontMetrics metrics = g.getFontMetrics(getFonte());

        heightNumero = metrics.getHeight();
        widthNumero = metrics.stringWidth(getNumero());

        int pX = getBounds().x + (getBounds().width - widthNumero) / 2;
        int pY = getBounds().y + ((getBounds().height - heightNumero) / 2) + metrics.getAscent();

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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the ativo
     */
//    public boolean isAtivo() {
//        return ativo;
//    }

    /**
     * @param ativo the ativo to set
     */
//    public void setAtivo(boolean ativo) {
//        this.ativo = ativo;
//    }

    public int getArea() {
        return heightNumero * widthNumero;
    }

    /**
     * @return the letra
     */
    public String getLetra() {
        return letra;
    }

    /**
     * @param letra the letra to set
     */
    public void setLetra(String letra) {
        this.letra = letra;
    }

    /**
     * @return the letraAtiva
     */
    public boolean isLetraAtiva() {
        return letraAtiva;
    }

    /**
     * @param letraAtiva the letraAtiva to set
     */
    public void setLetraAtiva(boolean letraAtiva) {
        this.letraAtiva = letraAtiva;
    }
}
