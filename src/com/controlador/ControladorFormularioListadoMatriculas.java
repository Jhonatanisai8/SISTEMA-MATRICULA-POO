package com.controlador;

import com.procesos.ProcesosFormularioListadoMatriculas;
import com.vista.frmListadoMatriculasView;
import com.vista.frmMenuView;
import com.vista.frmVerInformacionMatriculaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorFormularioListadoMatriculas
        implements ActionListener {

    private final frmMenuView frmMenuView;
    private final frmListadoMatriculasView frmListadoMatriculasView;

    public ControladorFormularioListadoMatriculas(frmMenuView frmMenuView, frmListadoMatriculasView frmListadoMatriculasView) {
        this.frmMenuView = frmMenuView;
        this.frmListadoMatriculasView = frmListadoMatriculasView;
        this.frmListadoMatriculasView.btnVerInformacionCompleta.addActionListener(this);
        this.frmListadoMatriculasView.btnBuscarMatricula.addActionListener(this);
        ProcesosFormularioListadoMatriculas.presentarFormulario(this.frmMenuView.dsktEscritorio, this.frmListadoMatriculasView);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.frmListadoMatriculasView.btnVerInformacionCompleta) {
            frmVerInformacionMatriculaView informacionMatriculaView = new frmVerInformacionMatriculaView();
            ControladorFormularioVerInformacionMatricula cfvim = new ControladorFormularioVerInformacionMatricula(this.frmMenuView, informacionMatriculaView);
            System.out.println("Click sobre el boton de ver informacion completa...");
        }
    }

}
