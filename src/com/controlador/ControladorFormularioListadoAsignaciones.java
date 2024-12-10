package com.controlador;

import com.procesos.ProcesosFormularioListadoAsignaciones;
import com.vista.frmListarAsignacionesView;
import com.vista.frmMenuView;

public class ControladorFormularioListadoAsignaciones {

    private final frmMenuView frmMenuView;
    private final frmListarAsignacionesView frmAsignacionesView;

    public ControladorFormularioListadoAsignaciones(frmMenuView frmMenuView, frmListarAsignacionesView frmAsignacionesView) {
        this.frmMenuView = frmMenuView;
        this.frmAsignacionesView = frmAsignacionesView;
        ProcesosFormularioListadoAsignaciones.presentarFormulario(this.frmMenuView.dsktEscritorio, this.frmAsignacionesView);
    }

}
