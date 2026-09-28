package ar.edu.unju.escmi.tp5.collections;
 
import java.util.HashMap;
import java.util.Map;
 
import ar.edu.unju.escmi.tp5.dominio.Factura;
 
public class CollectionFactura {
    // La clave del map es el número de factura
    public static Map<Integer, Factura> facturas = new HashMap<>();
 
    public static void guardarFactura(Factura factura) {
        facturas.put(factura.getNumeroFactura(), factura);
    }
 
    public static Factura buscarFactura(int numeroFactura) {
        return facturas.get(numeroFactura);
    }
    
    public static void mostrarTodasFacturas() {
        if (facturas.isEmpty()) {
            System.out.println("No hay ventas registradas.");
            return;
        }
        for (Factura f : facturas.values()) {
            System.out.println(f.mostrarFactura());
            System.out.println();
        }
    }

    public static double calcularTotalVentas() {
        double total = 0;
        for (Factura f : facturas.values()) {
            total += f.calcularTotal();
        }
        return total;
    }
 
    public static Map<Integer, Factura> getFacturas() {
        return facturas;
    }
}
 