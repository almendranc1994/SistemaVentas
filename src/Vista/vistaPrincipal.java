/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelo.Cliente;

/**
 *
 * @author HP
 */
public class vistaPrincipal extends javax.swing.JFrame {
    
    Controlador controlador;
    javax.swing.JFrame ventanaPadre;
    
    public vistaPrincipal(Controlador C, javax.swing.JFrame ventanaPadre) {
        this.ventanaPadre = ventanaPadre;
        this.controlador = C;
        initComponents();
        Cliente cliente = this.controlador.getClienteActual();
        jLabel1.setText(cliente.getNombre() + " " + cliente.getApellidoPaterno() + " " + cliente.getApellidoMaterno());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonChompas = new javax.swing.JButton();
        jButtonZapatos = new javax.swing.JButton();
        jButtonAbrigos = new javax.swing.JButton();
        jButtonCasacas = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jButtonCarritoCompras = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jButtonChompas.setText("CHOMPAS");
        jButtonChompas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonChompasMouseClicked(evt);
            }
        });
        jButtonChompas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChompasActionPerformed(evt);
            }
        });

        jButtonZapatos.setText("ZAPATOS");
        jButtonZapatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonZapatosMouseClicked(evt);
            }
        });

        jButtonAbrigos.setText("ABRIGOS");
        jButtonAbrigos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAbrigosMouseClicked(evt);
            }
        });

        jButtonCasacas.setText("CASACAS");
        jButtonCasacas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCasacasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonChompas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonZapatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAbrigos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCasacas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jButtonChompas)
                .addGap(36, 36, 36)
                .addComponent(jButtonZapatos)
                .addGap(34, 34, 34)
                .addComponent(jButtonAbrigos)
                .addGap(29, 29, 29)
                .addComponent(jButtonCasacas)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        jButtonCarritoCompras.setText("Carrito de Compras");
        jButtonCarritoCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCarritoComprasActionPerformed(evt);
            }
        });

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addComponent(jButtonCarritoCompras)
                        .addGap(41, 41, 41)
                        .addComponent(jButtonSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(436, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalir)
                    .addComponent(jButtonCarritoCompras)
                    .addComponent(jLabel1))
                .addGap(16, 16, 16)
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonChompasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonChompasMouseClicked
        this.setVisible(false);
        try {  
            new vistaCategoria(controlador,1,this).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(vistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButtonChompasMouseClicked

    private void jButtonChompasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChompasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonChompasActionPerformed


    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        dispose();
        this.ventanaPadre.setVisible(true);
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonCarritoComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCarritoComprasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCarritoComprasActionPerformed

    private void jButtonZapatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonZapatosMouseClicked
        this.setVisible(false);
        try {  
            new vistaCategoria(controlador,2,this).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(vistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonZapatosMouseClicked

    private void jButtonAbrigosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAbrigosMouseClicked
        this.setVisible(false);
        try {  
            new vistaCategoria(controlador,3,this).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(vistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonAbrigosMouseClicked

    private void jButtonCasacasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCasacasMouseClicked
        this.setVisible(false);
        try {  
            new vistaCategoria(controlador,4,this).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(vistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonCasacasMouseClicked

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAbrigos;
    private javax.swing.JButton jButtonCarritoCompras;
    private javax.swing.JButton jButtonCasacas;
    private javax.swing.JButton jButtonChompas;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JButton jButtonZapatos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
