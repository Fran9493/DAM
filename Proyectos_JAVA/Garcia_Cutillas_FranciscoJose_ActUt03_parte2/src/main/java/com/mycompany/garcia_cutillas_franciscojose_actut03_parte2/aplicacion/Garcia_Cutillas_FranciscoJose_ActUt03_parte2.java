package com.mycompany.garcia_cutillas_franciscojose_actut03_parte2.aplicacion;

import com.mycompany.garcia_cutillas_franciscojose_actut03_parte2.dao.ModuloDAOImpl;
import com.mycompany.garcia_cutillas_franciscojose_actut03_parte2.modelo.Modulo;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Fran
 */
public class Garcia_Cutillas_FranciscoJose_ActUt03_parte2 {
    
    private static Scanner sc = new Scanner(System.in, "ISO-8859-1");
    private static int codigo;
    private static String nombre;
    private static int horas_semanales;
    private static int curso_imparte;
    private static ModuloDAOImpl mdi = new ModuloDAOImpl();
    private static ArrayList<Modulo> modulos = new ArrayList<>();

    public static void main(String[] args) {
        
        int seleccion = -1;
        
        //Instrucciones de la aplicación:
        /*  
            Para finalizar pulsar 0
            Para dar de alta un módulo pulsar 1
            Para eliminar un módulo pulsar 2
            Para consultar un módulo pulsar 3
            Para consultar todos los módulos pulsar 4
            Para consultar módulos que tengan más de x horas pulsar 5
            Para consultar módulos que se imparten en un determinado curso pulsar 6
        */
        
        System.out.println("***** Consultas a la base de datos modulos *****\n");
        System.out.println("    Para finalizar pulse 0\n" +
                           "    Para dar de alta un módulo pulse 1\n" +
                           "    Para eliminar un módulo pulse 2\n" +
                           "    Para consultar un módulo pulse 3\n" +
                           "    Para consultar todos los módulos pulse 4\n" +
                           "    Para consultar módulos que tengan más de x horas pulse 5\n" +
                           "    Para consultar módulos que se imparten en un determinado curso pulse 6\n");
        
        do {
            
            System.out.print("    \nSeleccione un valor (0 - 6):");            
            seleccion = sc.nextInt();
            sc.nextLine();
            
            switch (seleccion) {
                case 1:
                    
                    altaModulo();
                    break;
                    
                case 2:
                    
                    eliminaModulo();
                    break;
                    
                case 3:
                    
                    consultaModulo();
                    break;
                    
                case 4:
                    
                    consultaModulos();
                    break;
                    
                case 5:
                    
                    consultaHoras();
                    break;
                    
                case 6:
                    
                    consultaCurso();
                    break;
                    
                default:
                    
                    if (seleccion != 0) {
                        
                        System.out.println("    Debe seleccionar un valor del rango preestablecido");
                        
                    }
                                        
                    break;
            }
            
        } while (seleccion != 0);
        
    }
    
    public static void altaModulo(){
                
        System.out.println("    *** Alta de módulo ***");
        
        System.out.print("        Introduce el código del módulo: ");
        codigo = sc.nextInt();
        sc.nextLine();
                
        System.out.print("        Introduce el nombre del módulo: ");
        nombre = sc.nextLine();
                
        System.out.print("        Introduce las horas semanales del módulo: ");
        horas_semanales = sc.nextInt();
        sc.nextLine();
        
        System.out.print("        Introduce el curso en el que se imparte el módulo: ");
        curso_imparte = sc.nextInt();
        sc.nextLine();
        
        Modulo m = new Modulo(codigo, nombre, horas_semanales, curso_imparte);
          
        if (mdi.altaModulo(m) != 0) {
            
            System.out.println("        Módulo añadido");
            
        } else {
            
            System.out.println("        No se ha añadido ningún módulo");
            
        }
        
    }
    
    public static void eliminaModulo(){
        
        System.out.println("    *** Eliminar un módulo ***");
        
        System.out.print("        Introduce el código del módulo: ");
        codigo = sc.nextInt();
        sc.nextLine();
                
        if (mdi.eliminaModulo(codigo) != 0) {
            
            System.out.println("        Módulo eliminado");
            
        } else {
            
            System.out.println("        No se ha eliminado ningún módulo");
            
        }
        
    }
    
    public static void consultaModulo(){
        
        System.out.println("    *** Consultar un módulo ***");
        
        System.out.print("        Introduce el código del módulo: ");
        codigo = sc.nextInt();
        sc.nextLine();
        
        if (mdi.existeModulo(codigo)) {
            
            Modulo m = mdi.consultaModulo(codigo);
            System.out.println(m.toString());
            
        } else {
            
            System.out.println("        El módulo con código " + codigo + " no se encuentra en la base de datos");
            
        }
                
        
        
    }
    
    public static void consultaModulos(){
        
        System.out.println("    *** Consultar todos los módulos ***");
        
        modulos = mdi.consultaTodos();
        
        mostrarModulos(modulos);
        
    }
    
    public static void consultaHoras(){
        
        System.out.println("    *** Consultar módulos de más de x horas ***");
        
        System.out.print("        Introduce las horas: ");
        int horas = sc.nextInt();
        sc.nextLine();
                
        modulos = mdi.moduloHoras(horas);
        
        mostrarModulos(modulos);
        
    }
    
    public static void consultaCurso(){
        
        System.out.println("    *** Consultar módulos por curso ***");
        
        System.out.print("        Introduce el curso: ");
        int curso = sc.nextInt();
        sc.nextLine();
                
        modulos = mdi.moduloCurso(curso);
        
        mostrarModulos(modulos);
        
    }
    
    public static void mostrarModulos(ArrayList<Modulo> modulos){
        
        for(Modulo m : modulos){
            
            System.out.println(m.toString());
            
        }
        
    }
    
}
