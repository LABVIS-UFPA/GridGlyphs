/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.shapes;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Anderson Soares
 */
public interface DrawBehavior {
    public void paint(Graphics g);
    
    public int getArea();

    public void setBounds(Rectangle bounds);
}
