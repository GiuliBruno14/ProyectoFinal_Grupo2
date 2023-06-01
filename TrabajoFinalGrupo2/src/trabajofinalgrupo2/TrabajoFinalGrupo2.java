
package trabajofinalgrupo2;

import Controladores.ClientesData;
import Controladores.ProveedorData;
import Modelo.Cliente;
import Modelo.Proveedor;

/**
 *
 * @author Giulietta
 */
public class TrabajoFinalGrupo2 {

    public static void main(String[] args) {
    Cliente cl = new Cliente("Bruno","Giulietta", "sucre 321","2664878565");
    Cliente cl2 = new Cliente(3,"Bruno","Giulietta", "sucre 32","2664567899");
    ClientesData cd =new ClientesData();
    //cd.agregarCliente(cl); //agregar cliente
    //cd.editarCliente(cl2); //actualizar cliente
//    cd.eliminarCliente(cl2);//eliminar cliente
    Proveedor p1=new Proveedor("Compuserve","Ayacucho 321","2665321546");
    Proveedor p2=new Proveedor(3,"Compuserve","Ayacucho 777","2665321546");  
    ProveedorData pd=new ProveedorData();
    pd.editarProveedor(p2);
//    pd.agregarProveedor(p1);
    pd.eliminarProveedor(p2);
    
    
    }
    
}
