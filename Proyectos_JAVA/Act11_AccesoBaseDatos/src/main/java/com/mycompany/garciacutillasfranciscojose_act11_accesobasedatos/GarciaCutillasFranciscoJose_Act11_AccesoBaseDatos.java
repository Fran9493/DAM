package com.mycompany.garciacutillasfranciscojose_act11_accesobasedatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

/**
 *
 * @author Fran
 */
public class GarciaCutillasFranciscoJose_Act11_AccesoBaseDatos {

    public static void main(String[] args) {

        //Apartado 1
        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ligabaloncesto", "root", "3979199");

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from equipo order by puntos desc;");

            System.out.println("Equipos ordenados por puntuación:");
            while (rs.next()) {

                int id_equipo = rs.getInt("id_equipo");
                String nombre = rs.getString("nombre");
                String ciudad = rs.getString("ciudad");
                String web = rs.getString("web");
                int puntos = rs.getInt("puntos");

                System.out.println("    " + "Id: " + id_equipo + ", Nombre: " + nombre + ", Ciudad: " + ciudad
                        + ", Web: " + web + ", Puntos: " + puntos);

            }
            st.close();
            connection.close();

        } catch (SQLException e) {

            System.out.println("Error de la base de datos:");
            System.out.println(e.getMessage());

        }

        System.out.println("");

        //Apartado 2
        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ligabaloncesto", "root", "3979199");

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select j.id_jugador, j.nombre, j.apellido, e.nombre nombre_equipo, j.fecha_alta, e.web "
                    + "from jugador j inner join equipo e "
                    + "on j.num_equipo = e.id_equipo "
                    + "where num_equipo not in (1, 2);");

            System.out.println("Jugadores menos los del equipo 1 y 2:");
            while (rs.next()) {

                int id_jugador = rs.getInt("id_jugador");
                String nombre_jugador = rs.getString("nombre");
                String apellido_jugador = rs.getString("apellido");
                String nombre_equipo = rs.getString("nombre_equipo");
                Date fecha = rs.getDate("fecha_alta");
                String web = rs.getString("web");

                System.out.println("    " + "Id: " + id_jugador + ", Nombre: " + nombre_jugador + ", Apellido: " + apellido_jugador
                        + ", Nombre del equipo: " + nombre_equipo + ", Fecha de alta: " + fecha.toString() + ", Web del equipo: "
                        + web);

            }
            st.close();
            connection.close();

        } catch (SQLException e) {

            System.out.println("Error de la base de datos:");
            System.out.println(e.getMessage());

        }

        //Apartado 3
        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ligabaloncesto", "root", "3979199");

            Statement st = connection.createStatement();

//            int insJugador = st.executeUpdate("insert into jugador values(30, 'JUAN', 'CANO', 'ALERO', 1, '2020-05-30', 98000, 1, 2.08);");
//            System.out.println("Filas insertadas: " + insJugador);
//            int insEquipo = st.executeUpdate("insert into equipo values(10, 'ULEA BALONCESTO', 'ULEA', 'HTTPS://WWW.ULEA.COM', 19);");
//            System.out.println("Filas insertadas: " + insEquipo);
//            int actSalario = st.executeUpdate("update jugador set salario = salario + 10000 where id_jugador % 2 = 0;");
//            System.out.println("Filas insertadas: " + actSalario);
            int borraEquipo = st.executeUpdate("delete from equipo where id_equipo = 10;");
            System.out.println("Filas Borradas: " + borraEquipo);

            st.close();
            connection.close();

        } catch (SQLException e) {

            System.out.println("Error de la base de datos:");
            System.out.println(e.getMessage());

        }

        //Apartado 4
        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ligabaloncesto", "root", "3979199");

            Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

//            ResultSet rs = st.executeQuery("select id_jugador, salario from jugador order by salario asc;");            
//            rs.first();
//            int salarioBajo = rs.getInt("salario");
//            rs.next();
//            rs.updateInt("salario", salarioBajo);
//            rs.updateRow();
//
//            ResultSet rs = st.executeQuery("select * from jugador");
//            rs.moveToInsertRow();
//            rs.updateInt("id_jugador", 31);
//            rs.updateString("nombre", "GONZALO");
//            rs.updateString("apellido", "GONZÁLEZ");
//            rs.updateString("puesto", "PIVOT");
//            rs.updateInt("id_capitan", 3);
//            rs.updateDate("fecha_alta", Date.valueOf(LocalDate.now()));
//            rs.updateInt("salario", 85000);
//            rs.updateInt("num_equipo", 3);
//            rs.updateDouble("altura", 2.12);
//            rs.insertRow();
//            ResultSet rs = st.executeQuery("select * from equipo");
//            rs.moveToInsertRow();
//            rs.updateInt("id_equipo", 10);
//            rs.updateString("nombre", "GARAPACHA BALONCESTO");
//            rs.updateString("ciudad", "FORTUNA");
//            rs.updateString("web", "HTTP://WWW.GARAPACHA.NET");
//            rs.updateInt("puntos", 83);            
//            rs.insertRow();
            ResultSet rs = st.executeQuery("select * from jugador where id_jugador = 31");
            if (rs.next()) {

                rs.deleteRow();

            } else {

                System.out.println("No existe el jugador");

            }

            st.close();
            rs.close();
            connection.close();

        } catch (SQLException e) {

            System.out.println("Error de la base de datos:");
            System.out.println(e.getMessage());

        }

    }

}
