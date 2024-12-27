package com.mycompany.psp_act2_5;

/**
 *
 * @author Fran
 */
public class ClaseRunnable implements Runnable {


    @Override
    public void run() {

        while (true) {

            System.out.println("Ejecutando hilo");

            try {

                Thread.sleep(100);

            } catch (InterruptedException ex) {

                System.out.println("Error: " + ex.getMessage());

            }

        }

    }

}
