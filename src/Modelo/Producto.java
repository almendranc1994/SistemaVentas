
package Modelo;

public class Producto {
    private int idProducto;
    private String nombreProducto;
    private double precioVenta;
    private Categoria categoria;

    public Producto(int idProducto, String nombreProducto, double precioVenta, Categoria categoria) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precioVenta = precioVenta;
        this.categoria = categoria;
    }    

    Producto() {
        this.idProducto = 0;
        this.nombreProducto = "";
        this.precioVenta = 0;
        
    }
    
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
}
