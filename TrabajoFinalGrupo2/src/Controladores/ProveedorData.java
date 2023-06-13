package Controladores;

import Modelo.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ProveedorData {

    private Connection con;

    public ProveedorData() {
        con = Conexion.getConexion();
    }

    public void agregarProveedor(Proveedor proveedor) {
        String sql = "INSERT INTO proveedor(razonSocial, domicilio, telefono) VALUES (?,?,?);";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, proveedor.getRazonSocial());
            ps.setString(2, proveedor.getDomicilio());
            ps.setLong(3, Long.parseLong(proveedor.getTelefono()));
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                proveedor.setIdProveedor(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Proveedor guardado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar el proveedor");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void editarProveedor(Proveedor proveedor) {
        String sql = "UPDATE proveedor SET razonSocial=?,domicilio=?,telefono=? WHERE id_proveedor =?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, proveedor.getRazonSocial());
            ps.setString(2, proveedor.getDomicilio());
            ps.setLong(3, Long.parseLong(proveedor.getTelefono()));
            ps.setInt(4, proveedor.getIdProveedor());
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Proveedor actualizado correctamente");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar proveedor");
        }

    }

    public void eliminarProveedor(Proveedor proveedor) {
        String sql = "DELETE FROM proveedor WHERE id_proveedor=?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, proveedor.getIdProveedor());
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Proveedor eliminado correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar al proveedor");
        }
    }

    public Proveedor buscarProveedor(int id) {
        Proveedor proveedor = null;
        String sql = "SELECT * FROM proveedor WHERE id_proveedor=?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                proveedor = new Proveedor();
                proveedor.setIdProveedor(id);
                proveedor.setRazonSocial(rs.getString("razonSocial"));
                proveedor.setDomicilio(rs.getString("domicilio"));
                proveedor.setTelefono(Long.toString(rs.getLong("telefono")));
            } else {
                JOptionPane.showMessageDialog(null, "Proveedor inexistente");
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "No se pudo buscar proveedor" + ex);
        }
        return proveedor;
    }

    public ArrayList<Proveedor> listarProveedores() {
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        Proveedor proveedor;
        String sql = "SELECT * FROM proveedor ;";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                proveedor = new Proveedor();
                proveedor.setIdProveedor(rs.getInt("id_proveedor"));
                proveedor.setRazonSocial(rs.getString("razonSocial"));
                proveedor.setDomicilio(rs.getString("domicilio"));
                proveedor.setTelefono(Long.toString(rs.getLong("telefono")));
                proveedores.add(proveedor);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener los Proveedores" + ex);
        }
        if (proveedores.isEmpty()) {
            JOptionPane.showMessageDialog(null, "la base de datos se encuentra vacia");
        }
        return proveedores;
    }
}
