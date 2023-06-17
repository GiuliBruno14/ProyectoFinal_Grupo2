/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vistas;

import Controladores.ProductoData;
import Modelo.Producto;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author giuli
 */
public class VistasProductos extends javax.swing.JInternalFrame {

    private DefaultTableModel modeloTabla;
    private ArrayList<Producto> productos = new ArrayList();
    private ProductoData prodData = new ProductoData();
    private int id;

    /**
     * Creates new form VistasProductos
     */
    public VistasProductos() {
        initComponents();
        modeloTabla = new DefaultTableModel();
        encabezado();
        llenarTabla();
        habilitarBuscar();
    }

    private void habilitarBuscar(){
    if(jIdProducto.getText().length()==0){
        btnBuscar.setEnabled(false);
        
    }
    else{
        btnBuscar.setEnabled(true);
        }
    if(jDescripcion.getText().length()==0){
        btnBuscar2.setEnabled(false);
    }
    else{
        btnBuscar2.setEnabled(true);
        }
    }
    private void encabezado() {
        ArrayList<Object> columna = new ArrayList();
        columna.add("Código");
        columna.add("Descripción");
        columna.add("Precio");
        columna.add("Stock");
        columna.add("Estado");
        for (Object c : columna) {
            modeloTabla.addColumn(c);
        }
        jTablaProductos.setModel(modeloTabla);
    }

    private void llenarTabla() {
        borrarFilas();
        productos = prodData.listarProductos();
        for (Producto p : productos) {
            modeloTabla.addRow(new Object[]{p.getIdProducto(), p.getDescripcion(), p.getPrecioActual(), p.getStock(), p.isEstado()});
        }
    }

    private void borrarFilas() {
        int fila = modeloTabla.getRowCount() - 1;
        for (int i = fila; i >= 0; i--) {
            modeloTabla.removeRow(i);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jIdProducto = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jStock = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JLabel();
        jDescripcion = new javax.swing.JTextField();
        jPrecioActual = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaProductos = new javax.swing.JTable();
        btnEditarP = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JLabel();
        btnBuscar2 = new javax.swing.JLabel();
        jRadioEstadoP = new javax.swing.JRadioButton();
        btnSalir1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 204));
        setPreferredSize(new java.awt.Dimension(820, 440));

        jLabel9.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel9.setText("Productos");

        jLabel13.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel13.setText("Id_Producto:");

