/*

 */
package Modelo;

/**

 */
public class Detalle_Venta {
    private int idDetalleVenta;
    private int cantidad;
    private float precioVenta;
    private Venta venta;
    private Producto producto;

    public Detalle_Venta(int cantidad, float precioVenta, Venta venta, Producto producto) {
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.venta = venta;
        this.producto = producto;
    }

    public Detalle_Venta(int idDetalleVenta, int cantidad, float precioVenta, Venta venta, Producto producto) {
        this.idDetalleVenta = idDetalleVenta;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.venta = venta;
        this.producto = producto;
    }

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

   

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Detalle_Venta() {
    }

    @Override
    public String toString() {
        return "Detalle_Venta{" + "idDetalleVenta=" + idDetalleVenta + ", cantidad=" + cantidad + ", precioVenta=" + precioVenta + ", venta=" + venta + ", producto=" + producto + '}';
    }
    
}
