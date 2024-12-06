package com.vista;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;

public class frmRegistrarAsignacionesView extends javax.swing.JInternalFrame {

    public frmRegistrarAsignacionesView() {
        FlatMaterialLighterIJTheme.setup();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDocentes = new javax.swing.JTable();
        lblTotalEstudiantes = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCursos = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSalones = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblHorarios = new javax.swing.JTable();
        btnRegistrarAsignacion = new javax.swing.JButton();
        txtBuscarDocente = new javax.swing.JTextField();
        btnBuscarDocente = new javax.swing.JButton();
        txtBuscarCursos = new javax.swing.JTextField();
        btnBuscarCurso = new javax.swing.JButton();
        txtBuscarSalon = new javax.swing.JTextField();
        btnBuscarSalones = new javax.swing.JButton();
        txtBuscarHorarios = new javax.swing.JTextField();
        btnBuscarHorarios = new javax.swing.JButton();

        setBackground(new java.awt.Color(254, 254, 254));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDocentes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblDocentes);

        pnlFondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 530, 150));
        pnlFondo.add(lblTotalEstudiantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(1148, 480, 314, 44));

        tblCursos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblCursos);

        pnlFondo.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, 530, 150));

        tblSalones.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblSalones);

        pnlFondo.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 530, 240));

        tblHorarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tblHorarios);

        pnlFondo.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 290, 530, 170));

        btnRegistrarAsignacion.setText("Registrar Asignacion");
        pnlFondo.add(btnRegistrarAsignacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 470, 240, 40));

        txtBuscarDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarDocenteActionPerformed(evt);
            }
        });
        pnlFondo.add(txtBuscarDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 380, 40));

        btnBuscarDocente.setText("Docente");
        pnlFondo.add(btnBuscarDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 140, 40));

        txtBuscarCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarCursosActionPerformed(evt);
            }
        });
        pnlFondo.add(txtBuscarCursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 380, 40));

        btnBuscarCurso.setText("Curso");
        pnlFondo.add(btnBuscarCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 10, 140, 40));

        txtBuscarSalon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarSalonActionPerformed(evt);
            }
        });
        pnlFondo.add(txtBuscarSalon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 380, 40));

        btnBuscarSalones.setText("Salones");
        pnlFondo.add(btnBuscarSalones, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 140, 40));

        txtBuscarHorarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarHorariosActionPerformed(evt);
            }
        });
        pnlFondo.add(txtBuscarHorarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 240, 380, 40));

        btnBuscarHorarios.setText("Horarios");
        pnlFondo.add(btnBuscarHorarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 240, 140, 40));

        getContentPane().add(pnlFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarDocenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarDocenteActionPerformed

    private void txtBuscarCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarCursosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarCursosActionPerformed

    private void txtBuscarSalonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarSalonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarSalonActionPerformed

    private void txtBuscarHorariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarHorariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarHorariosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBuscarCurso;
    public javax.swing.JButton btnBuscarDocente;
    public javax.swing.JButton btnBuscarHorarios;
    public javax.swing.JButton btnBuscarSalones;
    public javax.swing.JButton btnRegistrarAsignacion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblTotalEstudiantes;
    private static javax.swing.JPanel pnlFondo;
    public javax.swing.JTable tblCursos;
    public javax.swing.JTable tblDocentes;
    public javax.swing.JTable tblHorarios;
    public javax.swing.JTable tblSalones;
    public javax.swing.JTextField txtBuscarCursos;
    public javax.swing.JTextField txtBuscarDocente;
    public javax.swing.JTextField txtBuscarHorarios;
    public javax.swing.JTextField txtBuscarSalon;
    // End of variables declaration//GEN-END:variables
}
