package prueba;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Biblioteca implements Identificable {
    private String nombre;
    private Libro[] libros;
    private int numLibros;
    private Usuario[] usuarios;
    private Prestamo[] prestamos;
    private int maxUsuarios;
    private int maxPrestamos;

    // Constructor
    public Biblioteca(String nombre, int maxElementos) {
        this.nombre = nombre;
        this.libros = new Libro[maxElementos];
        this.numLibros = 0;
        this.usuarios = new Usuario[maxElementos];
        this.prestamos = new Prestamo[maxElementos];
        this.maxUsuarios = maxElementos;
        this.maxPrestamos = maxElementos;
    }

    // Método para agregar libros
    public boolean agregarLibro(Libro libro) {
        if (numLibros < libros.length) {
            libros[numLibros++] = libro;
            return true;
        }
        return false;
    }

    // Método para insertar usuarios
    public boolean insertarUsuario(Usuario usuario) {
        for (int i = 0; i < maxUsuarios; i++) {
            if (usuarios[i] == null) {
                usuarios[i] = usuario;
                return true;
            }
        }
        return false;
    }

    // Método para insertar préstamos
    public boolean insertarPrestamo(Prestamo prestamo) {
        for (int i = 0; i < maxPrestamos; i++) {
            if (prestamos[i] == null) {
                prestamos[i] = prestamo;
                return true;
            }
        }
        return false;
    }

    // Método para verificar si un usuario está en la biblioteca
    public boolean esUsuario(Usuario usuario) {
        for (Usuario u : usuarios) {
            if (u != null && u.equals(usuario)) {
                return true;
            }
        }
        return false;
    }

    // Método para verificar si un libro está en la biblioteca
    public boolean esLibro(Libro libro) {
        for (Libro l : libros) {
            if (l != null && l.equals(libro)) {
                return true;
            }
        }
        return false;
    }

    public boolean prestarLibro(Libro libro, Usuario usuario) {
        if (esLibro(libro) && esUsuario(usuario)) {
            for (Prestamo p : prestamos) {
                if (p != null && p.getLibro().equals(libro) && p.getFechaDevolucion() == null) {
                    return false; // El libro ya está prestado
                }
            }
            Prestamo nuevoPrestamo = new Prestamo(libro, usuario, LocalDate.now());
            return insertarPrestamo(nuevoPrestamo);
        }
        return false;
    }

    // Método para devolver un libro prestado
    public boolean devolverLibro(Libro libro, Usuario usuario) {
        for (Prestamo p : prestamos) {
            if (p != null && p.getLibro().equals(libro) && p.getUsuario().equals(usuario) && p.getFechaDevolucion() == null) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Ingrese la fecha de devolución (yyyy-MM-dd): ");
                LocalDate fechaDevolucion = LocalDate.parse(scanner.nextLine());
                if (fechaDevolucion.isAfter(p.getFechaPrestamo())) {
                    p.setFechaDevolucion(fechaDevolucion);
                    return true;
                }
            }
        }
        return false;
    }

    // Método para eliminar un libro
    public boolean eliminarLibro(Libro libro) {
        for (int i = 0; i < numLibros; i++) {
            if (libros[i].equals(libro)) {
                for (int j = i; j < numLibros - 1; j++) {
                    libros[j] = libros[j + 1];
                }
                libros[--numLibros] = null;
                return true;
            }
        }
        return false;
    }

    // Método para ordenar libros por título
    public void ordenarLibros() {
        Arrays.sort(libros, 0, numLibros, (l1, l2) -> l1.getTitulo().compareTo(l2.getTitulo()));
    }

    // Método para listar libros electrónicos de tamaño superior a tanMax
    public void listarLibrosElectronicos(float tanMax) {
        Arrays.stream(libros)
                .filter(libro -> libro instanceof LibroElectronico && ((LibroElectronico) libro).getTamanoMB() > tanMax)
                .sorted((l1, l2) -> l1.getTitulo().compareTo(l2.getTitulo()))
                .forEach(libro -> System.out.println(libro.imprime()));
    }

    // Método que devuelve los datos de la biblioteca
    public String imprime() {
        ordenarLibros();
        StringBuilder sb = new StringBuilder();
        sb.append("Biblioteca: ").append(nombre).append("\nLibros:\n");
        for (int i = 0; i < numLibros; i++) {
            sb.append(libros[i].imprime()).append("\n");
        }
        sb.append("Usuarios:\n");
        for (Usuario usuario : usuarios) {
            if (usuario != null) {
                sb.append(usuario.imprime()).append("\n");
            }
        }
        sb.append("Préstamos:\n");
        for (Prestamo prestamo : prestamos) {
            if (prestamo != null) {
                sb.append(prestamo.imprime()).append("\n");
            }
        }
        return sb.toString();
    }
}