package prueba;

class Productor implements Runnable {
    private final Cola cola;

    public Productor(Cola cola) {
        this.cola = cola;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                cola.producir();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}