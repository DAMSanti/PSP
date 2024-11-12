package prueba;

class Cola {
    private String texto;

    public void producir(String item) throws InterruptedException {
        texto = item;
    }

    public void consumir() throws InterruptedException {
        System.out.print(texto);
    }

}