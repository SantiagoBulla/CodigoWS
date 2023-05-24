/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;


import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modeloDAO.EmpleadoDAO;
import modeloVO.EmpleadoVO;

/**
 *
 * @author 57305
 */
public class GestionUsuarios extends javax.swing.JFrame {
    private String id="",firstName="", lastName="",phone="",isAdmin="",userName="",password="";
    EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    EmpleadoVO empleadoVO = new EmpleadoVO();
    ArrayList<EmpleadoVO> lista = new EmpleadoDAO().mostrarEmpleados();
    /**
     * Creates new form GestionUsuarios
     */
    public GestionUsuarios() {
        initComponents();
        this.mostrarLista();
    }
    
    public void mostrarLista(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("id");
        modelo.addColumn("FirstName");
        modelo.addColumn("LastName");
        modelo.addColumn("Phone");
        modelo.addColumn("IsAdmin");
        modelo.addColumn("Username");
        modelo.addColumn("Password");
        //asignar modelo 
        jTable_empleados.setModel(modelo);
        //vector de datos 
        String[] vector =  new String[7];
        try {
            for(int i=0; i<lista.size(); i++){
                empleadoVO = lista.get(i);
                vector[0] = empleadoVO.getId();
                vector[1] = empleadoVO.getFirstName();
                vector[2] = empleadoVO.getLastName();
                vector[3] = empleadoVO.getPhone();
                vector[4] = empleadoVO.getIsAdmin();
                vector[5] = empleadoVO.getUserName();
                vector[6] = empleadoVO.getPassword();
                modelo.addRow(vector);
            }
        } catch (Exception e) {
            System.out.println("Error en mostrar lista de datos "+e);
        }
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_empleados = new javax.swing.JTable();
        jButton_add = new javax.swing.JButton();
        jButton_modify = new javax.swing.JButton();
        jButton_back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Employee Admin");
        setMinimumSize(new java.awt.Dimension(700, 500));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jTable_empleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable_empleados);

        jButton_add.setText("Add");
        jButton_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_addActionPerformed(evt);
            }
        });

        jButton_modify.setText("Modify");
        jButton_modify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_modifyActionPerformed(evt);
            }
        });

        jButton_back.setBackground(new java.awt.Color(0, 204, 0));
        jButton_back.setText("Back");
        jButton_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_add)
                .addGap(49, 49, 49)
                .addComponent(jButton_modify)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton_back)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton_back)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_add)
                    .addComponent(jButton_modify))
                .addContainerGap(111, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 700, 500);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_addActionPerformed
        AgregarEmpleado pantalla = new AgregarEmpleado();
        pantalla.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton_addActionPerformed

    private void jButton_modifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_modifyActionPerformed
        ModificarEmpleado pantalla = new ModificarEmpleado();
        pantalla.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton_modifyActionPerformed

    private void jButton_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_backActionPerformed
        MenuAdmin pantalla = new MenuAdmin();
        pantalla.setVisible(true);
        this.dispose();  
    }//GEN-LAST:event_jButton_backActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_add;
    private javax.swing.JButton jButton_back;
    private javax.swing.JButton jButton_modify;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_empleados;
    // End of variables declaration//GEN-END:variables
}
