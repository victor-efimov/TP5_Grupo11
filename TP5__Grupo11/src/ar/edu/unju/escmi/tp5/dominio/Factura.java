package ar.edu.unju.escmi.tp5.dominio;
 
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
 
public class Factura {
    private static int contador = 1;
 
    private int numeroFactura;
    private LocalDate fecha;
    private Cliente cliente;
    private List<Detalle> detalles = new ArrayList<>();
 
    public Factura() {
        this.numeroFactura = contador++;
    }
 
    public Factura(LocalDate fecha, Cliente cliente) {
        this.numeroFactura = contador++;
        this.fecha = fecha;
        this.cliente = cliente;
    }
 
    public int getNumeroFactura() {
        return numeroFactura;
    }
 
    public Cliente getCliente() {
        return cliente;
    }
 
    public LocalDate getFecha() {
        return fecha;
    }
 
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
 
    public List<Detalle> getDetalles() {
        return detalles;
    }
 
    public void setDetalles(List<Detalle> detalles) {
        this.detalles = detalles;
    }
 
    public void agregarDetalle(Detalle detalle) {
        detalles.add(detalle);
    }
 
    public double calcularTotal() {
        double total = 0;
        for (Detalle d : detalles) {
            total += d.calcularImporte();
        }
        if (cliente instanceof ClienteMinorista) {
            total = ((ClienteMinorista) cliente).aplicarDescuento(total);
        }
        return total;
    }
 
    public String mostrarFactura() {
        StringBuilder sb = new StringBuilder();
        sb.append("----- FACTURA -----\n");
        sb.append("N°: ").append(numeroFactura).append("\n");
        sb.append("Fecha: ").append(fecha).append("\n");
        sb.append("Cliente: ").append(cliente.getNombre()).append("\n");
        sb.append("DNI: ").append(cliente.getDni()).append("\n");
        sb.append("Dirección: ").append(cliente.getDomicilio()).append("\n");
        sb.append("-------------------\n");
        sb.append("DETALLE:\n");
        for (Detalle d : detalles) {
            sb.append("Cantidad: ").append(d.getCantidad()).append("\t")
              .append("Descripción: ").append(d.getDescripcion()).append("\t")
              .append("Precio Unitario: ").append(d.getPrecioUnitario()).append("\t")
              .append("Importe: ").append(d.calcularImporte()).append("\n");
        }
        sb.append("-------------------\n");
        if (cliente instanceof ClienteMinorista
                && ((ClienteMinorista) cliente).tieneDescuento()) {
            sb.append("Descuento PAMI (10%) aplicado\n");
        }
        sb.append("TOTAL: ").append(calcularTotal());
        return sb.toString();
    }
}
