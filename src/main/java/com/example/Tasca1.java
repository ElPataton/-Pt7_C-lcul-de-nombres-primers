package com.example;

public class Tasca1 implements Runnable {

    private String nom;
    private int primers;
    private long temps;
    private long finalitzacio;

    public Tasca1(String nom) {
        this.nom = nom;
    }

    @Override
    public void run() {
        long iniciTemps = System.currentTimeMillis();
        for (int i = 1; i <= 500000; i++) {
            boolean esPrimer = true;
            if (i < 2) {
                esPrimer = false;
            } else {
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        esPrimer = false;
                        break;
                    }
                }
            }
            if (esPrimer) {
                primers++;
            }
        }
        temps = System.currentTimeMillis() - iniciTemps;
        finalitzacio = System.currentTimeMillis();
        synchronized (System.out) {
            System.out.println(nom + " ha trobat "
                    + primers + " nombres primers");
            System.out.println("Temps de " + nom + ": "
                    + temps + " ms");
            System.out.println("--------------------------------");
        }
    }

    public String getNom() {
        return nom;
    }

    public long getFinalitzacio() {
        return finalitzacio;
    }

    public int getPrimers() {
        return primers;
    }

    public long getTemps() {
        return temps;
    }
}
