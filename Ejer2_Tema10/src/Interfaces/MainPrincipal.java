package Interfaces;

import Datos.Conexion;
import Datos.GestorBaseDatos;
import Excepciones.Excepciones;
import Gestores.GestorArchivos;
import Gestores.GestorArticulos;
import domain.articulos;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class MainPrincipal extends javax.swing.JFrame {
    Connection conexion = null;
    public MainPrincipal() {
        initComponents();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonAlta = new javax.swing.JButton();
        jButtonBaja = new javax.swing.JButton();
        jButtonModificacion = new javax.swing.JButton();
        jButtonListado = new javax.swing.JButton();
        jButtonExportarXML = new javax.swing.JButton();
        jButtonExportaFichero = new javax.swing.JButton();
        jButtonFin = new javax.swing.JButton();
        jButtonConfirmarAlta = new javax.swing.JButton();
        jButtonAltav2 = new javax.swing.JButton();
        jButtonConfirmarAltav2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonAlta.setText("Alta");
        jButtonAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAltaActionPerformed(evt);
            }
        });

        jButtonBaja.setText("Baja");
        jButtonBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBajaActionPerformed(evt);
            }
        });

        jButtonModificacion.setText("Modificacion");
        jButtonModificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificacionActionPerformed(evt);
            }
        });

        jButtonListado.setText("Listado");
        jButtonListado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListadoActionPerformed(evt);
            }
        });

        jButtonExportarXML.setText("Numero Aleatorio");
        jButtonExportarXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExportarXMLActionPerformed(evt);
            }
        });

        jButtonExportaFichero.setText("Exporta Fichero");

        jButtonFin.setText("Fin");

        jButtonConfirmarAlta.setText("Confirmar Alta");
        jButtonConfirmarAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarAltaActionPerformed(evt);
            }
        });

        jButtonAltav2.setText("Alta vs2");
        jButtonAltav2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAltav2ActionPerformed(evt);
            }
        });

        jButtonConfirmarAltav2.setText("Confirmar Alta vs2");
        jButtonConfirmarAltav2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarAltav2ActionPerformed(evt);
            }
        });

        jButton1.setText("ExportarXML");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonExportaFichero)
                    .addComponent(jButtonExportarXML)
                    .addComponent(jButtonListado)
                    .addComponent(jButtonModificacion)
                    .addComponent(jButtonBaja)
                    .addComponent(jButtonAlta)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonFin)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonConfirmarAltav2)
                            .addComponent(jButtonConfirmarAlta)
                            .addComponent(jButtonAltav2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAlta)
                    .addComponent(jButtonAltav2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonBaja)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonModificacion)
                    .addComponent(jButtonConfirmarAltav2))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonListado)
                    .addComponent(jButtonConfirmarAlta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonExportarXML)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonExportaFichero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFin)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAltaActionPerformed
        //Boton Alta
        //Pide los datos de un articulo y comprueba si son correctos
        articulos articulo = pedirDatos();
        GestorArticulos.añadirArticulo(articulo);
    }//GEN-LAST:event_jButtonAltaActionPerformed

    private void jButtonConfirmarAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarAltaActionPerformed
        try {                                         
            //Confirmar alta, lo inserta en la base de datos
            Connection conexion = null;
            try {
                conexion = Conexion.getConnection();
            } catch (Excepciones ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            GestorBaseDatos cuentaDao = new GestorBaseDatos(conexion);
            for (articulos object : GestorArticulos.listaArticulos) {
                cuentaDao.insertar(object);
                JOptionPane.showMessageDialog(null, "Articulo insertado");
            }            
        } catch (SQLException | Excepciones ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());   
        }
    }//GEN-LAST:event_jButtonConfirmarAltaActionPerformed

    private void jButtonBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBajaActionPerformed
        try {                                         
            //Boton Baja, pide un articulo y lo elimina
            Connection conexion = null;
            try {
                conexion = Conexion.getConnection();
            } catch (Excepciones ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            GestorBaseDatos cuentaDao = new GestorBaseDatos(conexion);
            String entradaUsuario = JOptionPane.showInputDialog("Introduce el cod_art para eliminarlo");
            String cod_art = entradaUsuario;
            cuentaDao.eliminarGuardandoHistoricoBorrados(new articulos(cod_art));
            JOptionPane.showMessageDialog(null, "Articulo eliminado");
        } catch (Excepciones | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jButtonBajaActionPerformed

    private void jButtonAltav2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAltav2ActionPerformed
        //Alta v2
        articulos articulo = pedirDatos();
        try {                                         
            //Confirmar alta, lo inserta en la base de datos
            
            try {
                conexion = Conexion.getConnection();
                if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);//Si es verdadero lo ponemos en false
                }
            } catch (Excepciones ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            GestorBaseDatos cuentaDao = new GestorBaseDatos(conexion);
            cuentaDao.insertar(articulo);
        } catch (SQLException | Excepciones ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());   
        }
    }//GEN-LAST:event_jButtonAltav2ActionPerformed

    private void jButtonConfirmarAltav2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarAltav2ActionPerformed
        try {
            //Confirmar alta vs
            conexion.commit();
            JOptionPane.showMessageDialog(null, "Articulo Insertado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage()); 
        }
    }//GEN-LAST:event_jButtonConfirmarAltav2ActionPerformed

    private void jButtonListadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListadoActionPerformed
        //BOTON LISTADO DE ARTICULOS
            //Desaparece la ventana de menu y se muestra una tabla con todos los articulos de la bd
            JTableArticulos tablaArticulos = new JTableArticulos(this);
            this.setVisible(false);
            tablaArticulos.setVisible(true);  
    }//GEN-LAST:event_jButtonListadoActionPerformed

    private void jButtonModificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificacionActionPerformed
        try {
            //Boton modificar
            JOptionPane.showMessageDialog(null, "A continuacion se pediran los datos para modificar el articulo, si existe se sumara el stock, si no se creara");
            articulos articulo = pedirDatos();
            conexion = Conexion.getConnection();
            GestorBaseDatos cuentaDao = new GestorBaseDatos(conexion);
            cuentaDao.actualizarInsertandoSiNoExiste(articulo);
            JOptionPane.showMessageDialog(null, "Articulo Modificado");
        } catch (Excepciones | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        
    }//GEN-LAST:event_jButtonModificacionActionPerformed

    private void jButtonExportarXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportarXMLActionPerformed
        //Poner un numero aleatorio en el texto
        int numero = (int) (Math.random() * (18 - 5)) + 5;//Entre el 5 y el 17, (Hay que poner 18 para que el maximo sea 17)
        jTextField1.setText(String.valueOf(numero));
    }//GEN-LAST:event_jButtonExportarXMLActionPerformed

    
    public static void main(String args[]) {
        Connection conexion = null;
        try{        
        conexion = Conexion.getConnection();
        GestorBaseDatos cuentaDao = new GestorBaseDatos(conexion);
        }catch (Excepciones ex) {//No hay conexion con la bd
            //Necesito estas 4 lineas para guardar el log,pasandole un String
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            try {
                GestorArchivos.escribirLog(sw.toString().toUpperCase());
            } catch (Excepciones ex1) {
               JOptionPane.showMessageDialog(null, ex.getMessage());  
            }
            JOptionPane.showMessageDialog(null, ex.getMessage());        
            System.exit(0);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAlta;
    private javax.swing.JButton jButtonAltav2;
    private javax.swing.JButton jButtonBaja;
    private javax.swing.JButton jButtonConfirmarAlta;
    private javax.swing.JButton jButtonConfirmarAltav2;
    private javax.swing.JButton jButtonExportaFichero;
    private javax.swing.JButton jButtonExportarXML;
    private javax.swing.JButton jButtonFin;
    private javax.swing.JButton jButtonListado;
    private javax.swing.JButton jButtonModificacion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private articulos pedirDatos() {
        String cod_art;
        String descripcion;
        Float precio;
        int stock;
        
        String entradaUsuario = JOptionPane.showInputDialog("Introduce el cod_art");
        cod_art = entradaUsuario;
        
        entradaUsuario = JOptionPane.showInputDialog("Introduce la descripcion del articulo");
        descripcion = entradaUsuario;
        
        entradaUsuario = JOptionPane.showInputDialog("Introduce el precio del articulo");
        precio = Float.valueOf(entradaUsuario);
        
        entradaUsuario = JOptionPane.showInputDialog("Introduce el stock disponible");
        stock = Integer.valueOf(entradaUsuario);
        
        articulos art = null;
        try {
            art = new articulos(cod_art, descripcion, precio, stock);
        } catch (Excepciones ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return art; 
    }
}
