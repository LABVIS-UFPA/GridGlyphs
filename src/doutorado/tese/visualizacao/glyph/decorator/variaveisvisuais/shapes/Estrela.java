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

public class Estrela implements DrawBehavior {

    private int[] xPoints;
    private int[] yPoints;
    private Polygon p;
    private Rectangle bounds;
    private Color cor;

    public Estrela() {
        cor = Color.BLUE;
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

    private void montarHexagono() {
        int[] points = new int[2];

        Rectangle rect = getBounds();

        points[0] = rect.width;
        points[1] = rect.height;

//        verificarRetangulo(points);
        int width = (int) Math.round(points[0] * 0.95);
        int height = (int) Math.round(points[1] * 0.95);

        int halfWidth = width / 2;
        int halfHeight = height / 2;
        int innerWidth = width / 4;
        int innerHeight = height / 4;

        halfWidth += rect.x + rect.width / 2 - width / 2;
        halfHeight += rect.y + rect.height / 2 - height / 2;

        xPoints = new int[10];
        yPoints = new int[10];

        xPoints[0] = halfWidth;
        yPoints[0] =  height + Math.round(rect.y + rect.height / 2 - height / 2);
        
        xPoints[1] = (int) (halfWidth - (innerWidth/2)*1.3);
        yPoints[1] = halfHeight + innerHeight/2;

        xPoints[2] = (int) Math.round(rect.x + rect.width / 2 - width / 2);
        yPoints[2] = halfHeight + innerHeight/3;

        xPoints[3] = (int) Math.round(rect.x + rect.width/2 - innerHeight);
        yPoints[3] = halfHeight - innerHeight/2;

        xPoints[4] = halfWidth-innerWidth;
        yPoints[4] = (int) Math.round(rect.y + rect.height / 2 - height / 2);

        xPoints[5] = (int) Math.round(rect.x + rect.width / 2 );
        yPoints[5] = halfHeight - innerHeight;

        xPoints[6] =  halfWidth+ innerWidth;
        yPoints[6] = (int) Math.round(rect.y + rect.height / 2 - height / 2);
        
        xPoints[7] = (int) Math.round(rect.x + rect.width/2 + innerHeight);
        yPoints[7] = halfHeight - innerHeight/2;
        
        xPoints[8] = (int) Math.round(rect.x + rect.width / 2 + width / 2);
        yPoints[8] = halfHeight + innerHeight/3;
        
        xPoints[9] = (int) (halfWidth + (innerWidth/2)*1.3);
        yPoints[9] = halfHeight + innerHeight/2;
        
        
        

        p = new Polygon();

        p.addPoint(xPoints[0], yPoints[0]);
        p.addPoint(xPoints[1], yPoints[1]);
        p.addPoint(xPoints[2], yPoints[2]);
        p.addPoint(xPoints[3], yPoints[3]);
        p.addPoint(xPoints[4], yPoints[4]);
        p.addPoint(xPoints[5], yPoints[5]);
        p.addPoint(xPoints[6], yPoints[6]);
        p.addPoint(xPoints[7], yPoints[7]);
        p.addPoint(xPoints[8], yPoints[8]); 
        p.addPoint(xPoints[9], yPoints[9]);
    }

    public Rectangle getBounds() {
        return this.bounds;
    }

    @Override
    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
        montarHexagono();
    }

    @Override
    public void setColor(Color cor) {
        this.cor = cor;
    }

    @Override
    public int getArea() {
        return (xPoints[4] - xPoints[1]) * (yPoints[3] - yPoints[0]);
    }

    @Override
    public Shape getClipShape() {
        return p;
    }

    @Override
    public void drawForeground(Graphics2D g2d) {
//        g2d.setColor(Color.black);
        g2d.setColor(this.cor);
        g2d.draw(p);
    }
    
    @Override
    public Estrela clone() throws CloneNotSupportedException {
        try {
            // call clone in Object.
            return (Estrela) super.clone();
        } catch (CloneNotSupportedException e) {
            System.err.println("Cloning not allowed.");
            return this;
        }
    }
    
    @Override
    public String toString() {
        super.toString();
        return Estrela.class.getSimpleName();
    }
}
