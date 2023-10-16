package org.example;

public class Componente {
    private final String tipo;
    private final long id;
    private final long tiempoProduccion;

    public Componente(String tipo, long id, long tiempoProduccion) {
        this.tipo = tipo;
        this.id = id;
        this.tiempoProduccion = tiempoProduccion;
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
