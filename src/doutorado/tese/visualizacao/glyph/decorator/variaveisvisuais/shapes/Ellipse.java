package doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;

public class Ellipse implements DrawBehavior {

    private double[] xPoints;
    private double[] yPoints;
    private Rectangle bounds;
    private Path2D p;
    private Color cor;

    public Ellipse() {
        cor = Color.WHITE;
    }

    @Override
    public void paint(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(this.cor);
        g2d.fill(p);
        g2d.setColor(Color.black);
        g2d.draw(p);

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
        Rectangle rect = getBounds();

        int[] points = new int[2];

        points[0] = getBounds().width;
        points[1] = getBounds().height;

        int width = (int) Math.round(points[0] * 0.95);
        int height = (int) Math.round(points[1] * 0.95);

        p = new Path2D.Double();
        p.append(new Ellipse2D.Double(rect.x + 2, rect.y + height / 4, width, height / 1.5), true);
    }

    public Rectangle getBounds() {
        return this.bounds;
    }

    @Override
    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
        montarEllipse();
    }

    @Override
    public void setColor(Color cor) {
        this.cor = cor;
    }

    @Override
    public int getArea() {
        return (int) (xPoints[1] * yPoints[1]);
    }

    @Override
    public Shape getClipShape() {
        return p;
    }

    @Override
    public void drawForeground(Graphics2D g2d) {
        g2d.setColor(this.cor);
        g2d.draw(p);
    }

    @Override
    public Ellipse clone() throws CloneNotSupportedException {
        try {
            // call clone in Object.
            return (Ellipse) super.clone();
        } catch (CloneNotSupportedException e) {
            System.err.println("Cloning not allowed.");
            return this;
        }
    }

    @Override
    public String toString() {
        super.toString();
        return Ellipse.class.getSimpleName();
    }

}
