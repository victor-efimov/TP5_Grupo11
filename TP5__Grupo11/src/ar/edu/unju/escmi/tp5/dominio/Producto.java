package ar.edu.unju.escmi.tp5.dominio;

public class Producto {
    private String descripcion;
    private double precioUnitario;
    private int codigoProducto;
    private int descuento;

    public Producto() {
    }

    public Producto(int codigoProducto, String descripcion, double precioUnitario, int descuento) {
        this.codigoProducto = codigoProducto;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.descuento = descuento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Producto [Codigo=" + codigoProducto + ", Descripcion=" + descripcion + ", Precio Unitario=$" + precioUnitario + ", Descuento=" + descuento + "%]";
    }
}