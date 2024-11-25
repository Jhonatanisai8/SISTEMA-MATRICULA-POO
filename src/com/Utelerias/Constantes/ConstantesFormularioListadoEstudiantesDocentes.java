package com.Utelerias.Constantes;

import javax.swing.ImageIcon;

public interface ConstantesFormularioListadoEstudiantesDocentes {

//iconos
    final ImageIcon ICONO_BUSCAR = new ImageIcon("C:\\Users\\User\\Music\\CUARTO CICLO\\08 LABORATORIOS POO\\ProyectoMatriculaPOO\\src\\com\\imgs\\BuscarEstudiante.png");
    final ImageIcon ICONO_MODIFICAR = new ImageIcon("C:\\Users\\User\\Music\\CUARTO CICLO\\08 LABORATORIOS POO\\ProyectoMatriculaPOO\\src\\com\\imgs\\EditarEstudiante.png");
    final ImageIcon ICONO_ELIMINAR = new ImageIcon("C:\\Users\\User\\Music\\CUARTO CICLO\\08 LABORATORIOS POO\\ProyectoMatriculaPOO\\src\\com\\imgs\\EliminarEstudiante.png");

    //cabezeras de la tabla alumnos
    final String TITULOS_COLUMNAS[] = {"ID", "Nombre", "Apellido Paterno",
        "Apellido Materno", "Fecha Nacimiento", "Tipo Documento",
        "Nº de Dni", "Calle", "Nº de Calle",
        "Distrito", "Provincia", "Telefono",
        "Email Personal", "Cod Estudiante", "Email Educativo"};
    
    final String TITULOS_COLUMNAS_DOCENTE[] = {"ID", "Nombre", "Apellido Paterno",
        "Apellido Materno", "Fecha Nacimiento", "Tipo Documento",
        "Nº de Dni", "Calle", "Nº de Calle",
        "Distrito", "Provincia", "Telefono",
        "Email Personal", "Cod Docente", "Titulo Academico",
        "AÑOS EXP", "Email Educativo"};

}
