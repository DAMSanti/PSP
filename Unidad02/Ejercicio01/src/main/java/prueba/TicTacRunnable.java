package prueba;

public class TicTacRunnable implements Runnable {
    private String palabra;

    public TicTacRunnable(String palabra) {
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
