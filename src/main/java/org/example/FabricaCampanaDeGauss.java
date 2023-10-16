package org.example;import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FabricaCampanaDeGauss {
    private static final int NUM_ESTACIONES = 5;

    public static void main(String[] args) {
        FabricaVisual visual = new FabricaVisual();
        BufferCompartido buffer = new BufferCompartido(10);

        String[] tiposComponentes = {"TipoA", "TipoB", "TipoC", "TipoD", "TipoE"};
        ExecutorService executor = Executors.newFixedThreadPool(NUM_ESTACIONES + 1);
        for (int i = 0; i < NUM_ESTACIONES; i++) {
            executor.execute(new EstacionDeTrabajo(buffer, tiposComponentes[i], visual, i));
        }
        executor.execute(new LineaDeEnsamblaje(buffer, visual));
        executor.shutdown();

    }
}
