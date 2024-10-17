package org.example;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime(); /// Recuperamos la rutina actual
        Process process = null; /// Definimos un proceso
        if (args.length < 0) {
            System.out.println("Debes introducir al menos un comando");
        } else if (args.length > 10) {
            System.out.println("No debes introducir mas de 10 comandos");
        } else {
            for (int i=0; i < args.length; i++) {
                try {
                    System.out.println("Ejecutando el comando: " + args[i]); // Mostramos un mensaje con el comando
                    process = runtime.exec(args[i]); /// Ejecutamos el comando
                    InputStream is = process.getInputStream(); /// Recuperamos la salida del proceso
                    BufferedReader br = new BufferedReader(new InputStreamReader(is)); /// Creamos un buffer de lectura
                    String linea;
                    while ((linea = br.readLine()) != null) /// Leemos la salida del proceso
                        System.out.println(linea); /// Imprimimos la salida
                    br.close();
                } catch (Exception ex) { /// Capturamos cualquier excepción
                    System.err.println("Excepción de E / S !!");
                    System.exit(-1);
                }
            }
        }
    }
}