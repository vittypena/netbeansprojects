
package interfaces;

import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;


public class FormularioPreguntas extends javax.swing.JFrame {

    String datoComboBox;
    private int numeroRandom;
    public FormularioPreguntas() {
        initComponents();
        jButton2.setBackground(Color.WHITE);
        jButton3.setBackground(Color.WHITE);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Generar Pregunta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Psicología", "Historia de España", "Geografía", "Lengua", "Inglés", " ", " " }));
        jComboBox1.setSelectedIndex(5);
        jComboBox1.setToolTipText("");
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ELIGE LA MATERIA");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 255, 102));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("VERDADERO");

        jButton3.setBackground(new java.awt.Color(255, 51, 51));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setText("FALSO");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 204, 255));
        jLabel2.setText("Elige la materia en el selector");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 109, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(350, 350, 350)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(46, 46, 46))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(93, 93, 93)))
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 1120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 1120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 1120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 1120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton1)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton2)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton3)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 2, Short.MAX_VALUE)))
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
            datoComboBox = jComboBox1.getSelectedItem().toString();
            jLabel1.setText(datoComboBox);            
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jRadioButton4.setText("");
        if(datoComboBox.equalsIgnoreCase("psicologia")){
                psicologia();
            }
            if(datoComboBox.equalsIgnoreCase("Historia de españa")){
                historia();
            }
            if(datoComboBox.equalsIgnoreCase("geografia")){
                geografia();
            }
            if(datoComboBox.equalsIgnoreCase("lengua")){
                lengua();
            }
            if(datoComboBox.equalsIgnoreCase("ingles")){
                ingles();
            }        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        //BOTON A
        jButton2.setBackground(Color.WHITE);
        jButton3.setBackground(Color.WHITE);
        if( numeroRandom==59 |numeroRandom==49 |numeroRandom==46 |numeroRandom==32 |numeroRandom==31 |numeroRandom==30 |numeroRandom==5 |numeroRandom==4 |numeroRandom==26 |numeroRandom==24 |numeroRandom==23 |numeroRandom==22 |numeroRandom==20 |  numeroRandom==9 | numeroRandom==15 |numeroRandom==17){
            jButton2.setBackground(Color.GREEN);
        }else{
            jButton3.setBackground(Color.RED);
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        //BOTON B
        jButton2.setBackground(Color.WHITE);
        jButton3.setBackground(Color.WHITE);
        if( numeroRandom==60 |numeroRandom==57 |numeroRandom==54 |numeroRandom==50 |numeroRandom==42 | numeroRandom==40 |numeroRandom==39 | numeroRandom==38 |numeroRandom==36 |numeroRandom==34 |numeroRandom==33 |numeroRandom==29 |numeroRandom==27 | numeroRandom==3 |numeroRandom==21 |numeroRandom==18 | numeroRandom==6 | numeroRandom==7 | numeroRandom==8 | numeroRandom==11 | numeroRandom==12){
            jButton2.setBackground(Color.GREEN);
        }else{
            jButton3.setBackground(Color.RED);
        }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        //BOTON C
        jButton2.setBackground(Color.WHITE);
        jButton3.setBackground(Color.WHITE);
        if( numeroRandom==56 |numeroRandom==53 |numeroRandom==52 |numeroRandom==48 |numeroRandom==47 |numeroRandom==43 |numeroRandom==41 |numeroRandom==37 |numeroRandom==35 |numeroRandom==28 |numeroRandom==2 |numeroRandom==1 |numeroRandom==25 |numeroRandom==19 |   numeroRandom==10 | numeroRandom==13 | numeroRandom==14 | numeroRandom==16){
            jButton2.setBackground(Color.GREEN);
        }else{
            jButton3.setBackground(Color.RED);
        }        
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        //BOTON D
        jButton2.setBackground(Color.WHITE);
        jButton3.setBackground(Color.WHITE);
        if(numeroRandom==58 |numeroRandom==55 |numeroRandom==51 |numeroRandom==44){
            jButton2.setBackground(Color.GREEN);
        }else{
            jButton3.setBackground(Color.RED);
        }  
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioPreguntas().setVisible(true);
            }
        });
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    // End of variables declaration//GEN-END:variables
    
    
    private void historia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void psicologia(){
        buttonGroup1.clearSelection();
        jButton2.setBackground(Color.WHITE);
        jButton3.setBackground(Color.WHITE);
        jRadioButton4.setVisible(false);
        numeroRandom = (int) (Math.random() * (61 - 1)) + 1;//Entre el 1 y el 5, (Hay que poner 6 para que el maximo sea 5)        
        jLabel4.setText("Pregunta "+ numeroRandom);
        switch(numeroRandom){
            case 1:
                    jLabel3.setText("La Psicologia estudia");
                    jRadioButton1.setText("a) Las conductas humanas.");
                    jRadioButton2.setText("b) Los procesos mentales.");
                    jRadioButton3.setText("c) Todos ellos.");
                    break;
            case 2:
                    jLabel3.setText("La Psicologia evolutiva estudia:");
                    jRadioButton1.setText("a) La personalidad y sus caracteristicas.");
                    jRadioButton2.setText("b) Las lesiones del cerebro y sus consecuencias.");
                    jRadioButton3.setText("c) Los cambios de los procesos psicologicos en la vida del individuo.");
                    break;
            case 3:
                    jLabel3.setText("La escuela psicoanalitica considera que:");
                    jRadioButton1.setText("a) Las personas son basicamente buenas.");
                    jRadioButton2.setText("b) Hay que analizar los fenomenos mentales inconscientes.");
                    jRadioButton3.setText("c) Los psicologos deben estudiar los hechos observables.");
                    break;
            case 4:
                    jLabel3.setText("La Psicologia Clinica:");
                    jRadioButton1.setText("a) Trabaja problemas emocionales y de conducta.");
                    jRadioButton2.setText("b) Hace seleccion de trabajores para las empresas.");
                    jRadioButton3.setText("c) Estudia la latencia entre estimulo y respuesta.");
                    break;
            case 5:
                    jLabel3.setText("La sinapsis es:");
                    jRadioButton1.setText("a) La unión entre un axón y una dentrita.");
                    jRadioButton2.setText("b) Un neurotransmisor.");
                    jRadioButton3.setText("c) La unión de dos axones.");
                    break;
            case 6:
                    jLabel3.setText("Las raíces de la psicología son:");
                    jRadioButton1.setText("a) La medicina y la historia.");
                    jRadioButton2.setText("b) La filosofía y la fisiología.");
                    jRadioButton3.setText("c) La psiquiatría y el psicoanalisis.");
                    break;
            case 7:
                    jLabel3.setText("La investigación sobre los sueños es característica de:");
                    jRadioButton1.setText("a) La psicología cognitiva.");
                    jRadioButton2.setText("b) El psicoanálisis.");
                    jRadioButton3.setText("c) El conductismo.");
                    break;
            case 8:
                    jLabel3.setText("Una neurona actúa como");
                    jRadioButton1.setText("a) Una célula más.");
                    jRadioButton2.setText("b) Transmisora y efectora del impulso nervioso.");
                    jRadioButton3.setText("c) Receptora.");
                    break;
            case 9:
                    jLabel3.setText("El sistema nervioso central está constituido por:");
                    jRadioButton1.setText("a) El cerebro y la médula espinal.");
                    jRadioButton2.setText("b) El sistema somático y el sistema autónomo.");
                    jRadioButton3.setText("c) El sistema simpático y el sistema parasimpático.");
                    break;
            case 10:
                    jLabel3.setText("¿Qué técnina registra las señales eléctricas del cerebro");
                    jRadioButton1.setText("a) Tomografía axial computarizada(TAC).");
                    jRadioButton2.setText("b) Tomografía por emisión de positrones(TEP).");
                    jRadioButton3.setText("c) Electroencefalograma(EEG).");
                    break;
            case 11:
                    jLabel3.setText("Las sustancias químicas que regulan el metabolismo se denominan");
                    jRadioButton1.setText("a) Glándulas.");
                    jRadioButton2.setText("b) Hormonas.");
                    jRadioButton3.setText("c) Gónadas.");
                    break;
            case 12:
                    jLabel3.setText("¿Cuál de las siguientes afirmaciones es verdadera?");
                    jRadioButton1.setText("a) Los umbrales de los estímulos son absolutos para cada persona y no varían ante estímulos diferentes.");
                    jRadioButton2.setText("b) La información sobre un acontecimiento externo llega al ojo en forma de energia electromagnética, pero no se transmite al cerebro del observador a traves de cambios electroquímicos.");
                    jRadioButton3.setText("c) No toda actividad perceptiva se produce en un contexto.");
                    break;
            case 13:
                    jLabel3.setText("La percepción es un proceso bipolar que depende de:");
                    jRadioButton1.setText("a) Las características de los estímulos que activan los órganos de los sentidos.");
                    jRadioButton2.setText("b) La actividad del sujeto perceptor.");
                    jRadioButton3.setText("c) Las respuestas anteriores son verdaderas.");
                    break;
            case 14:
                    jLabel3.setText("Las características del observador que influyen en la percepción son:");
                    jRadioButton1.setText("a) Necesidades y valores.");
                    jRadioButton2.setText("b) Actitudes y personalidad.");
                    jRadioButton3.setText("c) Las respuestas anteriores son verdaderas.");
                    break;
            case 15:
                    jLabel3.setText("El aprendizaje:");
                    jRadioButton1.setText("a) Es un cambio en la conducta fruto de la experiencia con los acontecimientos ambientales.");
                    jRadioButton2.setText("b) No depende del nivel de maduración del sujeto.");
                    jRadioButton3.setText("c) No supone ningún esfuerzo.");
                    break;
            case 16:
                    jLabel3.setText("En el aprendizaje instrumental, el elemento principal es:");
                    jRadioButton1.setText("a) El estímulo.");
                    jRadioButton2.setText("b) El refuerzo.");
                    jRadioButton3.setText("c) La respuesta.");
                    break;
            case 17:
                    jLabel3.setText("¿De qué estructura de la memoria es característico retener la información de manera consciente?");
                    jRadioButton1.setText("a) Memoria a corto plazo.");
                    jRadioButton2.setText("b) Memoria a largo plazo.");
                    jRadioButton3.setText("c) Memoria sensorial.");
                    break;
            case 18:
                    jLabel3.setText("La lógica nos proporciona:");
                    jRadioButton1.setText("a) Reglas para opinar bien.");
                    jRadioButton2.setText("b) Reglas para realizar razonamientos válidos.");
                    jRadioButton3.setText("c) Las respuestas anteriores son falsas.");
                    break;
            case 19:
                    jLabel3.setText("La simbolización y la intencionalidad son características de la conducta:");
                    jRadioButton1.setText("a) Refleja.");
                    jRadioButton2.setText("b) Fisiológica.");
                    jRadioButton3.setText("c) Inteligente.");
                    break;
            case 20:
                    jLabel3.setText("La evaluación psicométrica de la inteligencia surgió con:");
                    jRadioButton1.setText("a) Piaget.");
                    jRadioButton2.setText("b) Guilford.");
                    jRadioButton3.setText("c) Binet.");
                    break;
            case 21:
                    jLabel3.setText("¿Con qué fenómeno suele estar relacionada la declinación del CI en la vejez");
                    jRadioButton1.setText("a) Falta de creatividad.");
                    jRadioButton2.setText("b) Inactividad.");
                    jRadioButton3.setText("c) Ambición excesiva.");
                    break;
            case 22:
                    jLabel3.setText("¿Cómo se define el término impulso");
                    jRadioButton1.setText("a) Un instinto.");
                    jRadioButton2.setText("b) Un motivo con base fisiológica.");
                    jRadioButton3.setText("c) Un motivo social.");
                    break;
            case 23:
                    jLabel3.setText("¿Qué motivación representa el deseo de no estar solo");
                    jRadioButton1.setText("a) Motivación de afilicación.");
                    jRadioButton2.setText("b) Motivación de logro.");
                    jRadioButton3.setText("c) Motivación de intimidad.");
                    break;
            case 24:
                    jLabel3.setText("El conductismo interpreta la personalidad como:");
                    jRadioButton1.setText("a) Una conducta habitual aprendida.");
                    jRadioButton2.setText("b) Una conducta inconsciente.");
                    jRadioButton3.setText("c) Un conjunto de rasgos estables.");
                    break;
            case 25:
                    jLabel3.setText("La teoría del aprendizaje social:");
                    jRadioButton1.setText("a) Defiende una concepción mecanicista de la conducta.");
                    jRadioButton2.setText("b) Postula el carácter activo del individuo.");
                    jRadioButton3.setText("c) Revaloriza los factores emocionales frente a los cognitivos.");
                    break;
            case 26:
                    jLabel3.setText("¿Cuál es el límite entre el comportamiento <<normal>> y patológico?");
                    jRadioButton1.setText("a) No hay una frontera claramente definida.");
                    jRadioButton2.setText("b) Lo <<normal>> es lo que hace la mayoría.");
                    jRadioButton3.setText("c) Lo <<normal>> es aceptar las leyes y normas sociales.");
                    break;
            case 27:
                    jLabel3.setText("El desorden degenerativo que llega a producir pérdida de la memoria, confusión y cambios de personalidad en sus pacientes se conoce como:");
                    jRadioButton1.setText("a) Autismo.");
                    jRadioButton2.setText("b) Enfermedad de Alzheimer.");
                    jRadioButton3.setText("c) Enfermedad de Parkinson.");
                    break;
            case 28:
                    jLabel3.setText("¿Cual de las siguientes estructuras cerebrales es vital para funciones biológicas importantes comoe l control de comer, beber y la conducta sexual?");
                    jRadioButton1.setText("a) Tálamo.");
                    jRadioButton2.setText("b) Cuerpo calloso.");
                    jRadioButton3.setText("c) Hipotálamo.");
                    break;
            case 29:
                    jLabel3.setText("¿Qué autor fundamentó su teoría de la evolución en la seleccion natural?");
                    jRadioButton1.setText("a) Lamark.");
                    jRadioButton2.setText("b) Darwin.");
                    jRadioButton3.setText("c) Linneus.");
                    break;
            case 30:
                    jLabel3.setText("¿A qué campo de estudio de la Psicología pertenecen las Leyes de la agrupación de estímulos");
                    jRadioButton1.setText("a) Percepción.");
                    jRadioButton2.setText("b) Atención.");
                    jRadioButton3.setText("c) Memoria.");
                    break;
            case 31:
                    jLabel3.setText("Según Piaget, en que etapa del desarrollo cognitivo se adquiere la 'Permanencia del Objeto'?");
                    jRadioButton1.setText("a) Periodo sensoriomotor.");
                    jRadioButton2.setText("b) Periodo preoperatorio.");
                    jRadioButton3.setText("c) Periodo de las operaciones concretas.");
                    break;
            case 32:
                    jLabel3.setText("La cocaína es un:");
                    jRadioButton1.setText("a) Estimulante del Sistema Nervioso Central.");
                    jRadioButton2.setText("b) Depresor del Sistema Nervioso Central.");
                    jRadioButton3.setText("c) Una sustancia visionaria.");
                    break;
            case 33:
                    jLabel3.setText("El aprendizaje por condicionamiento clásico se basa en:");
                    jRadioButton1.setText("a) Aplicar un refuerzo a una conducta.");
                    jRadioButton2.setText("b) Asociar un estímulo neutro con un estímulo incondicionado.");
                    jRadioButton3.setText("c) Premiar una conducta que queremos que se produzca.");
                    break;
            case 34:
                    jLabel3.setText("La amnesia retrógrada:");
                    jRadioButton1.setText("a) Es la incapacidad para almacenar nuevos recuerdos.");
                    jRadioButton2.setText("b) Es la incapacidad para recordar acontecimientos vividos en el pasado.");
                    jRadioButton3.setText("c) Es la incapacidad para recordar el significado de las palabras.");
                    break;
            case 35:
                    jLabel3.setText("¿En qué grupo incluiríamos a una persona con un Cociente Intelectual de 90");
                    jRadioButton1.setText("a) Deficientes.");
                    jRadioButton2.setText("b) Superdotados.");
                    jRadioButton3.setText("c) Normal.");
                    break;
            case 36:
                    jLabel3.setText("Según J.Piaget la inteligencia:");
                    jRadioButton1.setText("a) La inteligencia es innata.");
                    jRadioButton2.setText("b) La inteligencia se desarrolla en cuatro etapas a lo largo de la vida.");
                    jRadioButton3.setText("c) La inteligencia es múltiple.");
                    break;
            case 37:
                    jLabel3.setText("¿Cuál de las siguientes teorías defiende que los estímulos se perciben como un todo organizado?");
                    jRadioButton1.setText("a) Asociacionismo.");
                    jRadioButton2.setText("b) Teorías Neuropsicológicas.");
                    jRadioButton3.setText("c) Teoria de la Gestalt.");
                    break;
            case 38:
                    jLabel3.setText("Según la teoría motivacional de A.Maslow ¿Qué tipo de motivación está en el nivel más alto de su famosa pirámide");
                    jRadioButton1.setText("a) Las necesidades de seguridad.");
                    jRadioButton2.setText("b) La autorealización.");
                    jRadioButton3.setText("c) Las necesidades morales y estéticas.");
                    break;
            case 39:
                    jLabel3.setText("¿Qué mecanismo de defensa se caracteriza por rechazar y mantener fuera de la conciencia los contenidos que resultan dolorosos o inaceptables para el individuo?");
                    jRadioButton1.setText("a) Fijación.");
                    jRadioButton2.setText("b) Represión.");
                    jRadioButton3.setText("c) Sublimación.");
                    break;
            case 40:
                    jLabel3.setText("¿Cómo denomina Skinner a la recompensa que se otorga cuando el sujeto lleva a cabo una conducta deseada?");
                    jRadioButton1.setText("a) REfuerzo Negativo.");
                    jRadioButton2.setText("b) Refuerzo Positivo.");
                    jRadioButton3.setText("c) Castigo Positivo.");
                    break;
            case 41:
                    jLabel3.setText("La atracción sexual es un fenómeno:");
                    jRadioButton1.setText("a) Psicologico.");
                    jRadioButton2.setText("b) Cultural.");
                    jRadioButton3.setText("c) Ambas cosas.");
                    break;
            case 42:
                    jLabel3.setText("La esquizofrenia es una psicopatía consistente en:");
                    jRadioButton1.setText("a) Una reacción de atracción y defensa ante algo que nos porduce angustia.");
                    jRadioButton2.setText("b) Un malestar que afecta al cuerpo y a la mente y las emociones, e interfiere gravemente en la actividad cotidiana del individuo.");
                    jRadioButton3.setText("c) Se caracteriza por sufrir percepciones perturbadas, la desorganización en el pensamiento, vivir en un mundo ilusorio e inexistente y el retraimiento social.");
                    break;
            case 43:
                    jLabel3.setText("Se considera que el fundador de la psicología científica fue:");
                    jRadioButton1.setText("a) Watson, con su pretensión de hacer de la psicología una ciencia objetiva.");
                    jRadioButton2.setText("b) Freud, al escribir su Introducción al Psicoanalisis.");
                    jRadioButton3.setText("c) Wundt, que creó el primer laboratorio de psicología experimental.");
                    jRadioButton4.setText("d) Paulov, que inicio sus experimentos con perros.");
                    jRadioButton4.setVisible(true);
                    break;
            case 44:
                    jLabel3.setText("En la teoría sobre la motivación de Maslow se expresan las necesidades humanas mediante una pirámide. ¿Qué necesidades ocupan el vértice de dicha pirámide?");
                    jRadioButton1.setText("a) Necesidades amorosas y afectivas.");
                    jRadioButton2.setText("b) Necesidades fisiológicas.");
                    jRadioButton3.setText("c) Necesidades de proctección.");
                    jRadioButton4.setText("d) Necesidades de autorealización.");
                    jRadioButton4.setVisible(true);
                    break;
            case 45:
                    jLabel3.setText("El temperamento de la persona tiene una base:");
                    jRadioButton1.setText("a) Genética.");
                    jRadioButton2.setText("b) Social.");
                    jRadioButton3.setText("c) Moral.");
                    jRadioButton4.setText("d) Ambiental.");
                    jRadioButton4.setVisible(true);
                    break;
            case 46:
                    jLabel3.setText("El concepto de percepción subliminal se refiere a:");
                    jRadioButton1.setText("a) Percepción constante.");
                    jRadioButton2.setText("b) Percepción no consciente.");
                    jRadioButton3.setText("c) Percepción consciente.");
                    jRadioButton4.setText("d) Percepción extrasensorial.");
                    jRadioButton4.setVisible(true);
                    break;
            case 47:
                    jLabel3.setText("'El todo es más que la suma de las partes'. Esta frase fue formulada por:");
                    jRadioButton1.setText("a) La teoría asociacionista.");
                    jRadioButton2.setText("b) Wundt.");
                    jRadioButton3.setText("c) La gestalt.");
                    jRadioButton4.setText("d) La teoría conductista.");
                    jRadioButton4.setVisible(true);
                    break;
            case 48:
                    jLabel3.setText("El test de personalidad de Rorschach consiste en:");
                    jRadioButton1.setText("a) El sujeto debe dibujar una casa, un árbol y una persona.");
                    jRadioButton2.setText("b) El sujeto indica lo que le sugieren una serie de imágenes de personas interactuando.");
                    jRadioButton3.setText("c) El sujeto indica lo que le sugieren una serie de láminas con manchas de tinta.");
                    jRadioButton4.setText("d) El sujeto observa una serie de imágenes de dos personas en las que sólo aparece lo que dice una de ellas, teniendo que imaginar lo que dice la otra perosna y cómo se siente.");
                    jRadioButton4.setVisible(true);
                    break;
            case 49:
                    jLabel3.setText("El principio de placer de Freud rige sobre:");
                    jRadioButton1.setText("a) El ello.");
                    jRadioButton2.setText("b) El yo.");
                    jRadioButton3.setText("c) El superyó.");
                    jRadioButton4.setText("d) El arquetipo.");
                    jRadioButton4.setVisible(true);
                    break;
            case 50:
                    jLabel3.setText("El déficit de la dopamina cerebral con la pérdida de neuronas está relacionado con:");
                    jRadioButton1.setText("a) Alzheimer.");
                    jRadioButton2.setText("b) Parkinson.");
                    jRadioButton3.setText("c) Epilepsia.");
                    jRadioButton4.setText("d) Síndrome de Down.");
                    jRadioButton4.setVisible(true);
                    break;
            case 51:
                    jLabel3.setText("En el experimento de Pavlolv con el perro, la comida es:");
                    jRadioButton1.setText("a) Estímulo Condicionado (EC).");
                    jRadioButton2.setText("b) Estímulo Incondicionado (EI).");
                    jRadioButton3.setText("c) Respuesta Condicionada (RC).");
                    jRadioButton4.setText("d) Respuesta Incondicionada (RI).");
                    jRadioButton4.setVisible(true);
                    break;
            case 52:
                    jLabel3.setText("Las sustancias químicas que facilitan o dificultan la sinapsis entre neuronas se llaman:");
                    jRadioButton1.setText("a) Neuroreceptores.");
                    jRadioButton2.setText("b) Neuroinhibidores.");
                    jRadioButton3.setText("c) Neurotransmisores.");
                    jRadioButton4.setText("d) Neuroconectores.");
                    jRadioButton4.setVisible(true);
                    break;
            case 53:
                    jLabel3.setText("El síndrome de Down consiste en una alteración genética. ¿De qué tipo?");
                    jRadioButton1.setText("a) Monosomía.");
                    jRadioButton2.setText("b) Disomía.");
                    jRadioButton3.setText("c) Trisomía.");
                    jRadioButton4.setText("d) Tetrasomía.");
                    jRadioButton4.setVisible(true);
                    break;
            case 54:
                    jLabel3.setText("A la capacidad de ponernos en el lugar de los demás se denomina:");
                    jRadioButton1.setText("a) Tolerancia.");
                    jRadioButton2.setText("b) Empatía.");
                    jRadioButton3.setText("c) Asertividad.");
                    jRadioButton4.setText("d) Filantropía.");
                    jRadioButton4.setVisible(true);
                    break;
            case 55:
                    jLabel3.setText("El razonamiento que parte de hechos particulares para alcanzar una conclusión de tipo general se llama:");
                    jRadioButton1.setText("a) Deductivo.");
                    jRadioButton2.setText("b) Divergente.");
                    jRadioButton3.setText("c) Holístico.");
                    jRadioButton4.setText("d) Inductivo.");
                    jRadioButton4.setVisible(true);
                    break;
            case 56:
                    jLabel3.setText("Cuando se monta en bicicleta se está usando la memoria:");
                    jRadioButton1.setText("a) Visual.");
                    jRadioButton2.setText("b) Episódica.");
                    jRadioButton3.setText("c) A largo plazo.");
                    jRadioButton4.setText("d) Procedimental.");
                    jRadioButton4.setVisible(true);
                    break;
            case 57:
                    jLabel3.setText("El prejuicio según el cual la cultura propia es superior a todas las demás se denomina:");
                    jRadioButton1.setText("a) Multiculturalismo.");
                    jRadioButton2.setText("b) Etnocentrismo.");
                    jRadioButton3.setText("c) Culturización.");
                    jRadioButton4.setText("d) Interculturalismo.");
                    jRadioButton4.setVisible(true);
                    break;
            case 58:
                    jLabel3.setText("¿Qué mecanismo de defensa se caracteriza por rechazar y mantener fuera de la conciencia los contenidos que resultan dolorosos o inaceptables para el individuo?");
                    jRadioButton1.setText("a) Proyección.");
                    jRadioButton2.setText("b) Regresión.");
                    jRadioButton3.setText("c) Sublimación.");
                    jRadioButton4.setText("d) Represión.");
                    jRadioButton4.setVisible(true);
                    break;
            case 59:
                    jLabel3.setText("¿Qué autor desarrolló el concepto de aprendizaje significativo?");
                    jRadioButton1.setText("a) Ausubel.");
                    jRadioButton2.setText("b) Skinner.");
                    jRadioButton3.setText("c) Piaget.");
                    jRadioButton4.setText("d) Bandura.");
                    jRadioButton4.setVisible(true);
                    break;
            case 60:
                    jLabel3.setText("Entendemos por 'agorafobia' al temor a:");
                    jRadioButton1.setText("a) Las enfermedades.");
                    jRadioButton2.setText("b) Los lugares abiertos.");
                    jRadioButton3.setText("c) Los lugares altos.");
                    jRadioButton4.setText("d) Las arañas.");
                    jRadioButton4.setVisible(true);
                    break;
            case 61:
                    jLabel3.setText("");
                    jRadioButton1.setText("a) .");
                    jRadioButton2.setText("b) .");
                    jRadioButton3.setText("c) .");
                    jRadioButton4.setText("d) .");
                    break;
        }
    }

    private void geografia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void lengua() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void ingles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
