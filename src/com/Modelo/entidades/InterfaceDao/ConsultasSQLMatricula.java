package com.Modelo.entidades.InterfaceDao;

public interface ConsultasSQLMatricula {

    final String SQL_INSERT_MATRICULA = "INSERT INTO matricula (id_estudiante,id_asignacion,fecha_matricula) VALUES (?,?,?)";
    final String SQL_SELECT_ASIGNACIONES = "SELECT     "
            + "    a.id_asignacion AS ID     "
            + "    d.id_docente AS ID_DOCENTE     "
            + "    concat(p.nombre , \" \",p.apellido_paterno , \" \",p.apellido_materno ) AS DOCENTE     "
            + "    d.email_educativo_docente AS EMAIL_EDUCATIVO     "
            + "    -- c.id_curso AS ID_CURSO     "
            + "    c.codigo_curso AS COD_CURSO     "
            + "    c.nombre_curso AS NOMBRE_CURSO     "
            + "    c.grado AS GRADO     "
            + "    -- s.id_salon AS ID_SALON     "
            + "    s.nombre_salon AS SALON     "
            + "    s.referencia AS REFERENCIA     "
            + "    s.vacantes_disponibles AS VAC_DISPO     "
            + "    -- h.id_Horario AS ID_HORARIO     "
            + "    h.dia_semana AS DIA_SEMANA     "
            + "    h.hora_inicio AS HORA_INICIO     "
            + "    h.hora_fin AS HORA_FIN     "
            + "    h.turno AS TURN     "
            + "FROM     "
            + "    asignacion AS    a  "
            + "        INNER JOIN     "
            + "    docente AS d ON d.id_docente = a.id_docente     "
            + "        INNER JOIN     "
            + "    persona AS p ON p.id_persona = d.id_docente     "
            + "        INNER JOIN     "
            + "    curso AS c ON c.id_curso = a.id_curso     "
            + "        INNER JOIN     "
            + "    salon AS s ON s.id_salon = a.id_salon     "
            + "        INNER JOIN     "
            + "    horario AS h ON h.id_horario = a.id_horario     "
            + "    ORDER BY h.dia_semana ASC";
}
