package com.procesos;

import com.vista.frmRegistrarMatriculasView;
import javax.swing.JDesktopPane;

public class ProcesosFormularioRegistroMatricula {
    
    static void ponerIconosFormulario(frmRegistrarMatriculasView frmRegistrarMatriculasView) {
        
    }
    
    public static void presentarFormulario(JDesktopPane escritorio, frmRegistrarMatriculasView frmRegistrarMatriculasView) {
        ponerIconosFormulario(frmRegistrarMatriculasView);
        escritorio.removeAll();
        escritorio.add(frmRegistrarMatriculasView);
        frmRegistrarMatriculasView.toFront();
        frmRegistrarMatriculasView.setTitle("REGISTRO DE MATRICULA.");
        frmRegistrarMatriculasView.setVisible(true);
    }
}
