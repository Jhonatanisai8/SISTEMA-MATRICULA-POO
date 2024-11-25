package com.controlador;

import com.Modelo.entidades.DaoImplementacion.EstudianteReposioImple;
import com.Modelo.entidades.Estudiante;
import com.Modelo.entidades.InterfaceDao.Repositorio;
import com.procesos.ProcesosFormularioRegistroEstudiante;
import com.procesos.Servicios.ServiciosEstudiante;
import com.vista.frmMenuView;
import com.vista.frmRegistrarEstudianteView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorFormularioRegistroEstudiantes
        implements ActionListener {

    private final frmRegistrarEstudianteView frEstudiante;
    private final frmMenuView frMenuView;
    private Estudiante estudiante;
    private Estudiante estudianteMoficar;

    public ControladorFormularioRegistroEstudiantes(frmMenuView menuView, frmRegistrarEstudianteView frEstudiante) {
        this.frEstudiante = frEstudiante;
        this.frMenuView = menuView;
        this.frEstudiante.btnGuardar.addActionListener(this);
        ProcesosFormularioRegistroEstudiante.presentarFormulario(this.frMenuView.dsktEscritorio, frEstudiante);
    }

    public ControladorFormularioRegistroEstudiantes(frmMenuView menuView, frmRegistrarEstudianteView frEstudiante, Estudiante estudianteMOd) {
        this.frEstudiante = frEstudiante;
        this.frMenuView = menuView;
        this.estudianteMoficar = estudianteMOd;
        this.frEstudiante.btnGuardar.addActionListener(this);
        this.frEstudiante.btnGuardar.setText("Modificar");
        ProcesosFormularioRegistroEstudiante.presentarFormulario(this.frMenuView.dsktEscritorio, this.frEstudiante, this.estudianteMoficar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.frEstudiante.btnGuardar) {
            Repositorio<Estudiante> repositorio = new EstudianteReposioImple();  // Asegúrate que el nombre sea correcto.
            if (!frEstudiante.btnGuardar.getText().equalsIgnoreCase("Modificar")) {
                estudiante = ProcesosFormularioRegistroEstudiante.crearEstudiante(this.frEstudiante);
                repositorio.guardar(estudiante);
                ServiciosEstudiante.limpiarDatos(frEstudiante);
                System.out.println("Has dado click para guardar.....");
            } else {
                Long id = this.estudianteMoficar.getIdEstudiante();
                Estudiante estudianteModificar = ProcesosFormularioRegistroEstudiante.crearEstudiante(this.frEstudiante);
                estudianteModificar.setIdEstudiante(id);  // O si usas otro ID, asignarlo aquí.
                repositorio.modificar(estudianteModificar);
                ServiciosEstudiante.limpiarDatos(frEstudiante);
                System.out.println("Has dado click para modificar....");
            }
        }

    }

}
