
package Controladores;

import Modelo.Proveedor;
import java.sql.Connection;

public class ProveedorData {
    private Connection con;

    public ProveedorData(Connection con) {
        con = Conexion.getConexion();
    }
    
    public void agregarProveedor(Proveedor proveedor) {
    
    }
    
}
