package com.Modelo.entidades.InterfaceDao;

public interface ConsultasSQLHorario {

    final String SQL_INSERT_HORARIO = "INSERT INTO horario(dia_semana,hora_inicio,hora_fin,turno) "
            + " VALUES (?,?,?,?)";
    
}
