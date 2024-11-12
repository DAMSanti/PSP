package prueba;

public class Productor extends Thread {
    private Cola cola;
    private String item;
    public Productor(Cola cola) {
        this.cola = cola;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 8; i++) {
            if(i%2==0){
                item = "PONG ";
            }else {
                item = "PING ";
            }
            try {
                cola.producir(item);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
