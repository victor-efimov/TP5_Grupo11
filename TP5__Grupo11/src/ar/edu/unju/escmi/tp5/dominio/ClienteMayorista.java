package ar.edu.unju.escmi.tp5.dominio;

public class ClienteMayorista extends Cliente {
    private int codigo;

    public ClienteMayorista() {
    }

    public ClienteMayorista(int dni, String nombre, String apellido, String domicilio, int codigo) {
        super(dni, nombre, apellido , domicilio);
        this.codigo = codigo;
    }

    public int getCodigo() { 
        return codigo; 
    }
    public void setCodigo(int codigo) { 
        this.codigo = codigo; 
    }
    
    public double calcularPrecioMayorista(double precioUnitario) {
        return precioUnitario / 2;
    }

    @Override
    public String toString() {
        return "ClienteMayorista{" +
                "dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", codigo=" + codigo +
                '}';
    }
}
