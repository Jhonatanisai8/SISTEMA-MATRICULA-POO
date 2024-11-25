package com.Modelo.entidades.InterfaceDao;

public interface ConsultasSQLDocente {

    final String SQL_INSERT_DOCENTE = "INSERT INTO docente(id_docente,codigo_docente,titulo_academico,anios_esperiencia,email_educativo_docente) "
            + "VALUES ((SELECT id_persona FROM persona ORDER BY id_persona DESC limit 1),?,?,?,?)";
    final String SQL_SELECT_DOCENTES = "SELECT "
            + "p.id_dni AS 'ID', "
            + "p.nombre AS 'Nombre', "
            + "p.apellido_paterno AS 'Apellido Paterno', "
            + "p.apellido_materno AS 'Apellido Materno', "
            + "p.fecha_nacimiento AS 'Fecha Nacimiento', "
            + "d.tipo_documento AS 'Tipo Documento', "
            + "d.numero_dni AS 'Numero Dni', "
            + "di.calle AS 'Calle', "
            + "di.numero_cale AS 'Numero Calle', "
            + "di.distrito AS 'Distrito', "
            + "di.provincia AS 'Provincia', "
            + "p.telefono AS 'Telefono', "
            + "p.email_personal AS 'Email Personal', "
            + "doc.codigo_docente AS 'Cod Docente', "
            + "doc.titulo_academico AS 'Titulo Academico', "
            + "doc.anios_esperiencia AS 'Anios Exp', "
            + "doc.email_educativo_docente AS 'Email Educativo' "
            + "FROM persona AS p "
            + "INNER JOIN dni AS d ON d.id_dni = p.id_dni "
            + "INNER JOIN direccion AS di ON di.id_direccion = p.id_direccion "
            + "INNER JOIN docente AS doc ON  doc.id_docente = p.id_persona";

}
