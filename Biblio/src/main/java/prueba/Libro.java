package prueba;

import java.util.Scanner;

public abstract class Libro implements Identificable {
    private String titulo;
    private String autor;

    // Constructor por defecto
    public Libro() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el título del libro: ");
        this.titulo = scanner.nextLine();
        System.out.print("Ingrese el autor del libro: ");
        this.autor = scanner.nextLine();
    }

    // Constructor con parámetros
    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    // Getters y setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String imprime() {
        return "Título: " + titulo + ", Autor: " + autor;
    }
}