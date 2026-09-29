package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.escmi.tp5.dominio.Producto;

public class CollectionProducto {
    public static List<Producto> productos = new ArrayList<>();

    public static void guardarProducto(Producto producto) {
        productos.add(producto);
    }

    public static Producto buscarProducto(int codigoProducto) {
        for (Producto p : productos) {
            if (p.getCodigoProducto() == codigoProducto) {
                return p;
            }
        }
        return null;
    }

    public static void precargarProducto() {
        if (productos.isEmpty()) {
            guardarProducto(new Producto(1001, "Fideo Knorr Spaghetti x 500 gr", 1200.00, 0));
            guardarProducto(new Producto(1002, "Arroz Lucchetti x 1 kg", 1800.00, 25));
            guardarProducto(new Producto(1003, "Aceite Natura x 900 ml", 2500.00, 30));
        }
    }
}