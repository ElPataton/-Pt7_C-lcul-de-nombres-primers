package com.example;

public class Tasca2 implements Runnable {

    private String nom;
    private int inici;
    private int fi;
    private int primers;
    private long temps;
    private long finalitzacio;

    public Tasca2(String nom, int inici, int fi) {
        this.nom = nom;
        this.inici = inici;
        this.fi = fi;
    }

    @Override
    public void run() {
        long iniciTemps = System.currentTimeMillis();
        for (int i = inici; i <= fi; i++) {
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

    public int getPrimers() {
        return primers;
    }

    public long getTemps() {
        return temps;
    }

    public long getFinalitzacio() {
        return finalitzacio;
    }
}
