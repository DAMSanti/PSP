package org.example;

import java.io.*;
import java.util.Scanner;

public class Main {
    static int[] puntuacion = new int[2]; // Array que representa el marcador del partido
    static boolean salir = false; // boolean para indicar cuando hemos terminado

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        Process process = null;
        String comando = "java -jar Aleatorio.jar"; // comando a ejecutar el archivo aleatorio.jar en la carpeta raiz de nuestro proyecto
        System.out.println("Introduce lineas de texto (cuando un equipo llegue a 3 o se escriba fin, finalizará)"); // la pongo fuera como en tu ejemplo, que no se repita todas las veces
        while (!salir) {
            String input = new Scanner(System.in).nextLine(); // para recepciond e datos por teclado
            if (input.equalsIgnoreCase("fin")) { // comprobamos que el usuario no quiera salir
                salir = true;
                continue;
            }
            try {
                process = runtime.exec(comando); // ejecutamos la aplicacion aleatorios.jar
                OutputStream os = process.getOutputStream();
                BufferedReader br = null;
                String[] resultados = new String[2]; // array que representa los resultados aleatorios para rojo y azul
                for (int i = 0; i < 2; i++) {
                    os.write((input + "\n").getBytes()); // enviamos al hijo el texto introducido
                    os.flush();
                    InputStream is = process.getInputStream(); // recogemos la respuesta del hijo
                    br = new BufferedReader(new InputStreamReader(is)); // la guardamos en un buffered reader
                    resultados[i] = br.readLine(); // y la metemos como resultado del equipo correspondiente
                }
                System.out.println("Puntuación azul: " + resultados[0] + " | Puntuación roja: " + resultados[1]);
                compruebaResultado(resultados); // metodo para comprobar quien de los dos gana
                System.out.println("Marcador - Equipo azul: " + puntuacion[0] + " | Equipo rojo: " + puntuacion[1]);
                os.write(("fin\n").getBytes()); // enviamos al hijo para cerrar
                os.flush();
                br.close();
            } catch (Exception e) { // control de excepciones
                System.out.println("Excepción!!");
                e.printStackTrace();
                System.exit(-1);
            }
        }
        System.out.println("Partido finalizado --> Equipo azul: " + puntuacion[0] + " | Equipo rojo: " + puntuacion[1]); // cuando termine el partido nos dara los resultados.
    }


    /////////////////////////////////////////////////////////////////
    /// METODO PARA COMPROBAR QUE RESULTADO HA SIDO MAYOR
    /// out:
    /// in: Array con los resultados aleatorios obtenidos del hijo
    /////////////////////////////////////////////////////////////////
    public static void compruebaResultado(String[] resultado) {
        if (Integer.parseInt(resultado[0]) > Integer.parseInt(resultado[1])) { // Ha ganado el azul?
            puntuacion[0] += 1;
            System.out.println("Ha ganado el equipo azul.");
        } else if (Integer.parseInt(resultado[1]) > Integer.parseInt(resultado[0])) { // O ha ganado el rojo?
            puntuacion[1] += 1;
            System.out.println("Ha ganado el equipo rojo.");
        } else { // quizas haya sido un empate
            System.out.println("Ha sido empate!!");
        }
        if (puntuacion[0] >= 3 || puntuacion[1] >= 3) { // Comprobamos si alguno llega a 3 para terminar el partido.
            salir = true;
        }
    }
}