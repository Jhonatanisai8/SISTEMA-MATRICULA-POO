package com.controlador;

import com.procesos.ProcesosFormularioListadoMatriculas;
import com.vista.frmListadoMatriculasView;
import com.vista.frmMenuView;

public class ControladorFormularioListadoMatriculas {

    private final frmMenuView frmMenuView;
    private final frmListadoMatriculasView frmListadoMatriculasView;

    public ControladorFormularioListadoMatriculas(frmMenuView frmMenuView, frmListadoMatriculasView frmListadoMatriculasView) {
        this.frmMenuView = frmMenuView;
        this.frmListadoMatriculasView = frmListadoMatriculasView;
        ProcesosFormularioListadoMatriculas.presentarFormulario(this.frmMenuView.dsktEscritorio, this.frmListadoMatriculasView);
    }

}
