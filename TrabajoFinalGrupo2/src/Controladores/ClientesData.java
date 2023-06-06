/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClientesData {

    private Connection con;

    public ClientesData() {
        con = Conexion.getConexion();
    }

    public void agregarCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente(apellido, nombre, domicilio, telefono) VALUES (?,?,?,?);";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cliente.getApellido());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getDomicilio());
            ps.setLong(4, Long.parseLong(cliente.getTelefono()));
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                cliente.setIdCliente(rs.getInt(1));
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar el cliente");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarCliente(Cliente cliente) {
        String sql = "UPDATE cliente SET apellido=?,nombre=?,domicilio=?,telefono=? WHERE id_cliente=?;";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cliente.getApellido());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getDomicilio());
            ps.setLong(4, Long.parseLong(cliente.getTelefono()));
            ps.setInt(5, cliente.getIdCliente());
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Cliente actualizado correctamente");
        } catch (SQLException ex) {
            Logger.getLogger(ClientesData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarCliente(Cliente cliente) {
        String sql = "DELETE FROM cliente WHERE id_cliente=?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cliente.getIdCliente());
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente");
        } catch (SQLException ex) {
            Logger.getLogger(ClientesData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Cliente buscarCliente(int id) {
        Cliente cliente = null;
        String sql = "SELECT * FROM cliente WHERE id_cliente=?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(id);
                cliente.setApellido(rs.getString("apellido"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDomicilio(rs.getString("domicilio"));
                cliente.setTelefono(Long.toString(rs.getLong("telefono")));
            } else {
                JOptionPane.showMessageDialog(null, "Cliente inexistente");
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "No se pudo buscar cliente" + ex);
        }
        return cliente;
    }

    public ArrayList<Cliente> listarClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        Cliente cliente;
        String sql = "SELECT * FROM cliente ;";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cliente = new Cliente();
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("id_cliente"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDomicilio(rs.getString("domicilio"));
                cliente.setTelefono(Long.toString(rs.getLong("telefono")));
                clientes.add(cliente);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener los Clientes" + ex);
        }
        if (clientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "la base de datos se encuentra vacia");
        }
    return clientes;
    }
}
