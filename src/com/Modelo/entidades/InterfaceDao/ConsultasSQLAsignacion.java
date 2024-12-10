package com.Modelo.entidades.InterfaceDao;

public interface ConsultasSQLAsignacion {

    final String SQL_INSERT_ASIGNACION = "INSERT INTO asignacion(id_docente,id_curso,id_salon,id_horario) VALUES (?,?,?,?)";

    final String SQL_SELECT_ASIGNACIONES = """
                                           SELECT 
                                               a.id_asignacion AS "ID Asignacion",
                                               c.id_curso AS "ID Curso",
                                               c.codigo_curso AS "Codigo Curso",
                                               c.nombre_curso AS "Nombre Curso",
                                               c.descripcion AS "Descripcion Curso",
                                               c.grado AS "Grado",
                                               c.nivel AS "Nivel",
                                               d.id_docente AS "ID Docente",
                                               p.nombre AS "Nombre Docente",
                                               p.apellido_paterno AS "Apellido Paterno Docente",
                                               p.apellido_materno AS "Apellido Materno Docente",
                                               p.telefono AS "Telefono Docente",
                                               s.id_salon AS "ID Salon",
                                               s.nombre_salon AS "Nombre Salon",
                                               s.capacidad AS "Capacidad Salon",
                                               s.referencia AS "Referencia Salon",
                                               h.id_horario AS "ID Horario",
                                               h.dia_semana AS "Día Semana",
                                               h.hora_inicio AS "Hora Inicio",
                                               h.hora_fin AS "Hora Fin",
                                               h.turno AS "Turno"
                                           FROM 
                                               asignacion a
                                           JOIN 
                                               curso c ON a.id_curso = c.id_curso
                                           JOIN 
                                               docente d ON a.id_docente = d.id_docente
                                           JOIN 
                                               persona p ON d.id_docente = p.id_persona
                                           JOIN 
                                               salon s ON a.id_salon = s.id_salon
                                           JOIN 
                                               horario h ON a.id_horario = h.id_horario""";
}
