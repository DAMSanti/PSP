package prueba;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("Biblioteca+DAMxx", 5);

        LibroElectronico libroElectronico1 = new LibroElectronico();

        Usuario usuario1 = new Usuario();

        System.out.println(biblioteca.agregarLibro(libroElectronico1) ? "El libro agregado " + libroElectronico1.getTitulo() + " agregado a la biblioteca" : "No se pudo agregar el libro");
        LibroPapel libroPapel1 = new LibroPapel("El vagón de mujeres", "Anita Nair", 120);
        System.out.println(biblioteca.agregarLibro(libroPapel1) ? "El libro agregado " + libroPapel1.getTitulo() + " agregado a la biblioteca" : "No se pudo agregar el libro");
        LibroElectronico libroElectronico2 = new LibroElectronico("El día de mañana", "Ignacio Martínez de Pisón", 0.5f);
        System.out.println(biblioteca.agregarLibro(libroElectronico2) ? "El libro agregado " + libroElectronico2.getTitulo() + " agregado a la biblioteca" : "No se pudo agregar el libro");

        System.out.println(biblioteca.insertarUsuario(usuario1) ? "El usuario nombre: " + usuario1.getNombre() + ", apellidos: " + usuario1.getApellidos() + " se ha insertado correctamente en la biblioteca" : "No se pudo agregar el libro");
        Usuario usuario2 = new Usuario("María", "González");
        System.out.println(biblioteca.insertarUsuario(usuario2) ? "El usuario nombre: " + usuario2.getNombre() + ", apellidos: " + usuario2.getApellidos() + " se ha insertado correctamente en la biblioteca" : "No se pudo agregar el libro");
        Usuario usuario3 = new Usuario("Ignacio", "Álvarez");
        System.out.println(biblioteca.insertarUsuario(usuario3) ? "El usuario nombre: " + usuario3.getNombre() + ", apellidos: " + usuario3.getApellidos() + " se ha insertado correctamente en la biblioteca" : "No se pudo agregar el libro");


        System.out.println(biblioteca.prestarLibro(libroElectronico1, usuario1) ? "El prestamo se ha insertado correctamente en la biblioteca" : "No se puede realizar el prestamo");
        System.out.println(biblioteca.prestarLibro(new LibroElectronico("Donde fuimos invencibles", "María Oruña", 2.2f), usuario1) ? "El prestamo se ha insertado correctamente en la biblioteca" : "No se puede realizar el prestamo");
        System.out.println(biblioteca.prestarLibro(libroElectronico2, new Usuario("Alfredo Gómez", "Gómez")) ? "El prestamo se ha insertado correctamente en la biblioteca" : "No se puede realizar el prestamo");
        System.out.println(biblioteca.prestarLibro(libroElectronico1, usuario2) ? "El prestamo se ha insertado correctamente en la biblioteca" : "No se puede realizar el prestamo");

        System.out.println(biblioteca.devolverLibro(libroElectronico1, usuario1) ? "El libro devuelto correctamente" : "No se puede devolver el libro");
        System.out.println(biblioteca.devolverLibro(libroElectronico2, usuario3) ? "El libro devuelto correctamente" : "No se puede devolver el libro");

        System.out.println(biblioteca.eliminarLibro(libroPapel1) ? "El libro eliminado correctamente" : "No se puede eliminar el libro");
        System.out.println(biblioteca.eliminarLibro(new LibroElectronico("Donde fuimos invencibles", "María Oruña", 2.2f)) ? "El libro eliminado correctamente" : "No se puede eliminar el libro");

        System.out.println("Listado de libros electrónicos de tamaño superior a 0.4MB:");
        biblioteca.listarLibrosElectronicos(0.4f);

        System.out.println("Datos de la biblioteca:");
        System.out.println(biblioteca.imprime());
    }
}