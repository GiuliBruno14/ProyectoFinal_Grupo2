package Controladores;

import Modelo.Detalle_Venta;
import Modelo.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DetalleVentaData {

    private Connection con;

    public DetalleVentaData() {
        con = Conexion.getConexion();
    }

    public void agregarDetalleVenta(Detalle_Venta detalleV) {
        String sql = "INSERT INTO detalleventa(cantidad, precioVenta, id_venta, id_producto, estado) VALUES (?,?,?,?,?)";
        ProductoData pd = new ProductoData();
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, detalleV.getCantidad());
            ps.setFloat(2, detalleV.getPrecioVenta());
            ps.setInt(3, detalleV.getVenta().getIdVenta());
            ps.setInt(4, detalleV.getProducto().getIdProducto());
            ps.setBoolean(5, detalleV.isEstado());            
            detalleV.getProducto().setStock(detalleV.getProducto().getStock() - detalleV.getCantidad());
            pd.editarProducto(detalleV.getProducto());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) { 
                detalleV.setIdDetalleVenta(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Detalle Venta realizado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo realizar el Detalle Venta");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar el Detalle Venta" + ex);
        }
    }
    
    public void modificarDetalleVenta(Detalle_Venta detalleV){
        ProductoData pd = new ProductoData();
        String sql = "UPDATE detalleventa SET cantidad=?,precioVenta=?,id_venta=?,id_producto=?, estado=? WHERE id_detalleventa=?";
         
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, detalleV.getCantidad());
            ps.setFloat(2, detalleV.getPrecioVenta());
            ps.setInt(3, detalleV.getVenta().getIdVenta());
            ps.setInt(4, detalleV.getProducto().getIdProducto());
            ps.setBoolean(5, detalleV.isEstado());
            ps.setInt(6, detalleV.getIdDetalleVenta());
            detalleV.getProducto().setStock(detalleV.getProducto().getStock() - detalleV.getCantidad());
            pd.editarProducto(detalleV.getProducto());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "El Detalle Venta se modifico correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo Modificar el Detalle Venta" + ex);
        }
          
        
    }

    public void eliminarDetalleVenta(Detalle_Venta detalleV) {
        String sql = "UPDATE detalleventa SET estado=? WHERE id_detalleventa =?";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            detalleV.setEstado(false);
            ps.setBoolean(1, detalleV.isEstado());
            ps.setInt(2, detalleV.getIdDetalleVenta());            
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Detalle Venta eliminado correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el detalle venta" + ex);
        }

    }

    public Detalle_Venta buscarDetalleVenta(int id) {
        Detalle_Venta detalleV = null;
        String sql = "SELECT * FROM detalleventa WHERE id_detalleventa =?";
        VentaData vd = new VentaData();
        ProductoData pd = new ProductoData();
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                detalleV = new Detalle_Venta();
                detalleV.setIdDetalleVenta(id);
                detalleV.setCantidad(rs.getInt("cantidad"));
                detalleV.setPrecioVenta(rs.getFloat("precioVenta"));
                detalleV.setVenta(vd.buscarVenta(rs.getInt("id_venta")));
                detalleV.setProducto(pd.buscarProducto(rs.getInt("id_producto")));
                detalleV.setEstado(rs.getBoolean("estado"));
                
            } 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo buscar el detalle venta" + ex);
        }
        return detalleV;
    }

    public ArrayList<Detalle_Venta> listarDetalleVentas() {
        ArrayList<Detalle_Venta> detalleVtas = new ArrayList<>();
        VentaData vd = new VentaData();
        ProductoData pd = new ProductoData();
        Detalle_Venta detalleV;
        String sql = "SELECT * FROM detalleventa;";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                detalleV = new Detalle_Venta();
                detalleV.setIdDetalleVenta(rs.getInt("id_detalleventa"));
                detalleV.setCantidad(rs.getInt("cantidad"));
                detalleV.setPrecioVenta(rs.getFloat("precioVenta"));
                detalleV.setVenta(vd.buscarVenta(rs.getInt("id_venta")));
                detalleV.setProducto(pd.buscarProducto(rs.getInt("id_producto")));
                detalleV.setEstado(rs.getBoolean("estado"));
                detalleVtas.add(detalleV);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener la lista de detalle ventas" + ex);
        }
        if (detalleVtas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La base de datos se encuentra vacia");
        }
        return detalleVtas;
    }
    
    

}
