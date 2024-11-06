package prueba;

class Cola {
    private int cantidad = 0;
    private final int capacidad;

    public Cola(int capacity) {
        this.capacidad = capacity;
    }

    public synchronized void producir() throws InterruptedException {
        while (cantidad == capacidad) {
            System.out.println("Esperando que el consumidor consuma");
            wait();
        }
        cantidad++;
        System.out.println("Producido: " + cantidad);
        notifyAll();
    }

    public synchronized int consumir() throws InterruptedException {
        while (cantidad == 0) {
            System.out.println("Esperando que el productor produzca");
            wait();
        }
        cantidad--;
        System.out.println("Consumido: " + cantidad);
        notifyAll();
        return cantidad;
    }
}