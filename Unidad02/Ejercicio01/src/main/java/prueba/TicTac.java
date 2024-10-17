package prueba;

public class TicTac extends Thread{
    private String palabra;

    public TicTac(String palabra) {
        this.palabra = palabra;
    }

    public void run() {
        while (true) {
            System.out.println(palabra);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
