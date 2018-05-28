/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.cenarios;

import doutorado.tese.visualizacao.glyph.Glyph;
import doutorado.tese.visualizacao.grid.ItemGrid;
import java.util.ArrayList;

/**
 *
 * @author Anderson Soares
 */
public class Resposta {

    private ArrayList<ItemGrid> itensResposta;
    private ItemGrid itemResposta;

    public Resposta() {
        itensResposta = new ArrayList<>();
    }
    
    /**
     * @return the itemResposta
     */
    public ItemGrid getItemResposta() {
        return itemResposta;
    }

    /**
     * @param itemResposta the itemResposta to set
     */
    public void setItemResposta(ItemGrid itemResposta) {
        this.itemResposta = itemResposta;
    }

    /**
     * @return the itensResposta
     */
    public ArrayList<ItemGrid> getItensResposta() {
        return itensResposta;
    }

    /**
     * @param itensResposta the itensResposta to set
     */
    public void setItensResposta(ArrayList<ItemGrid> itensResposta) {
        this.itensResposta = itensResposta;
    }
}
