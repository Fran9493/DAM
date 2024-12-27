package com.mycompany.garcia_cutillas_franciscojose_actut02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Fran
 */
public class Ejercicio02 {

    public static void ejercicio02(String nombreFichero) throws FileNotFoundException, IOException {
       
        File fichero = new File(nombreFichero); 
        FileReader fr = new FileReader(fichero);        
        BufferedReader br = new BufferedReader(fr);
        ArrayList<Integer> numeros = new ArrayList<>();
        
        String caracter = br.readLine();

        //Bucle para leer el fichero
        while (caracter != null) {
            
            //Con esto rellenamos el array con los números indicando que van separados por tabulador
            String[] arrayNum = caracter.split("\t"); 
                        
            //Después rellenamos el ArrayList con cada número obtenido en el array arrayNum
            for(String numero : arrayNum){
                                
                numeros.add(Integer.valueOf(numero));
                
            }
            
            caracter = br.readLine();

        }

        fr.close();
        br.close();
        
        //Mostramos por pantalla los resultados
        Integer numMayor = numMayor(numeros);        
        System.out.println("Mayor: " + numMayor);
        
        Integer numMenor = numMenor(numeros);        
        System.out.println("Menor: " + numMenor);
        
        double media = media(numeros);
        System.out.println("Media: " + media);


    }

    //Método para buscar el número mayor
    private static Integer numMayor(ArrayList<Integer> entrada) {

        Integer salida = 0;

        Collections.sort(entrada, Collections.reverseOrder());

        salida = entrada.get(0);

        return salida;

    }

    //Método para buscar el número menor
    private static int numMenor(ArrayList<Integer> entrada) {

        Integer salida = 0;

        Collections.sort(entrada);

        salida = entrada.get(0);

        return salida;

    }

    //Método para hacer la media 
    private static double media(ArrayList<Integer> entrada) {

        double salida = 0;
        double total = 0;

        for (int i = 0; i < entrada.size(); i++) {

            total += entrada.get(i);

        }

        salida = total / (double)entrada.size();

        return salida;

    }
    
    

}
