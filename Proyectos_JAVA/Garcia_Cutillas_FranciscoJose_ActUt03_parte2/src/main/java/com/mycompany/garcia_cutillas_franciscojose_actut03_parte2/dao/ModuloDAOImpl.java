package com.mycompany.garcia_cutillas_franciscojose_actut03_parte2.dao;

import com.mycompany.garcia_cutillas_franciscojose_actut03_parte2.conexiones.MySQLConnection;
import com.mycompany.garcia_cutillas_franciscojose_actut03_parte2.modelo.Modulo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Fran
 */
public class ModuloDAOImpl implements ModuloDAO {

    @Override
    public int altaModulo(Modulo modulo) {

        Connection con = MySQLConnection.newInstance();

        String consulta = "insert into modulo (codigo, nombre, horas_semanales, curso_imparte) values (?,?,?,?);";

        int valorConsulta = 0;

        try {
            
            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setInt(1, modulo.getCodigo());
            ps.setString(2, modulo.getNombre());
            ps.setInt(3, modulo.getHorasSemanales());
            ps.setInt(4, modulo.getCursoImparte());
            valorConsulta = ps.executeUpdate();

        } catch (SQLException ex) {

            System.out.println("        Error al insertar el módulo: " + ex.getMessage());

        }

        MySQLConnection.cerrarConexion(con);

        return valorConsulta;

    }

    @Override
    public Modulo consultaModulo(int codigo) {

        Connection con = MySQLConnection.newInstance();

        String consulta = "select * from modulo where codigo = ?;";

        Modulo m = null;

        try {

            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                m = new Modulo(rs.getInt("codigo"), rs.getString("nombre"),
                        rs.getInt("horas_semanales"), rs.getInt("curso_imparte"));

            }

        } catch (SQLException ex) {

            System.out.println("        Error al consultar el módulo: " + ex.getMessage());

        }

        MySQLConnection.cerrarConexion(con);

        return m;

    }

    @Override
    public ArrayList<Modulo> consultaTodos() {

        Connection con = MySQLConnection.newInstance();

        String consulta = "select * from modulo;";

        ArrayList<Modulo> modulos = new ArrayList<>();
        Modulo m = null;

        try {

            PreparedStatement ps = con.prepareStatement(consulta);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                m = new Modulo(rs.getInt("codigo"), rs.getString("nombre"),
                        rs.getInt("horas_semanales"), rs.getInt("curso_imparte"));
                modulos.add(m);

            }

        } catch (SQLException ex) {

            System.out.println("        Error al consultar el módulo: " + ex.getMessage());

        }

        MySQLConnection.cerrarConexion(con);

        return modulos;

    }

    @Override
    public int eliminaModulo(int codigo) {

        Connection con = MySQLConnection.newInstance();

        String consulta = "delete from modulo where codigo = ?;";

        int valorConsulta = 0;

        try {

            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setInt(1, codigo);
            valorConsulta = ps.executeUpdate();

        } catch (SQLException ex) {

            System.out.println("        Error al eliminar el módulo: " + ex.getMessage());

        }

        MySQLConnection.cerrarConexion(con);

        return valorConsulta;

    }

    public boolean existeModulo(int codigo) {

        if (consultaModulo(codigo) == null) {

            return false;

        } else {

            return true;

        }

    }

    public ArrayList<Modulo> moduloHoras(int horas) {

        ArrayList<Modulo> salida = new ArrayList<>();

        ArrayList<Modulo> modulos = new ArrayList<>();

        modulos = consultaTodos();

        for (Modulo m : modulos) {

            if (m.getHorasSemanales() > horas) {

                salida.add(m);

            }

        }

        return salida;

    }

    public ArrayList<Modulo> moduloCurso(int curso) {

        ArrayList<Modulo> salida = new ArrayList<>();

        ArrayList<Modulo> modulos = new ArrayList<>();

        modulos = consultaTodos();

        for (Modulo m : modulos) {

            if (m.getCursoImparte() == curso) {

                salida.add(m);

            }

        }

        return salida;

    }

}
