package com.Modelo.entidades.DaoImplementacion;

import com.Modelo.entidades.BaseDatos.ConexionBaseDatos;
import com.Modelo.entidades.Horario;
import com.Modelo.entidades.InterfaceDao.ConsultasSQLHorario;
import com.Modelo.entidades.InterfaceDao.Repositorio;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class HorarioRepoImple
        implements Repositorio<Horario>,
        ConsultasSQLHorario {

    private Connection getConection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }

    @Override
    public List<Horario> listar() {
        List<Horario> listaHorarios = new ArrayList<>();
        try (
                Connection con = getConection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(SQL_SELECT);) {
            while (rs.next()) {
                Horario miHorario = crearHorario(rs);
                listaHorarios.add(miHorario);
            }
        } catch (Exception e) {
            System.out.println("Error al listar horarios: ");
        }
        return listaHorarios;
    }

    private Horario crearHorario(final ResultSet rs) throws SQLException {
        Horario miHorario = new Horario();
        miHorario.setIdHorario(rs.getLong("ID"));
        miHorario.setDiaSemana(rs.getString("DIA_SEMANA"));
        miHorario.setHoraInicio(rs.getTime("HORA_INICIO").toLocalTime());
        miHorario.setHoraFin(rs.getTime("HORA_FIN").toLocalTime());
        miHorario.setTurno(rs.getString("TURNO"));
        return miHorario;
    }

    @Override
    public Horario porDni(Long id) {
        final String SQL_BUSCAR_HORARIO = "SELECT   "
                + "    id_horario AS ID,  "
                + "    dia_semana AS DIA_SEMANA,  "
                + "    hora_inicio AS HORA_INICIO,  "
                + "    hora_fin AS HORA_FIN,  "
                + "    turno AS TURNO  "
                + "FROM  "
                + "    horario  "
                + "WHERE  "
                + "    id_horario = " + id;
        Horario horario = null;
        try (
                Connection con = getConection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(SQL_BUSCAR_HORARIO)) {
            if (rs.next()) {
                horario = crearHorario(rs);
            }
        } catch (Exception e) {
            System.out.println("Error al buscar horario: " + e.getMessage());
        }
        return horario;
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
        try (
                Connection con = getConection(); PreparedStatement st = con.prepareStatement(SQL_UPDATE_HORARIO);) {
            st.setString(1, horario.getDiaSemana());
            st.setTime(2, Time.valueOf(horario.getHoraInicio()));
            st.setTime(3, Time.valueOf(horario.getHoraFin()));
            st.setString(4, horario.getTurno());
            st.setLong(5, horario.getIdHorario());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("error al modificar  un horario: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(Long id) {
        boolean huboExcepcion = false;
        try (
                Connection con = getConection(); PreparedStatement st = con.prepareStatement(SQL_DELETE_HORARIO);) {
            st.setLong(1, id);
            st.executeUpdate();
        } catch (Exception e) {
            huboExcepcion = true;
            System.out.println("Hubo Excepcion: ");
        }
        if (!huboExcepcion) {
            JOptionPane.showMessageDialog(null, "Horario eliminado correctamente", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "El horario esta en uso en una Asignacion. No se puede Eliminar", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
