package com.Modelo.entidades.InterfaceDao;

public interface ConsultasSQLEstudiante {

    final String SQL_SELECT_DATOS_APODERADO = "SELECT id_apoderado AS ID ,  "
            + "concat(persona.nombre,\" \",persona.apellido_paterno,\" \",persona.apellido_materno) AS NOMBRE,  "
            + "relacion_estudiante AS RELACION,  "
            + "ocupacion  AS OCUPACION,  "
            + "estado_civil AS ESTADO_CIVIL	  "
            + "FROM apoderado   "
            + "INNER JOIN persona   "
            + "ON apoderado.id_apoderado = persona.id_persona";
    final String SQL_INSERT_DNI = "INSERT INTO dni(tipo_documento,numero_dni) VALUES (?,?)";

    final String SQL_INSERT_DIRECCION = "INSERT INTO direccion(distrito,calle,numero_cale,provincia) VALUES (?,?,?,?)";

    final String SQL_INSERT_PERSONA = "INSERT INTO persona (nombre,apellido_paterno,apellido_materno,fecha_nacimiento,id_dni,id_direccion,telefono,email_personal) "
            + " VALUES (?,?,?,?,(SELECT id_dni FROM dni ORDER BY id_dni DESC limit 1),(SELECT id_direccion FROM direccion ORDER BY id_direccion DESC limit 1),?,?)";

    final String SQL_INSERT_ESTUDIANTE = "INSERT INTO estudiante (id_estudiante,codigo_estudiante,email_educativo,id_apoderado)"
            + " VALUES ((SELECT id_persona FROM persona ORDER BY id_persona DESC limit 1),?,?,?)";

    final String SQL_UPDATE_DNI = "UPDATE  dni SET tipo_documento = ?, numero_dni = ? WHERE id_dni = ?";

    final String SQL_UPDATE_DIRECCION = "UPDATE  direccion SET distrito = ?, calle = ?,numero_cale = ?,provincia = ?  WHERE id_direccion = ?";

    final String SQL_UPDATE_PERSONA = "UPDATE  persona SET nombre = ?,apellido_paterno = ? ,apellido_materno =? ,fecha_nacimiento = ? ,id_dni = ? ,id_direccion = ? ,telefono = ?,email_personal = ? WHERE id_persona = ?";

    final String SQL_UPDATE_ESTUDIANTE = "UPDATE  estudiante SET codigo_estudiante = ? ,email_educativo = ? WHERE id_estudiante = ?";

    final String SQL_SELECT_ESTUDIANTES = "SELECT "
            + "p.id_persona AS 'ID', "
            + "p.nombre AS 'Nombre', "
            + "p.apellido_paterno AS 'Apellido Paterno', "
            + "p.apellido_materno AS 'Apellido Materno', "
            + "p.fecha_nacimiento AS 'Fecha Nacimiento', "
            + "d.tipo_documento AS 'Tipo Documento', "
            + "d.numero_dni AS 'Nº de Dni', "
            + "di.calle AS 'Calle', "
            + "di.numero_cale AS 'Nº Calle', "
            + "di.distrito AS 'Distrito', "
            + "di.provincia AS 'Provincia', "
            + "p.telefono AS 'Telefono', "
            + "p.email_personal AS 'Email Personal', "
            + "e.codigo_estudiante AS 'Cod Estudiante', "
            + "e.email_educativo AS 'Email Educativo', "
            + "apo.id_apoderado AS 'ID Apoderado', "
            + "pa.nombre AS 'Nombre Apoderado', "
            + "pa.apellido_paterno AS 'Apellido Paterno Apoderado', "
            + "pa.apellido_materno AS 'Apellido Materno Apoderado', "
            + "pa.telefono AS 'Telefono Apoderado', "
            + "pa.email_personal AS 'Email Personal Apoderado', "
            + "apo.relacion_estudiante AS 'Relacion Estudiante', "
            + "apo.ocupacion AS 'Ocupacion Apoderado', "
            + "apo.estado_civil AS 'Estado Civil Apoderado' "
            + "FROM persona AS p "
            + "INNER JOIN dni AS d ON d.id_dni = p.id_dni "
            + "INNER JOIN direccion AS di ON di.id_direccion = p.id_direccion "
            + "INNER JOIN estudiante AS e ON e.id_estudiante = p.id_persona "
            + "LEFT JOIN apoderado AS apo ON e.id_apoderado = apo.id_apoderado "
            + "LEFT JOIN persona AS pa ON pa.id_persona = apo.id_apoderado ";
    final String SQL_DELETE_ESTUDIANTE = "DELETE FROM estudiante WHERE id_estudiante = ?";
    final String SQL_DELETE_PERSONA = "DELETE FROM persona WHERE id_persona = ?";
    final String SQL_DELETE_DIRECCION = "DELETE FROM direccion WHERE id_direccion = ?";
    final String SQL_DELETE_DNI = "DELETE FROM dni WHERE id_dni = ?";
}
