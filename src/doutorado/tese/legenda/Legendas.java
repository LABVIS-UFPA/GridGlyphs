
package doutorado.tese.legenda;

import doutorado.tese.cenarios.Resposta;
import doutorado.tese.cenarios.ScenarioManager;
import doutorado.tese.visualizacao.glyph.Glyph;
import doutorado.tese.visualizacao.glyph.GlyphConcrete;
import doutorado.tese.visualizacao.glyph.GlyphManager;
import doutorado.tese.visualizacao.grid.Grid;
import doutorado.tese.visualizacao.grid.ItemGrid;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.HierarchyBoundsAdapter;
import java.awt.event.HierarchyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Legendas extends JPanel {
    private Rectangle rect;
    private Resposta respostaCerta;
    private ArrayList<ItemGrid> gabarito;
    
 
    public Legendas() {
        
                
    }

    public Resposta getRespostaCerta() {
        return respostaCerta;
    }

    public void setRespostaCerta(Resposta respostaCerta) {
        this.respostaCerta = respostaCerta;
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("na legenda!");
        Graphics2D g2d = (Graphics2D) g; 
        for (int i = 0; i <respostaCerta.getListItens().size(); i++) {
            Glyph glyph = this.respostaCerta.getListItens().get(i).getGlyph();
            glyph.setBounds(new Rectangle(0,0,48,48));
            System.out.println(this.respostaCerta.getListItens().get(i).getGlyph().getBounds());
        }
        super.paint(g);
    }
    
    
    
    
}
