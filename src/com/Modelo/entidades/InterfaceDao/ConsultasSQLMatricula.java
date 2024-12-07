package com.Modelo.entidades.InterfaceDao;

public interface ConsultasSQLMatricula {

    final String SQL_INSERT_MATRICULA = "INSERT INTO matricula (id_estudiante,id_asignacion,fecha_matricula) VALUES (?,?,?)";
}
