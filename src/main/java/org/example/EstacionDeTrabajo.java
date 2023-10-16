package org.example;

public class EstacionDeTrabajo implements Runnable {
    private final BufferCompartido buffer;
    private final String tipoComponente;
    private final int indiceEstacion;

    public EstacionDeTrabajo(BufferCompartido buffer, String tipoComponente, int indiceEstacion) {
        this.buffer = buffer;
        this.tipoComponente = tipoComponente;
        this.indiceEstacion = indiceEstacion;
    }


    @Override
    public void run() {
        try {
            for (int i = 1; i <= 100; i++) {
                Componente componente = new Componente(tipoComponente, System.currentTimeMillis());
                buffer.producir(componente);
                Thread.sleep(50); // Simulando el tiempo de producción

            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
