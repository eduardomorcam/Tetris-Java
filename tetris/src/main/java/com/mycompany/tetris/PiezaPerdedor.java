package com.mycompany.tetris;

import java.awt.Color;

/**
 *
 * @author eduar
 */
public class PiezaPerdedor extends Pieza{
    
    public PiezaPerdedor(GeneradorPiezas GeneradorPiezas, Tablero tablero) {
        super(GeneradorPiezas, tablero, Color.BLACK, new int[][]{
            {0,1},{0,2},{0,4},{0,6},{0,8},{0,9},{0,10},
            {1,0},{1,3},{1,5},{1,6},{1,7},{1,8},{1,9},
            {2,0},{2,3},{2,4},{2,5},{2,6},{2,8},{2,9},{2,10},
            {3,0},{3,2},{3,3},{3,5},{3,6},{3,8},{3,9},
            {4,1},{4,2},{4,3},{4,5},{4,6},{4,8},{4,9},{4,10}
        }, 1);
    }
}
