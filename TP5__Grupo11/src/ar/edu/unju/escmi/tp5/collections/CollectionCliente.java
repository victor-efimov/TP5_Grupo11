package ar.edu.unju.escmi.tp5.collections;
 
import java.util.HashMap;
import java.util.Map;
 
import ar.edu.unju.escmi.tp5.dominio.Cliente;
import ar.edu.unju.escmi.tp5.dominio.ClienteMayorista;
import ar.edu.unju.escmi.tp5.dominio.ClienteMinorista;
 
public class CollectionCliente {
    // La clve del map es el DNI
    public static Map<Integer, Cliente> clientes = new HashMap<>();
 
    public static void guardarCliente(Cliente cliente) {
        clientes.put(cliente.getDni(), cliente);
    }
 
    public static Cliente buscarCliente(int dni) {
        return clientes.get(dni);
    }
 
    public static void precargarCliente() {
        guardarCliente(new ClienteMayorista(123, "Carlos","Pérez", "Av. Siempre Viva", 1001));
        guardarCliente(new ClienteMinorista(456, "Ana","Gómez", "Calle Belgrano", "PAMI"));
        guardarCliente(new ClienteMinorista(789, "Luis","López", "Calle Lavalle", "OSEP"));
    }
}