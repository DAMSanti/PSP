package org.example;

public class Main {
    public static void main(String[] args) {
        Cola cola = new Cola(200);
        Thread producerThread = new Thread(new Productor(cola));
        Thread consumerThread = new Thread(new Consumidor(cola));

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}