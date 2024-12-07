package com.Modelo.entidades.InterfaceDao;

public interface ConsultasSQLAsignacion {

    final String SQL_INSERT_ASIGNACION = "INSERT INTO asignacion(id_docente,id_curso,id_salon,id_horario) VALUES (?,?,?,?)";
}
