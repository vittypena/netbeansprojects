package interfaces;

import formatoJTable.TableCellRendererColor;
import formatoJTable.HeaderColors;
import gestores.GestorUsuarios;
import modelos.Usuarios;

/**
 *
 * @author Vitty
 */
public class JTablePropaganda extends javax.swing.JFrame {

    public JTablePropaganda() {
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

        setTitle("Propaganda");
        setLocation(new java.awt.Point(0, 200));
        setPreferredSize(new java.awt.Dimension(565, 300));

        jTableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NICK", "PASSWORD", "E-mail", "TELÉFONO"
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
        int tamanioLista = 0;
        int contadorMatriz = 0;
        String asteriscos = "";
        for (Usuarios listaUsuarios : GestorUsuarios.getListaUsuarios()) {
            if (listaUsuarios.isEnviar()) {
                tamanioLista++;
            }
        }
        String matriz[][] = new String[tamanioLista][4];
        for (Usuarios listaUsuarios : GestorUsuarios.getListaUsuarios()) {
            if (listaUsuarios.isEnviar()) {
                matriz[contadorMatriz][0] = listaUsuarios.getNick();
                for (int j = 0; j < listaUsuarios.getPassword().length(); j++) {
                    asteriscos += "*";
                }
                matriz[contadorMatriz][1] = asteriscos;
                asteriscos = "";
                matriz[contadorMatriz][2] = listaUsuarios.getEmail();
                matriz[contadorMatriz][3] = listaUsuarios.getTelefono();
                contadorMatriz++;
            }
        }

        jTableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
                matriz,
                new String[]{
                    "NICK", "PASSWORD", "E-mail", "TELÉFONO"
                }
        ));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUsuarios;
    // End of variables declaration//GEN-END:variables
}
