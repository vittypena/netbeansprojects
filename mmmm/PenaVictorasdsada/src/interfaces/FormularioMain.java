package interfaces;

import excepciones.Excepciones;
import gestores.GestorUsuarios;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelos.Usuarios;

/**
 *
 * @author Vitty
 */
public class FormularioMain extends javax.swing.JFrame {

    public FormularioMain() throws Excepciones {
        initComponents();
        GestorUsuarios.iniciarListaUsuarios();
        leerInfoArchivo("C:\\Users\\Vitty\\Documents\\NetBeansProjects\\PenaVictor\\src\\archivos\\usuarios.txt");
        setIconImage(new ImageIcon(getClass().getResource("Frame.png")).getImage());//Se que esta en la misma ruta y deberia de estar en la carpeta imagenes, pero la ruta /imagenes/Frame.png la tengo bugeada 
        //(incluyendo la imagen alli tambien), funcionaba y derrepente NullPointerException, estuve buscando y era una corrupcion de mi IDE o algo asi, asi que opte por ponerlo en la misma carpeta, aun sin ser una buena practica
        //Con la imagen del label pasa lo mismo, la ruta estaba 100% bien ya que lo hacia desde la ventana de diseño, propiedades en el label icon y ponia la ruta alli de forma manual, si seleccionaba
        //la de imagenes NullPointerException, asi que hice lo mismo y sin problema. Segun he buscado si formateo el ordenador o reinstalo las librerias de java se soluciona el error, pero ahora en pleno proyecto no me la puedo jugar a toquiñear cosas.
        //Creo que ejecutandolo desde otro ordenador la ruta /imagenes/archivo funcionaba pero por si acaso saltaba la excepcion no me la he jugado.
        //adjunto busqueda del error (https://www.google.com/search?q=Exception+in+thread+%22AWT-EventQueue-0%22+java.lang.NullPointerException+at+javax.swing.ImageIcon.%3Cinit%3E&oq=Exception+in+thread+%22AWT-EventQueue-0%22+java.lang.NullPointerException+at+javax.swing.ImageIcon.%3Cinit%3E&aqs=edge..69i57.745j0j1&sourceid=chrome&ie=UTF-8)
        //si tiene facil solucion me gustaria saberlo para la proxima, ya que mas adelante voy a tener problemas con las rutas por el bug, gracias, perdona la parrafada
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        nick = new javax.swing.JLabel();
        jText_nick = new javax.swing.JTextField();
        password = new javax.swing.JLabel();
        jPassword_password = new javax.swing.JPasswordField();
        jButton_olvidado = new javax.swing.JButton();
        jButton_entrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        nick_registro = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        telefono = new javax.swing.JLabel();
        password_registro = new javax.swing.JLabel();
        passwordRepetir_registro = new javax.swing.JLabel();
        jText_nick_registro = new javax.swing.JTextField();
        jText_email = new javax.swing.JTextField();
        jText_telefono = new javax.swing.JTextField();
        jPassword_password_registro = new javax.swing.JPasswordField();
        jPassword_passwordRepetir_registro = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        jCheckBox_informacion = new javax.swing.JCheckBox();
        jButton_registrarse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("La compra en casa");

        jLabel1.setFont(new java.awt.Font("Palatino Linotype", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("Mi Web");

        nick.setForeground(new java.awt.Color(0, 51, 255));
        nick.setText("Nick");

        jText_nick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_nickActionPerformed(evt);
            }
        });

        password.setForeground(new java.awt.Color(0, 51, 255));
        password.setText("Contraseña");

