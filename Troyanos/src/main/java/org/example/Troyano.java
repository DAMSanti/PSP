// Troyano.java
package org.example;

public class Troyano extends Guerrero {
    public Troyano(String nombre, int edad, int fuerza) {
        super(nombre, edad, fuerza);
    }

    @Override
    public boolean retirarse() {
        return false;
    }
}