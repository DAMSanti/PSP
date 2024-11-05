package org.example;

class Consumidor implements Runnable {
    private final Cola cola;

    public Consumidor(Cola cola) {
        this.cola = cola;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                cola.consumir();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}