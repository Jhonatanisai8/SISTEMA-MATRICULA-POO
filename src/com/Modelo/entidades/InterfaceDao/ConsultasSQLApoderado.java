package com.Modelo.entidades.InterfaceDao;

public interface ConsultasSQLApoderado {

    final String SQL_INSERT_DNI = "INSERT INTO dni(tipo_documento,numero_dni) VALUES (?,?)";

    final String SQL_INSERT_DIRECCION = "INSERT INTO direccion(distrito,calle,numero_cale,provincia) VALUES (?,?,?,?)";

    final String SQL_INSERT_PERSONA = "INSERT INTO persona (nombre,apellido_paterno,apellido_materno,fecha_nacimiento,id_dni,id_direccion,telefono,email_personal) "
            + " VALUES (?,?,?,?,(SELECT id_dni FROM dni ORDER BY id_dni DESC limit 1),(SELECT id_direccion FROM direccion ORDER BY id_direccion DESC limit 1),?,?)";

    final String SQL_INSERT_APODERADO = "INSERT INTO apoderado (id_apoderado,relacion_estudiante,ocupacion,estado_civil)"
            + " VALUES ((SELECT id_persona FROM persona ORDER BY id_persona DESC limit 1),?,?,?)";

    final String SQL_UPDATE_DNI = "UPDATE  dni SET tipo_documento = ?, numero_dni = ? WHERE id_dni = ?";

    final String SQL_UPDATE_DIRECCION = "UPDATE  direccion SET distrito = ?, calle = ?,numero_cale = ?,provincia = ?  WHERE id_direccion = ?";

    final String SQL_UPDATE_PERSONA = "UPDATE  persona SET nombre = ?,apellido_paterno = ? ,apellido_materno =? ,fecha_nacimiento = ? ,id_dni = ? ,id_direccion = ? ,telefono = ?,email_personal = ? WHERE id_persona = ?";

    final String SQL_UPDATE_APODERADO = "UPDATE  apoderado SET relacion_estudiante = ? , ocupacion = ? ,estado_civil = ? WERE id_apoderado = ? ";

    final String SQL_SELECT_APODERADOS = "SELECT "
            + "             	p.id_persona AS 'ID', "
            + "                p.nombre AS 'Nombre', "
            + "                p.apellido_paterno AS 'Apellido Paterno', "
            + "                p.apellido_materno AS 'Apellido Materno', "
            + "                p.fecha_nacimiento AS 'Fecha Nacimiento', "
            + "                d.tipo_documento AS 'Tipo Documento', "
            + "                d.numero_dni AS 'Nº de Dni', "
            + "                di.calle AS 'Calle', "
            + "                di.numero_cale AS 'Nº Calle', "
            + "                di.distrito AS 'Distrito', "
            + "                di.provincia AS 'Provincia', "
            + "                p.telefono AS 'Telefono', "
            + "                p.email_personal AS 'Email Personal', "
            + "                a.relacion_estudiante AS 'Relacion Con Estudiante', "
            + "                a.ocupacion AS 'Ocupacion' ,"
            + "                a.estado_civil as 'Estado Civil'"
            + "            FROM persona AS p "
            + "            INNER JOIN dni AS d ON d.id_dni = p.id_dni "
            + "            INNER JOIN direccion AS di ON di.id_direccion = p.id_direccion "
            + "            INNER JOIN apoderado AS a ON a.id_apoderado = p.id_persona";

    final String SQL_DELETE_PERSONA = "DELETE FROM persona WHERE id_persona = ?";
    final String SQL_DELETE_DIRECCION = "DELETE FROM direccion WHERE id_direccion = ?";
    final String SQL_DELETE_DNI = "DELETE FROM dni WHERE id_dni = ?";

}
