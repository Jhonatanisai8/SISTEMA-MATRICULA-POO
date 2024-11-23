package com.controlador;

import com.procesos.ProcesosFormularioRegistroEstudiante;
import com.vista.frmMenuView;
import com.vista.frmRegistrarEstudiante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorFormularioRegistroEstudiantes
        implements ActionListener {

    private final frmRegistrarEstudiante frEstudiante;
    private final frmMenuView frMenuView;

    public ControladorFormularioRegistroEstudiantes(frmMenuView menuView, frmRegistrarEstudiante frEstudiante) {
        this.frEstudiante = frEstudiante;
        this.frMenuView = menuView;
        this.frEstudiante.btnGuardar.addActionListener(this);
        ProcesosFormularioRegistroEstudiante.presentarFormulario(this.frMenuView.dsktEscritorio, frEstudiante);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.frEstudiante.btnGuardar) {
            System.out.println("Hola Mundo Boton");
        }
    }

}
