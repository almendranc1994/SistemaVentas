
package Modelo;

public class TipoPago {
    private int idTipoPago;
    private String descripcion;

    public TipoPago(int idTipoPago, String descripcion) {
        this.idTipoPago = idTipoPago;
        this.descripcion = descripcion;
    }
    
    public int getIdTipoPago() {
        return idTipoPago;
    }

    public void setIdTipoPago(int idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
   
}
