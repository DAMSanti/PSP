package prueba;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Ejercicio05 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("No se proporcionaron comandos para ejecutar.");
            System.exit(1);
        }
        if  (args.length > 10) {
            System.err.println("No ejecutaremos mas de 10 programas.");
            System.exit(1);
        }
        Runtime runtime = Runtime.getRuntime();
        int estado = 0;
        try {
            for (String comando : args) {
                Process process = runtime.exec(comando);
                estado += process.waitFor();
            }
            if (estado == 0)
                System.out.println("Aplicación finalizada");
        } catch (Exception ex) {
            System.err.println("Excepción de E/S!!");
            System.exit(-1);
        }
    }
}