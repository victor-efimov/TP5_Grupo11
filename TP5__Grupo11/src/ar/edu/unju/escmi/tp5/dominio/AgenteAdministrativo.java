package ar.edu.unju.escmi.tp5.dominio;

import java.time.LocalDate;
import java.util.List;

import ar.edu.unju.escmi.tp5.collections.CollectionFactura;
import ar.edu.unju.escmi.tp5.collections.CollectionProducto;
import ar.edu.unju.escmi.tp5.collections.CollectionStock;

public class AgenteAdministrativo extends Empleado {

    public AgenteAdministrativo() {
        super();
    }

    public AgenteAdministrativo(int idEmpleado, String domicilio, int dni, String apellido, String nombre) {
        super(idEmpleado, domicilio, dni, apellido, nombre);
    }

    public void altaProducto(Producto producto) {
        if (CollectionProducto.buscarProducto(producto.getCodigoProducto()) == null) {
            CollectionProducto.guardarProducto(producto);
            System.out.println("Producto dado de alta correctamente: " + producto.getDescripcion());
        } else {
            System.out.println("El producto con código " + producto.getCodigoProducto() + " ya se encuentra registrado.");
        }
    }

    public Factura realizarVenta(Cliente cliente, List<Detalle> detalles) {
        Factura factura = new Factura(LocalDate.now(), cliente);
        
        for (Detalle detalle : detalles) {
            factura.agregarDetalle(detalle);
            CollectionStock.actualizarStock(detalle.getCodigoProducto(), -detalle.getCantidad());
        }
        
        CollectionFactura.guardarFactura(factura);
        return factura;
    }
}