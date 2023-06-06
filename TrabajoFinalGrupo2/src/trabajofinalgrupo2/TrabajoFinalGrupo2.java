
package trabajofinalgrupo2;

import Controladores.ClientesData;
import Controladores.ProductoData;
import Controladores.ProveedorData;
import Controladores.VentaData;
import Modelo.Cliente;
import Modelo.Producto;
import Modelo.Proveedor;
import Modelo.Venta;
import java.time.LocalDate;

/**
 *
 * @author Giulietta
 */
public class TrabajoFinalGrupo2 {

    public static void main(String[] args) {
    Cliente cl = new Cliente("Bruno","Giulietta", "sucre 321","2664878565");
    Cliente cl2 = new Cliente(5,"Araujo","Nicolas", "sucre 50","2664689899");
    ClientesData cd =new ClientesData();
//  cd.agregarCliente(cl); //agregar cliente
//  cd.editarCliente(cl2); //actualizar cliente
//    cd.eliminarCliente(cl2);//eliminar cliente
    Proveedor p1=new Proveedor("Compuserve","Ayacucho 321","2665321546");
    Proveedor p2=new Proveedor(3,"Compuserve","Ayacucho 777","2665321546");  
    ProveedorData pd=new ProveedorData();
//   pd.agregarProveedor(p1);
//   pd.editarProveedor(p2); 
//   pd.eliminarProveedor(p2);
    Producto prod1 = new Producto("Microondas",50000,2,true);
    Producto prod2 = new Producto(3,"Microondas",70000,2,true);
    ProductoData prodData = new ProductoData();
//    prodData.agregarProducto(prod1);
//  prodData.editarProducto(prod2);
//   prodData.eliminarProducto(prod2);
    Venta v1 = new Venta(LocalDate.of(2023, 6, 6),cl);
    Venta v2 = new Venta(2,LocalDate.of(2023, 6, 5),cl);
    VentaData vd = new VentaData();
    //vd.realizarVenta(v1);
  //  vd.modificarVenta(v2);
    vd.eliminarVenta(v2);
    }
    
}
