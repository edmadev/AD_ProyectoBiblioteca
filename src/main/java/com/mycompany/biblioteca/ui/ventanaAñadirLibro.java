/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.biblioteca.ui;

import com.mycompany.biblioteca.DAO.relacional.DML;
import com.mycompany.biblioteca.utils.Comprobaciones;
import javax.swing.JOptionPane;

/**
 *
 * @author dam
 */
public class ventanaAñadirLibro extends javax.swing.JPanel {

    /**
     * Creates new form ventanaAñadirLibro
     */
    DML dml = new DML();

    public ventanaAñadirLibro() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfNombre = new javax.swing.JTextField();
        tfAutor = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        lblAutor = new javax.swing.JLabel();
        lblGenero = new javax.swing.JLabel();
        lblAño = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        cbGeneros = new javax.swing.JComboBox<>();
        tfAnio = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(700, 320));

        lblNombre.setText("Titulo");

        lblAutor.setText("Autor");

        lblGenero.setText("Genero");

        lblAño.setText("Año");

        btnAceptar.setText("Añadir");
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarMouseClicked(evt);
            }
        });

        cbGeneros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Narrativa", "Poesía", "Teatro", "Ensayo", "Ciencia ficción", "Fantasía", "Terror", "Misterio", "Novela negra", "Romántico", "Histórico", "Biografía", "Autobiografía", "Cómic y novela gráfica", "Infantil y juvenil", "Autoayuda", "Filosofía", "Ciencias sociales", "Política", "Religión", "Educación", "Arte y fotografía", "Gastronomía", "Viajes", "Deportes" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(295, 295, 295)
                .addComponent(btnAceptar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbGeneros, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblGenero)
                    .addComponent(lblNombre)
                    .addComponent(tfNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAño)
                    .addComponent(tfAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAutor)
                    .addComponent(tfAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(162, 162, 162))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(lblAutor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGenero)
                    .addComponent(lblAño))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbGeneros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(btnAceptar)
                .addContainerGap(62, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked
        // TODO add your handling code here:
        String titulo = tfNombre.getText();
        String autor = tfAutor.getText();
        String genero = cbGeneros.getSelectedItem().toString();
        int año = Integer.parseInt(tfAnio.getText());
        if (Comprobaciones.esNombreValido(titulo) && Comprobaciones.esNombreValido(autor) && Comprobaciones.esNombreValido(titulo) && Comprobaciones.esAnioValido(String.valueOf(año))) {
            dml.registrarLibro(titulo, autor, genero, año);

            JOptionPane.showMessageDialog(null, "Exito al registrar libro");
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar, revise los campos\nAño solo 4 digitos, espacios nulos o vacios.\nLos nombres no admiten numeros");
        }
    }//GEN-LAST:event_btnAceptarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JComboBox<String> cbGeneros;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblAño;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTextField tfAnio;
    private javax.swing.JTextField tfAutor;
    private javax.swing.JTextField tfNombre;
    // End of variables declaration//GEN-END:variables
}
