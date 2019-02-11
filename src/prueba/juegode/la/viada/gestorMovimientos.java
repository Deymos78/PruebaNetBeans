/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.juegode.la.viada;

import java.util.HashMap;

/**
 *
 * @author andre
 */
public class gestorMovimientos {
    private int[] posX;
    
    private int[] posY;
    private int[][] posiciones;
    HashMap<String, Integer> local = new HashMap<String, Integer>();

    public gestorMovimientos(int sizeX, int sizeY) {
        this.posiciones = new int[sizeX][sizeY];
        this.posX = new int[10];
        this.posY = new int[10];
    }
    
    public void meterLocalizacion(int i, int j){
        
    }

    
    
    
}
