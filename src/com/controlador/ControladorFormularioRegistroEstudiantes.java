package com.controlador;

import com.Modelo.entidades.DaoImplementacion.EstudianteReposioImple;
import com.Modelo.entidades.Estudiante;
import com.Modelo.entidades.InterfaceDao.Repositorio;
import com.procesos.ProcesosFormularioRegistroEstudiante;
import com.procesos.Servicios.ServiciosEstudianteDocente;
import com.vista.frmMenuView;
import com.vista.frmRegistrarApoderadoView;
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
        this.frEstudiante.btnRegistrarApoderado.addActionListener(this);
        ProcesosFormularioRegistroEstudiante.presentarFormulario(this.frMenuView.dsktEscritorio, frEstudiante);
    }

    //controlador para editar
    public ControladorFormularioRegistroEstudiantes(frmMenuView menuView, frmRegistrarEstudianteView frEstudiante, Estudiante estudianteMOd) {
        this.frEstudiante = frEstudiante;
        this.frMenuView = menuView;
        this.estudianteMoficar = estudianteMOd;
        this.frEstudiante.btnGuardar.addActionListener(this);
        this.frEstudiante.btnRegistrarApoderado.addActionListener(this);
        this.frEstudiante.btnGuardar.setText("Modificar");
        ProcesosFormularioRegistroEstudiante.presentarFormulario(this.frMenuView.dsktEscritorio, this.frEstudiante, this.estudianteMoficar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Repositorio<Estudiante> repositorio = new EstudianteReposioImple();  // Asegúrate que el nombre sea correcto.
        if (e.getSource() == this.frEstudiante.btnGuardar) {
            int fila = this.frEstudiante.tblApoderados.getSelectedRow();
            //si esta en guardar
            if (!frEstudiante.btnGuardar.getText().equalsIgnoreCase("Modificar")) {
                if (fila >= 0) {
                    estudiante = ProcesosFormularioRegistroEstudiante.crearEstudiante(this.frEstudiante, fila);
                    if (estudiante != null) {
                        repositorio.guardar(estudiante);
                        ServiciosEstudianteDocente.limpiarDatos(frEstudiante);
                        System.out.println("Has dado click para guardar.....");
                        JOptionPane.showMessageDialog(null, "Estudiante con Nombre: " + estudiante.getNombre() + "\n guardado correctamente", "Atención", 3);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se puedo insertar el estudiante", "Atención", 3);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor seleccinar una fila del apoderado.", "Atención", 3);
                }
            } else {//si esta en modificar
                Long id = this.estudianteMoficar.getIdEstudiante();
                Estudiante estudianteModificar = ProcesosFormularioRegistroEstudiante.crearEstudiante(this.frEstudiante, fila);
                estudianteModificar.setIdEstudiante(id);  // O si usas otro ID, asignarlo aquí.
                repositorio.modificar(estudianteModificar);
                JOptionPane.showMessageDialog(null, "Estudiante con Id: " + estudianteModificar.getIdEstudiante() + "\n modifcado correctamente", "Atención", 3);
                ServiciosEstudianteDocente.limpiarDatos(frEstudiante);
                System.out.println("Has dado click para modificar....");
            }
        }

        //para digirse al formulario de regisi apoderado
        if (e.getSource() == this.frEstudiante.btnRegistrarApoderado) {
            frmRegistrarApoderadoView frmRegistrarApoderadoView = new frmRegistrarApoderadoView();
            this.frEstudiante.dispose();
            ControladorFormularioRegistroApoderado cfra = new ControladorFormularioRegistroApoderado(frmRegistrarApoderadoView, this.frMenuView);
            System.out.println("Click para registrar un apoderado......");
        }

    }

}
