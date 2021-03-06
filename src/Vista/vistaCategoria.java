/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador;
import Modelo.Producto;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author HP
 */
public class vistaCategoria extends javax.swing.JFrame {
    Controlador controlador;
    int categoria;
    ArrayList <Producto> productos;
    
    javax.swing.JFrame ventanaPadre;
    
    public vistaCategoria(Controlador C, int categoria, javax.swing.JFrame ventanaPadre) throws SQLException {
        this.ventanaPadre = ventanaPadre;
        this.controlador = C;
        this.categoria = categoria;
        initComponents();
        //productos = controlador.obtenerProductos(categoria);
        llenarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCategoria = new javax.swing.JTable();
        jButtonClose = new javax.swing.JButton();
        jButtonVerDetalle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre Producto", "Precio"
            }
        ));
        jScrollPane1.setViewportView(jTableCategoria);

        jButtonClose.setText("VOLVER");
        jButtonClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCloseMouseClicked(evt);
            }
        });

        jButtonVerDetalle.setText("VER DETALLE");
        jButtonVerDetalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonVerDetalleMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jButtonVerDetalle)
                .addGap(179, 179, 179)
                .addComponent(jButtonClose)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonVerDetalle)
                    .addComponent(jButtonClose))
                .addGap(62, 62, 62))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCloseMouseClicked
        setVisible(false); //you can't see me!
        dispose(); //Destroy the JFrame object
        this.ventanaPadre.setVisible(true);
    }//GEN-LAST:event_jButtonCloseMouseClicked

    private void jButtonVerDetalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonVerDetalleMouseClicked
        int index = jTableCategoria.getSelectedRow();
        TableModel table = jTableCategoria.getModel();
        
        String nombre = table.getValueAt(index, 0).toString();
        Double precio = Double.parseDouble(table.getValueAt(index,1).toString());
        
        new vistaVerDetalle(controlador,nombre,precio,this).setVisible(true);
        
    }//GEN-LAST:event_jButtonVerDetalleMouseClicked

    public void llenarTabla() throws SQLException{
        ArrayList<Producto> prod = controlador.obtenerProductoDeCategoria(categoria);
        DefaultTableModel model = (DefaultTableModel) jTableCategoria.getModel();
        Object rowData[] = new Object[3];
        
        for(int i=0; i<prod.size(); i++){
            rowData[0] = prod.get(i).getNombreProducto();
            rowData[1] = prod.get(i).getPrecioVenta();
            
            //owData[2] = (new JButton("Ver Detalle")).setActionCommand("verDetalle");
            model.addRow(rowData);
            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonVerDetalle;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCategoria;
    // End of variables declaration//GEN-END:variables
}
