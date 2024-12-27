package com.mycompany.operaciones;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Fran
 */
public class JDBCOperaciones {

    private JDBCOperaciones() {
    }

    ;
    
    public static int crearTabla(Connection con, String orden) {

        try {

            Statement st = con.createStatement();

            try {

                st.execute(orden);
                return 0;

            } catch (SQLException ex) {

                if (ex.getMessage().contains("already exists")) {

                    System.out.println("La tabla ya existe");
                    return -1;

                } else {

                    System.out.println("Error al crear la tabla: " + ex.getMessage());
                    return -2;

                }

            }

        } catch (SQLException ex) {

            System.out.println("Error al crear el Statement: " + ex.getMessage());
            return -3;

        }

    }
    
    public static boolean alterTable(Connection con, String orden){
        
        try{
            
            Statement st = con.createStatement();
            
            try{
                
                st.executeUpdate(orden);
                return true;
                
            } catch (SQLException ex){
                
                System.out.println("Error al modificar la tabla: " + ex.getMessage());
                return false;
                
            }
            
        } catch (SQLException ex){
            
            System.out.println("Error al crear el Statement: " + ex.getMessage());
            return false;
            
        }
        
    }

}
