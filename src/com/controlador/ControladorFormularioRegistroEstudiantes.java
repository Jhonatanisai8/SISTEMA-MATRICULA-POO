package com.controlador;

import com.procesos.ProcesosFormularioRegistroEstudiante;
import com.procesos.Validaciones.ValidacionesFrmRegistroEstudiante;
import com.vista.frmMenuView;
import com.vista.frmRegistrarEstudianteView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorFormularioRegistroEstudiantes
        implements ActionListener {

    private final frmRegistrarEstudianteView frEstudiante;
    private final frmMenuView frMenuView;

    public ControladorFormularioRegistroEstudiantes(frmMenuView menuView, frmRegistrarEstudianteView frEstudiante) {
        this.frEstudiante = frEstudiante;
        this.frMenuView = menuView;
        this.frEstudiante.btnGuardar.addActionListener(this);
        ProcesosFormularioRegistroEstudiante.presentarFormulario(this.frMenuView.dsktEscritorio, frEstudiante);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.frEstudiante.btnGuardar) {
            String validacion = ValidacionesFrmRegistroEstudiante.validarCamposFrmRegistroEstudiante(frEstudiante);
            if (!validacion.equals("")) {
                System.out.println("Observacion....");
                JOptionPane.showMessageDialog(null, "Revisar el campo " + validacion, "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
            } else {
                System.out.println("Hola Todo paso correctamente");
            }
        }
    }

}
