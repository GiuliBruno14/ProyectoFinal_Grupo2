package Controladores;

import Modelo.Producto;
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

public class ProductoData {

    private Connection con;

    public ProductoData() {
        con = Conexion.getConexion();
    }

    public void agregarProducto(Producto producto) {
        String sql = "INSERT INTO producto(descripcion, precioActual, stock, estado) VALUES (?,?,?,?);";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, producto.getDescripcion());
            ps.setFloat(2, producto.getPrecioActual());
            ps.setInt(3, producto.getStock());
            if (producto.getStock()==0){
            producto.setEstado(false);
            } else {
                producto.setEstado(true);
            }
            ps.setBoolean(4, producto.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                producto.setIdProducto(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Producto añadido correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar el producto");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarProducto(Producto producto) {
        String sql = "UPDATE producto SET descripcion=?,precioActual=?,stock=?,estado=? WHERE id_producto=?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, producto.getDescripcion());
            ps.setFloat(2, producto.getPrecioActual());
            ps.setInt(3, producto.getStock());
            if (producto.getStock()==0){
            producto.setEstado(false);
            } else {
                producto.setEstado(true);
            }
            ps.setBoolean(4, producto.isEstado());
            ps.setInt(5, producto.getIdProducto());
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Producto actualizado correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar el producto");
        }
    }

//    public void eliminarProducto(Producto producto) {
//        String sql = "DELETE FROM producto WHERE id_producto=?;";
//        try {
//            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            ps.setInt(1, producto.getIdProducto());
//            ps.executeUpdate();
//            ps.close();
//            JOptionPane.showMessageDialog(null, "Producto eliminado correctamente");
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "No se pudo eliminar el producto");
//        }
//    }  // Proxima version....

    public Producto buscarProducto(int id) {
        Producto producto = null;
        String sql = "SELECT * FROM producto WHERE id_producto=?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                producto = new Producto();
                producto.setIdProducto(id);
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioActual(rs.getFloat("precioActual"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(rs.getBoolean("estado"));
            } else {
                JOptionPane.showMessageDialog(null, "Producto inexistente");
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "No se pudo buscar el producto" + ex);
        }
        return producto;
    }
    
    public ArrayList<Producto> listarProductos() {
        ArrayList<Producto> productos = new ArrayList<>();
        Producto producto;
        String sql = "SELECT * FROM producto;";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                producto = new Producto();
                producto.setIdProducto(rs.getInt("id_producto"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioActual(rs.getFloat("precioActual"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(rs.getBoolean("estado"));
                productos.add(producto);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener los productos" + ex);
        }
        if (productos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "la base de datos se encuentra vacia");
        }
    return productos;
    }
    public Producto buscarPorNombre(String nombre) {
        Producto producto = null;
        String sql = "SELECT * FROM producto WHERE descripcion=?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                producto = new Producto();
                producto.setIdProducto(rs.getInt("id_producto"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioActual(rs.getFloat("precioActual"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(rs.getBoolean("estado"));
            } else {
                JOptionPane.showMessageDialog(null, "Producto inexistente");
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "No se pudo buscar el producto" + ex);
        }
        return producto;
    }

}
