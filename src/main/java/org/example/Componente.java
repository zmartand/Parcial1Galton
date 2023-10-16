package org.example;

public class Componente {
    private final String tipo;
    private final long id;
    private final long tiempoProduccion;

    public Componente(String tipo, long id) {
        this.tipo = tipo;
        this.id = id;
        this.tiempoProduccion = System.currentTimeMillis();
    }

    public String getTipo() {
        return tipo;
    }

    public long getId() {
        return id;
    }

    public long getTiempoProduccion() {
        return tiempoProduccion;
    }
}
