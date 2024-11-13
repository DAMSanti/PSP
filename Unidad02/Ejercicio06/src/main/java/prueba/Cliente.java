package prueba;

public class Cliente extends Thread {
    private Cuenta cuenta;
    private String nombre;

    public Cliente(Cuenta cuenta, String nombre) {
        this.cuenta = cuenta;
        this.nombre = nombre;
    }

    public void run() {
        try {
            for (int i = 1; i < 5; i++) {
                int cantidad = (int) (Math.random() * 500 + 1);
            if (i % 2 == 0) {
                cuenta.hacerReintegro(cantidad, nombre);
            } else {
                cuenta.hacerIngreso(cantidad, nombre);
            }
                sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
