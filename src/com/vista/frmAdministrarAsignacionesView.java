package com.vista;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;

public class frmAdministrarAsignacionesView extends javax.swing.JInternalFrame {

    public frmAdministrarAsignacionesView() {
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

        pnlFondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 530, 230));
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

        pnlFondo.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 530, 230));

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

        pnlFondo.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 530, 200));

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

        pnlFondo.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 260, 530, 200));

        btnRegistrarAsignacion.setText("Registrar Asignacion");
        pnlFondo.add(btnRegistrarAsignacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 470, 200, 40));

        getContentPane().add(pnlFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    // End of variables declaration//GEN-END:variables
}
