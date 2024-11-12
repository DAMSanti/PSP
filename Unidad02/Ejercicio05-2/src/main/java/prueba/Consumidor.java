package prueba;

public class Consumidor extends Thread {
    private Cola cola;

    public Consumidor(Cola cola) {
        this.cola = cola;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 8; i++) {
                cola.consumir();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
