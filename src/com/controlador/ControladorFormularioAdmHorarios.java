package com.controlador;

import com.procesos.ProcesosFormularioAdmHorarios;
import com.vista.frmAdmistrarHorariosView;
import com.vista.frmMenuView;

public class ControladorFormularioAdmHorarios {
    
    private final frmMenuView frmMenuView;
    private final frmAdmistrarHorariosView frmAdmistrarHorariosView;
    
    public ControladorFormularioAdmHorarios(frmMenuView frmMenuView, frmAdmistrarHorariosView frmAdmistrarHorariosView) {
        this.frmMenuView = frmMenuView;
        this.frmAdmistrarHorariosView = frmAdmistrarHorariosView;
        ProcesosFormularioAdmHorarios.presentarFormulario(this.frmMenuView.dsktEscritorio, this.frmAdmistrarHorariosView);
    }
    
}
