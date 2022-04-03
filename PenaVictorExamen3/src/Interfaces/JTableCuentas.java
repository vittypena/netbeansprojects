package Interfaces;

import Datos.Conexion;
import Excepciones.Excepciones;
import domain.CuentasDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class JTableCuentas extends javax.swing.JFrame {

    private MenuPrincipal v = null;
    private DefaultTableModel modelo;
    private Connection conexionTransaccional;

    public JTableCuentas() {
    }

    public JTableCuentas(MenuPrincipal v) {
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

        setTitle("Usuarios");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jTableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cuenta Corriente", "Saldo"
            }
        ));
        jScrollPane1.setViewportView(jTableUsuarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        v.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        v.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    public void mostrar() throws Excepciones {
        modelo = (DefaultTableModel) jTableUsuarios.getModel();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        CuentasDTO cuenta = null;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement("SELECT id_cc, saldo FROM cuentas");
            rs = stmt.executeQuery();
            JTableCuentas objeto = new JTableCuentas();
            while (rs.next()) {
                String idCuenta = rs.getString("id_cc");
                Double saldo = rs.getDouble("saldo");
                cuenta = new CuentasDTO(idCuenta, saldo);//Construimos objetos de tipo cuenta   
                modelo.addRow(cuenta.toArray());
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

    //Lo necesito por mi forma de abrir y cerrar las conexiones (Debido a que voy a abrirla y cerrarla para añadir datos en el modelo)
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUsuarios;
    // End of variables declaration//GEN-END:variables
}
