/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.grid;

import doutorado.tese.util.coluna.Coluna;
import java.util.HashMap;

/**
 *
 * @author Anderson Soares
 */
public class ItemGrid {

    protected HashMap<Coluna, String> mapaDadosItem;
    
    public ItemGrid() {
        mapaDadosItem = new HashMap<>();
    }
    
    /**
     * @return retorna o valor do item folha. 
     */
    public HashMap<Coluna, String> getMapaDadosItem() {
        return mapaDadosItem;
    }

    /**
     * @param mapaDadosItem the mapaDadosItem to set
     */
    public void setMapaDadosItem(HashMap<Coluna, String> mapaDadosItem) {
        this.mapaDadosItem = mapaDadosItem;
    }
}
