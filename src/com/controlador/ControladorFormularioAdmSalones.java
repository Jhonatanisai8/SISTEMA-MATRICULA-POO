package com.controlador;

import com.procesos.ProcesosFormularioAdmistrarSalones;
import com.vista.frmAdmistrarSalonesView;
import com.vista.frmMenuView;

public class ControladorFormularioAdmSalones {

    private final frmMenuView frmMenuView;
    private final frmAdmistrarSalonesView frmAdmistrarSalonesView;
    
    public ControladorFormularioAdmSalones(frmMenuView frmMenuView, frmAdmistrarSalonesView frmAdmistrarSalonesView) {
        this.frmMenuView = frmMenuView;
        this.frmAdmistrarSalonesView = frmAdmistrarSalonesView;
        ProcesosFormularioAdmistrarSalones.presentarFormulario(this.frmMenuView.dsktEscritorio, this.frmAdmistrarSalonesView);
    }
    
}
