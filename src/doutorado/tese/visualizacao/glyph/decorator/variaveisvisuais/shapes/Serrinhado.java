package doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;

public class Serrinhado implements DrawBehavior {

    private int[] xPoints;
    private int[] yPoints;
    private Color cor;
    private Rectangle bounds;
    private Polygon p1;
    private Polygon p2;
    private Polygon p3;
    private Polygon p4;
    
    public Serrinhado() {
        cor = Color.WHITE;
    }

    @Override
    public void paint(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

//        g2d.setPaint(Color.WHITE);        
        g2d.setColor(this.cor);
        g2d.fillRect(xPoints[0], yPoints[0], xPoints[1], yPoints[1]);
        g2d.setStroke(new BasicStroke(1.5f));
        g2d.setColor(Color.WHITE);
        g2d.drawRect(xPoints[0], yPoints[0], xPoints[1], yPoints[1]);
        
        g2d.setColor(Color.decode("#A9A9A9"));
        int slicewidth = bounds.width/6;
        int sliceheight = bounds.height/6;
        int slice = bounds.height/6;

        int scalewidth = (int) (bounds.width*0.15);
        int scaleheight = (int) (bounds.height*0.15);
        for (int i = slicewidth; i < 6*slicewidth; i+=slicewidth) {
              p1 = new Polygon();
              //left
              if(i==slicewidth){
              p1.addPoint(bounds.x,bounds.y);
              
              }
              
              p1.addPoint(bounds.x+i-scalewidth/2,bounds.y);
              //center
              p1.addPoint(bounds.x+i,bounds.y+scaleheight);
              //right
              p1.addPoint(bounds.x+i+scalewidth/2,bounds.y);
              
              
              p2 = new Polygon();
              //left
              p2.addPoint(bounds.x+i-scalewidth/2,(int) (bounds.y+bounds.height-scaleheight*0.2));
              //center
              p2.addPoint(bounds.x+i, (int) (bounds.y+bounds.height-scaleheight*1.2));
              //right
              p2.addPoint(bounds.x+i+scalewidth/2, (int) (bounds.y+bounds.height-scaleheight*0.2));
             
              
              p3 = new Polygon();
              //left
              if(i>1*slicewidth){
              p3.addPoint(bounds.x,bounds.y+i-scaleheight/2);
              if(i<5*slicewidth){
              //center
                   p3.addPoint((int) (bounds.x+scalewidth),bounds.y+i);
                   //right
                   p3.addPoint(bounds.x,bounds.y+i+scaleheight/2);
              }
              }
              
              p4 = new Polygon();
              if(i>1*slicewidth){
              p4.addPoint(bounds.x+bounds.width,bounds.y+i-scaleheight/2);
              if(i<5*slicewidth){
              //center
                   p4.addPoint((int) (bounds.x+bounds.width-scalewidth),bounds.y+i);
                   //right
                   p4.addPoint(bounds.x+bounds.width,bounds.y+i+scaleheight/2);
              }
              }
            
            g2d.draw(p1);
            g2d.fill(p1);
            
            g2d.draw(p2);
            g2d.fill(p2);
            
            g2d.draw(p3);
            g2d.fill(p3);
            
            g2d.draw(p4);
            g2d.fill(p4);
            
            
        }
        
        
        
  
        g2d.setStroke(new BasicStroke(1f));
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

    private void montarRetangulo() {        
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
        montarRetangulo();
    }
    
    @Override
    public int getArea() {
        return xPoints[1] * yPoints[1];
    }

    @Override
    public Shape getClipShape() {
        return getBounds();
    }

    @Override
    public void setColor(Color cor) {
        this.cor = cor;
    }
    
    @Override
    public void drawForeground(Graphics2D g2d) {
        g2d.setColor(this.cor);
//        g2d.drawRect(xPoints[0], yPoints[0], xPoints[1], yPoints[1]);
    }

    @Override
    public Serrinhado clone() throws CloneNotSupportedException {
        try {
            // call clone in Object.
            return (Serrinhado) super.clone();
        } 
        catch (CloneNotSupportedException e) {
            System.err.println("Cloning not allowed.");
            return this;
        }
    }
    
    @Override
    public String toString() {
        super.toString();
        return Serrinhado.class.getSimpleName();
    }

}
