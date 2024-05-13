/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author buend
 */
public class VentaDAO extends Conexion {

    Connection con = getConexion();
    PreparedStatement ps;
    ResultSet rs;

    public String GenerarSerie() {
        String numeroserie = "";
        String sql = "select max(NumeroSerie) from ventas";
        try {
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                numeroserie = rs.getString(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentencia Select " + ex);
        }
        return numeroserie;
    }
}
