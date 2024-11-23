package com.controlador;

import com.procesos.ProcesosFormularioListadoEstudiantes;
import com.vista.frmListadoEstudiantesView;
import com.vista.frmMenuView;

public class ControladorFormularioListadoEstudiantes {

    private final frmListadoEstudiantesView frmEstudiantesView;
    private final frmMenuView frmMenuView1;

    public ControladorFormularioListadoEstudiantes(frmListadoEstudiantesView frmEstudiantesView, frmMenuView frmMenuView1) {
        this.frmEstudiantesView = frmEstudiantesView;
        this.frmMenuView1 = frmMenuView1;
        ProcesosFormularioListadoEstudiantes.presentarFormulario(this.frmMenuView1.dsktEscritorio, this.frmEstudiantesView);
    }

}
