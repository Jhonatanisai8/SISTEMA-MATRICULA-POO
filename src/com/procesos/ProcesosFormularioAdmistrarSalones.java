package com.procesos;

import com.vista.frmAdmistrarSalonesView;
import javax.swing.JDesktopPane;

public class ProcesosFormularioAdmistrarSalones {

    public static void presentarFormulario(JDesktopPane desktopPane, frmAdmistrarSalonesView frmSalonesView) {
        frmSalonesView.setTitle("Administracion de Salones.");
        desktopPane.removeAll();
        desktopPane.add(frmSalonesView);
        frmSalonesView.toFront();
        frmSalonesView.setVisible(true);
    }
}
