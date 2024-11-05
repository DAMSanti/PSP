package org.example;

public class RecursoCompartido {
    private boolean condition = false;

    public synchronized void waitForCondition() {
        while (!condition) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted");
            }
        }
        System.out.println(Thread.currentThread().getName() + " notified");
    }

    public synchronized void changeCondition() {
        condition = true;
        notify();
    }
}
