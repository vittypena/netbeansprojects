

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Vitty
 */
public class Tabla extends javax.swing.JFrame {
String[] nombres_archivos;
    public Tabla(String[] nombres_archivos) {
        initComponents();
        this.setVisible(true);        
        this.nombres_archivos = nombres_archivos;
        mostrar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUsuarios = new javax.swing.JTable();

        setTitle("Usuarios");

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

    public void mostrar() {
        String matriz[][] = new String[nombres_archivos.length][1];   
        for (int i = 0; i < nombres_archivos.length; i++) {
            matriz[i][0] = nombres_archivos[i];    
        }

        jTableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
                matriz,
                new String[]{
                    "NICK"
                }
        ));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUsuarios;
    // End of variables declaration//GEN-END:variables
}
