package com.procesos.Validaciones;

import javax.swing.JTable;

public class ValidacionesFormularioRegistrarAsignacion {

    public static String validarSeleccionFilaTablas(
            JTable tblCursos, JTable tblDocentes, JTable tblHorarios, JTable tblSalones
    ) {
        if (tblDocentes.getSelectedRow() < 0) {
            return " de Tabla de Docentes.";
        }
        if (tblCursos.getSelectedRow() < 0) {
            return " de Tabla de Cursos.";
        }
        if (tblSalones.getSelectedRow() < 0) {
            return " de Tabla de Salones.";
        }
        if (tblHorarios.getSelectedRow() < 0) {
            return " de Tabla de Horarios.";
        }
        if (tblCursos.getSelectedRow() < 0
                && tblDocentes.getSelectedRow() < 0
                && tblHorarios.getSelectedRow() < 0
                && tblSalones.getSelectedRow() < 0) {
            return "Por favor selccionar Fila de Docente, Horarios, Salones, Cursos.";
        }
        return "";
    }
}
