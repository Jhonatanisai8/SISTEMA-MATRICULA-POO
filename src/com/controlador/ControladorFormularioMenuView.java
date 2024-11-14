package com.controlador;

import com.procesos.ProcesosFrmMenuView;
import com.vista.frmInicioView;
import com.vista.frmMenuView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorFormularioMenuView implements ActionListener {

    private frmMenuView frmenuView;

    public ControladorFormularioMenuView(frmMenuView menuView) {
        this.frmenuView = menuView;
        this.frmenuView.mnInicio.addActionListener(this);
        ProcesosFrmMenuView.presentarFormularioMenu(this.frmenuView);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.frmenuView.mnInicio) {
            frmInicioView frInicioView = new frmInicioView();
            System.out.println("Holaaa");
            // pasamos el frmMenuView existente al ControladorFormularioInicio
            ControladorFormularioInicio cfi = new ControladorFormularioInicio(frInicioView, frmenuView);
        }
    }
}
