/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.cenarios;

import doutorado.tese.visualizacao.grid.ItemGrid;
import java.util.ArrayList;

/**
 *
 * @author Anderson Soares
 */
public class Resposta {

    private ArrayList<ItemGrid> listItens;
    private ItemGrid itemResposta;

    public Resposta() {
        listItens = new ArrayList<>();
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
     * @return the listItens
     */
    public ArrayList<ItemGrid> getListItens() {
        return listItens;
    }

    /**
     * @param listItens the listItens to set
     */
    public void setListItens(ArrayList<ItemGrid> listItens) {
        this.listItens = listItens;
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
    
}
