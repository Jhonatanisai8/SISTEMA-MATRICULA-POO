package com.Modelo.entidades.DaoImplementacion;

import com.Modelo.entidades.BaseDatos.ConexionBaseDatos;
import com.Modelo.entidades.Horario;
import com.Modelo.entidades.InterfaceDao.ConsultasSQLHorario;
import com.Modelo.entidades.InterfaceDao.Repositorio;
import java.util.List;
import java.sql.*;

public class HorarioRepoImple
        implements Repositorio<Horario>,
        ConsultasSQLHorario {

    private Connection getConection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }

    @Override
    public List<Horario> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Horario porDni(Long dni) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void guardar(Horario horario) {
        try (
                Connection con = getConection(); PreparedStatement st = con.prepareStatement(SQL_INSERT_HORARIO);) {
            st.setString(1, horario.getDiaSemana());
            st.setTime(2, Time.valueOf(horario.getHoraInicio()));
            st.setTime(3, Time.valueOf(horario.getHoraFin()));
            st.setString(4, horario.getTurno());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("error al insertar un horario: " + e.getMessage());
        }
    }

    @Override
    public void modificar(Horario horario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
