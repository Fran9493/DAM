package com.mycompany.conexion;

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
    
    private MySQLConnection(){};
    
    public static Connection newInstance(String user, String pass, String bbdd) throws SQLException{
        
        String cadenaConexion = driver + "://" + hostPuerto + "/" + bbdd;
        Connection con = DriverManager.getConnection(cadenaConexion, user, pass);
        return con;
        
    }
    
}
