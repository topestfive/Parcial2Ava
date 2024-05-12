/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ClientesDAO extends Conexion{
    Connection con=getConexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    //Operaciones CRUD

    public List select(){
        String sql="SELECT * FROM cliente";
        List<Cliente> lista = new ArrayList<>();
        try{
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Cliente cl=new Cliente();
                cl.setId(rs.getInt("IdCliente"));
                cl.setDni(rs.getString("Dni"));
                cl.setNom(rs.getString("Nombres"));
                cl.setDir(rs.getString("Direccion"));
                cl.setEstado(rs.getString("Estado"));
                lista.add(cl);
            }
        }catch(SQLException ex){
            System.out.println("Error al ejecutar la sentencia Select "+ex);
        }
        return lista;
    }
    
    public int insert(Cliente cl){
        String sql="INSERT INTO cliente(Dni,Nombres,Direccion,Estado) VALUES(?,?,?,?)";
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, cl.getDni());
            ps.setString(2, cl.getNom());
            ps.setString(3, cl.getDir());
            ps.setString(4, cl.getEstado());            
            ps.executeUpdate();                     
        }catch(SQLException ex){
            System.out.println("Error al ejecutar la sentencia Insert"+ex);
        }
        return r;
    }
    
    public Cliente listarId(int id){
        Cliente cli=new Cliente();
        String sql="SELECT * FROM cliente WHERE IdCliente="+id;
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                cli.setDni(rs.getString("Dni"));
                cli.setNom(rs.getString("Nombres"));
                cli.setDir(rs.getString("Direccion"));
                cli.setEstado(rs.getString("Estado"));               
            }
        }catch(SQLException ex){
            System.out.println("Error al ejecutar la sentencia Select"+ex);
        }
        return cli;
    }
    
    public int update(Cliente cl){
        String sql="UPDATE cliente SET Dni=?,Nombres=?,Direccion=?,Estado=? WHERE IdCliente=?";
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, cl.getDni());
            ps.setString(2, cl.getNom());
            ps.setString(3, cl.getDir());
            ps.setString(4, cl.getEstado());
            ps.setInt(5, cl.getId());
            ps.executeUpdate();
                        
        }catch(SQLException ex){
            System.out.println("Error al ejecutar la sentencia Update "+ex);
        }
        return r;
    }
    
    public void delete(int id){
        String sql="DELETE FROM cliente WHERE IdCliente="+id;
        try {
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Error al ejecutar la sentencia Delete"+ex);
        }
    }
}
