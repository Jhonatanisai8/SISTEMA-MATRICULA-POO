package com.controlador;

import com.procesos.ProcesosFormularioListadoDocentes;
import com.vista.frmListadoDocentesView;
import com.vista.frmMenuView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorFormularioListadoDocentes
        implements ActionListener {
    
    private frmListadoDocentesView lfrmistadoDocentesView;
    private frmMenuView frmMenuView;
    
    public ControladorFormularioListadoDocentes(frmListadoDocentesView lfrmistadoDocentesView, frmMenuView frmMenuView) {
        this.lfrmistadoDocentesView = lfrmistadoDocentesView;
        this.frmMenuView = frmMenuView;
        ProcesosFormularioListadoDocentes.presentarFormulario(this.frmMenuView.dsktEscritorio, this.lfrmistadoDocentesView);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
