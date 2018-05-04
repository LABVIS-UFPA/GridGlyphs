/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.shapes;

import doutorado.tese.visualizacao.glyph.Glyph;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;

//trapezio descendente
public class Trapezio implements DrawBehavior {

    private int[] xPoints;
    private int[] yPoints;
    private Rectangle bounds;

    public Trapezio(Rectangle bounds) {
//        super(r, GeometryFactory.FORMAS.GLYPH_FORMAS.TRAPEZIO);
        this.bounds = bounds;
        montarTrapezio();
    }

//    public Trapezio(Rectangle r) {
//        super(r, "TRAPEZIO");
//    }
    @Override
    public void paint(Graphics g) {
        drawFormaGeometrica(g);
//        glyphChild.paint(g);
    }

    private void drawFormaGeometrica(Graphics g) {
        System.out.println("Desenhando forma geometrica = Trapezio");
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setPaint(Color.BLACK);

        Polygon p = new Polygon();

        p.addPoint(xPoints[0], yPoints[0]);
        p.addPoint(xPoints[1], yPoints[1]);
        p.addPoint(xPoints[2], yPoints[2]);
        p.addPoint(xPoints[3], yPoints[3]);

        g2d.setColor(Color.white);
        g2d.fillPolygon(p);
        g2d.setColor(Color.BLACK);
        g2d.drawPolygon(p);
    }

    private int[] verificarRetangulo(int[] point) {
        if (point[0] > point[1]) {
            point[0] = point[1];
            return point;
        } else if (point[0] < point[1]) {
            point[1] = point[0];
            return point;
        }
        return null;
    }

    private void montarTrapezio() {
        int[] points = new int[2];

        points[0] = getBounds().width;
        points[1] = getBounds().height;

        verificarRetangulo(points);

        int width = (int) Math.round(points[0] * 0.46);
        int height = (int) Math.round(points[1] * 0.46);

        int halfWidth = width / 2;
        int halfHeight = height / 2;
        int innerWidth = width / 4;
        int innerHeight = height / 4;

        halfWidth += getBounds().x + getBounds().width / 2 - width / 2;
        halfHeight += getBounds().y + getBounds().height / 2 - height / 2;

        xPoints = new int[4];
        yPoints = new int[4];

        xPoints[0] = halfWidth + innerWidth;
        yPoints[0] = (int) Math.round(getBounds().y + getBounds().height / 2 - height / 2);

        xPoints[1] = halfWidth - innerWidth;
        yPoints[1] = (int) Math.round(getBounds().y + getBounds().height / 2 - height / 2);

        xPoints[2] = (int) Math.round(getBounds().x + getBounds().width / 2 - width / 2);
        yPoints[2] = height + (int) Math.round(getBounds().y + getBounds().height / 2 - height / 2);

        xPoints[3] = width + (int) Math.round(getBounds().x + getBounds().width / 2 - width / 2);
        yPoints[3] = height + (int) Math.round(getBounds().y + getBounds().height / 2 - height / 2);

    }

    public Rectangle getBounds() {
        return this.bounds;
    }

    @Override
    public int getArea() {
        return (yPoints[2] - yPoints[0]) * (xPoints[3] - xPoints[2]);
    }
}
