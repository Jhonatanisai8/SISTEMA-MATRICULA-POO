package com.controlador;

import com.procesos.ProcesosFormularioListadoApoderados;
import com.vista.frmListadoApoderadosView;
import com.vista.frmMenuView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorFormularioListadoApoderados
        implements ActionListener {
    
    private frmMenuView frmMenuView;
    private frmListadoApoderadosView frmListadoApoderadosView;
    
    public ControladorFormularioListadoApoderados(frmMenuView frmMenuView, frmListadoApoderadosView frmListadoApoderadosView) {
        this.frmMenuView = frmMenuView;
        this.frmListadoApoderadosView = frmListadoApoderadosView;
        this.frmListadoApoderadosView.btnEliminar.addActionListener(this);
        ProcesosFormularioListadoApoderados.presentarFormulario(this.frmMenuView.dsktEscritorio, this.frmListadoApoderadosView);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //boton eliminar
        if (e.getSource() == this.frmListadoApoderadosView.btnEliminar) {
            ProcesosFormularioListadoApoderados.seleccionarDatosEliminar(this.frmListadoApoderadosView);
            System.out.println("Click en el boton eliminar.....");
        }
    }
    
}
