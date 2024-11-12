// Griego.java
package org.example;

public class Griego extends Guerrero {
    public Griego(String nombre, int edad, int fuerza) {
        super(nombre, edad, fuerza);
    }

    @Override
    public boolean retirarse() {
        return isHerido() && !isMuerto();
    }
}