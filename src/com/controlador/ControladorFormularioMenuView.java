package com.controlador;

import com.procesos.ProcesosFrmMenuView;
import com.vista.frmMenuView;

public class ControladorFormularioMenuView {
    
    private frmMenuView menuView;
    
    public ControladorFormularioMenuView(frmMenuView menuView) {
        this.menuView = menuView;
        ProcesosFrmMenuView.presentarFormularioMenu(menuView);
    }
    
}
