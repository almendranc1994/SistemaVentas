package sistema_venta;

import Controlador.Controlador;
import Modelo.GestorCliente;
import Vista.*;

public class Sistema_Venta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Controlador C = new Controlador();
        
        new vistaPrincipal(C).setVisible(true);
        
    }
    
}
