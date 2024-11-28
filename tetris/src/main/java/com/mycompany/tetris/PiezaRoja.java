package com.mycompany.tetris;

import java.awt.Color;

/**
 * Encapsula la informnación de una pieza roja
 * @author eduar
 */
public class PiezaRoja extends Pieza{
    /**
     * Crea una nueva pieza roja
     * 
     *         [][]
     *       [][]
     * 
     * @param tablero tablero donde la crea
     */
    public PiezaRoja(GeneradorPiezas GeneradorPiezas, Tablero tablero) {
        super(GeneradorPiezas, tablero, Color.RED, new int[][]{{0,4},{0,5},{1,3},{1,4}}, 1);
    }
    
}
