package com.mycompany.tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 * Encapsula un objeto Tablero y un objeto TetrisGraphics
 * @author eduar
 */
public class TableroJPanel extends JPanel{
    private Tablero tablero;
    private TetrisGraphics tetrisGraphics;
    
    /**
     * Crea un objeto con la información recibida y un objeto TetrisGraphics que crea
     * @param tablero Tablero que contiene la información que se va a dibujar sobre este JPanel
     */
    public TableroJPanel(Tablero tablero){
        this.tablero = tablero;
        this.tetrisGraphics = new TetrisGraphics();
    }
    
    /**
     * Llama al método TetrisGraphics.paint con el parámetro recibido para que dibuje el contorno del tablero.
     * Llama al método Tablero.paint (TetrisGraphics) para que actualice el estado del tablero.
     * @param g Objeto Graphics sobre el que se realizan, en última instancia, todos los gráficos
     */
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        this.tetrisGraphics.paint(g2D);
        
        tablero.paint(tetrisGraphics);
        /* CODIGO PRUEBA B
        for (int i = 0; i < 10; i++) {
            this.tetrisGraphics.pintarCuadro(Color.yellow, i+5, i);
        }
        */
    }
}