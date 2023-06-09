/*

 */
package Controladores;

import Modelo.Compra;
import Modelo.DetalleCompra;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CompraData {

    private Connection con;

    public CompraData() {
        con = Conexion.getConexion();

    }

    public void realizarCompra(Compra compra, DetalleCompra detalleC) {
        String sql = "INSERT INTO compra(id_proveedor, fecha) VALUES (?,?)";
        DetalleCompraData dcd=new DetalleCompraData();
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, compra.getProveedor().getIdProveedor());
            ps.setDate(2, Date.valueOf(compra.getFecha()));
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {                
                compra.setIdCompra(rs.getInt(1));
                
                detalleC.setCompra(compra);
                dcd.agregarDetalleCompra(detalleC);
                JOptionPane.showMessageDialog(null, "Compra realizada correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo realizar la compra");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompraData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    

    public Compra buscarCompra(int id) {
        Compra compra = null;
        String sql = "SELECT id_compra, id_proveedor, fecha FROM compra WHERE id_compra=?";
        ProveedorData pd = new ProveedorData();
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                compra = new Compra();
                compra.setIdCompra(id);
                compra.setProveedor(pd.buscarProveedor(rs.getInt("id_proveedor")));
                compra.setFecha(rs.getDate("fecha").toLocalDate());
            } else {
                JOptionPane.showMessageDialog(null, "Compra inexistente");
            }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "No se pudo buscar la compra"+ex);
        }
        return compra;
    }
    
    public ArrayList<Compra> listarCompras() {
        ArrayList<Compra> compras = new ArrayList<>();
        ProveedorData pd = new ProveedorData();
        Compra compra;
        String sql = "SELECT * FROM compra;";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                compra = new Compra();
                compra.setIdCompra(rs.getInt("id_compra"));
                compra.setProveedor(pd.buscarProveedor(rs.getInt("id_proveedor")));
                compra.setFecha(rs.getDate("fecha").toLocalDate());
                compras.add(compra);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener la lista de compra" + ex);
        }
        if (compras.isEmpty()) {
            JOptionPane.showMessageDialog(null, "la base de datos se encuentra vacia");
        }
    return compras;
    }
}
