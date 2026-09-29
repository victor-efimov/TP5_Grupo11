package ar.edu.unju.escmi.tp5.dominio;

import ar.edu.unju.escmi.tp5.collections.CollectionFactura;
import ar.edu.unju.escmi.tp5.collections.CollectionStock;

public class EncargadoVentas extends Empleado {

    public EncargadoVentas() {
        super();
    }

    public EncargadoVentas(int idEmpleado, String domicilio, int dni, String apellido, String nombre) {
        super(idEmpleado, domicilio, dni, apellido, nombre);
    }

    public double mostrarTotalVentas() {
        return CollectionFactura.calcularTotalVentas();
    }

    public String mostrarVentas() {
        if (CollectionFactura.getFacturas().isEmpty()) {
            return "No hay ventas registradas.";
        }
        StringBuilder sb = new StringBuilder();
        for (Factura f : CollectionFactura.getFacturas().values()) {
            sb.append(f.mostrarFactura()).append("\n\n");
        }
        return sb.toString();
    }

    public int verificarStock(int codigoProducto) {
        Stock stock = CollectionStock.buscarStock(codigoProducto);
        if (stock != null) {
            return stock.getCantidad();
        }
        return 0;
    }
}