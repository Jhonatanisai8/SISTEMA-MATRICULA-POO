package com.procesos;

import com.vista.frmListadoMatriculasView;
import javax.swing.JDesktopPane;

public class ProcesosFormularioListadoMatriculas {
    
    public static void presentarFormulario(JDesktopPane escritorio, frmListadoMatriculasView frmListadoMatriculasView) {
        escritorio.removeAll();
        escritorio.add(frmListadoMatriculasView);
        frmListadoMatriculasView.toFront();
        frmListadoMatriculasView.setTitle("Listado de Matriculas.");
        frmListadoMatriculasView.setVisible(true);
    }
}
