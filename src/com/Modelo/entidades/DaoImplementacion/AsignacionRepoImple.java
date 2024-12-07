package com.Modelo.entidades.DaoImplementacion;

import com.Modelo.entidades.Asignacion;
import com.Modelo.entidades.BaseDatos.ConexionBaseDatos;
import com.Modelo.entidades.InterfaceDao.ConsultasSQLAsignacion;
import com.Modelo.entidades.InterfaceDao.Repositorio;
import java.sql.*;
import java.util.List;

public class AsignacionRepoImple
        implements Repositorio<Asignacion>,
        ConsultasSQLAsignacion {

    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }

    @Override
    public List<Asignacion> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Asignacion porDni(Long dni) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void guardar(Asignacion asignacion) {
        try (
                Connection con = getConnection(); PreparedStatement st = con.prepareStatement(SQL_INSERT_ASIGNACION);) {
            //le establecemos los parametros
            st.setLong(1, asignacion.getDocente().getIdDocente());
            st.setLong(2, asignacion.getCurso().getIdCurso());
            st.setLong(3, asignacion.getSalon().getIdSalon());
            st.setLong(4, asignacion.getHorario().getIdHorario());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al insertar una asignacion: " + e.getMessage());
        }
    }

    @Override
    public void modificar(Asignacion t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
