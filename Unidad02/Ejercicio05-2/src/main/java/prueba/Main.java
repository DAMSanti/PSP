package prueba;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Cola cola = new Cola();
        Thread producerThread = new Thread(new Productor(cola));
        Thread consumerThread = new Thread(new Consumidor(cola));
        producerThread.start();
        consumerThread.start();
        }
    }
