package doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.arrows;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;

/**
 * O objeto Circulo com cor ocupa 65% do item do treemap
 * 
 * @author Anderson Soares
 */
public class Arrow90 implements DrawBehavior{

    private int[] xPoints;
    private int[] yPoints;
    private int numberColor;
    private Color cor;
    private Rectangle bounds;
    private Polygon p;


    public Arrow90() {
    }

    @Override
    public void paint(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2d.setColor(Color.WHITE);
        g2d.fillRect(bounds.x,bounds.y,bounds.width,bounds.height);
        
        g2d.setColor(Color.BLACK);
  
        int slicewidth = bounds.width/6;
        int sliceheight = bounds.height/6;
               
        int scalewidth = (int) (bounds.width*0.16);
        int scaleheight = (int) (bounds.height*0.16);


      
        for (int i = 0; i < 5; i++) {
            
            
            
            p = new Polygon();
            //left
            p.addPoint((int) ((i*slicewidth+1)+bounds.x+scalewidth*0.6),  bounds.y+ scaleheight);
            
            //right
            p.addPoint((int) ((i*slicewidth+1)+bounds.x+scalewidth*1.4),  bounds.y+scaleheight );
           
            //center
            p.addPoint((i*slicewidth+1)+bounds.x+scalewidth,bounds.y );
      
            g2d.draw(p);
            g2d.fill(p);
        }
        
         for (int i = 1; i < 6; i++) {
              g2d.draw ( new Line2D.Float ( 
                    bounds.x+(i*slicewidth),
                    bounds.y,
                    bounds.x+(i*slicewidth),
                    bounds.y+bounds.height
            ));
    
         }
    }
    
    //função para deixar os glyphs quadrados
    private int[] verificarRetangulo(int [] point){
        if(point[0] > point[1]){
            point[0] = point[1];
           return point;
        }
        else if(point[0] < point[1]){
            point[1] = point[0];
           return point;
        }
        return null;
    }

    private void montarSetas90() {
      
             

    }

    public Rectangle getBounds(){
        return this.bounds;
    }
    
    @Override
    public void setBounds(Rectangle bounds){
        this.bounds = bounds;
        montarSetas90();
    }
    
    @Override
    public int getArea() {
        return xPoints[1]*yPoints[1];
    }

    @Override
    public Shape getClipShape() {
        return p;
    }

    @Override
    public void drawForeground(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLACK);
//        g2d.setStroke(new BasicStroke(1.5f));
//        g2d.draw(p);
//        g2d.setColor(Color.BLACK);
//        g2d.fill(p);
//        g2d.setStroke(new BasicStroke(1f));
    }
    
    @Override
    public Arrow90 clone() throws CloneNotSupportedException {
        try {
            // call clone in Object.
            return (Arrow90) super.clone();
        } catch (CloneNotSupportedException e) {
            System.err.println("Cloning not allowed.");
            return this;
        }
    }

    @Override
    public String toString() {
        super.toString();
        return Arrow90.class.getSimpleName();
    }
}
