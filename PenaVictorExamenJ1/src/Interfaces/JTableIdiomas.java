package Interfaces;

import Datos.Conexion;
import Datos.GestorBaseDatos;
import Excepciones.Excepciones;
import Gestores.GestorArchivos;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JTableIdiomas extends javax.swing.JFrame {
//    public static String [] nombres = {};//guardara los nombres que hay metidos en los ficheros
//    Integer [] nombresInt = {11, 13, 15, 17, 19, 21, 23, 25, 27, 29};//Guarda la direccion del array dnd estan los nombres en los ficheros
    public static String jLabel2;
    public static String jButton1 = "Cambiar de Idioma";
    public static String jButton2 = "Listado";
    public static String jButton3 = "Nueva materia prima";
    public static String jButton4 = "Salir de la aplicacion";
    
    private MenuPrincipal v = null;
    private DefaultTableModel modelo;
//    private Connection conexionTransaccional;
    private boolean frances = false;
    private boolean ingles = false;
    private boolean polaco = false;
    private boolean suajili = false;
    private boolean aleman = false;
    private boolean español = false;
    private int seleccionar = 0;
    
    public JTableIdiomas() {
    }

    public JTableIdiomas(MenuPrincipal v) {
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
        jTableIdiomas = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        seleccionarIdioma = new javax.swing.JButton();

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

        jTableIdiomas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"frances"},
                {"ingles"},
                {"polaco"},
                {"suajili"},
                {"aleman"},
                {"español"}
            },
            new String [] {
                "Title 1"
            }
        ));
        jTableIdiomas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableIdiomasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableIdiomas);

        seleccionarIdioma.setText("Seleccionar Idioma");
        seleccionarIdioma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarIdiomaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(seleccionarIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(seleccionarIdioma)
                .addContainerGap(30, Short.MAX_VALUE))
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
        v.cambiarIdioma();
        v.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        v.cambiarIdioma();
        v.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
    }//GEN-LAST:event_formMouseClicked

    private void jTableIdiomasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableIdiomasMouseClicked
        seleccionar = jTableIdiomas.rowAtPoint(evt.getPoint());
        if(seleccionar==0){
            frances = true;
            ingles = false;
            polaco = false;
            suajili = false;
            aleman = false;
            español = false;
        }else if(seleccionar==1){
            ingles = true;
            polaco = false;
            suajili = false;
            aleman = false;
            español = false;
            frances = false;
        }else if(seleccionar==2){
            polaco = true;
            suajili = false;
            aleman = false;
            español = false;
            frances = false;
            ingles = false;
        }else if(seleccionar==3){
            suajili = true;
            aleman = false;
            español = false;
            frances = false;
            ingles = false;
            polaco = false;
        }else if(seleccionar==4){
            aleman = true;
            español = false;
            frances = false;
            ingles = false;
            polaco = false;
            suajili = false;
        }else if(seleccionar==5){
            español = true;
            frances = false;
            ingles = false;
            polaco = false;
            suajili = false;
            aleman = false;
        }
    }//GEN-LAST:event_jTableIdiomasMouseClicked

    private void seleccionarIdiomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarIdiomaActionPerformed
       //Boton seleccionar idioma
       if(español){
           File archivo = new File("src\\ficheros\\espanol.dat");
           try {
               String [] idioma = GestorArchivos.leerFicheroDataInputStream(archivo);
               jButton1 = idioma[3];
               jButton2 = idioma[5];
               jButton3 = idioma[7];
               jButton4= idioma[9];
               jLabel2 = idioma[1];
//               for (int i = 0; i < nombres.length; i++) {
//                   nombres[i] = idioma[nombresInt[i]];
//               }
           } catch (Excepciones ex) {
               JOptionPane.showMessageDialog(null, ex.getMessage()); 
           }
       }else if(frances){
           File archivo = new File("src\\ficheros\\frances.dat");
           try {
               String [] idioma = GestorArchivos.leerFicheroDataInputStream(archivo);
           } catch (Excepciones ex) {
               JOptionPane.showMessageDialog(null, ex.getMessage()); 
           }
       }else if(ingles){
           File archivo = new File("src\\ficheros\\ingles.dat");
           try {
               String [] idioma = GestorArchivos.leerFicheroDataInputStream(archivo);
               jButton1 = idioma[3];
               jButton2 = idioma[5];
               jButton3 = idioma[7];
               jButton4= idioma[9];
               jLabel2 = idioma[1];               
           } catch (Excepciones ex) {
               JOptionPane.showMessageDialog(null, ex.getMessage()); 
           }
       }else if(polaco){
           File archivo = new File("src\\ficheros\\polaco.dat");
           try {
               String [] idioma = GestorArchivos.leerFicheroDataInputStream(archivo);
               jButton1 = idioma[3];
               jButton2 = idioma[5];
               jButton3 = idioma[7];
               jButton4= idioma[9];
               jLabel2 = idioma[1];
           } catch (Excepciones ex) {
               JOptionPane.showMessageDialog(null, ex.getMessage()); 
           }
       }else if(suajili){
           File archivo = new File("src\\ficheros\\suajili.dat");
           try {
               String [] idioma = GestorArchivos.leerFicheroDataInputStream(archivo);
               jButton1 = idioma[3];
               jButton2 = idioma[5];
               jButton3 = idioma[7];
               jButton4= idioma[9];
               jLabel2 = idioma[1];
           } catch (Excepciones ex) {
               JOptionPane.showMessageDialog(null, ex.getMessage()); 
           }
       }else if(aleman){
           File archivo = new File("src\\ficheros\\aleman.dat");
           try {
               String [] idioma = GestorArchivos.leerFicheroDataInputStream(archivo);
               jButton1 = idioma[3];
               jButton2 = idioma[5];
               jButton3 = idioma[7];
               jButton4= idioma[9];
               jLabel2 = idioma[1];
           } catch (Excepciones ex) {
               JOptionPane.showMessageDialog(null, ex.getMessage()); 
           }
       }       
       JOptionPane.showMessageDialog(null, "Idioma Cambiado"); 
    }//GEN-LAST:event_seleccionarIdiomaActionPerformed

    public void mostrar() throws Excepciones {
        modelo = (DefaultTableModel) jTableIdiomas.getModel();
        
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        articulos articulo = null;

//        try {
//            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
//            //stmt = conn.prepareStatement("SELECT * FROM articulos ");
//            //stmt = conn.prepareStatement("SELECT * FROM articulos ORDER BY precio");
//            stmt = conn.prepareStatement("SELECT * FROM articulos ORDER BY precio DESC, stock DESC");//Si empatan tiene el stock en cuenta de manera descendiente
//            rs = stmt.executeQuery();
//            JTableIdiomas objeto = new JTableIdiomas();
//            while (rs.next()) {
//                String cod_arti = rs.getString("cod_art");
//                String descripcion = rs.getString("descripcion");
//                Float precio = rs.getFloat("precio");
//                int stock = rs.getInt("stock");
//                articulo = new articulos(cod_arti, descripcion, precio, stock);//Construimos objetos de tipo cuenta   
//                modelo.addRow(articulo.toArray());
//            }
//        } catch (SQLException ex) {
//            throw new Excepciones("Error al introducir filas en la jTable con los datos de la bd");
//        } finally {//Cerramos los objetos con finally ya que a diferencia de catch siempre se ejecuta
//            try {//Se cierran en el orden inverso al que se han abierto
//                Conexion.closeConnection(rs);
//                Conexion.closeConnection(stmt);
//                if (this.conexionTransaccional == null) {//Si el objeto conexionTransaccional es diferente de nulo, no se debe de cerrar
//                    Conexion.closeConnection(conn);
//                }
//            } catch (SQLException ex) {
//                throw new Excepciones("Error al cerrar la conexion en JTable");
//            }
//        }

    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableIdiomas;
    private javax.swing.JButton seleccionarIdioma;
    // End of variables declaration//GEN-END:variables
}
