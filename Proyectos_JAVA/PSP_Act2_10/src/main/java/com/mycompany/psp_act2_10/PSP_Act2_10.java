package com.mycompany.psp_act2_10;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Fran
 */
public class PSP_Act2_10 implements Runnable {

    private static Semaphore semaforo1 = new Semaphore(2);
    private static Semaphore semaforo2 = new Semaphore(2);

    public static void main(String[] args) {

        PSP_Act2_10 sem1 = new PSP_Act2_10();
        PSP_Act2_10 sem2 = new PSP_Act2_10();

        for (int i = 0; i < 4; i++) {

            new Thread(sem1).start();
            new Thread(sem2).start();

        }

    }

    public static void metodo1() throws InterruptedException {

        semaforo1.acquire();
        System.out.println("Ejecutando metodo1 con semaforo1");
        Thread.sleep(1000);
        semaforo1.release();

    }

    public static void metodo2() throws InterruptedException {

        semaforo2.acquire();
        System.out.println("Ejecutando metodo2 con semaforo2");
        Thread.sleep(1000);
        semaforo2.release();

    }

    @Override
    public void run() {

        try {
            metodo1();
            metodo2();
        } catch (InterruptedException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }

}
