
package Modelo;
import java.util.Date;

public class DocumentoPago {
    private int codigoFactura;
    private Date fecha;
    private double precioTotal;
    private Cliente persona;
    private TipoPago tipoPago;
    private ModoPago modoPago;

    public DocumentoPago(int codigoFactura, Date fecha, double precioTotal, Cliente persona, TipoPago tipoPago, ModoPago modoPago) {
        this.codigoFactura = codigoFactura;
        this.fecha = fecha;
        this.precioTotal = precioTotal;
        this.persona = persona;
        this.tipoPago = tipoPago;
        this.modoPago = modoPago;
    }
           
    public int getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(int codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Cliente getPersona() {
        return persona;
    }

    public void setPersona(Cliente persona) {
        this.persona = persona;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }

    public ModoPago getModoPago() {
        return modoPago;
    }

    public void setModoPago(ModoPago modoPago) {
        this.modoPago = modoPago;
    }	
}

