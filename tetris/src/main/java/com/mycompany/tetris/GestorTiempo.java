package com.mycompany.tetris;

import java.util.Date;

/**
 * Gestiona el descenso de una pieza conforme pasa el tiempo
 * @author DAW
 */
public class GestorTiempo {
    private Pieza pieza;
    private long tiempo;
    
    /**
     * Crea un nuevo GestorTiempo
     */
    public GestorTiempo(){
        this.pieza = null;
        this.tiempo = new Date().getTime();
    }
    
    /**
     * Establece la pieza que va a gestionar este GestorTiempo
     * @param pieza pieza a gestionar
     */
    public void setPieza(Pieza pieza){
        this.pieza = pieza;
    }
    
    /**
     * Este método se llama cada cierto tiempo para que la pieza baje cada 500 milisegundos.
     * Si han transcurrido 500 milisegundos desde la creación de la pieza o desde la última vez que la pieza se baja la pieza se baja.
     */
    public void actualizar() throws InterruptedException{
        long tiempoActual = new Date().getTime();
        if(tiempoActual - this.tiempo >= 500){
            if(this.pieza.bajar())
                this.tiempo = tiempoActual;
            //tableroJPanel.repaint();
        }
        
        /*
        if(this.pieza.bajar()){
            Thread.sleep(500);
            this.actualizar();
        }
        */
        /*
        Date date = new Date();
        long fecha;
        int i=0;
        for (;new Date().getTime() <= date.getTime() + 60000;) {
            i++;
            while(new Date().getTime() <= date.getTime() + 100*i);
        }*/
    }
}
