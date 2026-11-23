package com.example;

public class Main {
    private static final int REPETICIONS = 5;

    public static void main(String[] args) throws InterruptedException {
        long tempsTotalTasca1 = 0;
        long tempsTotalTasca2 = 0;
        long tempsTotalTasca3 = 0;

        System.out.println("\n-------- TASCA 1 --------");
        for (int i = 0; i < REPETICIONS; i++) {
            Tasca1 tasca = new Tasca1("Joan");
            Thread fil = new Thread(tasca);
            long inici = System.currentTimeMillis();

            fil.start();
            fil.join();
            long temps = System.currentTimeMillis() - inici;
            tempsTotalTasca1 += temps;
            System.out.println("Repetició " + (i + 1)+ " - Temps total: " + temps + " ms\n");
            System.out.println("--------------------------------");
        }
        System.out.println("\n-------- TASCA 2 --------");
        for (int i = 0; i < REPETICIONS; i++) {
            Tasca2 pere = new Tasca2("Pere", 1, 250000);
            Tasca2 raquel = new Tasca2("Raquel", 250000, 500001);
            Thread filPere = new Thread(pere);
            Thread filRaquel = new Thread(raquel);
            long inici = System.currentTimeMillis();

            filPere.start();
            filRaquel.start();
            filPere.join();
            filRaquel.join();
            long temps = System.currentTimeMillis() - inici;
            tempsTotalTasca2 += temps;
            System.out.println("Repetició " + (i + 1)+ " - Temps total: " + temps + " ms\n");
            System.out.println("--------------------------------");

        }

        System.out.println("\n-------- TASCA 3 --------");
        for (int i = 0; i < REPETICIONS; i++) {
            Tasca3 maria = new Tasca3("Maria", 1, 100000);
            Tasca3 joana = new Tasca3("Joana", 100000, 200000);
            Tasca3 marc = new Tasca3("Marc", 200000, 300000);
            Tasca3 toni = new Tasca3("Toni", 300000, 400000);
            Tasca3 ana = new Tasca3("Ana", 400000, 500001);
            Thread filMaria = new Thread(maria);
            Thread filJoana = new Thread(joana);
            Thread filMarc = new Thread(marc);
            Thread filToni = new Thread(toni);
            Thread filAna = new Thread(ana);
            long inici = System.currentTimeMillis();

            filMaria.start();
            filJoana.start();
            filMarc.start();
            filToni.start();
            filAna.start();
            filMaria.join();
            filJoana.join();
            filMarc.join();
            filToni.join();
            filAna.join();
            long temps = System.currentTimeMillis() - inici;
            tempsTotalTasca3 += temps;
            System.out.println("Repetició " + (i + 1)+ " - Temps total: " + temps + " ms\n");
            System.out.println("--------------------------------");
        }

        System.out.println("\n-------- RESULTATS --------");
        System.out.println("\nTASCA 1:");
        System.out.println("Mitjana del temps total: "+ (tempsTotalTasca1 / 5.0) + " ms");

        System.out.println("\nTASCA 2:");
        System.out.println("Mitjana del temps total: "+ (tempsTotalTasca2 / 5.0) + " ms");

        System.out.println("\nTASCA 3:");
        System.out.println("Mitjana del temps total: "+ (tempsTotalTasca3 / 5.0) + " ms");
    }
}
