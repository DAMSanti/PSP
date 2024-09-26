package prueba;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Ejercicio02 {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        String comando = "CALC";
        int estado;
        try {
            Process process = runtime.exec(comando);
            estado = process.waitFor();
            if (estado == 0) {
                System.out.println("El proceso hijo ha terminado con estado " + estado);
            }
        } catch (Exception ex) {
            System.err.println("Excepción de E/S!!");
            System.exit(-1);

        }
    }
}