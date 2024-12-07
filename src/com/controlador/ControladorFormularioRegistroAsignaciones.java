package com.controlador;

import com.Modelo.entidades.Asignacion;
import com.Modelo.entidades.DaoImplementacion.AsignacionRepoImple;
import com.procesos.ProcesosFormularioRegistroAsignaciones;
import com.procesos.Validaciones.ValidacionesFormularioRegistrarAsignacion;
import com.vista.frmRegistrarAsignacionesView;
import com.vista.frmMenuView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorFormularioRegistroAsignaciones
        implements ActionListener {

    private final frmMenuView frmMenuView;
    private final frmRegistrarAsignacionesView frmAdministrarAsignacionesView;
    private Asignacion asignacion;

    public ControladorFormularioRegistroAsignaciones(frmMenuView frmMenuView, frmRegistrarAsignacionesView frmAdministrarAsignacionesView) {
        this.frmMenuView = frmMenuView;
        this.frmAdministrarAsignacionesView = frmAdministrarAsignacionesView;
        this.frmAdministrarAsignacionesView.btnBuscarCurso.addActionListener(this);
        this.frmAdministrarAsignacionesView.btnBuscarDocente.addActionListener(this);
        this.frmAdministrarAsignacionesView.btnBuscarHorarios.addActionListener(this);
        this.frmAdministrarAsignacionesView.btnBuscarSalones.addActionListener(this);
        this.frmAdministrarAsignacionesView.btnRegistrarAsignacion.addActionListener(this);
        ProcesosFormularioRegistroAsignaciones.presentarFormulario(this.frmMenuView.dsktEscritorio, this.frmAdministrarAsignacionesView);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AsignacionRepoImple asignacionRepoImple = new AsignacionRepoImple();
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
            String validacion = ValidacionesFormularioRegistrarAsignacion.validarSeleccionFilaTablas(frmAdministrarAsignacionesView.tblCursos, frmAdministrarAsignacionesView.tblDocentes, frmAdministrarAsignacionesView.tblHorarios, frmAdministrarAsignacionesView.tblSalones);
            if (!validacion.equals("")) {
                System.out.println("Selecionar Fila " + validacion);
                JOptionPane.showMessageDialog(null, "Seleccionar una fila de " + validacion, "ATENCION", JOptionPane.WARNING_MESSAGE);
                return;
            } else {
                asignacion = ProcesosFormularioRegistroAsignaciones.crearAsignacionDesdeFormulario(this.frmAdministrarAsignacionesView);
                asignacionRepoImple.guardar(asignacion);
                JOptionPane.showMessageDialog(null, "Asignacion Registrada Corectamente", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
                ProcesosFormularioRegistroAsignaciones.presentarFormulario(this.frmMenuView.dsktEscritorio, this.frmAdministrarAsignacionesView);
            }
            System.out.println("Click sobre el boton Registrar Asigacion....");
        }

    }

}
