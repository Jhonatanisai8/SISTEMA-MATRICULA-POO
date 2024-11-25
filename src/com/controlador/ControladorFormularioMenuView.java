package com.controlador;

import com.procesos.ProcesosFormularioMenuView;
import com.vista.frmInicioView;
import com.vista.frmListadoDocentesView;
import com.vista.frmListadoEstudiantesView;
import com.vista.frmMenuView;
import com.vista.frmRegistrarDocenteView;
import com.vista.frmRegistrarEstudianteView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorFormularioMenuView
        implements ActionListener {

    private final frmMenuView frmenuView;

    public ControladorFormularioMenuView(frmMenuView menuView) {
        this.frmenuView = menuView;
        this.frmenuView.mnInicio.addActionListener(this);
        this.frmenuView.jmnRegistrarEstudiante.addActionListener(this);
        this.frmenuView.jmnAdministrarEstudiantes.addActionListener(this);
        this.frmenuView.jmnRegistrarDocente.addActionListener(this);
        this.frmenuView.jmnAdministrarDocentes.addActionListener(this);
        ProcesosFormularioMenuView.presentarFormulario(this.frmenuView);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.frmenuView.mnInicio) {
            frmInicioView frInicioView = new frmInicioView();
            System.out.println("Holaaa");
            // pasamos el frmMenuView existente al ControladorFormularioInicio
            ControladorFormularioInicio cfi = new ControladorFormularioInicio(frInicioView, frmenuView);
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
    }
}
