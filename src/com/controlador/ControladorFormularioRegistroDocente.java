package com.controlador;

import com.procesos.ProcesosFormularioRegistroDocente;
import com.vista.frmMenuView;
import com.vista.frmRegistrarDocenteView;

public class ControladorFormularioRegistroDocente {

    private frmRegistrarDocenteView frmRegistrarDocenteView;
    private frmMenuView frmMenuView;

    public ControladorFormularioRegistroDocente(frmRegistrarDocenteView frmRegistrarDocenteView, frmMenuView frmMenuView) {
        this.frmRegistrarDocenteView = frmRegistrarDocenteView;
        this.frmMenuView = frmMenuView;
        ProcesosFormularioRegistroDocente.presentarFormulario(this.frmMenuView.dsktEscritorio, this.frmRegistrarDocenteView);
    }

}
