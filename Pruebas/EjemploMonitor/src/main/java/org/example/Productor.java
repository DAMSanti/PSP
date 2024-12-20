package org.example;

import java.util.concurrent.Semaphore;

class Productor implements Runnable {
    private final Cola cola;
    private Semaphore produce;
    private Semaphore consume;
    private Semaphore mutex;

    public Productor(Cola cola, Semaphore produce, Semaphore consume, Semaphore mutex) {
        this.cola = cola;
        this.produce = produce;
        this.consume = consume;
        this.mutex = mutex;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                produce.acquire();
                mutex.acquire();
                cola.producir();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                mutex.release();
                consume.release();
            }
        }
    }
}