package com.controlador;

import com.procesos.ProcesosFormularioMenuView;
import com.vista.frmRegistrarAsignacionesView;
import com.vista.frmAdmistrarCursos;
import com.vista.frmAdmistrarHorariosView;
import com.vista.frmAdmistrarSalonesView;
import com.vista.frmInicioSesionView;
import com.vista.frmInicioView;
import com.vista.frmListadoApoderadosView;
import com.vista.frmListadoDocentesView;
import com.vista.frmListadoEstudiantesView;
import com.vista.frmListadoMatriculasView;
import com.vista.frmMenuView;
import com.vista.frmRegistrarApoderadoView;
import com.vista.frmRegistrarDocenteView;
import com.vista.frmRegistrarEstudianteView;
import com.vista.frmRegistrarMatriculasView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorFormularioMenuView
        implements ActionListener {

    private final frmMenuView frmenuView;

    public ControladorFormularioMenuView(frmMenuView menuView) {
        this.frmenuView = menuView;
        this.frmenuView.jmnInicio.addActionListener(this);
        this.frmenuView.jmnnInicio.addActionListener(this);
        this.frmenuView.jmnRegistrarEstudiante.addActionListener(this);
        this.frmenuView.jmnAdministrarEstudiantes.addActionListener(this);
        this.frmenuView.jmnRegistrarDocente.addActionListener(this);
        this.frmenuView.jmnAdministrarDocentes.addActionListener(this);
        this.frmenuView.jmnAdmistrarSalones.addActionListener(this);
        this.frmenuView.jmnRegistroApoderados.addActionListener(this);
        this.frmenuView.jmnAdministrarApoderados.addActionListener(this);
        this.frmenuView.jmnCerrarSesion.addActionListener(this);
        this.frmenuView.jmnRegistrarCurso.addActionListener(this);
        this.frmenuView.jmnAdministrarHorarios.addActionListener(this);
        this.frmenuView.jmnRegistrarAsignacion.addActionListener(this);
        this.frmenuView.jmnRegistrarMatriculas.addActionListener(this);
        this.frmenuView.jmnAdministrarMatriculas.addActionListener(this);
        ProcesosFormularioMenuView.presentarFormulario(this.frmenuView);
        System.out.println("Mostrando el Menu del sistema...");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.frmenuView.jmnInicio) {
            frmInicioView frInicioView = new frmInicioView();
            // pasamos el frmMenuView existente al ControladorFormularioInicio
            ControladorFormularioInicio cfi = new ControladorFormularioInicio(frInicioView, frmenuView);
        }

        if (e.getSource() == this.frmenuView.jmnnInicio) {
            frmInicioView frInicioView = new frmInicioView();
            // pasamos el frmMenuView existente al ControladorFormularioInicio
            ControladorFormularioInicio cfi = new ControladorFormularioInicio(frInicioView, frmenuView);
            System.out.println("Click sobre el menu de incio");
        }

        if (e.getSource() == this.frmenuView.jmnRegistrarEstudiante) {
            System.out.println("Evento del Jmenu del registro de estudiantes");
            frmRegistrarEstudianteView frEstudiante = new frmRegistrarEstudianteView();
            ControladorFormularioRegistroEstudiantes cfre = new ControladorFormularioRegistroEstudiantes(this.frmenuView, frEstudiante);
        }

        if (e.getSource() == this.frmenuView.jmnAdministrarEstudiantes) {
            System.out.println("Evento del Jmenu  de estudiantes en marcha....");
            frmListadoEstudiantesView frmEstudiantesView = new frmListadoEstudiantesView();
            ControladorFormularioListadoEstudiantes cfle = new ControladorFormularioListadoEstudiantes(frmEstudiantesView, this.frmenuView);
        }
        if (e.getSource() == this.frmenuView.jmnRegistrarDocente) {
            frmRegistrarDocenteView frmDocenteView = new frmRegistrarDocenteView();
            ControladorFormularioRegistroDocente cfrd = new ControladorFormularioRegistroDocente(frmDocenteView, this.frmenuView);
            System.out.println("Evento del Jmenu de registrar docentes...");
        }
        if (e.getSource() == this.frmenuView.jmnAdministrarDocentes) {
            frmListadoDocentesView frmListadoDocentesView = new frmListadoDocentesView();
            ControladorFormularioListadoDocentes cfld = new ControladorFormularioListadoDocentes(frmListadoDocentesView, this.frmenuView);
            System.out.println("Evento del Jmenu de administrar docentes...");
        }
        if (e.getSource() == this.frmenuView.jmnAdmistrarSalones) {
            frmAdmistrarSalonesView frmAdmistrarSalonesView = new frmAdmistrarSalonesView();
            ControladorFormularioAdmSalones admSalones = new ControladorFormularioAdmSalones(this.frmenuView, frmAdmistrarSalonesView);
        }

        if (e.getSource() == this.frmenuView.jmnRegistroApoderados) {
            frmRegistrarApoderadoView frmApoderadoView = new frmRegistrarApoderadoView();
            ControladorFormularioRegistroApoderado apoderado = new ControladorFormularioRegistroApoderado(frmApoderadoView, this.frmenuView);
            System.out.println("Click sobre el Jmenu de registrar Apoderados");
        }
        if (e.getSource() == this.frmenuView.jmnAdministrarApoderados) {
            frmListadoApoderadosView frmListadoApoderadosView = new frmListadoApoderadosView();
            ControladorFormularioListadoApoderados apoderados = new ControladorFormularioListadoApoderados(frmenuView, frmListadoApoderadosView);
            System.out.println("Click sobre el Jmenu Admisnitrar Apoderados.");
        }

        if (e.getSource() == this.frmenuView.jmnCerrarSesion) {
            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea Salir de Sistema.?", "Atención", JOptionPane.INFORMATION_MESSAGE);
            if (opcion == 0) {
                this.frmenuView.dispose();
                frmInicioSesionView frmInicioSesionView = new frmInicioSesionView();
                ControladorInicioSesion cis = new ControladorInicioSesion(frmInicioSesionView);
            }
            System.out.println("Click sobre el jMenu de cerrar sesion.....");
        }
        if (e.getSource() == this.frmenuView.jmnRegistrarCurso) {
            frmAdmistrarCursos frmAdmistrarCursos = new frmAdmistrarCursos();
            ControladorFormularioAdmCursos admCursos = new ControladorFormularioAdmCursos(this.frmenuView, frmAdmistrarCursos);

            System.out.println("Click sobre el jMenu de registrar Horario....");
        }

        if (e.getSource() == this.frmenuView.jmnAdministrarHorarios) {
            frmAdmistrarHorariosView frmAdmistrarHorariosView = new frmAdmistrarHorariosView();
            ControladorFormularioAdmHorarios cfah = new ControladorFormularioAdmHorarios(this.frmenuView, frmAdmistrarHorariosView);
            System.out.println("click sobre el jMenu de Administrar Horarios..");
        }

        if (e.getSource() == this.frmenuView.jmnRegistrarAsignacion) {
            frmRegistrarAsignacionesView frmAdministrarAsignacionesVie = new frmRegistrarAsignacionesView();
            ControladorFormularioRegistroAsignaciones admAsignaciones = new ControladorFormularioRegistroAsignaciones(this.frmenuView, frmAdministrarAsignacionesVie);
            System.out.println("Click sobre el JMenu de Registrar Asignacion");
        }

        if (e.getSource() == this.frmenuView.jmnRegistrarMatriculas) {
            frmRegistrarMatriculasView frmMatriculasView = new frmRegistrarMatriculasView();
            ControladorFormularioRegistroMatricula cfrm = new ControladorFormularioRegistroMatricula(this.frmenuView, frmMatriculasView);
            System.out.println("Click sobre el JMenu de Registrar Matriculas");
        }

        if (e.getSource() == this.frmenuView.jmnAdministrarMatriculas) {
            frmListadoMatriculasView frmListadoMatriculasView = new frmListadoMatriculasView();
            ControladorFormularioListadoMatriculas cflm = new ControladorFormularioListadoMatriculas(this.frmenuView, frmListadoMatriculasView);
            System.out.println("Click sobre el JMenu de Administrar Matriculas");
        }

    }
}
