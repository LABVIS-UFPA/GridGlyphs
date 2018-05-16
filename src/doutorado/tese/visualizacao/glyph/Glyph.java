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
import java.util.List;

/**
 *
 * @author Anderson Soares
 */
public abstract class Glyph {

    protected Glyph child;
    private Rectangle bounds;
    public float pectSobreposicao;
    private Glyph father;
    private final ArrayList children = new ArrayList();

    public void paint(Graphics2D g2d) {
        if (child != null) {
            if (getClipShape() != null) {
                g2d.clip(getClipShape());
            }
            child.paint(g2d);
        }
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
        if (this.child != null) {
            this.child.setBounds(new Rectangle(bounds.x + Math.round(((bounds.width * (1 - pectSobreposicao)) / 2)),
                    bounds.y + Math.round(((bounds.height * (1 - pectSobreposicao)) / 2)),
                    Math.round(bounds.width * pectSobreposicao), Math.round(bounds.height * pectSobreposicao)));
        }
    }

    public Rectangle getBounds() {
        return bounds;
    }

    /**
     * Metodo que faz a inclusao de um Glyph filho ao GLyphs pai.
     * Este metodo tambem atualiza o pai do glyph filho.
     * @param glyphChild glyph filho a ser incluido
     */
    public void appendChild(Glyph glyphChild) {
        Glyph pai = this.child;
        if (pai != null) {
            pai.appendChild(glyphChild);
        } else {
            pai = glyphChild;
            this.child = pai;
            this.children.add(pai);
            this.child.father = this;
        }
    }

    public void getChildren(ArrayList<Glyph> children) {
        children.add(this);
        if (this.child != null) {
            this.child.getChildren(children);
        }
    }

    public List<Glyph> getChildren() {
        return children;
    }

    public void killAllChild() {
        this.child = null;
    }

    public abstract Shape getClipShape();

    public float getPectSobreposicao() {
        return pectSobreposicao;
    }

    public void setPectSobreposicao(float pectSobreposicao) {
        this.pectSobreposicao = pectSobreposicao;
    }

    protected void setFather(Glyph father) {
        this.father = father;
    }

    /**
     * @return the father
     */
    protected Glyph getFather() {
        return father;
    }

    @Override
    public String toString() {
//        System.out.println(this.getClass().getSimpleName());
        return this.getClass().getSimpleName(); //To change body of generated methods, choose Tools | Templates.
    }
}
