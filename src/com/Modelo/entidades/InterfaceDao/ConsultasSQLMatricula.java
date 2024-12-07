package com.Modelo.entidades.InterfaceDao;

public interface ConsultasSQLMatricula {

    final String SQL_INSERT_MATRICULA = "INSERT INTO matricula (id_estudiante,id_asignacion,fecha_matricula) VALUES (?,?,?)";
    final String SQL_SELECT_ASIGNACIONES = """
                                           SELECT
                                               a.id_asignacion AS ID,
                                               d.id_docente AS ID_DOCENTE,
                                               CONCAT(p.nombre, ' ', p.apellido_paterno, ' ', p.apellido_materno) AS DOCENTE,
                                               c.nombre_curso AS NOMBRE_CURSO,
                                               c.grado AS GRADO,
                                               s.nombre_salon AS SALON,
                                               s.referencia AS REFERENCIA,
                                               s.vacantes_disponibles AS VAC_DISPO,
                                               h.dia_semana AS DIA_SEMANA,
                                               h.hora_inicio AS HORA_INICIO,
                                               h.hora_fin AS HORA_FIN,
                                               h.turno AS TURNO
                                           FROM
                                               asignacion AS a
                                               INNER JOIN docente AS d ON d.id_docente = a.id_docente
                                               INNER JOIN persona AS p ON p.id_persona = d.id_docente
                                               INNER JOIN curso AS c ON c.id_curso = a.id_curso
                                               INNER JOIN salon AS s ON s.id_salon = a.id_salon
                                               INNER JOIN horario AS h ON h.id_horario = a.id_horario
                                           ORDER BY
                                               h.dia_semana ASC""";

    final String SQL_SELECT_INFORMACION = """
                                          SELECT 
                                              m.id_matricula AS ID_Matricula,
                                              CONCAT(p.nombre, ' ', p.apellido_paterno, ' ', p.apellido_materno) AS Estudiante,
                                              e.email_educativo AS Email_Educativo,
                                              CONCAT(pd.nombre, ' ', pd.apellido_paterno, ' ', pd.apellido_materno) AS Docente,
                                              s.nombre_salon AS Salon,
                                              CONCAT(h.dia_semana, ' ', h.hora_inicio, '-', h.hora_fin) AS Horario,
                                              m.fecha_matricula AS Fecha_Matricula
                                          FROM 
                                              matricula m
                                          JOIN 
                                              estudiante e ON m.id_estudiante = e.id_estudiante
                                          JOIN 
                                              persona p ON e.id_estudiante = p.id_persona
                                          JOIN 
                                              asignacion a ON m.id_asignacion = a.id_asignacion
                                          JOIN 
                                              docente d ON a.id_docente = d.id_docente
                                          JOIN 
                                              persona pd ON d.id_docente = pd.id_persona
                                          JOIN 
                                              salon s ON a.id_salon = s.id_salon
                                          JOIN 
                                              horario h ON a.id_horario = h.id_horario""";
}
