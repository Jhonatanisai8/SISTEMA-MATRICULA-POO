package com.Modelo.entidades.InterfaceDao;

public interface ConsultasSQLDocente {

    final String SQL_INSERT_DOCENTE = "INSERT INTO docente(id_docente,codigo_docente,titulo_academico,anios_esperiencia,email_educativo_docente) "
            + "VALUES ((SELECT id_persona FROM persona ORDER BY id_persona DESC limit 1),?,?,?,?)";
}
