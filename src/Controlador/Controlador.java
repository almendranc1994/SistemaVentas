package Controlador;

import Modelo.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class Controlador {
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
    
}
