package com.controlador;

import com.procesos.ProcesosFormularioListadoDocentes;
import com.procesos.Servicios.ServiciosDocente;
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
        this.lfrmistadoDocentesView.btnBuscar.addActionListener(this);
        ProcesosFormularioListadoDocentes.presentarFormulario(this.frmMenuView.dsktEscritorio, this.lfrmistadoDocentesView);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.lfrmistadoDocentesView.btnBuscar) {
            ProcesosFormularioListadoDocentes.mostarSoloDocente(lfrmistadoDocentesView,lfrmistadoDocentesView.txtBuscar.getText());
        }
    }

}
