package org.example;

import javax.swing.*;
import java.awt.*;

public class FabricaVisual extends JFrame{
    private static final int NUM_ESTACIONES =5;
    private final JProgressBar[] estaciones = new JProgressBar[NUM_ESTACIONES];
    private final JProgressBar ensamblaje = new JProgressBar();
    private final JPanel histogramaPanel = new JPanel(new GridLayout(1,10));

    public FabricaVisual(){
        setTitle("Fabrica de Campanas de Gauss");
        setSize(800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(NUM_ESTACIONES+4,1));

        for (int i = 0; i < NUM_ESTACIONES; i++) {
            estaciones[i] = new JProgressBar();
            estaciones[i].setStringPainted(true);
            estaciones[i].setValue(0);
            add(estaciones[i]);
        }
        ensamblaje.setStringPainted(true);
        ensamblaje.setValue(0);
        ensamblaje.setForeground(Color.BLUE);
        add(new JLabel("Linea de Ensamblaje:"));
        add(ensamblaje);
        //Añadir histograma para visualizacion de distribucion normal
        for (int i = 0; i < 10; i++) {
            JProgressBar barra = new JProgressBar(JProgressBar.VERTICAL);
            barra.setStringPainted(true);
            barra.setForeground(Color.GREEN);
            histogramaPanel.add(barra);
        }
        add(new JLabel("Distribucion de Bolas (Campana de Gauss):"));
        add(histogramaPanel);
        setVisible(true);

    }

    public void actualizarProduccion(int estacion, int valor){
        estaciones[estacion].setValue(valor);
    }

    public void actualizarEnsamblaje(int valor){
        ensamblaje.setValue(valor);
    }
    public void actualizarHistograma(int[] valores){
        for (int i = 0; i < 10; i++) {
            JProgressBar barra = (JProgressBar) histogramaPanel.getComponent(i);
            barra.setValue(valores[i]);
        }
    }
}
