/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.biblioteca.ui;

import java.awt.BorderLayout;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultKeyedValuesDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author JHB
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    VentanaLibros vI = new VentanaLibros();
    VentanaUsuarios vU = new VentanaUsuarios();
    VentanaPrestamos vP = new VentanaPrestamos();
    VentanaEventos vE = new VentanaEventos();
    VentanaTablas vT = new VentanaTablas();
        DefaultPieDataset dataset = new DefaultKeyedValuesDataset();

    VentanaConfiguracion vConfiguracion = new VentanaConfiguracion();

    public MenuPrincipal() {
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

        lblTitulo = new javax.swing.JLabel();
        btnLibros = new javax.swing.JButton();
        btnUsuarios = new javax.swing.JButton();
        btnPrestamos = new javax.swing.JButton();
        btnEventos = new javax.swing.JButton();
        btnConfiguracion = new javax.swing.JButton();
        pnInsertarVentana = new javax.swing.JPanel();
        btnMultas = new javax.swing.JButton();
        btnTablas = new javax.swing.JButton();
        btnGrafica = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblTitulo.setText("BIBLIOTECA");

        btnLibros.setText("Gestionar Libros");
        btnLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLibrosActionPerformed(evt);
            }
        });

        btnUsuarios.setText("Gestionar Usuarios");
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });

        btnPrestamos.setText("Prestamos y devoluciones");
        btnPrestamos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrestamosActionPerformed(evt);
            }
        });

        btnEventos.setText("Eventos");
        btnEventos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEventosActionPerformed(evt);
            }
        });

        btnConfiguracion.setText("Configuracion");
        btnConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfiguracionActionPerformed(evt);
            }
        });

        pnInsertarVentana.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout pnInsertarVentanaLayout = new javax.swing.GroupLayout(pnInsertarVentana);
        pnInsertarVentana.setLayout(pnInsertarVentanaLayout);
        pnInsertarVentanaLayout.setHorizontalGroup(
            pnInsertarVentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnInsertarVentanaLayout.setVerticalGroup(
            pnInsertarVentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnMultas.setText("Multas");
        btnMultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMultasActionPerformed(evt);
            }
        });

        btnTablas.setText("Tablas");
        btnTablas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTablasActionPerformed(evt);
            }
        });

        btnGrafica.setText("Gráfica de Usuarios");
        btnGrafica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraficaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPrestamos, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(btnUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLibros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEventos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConfiguracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMultas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTablas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGrafica, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnInsertarVentana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(518, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(401, 401, 401))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(btnLibros)
                .addGap(18, 18, 18)
                .addComponent(btnUsuarios)
                .addGap(18, 18, 18)
                .addComponent(btnPrestamos)
                .addGap(18, 18, 18)
                .addComponent(btnEventos)
                .addGap(18, 18, 18)
                .addComponent(btnMultas)
                .addGap(18, 18, 18)
                .addComponent(btnTablas)
                .addGap(18, 18, 18)
                .addComponent(btnGrafica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                .addComponent(btnConfiguracion)
                .addGap(16, 16, 16))
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnInsertarVentana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEventosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEventosActionPerformed
        establecerDimensionesPanelExterno(vE);
        insertarVentana(vE);
    }//GEN-LAST:event_btnEventosActionPerformed

    private void btnLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLibrosActionPerformed
        establecerDimensionesPanelExterno(vI);
        insertarVentana(vI);

    }//GEN-LAST:event_btnLibrosActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        establecerDimensionesPanelExterno(vU);
        insertarVentana(vU);
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnPrestamosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrestamosActionPerformed
        establecerDimensionesPanelExterno(vP);
        insertarVentana(vP);
    }//GEN-LAST:event_btnPrestamosActionPerformed

    private void btnMultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMultasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMultasActionPerformed

    private void btnTablasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTablasActionPerformed
        // TODO add your handling code here:
        establecerDimensionesPanelExterno(vT);
        insertarVentana(vT);
    }//GEN-LAST:event_btnTablasActionPerformed

    private void btnConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfiguracionActionPerformed
        // TODO add your handling code here:
        establecerDimensionesPanelExterno(vConfiguracion);
        insertarVentana(vConfiguracion);
    }//GEN-LAST:event_btnConfiguracionActionPerformed

    private void btnGraficaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraficaActionPerformed
       cargarGrafica();
    }//GEN-LAST:event_btnGraficaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    public void insertarVentana(JPanel panel) {
        panel.setSize(900, 480);
        panel.setLocation(0, 0); //establecido en el eje (0,0)
        pnInsertarVentana.removeAll();
        pnInsertarVentana.add(panel, BorderLayout.CENTER);
        pnInsertarVentana.revalidate();
        pnInsertarVentana.repaint();
    }

    public void establecerDimensionesPanelExterno(JPanel panel) {
        panel.setSize(900, 480);
        panel.setLocation(0, 0);
    }
    
    private void cargarGrafica() {
        dataset.setValue("Estudiante", Double.valueOf(10));
        dataset.setValue("Profesor", Double.valueOf(1));
        dataset.setValue("Externo", Double.valueOf(1));
        JFreeChart chart = ChartFactory.createPieChart("Distribución de usuarios", dataset, true, true, true);
        ChartFrame frame = new ChartFrame("Distribución de usuarios", chart);
        frame.pack();
        frame.setVisible(true);
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfiguracion;
    private javax.swing.JButton btnEventos;
    private javax.swing.JButton btnGrafica;
    private javax.swing.JButton btnLibros;
    private javax.swing.JButton btnMultas;
    private javax.swing.JButton btnPrestamos;
    private javax.swing.JButton btnTablas;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnInsertarVentana;
    // End of variables declaration//GEN-END:variables
}
