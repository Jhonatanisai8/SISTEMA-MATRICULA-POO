package com.procesos;

import com.vista.frmCursoProfesorView;
import javax.swing.JDesktopPane;

public class ProcesosFormularioCursoProfesor {

    public static void presentarFormulario(JDesktopPane desktopPane, frmCursoProfesorView frmCursoProfesorView) {
        desktopPane.removeAll();
        desktopPane.add(frmCursoProfesorView);
        frmCursoProfesorView.setTitle("Listado de Cursos Asociados Con Profesores.");
        frmCursoProfesorView.toFront();
        frmCursoProfesorView.setVisible(true);
    }
}
