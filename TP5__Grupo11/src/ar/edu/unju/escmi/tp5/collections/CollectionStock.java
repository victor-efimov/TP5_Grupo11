package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp5.dominio.Producto;
import ar.edu.unju.escmi.tp5.dominio.Stock;

public class CollectionStock{
	
	public static List<Stock> stock = new ArrayList<>();
	
	 public static Stock buscarStock(int codigoProducto) {
	        for (Stock s : stock) {
	            if (s.getProducto().getCodigoProducto() == codigoProducto) {
	                return s;
	            }
	        }
	        return null;
	    }
	 public static void actualizarStock(int codigoProducto, int cantidad) {
	        Stock s = buscarStock(codigoProducto);
	        if (s == null) {
	            System.out.println("No hay stock del producto");
	        }
	        else {
	        s.modificar(cantidad);
	        }
	    }
	 public static void precargarStock() {
	        for (Producto p : CollectionProducto.productos) {
	            if (buscarStock(p.getCodigoProducto()) == null) {
	                stock.add(new Stock(p));
	            }
	        }
	    }
	
}