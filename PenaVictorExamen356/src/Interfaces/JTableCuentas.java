package Interfaces;

import Datos.Conexion;
import Datos.GestorBaseDatos;
import Excepciones.Excepciones;
import domain.CuentasDTO;
import gestores.GestorCuentas;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JTableCuentas extends javax.swing.JFrame {
private final MenuPrincipal v;

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
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "NICK", "PASSWORD", "E-mail", "TELÉFONO", "ENVIAR"
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
        Connection conexion = null;
        GestorBaseDatos cuentaDao = null;
        conexion = Conexion.getConnection();
        cuentaDao = new GestorBaseDatos(conexion); 
    
        String matriz[][];
    try {
        matriz = new String[cuentaDao.seleccionar().size()][2];
    } catch (SQLException ex) {
        throw new Excepciones("Error al conectar a la bd");
    }
        int contadorMatriz = 0;
    try {
        for (CuentasDTO listaCuenta : cuentaDao.seleccionar()) {
            matriz[contadorMatriz][0] = listaCuenta.getId_cc();
            matriz[contadorMatriz][1] = listaCuenta.getSaldo().toString();
            contadorMatriz++;
        }
    } catch (SQLException ex) {
        throw new Excepciones("Error al conectar a la bd");
    }

        jTableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
                matriz,
                new String[]{
                    "Cuenta Corriente", "Saldo"
                }
        ));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUsuarios;
    // End of variables declaration//GEN-END:variables
}
