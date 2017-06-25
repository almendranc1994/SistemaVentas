package Controlador;

import Modelo.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class Controlador {
    private Cliente clienteActual;
    GestorCliente gestorCliente;
    GestorProducto gestorProducto;
 
    public Controlador() {
        gestorCliente = new GestorCliente();
        gestorProducto = new GestorProducto();
    }
    
    public void insertarPersona(String nombre, String ape_pat, String ape_mat){
        gestorCliente.insertarPersona(nombre,ape_pat,ape_mat);
    }
    
    public ArrayList <Producto> obtenerProductoDeCategoria(Integer categoria) throws SQLException {
        return gestorProducto.obtenerProductoDeCategoria(categoria);
    }
    
    public Cliente obtenerDatosCliente(String usuario,String password) throws SQLException{
        
        return gestorCliente.obtenerCliente(usuario, password);
        
    }

    /**
     * @return the clienteActual
     */
    public Cliente getClienteActual() {
        return clienteActual;
    }

    /**
     * @param clienteActual the clienteActual to set
     */
    public void setClienteActual(Cliente clienteActual) {
        this.clienteActual = clienteActual;
    }
    
    
    
}
