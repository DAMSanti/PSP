package org.example;

public abstract class Guerrero implements Comparable<Guerrero> {
    private final String nombre;
    private int edad;
    private int fuerza;
    private boolean herido;
    private boolean muerto;

    public Guerrero(String nombre, int edad, int fuerza) {
        this.nombre = nombre;
        if (comprobarEdad(edad) && comprobarFuerza(fuerza)) {
            this.edad = edad;
            this.fuerza = fuerza;
        } else {
            this.edad = 25;
            this.fuerza = 5;
        }
        this.herido = false;
        this.muerto = false;
    }

    public Guerrero() {
        this("guerreroX", 15, 1);
    }

    public Guerrero(Guerrero otro, String nombre) {
        this(nombre, otro.edad, otro.fuerza);
        this.herido = otro.herido;
        this.muerto = otro.muerto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (comprobarEdad(edad)) {
            this.edad = edad;
        }
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        if (comprobarFuerza(fuerza)) {
            this.fuerza = fuerza;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isHerido() {
        return herido;
    }

    public void setHerido(boolean herido) {
        this.herido = herido;
    }

    public boolean isMuerto() {
        return muerto;
    }

    public void setMuerto(boolean muerto) {
        this.muerto = muerto;
    }

    protected static boolean comprobarEdad(int e) {
        return e >= 15 && e <= 60;
    }

    protected static boolean comprobarFuerza(int f) {
        return f >= 1 && f <= 10;
    }

    @Override
    public int compareTo(Guerrero otro) {
        return Integer.compare(this.fuerza, otro.fuerza);
    }

    public abstract boolean retirarse();
}