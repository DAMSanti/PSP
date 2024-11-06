package prueba;

import java.util.concurrent.Semaphore;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Cola cola = new Cola();
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