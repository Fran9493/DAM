package com.mycompany.garcia_cutillas_franciscojose_actut03;

import com.mycompany.conexion.MySQLConnection;
import com.mycompany.operaciones.JDBCOperaciones;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Fran
 */
public class Garcia_Cutillas_FranciscoJose_ActUt03 {

    public static void main(String[] args) {

        Connection con = null;

        try {

            con = MySQLConnection.newInstance("root", "3979199", "flota");
            System.out.println("Conectado: " + con.isValid(3));

        } catch (SQLException ex) {

            System.out.println("Error al conectarse a la base de datos: " + ex.getMessage());

        }

        String tablaVehiculo = "create table vehiculo(\n"
                + "    matricula varchar(10) primary key,\n"
                + "    ano_matricula numeric(4) not null,\n"
                + "    color varchar(50),\n"
                + "    precio numeric(10,2)\n"
                + ");";

//        int operacion = JDBCOperaciones.crearTabla(con, tablaVehiculo);
//        
//        if (operacion == 0) {
//            
//            System.out.println("Tabla creada correctamente");
//            
//        }
        String tablaConductor = "create table conductor(\n"
                + "    dni varchar(10) primary key,\n"
                + "    nombre varchar(50) not null,\n"
                + "    apellidos varchar(100) not null,\n"
                + "    fecha_nacimiento date not null,\n"
                + "    fecha_carnet date not null,\n"
                + "    estatura numeric(3)\n"
                + ");";

//        int operacionConductor = JDBCOperaciones.crearTabla(con, tablaConductor);
//        
//        if (operacionConductor == 0) {
//            
//            System.out.println("Tabla conductor creada correctamente");
//            
//        }
        String tablaTipoVehiculo = "create table tipo_vehiculo(\n"
                + "    codigo_vehiculo varchar(10) primary key,\n"
                + "    descripcion varchar(100)\n"
                + ");";

//        int operacionTipoVehiculo = JDBCOperaciones.crearTabla(con, tablaTipoVehiculo);
//        
//        if (operacionTipoVehiculo == 0) {
//            
//            System.out.println("Tabla tipo vehiculo creada correctamente");
//            
//        }

        //Para realizar esta operación, necesitamos hacerla en dos pasos:
        //Primero tenemos que añadir un índice a la tabla tipo_vehículo para poder referenciar la 
        //foreign key
        String addIndex = "alter table tipo_vehiculo add index descripcion (descripcion);";

//        boolean operacionAddTipoVehiculo = JDBCOperaciones.alterTable(con, addIndex);
//
//        if (operacionAddTipoVehiculo) {
//
//            System.out.println("Añadido índice correctamente");
//
//        }
       
        //Segundo vamos a añadir la columna tipo_vehiculo y su foreign key hacia la tabla tipo_vehiculo
        String addTipoVehiculo = "alter table vehiculo add column tipo_vehiculo varchar(100) not null,\n" +
                                 "	add constraint fk_vehiculo_tipo_vehiculo foreign key (tipo_vehiculo)\n" +
                                 "      references tipo_vehiculo(descripcion) on delete restrict on update cascade;";
        
//        operacionAddTipoVehiculo = JDBCOperaciones.alterTable(con, addTipoVehiculo);
//        
//        if (operacionAddTipoVehiculo) {
//
//            System.out.println("Añadida columna tipo_vehiculo y su foreign key");
//
//        }

        String delColor = "alter table vehiculo drop column color;";
        
//        boolean operaciondelColor = JDBCOperaciones.alterTable(con, delColor);
//        
//        if (operaciondelColor) {
//            
//            System.out.println("Columna color eliminada correctamente.");
//            
//        }
        
        String delFechaCarnet = "alter table conductor drop column fecha_carnet;";
        
//        boolean operacionDelFechaCarnet = JDBCOperaciones.alterTable(con, delFechaCarnet);
//        
//        if (operacionDelFechaCarnet) {
//            
//            System.out.println("Columna fecha_carnet eliminada correctamente");
//            
//        }
        
        String addFechaCarnet = "alter table conductor add column fecha_carnet date null;";
        
//        boolean operacionAddFechaCarnet = JDBCOperaciones.alterTable(con, addFechaCarnet);
//        
//        if (operacionAddFechaCarnet) {
//            
//            System.out.println("Columna fecha_carnet agregada correctamente");
//            
//        }

    }

}
