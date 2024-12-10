package com.Modelo.entidades.DaoImplementacion;

import com.Modelo.entidades.Asignacion;
import com.Modelo.entidades.BaseDatos.ConexionBaseDatos;
import com.Modelo.entidades.Curso;
import com.Modelo.entidades.Docente;
import com.Modelo.entidades.Horario;
import com.Modelo.entidades.InterfaceDao.ConsultasSQLAsignacion;
import com.Modelo.entidades.InterfaceDao.Repositorio;
import com.Modelo.entidades.Salon;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class AsignacionRepoImple
        implements Repositorio<Asignacion>,
        ConsultasSQLAsignacion {

    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }

    @Override
    public List<Asignacion> listar() {
        List<Asignacion> listaAsignaccion = new ArrayList<>();
        try (Connection con = getConnection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(SQL_SELECT_ASIGNACIONES);) {
            while (rs.next()) {
                Asignacion asignacion = CrearAsignacion(rs);
                listaAsignaccion.add(asignacion);
            }
        } catch (Exception e) {
            System.out.println("Error al listar las asignaciones: " + e.getMessage());
        }
        return listaAsignaccion;
    }

    private Asignacion CrearAsignacion(final ResultSet rs) throws SQLException {
        Asignacion asignacion = new Asignacion();
        asignacion.setIdAsignacion(rs.getLong("ID Asignacion"));
        Curso curso = new Curso();
        curso.setIdCurso(rs.getLong("ID Curso"));
        curso.setCodigoCurso(rs.getString("Codigo Curso"));
        curso.setNombreCurso(rs.getString("Nombre Curso"));
        curso.setDescripcion(rs.getString("Descripcion Curso"));
        curso.setGrado(rs.getInt("Grado"));
        curso.setNivel(rs.getString("Nivel"));
        asignacion.setCurso(curso);
        Docente docente = new Docente();
        docente.setIdDocente(rs.getLong("ID Docente"));
        docente.setNombre(rs.getString("Nombre Docente"));
        docente.setApellidoPaterno(rs.getString("Apellido Paterno Docente"));
        docente.setApellidoMaterno(rs.getString("Apellido Materno Docente"));
        docente.setTelefono(rs.getString("Telefono Docente"));
        asignacion.setDocente(docente);
        Salon salon = new Salon();
        salon.setIdSalon(rs.getLong("ID Salon"));
        salon.setNombreSalon(rs.getString("Nombre Salon"));
        salon.setCapacidadEstudiantes(rs.getInt("Capacidad Salon"));
        salon.setReferencia(rs.getString("Referencia Salon"));
        asignacion.setSalon(salon);
        Horario horario = new Horario();
        horario.setIdHorario(rs.getLong("ID Horario"));
        horario.setDiaSemana(rs.getString("Día Semana"));
        horario.setHoraInicio(rs.getTime("Hora Inicio").toLocalTime());
        horario.setHoraFin(rs.getTime("Hora Fin").toLocalTime());
        horario.setTurno(rs.getString("Turno"));
        asignacion.setHorario(horario);
        return asignacion;
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

    public DefaultTableModel listarInformacionObjeto(DefaultTableModel model, String parametro, int bandera) {
        model.setRowCount(0);

        return model;
    }

}
