package ar.edu.unju.escmi.tp5.dominio;

public class Stock{
	private static final int CANTIDAD_INICIAL = 500;
	Producto producto;
	private int cantidad;
	
	public Stock(Producto producto) {
		this.producto = producto;
		this.cantidad = CANTIDAD_INICIAL;
	}
	public int modificar(int cantidad) {
        int nueva = this.cantidad + cantidad;
        if (nueva < 0) {
            System.out.println("Error: Stock insuficiente");
            return -1;
        }
        this.cantidad = nueva; 
        return nueva;
    }
	public Producto getProducto() {
        return producto;
    }
 
    public int getCantidad() {
        return cantidad;
    }
}