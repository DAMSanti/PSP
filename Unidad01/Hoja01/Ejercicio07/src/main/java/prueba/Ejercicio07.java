package prueba;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Ejercicio07 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        while (true) {
            System.out.println("Introduce un texto: ");
            String text = teclado.nextLine();
            if (text.equals("FIN")) {
                break;
            } else {
                try {
                    ProcessBuilder pb = new ProcessBuilder("java", "-cp", "target/Ejercicio07-1.0-SNAPSHOT.jar", "prueba.ProcesoHijo");
                    Process process = pb.start();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println("Número aleatorio: " + line);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
