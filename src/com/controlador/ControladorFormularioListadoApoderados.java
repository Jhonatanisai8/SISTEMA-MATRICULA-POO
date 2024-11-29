package com.controlador;

import com.procesos.ProcesosFormularioListadoApoderados;
import com.vista.frmListadoApoderadosView;
import com.vista.frmMenuView;

public class ControladorFormularioListadoApoderados {

    private frmMenuView frmMenuView;
    private frmListadoApoderadosView frmListadoApoderadosView;
    
    public ControladorFormularioListadoApoderados(frmMenuView frmMenuView, frmListadoApoderadosView frmListadoApoderadosView) {
        this.frmMenuView = frmMenuView;
        this.frmListadoApoderadosView = frmListadoApoderadosView;
        ProcesosFormularioListadoApoderados.presentarFormulario(this.frmMenuView.dsktEscritorio, this.frmListadoApoderadosView);
    }
    
}
