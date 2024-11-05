package org.example;

public class Main {
    public static void main(String[] args) {
        RecursoCompartido sharedResource = new RecursoCompartido();

        Runnable waitingTask = () -> {
            System.out.println(Thread.currentThread().getName() + " waiting");
            sharedResource.waitForCondition();
        };

        Thread thread1 = new Thread(waitingTask, "Thread 1");
        Thread thread2 = new Thread(waitingTask, "Thread 2");

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(1000); // Espera para asegurar que los hilos estén esperando
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Main thread changing condition");
        sharedResource.changeCondition();
    }
}