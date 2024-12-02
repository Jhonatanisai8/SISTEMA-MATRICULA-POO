package com.procesos;

import com.vista.frmAdministrarAsignacionesView;
import javax.swing.JDesktopPane;

public class ProcesosFormularioAdmAsignaciones {

    public static void presentarFormulario(JDesktopPane desktopPane, frmAdministrarAsignacionesView frmAdministrarAsignacionesView) {
        desktopPane.removeAll();
        desktopPane.add(frmAdministrarAsignacionesView);
        frmAdministrarAsignacionesView.setTitle("Registro de asignaciones".toUpperCase());
        frmAdministrarAsignacionesView.toFront();
        frmAdministrarAsignacionesView.setVisible(true);
        System.out.println("Haciendo visible el registor de asiganaciones....");
    }
}
