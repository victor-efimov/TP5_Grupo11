package ar.edu.unju.escmi.tp5.dominio;

public class Detalle {
    private int cantidad;
    private int codigoProducto;
    private double precioUnitario;
    private int descuento;
    private String descripcion;
    
    public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String detalle) {
		this.descripcion = detalle;
	}

	public Detalle() {
    }

    public Detalle(int cantidad, int codigoProducto, double precioUnitario, int descuento, String descripcion) {
        this.cantidad = cantidad;
        this.codigoProducto = codigoProducto;
        this.precioUnitario = precioUnitario;
        this.descuento = descuento;
    }
    

    public double calcularImporte() {
        double subtotal = this.cantidad * this.precioUnitario;
        if (this.descuento > 0) {
            subtotal = subtotal - (subtotal * (this.descuento / 100.0));
        }
        return subtotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Detalle [Cantidad=" + cantidad + ", CodigoProducto=" + codigoProducto + ", PrecioUnitario=$" + precioUnitario + ", Descripcion=$" + descripcion + ", Descuento=" + descuento + "%, Importe=$" + calcularImporte() + "]";
    }
}