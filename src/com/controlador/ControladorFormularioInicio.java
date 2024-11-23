package com.controlador;

import com.procesos.ProcesosFormularioInicio;
import com.vista.frmInicioView;
import com.vista.frmMenuView;

public class ControladorFormularioInicio {

    private final frmInicioView frInicioView;
    private final frmMenuView frMenuView;

    public ControladorFormularioInicio(frmInicioView frInicioView, frmMenuView frMenuView) {
        this.frInicioView = frInicioView;
        this.frMenuView = frMenuView;
        ProcesosFormularioInicio.presentarFormulario(this.frMenuView.dsktEscritorio, this.frInicioView);
    }
}
