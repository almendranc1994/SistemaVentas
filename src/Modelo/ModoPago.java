
package Modelo;

public class ModoPago {
    private int idModoPago;
    private String descripcion;

    public ModoPago(int idModoPago, String descripcion) {
        this.idModoPago = idModoPago;
        this.descripcion = descripcion;
    }
    
    public int getIdModoPago() {
        return idModoPago;
    }

    public void setIdModoPago(int idModoPago) {
        this.idModoPago = idModoPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
