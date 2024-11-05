package prueba;

import java.util.Scanner;

public class LibroPapel extends Libro {
    private int numeroPaginas;

    // Constructor por defecto
    public LibroPapel() {
        super();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de páginas: ");
        this.numeroPaginas = scanner.nextInt();
    }

    // Constructor con parámetros
    public LibroPapel(String titulo, String autor, int numeroPaginas) {
        super(titulo, autor);
        this.numeroPaginas = numeroPaginas;
    }

    // Getters y setters
    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    // Implementación del método imprime
    @Override
    public String imprime() {
        return super.imprime() + ", Número de páginas: " + numeroPaginas;
    }
}