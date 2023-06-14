package trabajofinalgrupo2;

import Controladores.ClientesData;
import Controladores.CompraData;
import Controladores.DetalleCompraData;
import Controladores.DetalleVentaData;
import Controladores.ProductoData;
import Controladores.ProveedorData;
import Controladores.VentaData;
import Modelo.Cliente;
import Modelo.Compra;
import Modelo.DetalleCompra;
import Modelo.Detalle_Venta;
import Modelo.Producto;
import Modelo.Proveedor;
import Modelo.Venta;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/**
 *
 * @author Giulietta
 */
public class TrabajoFinalGrupo2 {

    public static void main(String[] args) {
        Cliente cl = new Cliente("Bruno", "Giulietta", "sucre 321", "2664878565");
        Cliente cl2 = new Cliente(5, "Araujo", "Nicolas", "sucre 50", "2664689899");
        ClientesData cd = new ClientesData();
//  cd.agregarCliente(cl); //agregar cliente
//  cd.editarCliente(cl2); //actualizar cliente
//    cd.eliminarCliente(cl2);//eliminar cliente
        Proveedor p1 = new Proveedor("Compuserve", "Ayacucho 321", "2665321546");
        Proveedor p2 = new Proveedor(3, "Compuserve", "Ayacucho 777", "2665321546");
        ProveedorData pd = new ProveedorData();
//   pd.agregarProveedor(p1);
//   pd.editarProveedor(p2); 
//   pd.eliminarProveedor(p2);
        Producto prod1 = new Producto("Microondas", 50000, 2);
        Producto prod2 = new Producto(3, "Microondas", 70000, 2);
        ProductoData prodData = new ProductoData();
//    prodData.agregarProducto(prod1);
//  prodData.editarProducto(prod2);
//   prodData.eliminarProducto(prod2);
        Venta v1 = new Venta(LocalDate.of(2023, 6, 7), cl);
        Venta v2 = new Venta(2, LocalDate.of(2023, 6, 5), cl);
        VentaData vd = new VentaData();
        //vd.realizarVenta(v1);
        //  vd.modificarVenta(v2);
//    vd.eliminarVenta(v2);
        Compra com1 = new Compra(p1, LocalDate.of(2023, 6, 6));
        CompraData comd = new CompraData();
//    comd.realizarCompra(com1);
       Proveedor proved = pd.buscarProveedor(1);
        Compra com2 =new Compra(1,proved,LocalDate.of(2023, 4, 12));
 //      comd.editarCompra(com2);
//        System.out.println(pd.buscarProveedor(1));
//        System.out.println(comd.buscarCompra(1));
//        System.out.println(vd.buscarVenta(1));
//        ArrayList<Cliente> clientes = new ArrayList<>();
//        clientes = cd.listarClientes();
//        for (Cliente c : clientes) {
//            System.out.println(c);
//        }
//        ArrayList <Proveedor> proveedores=new ArrayList<>();
//        proveedores =pd.listarProveedores();
//        for(Proveedor p: proveedores){
//            System.out.println(p);
//        }
//        ArrayList <Producto> productos=new ArrayList<>();
//        productos =prodData.listarProductos();
//        for(Producto p: productos){
//            System.out.println(p);
//        }
//        ArrayList <Compra> compras=new ArrayList<>();
//        compras =comd.listarCompras();
//        for(Compra c: compras){
//            System.out.println(c);
//        }
//        ArrayList <Venta> ventas=new ArrayList<>();
//        ventas =vd.listarVentas();
//        for(Venta v: ventas){
//            System.out.println(v);
//        }
        DetalleVentaData dvd = new DetalleVentaData();
        Venta ven = new Venta();
 //      ven = vd.buscarVenta(1);
        Producto produ = new Producto();
      produ = prodData.buscarProducto(1);
        Detalle_Venta dv = new Detalle_Venta(1,80000,produ);
//       dvd.agregarDetalleVenta(dv);
        //dvd.eliminarDetalleVenta(dv);
      //  System.out.println(dvd.buscarDetalleVenta(1));
        ArrayList <Detalle_Venta> detalleVtas =new ArrayList<>();
        detalleVtas = dvd.listarDetalleVentas();
        for(Detalle_Venta v: detalleVtas){
           System.out.println(v);
       }
        Venta ventnueva = new Venta(LocalDate.of(2023, 6, 7), cl2);
        ventnueva=vd.buscarVenta(1);
       // ventnueva.setFecha(LocalDate.of(2023,6,9));
       // vd.modificarVenta(ventnueva);
       
        dv=dvd.buscarDetalleVenta(1);
        
//        vd.eliminarVenta(ventnueva, dv);
// vd.realizarVenta(ventnueva, dv);
        CompraData compD=new CompraData();
        
        DetalleCompraData dcd=new DetalleCompraData();
        System.out.println(prodData.buscarPorNombre("Heladera"));
//        System.out.println(dcd.buscarDetalleCompra(1));
//        ArrayList <DetalleCompra> detalleComp =new ArrayList<>();
//        detalleComp =dcd.listarDetalleCompras();
//       for(DetalleCompra c: detalleComp){
//           System.out.println(c);
//       }
              
                
//        Compra compra2 = new Compra(proved,LocalDate.of(2023,6, 8));
//        DetalleCompra dc1= new DetalleCompra(2,2000,compra2,produ);
//        compD.realizarCompra(compra2, dc1);
       
}
}
