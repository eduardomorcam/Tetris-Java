package com.mycompany.tetris;

import java.awt.Color;

public abstract class Pieza {
    private GeneradorPiezas generadorPiezas;
    private Tablero tablero;
    private Color color;
    private int[][] casillas;
    private int indiceCentro;
    private boolean fijada;
    
    /**
     * Crea un objeto Pieza con la información recibida.
     * @param generadorPiezas Generador de piezas, al que avisa cuando la pieza se ha fijado en el tablero.
     * @param tablero Tablero sobre el que se mueve la pieza.
     * @param color Color de la pieza.
     * @param casillas casillas ocupadas por la pieza inicialmente.
     * casillas.length = número de casillas de la pieza.
     * casillas[indice][0] = fila de la casilla indice.
     * casillas[indice][1] = columna de la casilla indice.
     * @param indiceCentro indice, sobre el parámetro casillas, de la casilla que es el centro de rotación.
     */
    public Pieza(GeneradorPiezas generadorPiezas, Tablero tablero, Color color, int[][] casillas, int indiceCentro){
        this.generadorPiezas = generadorPiezas;
        this.tablero = tablero;
        this.color = color;
        this.casillas = casillas;
        this.indiceCentro = indiceCentro;
        this.fijada = false;
    }
    
    /**
     * Intenta situar la pieza en el tablero.
     * Si al menos una de las casillas que ocupa la pieza no está disponible en el tablero:
     *          La pieza no se sitúa en el tablero
     *          Devuelve false
     * Si todas las casillas que ocupa la pieza están disponibles en el tablero:
     *          La pieza se sitúa en el tablero
     *          Devuelve true
     * @return true si la pieza se puede situar en el tablero y se sitúa y false en caso contrario.
     */
    public boolean situarPieza(){
        if(this.tablero.espacioDisponible(casillas)) {
            tablero.situarPieza(color, casillas);
            return true;
        } else {
            //this.tablero.perder();
            return false;
        }
    }
    
    /**
     * Si la pieza aún no se ha fijado y además esta libre la nueva posición en el tablero cambia la pieza a la nueva posición.
     *          Actualizando la información en el tablero
     *          Actualizando la nueva ubicación de la pieza
     *          Devuelve true
     * Si la pieza ya ha sido fijada o no está libre la nueva posición en el tablero
     *          Devuelve false
     * @param nuevaPosicion
     * @return true si la pieza a cambiado a la nueva posición, false si la pieza no ha cambiado ala nueva posición.
     */
    public boolean cambiarPiezaSiPuede(int[][] nuevaPosicion){
        if(this.fijada == false && this.tablero.espacioDisponible(nuevaPosicion)){
            this.tablero.cambiarPieza(color, casillas, nuevaPosicion);
            this.casillas = nuevaPosicion;
            return true;
        } else {
            return false;
        } 
    }
    
    /**
     * Baja la pieza una fila si puede.
     * Si la pieza se puede bajar una fila
     *          Baja la pieza una fila: actualizando el tablero y las coordenadas de la pieza
     *          Devuelve true
     * Si la pieza no se puede bajar:
     *          Fija la pieza en el tablero
     *          Avisa al GeneradorPiezas recibido en el constructor que la pieza ha llevado a su fin llamando al método GeneradorPiezas.finPieza()
     * @return true si la pieza se ha desplazado hacia abajo, false en caso contrario.
     */
    public boolean bajar(){
        int[][] nuevaPosicion = new int[this.casillas.length][this.casillas[0].length];
        for (int i = 0; i < this.casillas.length; i++) {
            for (int j = 0; j < this.casillas[0].length; j++) {
                nuevaPosicion[i][j] = this.casillas[i][j];
            }
        }
        for (int i = 0; i < nuevaPosicion.length; i++) {
            nuevaPosicion[i][0]++;
        }
        if(this.cambiarPiezaSiPuede(nuevaPosicion) == false){
            this.fijada = true;
            this.tablero.fijarPieza(this.color, this.casillas);
            this.generadorPiezas.finPieza();
            return false;
        } else return true;
        /*int[][] nuevaPosicion = new int[this.casillas.length][this.casillas[0].length];
        for (int i = 0; i < this.casillas.length; i++) {
            for (int j = 0; j < this.casillas[0].length; j++) {
                nuevaPosicion[i][j] = this.casillas[i][j];
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                nuevaPosicion[i][j] = 
            }
        }
        return this.cambiarPiezaSiPuede(nuevaPosicion);*/
    }
    
    /**
     * Desplaza la pieza una columna hacia la izquierda si puede.
     * Si la pieza se puede mover una columna hacia la izquierda:
     *          Desplaza la pieza una columna hacia la izquierda: actualizando el tablero y las coordenadas de la pieza
     *          Devuelve true
     * Si la pieza no se puede mover una columna hacia la izquierda:
     *          Devuelve false
     * @return true si la pieza se ha desplazado hacia la izquierda, false en caso contrario.
     */
    public boolean izquierda(){
        int[][] nuevaPosicion = new int[this.casillas.length][this.casillas[0].length];
        for (int i = 0; i < this.casillas.length; i++) {
            for (int j = 0; j < this.casillas[0].length; j++) {
                nuevaPosicion[i][j] = this.casillas[i][j];
            }
        }
        for (int i = 0; i < nuevaPosicion.length; i++) {
            nuevaPosicion[i][1]--;
            if(nuevaPosicion[i][1] < 0) return false;
        }
        return this.cambiarPiezaSiPuede(nuevaPosicion);
        /*
        if(this.cambiarPiezaSiPuede(nuevaPosicion) == false){
            this.fijada = true;
            return false;
        } else return true;
        */
    }
    
