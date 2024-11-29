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
        menMenuPrincipal = new javax.swing.JMenuBar();
        jmnInicio = new javax.swing.JMenu();
        jmnnInicio = new javax.swing.JMenuItem();
        mnEstudiantes = new javax.swing.JMenu();
        jmnRegistrarEstudiante = new javax.swing.JMenuItem();
        jmnAdministrarEstudiantes = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jmnRegistroApoderados = new javax.swing.JMenuItem();
        mnDocentes = new javax.swing.JMenu();
        jmnRegistrarDocente = new javax.swing.JMenuItem();
        jmnAdministrarDocentes = new javax.swing.JMenuItem();
        mnSalones = new javax.swing.JMenu();
        jmnAdmistrarSalones = new javax.swing.JMenuItem();
        mnCursos = new javax.swing.JMenu();
        jmnRegistrarCurso = new javax.swing.JMenuItem();
        jmnAdministrarCursos = new javax.swing.JMenuItem();
        mnHorarios = new javax.swing.JMenu();
        jmnAsignarHorario = new javax.swing.JMenuItem();
        jmnAdministrarHorarios = new javax.swing.JMenuItem();
        mnMatricula = new javax.swing.JMenu();
        jmnRegistrarMatricula = new javax.swing.JMenuItem();
        jmnAdministrarMatriculas = new javax.swing.JMenuItem();
        mnListados = new javax.swing.JMenu();
        jmnEstudiantesMatriculados = new javax.swing.JMenuItem();
        jmnDocentesAsignados = new javax.swing.JMenuItem();
        mnSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout dsktEscritorioLayout = new javax.swing.GroupLayout(dsktEscritorio);
        dsktEscritorio.setLayout(dsktEscritorioLayout);
        dsktEscritorioLayout.setHorizontalGroup(
            dsktEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1190, Short.MAX_VALUE)
        );
        dsktEscritorioLayout.setVerticalGroup(
            dsktEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 572, Short.MAX_VALUE)
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

        jmnInicio.setText("Inicio");
        jmnInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmnInicioMouseClicked(evt);
            }
        });
        jmnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnInicioActionPerformed(evt);
            }
        });

        jmnnInicio.setText("Inicio");
        jmnInicio.add(jmnnInicio);

        menMenuPrincipal.add(jmnInicio);

        mnEstudiantes.setText("Estudiantes");

        jmnRegistrarEstudiante.setText("Registrar Estudiante");
        mnEstudiantes.add(jmnRegistrarEstudiante);

        jmnAdministrarEstudiantes.setText("Administrar Estudiante");
        jmnAdministrarEstudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnAdministrarEstudiantesActionPerformed(evt);
            }
        });
        mnEstudiantes.add(jmnAdministrarEstudiantes);

        menMenuPrincipal.add(mnEstudiantes);

        jMenu1.setText("Apoderados");

        jmnRegistroApoderados.setText("Registro de Apoderados");
        jMenu1.add(jmnRegistroApoderados);

        menMenuPrincipal.add(jMenu1);

        mnDocentes.setText("Docentes");

        jmnRegistrarDocente.setText("Registrar Docente");
        mnDocentes.add(jmnRegistrarDocente);

        jmnAdministrarDocentes.setText("Administrar Docentes");
        mnDocentes.add(jmnAdministrarDocentes);

        menMenuPrincipal.add(mnDocentes);

        mnSalones.setText("Salones");

        jmnAdmistrarSalones.setText("Adminstrar Salones");
        mnSalones.add(jmnAdmistrarSalones);

        menMenuPrincipal.add(mnSalones);

        mnCursos.setText("Cursos");

        jmnRegistrarCurso.setText("Registrar Curso");
        mnCursos.add(jmnRegistrarCurso);

        jmnAdministrarCursos.setText("Administrar Cursos");
        jmnAdministrarCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnAdministrarCursosActionPerformed(evt);
            }
        });
        mnCursos.add(jmnAdministrarCursos);

        menMenuPrincipal.add(mnCursos);

        mnHorarios.setText("Horarios");

        jmnAsignarHorario.setText("Asignar Horario");
        mnHorarios.add(jmnAsignarHorario);

        jmnAdministrarHorarios.setText("Administrar Horarios");
        jmnAdministrarHorarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnAdministrarHorariosActionPerformed(evt);
            }
        });
        mnHorarios.add(jmnAdministrarHorarios);

        menMenuPrincipal.add(mnHorarios);

        mnMatricula.setText("Matrícula");

        jmnRegistrarMatricula.setText("Matricular Estudiante");
        mnMatricula.add(jmnRegistrarMatricula);

        jmnAdministrarMatriculas.setText("Administrar Matriculas");
        mnMatricula.add(jmnAdministrarMatriculas);

        menMenuPrincipal.add(mnMatricula);

        mnListados.setText("Listados");

        jmnEstudiantesMatriculados.setText("Estufiantes Matriculados");
        mnListados.add(jmnEstudiantesMatriculados);

        jmnDocentesAsignados.setText("Docentes Asignados");
        jmnDocentesAsignados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnDocentesAsignadosActionPerformed(evt);
            }
        });
        mnListados.add(jmnDocentesAsignados);

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

    private void jmnInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmnInicioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jmnInicioMouseClicked

    private void jmnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmnInicioActionPerformed

    private void jmnAdministrarEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnAdministrarEstudiantesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmnAdministrarEstudiantesActionPerformed

    private void jmnAdministrarCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnAdministrarCursosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmnAdministrarCursosActionPerformed

    private void jmnAdministrarHorariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnAdministrarHorariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmnAdministrarHorariosActionPerformed

    private void jmnDocentesAsignadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnDocentesAsignadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmnDocentesAsignadosActionPerformed
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
    public javax.swing.JMenu jMenu1;
    public javax.swing.JMenuItem jmnAdministrarCursos;
    public javax.swing.JMenuItem jmnAdministrarDocentes;
    public javax.swing.JMenuItem jmnAdministrarEstudiantes;
    public javax.swing.JMenuItem jmnAdministrarHorarios;
    public javax.swing.JMenuItem jmnAdministrarMatriculas;
    public javax.swing.JMenuItem jmnAdmistrarSalones;
    public javax.swing.JMenuItem jmnAsignarHorario;
    public javax.swing.JMenuItem jmnDocentesAsignados;
    public javax.swing.JMenuItem jmnEstudiantesMatriculados;
    public javax.swing.JMenu jmnInicio;
    public javax.swing.JMenuItem jmnRegistrarCurso;
    public javax.swing.JMenuItem jmnRegistrarDocente;
    public javax.swing.JMenuItem jmnRegistrarEstudiante;
    public javax.swing.JMenuItem jmnRegistrarMatricula;
    public javax.swing.JMenuItem jmnRegistroApoderados;
    public javax.swing.JMenuItem jmnnInicio;
    public javax.swing.JMenuBar menMenuPrincipal;
    public javax.swing.JMenu mnCursos;
    public javax.swing.JMenu mnDocentes;
    public javax.swing.JMenu mnEstudiantes;
    public javax.swing.JMenu mnHorarios;
    public javax.swing.JMenu mnListados;
    public javax.swing.JMenu mnMatricula;
    public javax.swing.JMenu mnSalir;
    public javax.swing.JMenu mnSalones;
    public javax.swing.JPanel pnlBackgroundMenu;
    // End of variables declaration//GEN-END:variables
}
