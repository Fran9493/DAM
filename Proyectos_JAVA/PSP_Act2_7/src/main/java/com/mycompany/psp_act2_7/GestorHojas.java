package com.mycompany.psp_act2_7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author Fran
 */
public class GestorHojas extends Thread {

    private static List<String> lista = new CopyOnWriteArrayList<>();

    @Override
    public void run() {

        while (true) {

            if (lista.size() >= 10) {

                lista.remove(0);

            } else if (lista.size() < 10) {

            }

            lista.add(new String("Texto"));

            for (String string : lista) {
                System.out.println("Texto");
            }

        }

    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            lista.add(new String("Texto"));
        }

        for (int i = 0; i < 100; i++) {
            new GestorHojas().start();
        }

    }

}
