package prueba;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Ejercicio04 {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        String comando = args[0];
        int estado = 0;
        try {
            Process process = runtime.exec(comando);
            if (process.waitFor() == 0)
                System.out.println("Aplicación finalizada");
        } catch (Exception ex) {
            System.err.println("Excepción de E/S!!");
            System.exit(-1);

        }
    }
}