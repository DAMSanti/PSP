package prueba;

public class Cola {
    private int numero;
    private boolean disponible = false; //inicialmente cola vacia
    public synchronized int get() {
        while (!disponible) { //hay numero en la cola?
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        disponible = false; //cola vacia
        notify();
        return numero; //se devuelve
    }

    public synchronized void put (int valor) {
        while (disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        numero = valor; //coloca valor en la cola
        disponible = true; //disponible para consumir, cola llena
        notify();
    }
}