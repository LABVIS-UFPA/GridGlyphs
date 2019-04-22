/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.arrows;

import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.textures.*;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.shapes.*;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;

/**
 *
 * @author Anderson Soares
 */
public interface DrawBehavior extends Cloneable{

    public void paint(Graphics2D g2d);

    public int getArea();

    public void setBounds(Rectangle bounds);

    public Shape getClipShape();
    
    public void drawForeground(Graphics2D g2d);
    
    public DrawBehavior clone() throws CloneNotSupportedException ;
}
