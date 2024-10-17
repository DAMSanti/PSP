package prueba;

public class Cola {
    private int numero;
    private boolean disponible = false; //inicialmente cola vacia
    public int get() {
        if (disponible) { //hay numero en la cola?
            //disponible = false; //se pone cola vacia
            numero--;
            return numero; //se devuelve
        }
        return (-1); //no hay numero disponible, cola vacia
    }
    public void put (int valor) {
        numero = valor; //coloca valor en la cola
        disponible = true; //disponible para consumir, cola llena
    }
}