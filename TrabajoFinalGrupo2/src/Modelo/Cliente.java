/*

 */
package Modelo;

/**
 
 */
public class Cliente {
    private int idCliente ;
    private String apellido;
    private String nombre;
    private String domicilio;
    private Long telefono;

    public Cliente(String apellido, String nombre, String domicilio, Long telefono) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }

    public Cliente() {
    }

    public Cliente(int idCliente, String apellido, String nombre, String domicilio, Long telefono) {
        this.idCliente = idCliente;
        this.apellido = apellido;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", apellido=" + apellido + ", nombre=" + nombre + ", domicilio=" + domicilio + ", telefono=" + telefono + '}';
    }
    
    
    
}
