/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjercicioPropio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static EjercicioPropio.Gestor.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author EDU
 */
public class Interfaz extends JFrame implements ActionListener {

    JButton insertar = new JButton("INSERTAR");
    JButton intercambiar = new JButton("INTERCAMBIAR");
    JButton listar = new JButton("LISTAR");
    JButton cerrar = new JButton("CERRAR");

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == insertar) {
            try {
                insertarDatos();
            } catch (Excepciones ex) {
            }
        }
        if (e.getSource() == intercambiar) {
            try {
                intercambiarDatos();
            } catch (Excepciones ex) {
            }
        }
        if (e.getSource() == listar) {
            try {
                listarDatos();
            } catch (Excepciones ex) {

            }
        }
        if (e.getSource() == cerrar) {
            try {
                cerrar();
            } catch (Excepciones ex) {
            }
        }
    }

    public Interfaz() {
        setLayout(null);
        insertar.setBounds(25, 35, 150, 35);
        insertar.addActionListener(this);
        add(insertar);
        intercambiar.setBounds(25, 95, 150, 35);
        intercambiar.addActionListener(this);
        add(intercambiar);
        listar.setBounds(25, 155, 150, 35);
        listar.addActionListener(this);
        add(listar);
        cerrar.setBounds(25, 215, 150, 35);
        cerrar.addActionListener(this);
        add(cerrar);
    }

    public static void main(String[] args) {
        Interfaz frame = new Interfaz();
        frame.setBounds(0, 0, 200, 350);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
