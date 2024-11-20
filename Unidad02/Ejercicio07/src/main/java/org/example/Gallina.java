package org.example;

import java.util.Random;

public class Gallina extends Thread {
    private boolean huevoPresente;
    private Random random;
    private int huevosPerdidos;
    private int huevosRecogidos;

    public Gallina() {
        this.huevoPresente = false;
        this.random = new Random();
        this.huevosPerdidos = 0;
        this.huevosRecogidos = 0;
    }

    public int getHuevosPerdidos() {
        return huevosPerdidos;
    }

    public int getHuevosRecogidos() {
        return huevosRecogidos;
    }

    public synchronized boolean ponerHuevo() {
        if (huevoPresente) {
            huevosPerdidos++;
            return false;
        } else {
            huevoPresente = true;
            return true;
        }
    }

    public synchronized boolean recogerHuevo() {
        if (huevoPresente) {
            huevoPresente = false;
            huevosRecogidos++;
            return true;
        }
        return false;
    }

    @Override
    public void run() {
        for (int dia = 0; dia < 365; dia++) {
            for (int hora = 0; hora < 24; hora++) {
                if (random.nextInt(24) == hora) {
                    ponerHuevo();
                    System.out.println("Huevo puesto a las " + hora + " horas del día " + dia);
                }
                if (hora == 12) {
                    synchronized (this) {
                        recogerHuevo();
                    }
                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}