package doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.shapes;

import doutorado.tese.visualizacao.glyph.Glyph;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

/**
 * O objeto Circulo com cor ocupa 65% do item do treemap
 * 
 * @author Anderson Soares
 */
public class Circulo extends FormaGeometrica{

    private int[] xPoints;
    private int[] yPoints;
    private int numberColor;
    private Color cor;

    public Circulo(Glyph absGlyph, Rectangle r) {
        super(absGlyph, r, GeometryFactory.FORMAS.GLYPH_FORMAS.CIRCULO);
//        this.cor = cor;
//        montarCirculo();
    }

    public void paint(Graphics g) {
        drawFormaGeometrica(g);
        glyph.paint(g);
    }
    
    private void drawFormaGeometrica(Graphics g) {
        System.out.println("Desenhando forma geometrica = CIRCULO");
//        Graphics2D g2d = (Graphics2D) g;
//        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        
//        g2d.setColor(cor);
//        g2d.fillOval(xPoints[0], yPoints[0], xPoints[1], yPoints[1]);
//        g2d.setColor(Color.BLACK);
//        g2d.drawOval(xPoints[0], yPoints[0], xPoints[1], yPoints[1]);
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
        int[] points = new int[2];

        Rectangle rect = getBounds();
        points[0] = rect.width;
        points[1] = rect.height;

        verificarRetangulo(points);

        int width = (int) Math.round(points[0] * 0.65);
        int height = (int) Math.round(points[1] * 0.65);

        xPoints = new int[2];
        yPoints = new int[2];

        xPoints[0] = (int) (rect.x + rect.width/2 - width/2);
        yPoints[0] = (int) (rect.y + rect.height/2 - height/2);

        xPoints[1] = (int) (width);
        yPoints[1] = (int) (height);
    }

    @Override
    public int getArea() {
        return xPoints[1]*yPoints[1];
    }

}
