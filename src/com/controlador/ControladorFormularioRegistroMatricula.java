package com.controlador;

import com.procesos.ProcesosFormularioRegistroMatricula;
import com.vista.frmMenuView;
import com.vista.frmRegistrarMatriculasView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorFormularioRegistroMatricula
        implements ActionListener {
    
    private frmMenuView frmMenuView;
    private frmRegistrarMatriculasView frmRegistrarMatriculasView;
    
    public ControladorFormularioRegistroMatricula(frmMenuView frmMenuView, frmRegistrarMatriculasView frmRegistrarMatriculasView) {
        this.frmMenuView = frmMenuView;
        this.frmRegistrarMatriculasView = frmRegistrarMatriculasView;
        this.frmRegistrarMatriculasView.btnBuscarAsignacion.addActionListener(this);
        this.frmRegistrarMatriculasView.btnBuscarEstudent.addActionListener(this);
        this.frmRegistrarMatriculasView.btnRegistrarMatricula.addActionListener(this);
        ProcesosFormularioRegistroMatricula.presentarFormulario(this.frmMenuView.dsktEscritorio, this.frmRegistrarMatriculasView);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
