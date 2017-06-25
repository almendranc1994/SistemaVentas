package Modelo;

import Connect.ConnectDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestorCliente {
    private ArrayList <Cliente> personas;

    public GestorCliente() {
        personas = new ArrayList<Cliente>();
    }
    
    public void insertarPersona(String nombre, String ape_pat, String ape_mat){ 
        
    }
    
    public Cliente obtenerCliente(String usuario, String password) throws SQLException {
    
        Cliente cliente = new Cliente();
        
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_ventas", "root", "almendra1994");
            myStmt = myConn.createStatement();  
            String sql = "SELECT * FROM CLIENTE WHERE DocumentoIdentidad = '" + usuario + "' AND Password = '" + password+"'";
            myRs = myStmt.executeQuery(sql);          
            
            while(myRs.next()){
                cliente.setNombre(myRs.getString("Nombre"));
                cliente.setApellidoPaterno(myRs.getString("ApellidoPaterno"));
                cliente.setApellidoMaterno(myRs.getString("ApellidoMaterno"));
                cliente.setEmail(myRs.getString("Email"));
                cliente.setIdCliente(Integer.parseInt(myRs.getString("idCliente")));
                cliente.setDocumentoIdentidad(Integer.parseInt(myRs.getString("DocumentoIdentidad")));
                return cliente; // si se encontro se retorna de frente el cliente
            }                   
        }
        catch (Exception exc){
            exc.printStackTrace();	
            return null; //  si se cayo por algun error de la BD, se retorna null
        }	
        finally{
            if(myRs != null)
                myRs.close();
            if(myStmt != null)
                myStmt.close();
            if(myConn != null)
                myConn.close();
        }
        
        return null; // si no se encontro nada, se devuelve null
    }
    
}
