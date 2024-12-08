package com.controlador;

import com.procesos.ProcesosFormularioVerInformacionMatricula;
import com.vista.frmMenuView;
import com.vista.frmVerInformacionMatriculaView;

public class ControladorFormularioVerInformacionMatricula {

    private final frmMenuView frmMenuView;
    private final frmVerInformacionMatriculaView frmInformacionMatriculaVie;

    public ControladorFormularioVerInformacionMatricula(frmMenuView frmMenuView, frmVerInformacionMatriculaView frmInformacionMatriculaVie) {
        this.frmMenuView = frmMenuView;
        this.frmInformacionMatriculaVie = frmInformacionMatriculaVie;
        ProcesosFormularioVerInformacionMatricula.presentarFormulario(this.frmMenuView.dsktEscritorio, this.frmInformacionMatriculaVie);
    }

}
