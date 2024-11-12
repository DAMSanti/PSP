package prueba;

import java.util.concurrent.Semaphore;

class Productor implements Runnable {
    private final Cola cola;
    private Semaphore produce;
    private Semaphore consume;
    private Semaphore mutex;
    private boolean toggle = true;

    public Productor(Cola cola, Semaphore produce, Semaphore consume, Semaphore mutex) {
        this.cola = cola;
        this.produce = produce;
        this.consume = consume;
        this.mutex = mutex;
    }

    @Override
    public void run() {
        for (int i = 0; i < 8; i++) {
            try {
                produce.acquire();
                mutex.acquire();
                String item = toggle ? "PING " : "PONG ";
                cola.producir(item);
                toggle = !toggle;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                mutex.release();
                consume.release();
            }
        }
    }
}