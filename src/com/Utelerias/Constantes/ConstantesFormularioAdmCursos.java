package com.Utelerias.Constantes;

import java.awt.Font;

public interface ConstantesFormularioAdmCursos {

    final String ENCABEZADO_COLUMNAS_TABLA[] = {"ID", "CODIGO", "NOMBRE", "DESCRIPCION", "GRADO", "NIVEL"};
    final int ANCH0_COLUMNAS[] = {5, 40, 50, 80, 5, 30};
    final Font FUENTE_TEXT_PRESENTACION = new Font("Segoe UI", Font.PLAIN, 12);
    final String[] LISTA_GRADOS = {"=SELECCIONAR=", "1", "2", "3", "4", "5", "6"};
    final String[] ENCABEZADOS_TABLA_CURSO = {"Docente", "Email Educativo", "Codigo Curso", "Nombre Curso", "Descripcion Curso", "Grado Curso", "Nivel Curso"};
    final int ANCHO_CURSO_PROFESOR[] = {150, 100, 75, 75, 150, 50, 50};
}
