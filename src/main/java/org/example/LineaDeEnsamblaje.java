package org.example;

public class LineaDeEnsamblaje implements Runnable{
    private final BufferCompartido buffer;
    private final FabricaVisual visual;
    private final int[] histogramaValores = new int[10];

    public LineaDeEnsamblaje(BufferCompartido buffer, FabricaVisual visual) {
        this.buffer = buffer;
        this.visual = visual;
    }

    @Override
    public void run() {
        try{
            for (int i = 1; i <= 100; i++) {
                Componente componente = buffer.consumir();
                ensamblarMaquina(); // Método para ensamblar la máquina
                // Simular la caída de bolas en el histograma
                int index = (int) (Math.random() * 10); // Simulación de la caída
                histogramaValores[index]++;
                visual.actualizarHistograma(histogramaValores);

                visual.actualizarEnsamblaje(i);
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
