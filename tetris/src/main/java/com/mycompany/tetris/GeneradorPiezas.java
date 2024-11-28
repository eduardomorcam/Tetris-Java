package com.mycompany.tetris;

import java.awt.Color;
import java.util.Random;

/**
 * Controla la generación de piezas
 * @author eduar
 */
public class GeneradorPiezas {
    
    private Tablero tablero;
    private GestorTeclado gestorTeclado;
    private GestorTiempo gestorTiempo;
    private Pieza pieza;

    public GeneradorPiezas(Tablero tablero, GestorTeclado gestorTeclado, GestorTiempo gestorTiempo) {
        this.tablero = tablero;
        this.gestorTeclado = gestorTeclado;
        this.gestorTiempo = gestorTiempo;
    }
    
    public void crearPrimeraPieza(){
        Random random = new Random();
        
        int piezaACrear = random.nextInt(7);
        
        if(piezaACrear == 0){
            this.pieza = new PiezaRoja(this, this.tablero);
        } else if(piezaACrear == 1){
            this.pieza = new PiezaAzul(this, this.tablero);
        } else if(piezaACrear == 2){
            this.pieza = new PiezaVerde(this, this.tablero);
        } else if(piezaACrear == 3){
            this.pieza = new PiezaBlanca(this, this.tablero);
        } else if(piezaACrear == 4){
            this.pieza = new PiezaAmarilla(this, this.tablero);
        } else if(piezaACrear == 5){
            this.pieza = new PiezaVioleta(this, this.tablero);
        } else {
            this.pieza = new PiezaRosa(this, this.tablero);
        }
        if(this.pieza.situarPieza()){
            this.gestorTiempo.setPieza(pieza);
            this.gestorTeclado.setPieza(pieza);
        }
    }
    
    public void finPieza(){
        this.crearPrimeraPieza();
    }
}
