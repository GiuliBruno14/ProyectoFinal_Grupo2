package Controladores;

import Modelo.Detalle_Venta;
import Modelo.Venta;
import java.sql.Connection;
import java.sql.Date;
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

public class VentaData {

    private Connection con;

    public VentaData() {
        con = Conexion.getConexion();
    }

    public void realizarVenta(Venta venta, Detalle_Venta detalleV) {
        String sql = "INSERT INTO venta(fecha, id_cliente, estado) VALUES (?,?,?);";
        DetalleVentaData dvd = new DetalleVentaData();
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            if (detalleV.getCantidad() <= detalleV.getProducto().getStock()) {
                ps.setDate(1, Date.valueOf(venta.getFecha()));
                ps.setInt(2, venta.getCliente().getIdCliente());
                ps.setBoolean(3, venta.isEstado());
                
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    venta.setIdVenta(rs.getInt(1));
                    detalleV.setVenta(venta);
                    dvd.agregarDetalleVenta(detalleV);
                    JOptionPane.showMessageDialog(null, "Venta realizada correctamente");

                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo realizar la venta");
                }
            } else {
                JOptionPane.showMessageDialog(null,"No hay suficiente stock para realizar la venta");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la venta" + ex);
        }
    }

    public void modificarVenta(Venta venta, Detalle_Venta detalleV) {
        String sql = "UPDATE venta SET fecha=?,id_cliente=?, estado=? WHERE id_venta=?;";
        DetalleVentaData dvd = new DetalleVentaData();
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, Date.valueOf(venta.getFecha()));
            ps.setInt(2, venta.getCliente().getIdCliente());
            ps.setBoolean(3, venta.isEstado());
            ps.setInt(4, venta.getIdVenta());  
            dvd.modificarDetalleVenta(detalleV);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Venta modificada correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo modificar la venta");
        }
    }

    public void eliminarVenta(Venta venta,Detalle_Venta detalleV) {
        String sql = "UPDATE venta SET estado=? WHERE id_venta=?;";
        DetalleVentaData dvd = new DetalleVentaData();
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            venta.setEstado(false);
            ps.setBoolean(1, venta.isEstado());
            
            ps.setInt(2, venta.getIdVenta());
            detalleV.setVenta(venta);
            dvd.eliminarDetalleVenta(detalleV);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Venta eliminada correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar la venta");
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
                venta.setEstado(rs.getBoolean("estado"));
                
                
            } else {
                JOptionPane.showMessageDialog(null, "Venta inexistente");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo buscar la venta" + ex);
        }
        return venta;
    }

    public ArrayList<Venta> listarVentas() {
        ArrayList<Venta> ventas = new ArrayList<>();
        ClientesData cd = new ClientesData();
        Venta venta;
        String sql = "SELECT * FROM venta;";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                venta = new Venta();
                venta.setIdVenta(rs.getInt("id_venta"));
                venta.setCliente(cd.buscarCliente(rs.getInt("id_cliente")));
                venta.setFecha(rs.getDate("fecha").toLocalDate());
                venta.setEstado(rs.getBoolean("estado"));
                ventas.add(venta);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener la lista de ventas" + ex);
        }
        if (ventas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "la base de datos se encuentra vacia");
        }
        return ventas;
    }
}
