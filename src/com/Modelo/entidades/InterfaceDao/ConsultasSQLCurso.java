package com.Modelo.entidades.InterfaceDao;

public interface ConsultasSQLCurso {

    final String SQL_SELECT_CURSOS = "SELECT  "
            + "    id_curso AS ID,"
            + "    codigo_curso AS CODIGO,"
            + "    nombre_curso AS NOMBRE_CURSO,"
            + "    descripcion AS DESCRIPCION,"
            + "    grado AS GRADO,"
            + "    nivel AS NIVEL\n"
            + "FROM  "
            + "    curso";

    final String SQL_INSERT_CURSO = "INSERT INTO curso(codigo_curso,nombre_curso,descripcion,grado,nivel) "
            + "VALUES (?,?,?,?,?)";

}
