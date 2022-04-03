/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjercicioPropio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EDU
 */
public class Tabla extends JFrame {

    JTable tabla;
    JScrollPane scroll;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;

    public Tabla() throws Excepciones {
        {

            jScrollPane1 = new javax.swing.JScrollPane();
            jTable1 = new javax.swing.JTable();

            //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                    devuelve(),
                    new String[]{
                        "Codigo", "Nombre"
                    }
            ) {
                Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class
                };
                boolean[] canEdit = new boolean[]{
                    false, false
                };

                public Class getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });
            jTable1.getTableHeader().setReorderingAllowed(false);
            jScrollPane1.setViewportView(jTable1);
            if (jTable1.getColumnModel().getColumnCount() > 0) {
                jTable1.getColumnModel().getColumn(0).setResizable(false);
                jTable1.getColumnModel().getColumn(1).setResizable(false);
            }

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
            );

            pack();
        }
    }

    public static Object[][] devuelve() throws Excepciones {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/probando", "dani", "dani");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM PRUEBAS");
            String columnas[] = {"Codigo", "Nombre"};
            Object data[][] = new Object[40][columnas.length];
            int i = 0;
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String codigo = rs.getString("codigo");
                data[i][0] = codigo;
                data[i][1] = nombre;
                i++;
            }
            return data;
        } catch (SQLException e) {
            throw new Excepciones("Error con la base de datos");
        }
    }
}
