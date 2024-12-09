package com.controlador;

import com.procesos.ProcesosFormularioCursoProfesor;
import com.vista.frmCursoProfesorView;
import com.vista.frmMenuView;

public class ControladorFormularioCursoProfesor {

    private final frmMenuView frmMenuView;
    private final frmCursoProfesorView frmCursoProfesorView;

    public ControladorFormularioCursoProfesor(frmMenuView frmMenuView, frmCursoProfesorView frmCursoProfesorView) {
        this.frmMenuView = frmMenuView;
        this.frmCursoProfesorView = frmCursoProfesorView;
        ProcesosFormularioCursoProfesor.presentarFormulario(this.frmMenuView.dsktEscritorio, this.frmCursoProfesorView);
    }

}
