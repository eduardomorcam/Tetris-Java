package com.mycompany.tetris;

import java.awt.Color;

/**
 * Encapsula la información de una pieza rosa
 * @author eduar
 */
public class PiezaRosa extends Pieza{
    /**
     * Crea una nueva pieza rosa
     * 
     *        [][]
     *        [][]
     * 
     * @param tablero tablero donde la crea
     */
    public PiezaRosa(GeneradorPiezas GeneradorPiezas, Tablero tablero) {
        super(GeneradorPiezas, tablero, Color.PINK, new int[][]{{0,3},{0,4},{1,3},{1,4}}, 1);
    }
    
}
