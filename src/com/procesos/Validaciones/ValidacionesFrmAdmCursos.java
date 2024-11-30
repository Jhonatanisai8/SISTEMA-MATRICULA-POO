package com.procesos.Validaciones;

import com.vista.frmAdmistrarCursos;

public class ValidacionesFrmAdmCursos {

    public static String validarCampos(frmAdmistrarCursos frmAdmistrarCursos) {
        if (frmAdmistrarCursos.txtNombreCurso.getText().isBlank()
                || frmAdmistrarCursos.txtNombreCurso.getText().length() > 50) {
            return "Nombre del Curso.";
        }

        if (frmAdmistrarCursos.txtDiscripcion.getText().isBlank()) {
            return "Descripcion.";
        }

        if (frmAdmistrarCursos.cbxGrado.getSelectedIndex() == 0) {
            return "Grado";
        }
        return "";
    }
}
