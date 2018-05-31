package doutorado.tese.legenda;

import doutorado.tese.cenarios.Resposta;
import doutorado.tese.visualizacao.glyph.Glyph;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.shapes.DrawBehavior;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.shapes.FormaGeometrica;
import doutorado.tese.visualizacao.grid.ItemGrid;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class Legenda extends JPanel {

    private Resposta respostaCerta;
    private ItemGrid itemGrid;
    private Glyph paiClone;

    public Legenda(Rectangle bounds) {
        setBounds(bounds.x, 15, bounds.width - 15, bounds.height - 20);
        setBackground(Color.WHITE);
        setVisible(true);
    }

    public Resposta getRespostaCerta() {
        return respostaCerta;
    }

    public void setRespostaCerta(Resposta respostaCerta) {
        this.respostaCerta = respostaCerta;
        this.itemGrid = this.respostaCerta.getListItens().get(0);
        clonandoGlyph();
    }

    public Glyph clonandoGlyph() {
        try {
            List<Glyph> glyphFamily = itemGrid.getGlyphFamily(itemGrid.getGlyph(), new ArrayList<>());
            paiClone = glyphFamily.get(0).clone();
            paiClone.killAllChild();
            for (int i = 1; i < glyphFamily.size(); i++) {
                Glyph filhoClone = glyphFamily.get(i).clone();
//                if (filhoClone instanceof FormaGeometrica) {
//                    FormaGeometrica forma = (FormaGeometrica) glyphFamily.get(i);
//                    DrawBehavior drawBehaviorClone = forma.getDrawBehavior().clone();
//                    FormaGeometrica formaClonada = ((FormaGeometrica) filhoClone);
//                    formaClonada.setDrawBehavior(drawBehaviorClone);  
//                    formaClonada.killAllChild();
//                    paiClone.appendChild(formaClonada);
//                } else {
                    filhoClone.killAllChild();
                    paiClone.appendChild(filhoClone);
//                }
            }
            paiClone.setBounds(new Rectangle(getBounds().x, 6, 75, 75));
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Legenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paiClone;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        paiClone.paint(g2d);
    }

}
