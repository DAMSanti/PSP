package org.example;

class Cola {
    private int cantidad = 0;
    private final int capacidad;

    public Cola(int capacity) {
        this.capacidad = capacity;
    }

    public void producir() throws InterruptedException {
        while (cantidad == capacidad) {
            System.out.println("Esperando que el consumidor consuma");
        }
        cantidad++;
        System.out.println("Producido: " + cantidad);
    }

    public synchronized int consumir() throws InterruptedException {
        while (cantidad == 0) {
            System.out.println("Esperando que el productor produzca");
        }
        cantidad--;
        System.out.println("Consumido: " + cantidad);
        return cantidad;
    }

}