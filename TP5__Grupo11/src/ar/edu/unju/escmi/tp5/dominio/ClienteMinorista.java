package ar.edu.unju.escmi.tp5.dominio;

public class ClienteMinorista extends Cliente {
    private String obraSocial;

    public ClienteMinorista() {
    	
    }
    public ClienteMinorista(int dni, String nombre,String apellido, String domicilio, String obraSocial) {
        super(dni, nombre, apellido, domicilio);
        this.obraSocial = obraSocial;
    }

    public String getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(String obraSocial) {
        this.obraSocial = obraSocial;
    }

    @Override
    public String toString() {
        return "ClienteMinorista{" +
                "dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", obraSocial='" + obraSocial + '\'' +
                '}';
    }

    
    public boolean tieneDescuento() {
        return dni > 0 && obraSocial != null && obraSocial.equalsIgnoreCase("PAMI");
    }

    public double aplicarDescuento(double precio) {
        if (tieneDescuento()) {
            System.out.println("El cliente tiene un descuento del 10% en la compra.");
            return precio * 0.9; // 10% de descuento
        } else {
            System.out.println("El cliente no aplica para el descuento de PAMI.");
            return precio;
        }
    }

}
