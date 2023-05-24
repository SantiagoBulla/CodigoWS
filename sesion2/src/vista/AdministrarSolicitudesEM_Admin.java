/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.table.DefaultTableModel;
import modeloDAO.MantenimientoEmergenciaDAO;
import modeloVO.MantenimientosEmergenciaVO;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 57305
 */
public class AdministrarSolicitudesEM_Admin extends javax.swing.JFrame {

    private String AssetSN = "", AssetName = "", EMReportDate = "", EmployeeFullaName = "", DepartmentName = "";
    MantenimientosEmergenciaVO emVO = new MantenimientosEmergenciaVO();
    MantenimientoEmergenciaDAO emDAO = new MantenimientoEmergenciaDAO();
    ArrayList<MantenimientosEmergenciaVO> lista = new MantenimientoEmergenciaDAO().mostrarEM();
    ArrayList<MantenimientosEmergenciaVO> listaFiltro = new MantenimientoEmergenciaDAO().mostrarEMFiltro();

    /**
     * Creates new form AdministrarSolicitudesEM_Admin
     */
    public AdministrarSolicitudesEM_Admin() {
        initComponents();
        this.mostrarDatos();
        this.mostrarDatosFiltro();
    }

    public void mostrarDatos() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Asset Name");
        model.addColumn("Asset SN");
        model.addColumn("EMReportDate");
        model.addColumn("EmployeeFullName");
        model.addColumn("DepartmentName");
        jTable_EMM.setModel(model);
        String[] vector = new String[5];
        try {
            for (int i = 0; i < lista.size(); i++) {
                emVO = lista.get(i);
                vector[0] = emVO.getAssetName();
                vector[1] = emVO.getAssetSN();
                vector[2] = emVO.getEMReportDate();
                vector[3] = emVO.getEmployeeFullaName();
                vector[4] = emVO.getDepartmentName();
                model.addRow(vector);
            }
        } catch (Exception e) {
            Logger.getLogger(AdministrarSolicitudesEM_Admin.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void mostrarDatosFiltro() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Asset Name");
        model.addColumn("Asset SN");
        model.addColumn("EMReportDate");
        model.addColumn("EmployeeFullName");
        model.addColumn("DepartmentName");
        jTable_Filtro.setModel(model);
        String[] vector = new String[5];
        try {
            for (int i = 0; i < listaFiltro.size(); i++) {
                emVO = listaFiltro.get(i);
                vector[0] = emVO.getAssetName();
                vector[1] = emVO.getAssetSN();
                vector[2] = emVO.getEMReportDate();
                vector[3] = emVO.getEmployeeFullaName();
                vector[4] = emVO.getDepartmentName();
                model.addRow(vector);
            }
        } catch (Exception e) {
            Logger.getLogger(AdministrarSolicitudesEM_Admin.class.getName()).log(Level.SEVERE, null, e);
        }
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_EMM = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Filtro = new javax.swing.JTable();
        jButton_ManageRequest = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 500));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jTable_EMM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "dios mio", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable_EMM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_EMMMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_EMM);

        jDesktopPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Emergency Maintenance Managment All", jDesktopPane1);

        jTable_Filtro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "hola", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable_Filtro);

        jTabbedPane1.addTab("Emergency  Maintenances Open ", jScrollPane1);

        jButton_ManageRequest.setText("Manage Request");
        jButton_ManageRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ManageRequestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_ManageRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_ManageRequest)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ManageRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ManageRequestActionPerformed
        int seleccion = jTable_Filtro.getSelectedRow();
        int sizeFila = jTable_Filtro.getColumnCount();
        int seleccion2 = jTable_EMM.getSelectedRow();
        int sizeFila2 = jTable_EMM.getColumnCount();

    }//GEN-LAST:event_jButton_ManageRequestActionPerformed

    private void jTable_EMMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_EMMMouseClicked
        int assetSeleccionado = jTable_EMM.rowAtPoint(evt.getPoint());
        this.AssetName = String.valueOf(jTable_EMM.getValueAt(assetSeleccionado, 0));
        
    }//GEN-LAST:event_jTable_EMMMouseClicked

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
            java.util.logging.Logger.getLogger(EMRQ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EMRQ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EMRQ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EMRQ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AdministrarSolicitudesEM_Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_ManageRequest;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable_EMM;
    private javax.swing.JTable jTable_Filtro;
    // End of variables declaration//GEN-END:variables
}