package org.example;

import javax.swing.*;
import java.awt.*;

public class FabricaVisual extends JFrame{
    private static final int NUM_ESTACIONES =5;
    private final JProgressBar[] estaciones = new JProgressBar[NUM_ESTACIONES];
    private final JProgressBar ensamblaje = new JProgressBar();

    public FabricaVisual(){
        setTitle("Fabrica de Campanas de Gauss");
        setSize(600,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(NUM_ESTACIONES+2,1));

        for (int i = 0; i < NUM_ESTACIONES; i++) {
            estaciones[i] = new JProgressBar();
            estaciones[i].setStringPainted(true);
            estaciones[i].setValue(0);
            add(estaciones[i]);
        }
        ensamblaje.setStringPainted(true);
        ensamblaje.setValue(0);
        add(new JLabel("Linea de Ensamblaje:"));
        add(ensamblaje);

        setVisible(true);

    }

    public void actualizarProduccion(int estacion, int valor){
        estaciones[estacion].setValue(valor);
    }

    public void actualizarEnsamblaje(int valor){
        ensamblaje.setValue(valor);
    }
}
