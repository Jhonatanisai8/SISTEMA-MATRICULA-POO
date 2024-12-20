package com.Utelerias.Constantes;

public interface ConstantesFormulariosMatricula {

    final String COLUMNAS_TABLA_ESTUDIANTES[] = {
        "ID",
        "NOMBRES Y APELLIDOS",
        "COD.",};
    final int TAMANIO_COLUMNAS[] = {30, 170, 60};

    final String ENCABEZADOS_TABLA_ASIGNACIONES[] = {
        "ID",
        "ID DOCENTE",
        "DOCENTE",
        "CURSO",
        "GRADO",
        "SALON",
        "REFERENCIA",
        "VACANTES DISPONIBLES",
        "DIA  SEMANA",
        "HORA INICIO",
        "HORA FIN",
        "TURNO"
    };
    final int ANCHO_COLUMAS[] = {40, 40, 150, 100, 40, 100, 100, 50, 100, 70, 70, 50};

    final String[] ENCABEZADOS_TABLA_MATRICULA = {
        "ID",
        "ID EST",
        "ESTUDIANTE",
        "EMAIL ESTUDIANTE",
        "DOCENTE",
        "SALON",
        "HORARIO",
        "FECHA MATRICULA"
    };

    final int ANCHO_COLUMNAS_TABLA_MATRICULAS[] = {25, 25, 150, 100, 150, 20, 100, 70};
}
