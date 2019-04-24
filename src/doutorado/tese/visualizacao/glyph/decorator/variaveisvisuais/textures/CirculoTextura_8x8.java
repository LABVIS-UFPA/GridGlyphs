package doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.textures;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;

/**
 * O objeto Circulo com cor ocupa 65% do item do treemap
 * 
 * @author Anderson Soares
 */
public class CirculoTextura_8x8 implements DrawBehavior{

    private int[] xPoints;
    private int[] yPoints;
    private int numberColor;
    private Color cor;
    private Rectangle bounds;
    private Path2D p;


    public CirculoTextura_8x8() {
    }

    @Override
    public void paint(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2d.setColor(Color.WHITE);
        g2d.fillRect(bounds.x,bounds.y,bounds.width,bounds.height);
        
        g2d.setColor(Color.BLACK);
        g2d.draw(p);    
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

    private void montarCirculo() {
        Rectangle rect = getBounds();
        
        int[] points = new int[2];

        points[0] = getBounds().width;
        points[1] = getBounds().height;

        int width = points[0];
        int height = points[1];

        int spacex = width/8;
        int spacey = height/8;
        
        int textureWidth = points[0];
        int textureHeight = points[1];

   
        p = new Path2D.Double();   
        
        for (int j = rect.y; j < rect.y+rect.height; j=j+spacey) {          
            for(int i = rect.x; i < rect.x + rect.width; i=i+spacex) {   
                p.append(new Ellipse2D.Double(width*0.025+i,height*0.025+j, textureWidth/8, textureHeight/8), false);   
                }
        }

             

    }

    public Rectangle getBounds(){
        return this.bounds;
    }
    
    @Override
    public void setBounds(Rectangle bounds){
        this.bounds = bounds;
        montarCirculo();
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
        g2d.setStroke(new BasicStroke(1.5f));
        g2d.setColor(Color.WHITE);
        g2d.draw(p);
        g2d.setColor(Color.BLACK);
        g2d.fill(p);
        g2d.setStroke(new BasicStroke(1));
    }
    
    @Override
    public CirculoTextura_8x8 clone() throws CloneNotSupportedException {
        try {
            // call clone in Object.
            return (CirculoTextura_8x8) super.clone();
        } catch (CloneNotSupportedException e) {
            System.err.println("Cloning not allowed.");
            return this;
        }
    }

    @Override
    public String toString() {
        super.toString();
        return CirculoTextura_8x8.class.getSimpleName();
    }
}
