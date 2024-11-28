package com.mycompany.tetris;

import java.awt.Color;

/**
 * Encapsula la información de una pieza amarilla
 * @author eduar
 */
public class PiezaAmarilla extends Pieza{
    /**
     * Crea una nueva pieza amarilla
     * 
     *          [][][]
     *            []
     * 
     * @param tablero tablero donde la crea
     */
    public PiezaAmarilla(GeneradorPiezas GeneradorPiezas, Tablero tablero) {
        super(GeneradorPiezas, tablero, Color.YELLOW, new int[][]{{0,3},{0,4},{0,5},{1,4}}, 1);
    }
    
}
