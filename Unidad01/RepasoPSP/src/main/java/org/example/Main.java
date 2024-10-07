package org.example;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime(); /// Recuperamos la rutina actual
        Process process = null; /// Definimos un proceso
        String comando = "cmd /c ipconfig /all"; /// Comando a ejecutar
        try {
            process = runtime.exec(comando); /// Ejecutamos el comando
            InputStream is = process.getInputStream(); /// Recuperamos la salida del proceso
            BufferedReader br = new BufferedReader(new InputStreamReader(is)); /// Creamos un buffer de lectura
            String linea;
            while ((linea = br.readLine()) != null) /// Leemos la salida del proceso
                System.out.println(linea); /// Imprimimos la salida
            br.close();
        } catch (Exception ex) { /// Capturamos cualquier excepción
            System.err.println("Excepción de E/S!!");
            System.exit(-1);
        }
    }
}

class Main2 {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        Process process;
        if (args.length > 0) {
            String comando = args[0];
            try {
                process = runtime.exec(comando);
                int exitval = process.waitFor();
                if (exitval == 0) {
                    System.out.println("El proceso hijo ha terminado con estado ");
                }
            } catch (Exception ex) {
                System.err.println("Excepción de E/S!!");
                System.exit(-1);
            }
        }
    }
}