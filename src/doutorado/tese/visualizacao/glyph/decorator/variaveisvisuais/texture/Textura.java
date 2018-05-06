/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.texture;

import doutorado.tese.visualizacao.glyph.Glyph;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import net.bouthier.treemapAWT.TMPatternFactory;

/**
 *
 * @author Anderson Soares
 */
public class Textura extends Glyph {

    private int[] xPoints;
    private int[] yPoints;
    private String nome;
    TMPatternFactory textura;

    public Textura() {
        textura = TMPatternFactory.getInstance();
    }
//    public Textura(Rectangle r, String nome) {
//        this.rect = r;
//        setBounds(this.rect);
//        this.nome = nome;
//        montarRetangulo();
//        textura = TMPatternFactory.getInstance();
//    }
    @Override
    public void paint(Graphics g) {
        drawTextura(g);
        super.paint(g);
    }

    private void drawTextura(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setPaint(textura.get("PATTERN_HORIZONTAL"));

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

    private void verificarRetangulo(int[] point) {
        if (point[0] > point[1]) {
            point[0] = point[1];
        } else if (point[0] < point[1]) {
            point[1] = point[0];
        }
    }

    private void montarRetangulo() {
        int[] points = new int[2];

        points[0] = getBounds().width;
        points[1] = getBounds().height;

        verificarRetangulo(points);

        int width = Math.round(points[0] * 0.95f);
        int height = Math.round(points[1] * 0.95f);

        xPoints = new int[2];
        yPoints = new int[2];

        xPoints[0] = getBounds().x + getBounds().width / 2 - width / 2;
        yPoints[0] = getBounds().y + getBounds().height / 2 - height / 2;

        xPoints[1] = width;
        yPoints[1] = height;
    }
}
