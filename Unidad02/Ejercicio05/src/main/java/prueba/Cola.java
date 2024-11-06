package prueba;

import java.util.LinkedList;
import java.util.Queue;

class Cola {
    private String texto;

    public void producir(String item) throws InterruptedException {
        texto = item;
    }

    public void consumir() throws InterruptedException {
        System.out.print(texto);
    }

}