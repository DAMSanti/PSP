package prueba;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        Process process = null;
        String comando = "java -jar Aleatorio.jar";
        boolean salir = false;

        while (!salir) {
            System.out.print("Escribe un texto: ");
            String input = new Scanner(System.in).nextLine();

            if (input.equals("FIN")) {
                salir = true;
                continue;
            }

            try {
                process = runtime.exec(comando);
                OutputStream os = process.getOutputStream();
                os.write((input + "\n").getBytes());
                os.flush();

                InputStream is = process.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line = br.readLine();

              // while ((line = br.readLine()) != null) {
                    System.out.println("Número aleatorio: " + line);
               //}
                System.out.println("Fin de la ejecución");

                br.close();
            } catch (Exception e) {
                System.err.println("Excepción de E/S!!");
                System.exit(-1);
            }
        }
    }
}