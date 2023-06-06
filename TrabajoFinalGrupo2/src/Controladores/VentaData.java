
package Controladores;

import Modelo.Venta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class VentaData {
    private Connection con;

    public VentaData() {
        con = Conexion.getConexion();
    }
    
    public void realizarVenta(Venta venta){
        String sql = "INSERT INTO venta(fecha, id_cliente) VALUES (?,?);";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1,Date.valueOf(venta.getFecha()));
            ps.setInt(2,venta.getCliente().getIdCliente());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                venta.setIdVenta(rs.getInt(1));
                JOptionPane.showMessageDialog(null,"Venta realizada correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo realizar la venta");
            }
        } catch (SQLException ex) {
            Logger.getLogger(VentaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modificarVenta(Venta venta){
        String sql = "UPDATE venta SET fecha=?,id_cliente=? WHERE id_venta=?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1,Date.valueOf(venta.getFecha()));
            ps.setInt(2,venta.getCliente().getIdCliente());
            ps.setInt(3,venta.getIdVenta());
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null,"Venta modificada correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"No se pudo modificar la venta");
        }
    }
    
    public void eliminarVenta(Venta venta){
        String sql ="DELETE FROM venta WHERE id_venta=?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,venta.getIdVenta());
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null,"Venta eliminada correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"No se pudo eliminar la venta");
        }
    }
  
    public Venta buscarVenta(int id) {
        Venta venta = null;
        String sql = "SELECT * FROM venta WHERE id_venta=?";
      ClientesData cd = new ClientesData();
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                venta = new Venta();
                venta.setIdVenta(id);
                venta.setCliente(cd.buscarCliente(rs.getInt("id_cliente")));
                venta.setFecha(rs.getDate("fecha").toLocalDate());
            } else {
                JOptionPane.showMessageDialog(null, "Venta inexistente");
            }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "No se pudo buscar la venta"+ex);
        }
        return venta;
    }  
}
