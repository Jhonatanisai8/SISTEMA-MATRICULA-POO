package com.Modelo.entidades.BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos
        implements Credenciales {

    public static Connection getInstance() throws SQLException {
        return DriverManager.getConnection(RUTA, USUARIO, CLAVE);
    }
}
