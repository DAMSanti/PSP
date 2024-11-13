package prueba;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta (0, 2000);
        Thread cliente1 = new Thread(new Cliente(cuenta, "Cliente 1"));
        Thread cliente2 = new Thread(new Cliente(cuenta, "Cliente 2"));
        Thread cliente3 = new Thread(new Cliente(cuenta, "Cliente 3"));
        Thread cliente4 = new Thread(new Cliente(cuenta, "Cliente 4"));

        cliente1.start();
        cliente2.start();
        cliente3.start();
        cliente4.start();
    }
}