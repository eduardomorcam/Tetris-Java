package com.mycompany.tetris;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Encapsula la información del GestorTeclado
 * @author eduar
 */
public class GestorTeclado extends KeyAdapter{
    /*
    char izquierda;
    char bajar;
    char derecha;
    char rotarDerecha;
    char rotarIzquierda;
    */
    int izquierda;
    int bajar;
    int derecha;
    int rotarDerecha;
    int rotarIzquierda;
    Pieza pieza;
    
    /**
     * Crea un objeto con la información recibida. Inicialmente no tiene ninguna pieza asociada.
     * @param izquierda tecla que provoca un desplazamiento hacia la izquierda de la pieza
     * @param bajar tecla que provoca un desplazamiento hacia la abajo de la pieza
     * @param derecha tecla que provoca un desplazamiento hacia la derecha de la pieza
     * @param rotarDerecha tecla que provoca un desplazamiento en el sentido de las agujas del reloj de la pieza
     * @param rotarIzquierda tecla que provoca un desplazamiento en el sentido contrario de las agujas del reloj de la pieza
     */
    public GestorTeclado(int izquierda, int bajar, int derecha, int rotarDerecha, int rotarIzquierda) {
        this.izquierda = izquierda;
        this.bajar = bajar;
        this.derecha = derecha;
        this.rotarDerecha = rotarDerecha;
        this.rotarIzquierda = rotarIzquierda;
        this.pieza = null;
    }
    /*
    public GestorTeclado(char izquierda, char bajar, char derecha, char rotarDerecha, char rotarIzquierda) {
        this.izquierda = izquierda;
        this.bajar = bajar;
        this.derecha = derecha;
        this.rotarDerecha = rotarDerecha;
        this.rotarIzquierda = rotarIzquierda;
        this.pieza = null;
    }
    */
    
    /**
     * Establece la pieza que va a gestionar este GestorTeclado.
     * @param pieza pieza a gestionar.
     */
    public void setPieza(Pieza pieza){
        this.pieza = pieza;
    }
    
    /**
     * Este método se invoca cada vez que se pulsa una tecla.
     * El método comprueba si coincide con alguna de las teclas recibidas en el constructor y en caso de coincidir, transmite a la pieza el movimiento a realizar.
     * @param e KeyEvent con la información de la tecla pulsada.
     */
    @Override
    public void keyPressed(KeyEvent e){
        if (this.pieza != null) {
        int tecla = e.getKeyCode();
        
        if (tecla == this.izquierda) {
            pieza.izquierda();
        } else if (tecla == this.bajar) {
            pieza.bajar();
        } else if (tecla == this.derecha) {
            pieza.derecha();
        } else if (tecla == this.rotarDerecha) {
            pieza.rotarDerecha();
        } else if (tecla == this.rotarIzquierda) {
            pieza.rotarIzquierda();
        }
    }
        /*
        if(this.pieza!=null){
            char tecla = e.getKeyChar();
            if(tecla == this.izquierda) pieza.izquierda();
            else if(tecla == this.bajar){
                pieza.bajar();
            }
            else if(tecla == derecha) pieza.derecha();
            else if(tecla == rotarDerecha) pieza.rotarDerecha();
            else if(tecla == rotarIzquierda) pieza.rotarIzquierda();
            
        }
        */
    }
}
