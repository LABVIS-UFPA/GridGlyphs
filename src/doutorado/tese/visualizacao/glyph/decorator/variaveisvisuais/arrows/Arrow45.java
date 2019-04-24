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
public class Arrow45 implements DrawBehavior{

    private int[] xPoints;
    private int[] yPoints;
    private int numberColor;
    private Color cor;
    private Rectangle bounds;
    private Polygon p;


    public Arrow45() {
    }

    @Override
    public void paint(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2d.setColor(Color.WHITE);
        g2d.fillRect(bounds.x,bounds.y,bounds.width,bounds.height);
        
        g2d.setColor(Color.BLACK);
    
        int slicewidth = bounds.width/6;
        int sliceheight = bounds.height/6;
        int slice = bounds.height/6;
        int scalewidth = (int) (bounds.width*0.15);
        int scaleheight = (int) (bounds.height*0.15);

        int arrow[] = new int[4];
        arrow[0] = bounds.x;
        arrow[1] = bounds.y+bounds.height;
        arrow[2] = bounds.x+bounds.width;
        arrow[3] = bounds.y;
        
        
        int[] line1 = new int[4];
        line1[0]=bounds.x;
        line1[1]=bounds.y+2*slice;
        line1[2]=bounds.x+2*slice;
        line1[3]=bounds.y;
        
        int[] line2 = new int[4];
        line2[0]=bounds.x;
        line2[1]=bounds.y+4*slice;
        line2[2]=bounds.x+4*slice;
        line2[3]=bounds.y;
        
        int[] line3 = new int[4];
        line3[0]=bounds.x;
        line3[1]=bounds.y+bounds.height;
        line3[2]=bounds.x+bounds.width;
        line3[3]=bounds.y;
        
        int[] line4 = new int[4];
        line4[0]=bounds.x+2*slice;
        line4[1]=bounds.y+bounds.height;
        line4[2]=bounds.x+bounds.width;
        line4[3]=bounds.y+2*slice;
        
        int[] line5 = new int[4];
        line5[0]=bounds.x+4*slice;
        line5[1]=bounds.y+bounds.height;
        line5[2]=bounds.x+bounds.width;
        line5[3]=bounds.y+4*slice;
        
          g2d.setStroke(new BasicStroke(1.5f));
            g2d.draw ( new Line2D.Float ( 
                    line1[0],
                    line1[1],
                    line1[2],
                    line1[3]
            ));
    
            g2d.draw ( new Line2D.Float ( 
                    line2[0],
                    line2[1],
                    line2[2],
                    line2[3]
            ));
            
              g2d.draw ( new Line2D.Float ( 
                    line3[0],
                    line3[1],
                    line3[2],
                    line3[3]
            ));
              
                   g2d.draw ( new Line2D.Float ( 
                    line4[0],
                    line4[1],
                    line4[2],
                    line4[3]
            ));
              
              g2d.draw ( new Line2D.Float ( 
                    line5[0],
                    line5[1],
                    line5[2],
                    line5[3]
            ));
            
              
            g2d.setStroke(new BasicStroke(1f));
            
                    
        g2d.setColor(Color.BLACK);
        int x = 0;
        int arrowspace = slicewidth/2;
        int y = 0;
        while(x<= bounds.x+bounds.width){
            if(x>0 && x<5*slicewidth){
                
            p = new Polygon();
            p.addPoint(bounds.x+x, bounds.y );
            //top
            p.addPoint((int) (bounds.x+x-scalewidth*1.25), (int) (bounds.y+scaleheight*0.7));
            //botton
            p.addPoint((int) (bounds.x+x-scalewidth*0.6), (int) (bounds.y+scaleheight*1.4));
           
      
            g2d.draw(p);
            g2d.fill(p);
        
            }


  
            x += 2*slicewidth;
        }
        
        int polygon2[][] = new int[3][3];

        while(y<bounds.y+bounds.height){
            if(y<5*sliceheight){
            
            p = new Polygon();
            p.addPoint(bounds.x+bounds.width,bounds.y+y);
            //top
            p.addPoint((int) (bounds.x+bounds.width-scalewidth*1.25), (int) (bounds.y+y+scaleheight*0.7));
            //botton
            p.addPoint((int) (bounds.x+bounds.width-scalewidth*0.6), (int) (bounds.y+y+scaleheight*1.4));
           
      
            g2d.draw(p);
            g2d.fill(p);
                            
            }
            y += 2*sliceheight;
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
//        g2d.setColor(Color.WHITE);
//        g2d.setColor(Color.BLACK);
//        g2d.setStroke(new BasicStroke(1.5f));
//        g2d.draw(p);
//        g2d.fill(p);
//        g2d.setStroke(new BasicStroke(1f));
    }
    
    @Override
    public Arrow45 clone() throws CloneNotSupportedException {
        try {
            // call clone in Object.
            return (Arrow45) super.clone();
        } catch (CloneNotSupportedException e) {
            System.err.println("Cloning not allowed.");
            return this;
        }
    }

    @Override
    public String toString() {
        super.toString();
        return Arrow45.class.getSimpleName();
    }
}
