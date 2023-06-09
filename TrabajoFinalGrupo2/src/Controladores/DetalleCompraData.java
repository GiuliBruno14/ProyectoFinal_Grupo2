/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelo.DetalleCompra;
import Modelo.Detalle_Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author becer
 */
public class DetalleCompraData {
     private Connection con;
     
     public DetalleCompraData() {
        con = Conexion.getConexion();

    }
     public void agregarDetalleCompra(DetalleCompra detalleC) {
        String sql = "INSERT INTO detallecompra(cantidad, precioCosto, id_compra, id_producto) VALUES (?,?,?,?)";
        ProductoData pd = new ProductoData();
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, detalleC.getCantidad());
            ps.setFloat(2, detalleC.getPrecioCosto());
            ps.setInt(3, detalleC.getCompra().getIdCompra());
            ps.setInt(4, detalleC.getProducto().getIdProducto());
                       
            detalleC.getProducto().setStock(detalleC.getProducto().getStock() + detalleC.getCantidad());
            pd.editarProducto(detalleC.getProducto());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) { 
                detalleC.setIdDetalle(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Detalle Compra realizado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo realizar el Detalle Compra");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar el Detalle Compra" + ex);
        }
    }
     public DetalleCompra buscarDetalleCompra(int id) {
        DetalleCompra detalleC = null;
        String sql = "SELECT * FROM detallecompra WHERE id_detalle =?";
        CompraData cd = new CompraData();
        ProductoData pd = new ProductoData();
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                detalleC = new DetalleCompra();
                detalleC.setIdDetalle(id);
                detalleC.setCantidad(rs.getInt("cantidad"));
                detalleC.setPrecioCosto(rs.getFloat("precioCosto"));
                detalleC.setCompra(cd.buscarCompra(rs.getInt("id_compra")));
                detalleC.setProducto(pd.buscarProducto(rs.getInt("id_producto")));
                
                
            } else {
                JOptionPane.showMessageDialog(null, "Detalle Compra inexistente");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo buscar el detalle Compra" + ex);
        }
        return detalleC;
    }
     public ArrayList<DetalleCompra> listarDetalleCompras() {
        ArrayList<DetalleCompra> detalleComp = new ArrayList<>();
        CompraData cd = new CompraData();
        ProductoData pd = new ProductoData();
        DetalleCompra detalleC;
        String sql = "SELECT * FROM detallecompra;";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                detalleC = new DetalleCompra();
                detalleC.setIdDetalle(rs.getInt("id_detalle"));
                detalleC.setCantidad(rs.getInt("cantidad"));
                detalleC.setPrecioCosto(rs.getFloat("precioCosto"));
                detalleC.setCompra(cd.buscarCompra(rs.getInt("id_compra")));
                detalleC.setProducto(pd.buscarProducto(rs.getInt("id_producto")));
                
                detalleComp.add(detalleC);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener la lista de detalle Compras" + ex);
        }
        if (detalleComp.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La base de datos se encuentra vacia");
        }
        return detalleComp;
    }
}
