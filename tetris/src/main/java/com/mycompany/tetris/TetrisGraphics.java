package com.mycompany.tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Clase que encapsula un objeto Graphics2D, pinta sobre el objeto Graphics2D el borde del tetris y dispone de un método para poder pintar cada uno de los recuadros que conforman el tablero de juego.
 * @author eduar
 */
public class TetrisGraphics {
    private static final int MARGEN = 2;
    private static final int BORDE = 10;
    private static final Color COLOR_BORDE = Color.BLUE;
    private static final int FILAS = 20;
    private static final int COLUMNAS = 10;
    
    private Graphics g2D;  //Objeto Graphics2D
    private Rectangle rectangle;   //Rectángulo de pintado del objeto Graphics2D
    /*
    private static final double limiteInferiorX = 0; //COLUMNAS * MARGEN;
    private static final double limiteSuperiorX = COLUMNAS * BORDE;
    private static final double limiteInferiorY = 0; //FILAS * MARGEN;
    private static final double limiteSuperiorY = FILAS * BORDE;
    
    private int cartesianoAPixelX (double x) {
        return (int)((x-limiteInferiorX)/(limiteSuperiorX-limiteInferiorX)*rectangle.width);
    }
    
    private int cartesianoAPixelY (double y) {
        return (int)((limiteSuperiorY-y)/(limiteSuperiorY-limiteInferiorY)*rectangle.height);
    }
    */
    
    /**
     * Pinta el borde del área de juego
     */
    private void pintarBorde(){
        this.g2D.setColor(COLOR_BORDE);
        this.g2D.fillRect(this.rectangle.x + MARGEN, this.rectangle.y + MARGEN, BORDE, this.rectangle.height - MARGEN*2);
        this.g2D.fillRect(this.rectangle.width - MARGEN - BORDE, this.rectangle.y + MARGEN, BORDE, this.rectangle.height - MARGEN*2);
        this.g2D.fillRect(this.rectangle.x + MARGEN, this.rectangle.height - MARGEN - BORDE, this.rectangle.width - MARGEN*2, BORDE);
    }
    
    /**
     * Pinta el borde del tablero de juego
     * @param g2D 
     */
    public void paint(Graphics g2D){
        this.g2D = g2D;
        rectangle = g2D.getClipBounds();
        pintarBorde();
    }
    
    /**
     * Devuelve el ancho, en píxeles, de cada una de las celdas del tablero de juego.
     * @return el ancho, en píxeles, de cada una de las celdas del tablero de juego.
     */
    private double anchoCelda(){
        return (this.rectangle.width - MARGEN*2-BORDE*2) / (double)COLUMNAS;
    }
    
    /**
     * Devuelve el alto, en píxeles, de cada una de las celdas del tablero de juego.
     * @return el alto, en píxeles, de cada una de las celdas del tablero de juego.
     */
    private double altoCelda(){
        return (this.rectangle.height - MARGEN*2-BORDE) / (double)FILAS;
    }
   
    /**
     * Pinta en el color especificado la celda especificada por las coordenadas fila y columna. 
     * Las filas se numeran desde 0 hasta un máximo de filas -1, siendo 0 la fila superior y máximo número de filas -1, la fila inferior.
     * Las columnas se numeran desde 0 hasta un máximo de filas -1, siendo 0 la columna izquierda y máximo número de columnas -1, la columna derecha.
     * @param color color para pintar el cuadro
     * @param fila fila del cuadro a pintar
     * @param columna columna del cuadro a pintar
     */
    public void pintarCuadro(Color color, int fila, int columna){
        this.g2D.setColor(color);
        
        //this.g2D.fillRect((MARGEN + BORDE + (int)(columna*this.anchoCelda())), (MARGEN + (int)(fila*this.altoCelda()), (int)this.anchoCelda(), (int)this.altoCelda());
        
        
        this.g2D.fillRect(MARGEN + BORDE + (int)(columna*this.anchoCelda()), (MARGEN + (int)(fila*this.altoCelda())), ((int)(this.anchoCelda()*(columna+1))-(int)(this.anchoCelda()*columna)), ((int)(this.altoCelda()*(fila+1))-(int)(this.altoCelda()*fila)));
    
    }   
}