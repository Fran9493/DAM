package com.mycompany.garcia_cutillas_franciscojose_actut03_parte2.conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Fran
 */
public class MySQLConnection {
    
    private static String driver = "jdbc:mysql";
    private static String hostPuerto = "localhost:3306";
    private static String user = "root";
    private static String pass = "3979199";
    private static String bbdd = "modulos";
    
    private MySQLConnection(){};
    
    public static Connection newInstance() {
        
        Connection con = null;
        
        try{
        
            String cadenaConexion = driver + "://" + hostPuerto + "/" + bbdd;
            con = DriverManager.getConnection(cadenaConexion, user, pass);
            
        } catch (SQLException ex){
            
            System.out.println("Error al crear la conexión: " + ex.getMessage());
            
        }
        
        return con;
        
    }
    
    public static Connection newInstance(String user, String pass, String bbdd) {
        
        Connection con = null;
        
        try{
        
            String cadenaConexion = driver + "://" + hostPuerto + "/" + bbdd;
            con = DriverManager.getConnection(cadenaConexion, user, pass);
            
        } catch (SQLException ex){
            
            System.out.println("Error al crear la conexión: " + ex.getMessage());
            
        }
        
        return con;
        
    }
    
    public static boolean cerrarConexion(Connection con){
        
        try{
            
            con.close();
            return true;
            
        } catch (SQLException ex){
            
            System.out.println("Error al cerrar la conexión: " + ex.getMessage());
            return false;
             
        }
        
    }
    
}
