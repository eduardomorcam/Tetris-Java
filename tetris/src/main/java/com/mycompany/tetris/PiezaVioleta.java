package com.mycompany.tetris;

import java.awt.Color;

/**
 * Encapsula la información de una pieza violeta
 * @author eduar
 */
public class PiezaVioleta extends Pieza{
    /**
     * Crea una nueva pieza violeta
     * 
     *            [][]
     *              [][]
     * 
     * @param tablero tablero donde la crea
     */
    public PiezaVioleta(GeneradorPiezas GeneradorPiezas, Tablero tablero) {
        super(GeneradorPiezas, tablero, Color.MAGENTA, new int[][]{{0,3},{0,4},{1,4},{1,5}}, 1);
    }
    
}
