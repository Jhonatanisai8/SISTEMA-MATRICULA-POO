package com.controlador;

import com.procesos.ProcesosFormularioMenuView;
import com.vista.frmInicioView;
import com.vista.frmMenuView;
import com.vista.frmRegistrarEstudiante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorFormularioMenuView
        implements ActionListener {

    private final frmMenuView frmenuView;

    public ControladorFormularioMenuView(frmMenuView menuView) {
        this.frmenuView = menuView;
        this.frmenuView.mnInicio.addActionListener(this);
        this.frmenuView.jmnRegistrarEstudiante.addActionListener(this);
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
            System.out.println("Hola Mundo Jmenu");
            frmRegistrarEstudiante frEstudiante = new frmRegistrarEstudiante();
            ControladorFormularioRegistroEstudiantes cfre = new ControladorFormularioRegistroEstudiantes(this.frmenuView, frEstudiante);
        }
    }
}
