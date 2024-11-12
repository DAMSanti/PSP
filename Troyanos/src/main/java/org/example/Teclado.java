package org.example;

import java.util.Scanner;

public class Teclado {
    private static final Scanner scanner = new Scanner(System.in);

    public static String leerString(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public static int leerInt(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.print("Por favor, introduce un número entero: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}