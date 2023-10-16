package org.example;

public class EstacionDeTrabajo implements Runnable {
    private final BufferCompartido buffer;
    private final String tipoComponente;
    private final int indiceEstacion;
    private final FabricaVisual visual;


    public EstacionDeTrabajo(BufferCompartido buffer, String tipoComponente, int indiceEstacion, FabricaVisual visual) {
        this.buffer = buffer;
        this.tipoComponente = tipoComponente;
        this.indiceEstacion = indiceEstacion;
        this.visual = visual;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 100; i++) {
                Componente componente = new Componente(tipoComponente, System.currentTimeMillis());
                buffer.producir(componente);
                Thread.sleep(50); // Simulando el tiempo de producción
                visual.actualizarProduccion(indiceEstacion, i);

            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
