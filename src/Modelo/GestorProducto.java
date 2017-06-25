package Modelo;

import Connect.ConnectDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestorProducto {
    private ArrayList <Producto> productos;
    ConnectDB conexion;
    private Producto prod;

    public GestorProducto() {
        this.productos = new ArrayList<Producto>();
        this.conexion = new ConnectDB();
        this.prod = new Producto();
    }
    
    public ArrayList <Producto> obtenerProductoDeCategoria(Integer categoria) throws SQLException {
        productos.clear();
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_ventas", "root", "almendra1994");
            myStmt = myConn.createStatement();  
            String sql = "SELECT * FROM PRODUCTO WHERE Categoria_idCategoria = " + categoria;
            myRs = myStmt.executeQuery(sql);          
            
            while(myRs.next()){
                int codigo = Integer.parseInt(myRs.getString("idProducto"));
                double precio = Double.parseDouble(myRs.getString("Precio"));
                int idCat = Integer.parseInt(myRs.getString("Categoria_idCategoria"));
                Categoria cat = new Categoria(idCat, "");
                Producto prod = new Producto(codigo, myRs.getString("NombreProducto"),precio, cat);
                productos.add(prod);
            }                   
        }
        catch (Exception exc){
            exc.printStackTrace();			
        }	
        finally{
            if(myRs != null)
                myRs.close();
            if(myStmt != null)
                myStmt.close();
            if(myConn != null)
                myConn.close();
        }
        return productos;       
    }
    
    public Producto obtenerProductoDeNombre(String nombre) throws SQLException { 
        System.out.println(nombre);
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_ventas", "root", "almendra1994");
            myStmt = myConn.createStatement();  
            String sql = "SELECT PRODUCTO.idProducto, PRODUCTO.Precio ,PRODUCTO.NombreProducto,PRODUCTO.Categoria_idCategoria , CATEGORIA.Descripcion FROM PRODUCTO, CATEGORIA  WHERE PRODUCTO.Categoria_idCategoria=CATEGORIA.idCategoria AND PRODUCTO.NombreProducto = '" + nombre + "'";
            myRs = myStmt.executeQuery(sql);          
            
            while(myRs.next()){
                int codigo = Integer.parseInt(myRs.getString("idProducto"));
                double precio = Double.parseDouble(myRs.getString("Precio"));
                int idCat = Integer.parseInt(myRs.getString("Categoria_idCategoria"));
                Categoria cat = new Categoria(idCat, myRs.getString("Descripcion"));
                prod = new Producto(codigo, myRs.getString("NombreProducto"),precio, cat);
                return prod;
            }                 
      
        }
        catch (Exception exc){
            exc.printStackTrace();			
        }	
        finally{
            if(myRs != null)
                myRs.close();
            if(myStmt != null)
                myStmt.close();
            if(myConn != null)
                myConn.close();
        }
        return prod;      
    }
    
}
