package org.example;

import javax.swing.plaf.PanelUI;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;

public class BufferCompartido {
    private final BlockingQueue<Componente> buffer;
    public Semaphore semProductor = new Semaphore(10);
    public Semaphore semConsumidor = new Semaphore(0);

    public BufferCompartido(int capacidad) {
        this.buffer = new LinkedBlockingDeque<>(capacidad);
    }
    public void producir(Componente componente) throws InterruptedException {
        semProductor.acquire();
        buffer.put(componente);
        semConsumidor.release();
    }
    public Componente consumir() throws InterruptedException{
        semConsumidor.acquire();
        Componente componente = buffer.take();
        semProductor.release();
        return componente;
    }
    public int obtenerTamanioActual() {
        return buffer.size();
    }

}
