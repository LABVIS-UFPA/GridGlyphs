/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;

public class Losango implements DrawBehavior {

    private int[] xPoints;
    private int[] yPoints;
    private Rectangle bounds;
    private Polygon p;
    private Color cor;

    public Losango() {
        cor = Color.WHITE;
    }

    @Override
    public void paint(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        g2d.setPaint(Color.BLACK);

        g2d.setColor(this.cor);
        g2d.fillPolygon(p);
//        g2d.setStroke(new BasicStroke(2f));
        g2d.setColor(Color.black);
        g2d.drawPolygon(p);
//        g2d.setStroke(new BasicStroke(1f));
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

    private void montarLosango() {
        int[] points = new int[2];

        points[0] = getBounds().width;
        points[1] = getBounds().height;

//        verificarRetangulo(points);
        int width = (int) Math.round(points[0] * 0.95);
        int height = (int) Math.round(points[1] * 0.95);

        int halfWidth = width / 2;
        int halfHeight = height / 2;
        int innerWidth = width / 2;
//        int innerHeight = height / 2;

        halfWidth += getBounds().x + getBounds().width / 2 - width / 2;
        halfHeight += getBounds().y + getBounds().height / 2 - height / 2;

        xPoints = new int[4];
        yPoints = new int[4];

        xPoints[0] = halfWidth;
        yPoints[0] = (int) Math.round(getBounds().y + getBounds().height / 2 - height / 2);

        xPoints[1] = halfWidth - innerWidth;
        yPoints[1] = halfHeight;

        xPoints[2] = halfWidth;
        yPoints[2] = height + (int) Math.round(getBounds().y + getBounds().height / 2 - height / 2);

        xPoints[3] = halfWidth + innerWidth;
        yPoints[3] = halfHeight;

        p = new Polygon();
        p.addPoint(xPoints[0], yPoints[0]);
        p.addPoint(xPoints[1], yPoints[1]);
        p.addPoint(xPoints[2], yPoints[2]);
        p.addPoint(xPoints[3], yPoints[3]);
    }

    public Rectangle getBounds() {
        return this.bounds;
    }

    @Override
    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
        montarLosango();
    }

    @Override
    public int getArea() {
        return (yPoints[2] - yPoints[0]) * (xPoints[3] - xPoints[1]);
    }

    @Override
    public Shape getClipShape() {
        return p;
    }

    @Override
    public void setColor(Color cor) {
        this.cor = cor;
    }
    
    @Override
    public void drawForeground(Graphics2D g2d) {
        g2d.setColor(Color.black);
        g2d.draw(p);
    }
    
    @Override
    public Losango clone() throws CloneNotSupportedException {
        try {
            // call clone in Object.
            return (Losango) super.clone();
        } catch (CloneNotSupportedException e) {
            System.err.println("Cloning not allowed.");
            return this;
        }
    }
    
    @Override
    public String toString() {
        super.toString();
        return Losango.class.getSimpleName();
    }

}
