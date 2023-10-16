package org.example;

public class LineaDeEnsamblaje implements Runnable{
    private final BufferCompartido buffer;

    public LineaDeEnsamblaje(BufferCompartido buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try{
            for (int i = 1; i <= 100; i++) {
                Componente componente = buffer.consumir();
                ensamblarMaquina(); // Método para ensamblar la máquina
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void ensamblarMaquina(){
        //Simular el ensamblaje de la máquina con los componentes
        System.out.println("Ensamblaje de la máquina enprogreso...");
        try {
            Thread.sleep(5000); //Simular el tiempo de ensamblaje
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        System.out.println("Máquina ensamblada exitosamente!!");
    }
}
