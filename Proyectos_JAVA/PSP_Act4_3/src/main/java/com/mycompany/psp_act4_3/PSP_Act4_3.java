package com.mycompany.psp_act4_3;

/**
 *
 * @author Fran
 */
public class PSP_Act4_3 {

    public static void main(String[] args) {

        GestorFTP gestorFTP = new GestorFTP();

        try {

            gestorFTP.conectar();
            System.out.println("Conectado");

            gestorFTP.descargarFicherosRaiz("C:\\");

            gestorFTP.desconectar();
            System.out.println("Desconectado");

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());

        }

    }
}
