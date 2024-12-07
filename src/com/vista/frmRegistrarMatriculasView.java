package com.vista;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;

public class frmRegistrarMatriculasView extends javax.swing.JInternalFrame {

    public frmRegistrarMatriculasView() {
        FlatMaterialLighterIJTheme.setup();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEstudiantes = new javax.swing.JTable();
        lblTotalEstudiantes = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAsignaciones = new javax.swing.JTable();
        btnRegistrarMatricula = new javax.swing.JButton();
        txtBuscarEstdent = new javax.swing.JTextField();
        btnBuscarEstudent = new javax.swing.JButton();
        txtBuscarAsignacion = new javax.swing.JTextField();
        btnBuscarAsignacion = new javax.swing.JButton();

        setBackground(new java.awt.Color(254, 254, 254));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblEstudiantes);

        pnlFondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 350, 450));
        pnlFondo.add(lblTotalEstudiantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(1148, 480, 314, 44));

        tblAsignaciones.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblAsignaciones);

        pnlFondo.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 780, 400));

        btnRegistrarMatricula.setText("Grabar Matricula");
        pnlFondo.add(btnRegistrarMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 470, 240, 40));

        txtBuscarEstdent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarEstdentActionPerformed(evt);
            }
        });
        pnlFondo.add(txtBuscarEstdent, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, 40));

        btnBuscarEstudent.setText("Estudiante");
        pnlFondo.add(btnBuscarEstudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 140, 40));

        txtBuscarAsignacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarAsignacionActionPerformed(evt);
            }
        });
        pnlFondo.add(txtBuscarAsignacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 380, 40));

        btnBuscarAsignacion.setText("Asignacion");
        pnlFondo.add(btnBuscarAsignacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 10, 140, 40));

        getContentPane().add(pnlFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarEstdentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarEstdentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarEstdentActionPerformed

    private void txtBuscarAsignacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarAsignacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarAsignacionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBuscarAsignacion;
    public javax.swing.JButton btnBuscarEstudent;
    public javax.swing.JButton btnRegistrarMatricula;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTotalEstudiantes;
    private static javax.swing.JPanel pnlFondo;
    public javax.swing.JTable tblAsignaciones;
    public javax.swing.JTable tblEstudiantes;
    public javax.swing.JTextField txtBuscarAsignacion;
    public javax.swing.JTextField txtBuscarEstdent;
    // End of variables declaration//GEN-END:variables
}
