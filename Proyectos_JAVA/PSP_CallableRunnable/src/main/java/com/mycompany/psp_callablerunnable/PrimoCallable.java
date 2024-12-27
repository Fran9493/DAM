package com.mycompany.psp_callablerunnable;

import java.util.concurrent.Callable;

/**
 *
 * @author Fran
 */
public class PrimoCallable implements Callable<String> {

    private int numero;

    public PrimoCallable(int _numero) {

        this.numero = _numero;

    }

    @Override
    public String call() throws Exception {

        if (!esPrimo(numero)) {

            return "El número no es primo, y el mayor divisor es " + mayorDivisor(numero);

        } else {

            throw new Exception("El número es primo");

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

        int mayorDivisor = 0;

        for (int i = 2; i < numero; i++) {

            if (numero % i == 0) {

                mayorDivisor = i;
            }

        }

        return mayorDivisor;

    }

}
