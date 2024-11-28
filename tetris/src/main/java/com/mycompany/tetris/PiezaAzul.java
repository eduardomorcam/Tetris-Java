package com.mycompany.tetris;

import java.awt.Color;

/**
 * Encapsula la información de una pieza azul
 * @author eduar
 */
public class PiezaAzul extends Pieza{
    /**
     * Crea una nueva pieza azul
     * 
     *       [][][][]
     * 
     * @param tablero tablero donde la crea
     */
    public PiezaAzul(GeneradorPiezas GeneradorPiezas, Tablero tablero) {
        super(GeneradorPiezas, tablero, Color.BLUE, new int[][]{{0,3},{0,4},{0,5},{0,6}}, 1);
        //super(tablero, Color.BLUE, new int[][]{{0,3},{1,3},{2,3},{3,3}}, 1);
    }
    
}
