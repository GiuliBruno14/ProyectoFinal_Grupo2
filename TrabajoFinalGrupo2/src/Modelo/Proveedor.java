
package Modelo;

/**
 
 */
public class Proveedor {
    private int idProveedor;
    private String razonSocial;
    private String domicilio;
    private long telefono;

    public int getIdProveedor() {
        return idProveedor;
    }


    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public Proveedor(String razonSocial, String domicilio, long telefono) {
        this.razonSocial = razonSocial;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }

    public Proveedor(int idProveedor, String razonSocial, String domicilio, long telefono) {
        this.idProveedor = idProveedor;
        this.razonSocial = razonSocial;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }

    public Proveedor() {

    }
        @Override
    public String toString() {
        return "Proveedor{" + "idProveedor=" + idProveedor + ", razonSocial=" + razonSocial + ", domicilio=" + domicilio + ", telefono=" + telefono + '}';
    }


}
