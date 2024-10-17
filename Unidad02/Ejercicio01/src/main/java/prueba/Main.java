package prueba;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*Thread t1 = new Thread(new TicTac("TIC"));
        Thread t2 = new Thread(new TicTac("TAC"));
        t1.start();
        t2.start();*/
        Thread t3 = new Thread(new TicTacRunnable("TIC"));
        Thread t4 = new Thread(new TicTacRunnable("TAC"));
        t3.start();
        t4.start();
    }


}

/*


Crea dos clases (hilos) en Java que extiendan la clase Thread. Uno de los hilos
debe visualizar en pantalla en un bucle infinito la palabra TIC y el otro hilo la
palabra TAC. Dentro del bucle usa el método sleep para que nos dé tiempo a ver
las palabras que se escriben cuando se ejecute, tendrás que añadir un bloque trycatch (para capturar la excepción InterruptedException). Crea después la función
main que haga uso de los hilos anteriores y comprueba si se visualizan los textos
TIC TAC de forma ordenada, es decir (TIC TAC TIC TAC …) sin usar ninguna
herramienta de sincronización.
Realiza el mismo proceso implementando “Runnable” y observa las diferencias.


 */