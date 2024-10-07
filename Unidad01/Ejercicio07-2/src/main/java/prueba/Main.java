package prueba;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        while(true) {
            System.out.println("Introduce un texto: ");
            String text = teclado.nextLine();
            if (text.equals("FIN")) {
                return;
            }

            try {
                ProcessBuilder pb = new ProcessBuilder("java", "-cp", "target/Aleatorios.jar", "aleatorios.AleatoriosHijo");
                Process process = pb.start();
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

                String line;
                while((line = reader.readLine()) != null) {
                    System.out.println("Número aleatorio: " + line);
                }
            } catch (Exception var7) {
                Exception e = var7;
                e.printStackTrace();
            }
        }
    }
}