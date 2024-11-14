package com.vista;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;

public class frmMenuView extends javax.swing.JFrame {

    public frmMenuView() {
        FlatMaterialLighterIJTheme.setup();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackgroundMenu = new javax.swing.JPanel();
        dsktEscritorio = new javax.swing.JDesktopPane();
        lblAdministrador = new javax.swing.JLabel();
        menMenuPrincipal = new javax.swing.JMenuBar();
        mnInicio = new javax.swing.JMenu();
        mnEstudiantes = new javax.swing.JMenu();
        mnDocentes = new javax.swing.JMenu();
        mnSalones = new javax.swing.JMenu();
        mnCursos = new javax.swing.JMenu();
        mnHorarios = new javax.swing.JMenu();
        mnMatricula = new javax.swing.JMenu();
        mnListados = new javax.swing.JMenu();
        mnSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dsktEscritorio.setLayer(lblAdministrador, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout dsktEscritorioLayout = new javax.swing.GroupLayout(dsktEscritorio);
        dsktEscritorio.setLayout(dsktEscritorioLayout);
        dsktEscritorioLayout.setHorizontalGroup(
            dsktEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dsktEscritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(802, Short.MAX_VALUE))
        );
        dsktEscritorioLayout.setVerticalGroup(
            dsktEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dsktEscritorioLayout.createSequentialGroup()
                .addContainerGap(450, Short.MAX_VALUE)
                .addComponent(lblAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlBackgroundMenuLayout = new javax.swing.GroupLayout(pnlBackgroundMenu);
        pnlBackgroundMenu.setLayout(pnlBackgroundMenuLayout);
        pnlBackgroundMenuLayout.setHorizontalGroup(
            pnlBackgroundMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dsktEscritorio)
        );
        pnlBackgroundMenuLayout.setVerticalGroup(
            pnlBackgroundMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dsktEscritorio)
        );

        mnInicio.setText("Inicio");
        menMenuPrincipal.add(mnInicio);

        mnEstudiantes.setText("Estudiantes");
        menMenuPrincipal.add(mnEstudiantes);

        mnDocentes.setText("Docentes");
        menMenuPrincipal.add(mnDocentes);

        mnSalones.setText("Salones");
        menMenuPrincipal.add(mnSalones);

        mnCursos.setText("Cursos");
        menMenuPrincipal.add(mnCursos);

        mnHorarios.setText("Horarios");
        menMenuPrincipal.add(mnHorarios);

        mnMatricula.setText("Matrícula");
        menMenuPrincipal.add(mnMatricula);

        mnListados.setText("Listados");
        menMenuPrincipal.add(mnListados);

        mnSalir.setText("Salir");
        menMenuPrincipal.add(mnSalir);

        setJMenuBar(menMenuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackgroundMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackgroundMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public static void main(String args[]) {
        FlatMaterialLighterIJTheme.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMenuView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JDesktopPane dsktEscritorio;
    public javax.swing.JLabel lblAdministrador;
    public javax.swing.JMenuBar menMenuPrincipal;
    public javax.swing.JMenu mnCursos;
    public javax.swing.JMenu mnDocentes;
    public javax.swing.JMenu mnEstudiantes;
    public javax.swing.JMenu mnHorarios;
    public javax.swing.JMenu mnInicio;
    public javax.swing.JMenu mnListados;
    public javax.swing.JMenu mnMatricula;
    public javax.swing.JMenu mnSalir;
    public javax.swing.JMenu mnSalones;
    public javax.swing.JPanel pnlBackgroundMenu;
    // End of variables declaration//GEN-END:variables
}
