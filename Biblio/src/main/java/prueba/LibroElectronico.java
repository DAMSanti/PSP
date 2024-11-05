package prueba;

import java.util.Scanner;

public class LibroElectronico extends Libro {
    private float tamanoMB;

    // Constructor por defecto
    public LibroElectronico() {
        super();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el tamaño en MB: ");
        this.tamanoMB = scanner.nextFloat();
    }

    // Constructor con parámetros
    public LibroElectronico(String titulo, String autor, float tamanoMB) {
        super(titulo, autor);
        this.tamanoMB = tamanoMB;
    }

    // Getters y setters
    public float getTamanoMB() {
        return tamanoMB;
    }

    public void setTamanoMB(float tamanoMB) {
        this.tamanoMB = tamanoMB;
    }

    // Implementación del método imprime
    @Override
    public String imprime() {
        return super.imprime() + ", Tamaño en MB: " + tamanoMB;
    }
}