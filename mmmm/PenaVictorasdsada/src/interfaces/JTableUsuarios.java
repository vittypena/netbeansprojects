package interfaces;

import formatoJTable.TableCellRendererColor;
import formatoJTable.HeaderColors;
import gestores.GestorUsuarios;
import java.awt.Color;
import java.util.ArrayList;
import modelos.Usuarios;

/**
 *
 * @author Vitty
 */
public class JTableUsuarios extends javax.swing.JFrame {

    public JTableUsuarios() {
        initComponents();
        this.setVisible(true);
        jTableUsuarios.setDefaultRenderer(Object.class, new TableCellRendererColor());
        jTableUsuarios.getTableHeader().setDefaultRenderer(new HeaderColors());
        mostrar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUsuarios = new javax.swing.JTable();

        setTitle("Usuarios");
        setPreferredSize(new java.awt.Dimension(565, 300));

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
        String matriz[][] = new String[GestorUsuarios.getListaUsuarios().size()][5];
        String informacion;
        int contadorMatriz = 0;
        for (Usuarios listaUsuarios : GestorUsuarios.getListaUsuarios()) {
            matriz[contadorMatriz][0] = listaUsuarios.getNick();
            matriz[contadorMatriz][1] = listaUsuarios.getPassword();
            matriz[contadorMatriz][2] = listaUsuarios.getEmail();
            matriz[contadorMatriz][3] = listaUsuarios.getTelefono();
            if (listaUsuarios.isEnviar()) {
                informacion = "si";
            } else {
                informacion = "no";
            }
            matriz[contadorMatriz][4] = informacion;
            contadorMatriz++;
        }

        jTableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
                matriz,
                new String[]{
                    "NICK", "PASSWORD", "E-mail", "TELÉFONO", "ENVIAR"
                }
        ));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUsuarios;
    // End of variables declaration//GEN-END:variables
}
