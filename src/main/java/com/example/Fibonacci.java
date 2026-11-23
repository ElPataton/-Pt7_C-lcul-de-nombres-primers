package com.example;


public class Fibonacci {

    public static void fibonacci(String[] args) throws InterruptedException {

        Fibo fil1 = new Fibo(19);
        Fibo fil2 = new Fibo(18);

        Thread t1 = new Thread(fil1);
        Thread t2 = new Thread(fil2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        int resultat = fil1.getResultat() + fil2.getResultat();

        System.out.println("El terme 20 de Fibonacci és: " + resultat);
    }
}

class Fibo implements Runnable {

    private int terme;
    private int resultat;

    public Fibo(int terme) {
        this.terme = terme;
    }

    @Override
    public void run() {
        resultat = calcularFibonacci(terme);
    }

    private int calcularFibonacci(int n) {

        if (n <= 1) {
            return n;
        }

        return calcularFibonacci(n - 1) + calcularFibonacci(n - 2);
    }

    public int getResultat() {
        return resultat;
    }
}

