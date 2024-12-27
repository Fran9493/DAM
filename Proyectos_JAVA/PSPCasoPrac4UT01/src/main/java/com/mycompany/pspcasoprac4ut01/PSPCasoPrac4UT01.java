package com.mycompany.pspcasoprac4ut01;

import java.util.Scanner;

/**
 *
 * @author Fran
 */
public class PSPCasoPrac4UT01 {

    public static void main(String[] args) {
        
        Sumador suma = new Sumador();
        
        Scanner sc = new Scanner(System.in);
                        
        System.out.println("Introduce el primer valor: ");
        int num1 = sc.nextInt();
        
        System.out.println("Introduce el segundo valor: ");
        int num2 = sc.nextInt();
        
        System.out.println("El resultado de la suma es: " + suma.sumar(num1, num2));
        
    }
}
