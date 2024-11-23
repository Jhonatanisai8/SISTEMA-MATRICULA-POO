package com.procesos;

import com.Utelerias.Constantes.ConstantesFormularioListadoEstudiantes;
import com.vista.frmListadoEstudiantesView;
import javax.swing.JDesktopPane;

public class ProcesosFormularioListadoEstudiantes
        implements ConstantesFormularioListadoEstudiantes {

    private static void ponerIconosFormulario(frmListadoEstudiantesView frmEstudiantesView) {
        frmEstudiantesView.btnBuscar.setIcon(ICONO_BUSCAR);
        frmEstudiantesView.btnModificar.setIcon(ICONO_MODIFICAR);
        frmEstudiantesView.btnEliminar.setIcon(ICONO_ELIMINAR);

    }

    public static void presentarFormulario(JDesktopPane desktopPane, frmListadoEstudiantesView frmEstudiantesView) {
        ponerIconosFormulario(frmEstudiantesView);
        frmEstudiantesView.setTitle("Listado de Estudiantes");
        desktopPane.add(frmEstudiantesView);
        frmEstudiantesView.toFront();
        frmEstudiantesView.setVisible(true);
    }
}
