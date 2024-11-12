package prueba;

public class Cola {
    private String texto;

    public synchronized void producir(String item) throws InterruptedException {
        while (texto != null) {
            wait();
        }
        texto = item;
        notify();
    }

    public synchronized void consumir() throws InterruptedException {

        while (texto == null) {
            wait();
        }
        System.out.print(texto);
        texto = null;
        notify();

        }
    }
