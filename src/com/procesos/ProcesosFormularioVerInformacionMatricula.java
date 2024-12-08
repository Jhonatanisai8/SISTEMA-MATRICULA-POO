package com.procesos;

import com.vista.frmVerInformacionMatriculaView;
import javax.swing.JDesktopPane;

public class ProcesosFormularioVerInformacionMatricula {
    
    public static void presentarFormulario(JDesktopPane desktopPane, frmVerInformacionMatriculaView frmInformacionMatriculaVie) {
        desktopPane.removeAll();
        desktopPane.add(frmInformacionMatriculaVie);
        frmInformacionMatriculaVie.toFront();
        frmInformacionMatriculaVie.setTitle("INFORMACION DE LA MATRICULA: ");
        frmInformacionMatriculaVie.setVisible(true);
    }
}
