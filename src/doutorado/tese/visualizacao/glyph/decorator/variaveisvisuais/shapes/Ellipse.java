package doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.GeneralPath;

public class Ellipse implements DrawBehavior {

    private int[] xPoints;
    private int[] yPoints;
    private Rectangle bounds;

    public Ellipse() {
    }

    @Override
    public void paint(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
               
        g2d.setColor(Color.white);
        g2d.fillOval(xPoints[0], yPoints[0], xPoints[1], yPoints[1]);
        g2d.setColor(Color.black);
        g2d.drawOval(xPoints[0], yPoints[0], xPoints[1], yPoints[1]);
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

    private void montarEllipse() {
        int[] points = new int[2];

        points[0] = getBounds().width;
        points[1] = getBounds().height;

//        verificarRetangulo(points);

        int width = (int) Math.round(points[0] * 0.95);
        int height = (int) Math.round(points[1] * 0.5);

        xPoints = new int[2];
        yPoints = new int[2];

        xPoints[0] = (int) (getBounds().x + getBounds().width/2 - width/2);
        yPoints[0] = (int) (getBounds().y + getBounds().height/2 - height/2);

        xPoints[1] = (int) (width);
        yPoints[1] = (int) (height);
    }
    
    public Rectangle getBounds(){
        return this.bounds;
    }
    
    @Override
    public void setBounds(Rectangle bounds){
        this.bounds = bounds;
        montarEllipse();
    }
    
    @Override
    public int getArea() {
        return xPoints[1] * yPoints[1];
    }

    @Override
    public Shape getClipShape() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
