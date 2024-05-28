package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO extends Conexion {

    Connection con = getConexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Empleado validar(String user, String dni) {
        Empleado em = new Empleado();
        String sql = "SELECT * FROM empleado WHERE User=? AND Dni=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, dni);
            rs = ps.executeQuery();
            while (rs.next()) {
                em.setId(rs.getInt("IdEmpleado"));
                em.setUser(rs.getString("User"));
                em.setDni(rs.getString("Dni"));
                em.setNom(rs.getString("Nombres"));
            }
            if (user.equalsIgnoreCase(em.getUser()) && dni.equals(em.getDni())) {
                return em;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentencia Select " + ex);
            return null;
        }
    }

    //Operaciones CRUD
    public List select() {
        String sql = "SELECT * FROM empleado";
        List<Empleado> lista = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado em = new Empleado();
                em.setId(rs.getInt("IdEmpleado"));
                em.setDni(rs.getString("Dni"));
                em.setNom(rs.getString("Nombres"));
                em.setTel(rs.getString("Telefono"));
                em.setEstado(rs.getString("Estado"));
                em.setUser(rs.getString("User"));
                lista.add(em);
            }
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentencia Select " + ex);
        }
        return lista;
    }

    public int insert(Empleado em) {
        String sql = "INSERT INTO empleado(Dni,Nombres,Telefono,Estado,User) VALUES(?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getTel());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUser());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentencia Insert" + ex);
        }
        return r;
    }

    public Empleado listarId(int id) {
        Empleado emp = new Empleado();
        String sql = "select * from empleado where IdEmpleado=" + id;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                emp.setDni(rs.getString("Dni"));
                emp.setNom(rs.getString("Nombres"));
                emp.setTel(rs.getString("Telefono"));
                emp.setEstado(rs.getString("Estado"));
                emp.setUser(rs.getString("User"));
            }
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentencia Select" + ex);
        }
        return emp;
    }

    public int update(Empleado em) {
        String sql = "UPDATE empleado SET Dni=?,Nombres=?,Telefono=?,Estado=?,User=? WHERE IdEmpleado=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getTel());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUser());
            ps.setInt(6, em.getId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentencia Update " + ex);
        }
        return r;
    }

    public void delete(int id) {
        String sql = "DELETE FROM empleado WHERE IdEmpleado=" + id;
        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentencia Delete" + ex);
        }
    }
}
