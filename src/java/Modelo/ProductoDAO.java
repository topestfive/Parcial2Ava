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
public class ProductoDAO extends Conexion{
    Connection con=getConexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    //Operaciones CRUD

    public List select(){
        String sql="SELECT * FROM producto";
        List<Producto> lista = new ArrayList<>();
        try{
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Producto pr=new Producto();
                pr.setId(rs.getInt("IdProducto"));
                pr.setNom(rs.getString("Nombres"));
                pr.setPrecio(rs.getString("Precio"));
                pr.setStock(rs.getString("Stock"));
                pr.setEstado(rs.getString("Estado"));
                lista.add(pr);
            }
        }catch(SQLException ex){
            System.out.println("Error al ejecutar la sentencia Select "+ex);
        }
        return lista;
    }
    
    public int insert(Producto pr){
        String sql="INSERT INTO producto(Nombres,Precio,Stock,Estado) VALUES(?,?,?,?)";
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, pr.getNom());
            ps.setString(2, pr.getPrecio());
            ps.setString(3, pr.getStock());
            ps.setString(4, pr.getEstado());            
            ps.executeUpdate();                     
        }catch(SQLException ex){
            System.out.println("Error al ejecutar la sentencia Insert"+ex);
        }
        return r;
    }
    
    public Producto listarId(int id){
        Producto pro=new Producto();
        String sql="SELECT * FROM producto WHERE IdProducto="+id;
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                pro.setId(rs.getInt("IdProducto"));
                pro.setNom(rs.getString("Nombres"));
                pro.setPrecio(rs.getString("Precio"));
                pro.setStock(rs.getString("Stock"));
                pro.setEstado(rs.getString("Estado"));              
            }
        }catch(SQLException ex){
            System.out.println("Error al ejecutar la sentencia Select"+ex);
        }
        return pro;
    }
    
    public int update(Producto pr){
        String sql="UPDATE producto SET Nombres=?,Precio=?,Stock=?,Estado=? WHERE IdProducto=?";
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, pr.getNom());
            ps.setString(2, pr.getPrecio());
            ps.setString(3, pr.getStock());
            ps.setString(4, pr.getEstado());
            ps.setInt(5, pr.getId());
            ps.executeUpdate();     
        }catch(SQLException ex){
            System.out.println("Error al ejecutar la sentencia Update "+ex);
        }
        return r;
    }
    
    public void delete(int id){
        String sql="DELETE FROM producto WHERE IdProducto="+id;
        try {
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Error al ejecutar la sentencia Delete"+ex);
        }
    }
}
