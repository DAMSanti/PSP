package org.example;

import java.util.ArrayList;
import java.util.List;

public class Gallinero {
    private List<Gallina> gallinas;

    public Gallinero(int numeroDeGallinas) {
        gallinas = new ArrayList<>();
        for (int i = 0; i < numeroDeGallinas; i++) {
            gallinas.add(new Gallina());
        }
    }

    public void simularAno() {
        int huevosRecogidos = 0;
        int huevosPerdidos = 0;

        for (Gallina gallina : gallinas) {
            gallina.start();
        }

        for (Gallina gallina : gallinas) {
            try {
                gallina.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Gallina gallina : gallinas) {
            huevosPerdidos += gallina.getHuevosPerdidos();
            huevosRecogidos += gallina.getHuevosRecogidos();
        }

        System.out.println("Huevos recogidos en un año: " + huevosRecogidos);
        System.out.println("Huevos perdidos en un año: " + huevosPerdidos);
    }
}