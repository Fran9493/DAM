package com.mycompany.psp_callablerunnable;

/**
 *
 * @author Fran
 */
public class PSP_CallableRunnable {

    public static void main(String[] args) {

        System.out.println("********Solución con Callable********");
        PrimoCallable p1 = new PrimoCallable(7);
        try {
            System.out.println(p1.call());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("");
        System.out.println("********Solución con Runnable********");

        PrimoRunnable p2 = new PrimoRunnable(7);

        p2.run();

        if (p2.getMayorDivisor() == -1) {

            System.out.println("Número primo");

        } else {

            System.out.println("Número no primo. Mayor divisor: " + p2.getMayorDivisor());

        }

    }

}
