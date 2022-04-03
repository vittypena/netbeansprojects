package Interfaces;

import Datos.Conexion;
import Datos.GestorBaseDatos;
import Excepciones.Excepciones;
import domain.articulos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JTableArticulos extends javax.swing.JFrame {

    private MainPrincipal v = null;
    private DefaultTableModel modelo;
    private Connection conexionTransaccional;
    private String cod_articulo = "";
    private String descripcion = "";
    private String precio = "";
    private String stock = "";
    private int seleccionar = 0;
    
    public JTableArticulos() {
    }

    public JTableArticulos(MainPrincipal v) {
        initComponents();
        this.setVisible(true);
        this.v = v;
        try {
            mostrar();
        } catch (Excepciones ex) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUsuarios = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();

        setTitle("Usuarios");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod_Art", "Descripcion", "Precio", "Stock"
            }
        ));
        jTableUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableUsuarios);

        jButton1.setText("Eliminar fila seleccionada");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField2");

        jTextField3.setText("jTextField3");

        jTextField4.setText("jTextField4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        v.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        v.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Eliminar fila seleccionada            
//        try {
//            articulos objeto = new articulos(cod_articulo, descripcion, Float.parseFloat(precio), Integer.parseInt(stock));
//        } catch (Excepciones ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage());
//        }
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
        } catch (Excepciones ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        GestorBaseDatos cuentaDao = new GestorBaseDatos(conexion);
        try {
            cuentaDao.eliminarGuardandoHistoricoBorrados(new articulos(cod_articulo));
        } catch (Excepciones | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        modelo.removeRow(seleccionar);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
    }//GEN-LAST:event_formMouseClicked

    private void jTableUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableUsuariosMouseClicked
        seleccionar = jTableUsuarios.rowAtPoint(evt.getPoint());
        cod_articulo = String.valueOf(jTableUsuarios.getValueAt(seleccionar, 0));
        descripcion  = String.valueOf(jTableUsuarios.getValueAt(seleccionar, 1));
        precio       = String.valueOf(jTableUsuarios.getValueAt(seleccionar, 2));
        stock        = String.valueOf(jTableUsuarios.getValueAt(seleccionar, 3));
        jTextField1.setText(String.valueOf(jTableUsuarios.getValueAt(seleccionar, 0)));
        jTextField2.setText(String.valueOf(jTableUsuarios.getValueAt(seleccionar, 1)));
        jTextField3.setText(String.valueOf(jTableUsuarios.getValueAt(seleccionar, 2)));
        jTextField4.setText(String.valueOf(jTableUsuarios.getValueAt(seleccionar, 3)));
    }//GEN-LAST:event_jTableUsuariosMouseClicked

    public void mostrar() throws Excepciones {
        modelo = (DefaultTableModel) jTableUsuarios.getModel();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        articulos articulo = null;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            //stmt = conn.prepareStatement("SELECT * FROM articulos ");
            //stmt = conn.prepareStatement("SELECT * FROM articulos ORDER BY precio");
            stmt = conn.prepareStatement("SELECT * FROM articulos ORDER BY precio DESC, stock DESC");//Si empatan tiene el stock en cuenta de manera descendiente
            rs = stmt.executeQuery();
            JTableArticulos objeto = new JTableArticulos();
            while (rs.next()) {
                String cod_arti = rs.getString("cod_art");
                String descripcion = rs.getString("descripcion");
                Float precio = rs.getFloat("precio");
                int stock = rs.getInt("stock");
                articulo = new articulos(cod_arti, descripcion, precio, stock);//Construimos objetos de tipo cuenta   
                modelo.addRow(articulo.toArray());
            }
        } catch (SQLException ex) {
            throw new Excepciones("Error al introducir filas en la jTable con los datos de la bd");
        } finally {//Cerramos los objetos con finally ya que a diferencia de catch siempre se ejecuta
            try {//Se cierran en el orden inverso al que se han abierto
                Conexion.closeConnection(rs);
                Conexion.closeConnection(stmt);
                if (this.conexionTransaccional == null) {//Si el objeto conexionTransaccional es diferente de nulo, no se debe de cerrar
                    Conexion.closeConnection(conn);
                }
            } catch (SQLException ex) {
                throw new Excepciones("Error al cerrar la conexion en JTable");
            }
        }

    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUsuarios;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
