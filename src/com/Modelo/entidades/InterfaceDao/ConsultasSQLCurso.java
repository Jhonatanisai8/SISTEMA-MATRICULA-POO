package com.Modelo.entidades.InterfaceDao;

public interface ConsultasSQLCurso {

    final String SQL_SELECT_CURSOS = """
                                     SELECT      id_curso AS ID,    codigo_curso AS CODIGO,    nombre_curso AS NOMBRE_CURSO,    descripcion AS DESCRIPCION,    grado AS GRADO,    nivel AS NIVEL
                                     FROM      curso ORDER BY grado DESC""";

    final String SQL_INSERT_CURSO = "INSERT INTO curso(codigo_curso,nombre_curso,descripcion,grado,nivel) "
            + "VALUES (?,?,?,?,?)";

    final String SQL_UPDATE_CURSO = "UPDATE curso SET codigo_curso = ?, nombre_curso = ?, descripcion = ?, grado = ? WHERE id_curso = ?";

    final String SQL_DELETE_CURSO = "DELETE FROM curso WHERE id_curso = ?";

    final String SQL_CURSO_PROFESOR = """
                                      SELECT
                                          CONCAT(pd.nombre,' ',pd.apellido_paterno,' ',pd.apellido_materno) AS "Docente",
                                          ddoc.email_educativo_docente AS "Email Educativo Docente",
                                          c.codigo_curso AS "Codigo Curso",
                                          c.nombre_curso AS "Nombre Curso",
                                          c.descripcion AS "Descripcion Curso",
                                          c.grado AS "Grado Curso",
                                          c.nivel AS "Nivel Curso"
                                      FROM 
                                          docente ddoc
                                      JOIN 
                                          persona pd ON ddoc.id_docente = pd.id_persona
                                      JOIN 
                                          asignacion a ON ddoc.id_docente = a.id_docente
                                      JOIN 
                                          curso c ON a.id_curso = c.id_curso
                                      ORDER BY 
                                          pd.nombre, c.nombre_curso""";
}
