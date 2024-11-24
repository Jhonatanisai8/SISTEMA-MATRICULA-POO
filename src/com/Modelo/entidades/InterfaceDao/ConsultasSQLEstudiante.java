package com.Modelo.entidades.InterfaceDao;

public interface ConsultasSQLEstudiante {

    final String SQL_INSERT_DNI = "INSERT INTO dni(tipo_documento,numero_dni) VALUES (?,?)";

    final String SQL_INSERT_DIRECCION = "INSERT INTO direccion(distrito,calle,numero_cale,provincia) VALUES (?,?,?,?)";

    final String SQL_INSERT_PERSONA = "INSERT INTO persona (nombre,apellido_paterno,apellido_materno,fecha_nacimiento,id_dni,id_direccion,telefono,email_personal) "
            + " VALUES (?,?,?,?,(SELECT id_dni FROM dni ORDER BY id_dni DESC limit 1),(SELECT id_direccion FROM direccion ORDER BY id_direccion DESC limit 1),?,?)";

    final String SQL_INSERT_ESTUDIANTE = "INSERT INTO estudiante (id_estudiante,codigo_estudiante,email_educativo)"
            + " VALUES ((SELECT id_persona FROM persona ORDER BY id_persona DESC limit 1),?,?)";

    final String SQL_SELECT_ESTUDIANTES = "SELECT "
            + "	p.id_persona AS 'ID', "
            + "    p.nombre AS 'Nombre', "
            + "    p.apellido_paterno AS 'Apellido Paterno', "
            + "    p.apellido_materno AS 'Apellido Materno', "
            + "    p.fecha_nacimiento AS 'Fecha Nacimiento', "
            + "    d.tipo_documento AS 'Tipo Documento', "
            + "    d.numero_dni AS 'Nº de Dni', "
            + "    di.calle AS 'Calle', "
            + "    di.numero_cale AS 'Nº Calle', "
            + "    di.distrito AS 'Distrito', "
            + "    di.provincia AS 'Provincia', "
            + "    p.telefono AS 'Telefono', "
            + "    p.email_personal AS 'Email Personal', "
            + "    e.codigo_estudiante AS 'Cod Estudiante', "
            + "    e.email_educativo AS 'Email Educativo' "
            + "FROM persona AS p "
            + "INNER JOIN dni AS d ON d.id_dni = p.id_dni "
            + "INNER JOIN direccion AS di ON di.id_direccion = p.id_direccion "
            + "INNER JOIN estudiante AS e ON e.id_estudiante = p.id_persona";
}
