/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.glyph;

import java.awt.Graphics;

/**
 *
 * @author Anderson Soares
 */
public class GlyphConcrete extends Glyph{
     
    @Override
    public void paint(Graphics g) {
        System.out.println("Desenhar Glyph.");
    }
}
