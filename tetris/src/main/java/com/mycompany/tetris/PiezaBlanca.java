package com.mycompany.tetris;

import java.awt.Color;

/**
 * Encapsula la información de una pieza blanca
 * @author eduar
 */
public class PiezaBlanca extends Pieza{
    /**
     * Crea una nueva pieza blanca
     * 
     *         [][][]
     *         []         
     * 
     * @param tablero tablero donde la crea
     */
    public PiezaBlanca(GeneradorPiezas GeneradorPiezas,Tablero tablero) {
        super(GeneradorPiezas, tablero, Color.WHITE, new int[][]{{0,3},{0,4},{0,5},{1,3}}, 1);
    }
    
}
