package com.mycompany.psp_callablerunnable;

/**
 *
 * @author Fran
 */
public class PrimoRunnable implements Runnable {

    private int numero;
    private int mayorDivisor;

    public PrimoRunnable(int _numero) {

        this.numero = _numero;

    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getMayorDivisor() {
        return mayorDivisor;
    }

    public void setMayorDivisor(int mayorDivisor) {
        this.mayorDivisor = mayorDivisor;
    }

    @Override
    public void run() {
        if (!esPrimo(this.numero)) {

            this.mayorDivisor = mayorDivisor(this.numero);

        } else {

            this.mayorDivisor = -1;

        }
    }

    private boolean esPrimo(int numero) {

        boolean divisible = true;

        for (int i = 2; i < numero; i++) {

            if (numero % i == 0) {

                divisible = false;
                break;

            }

        }

        return divisible;

    }

    private int mayorDivisor(int numero) {

        int mayorDiv = 0;

        for (int i = 2; i < numero; i++) {

            if (numero % i == 0) {

                mayorDiv = i;
            }

        }

        return mayorDiv;

    }

}
