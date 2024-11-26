package com.Modelo.entidades.InterfaceDao;

public interface ConsultasSQLSalon {

    final String SQL_INSERT_SALON = "INSERT INTO salon (nombre_salon,capacidad,referencia) VALUES (?,?,?)";

    final String SQL_UPDATE_SALON = "UPDATE salon SET nombre_salon = ? ,capacidad = ?,referencia = ? WHERE id_salon = ?";

    final String SQL_DELETE_SALON = "DELETE FROM salon WHERE id_salon = ?";

    final String SQL_SELECT_RONALDO = "SELECT id_salon,nombre_salon,capacidad,referencia FROM salon";
}
