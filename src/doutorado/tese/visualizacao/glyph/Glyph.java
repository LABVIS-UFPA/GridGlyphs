/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.glyph;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.util.ArrayList;
import javax.swing.JMenuBar;

/**
 *
 * @author Anderson Soares
 */
public abstract class Glyph {

    protected Glyph glyphChild;
    private Rectangle bounds;
    public float pectSobreposicao;

    public void paint(Graphics2D g2d) {
        if (glyphChild != null) {
            if (getClipShape() != null) {
                g2d.clip(getClipShape());
            }
            glyphChild.paint(g2d);
        }
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
        if (this.glyphChild != null) {
            this.glyphChild.setBounds(new Rectangle(bounds.x + Math.round(((bounds.width * (1 - pectSobreposicao)) / 2)),
                    bounds.y + Math.round(((bounds.height * (1 - pectSobreposicao)) / 2)),
                    Math.round(bounds.width * pectSobreposicao), Math.round(bounds.height * pectSobreposicao)));
        }
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void appendChild(Glyph glyphChild) {
        if (this.glyphChild != null) {
            this.glyphChild.appendChild(glyphChild);
        } else {
            this.glyphChild = glyphChild;
        }
    }

    public void getChildren(ArrayList<Glyph> children) {
        children.add(this);
        if (this.glyphChild != null) {
            this.glyphChild.getChildren(children);
        }
    }

    public void killAllChild() {
        this.glyphChild = null;
    }

    public abstract Shape getClipShape();

    public float getPectSobreposicao() {
        return pectSobreposicao;
    }
    
    public void setPectSobreposicao(float pectSobreposicao) {
        this.pectSobreposicao = pectSobreposicao;
    }
}
