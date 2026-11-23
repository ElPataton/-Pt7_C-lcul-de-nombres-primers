package com.example;

public class OldMain {

    public static void main(String[] args) {
        try {
            Tasca1 joan = new Tasca1("Joan");
            Thread t1 = new Thread(joan);

            Tasca2 pere = new Tasca2("Pere", 1, 249999);
            Tasca2 raquel = new Tasca2("Raquel", 250000, 500000);
            Thread t2 = new Thread(pere);
            Thread t3 = new Thread(raquel);

            Tasca3 maria = new Tasca3("Maria", 1, 100000);
            Tasca3 joana = new Tasca3("Joana", 100001, 200000);
            Tasca3 marc = new Tasca3("Marc", 200001, 300000);
            Tasca3 toni = new Tasca3("Toni", 300001, 400000);
            Tasca3 ana = new Tasca3("Ana", 400001, 500000);
            Thread t4 = new Thread(maria);
            Thread t5 = new Thread(joana);
            Thread t6 = new Thread(marc);
            Thread t7 = new Thread(toni);
            Thread t8 = new Thread(ana);


            long inici1 = System.currentTimeMillis();
            long inici2 = System.currentTimeMillis();
            long inici3 = System.currentTimeMillis();

            t1.start();
            t2.start();
            t3.start();
            t4.start();
            t5.start();
            t6.start();
            t7.start();
            t8.start();

            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
            t7.join();
            t8.join();

            long temps1 = joan.getFinalitzacio() - inici1;
            long temps2 = Math.max(pere.getFinalitzacio(), raquel.getFinalitzacio()) - inici2;

            long temps3 = Math.max(Math.max(maria.getFinalitzacio(), joana.getFinalitzacio()), 
            Math.max(marc.getFinalitzacio(),Math.max(toni.getFinalitzacio(), ana.getFinalitzacio()))) - inici3;


            System.out.println("\n---------- RESULTATS FINALS ----------");
            System.out.println("Temps total TASCA 1: " + temps1 + " ms");

            System.out.println("Temps total TASCA 2: " + temps2 + " ms");

            System.out.println("Temps total TASCA 3: " + temps3 + " ms");

            System.out.println("----------------------------------------");


        } catch (InterruptedException e) {

            System.out.println("Error al executar els threads" + e);

        }
    }
}
