package com.controlador;

import com.Modelo.entidades.DaoImplementacion.EstudianteReposioImple;
import com.Modelo.entidades.Estudiante;
import com.Modelo.entidades.InterfaceDao.Repositorio;
import com.procesos.ProcesosFormularioRegistroEstudiante;
import com.procesos.Servicios.ServiciosEstudianteDocente;
import com.vista.frmMenuView;
import com.vista.frmRegistrarEstudianteView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

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

    //controlador para editar
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
        Repositorio<Estudiante> repositorio = new EstudianteReposioImple();  // Asegúrate que el nombre sea correcto.
        if (e.getSource() == this.frEstudiante.btnGuardar) {
            //si esta en guardar
            if (!frEstudiante.btnGuardar.getText().equalsIgnoreCase("Modificar")) {
                estudiante = ProcesosFormularioRegistroEstudiante.crearEstudiante(this.frEstudiante);
                if (estudiante != null) {
                    repositorio.guardar(estudiante);
                    ServiciosEstudianteDocente.limpiarDatos(frEstudiante);
                    System.out.println("Has dado click para guardar.....");
                    JOptionPane.showMessageDialog(null, "Estudiante con Nombre: " + estudiante.getNombre() + "\n guardado correctamente", "Atención", 3);
                } else {
                    JOptionPane.showMessageDialog(null, "No se puedo insertar el estudiante", "Atención", 3);
                }
            } else {//si esta en modificar
                Long id = this.estudianteMoficar.getIdEstudiante();
                Estudiante estudianteModificar = ProcesosFormularioRegistroEstudiante.crearEstudiante(this.frEstudiante);
                estudianteModificar.setIdEstudiante(id);  // O si usas otro ID, asignarlo aquí.
                repositorio.modificar(estudianteModificar);
                ServiciosEstudianteDocente.limpiarDatos(frEstudiante);
                JOptionPane.showMessageDialog(null, "Estudiante con Id: " + estudiante.getIdEstudiante() + "\n modifcado correctamente", "Atención", 3);
                System.out.println("Has dado click para modificar....");
            }
        }

    }

}
