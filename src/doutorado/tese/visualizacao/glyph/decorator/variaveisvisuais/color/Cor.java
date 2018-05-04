/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.color;

import doutorado.tese.visualizacao.glyph.Glyph;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Anderson Soares
 */
public class Cor extends Glyph{
    private int[] xPoints;
    private int[] yPoints;
    
    @Override
    public void paint(Graphics g) {
        drawCor(g);
        super.paint(g);
    }
    
    private void drawCor(Graphics g){
        System.out.println("Desenhando cor.");
    }
    
    @Override
    public void setBounds(Rectangle rect) {
        super.setBounds(rect);
        montarRetangulo();
    }
    
    private void montarRetangulo() {
        int[] points = new int[2];

        points[0] = getBounds().width;
        points[1] = getBounds().height;

        verificarRetangulo(points);

        int width = Math.round(points[0] * 0.8f);
        int height = Math.round(points[1] * 0.8f);

        xPoints = new int[2];
        yPoints = new int[2];

        xPoints[0] = getBounds().x + getBounds().width / 2 - width / 2;
        yPoints[0] = getBounds().y + getBounds().height / 2 - height / 2;

        xPoints[1] = width;
        yPoints[1] = height;
    }
    private void verificarRetangulo(int[] point) {
        if (point[0] > point[1]) {
            point[0] = point[1];
        } else if (point[0] < point[1]) {
            point[1] = point[0];
        }
    }
}
