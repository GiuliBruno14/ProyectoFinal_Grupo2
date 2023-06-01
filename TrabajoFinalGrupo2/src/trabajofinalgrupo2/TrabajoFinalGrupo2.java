
package trabajofinalgrupo2;

import Controladores.ClientesData;
import Modelo.Cliente;

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
    cd.eliminarCliente(cl2);//eliminar cliente
    
    
    
    }
    
}