        jButton_olvidado.setForeground(new java.awt.Color(0, 51, 255));
        jButton_olvidado.setText("¿Has olvidado la contraseña?");
        jButton_olvidado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_olvidadoActionPerformed(evt);
            }
        });

        jButton_entrar.setFont(new java.awt.Font("Microsoft Tai Le", 1, 18)); // NOI18N
        jButton_entrar.setForeground(new java.awt.Color(0, 51, 255));
        jButton_entrar.setText("ENTRAR");
        jButton_entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_entrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nick)
                        .addGap(98, 98, 98)
                        .addComponent(password))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jText_nick, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPassword_password, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton_olvidado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addComponent(jButton_entrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton_entrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nick)
                            .addComponent(password))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jText_nick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPassword_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_olvidado)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/imagenLabel.png"))); // NOI18N

        nick_registro.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        nick_registro.setForeground(new java.awt.Color(0, 51, 255));
        nick_registro.setText("Nick");

        email.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        email.setForeground(new java.awt.Color(0, 51, 255));
        email.setText("Correo electrónico");

        telefono.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        telefono.setForeground(new java.awt.Color(0, 51, 255));
        telefono.setText("Telefono");

        password_registro.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        password_registro.setForeground(new java.awt.Color(0, 51, 255));
        password_registro.setText("Contraseña");

        passwordRepetir_registro.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        passwordRepetir_registro.setForeground(new java.awt.Color(0, 51, 255));
        passwordRepetir_registro.setText("Repetir Contraseña");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(nick_registro))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(email)
                            .addComponent(passwordRepetir_registro, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telefono)
                            .addComponent(password_registro))))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jText_nick_registro)
                    .addComponent(jText_email)
                    .addComponent(jText_telefono)
                    .addComponent(jPassword_password_registro)
                    .addComponent(jPassword_passwordRepetir_registro))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nick_registro)
                    .addComponent(jText_nick_registro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email)
                    .addComponent(jText_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefono)
                    .addComponent(jText_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password_registro)
                    .addComponent(jPassword_password_registro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordRepetir_registro)
                    .addComponent(jPassword_passwordRepetir_registro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jCheckBox_informacion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCheckBox_informacion.setForeground(new java.awt.Color(0, 51, 255));
        jCheckBox_informacion.setText("Deseo recibir información cada diez minutos");

        jButton_registrarse.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_registrarse.setForeground(new java.awt.Color(0, 51, 255));
        jButton_registrarse.setText("REGISTRARSE");
        jButton_registrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_registrarseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jCheckBox_informacion, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_registrarse, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox_informacion)
                    .addComponent(jButton_registrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jText_nickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_nickActionPerformed

    }//GEN-LAST:event_jText_nickActionPerformed

    private void jButton_registrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_registrarseActionPerformed
        //CODIGO BOTON REGISTRARSE
        boolean comprobar = false;
        String textoNickRegistro = jText_nick_registro.getText();
        String textoEmail = jText_email.getText();
        String textoTelefono = jText_telefono.getText();
        String textoPassword;
        String textoPasswordRepetir;
        String textoCheckbox = "no";
        boolean noLimpiarNoCrear = false;
        boolean booleanCheckbox = false;
        if (jCheckBox_informacion.isSelected()) {
            textoCheckbox = "si";
            booleanCheckbox = true;
        }
        char[] arrayPasswordRegistro = jPassword_password_registro.getPassword();
        textoPassword = new String(arrayPasswordRegistro);
        char[] arrayPasswordRepetirRegistro = jPassword_passwordRepetir_registro.getPassword();
        textoPasswordRepetir = new String(arrayPasswordRepetirRegistro);
        if (!textoPassword.equals(textoPasswordRepetir)) {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
            return;
        }

        if (textoNickRegistro.equals("") || textoEmail.equals("") || textoTelefono.equals("") || textoPassword.equals("")) {
            JOptionPane.showMessageDialog(null, "Faltan datos");
        } else {
            comprobar = true;
        }

        if (comprobar) {
            String fila = textoNickRegistro + " " + textoPassword + " " + textoEmail + " " + textoTelefono + " " + textoCheckbox;
            try {
                if (!GestorUsuarios.añadirUsuario(new Usuarios(textoNickRegistro, textoPassword, textoEmail, textoTelefono, booleanCheckbox))) {
                    noLimpiarNoCrear = true;
                    JOptionPane.showMessageDialog(null, "Alta correcta");
                }
            } catch (Excepciones ex) {
                System.out.println(ex.getMessage());
            }
            if (noLimpiarNoCrear) {
                File archivo = new File("C:\\Users\\Vitty\\Documents\\NetBeansProjects\\PenaVictor\\src\\archivos\\usuarios.txt");
                try {

                    BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true));
                    writer.write(fila + System.getProperty("line.separator"));
                    writer.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace(System.out);
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                }

                //Limpiar Formulario Registro                
                jText_nick_registro.setText("");
                jText_email.setText("");
                jText_telefono.setText("");
                jPassword_password_registro.setText("");
                jPassword_passwordRepetir_registro.setText("");
                if (jCheckBox_informacion.isSelected()) {
                    jCheckBox_informacion.setSelected(false);
                }
            }
        }
    }//GEN-LAST:event_jButton_registrarseActionPerformed

    private void jButton_entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_entrarActionPerformed
        //CODIGO BOTON ENTRAR
        String textoNick = jText_nick.getText();
        String textoPassword;
        char[] arrayPassword = jPassword_password.getPassword();
        textoPassword = new String(arrayPassword);
        boolean comprobar = GestorUsuarios.listarUsuarios(textoNick, textoPassword);
        if (comprobar) {
            jText_nick.setText("");
            jPassword_password.setText("");
            if (textoNick.equals("crisbar") && textoPassword.equals("1111")) {
                JTableUsuarios tablaUsuarios = new JTableUsuarios();
                tablaUsuarios.setVisible(true);
                JTablePropaganda tablaPropaganda = new JTablePropaganda();
                tablaPropaganda.setVisible(true);
                JOptionPane.showMessageDialog(null, "Bienvenido admin");
            } else {
                JOptionPane.showMessageDialog(null, "Has entrado en el sitio");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrectos");
        }
    }//GEN-LAST:event_jButton_entrarActionPerformed

    private void jButton_olvidadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_olvidadoActionPerformed
        //CODIGO BOTON OLVIDAR CONTRASEÑA        
        String textoNick = jText_nick.getText();
        String textoEmail = jText_email.getText();
        String textoTelefono = jText_telefono.getText();
        boolean comprobar = false;
        try {
            comprobar = GestorUsuarios.olvidarPassword(textoNick, textoEmail, textoTelefono);
        } catch (Excepciones ex) {
            System.out.println(ex.getMessage());
        }
        if (comprobar) {
            JOptionPane.showMessageDialog(null, "Se ha cambiado la contraseña a 'password'");
            jText_nick.setText("");
            jText_email.setText("");
            jText_telefono.setText("");
        }
    }//GEN-LAST:event_jButton_olvidadoActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FormularioMain().setVisible(true);
                } catch (Excepciones ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
    }

    public static void leerInfoArchivo(String nombreArchivo) throws Excepciones {
        File archivo = new File(nombreArchivo);
        int contador = 0;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura;
            while ((lectura = entrada.readLine()) != null) {
                String nombre = "";
                String password = "";
                String email = "";
                String telefono = "";
                boolean informacion = false;
                String[] strArr = lectura.split("\\ ");
                for (String str : strArr) {
                    if (contador == 0) {
                        nombre = str;
                    } else if (contador == 1) {
                        password = str;
                    } else if (contador == 2) {
                        email = str;
                    } else if (contador == 3) {
                        telefono = str;
                    } else if (contador == 4) {
                        if (str.equals("si")) {
                            informacion = true;
                        } else if (str.equals("no")) {
                            informacion = false;
                        }
                    }
                    contador++;
                }
                contador = 0;
                GestorUsuarios.añadirUsuario(new Usuarios(nombre, password, email, telefono, informacion));
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel email;
    private javax.swing.JButton jButton_entrar;
    private javax.swing.JButton jButton_olvidado;
    private javax.swing.JButton jButton_registrarse;
    private javax.swing.JCheckBox jCheckBox_informacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPassword_password;
    private javax.swing.JPasswordField jPassword_passwordRepetir_registro;
    private javax.swing.JPasswordField jPassword_password_registro;
    private javax.swing.JTextField jText_email;
    private javax.swing.JTextField jText_nick;
    private javax.swing.JTextField jText_nick_registro;
    private javax.swing.JTextField jText_telefono;
    private javax.swing.JLabel nick;
    private javax.swing.JLabel nick_registro;
    private javax.swing.JLabel password;
    private javax.swing.JLabel passwordRepetir_registro;
    private javax.swing.JLabel password_registro;
    private javax.swing.JLabel telefono;
    // End of variables declaration//GEN-END:variables
}
