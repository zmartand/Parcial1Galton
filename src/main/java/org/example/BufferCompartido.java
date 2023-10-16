package org.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class BufferCompartido {
    private final BlockingQueue<Componente> buffer;

    public BufferCompartido(int capacidad) {
        this.buffer = new LinkedBlockingDeque<>(capacidad);
    }
    public void producir(Componente componente) throws InterruptedException {
        buffer.put(componente);
    }
    public Componente consumir() throws InterruptedException{
        return buffer.take();
    }
    public int obtenerTamanioActual() {
        return buffer.size();
    }

}
