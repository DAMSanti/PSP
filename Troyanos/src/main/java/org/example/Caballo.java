package org.example;

import java.util.Arrays;

public class Caballo implements Montarse {
    public final int capacidad;
    public int ocupacion;
    public Guerrero[] ocupantes;

    public Caballo(Guerrero[] guerreros) {
        boolean todosGriegos = Arrays.stream(guerreros).allMatch(g -> g instanceof Griego);
        if (todosGriegos) {
            this.capacidad = guerreros.length;
            this.ocupacion = guerreros.length;
            this.ocupantes = guerreros;
        } else {
            this.capacidad = 100;
            this.ocupacion = 0;
            this.ocupantes = new Guerrero[0];
        }
    }

    public Caballo(Guerrero guerrero, int capacidad) {
        if (guerrero instanceof Griego) {
            this.capacidad = capacidad;
            this.ocupacion = 1;
            this.ocupantes = new Guerrero[]{guerrero};
        } else {
            this.capacidad = capacidad;
            this.ocupacion = 0;
            this.ocupantes = new Guerrero[0];
        }
    }

    public void ordenar() {
        Arrays.sort(ocupantes, (a, b) -> Integer.compare(b.getFuerza(), a.getFuerza()));
    }

    public int buscar(String nombre) {
        ordenar();
        for (int i = 0; i < ocupacion; i++) {
            if (ocupantes[i].getNombre().equals(nombre)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int montar(Guerrero g) {
        if (ocupacion >= capacidad) {
            return -1;
        }
        if (!(g instanceof Griego)) {
            return -2;
        }
        ocupantes = Arrays.copyOf(ocupantes, ocupacion + 1);
        ocupantes[ocupacion++] = g;
        return ocupacion;
    }

    @Override
    public void desmontar() {
        ocupacion = 0;
        ocupantes = new Guerrero[0];
    }
}