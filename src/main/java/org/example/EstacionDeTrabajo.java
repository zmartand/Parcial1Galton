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
        
    }
}
