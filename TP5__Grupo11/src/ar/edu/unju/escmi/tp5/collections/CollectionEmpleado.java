package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.escmi.tp5.dominio.Empleado;

public class CollectionEmpleado {
    public static List<Empleado> empleados = new ArrayList<>();

    public static void guardarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public static Empleado buscarEmpleado(int idEmpleado) {
        for (Empleado e : empleados) {
            if (e.getIdEmpleado() == idEmpleado) {
                return e;
            }
        }
        return null;
    }

    public static void precargarEmpleado() {
        if (empleados.isEmpty()) {
            guardarEmpleado(new Empleado(1, "Belgrano 123", 40111222, "Perez", "Juan"));
        }
    }
}