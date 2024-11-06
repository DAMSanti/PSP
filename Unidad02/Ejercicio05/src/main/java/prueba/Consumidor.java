package prueba;

import java.util.concurrent.Semaphore;

class Consumidor implements Runnable {
    private final Cola cola;
    private Semaphore produce;
    private Semaphore consume;
    private Semaphore mutex;

    public Consumidor(Cola cola, Semaphore produce, Semaphore consume, Semaphore mutex) {
        this.cola = cola;
        this.produce = produce;
        this.consume = consume;
        this.mutex = mutex;
    }

    @Override
    public void run() {
        for (int i = 0; i < 8; i++) {
            try {
                consume.acquire();
                mutex.acquire();
                cola.consumir();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                mutex.release();
                produce.release();
            }
        }
    }
}