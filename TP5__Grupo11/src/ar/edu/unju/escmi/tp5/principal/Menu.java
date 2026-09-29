package ar.edu.unju.escmi.tp5.principal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import ar.edu.unju.escmi.tp5.collections.CollectionCliente;
import ar.edu.unju.escmi.tp5.collections.CollectionEmpleado;
import ar.edu.unju.escmi.tp5.collections.CollectionProducto;
import ar.edu.unju.escmi.tp5.collections.CollectionStock;
import ar.edu.unju.escmi.tp5.dominio.AgenteAdministrativo;
import ar.edu.unju.escmi.tp5.dominio.Cliente;
import ar.edu.unju.escmi.tp5.dominio.ClienteMayorista;
import ar.edu.unju.escmi.tp5.dominio.Detalle;
import ar.edu.unju.escmi.tp5.dominio.Empleado;
import ar.edu.unju.escmi.tp5.dominio.EncargadoVentas;
import ar.edu.unju.escmi.tp5.dominio.Factura;
import ar.edu.unju.escmi.tp5.dominio.Producto;
import ar.edu.unju.escmi.tp5.dominio.Stock;

public class Menu {

    
    private static final int UNIDADES_POR_BULTO = 10;

    
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        
        CollectionCliente.precargarCliente();
        CollectionEmpleado.precargarEmpleado();
        asegurarPerfilesEmpleados();
        CollectionProducto.precargarProducto();
        CollectionStock.precargarStock();

        
        int opcion;
        do {
            System.out.println();
            System.out.println("=== SISTEMA DE VENTAS DE COMESTIBLES ===");
            System.out.println("1 - Encargado de ventas");
            System.out.println("2 - Cliente");
            System.out.println("3 - Agente administrativo");
            System.out.println("0 - Salir");
            opcion = leerEntero("Seleccione su perfil: ");

            switch (opcion) {
                case 1: menuEncargado(); break;
                case 2: menuCliente(); break;
                case 3: menuAgente(); break;
                case 0: System.out.println("Hasta luego."); break;
                default: System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);

        sc.close();
    }

