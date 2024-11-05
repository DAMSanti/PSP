package prueba;


import java.util.Scanner;

public class Usuario {
    private String nombre;
    private String apellidos;

    // Constructor por defecto
    public Usuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre: ");
        this.nombre = scanner.nextLine();
        System.out.print("Ingrese los apellidos: ");
        this.apellidos = scanner.nextLine();
    }

    // Constructor con parámetros
    public Usuario(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    // Método que devuelve los datos del usuario
    public String imprime() {
        return "Nombre: " + nombre + ", Apellidos: " + apellidos;
    }
}