    /**
     * Desplaza la pieza una columna hacia la derecha si puede.
     * Si la pieza se puede mover una columna hacia la derecha:
     *          Desplaza la pieza una columna hacia la derecha: actualizando el tablero y las coordenadas de la pieza
     *          Devuelve true
     * Si la pieza no se puede mover una columna hacia la derecha:
     *          Devuelve false
     * @return true si la pieza se ha desplazado hacia la derecha, false en caso contrario.
     */
    public boolean derecha(){
        int[][] nuevaPosicion = new int[this.casillas.length][this.casillas[0].length];
        for (int i = 0; i < this.casillas.length; i++) {
            for (int j = 0; j < this.casillas[0].length; j++) {
                nuevaPosicion[i][j] = this.casillas[i][j];
            }
        }
        for (int i = 0; i < nuevaPosicion.length; i++) {
            nuevaPosicion[i][1]++;
        }
        return this.cambiarPiezaSiPuede(nuevaPosicion);
    }
    
    /**
     * Gira la pieza en el sentido de las agujas del reloj si puede.
     * Si la pieza se puede rotar en el sentido de las agujas del reloj:
     *          Rota la pieza en el sentido de las agujas del reloj: actualizando el tablero y las coordenadas de la pieza
     *          Devuelve true
     * Si la pieza no se puede rotar en el sentido de las agujas del reloj:
     *          Devuelve false
     * @return true si la pieza ha rotado en el sentido de las agujas del reloj, false en caso contrario.
     */
    public boolean rotarDerecha(){
        int[][] nuevaPosicion = new int[this.casillas.length][this.casillas[0].length];
        for (int i = 0; i < this.casillas.length; i++) {
            int XsinCentro = this.casillas[i][0] - this.casillas[this.indiceCentro][0];
            int YsinCentro = this.casillas[i][1] - this.casillas[this.indiceCentro][1];
            nuevaPosicion[i][0] = this.casillas[this.indiceCentro][0] + YsinCentro;
            nuevaPosicion[i][1] = this.casillas[this.indiceCentro][1] - XsinCentro; 
        }
        return this.cambiarPiezaSiPuede(nuevaPosicion);
        /*
        int[][] nuevaPosicion = new int[this.casillas.length][this.casillas[0].length];
        int centroX = this.casillas[this.indiceCentro][0];
        int centroY = this.casillas[this.indiceCentro][1];

        for (int i = 0; i < this.casillas.length; i++) {
            int relX = this.casillas[i][0] - centroX; // Invertir el eje X
            int relY = this.casillas[i][1] - centroY;
            nuevaPosicion[i][0] = centroX + relY; // Mantener la dirección del eje X
            nuevaPosicion[i][1] = centroY - relX;
        }

        return this.cambiarPiezaSiPuede(nuevaPosicion);*/
        /*int[][] nuevaPosicion = new int[this.casillas.length][this.casillas[0].length];
        int centroX = this.casillas[this.indiceCentro][0];
        int centroY = this.casillas[this.indiceCentro][1];

        for (int i = 0; i < this.casillas.length; i++) {
            int relX = this.casillas[i][0] - centroX;
            int relY = centroY - this.casillas[i][1]; // Invertir el eje Y
            nuevaPosicion[i][0] = centroX + relY;
            nuevaPosicion[i][1] = centroY - relX; // Mantener la dirección del eje Y
        }

        return this.cambiarPiezaSiPuede(nuevaPosicion);*/

    }
    
    /**
     * Gira la pieza en el sentido contrario de las agujas del reloj si puede.
     * Si la pieza se puede rotar en el sentido contrario de las agujas del reloj:
     *          Rota la pieza en el sentido contrario de las agujas del reloj: actualizando el tablero y las coordenadas de la pieza
     *          Devuelve true
     * Si la pieza no se puede rotar en el sentido contrario de las agujas del reloj:
     *          Devuelve false
     * @return true si la pieza ha rotado en el sentido contrario de las agujas del reloj, false en caso contrario.
     */
    public boolean rotarIzquierda(){
       int[][] nuevaPosicion = new int[this.casillas.length][this.casillas[0].length];
        for (int i = 0; i < this.casillas.length; i++) {
            int XsinCentro = this.casillas[i][0] - this.casillas[this.indiceCentro][0];
            int YsinCentro = this.casillas[i][1] - this.casillas[this.indiceCentro][1];
            nuevaPosicion[i][0] = this.casillas[this.indiceCentro][0] - YsinCentro;
            nuevaPosicion[i][1] = this.casillas[this.indiceCentro][1] + XsinCentro; 
        }
        return this.cambiarPiezaSiPuede(nuevaPosicion);
        /*
        int[][] nuevaPosicion = new int[this.casillas.length][this.casillas[0].length];
        int centroX = this.casillas[this.indiceCentro][0];
        int centroY = this.casillas[this.indiceCentro][1];

        for (int i = 0; i < this.casillas.length; i++) {
            int relX = centroX - this.casillas[i][0]; // Invertir el eje X
            int relY = this.casillas[i][1] - centroY;
            nuevaPosicion[i][0] = centroX - relY; // Mantener la dirección del eje X
            nuevaPosicion[i][1] = centroY + relX;
        }

        return this.cambiarPiezaSiPuede(nuevaPosicion);
*/
    }
}
