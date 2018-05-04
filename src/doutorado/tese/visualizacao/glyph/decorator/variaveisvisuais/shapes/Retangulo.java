package doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

public class Retangulo implements DrawBehavior {

    private int[] xPoints;
    private int[] yPoints;
    private Color cor;
    private Rectangle bounds;

    public Retangulo(Rectangle bounds) {
//        super(r, GeometryFactory.FORMAS.GLYPH_FORMAS.RETANGULO);
//        this.cor = cor;
        this.bounds = bounds;
        montarRetangulo();
    }

//    @Override
    public void paint(Graphics g) {
        drawFormaGeometrica(g);
//        glyphChild.paint(g);
    }

    private void drawFormaGeometrica(Graphics g) {
        System.out.println("Desenhando forma geometrica = Retangulo");
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setPaint(Color.WHITE);
        
        g2d.setColor(cor);
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

    private void montarRetangulo() {        
        int[] points = new int[2];

        Rectangle rect = getBounds();
        
        points[0] = rect.width;
        points[1] = rect.height;

        verificarRetangulo(points);

        int width = (int) Math.round(points[0] * 0.4);
        int height = (int) Math.round(points[1] * 0.4);
        
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
    public int getArea() {
        return xPoints[1] * yPoints[1];
    }

}
