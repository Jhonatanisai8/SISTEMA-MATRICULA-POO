package com.procesos;

import com.Modelo.entidades.DaoImplementacion.MatriculaRepoImple;
import com.vista.frmVerInformacionMatriculaView;
import javax.swing.JDesktopPane;

public class ProcesosFormularioVerInformacionMatricula {
    
    public static void presentarFormulario(JDesktopPane desktopPane, frmVerInformacionMatriculaView frmInformacionMatriculaVie, Long id) {
        MatriculaRepoImple imple = new MatriculaRepoImple();
        desktopPane.removeAll();
        desktopPane.add(frmInformacionMatriculaVie);
        frmInformacionMatriculaVie.toFront();
        frmInformacionMatriculaVie.setTitle("INFORMACION DE LA MATRICULA: ");
        frmInformacionMatriculaVie.setVisible(true);
        String texto = imple.verHorario(id);
        frmInformacionMatriculaVie.txtInformacion.setText(texto);
    }
}
