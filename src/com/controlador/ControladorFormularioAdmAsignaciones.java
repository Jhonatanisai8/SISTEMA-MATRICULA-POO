package com.controlador;

import com.procesos.ProcesosFormularioAdmAsignaciones;
import com.vista.frmAdministrarAsignacionesView;
import com.vista.frmMenuView;

public class ControladorFormularioAdmAsignaciones {
    
    private frmMenuView frmMenuView;
    private frmAdministrarAsignacionesView frmAdministrarAsignacionesView;
    
    public ControladorFormularioAdmAsignaciones(frmMenuView frmMenuView, frmAdministrarAsignacionesView frmAdministrarAsignacionesView) {
        this.frmMenuView = frmMenuView;
        this.frmAdministrarAsignacionesView = frmAdministrarAsignacionesView;
        ProcesosFormularioAdmAsignaciones.presentarFormulario(this.frmMenuView.dsktEscritorio, this.frmAdministrarAsignacionesView);
    }
    
}