    private static void asegurarPerfilesEmpleados() {
        boolean hayEncargado = false;
        boolean hayAgente = false;
        for (Empleado e : CollectionEmpleado.empleados) {
            if (e instanceof EncargadoVentas) {
                hayEncargado = true;
            }
            if (e instanceof AgenteAdministrativo) {
                hayAgente = true;
            }
        }
        
        if (!hayEncargado) {
            CollectionEmpleado.guardarEmpleado(
                    new EncargadoVentas(idLibre(), "Alvear 200", 30111222, "Torres", "Mario"));
        }
        if (!hayAgente) {
            CollectionEmpleado.guardarEmpleado(
                    new AgenteAdministrativo(idLibre(), "Sarmiento 300", 30222333, "Diaz", "Laura"));
        }
    }

    
    private static int idLibre() {
        int id = 1;
        while (CollectionEmpleado.buscarEmpleado(id) != null) {
            id++;
        }
        return id;
    }
    private static void menuEncargado() {
        Empleado e = identificarEmpleado();
        if (e == null) {
            return; 
        }
        
        if (!(e instanceof EncargadoVentas)) {
            System.out.println("Ese empleado no es Encargado de ventas.");
            return;
        }
        EncargadoVentas encargado = (EncargadoVentas) e;

        int opcion;
        do {
            System.out.println();
            System.out.println("--- ENCARGADO DE VENTAS ---");
            System.out.println("1 - Mostrar las ventas");
            System.out.println("2 - Mostrar el total de todas las ventas");
            System.out.println("3 - Verificar stock de un producto");
            System.out.println("0 - Volver");
            opcion = leerEntero("Opcion: ");

            switch (opcion) {
                case 1:
                    System.out.println(encargado.mostrarVentas());
                    break;
                case 2:
                    System.out.println("Total de ventas: $" + formatear(encargado.mostrarTotalVentas()));
                    break;
                case 3:
                    verificarStock(encargado);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);
    }

    private static void verificarStock(EncargadoVentas encargado) {
        int codigo = leerEntero("Codigo de producto: ");
        Stock s = CollectionStock.buscarStock(codigo);
        if (s == null) {
            System.out.println("No existe stock para el codigo " + codigo + ".");
        } else {
            System.out.println("Producto: " + s.getProducto().getDescripcion());
            System.out.println("Stock disponible: " + encargado.verificarStock(codigo) + " unidades");
        }
    }

    private static void menuCliente() {
        int dni = leerEntero("Ingrese su DNI: ");
        Cliente cliente = CollectionCliente.buscarCliente(dni);
        if (cliente == null) {
            System.out.println("No existe un cliente con DNI " + dni + ".");
            return;
        }
        System.out.println("Bienvenido/a " + cliente.getNombre());

        int opcion;
        do {
            System.out.println();
            System.out.println("--- CLIENTE ---");
            System.out.println("1 - Buscar factura");
            System.out.println("0 - Volver");
            opcion = leerEntero("Opcion: ");

            switch (opcion) {
                case 1:
                    int numero = leerEntero("Numero de factura: ");
                    Factura f = cliente.buscarFactura(numero);
                    if (f != null) {
                        System.out.println(f.mostrarFactura());
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);
    }
    private static void menuAgente() {
        Empleado e = identificarEmpleado();
        if (e == null) {
            return;
        }
        if (!(e instanceof AgenteAdministrativo)) {
            System.out.println("Ese empleado no es Agente administrativo.");
            return;
        }
        AgenteAdministrativo agente = (AgenteAdministrativo) e;

        int opcion;
        do {
            System.out.println();
            System.out.println("--- AGENTE ADMINISTRATIVO ---");
            System.out.println("1 - Alta de producto");
            System.out.println("2 - Realizar venta");
            System.out.println("0 - Volver");
            opcion = leerEntero("Opcion: ");

            switch (opcion) {
                case 1: altaProducto(agente); break;
                case 2: realizarVenta(agente); break;
                case 0: break;
                default: System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);
    }

    private static void altaProducto(AgenteAdministrativo agente) {
        int codigo = leerEntero("Codigo de producto: ");
        if (codigo <= 0) {
            System.out.println("El codigo debe ser mayor a 0.");
            return;
        }
   if (CollectionProducto.buscarProducto(codigo) != null) {
            System.out.println("Ya existe un producto con el codigo " + codigo + ".");
            return;
        }

        String descripcion = leerTexto("Descripcion: ");
        double precio = leerPrecio("Precio unitario: ");

        int descuento;
        do {
            descuento = leerEntero("Descuento (0, 25 o 30): ");
            if (descuento != 0 && descuento != 25 && descuento != 30) {
                System.out.println("El descuento solo puede ser 0, 25 o 30.");
            }
        } while (descuento != 0 && descuento != 25 && descuento != 30);
        agente.altaProducto(new Producto(codigo, descripcion, precio, descuento));
        CollectionStock.precargarStock();
    }

    private static void realizarVenta(AgenteAdministrativo agente) {
        int dni = leerEntero("DNI del cliente: ");
        Cliente cliente = CollectionCliente.buscarCliente(dni);
        if (cliente == null) {
            System.out.println("No existe un cliente con DNI " + dni + ".");
            return;
        }
        boolean esMayorista = cliente instanceof ClienteMayorista;
        System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getApellido()
                + (esMayorista ? " (mayorista, compra por bulto)" : " (minorista, compra por unidad)"));

        List<Detalle> detalles = new ArrayList<>();
        Map<Integer, Integer> pedido = new HashMap<>();
        while (true) {
            int codigo = leerEntero("Codigo de producto (0 para terminar): ");
            if (codigo == 0) {
                break;
            }

            Producto producto = CollectionProducto.buscarProducto(codigo);
            if (producto == null) {
                System.out.println("No existe el producto " + codigo + ".");
                continue;
            }
            Stock stock = CollectionStock.buscarStock(codigo);
            if (stock == null) {
                System.out.println("El producto no tiene stock cargado.");
                continue;
            }

            int cantidad = leerEntero(esMayorista
                    ? "Cantidad de bultos (" + UNIDADES_POR_BULTO + " unidades c/u): "
                    : "Cantidad de unidades: ");
            if (cantidad <= 0) {
                System.out.println("La cantidad debe ser mayor a 0.");
                continue;
            }

            int unidades = esMayorista ? cantidad * UNIDADES_POR_BULTO : cantidad;
            int yaPedido = pedido.getOrDefault(codigo, 0);
            if (unidades + yaPedido > stock.getCantidad()) {
                System.out.println("Stock insuficiente. Disponible: "
                        + (stock.getCantidad() - yaPedido) + " unidades.");
                continue;
            }

            double precio = producto.getPrecioUnitario();
            if (esMayorista) {
                precio = ((ClienteMayorista) cliente).calcularPrecioMayorista(precio);
            }

            Detalle detalle = new Detalle(unidades, producto.getCodigoProducto(), precio,
                    producto.getDescuento(), producto.getDescripcion());
            detalles.add(detalle);
            pedido.put(codigo, yaPedido + unidades);

            System.out.println("Agregado: " + unidades + " u. de " + producto.getDescripcion());
        }

        if (detalles.isEmpty()) {
            System.out.println("Venta cancelada: no se cargaron productos.");
            return;
        }

        Factura factura = agente.realizarVenta(cliente, detalles);

        System.out.println();
        System.out.println("Venta registrada.");
        System.out.println(factura.mostrarFactura());
    }

    private static Empleado identificarEmpleado() {
        int id = leerEntero("Ingrese su id de empleado: ");
        Empleado e = CollectionEmpleado.buscarEmpleado(id);
        if (e == null) {
            System.out.println("Empleado inexistente.");
        } else {
            System.out.println("Bienvenido/a " + e.getNombre() + " " + e.getApellido());
        }
        return e;
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String linea = sc.nextLine().trim();
            try {
                return Integer.parseInt(linea);
            } catch (NumberFormatException ex) {
                System.out.println("Valor invalido. Ingrese un numero entero.");
            }
        }
    }

    private static double leerPrecio(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String linea = sc.nextLine().trim().replace(',', '.');
            try {
                double valor = Double.parseDouble(linea);
                if (valor > 0) {
                    return valor;
                }
                System.out.println("El precio debe ser mayor a 0.");
            } catch (NumberFormatException ex) {
                System.out.println("Valor invalido. Ingrese un numero decimal.");
            }
        }
    }

    private static String leerTexto(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String linea = sc.nextLine().trim();
            if (!linea.isEmpty()) {
                return linea;
            }
            System.out.println("El texto no puede estar vacio.");
        }
    }

    private static String formatear(double monto) {
        return String.format("%.2f", monto);
    }
}