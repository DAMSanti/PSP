package org.example;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Cola cola = new Cola(1);
        Semaphore produce = new Semaphore(1);
        Semaphore consume = new Semaphore(0);
        Semaphore mutex = new Semaphore(1);
        Thread producerThread = new Thread(new Productor(cola, produce, consume, mutex));
        Thread consumerThread = new Thread(new Consumidor(cola, produce, consume, mutex));


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