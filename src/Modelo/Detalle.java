package Modelo;

public class Detalle {
    private int secuencia;
    private int cantidad;
    private double precio_parcial;
    private DocumentoPago docPago;
    private Producto producto;

    public Detalle(int secuencia, int cantidad, double precio_parcial, DocumentoPago docPago, Producto producto) {
        this.secuencia = secuencia;
        this.cantidad = cantidad;
        this.precio_parcial = precio_parcial;
        this.docPago = docPago;
        this.producto = producto;
    }        
    
    public int getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(int secuencia) {
        this.secuencia = secuencia;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_parcial() {
        return precio_parcial;
    }

    public void setPrecio_parcial(double precio_parcial) {
        this.precio_parcial = precio_parcial;
    }

    public DocumentoPago getDocPago() {
        return docPago;
    }

    public void setDocPago(DocumentoPago docPago) {
        this.docPago = docPago;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }    
}
