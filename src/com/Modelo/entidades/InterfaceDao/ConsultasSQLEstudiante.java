package com.Modelo.entidades.InterfaceDao;

public interface ConsultasSQLEstudiante {

    final String SQL_INSERT_DNI = "INSERT INTO dni(tipo_documento,numero_dni) VALUES (?,?)";

    final String SQL_INSERT_DIRECCION = "INSERT INTO direccion(distrito,calle,numero_calle,provincia) VALUES (?,?,?,?)";

    final String SQL_INSERT_PERSONA = "INSERT INTO persona (nombre,apellido_paterno,apellido_materno,fecha_nacimiento,id_dni,id_direccion,telefono,email_personal) "
            + " VALUES (?,?,?,?,(SELECT id_dni FROM dni ORDER BY id_dni DESC limit 1),(SELECT id_direccion FROM direccion ORDER BY id_direccion DESC limit 1),?,?)";

    final String SQL_INSERT_ESTUDIANTE = "INSERT INTO estudiante (id_estudiante,codigo_estudiante,email_educativo)"
            + " VALUES ((SELECT id_persona FROM persona ORDER BY id_persona DESC limit 1),?,?)";
}
