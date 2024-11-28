package com.mycompany.tetris;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class Tetris {

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Tetris");
        /*Apartado C*/
        Tablero tableroUno = new Tablero();
        Tablero tableroDos = new Tablero();
        /**/
        TableroJPanel tableroJPanelUno = new TableroJPanel(tableroUno);
        TableroJPanel tableroJPanelDos = new TableroJPanel(tableroDos);
        GridLayout gridLayout = new GridLayout(1, 2);
        frame.setLayout(gridLayout);
        frame.add(tableroJPanelUno);
        frame.add(tableroJPanelDos);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        tableroJPanelUno.repaint();
        tableroJPanelDos.repaint();
        
        
        GestorTeclado gestorTecladoUno = new GestorTeclado(KeyEvent.VK_A, KeyEvent.VK_S, KeyEvent.VK_D, KeyEvent.VK_SPACE, KeyEvent.VK_W);
        GestorTiempo gestorTiempoUno = new GestorTiempo();
        GeneradorPiezas generadorPiezasUno = new GeneradorPiezas(tableroUno, gestorTecladoUno, gestorTiempoUno);
        generadorPiezasUno.crearPrimeraPieza();
        frame.addKeyListener(gestorTecladoUno);
        
        //GestorTeclado gestorTecladoDos = new GestorTeclado('j', 'k', 'l', 'm', 'i');
        GestorTeclado gestorTecladoDos = new GestorTeclado(KeyEvent.VK_LEFT, KeyEvent.VK_DOWN, KeyEvent.VK_RIGHT, KeyEvent.VK_UP, KeyEvent.VK_SHIFT);
        GestorTiempo gestorTiempoDos = new GestorTiempo();
        GeneradorPiezas generadorPiezasDos = new GeneradorPiezas(tableroDos, gestorTecladoDos, gestorTiempoDos);
        generadorPiezasDos.crearPrimeraPieza();
        frame.addKeyListener(gestorTecladoDos);
        
        while(true){
            gestorTiempoUno.actualizar();
            gestorTiempoDos.actualizar();
            tableroJPanelUno.repaint();
            tableroJPanelDos.repaint();
        }

        /*
        for (int i = 0; i < 3000; i++) {
            Thread.sleep(20);
        }
        */
        
        
                
        // APARTADO E        
        /*
        Pieza pieza = new PiezaAmarilla(tableroUno);
        pieza.situarPieza();
        tableroJPanelUno.repaint();
        Thread.sleep(200);
        for (int i = 0; i < 2; i++) { pieza.bajar(); tableroJPanelUno.repaint(); Thread.sleep(200);} 
        for (int i = 0; i < 10; i++) { pieza.rotarDerecha(); tableroJPanelUno.repaint(); Thread.sleep(200);} 
        for (int i = 0; i < 5; i++) { pieza.rotarIzquierda(); tableroJPanelUno.repaint(); Thread.sleep(200);} 
        for (int i = 0; i < 10; i++) { pieza.derecha(); tableroJPanelUno.repaint(); Thread.sleep(200);} 
        for (int i = 0; i < 10; i++) { pieza.izquierda(); tableroJPanelUno.repaint(); Thread.sleep(200);} 
        while(pieza.bajar()){ tableroJPanelUno.repaint(); Thread.sleep(200); }
        
        pieza = new PiezaVerde(tableroUno);
        pieza.situarPieza();
        tableroJPanelUno.repaint();
        Thread.sleep(200);
        for (int i = 0; i < 5; i++) { pieza.izquierda(); tableroJPanelUno.repaint(); Thread.sleep(200); }
        while(pieza.bajar()){ tableroJPanelUno.repaint(); Thread.sleep(200); }
        */
        
        // APARTADO C
        /*
        int[][] pieza = new int[][]{{0,3},{0,4},{0,5},{1,4}};
        Color colorPieza = Color.YELLOW;
        
        for(int numeroPieza=0; numeroPieza<2; numeroPieza++){
            tableroUno.situarPieza(colorPieza, pieza);
            tableroJPanelUno.repaint();
            Thread.sleep(500);
            
            int[][] nuevaPosicion;
            nuevaPosicion = new int[pieza.length][2];
            for (int i = 0; i < pieza.length; i++) {
                nuevaPosicion[i][0] = pieza[i][0]+1;
                nuevaPosicion[i][1] = pieza[i][1];
            }
            while(tableroUno.espacioDisponible(nuevaPosicion)){
                tableroUno.cambiarPieza(colorPieza, pieza, nuevaPosicion);
                tableroJPanelUno.repaint();
                Thread.sleep(500);
                pieza=nuevaPosicion;
                nuevaPosicion = new int[pieza.length][2];
                for (int i = 0; i < pieza.length; i++) {
                    nuevaPosicion[i][0] = pieza[i][0]+1;
                    nuevaPosicion[i][1] = pieza[i][1];
                }
            }
            tableroUno.fijarPieza(colorPieza, pieza);
            tableroJPanelUno.repaint();
            
            pieza = new int[][]{{0,3},{0,4},{0,5},{1,5}};
            colorPieza = Color.GREEN;
        }
        */
    }
}