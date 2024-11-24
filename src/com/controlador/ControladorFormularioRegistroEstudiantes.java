package com.controlador;

import com.Modelo.entidades.DaoImplementacion.EstudianteReposioImple;
import com.Modelo.entidades.Estudiante;
import com.Modelo.entidades.InterfaceDao.Repositorio;
import com.procesos.ProcesosFormularioRegistroEstudiante;
import com.vista.frmMenuView;
import com.vista.frmRegistrarEstudianteView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorFormularioRegistroEstudiantes
        implements ActionListener {

    private final frmRegistrarEstudianteView frEstudiante;
    private final frmMenuView frMenuView;
    private Estudiante estudiante;

    public ControladorFormularioRegistroEstudiantes(frmMenuView menuView, frmRegistrarEstudianteView frEstudiante) {
        this.frEstudiante = frEstudiante;
        this.frMenuView = menuView;
        this.frEstudiante.btnGuardar.addActionListener(this);
        ProcesosFormularioRegistroEstudiante.presentarFormulario(this.frMenuView.dsktEscritorio, frEstudiante);
    }

    public ControladorFormularioRegistroEstudiantes(frmMenuView menuView, frmRegistrarEstudianteView frEstudiante, Estudiante estudiante) {
        this.frEstudiante = frEstudiante;
        this.frMenuView = menuView;
        this.frEstudiante.btnGuardar.addActionListener(this);
        ProcesosFormularioRegistroEstudiante.presentarFormulario(this.frMenuView.dsktEscritorio, frEstudiante,estudiante);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.frEstudiante.btnGuardar) {
            Repositorio<Estudiante> repositorio = new EstudianteReposioImple();
            estudiante = ProcesosFormularioRegistroEstudiante.crearEstudiante(this.frEstudiante);
            repositorio.guardar(estudiante);
            System.out.println("Estudiante guardado con exito.. ");
        }
    }

}
