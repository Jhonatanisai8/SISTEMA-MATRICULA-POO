package com.controlador;

import com.procesos.ProcesosFormularioAdmAsignaciones;
import com.vista.frmAdministrarAsignacionesView;
import com.vista.frmMenuView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorFormularioAdmAsignaciones
        implements ActionListener {

    private final frmMenuView frmMenuView;
    private final frmAdministrarAsignacionesView frmAdministrarAsignacionesView;

    public ControladorFormularioAdmAsignaciones(frmMenuView frmMenuView, frmAdministrarAsignacionesView frmAdministrarAsignacionesView) {
        this.frmMenuView = frmMenuView;
        this.frmAdministrarAsignacionesView = frmAdministrarAsignacionesView;

        this.frmAdministrarAsignacionesView.btnBuscarCurso.addActionListener(this);
        this.frmAdministrarAsignacionesView.btnBuscarDocente.addActionListener(this);
        this.frmAdministrarAsignacionesView.btnBuscarHorarios.addActionListener(this);
        this.frmAdministrarAsignacionesView.btnBuscarSalones.addActionListener(this);
        this.frmAdministrarAsignacionesView.btnRegistrarAsignacion.addActionListener(this);

        ProcesosFormularioAdmAsignaciones.presentarFormulario(this.frmMenuView.dsktEscritorio, this.frmAdministrarAsignacionesView);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.frmAdministrarAsignacionesView.btnBuscarCurso) {
            System.out.println("Click sobre el boton Buscar Curso....");

        }
        if (e.getSource() == this.frmAdministrarAsignacionesView.btnBuscarDocente) {
            System.out.println("Click sobre el boton Buscar Docente....");
        }
        if (e.getSource() == this.frmAdministrarAsignacionesView.btnBuscarHorarios) {
            System.out.println("Click sobre el boton Buscar Horario....");
        }
        if (e.getSource() == this.frmAdministrarAsignacionesView.btnBuscarSalones) {
            System.out.println("Click sobre el boton Buscar Salon....");
        }
        if (e.getSource() == this.frmAdministrarAsignacionesView.btnRegistrarAsignacion) {
            System.out.println("Click sobre el boton Registrar Asigacion....");
        }

    }

}
