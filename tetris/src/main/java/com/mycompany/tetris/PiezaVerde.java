package com.mycompany.tetris;

import java.awt.Color;

/**
 * Encapsula la información de una pieza verde
 * @author eduar
 */
public class PiezaVerde extends Pieza{
    /**
     * Crea una nueva pieza verde
     * 
     *        [][][]
     *            []
     * 
     * @param tablero tablero donde la crea
     */
    public PiezaVerde(GeneradorPiezas GeneradorPiezas, Tablero tablero) {
        super(GeneradorPiezas, tablero, Color.GREEN, new int[][]{{0,3},{0,4},{0,5},{1,5}}, 1);
    }
    
}
