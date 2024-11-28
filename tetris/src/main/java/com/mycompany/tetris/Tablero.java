package com.mycompany.tetris;

import java.awt.Color;

/**
 * Tablero donde se almacena el estado de juego.
 * @author eduar
 */
public class Tablero {
    private static final int FILAS = 20;
    private static final int COLUMNAS = 10;
    private static final Color COLOR_FONDO = Color.BLACK;
    
    
    // Estado de cada una de las casillas del Tablero.
    
    // estadoTablero[f][c] false - la casilla formada por fila f y columna c está vacía u ocupada por la ficha actual.
    
    // estadoTablero[f][c] true - la casilla formada por la fila f y columna c está ocupada por una ficha que ya se ha fijado.
    private boolean[][] estadoTablero;
    
    
    // Color con el que hay que pintar cada una de las casillas del tablero gráfico.
    
    // colorTablero[f][c] = color con el que hay que pintar la casilla formada por fila f y columna c
    
    // (se incluye también el pintado de la ficha actual)
    private Color[][] colorTablero;
    
    /**
     * Crea un objeto con la información recibida
     * Inicialmente todas las casillas del tablero están en COLOR_FONDO y libres.
     */
    public Tablero(){
        this.estadoTablero = new boolean[FILAS][COLUMNAS];
        this.colorTablero = new Color[FILAS][COLUMNAS];
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                this.colorTablero[i][j] = COLOR_FONDO;
                this.estadoTablero[i][j] = false;
            }
        }
    }
    
    /**
     * Pinta el tablero sobre el objeto recibido
     * @param tetrisGraphics objeto sobre el que se pinta el tablero.
     */
    private void pintarTablero(TetrisGraphics tetrisGraphics){
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tetrisGraphics.pintarCuadro(this.colorTablero[i][j], i, j);
            }
        }
    }
    
    /**
     * Pinta el tablero sobre el objeto recibido.
     * @param tetrisGraphics objeto sobre el que se pinta el tablero
     */
    public void paint(TetrisGraphics tetrisGraphics){
        pintarTablero(tetrisGraphics);
    }
    
    /**
     * Sitúa una nueva pieza sobre el tablero.
     * @param color color de la nueva pieza.
     * @param casillas coordenadas ocupadas por la casilla.
     * casillas.length = número de casillas que tiene la pieza.
     * casillas[indice][0] = fila de la casilla indice.
     * casillas[indice][1] = columna de la casilla indice.
     */
    public void situarPieza(Color color, int[][] casillas){
        for (int i = 0; i < casillas.length; i++) {
            this.colorTablero[casillas[i][0]][casillas[i][1]] = color;
        }
    }
    
    /**
     * Cambia la posición de una pieza sobre el tablero
     * @param color Color de la pieza
     * @param casillasAnteriores coordenadas ocupadas actualmente por la casilla.
     * casillasAnteriores.length = número de casillas que tiene la pieza.
     * casillasAnteriores[indice][0] = fila de la casilla indice.
     * casillasAnteriores[indice][1] = columna de la casilla indice.
     * @param casillasActuales coordenadas ocupadas por la casilla tras cambiar la pieza de lugar/posición.
     * casillasActuales.length = número de casillas que tiene la pieza.
     * casillasActuales[indice][0] = fila de la casilla indice.
     * casillasActuales[indice][1] = columna de la casilla indice.
     */
    public void cambiarPieza(Color color, int[][] casillasAnteriores, int[][] casillasActuales){
        for (int i = 0; i < casillasAnteriores.length; i++) {
            this.colorTablero[casillasAnteriores[i][0]][casillasAnteriores[i][1]] = COLOR_FONDO;
        }
        for (int i = 0; i < casillasActuales.length; i++) {
            this.colorTablero[casillasActuales[i][0]][casillasActuales[i][1]] = color;
        }
    }
    
    /**
     * Fija la pieza en el tablero y actualiza las matrices estadoTablero y colorTablero.
     * Actualiza las matrices estadoTablero y colorTablero eliminando las filas completas y haciendo que las filas superiores desciendan ocupando las filas que se han completado.
     * @param color Color de la pieza a fijar
     * @param casillas casillas de la pieza a fijar
     * casillas.length = número de casillas que tiene la pieza.
     * casillas[indice][0] = fila de la casilla indice
     * casillas[indice][1] = columna de la casilla indice
     */
    public void fijarPieza(Color color, int[][] casillas){
        for (int i = 0; i < casillas.length; i++) {
            this.colorTablero[casillas[i][0]][casillas[i][1]] = color;
            this.estadoTablero[casillas[i][0]][casillas[i][1]] = true; 
        }
        this.comprobarFilas();
    }
    
    /**
     * Devuelve true si todas las casillas especificadas en el parámetro se encuentran vacías, a estos efectos no tiene en cuenta las casillas ocupadas por la pieza actual.
     * Devuelve false, si alguna de las casillas especificadas se encuentra ocupada.
     * @param casillas casillas que se quiere comprobar si están ocupadas.
     * casillas.length = número de casillas a comprobar.
     * casillas[indice][0] = fila de la casilla indice a comprobar si está ocupada.
     * casillas[indice][1] = columna de la casilla indice a comprobar si está ocupada.
     * @return true si todas las casillas especificadas en el parámetro se encuentran vacías, si alguna de las casillas especificadas se encuentra ocupada.
     */
    @SuppressWarnings("empty-statement")
    public boolean espacioDisponible(int[][] casillas){
        for (int i = 0; i < casillas.length; i++) {
            
            if(casillas[i][0] < 0 || casillas[i][0] >= FILAS || casillas[i][1] < 0 || casillas[i][1] >= COLUMNAS) return false;
            if(this.estadoTablero[casillas[i][0]][casillas[i][1]]) return false;
            
            
            /*
            if(casillas[i][0] >= this.estadoTablero.length || casillas[i][1] >= this.estadoTablero[0].length) return false;
            if(casillas[i][0] < 0 || casillas[i][1] < 0) return false;
            if(casillas[i][0] > FILAS || casillas[i][1] > COLUMNAS) return false;
            */
                    
                    
            /*
            if(casillas[i][0] > COLUMNAS || casillas[i][1] > FILAS) return false;
             if (casillas[i][0] < 0 || casillas[i][0] >= FILAS ||
                casillas[i][1] < 0 || casillas[i][1] >= COLUMNAS)
                 return false;
*/
        }
        return true;
    }
    
    public void comprobarFilas(){
        for (int i = 0; i < FILAS; i++) {
            boolean filaCompleta = true;
            for (int j = 0; j < COLUMNAS; j++) {
                if (this.estadoTablero[i][j] == false) {
                    filaCompleta = false;
                    break;
                }
            }
            if (filaCompleta) {
                this.borrarFilas(i);
                i--;
            }
        }
        /*
        for (int i = FILAS; i > 0; i--) {
            int casillaTrue = 0;
            for (int j = COLUMNAS; j > 0; j--) {
                if(this.estadoTablero[i][j]) casillaTrue++;
            }
            if(casillaTrue == COLUMNAS){
                this.borrarFilas(i);
            }
        }*/
    }
    
    public void borrarFilas(int indiceFila){
        for (int i = 0; i < COLUMNAS; i++) {
            this.colorTablero[indiceFila][i] = COLOR_FONDO;
            this.estadoTablero[indiceFila][i] = false;
        }
        for (int i = indiceFila; i > 0; i--) {
            for (int j = 0; j < COLUMNAS; j++) {
                this.colorTablero[i][j] = this.colorTablero[i - 1][j];
                this.estadoTablero[i][j] = this.estadoTablero[i - 1][j];
            }
        }
        for (int i = 0; i < COLUMNAS; i++) {
            this.colorTablero[0][i] = COLOR_FONDO;
            this.estadoTablero[0][i] = false;
        }
    }
    /*
    public void perder(){
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                this.colorTablero[i][j] = Color.RED;
                this.estadoTablero[i][j] = false;
            }
        }
        this.situarPieza(COLOR_FONDO, new PiezaPerdedor());
        
        this.situarPieza(COLOR_FONDO, new int[][]{
            {0,1},{0,2},{0,4},{0,6},{0,8},{0,9},{0,10},
            {1,0},{1,3},{1,5},{1,6},{1,7},{1,8},{1,9},
            {2,0},{2,3},{2,4},{2,5},{2,6},{2,8},{2,9},{2,10},
            {3,0},{3,2},{3,3},{3,5},{3,6},{3,8},{3,9},
            {4,1},{4,2},{4,3},{4,5},{4,6},{4,8},{4,9},{4,10}
        });
    }*/
}