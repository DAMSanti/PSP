package prueba;

public class Cuenta {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    private int saldo;
    private int maxSaldo;

    public Cuenta(int saldo, int maxSaldo) {
        this.saldo = saldo;
        this.maxSaldo = maxSaldo;
    }

    public void obtenerSaldo() {
        System.out.println("Saldo: " + saldo);
    }

    public synchronized void hacerIngreso(int cantidad, String nombre) {
        if (cantidad > 0) {
            if (saldo + cantidad > maxSaldo) {
                System.out.println("Se intentan ingresar " + cantidad + "€");
                System.out.println(ANSI_RED + "Error:" + ANSI_RESET + "Ingreso no válido, saldo excede el máximo permitido.");
                System.exit(1);
            } else {
                saldo += cantidad;
                System.out.println("Se intentan ingresar " + cantidad + "€");
                System.out.println(ANSI_GREEN + nombre + ": Ingreso realizado, saldo total: " + ANSI_RESET + saldo + "€" );
            }
        } else {
            System.out.println(ANSI_RED + "Error:" + ANSI_RESET + "Cantidad de ingreso no válida.");
        }
    }

    public synchronized void hacerReintegro(int cantidad, String nombre) {
        if (cantidad > 0) {
            if (saldo - cantidad < 0) {
                System.out.println("Se intentan reintegrar " + cantidad + "€");
                System.out.println(ANSI_RED + "Error:" + ANSI_RESET + "Reintegro no válido, saldo insuficiente.");
                System.exit(1);
            } else {
                saldo -= cantidad;
                System.out.println("Se intentan reintegrar " + cantidad + "€");
                System.out.println(ANSI_RED + nombre + ": Reintegro realizado, saldo total: " + ANSI_RESET + saldo + "€" + ANSI_RESET);
            }
        } else {
            System.out.println(ANSI_RED + "Error:" + ANSI_RESET + "Cantidad de reintegro no válida.");
        }
    }
}
