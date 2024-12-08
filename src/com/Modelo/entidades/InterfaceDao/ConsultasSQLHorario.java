package com.Modelo.entidades.InterfaceDao;

public interface ConsultasSQLHorario {

    final String SQL_INSERT_HORARIO = "INSERT INTO horario(dia_semana,hora_inicio,hora_fin,turno) "
            + " VALUES (?,?,?,?)";

    final String SQL_SELECT = "SELECT "
            + "    id_horario AS ID, "
            + "    dia_semana AS DIA_SEMANA, "
            + "    hora_inicio AS HORA_INICIO, "
            + "    hora_fin AS HORA_FIN, "
            + "    turno AS TURNO "
            + " FROM "
            + "    horario";

    final String SQL_UPDATE_HORARIO = "UPDATE horario SET dia_semana = ?, hora_inicio = ?, hora_fin = ?, turno = ? WHERE id_horario = ?";

}