        jIdProducto.setBackground(new java.awt.Color(0, 102, 153));
        jIdProducto.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jIdProducto.setForeground(new java.awt.Color(255, 255, 255));
        jIdProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jIdProductoMouseClicked(evt);
            }
        });
        jIdProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jIdProductoActionPerformed(evt);
            }
        });
        jIdProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jIdProductoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jIdProductoKeyReleased(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel14.setText("Descripción:");

        jLabel15.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel15.setText("Precio Actual:");

        jLabel16.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel16.setText("Stock:");

        jStock.setBackground(new java.awt.Color(0, 102, 153));
        jStock.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jStock.setForeground(new java.awt.Color(255, 255, 255));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconos/guardarico.png"))); // NOI18N
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });

        jDescripcion.setBackground(new java.awt.Color(0, 102, 153));
        jDescripcion.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        jDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jDescripcionKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jDescripcionKeyReleased(evt);
            }
        });

        jPrecioActual.setBackground(new java.awt.Color(0, 102, 153));
        jPrecioActual.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jPrecioActual.setForeground(new java.awt.Color(255, 255, 255));
        jPrecioActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPrecioActualActionPerformed(evt);
            }
        });

        jTablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTablaProductos);

        btnEditarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconos/icocrear.png"))); // NOI18N
        btnEditarP.setToolTipText("");
        btnEditarP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarPMouseClicked(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconos/buscarico.png"))); // NOI18N
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });

        btnBuscar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconos/buscarico.png"))); // NOI18N
        btnBuscar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscar2MouseClicked(evt);
            }
        });

        jRadioEstadoP.setBackground(new java.awt.Color(255, 255, 255));
        jRadioEstadoP.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jRadioEstadoP.setText("Estado");
        jRadioEstadoP.setEnabled(false);
        jRadioEstadoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioEstadoPActionPerformed(evt);
            }
        });

        btnSalir1.setBackground(new java.awt.Color(0, 102, 153));
        btnSalir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconos/salir.png"))); // NOI18N
        btnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel14)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel16)
                                        .addComponent(jLabel15))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPrecioActual, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jStock, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(94, 94, 94)
                            .addComponent(btnEditarP, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGuardar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jRadioEstadoP, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(356, 356, 356))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSalir1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnBuscar2)
                                    .addComponent(btnBuscar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(82, 82, 82))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(jDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(jPrecioActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(jStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addComponent(jRadioEstadoP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnGuardar)
                                    .addComponent(btnEditarP)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBuscar)
                                .addGap(20, 20, 20)
                                .addComponent(btnBuscar2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnSalir1)
                                .addGap(1, 1, 1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        // TODO add your handling code here:
        try {
            String descrip = jDescripcion.getText();
            float precio = Float.parseFloat(jPrecioActual.getText());
            int stock2 = Integer.parseInt(jStock.getText());
            Producto product = new Producto(descrip, precio, stock2);
            prodData.agregarProducto(product);
            limpiar();
            llenarTabla();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Datos incorrectos" + e);
        }
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void jPrecioActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPrecioActualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPrecioActualActionPerformed

    private void btnEditarPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarPMouseClicked
        // TODO add your handling code here:
        try {
            if (Integer.parseInt(jIdProducto.getText()) != id) {
                JOptionPane.showMessageDialog(null, "Error al modificar producto: No se puede cambiar el ID");
            } else {
                int id = Integer.parseInt(jIdProducto.getText());
                String descrip = jDescripcion.getText();
                float precio = Float.parseFloat(jPrecioActual.getText());
                int stock2 = Integer.parseInt(jStock.getText());
                Producto product = new Producto(id, descrip, precio, stock2);
                prodData.editarProducto(product);
                limpiar();
                llenarTabla();
            }
            llenarTabla();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Datos incorrectos" + e);
        }

    }//GEN-LAST:event_btnEditarPMouseClicked

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        // TODO add your handling code here:
        try {
            if(btnBuscar.isEnabled()){
            Producto producto1 = new Producto();
            id = Integer.parseInt(jIdProducto.getText());
            producto1 = prodData.buscarProducto(id);
            jDescripcion.setText(producto1.getDescripcion());
            jPrecioActual.setText(Float.toString(producto1.getPrecioActual()));
            jStock.setText(Integer.toString(producto1.getStock()));
            if (producto1.isEstado()) {
                jRadioEstadoP.setSelected(true);
            } else {
                jRadioEstadoP.setSelected(false);
            }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Datos incorrectos" + e);
        }

    }//GEN-LAST:event_btnBuscarMouseClicked

    private void btnBuscar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscar2MouseClicked
        // TODO add your handling code here:
        try {
            if(btnBuscar2.isEnabled()){
            Producto producto1 = new Producto();
            String descrip = jDescripcion.getText();
            producto1 = prodData.buscarPorNombre(descrip);
            jIdProducto.setText(Integer.toString(producto1.getIdProducto()));
            jPrecioActual.setText(Float.toString(producto1.getPrecioActual()));
            jStock.setText(Integer.toString(producto1.getStock()));
            if (producto1.isEstado()) {
                jRadioEstadoP.setSelected(true);
            } else {
                jRadioEstadoP.setSelected(false);
            }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Datos incorrectos" + e);
        }
    }//GEN-LAST:event_btnBuscar2MouseClicked

    private void jIdProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jIdProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jIdProductoActionPerformed

    private void jIdProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jIdProductoMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jIdProductoMouseClicked

    private void jIdProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jIdProductoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jIdProductoKeyPressed

    private void jDescripcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDescripcionKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jDescripcionKeyPressed

    private void jRadioEstadoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioEstadoPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioEstadoPActionPerformed

    private void jIdProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jIdProductoKeyReleased
        habilitarBuscar();        // TODO add your handling code here:
    }//GEN-LAST:event_jIdProductoKeyReleased

    private void jDescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDescripcionKeyReleased
        habilitarBuscar();        // TODO add your handling code here:
    }//GEN-LAST:event_jDescripcionKeyReleased

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
      dispose();
    }//GEN-LAST:event_btnSalir1ActionPerformed
    private void limpiar() {
        jIdProducto.setText("");
        jDescripcion.setText("");
        jPrecioActual.setText("");
        jStock.setText("");
        jRadioEstadoP.setSelected(false);
        habilitarBuscar();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBuscar;
    private javax.swing.JLabel btnBuscar2;
    private javax.swing.JLabel btnEditarP;
    private javax.swing.JLabel btnGuardar;
    private javax.swing.JButton btnSalir1;
    private javax.swing.JTextField jDescripcion;
    private javax.swing.JTextField jIdProducto;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jPrecioActual;
    private javax.swing.JRadioButton jRadioEstadoP;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jStock;
    private javax.swing.JTable jTablaProductos;
    // End of variables declaration//GEN-END:variables
}
