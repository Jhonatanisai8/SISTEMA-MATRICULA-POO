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
        mnApoderados = new javax.swing.JMenu();
        jmnRegistroApoderados = new javax.swing.JMenuItem();
        jmnAdministrarApoderados = new javax.swing.JMenuItem();
        mnDocentes = new javax.swing.JMenu();
        jmnRegistrarDocente = new javax.swing.JMenuItem();
        jmnAdministrarDocentes = new javax.swing.JMenuItem();
        mnSalones = new javax.swing.JMenu();
        jmnAdmistrarSalones = new javax.swing.JMenuItem();
        mnCursos = new javax.swing.JMenu();
        jmnRegistrarCurso = new javax.swing.JMenuItem();
        jmnCursoProfesor = new javax.swing.JMenuItem();
        mnHorarios = new javax.swing.JMenu();
        jmnAdministrarHorarios = new javax.swing.JMenuItem();
        mnMatricula = new javax.swing.JMenu();
        jmnRegistrarAsignacion = new javax.swing.JMenuItem();
        jmnListarAsignaciones = new javax.swing.JMenuItem();
        mnListados = new javax.swing.JMenu();
        jmnRegistrarMatriculas = new javax.swing.JMenuItem();
        jmnAdministrarMatriculas = new javax.swing.JMenuItem();
        mnSalir = new javax.swing.JMenu();
        jmnCerrarSesion = new javax.swing.JMenuItem();

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

        mnApoderados.setText("Apoderados");

        jmnRegistroApoderados.setText("Registro de Apoderados");
        jmnRegistroApoderados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnRegistroApoderadosActionPerformed(evt);
            }
        });
        mnApoderados.add(jmnRegistroApoderados);

        jmnAdministrarApoderados.setText("Administrar Apoderados");
        mnApoderados.add(jmnAdministrarApoderados);

        menMenuPrincipal.add(mnApoderados);

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

        jmnCursoProfesor.setText("Curso Profesor");
        jmnCursoProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnCursoProfesorActionPerformed(evt);
            }
        });
        mnCursos.add(jmnCursoProfesor);

        menMenuPrincipal.add(mnCursos);

        mnHorarios.setText("Horarios");

        jmnAdministrarHorarios.setText("Administrar Horarios");
        jmnAdministrarHorarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnAdministrarHorariosActionPerformed(evt);
            }
        });
        mnHorarios.add(jmnAdministrarHorarios);

        menMenuPrincipal.add(mnHorarios);

        mnMatricula.setText("Asignaciones");

        jmnRegistrarAsignacion.setText("Registrar Asignacion");
        mnMatricula.add(jmnRegistrarAsignacion);

        jmnListarAsignaciones.setText("Administrar Asignaciones");
        mnMatricula.add(jmnListarAsignaciones);

        menMenuPrincipal.add(mnMatricula);

        mnListados.setText("Matriculas");

        jmnRegistrarMatriculas.setText("Registrar Matricula");
        mnListados.add(jmnRegistrarMatriculas);

        jmnAdministrarMatriculas.setText("Administrar Matriculas");
        jmnAdministrarMatriculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnAdministrarMatriculasActionPerformed(evt);
            }
        });
        mnListados.add(jmnAdministrarMatriculas);

        menMenuPrincipal.add(mnListados);

        mnSalir.setText("Salir");

        jmnCerrarSesion.setText("Cerrar Sesion");
        mnSalir.add(jmnCerrarSesion);

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

    private void jmnCursoProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnCursoProfesorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmnCursoProfesorActionPerformed

    private void jmnAdministrarHorariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnAdministrarHorariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmnAdministrarHorariosActionPerformed

    private void jmnAdministrarMatriculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnAdministrarMatriculasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmnAdministrarMatriculasActionPerformed

    private void jmnRegistroApoderadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnRegistroApoderadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmnRegistroApoderadosActionPerformed
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
    public javax.swing.JMenuItem jmnAdministrarApoderados;
    public javax.swing.JMenuItem jmnAdministrarDocentes;
    public javax.swing.JMenuItem jmnAdministrarEstudiantes;
    public javax.swing.JMenuItem jmnAdministrarHorarios;
    public javax.swing.JMenuItem jmnAdministrarMatriculas;
    public javax.swing.JMenuItem jmnAdmistrarSalones;
    public javax.swing.JMenuItem jmnCerrarSesion;
    public javax.swing.JMenuItem jmnCursoProfesor;
    public javax.swing.JMenu jmnInicio;
    public javax.swing.JMenuItem jmnListarAsignaciones;
    public javax.swing.JMenuItem jmnRegistrarAsignacion;
    public javax.swing.JMenuItem jmnRegistrarCurso;
    public javax.swing.JMenuItem jmnRegistrarDocente;
    public javax.swing.JMenuItem jmnRegistrarEstudiante;
    public javax.swing.JMenuItem jmnRegistrarMatriculas;
    public javax.swing.JMenuItem jmnRegistroApoderados;
    public javax.swing.JMenuItem jmnnInicio;
    public javax.swing.JMenuBar menMenuPrincipal;
    public javax.swing.JMenu mnApoderados;
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
