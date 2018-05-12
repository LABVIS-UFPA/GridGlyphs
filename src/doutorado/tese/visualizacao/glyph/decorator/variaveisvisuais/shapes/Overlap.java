/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;

public class Overlap implements DrawBehavior {

    private int[] xPoints;
    private int[] yPoints;
    private Polygon p;
    private Rectangle bounds;

    public Overlap() {

    }

    @Override
    public void paint(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setPaint(Color.WHITE);
        
        g2d.setColor(Color.BLACK);
        g2d.fillRect(xPoints[0], yPoints[0], xPoints[1], yPoints[1]);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(xPoints[0], yPoints[0], xPoints[1], yPoints[1]);
        
    }

    //função para deixar os glyphs quadrados
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

    private void sobreposicao() {
       int[] points = new int[2];

        Rectangle rect = getBounds();
        
        points[0] = rect.width;
        points[1] = rect.height;

//        verificarRetangulo(points);

        int width = (int) Math.round(points[0] * 0.95);
        int height = (int) Math.round(points[1] * 0.95);
        
        xPoints = new int[2];
        yPoints = new int[2];

        xPoints[0] =   rect.x + rect.width/2 - width/2 ;
        yPoints[0] =   rect.y + rect.height/2 - height/2;

        xPoints[1] = width;
        yPoints[1] = height;
        
    }
    
    public Rectangle getBounds(){
        return this.bounds;
    }
    
    @Override
    public void setBounds(Rectangle bounds){
        this.bounds = bounds;
        sobreposicao();
    }
    
    @Override
    public int getArea() {
        return (xPoints[8] - xPoints[2]) * (yPoints[5] - yPoints[0]);
    }

    @Override
    public Shape getClipShape() {
        return p;
    }
}
