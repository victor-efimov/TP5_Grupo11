package ar.edu.unju.escmi.tp5.dominio;

public class Empleado {
    protected int idEmpleado;
    protected String domicilio;
    protected int dni;
    protected String apellido;
    protected String nombre;

    public Empleado() {
    }

    public Empleado(int idEmpleado, String domicilio, int dni, String apellido, String nombre) {
        this.idEmpleado = idEmpleado;
        this.domicilio = domicilio;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}