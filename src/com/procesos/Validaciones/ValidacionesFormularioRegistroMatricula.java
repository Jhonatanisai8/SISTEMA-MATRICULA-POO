package com.procesos.Validaciones;

import javax.swing.JTable;

public class ValidacionesFormularioRegistroMatricula {

    public static String validarFilasSelecionadas(JTable tblEstudiantes, JTable tblAsignaciones) {
        if (tblEstudiantes.getSelectedRow() < 0 && tblAsignaciones.getSelectedRow() < 0) {
            return " de Ambas Tablas.";
        }
        if (tblEstudiantes.getSelectedRow() < 0) {
            return " de Tabla de Estudiantes.";
        }
        if (tblAsignaciones.getSelectedRow() < 0) {
            return " de Tabla de Asignaciones.";
        }
        return "";
    }
}
