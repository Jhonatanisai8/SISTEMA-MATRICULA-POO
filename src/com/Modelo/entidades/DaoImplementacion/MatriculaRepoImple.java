package com.Modelo.entidades.DaoImplementacion;

import com.Modelo.entidades.BaseDatos.ConexionBaseDatos;
import com.Modelo.entidades.InterfaceDao.ConsultasSQLMatricula;
import com.Modelo.entidades.InterfaceDao.Repositorio;
import com.Modelo.entidades.Matricula;
import java.util.List;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.Utelerias.Constantes.ConstantesFormulariosMatricula;

public class MatriculaRepoImple
        implements ConsultasSQLMatricula,
        Repositorio<Matricula>,
        ConstantesFormulariosMatricula {

    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }

    @Override
    public List<Matricula> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Matricula porDni(Long dni) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void guardar(Matricula matricula) {
        try (
                Connection con = getConnection(); PreparedStatement st = con.prepareStatement(SQL_INSERT_MATRICULA);) {
            st.setLong(1, matricula.getEstudiante().getIdEstudiante());
            st.setLong(2, matricula.getAsignacion().getIdAsignacion());
            st.setDate(3, new Date(matricula.getFechaEmision().getTime()));
            //ejecutamos
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("error al momento de insertar una matricula: : " + e.getMessage());
        }
    }

    @Override
    public void modificar(Matricula t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void listarInformacion(JTable tblData) {
        try (Connection con = getConnection(); PreparedStatement pr = con.prepareStatement(SQL_SELECT_ASIGNACIONES); ResultSet rs = pr.executeQuery();) {
            //obtenemos las columnas 
            DefaultTableModel modelo = new DefaultTableModel(ENCABEZADOS_TABLA_ASIGNACIONES, 0);
            tblData.setModel(modelo);
            ResultSetMetaData data = rs.getMetaData();
            int nColumnas = data.getColumnCount();
            while (rs.next()) {
                Object[] fila = new Object[nColumnas];
                for (int i = 1; i <= nColumnas; i++) {
                    fila[i - 1] = rs.getObject(i);
                }
                modelo.addRow(fila);
            }
            System.out.println("Listando informacion de asignaciones");
        } catch (Exception e) {
            System.out.println("Error al listar cierta informacion de la tabla de asiganciones: " + e.getMessage());
        }

    }

    public void listarInformacionMatriculas(JTable tblData) {
        try (Connection con = getConnection(); PreparedStatement pr = con.prepareStatement(SQL_SELECT_INFORMACION); ResultSet rs = pr.executeQuery();) {
            //obtenemos las columnas 
            DefaultTableModel modelo = new DefaultTableModel(ENCABEZADOS_TABLA_MATRICULA, 0);
            tblData.setModel(modelo);
            ResultSetMetaData data = rs.getMetaData();
            int nColumnas = data.getColumnCount();
            while (rs.next()) {
                Object[] fila = new Object[nColumnas];
                for (int i = 1; i <= nColumnas; i++) {
                    fila[i - 1] = rs.getObject(i);
                }
                modelo.addRow(fila);
            }
            System.out.println("Listando informacion de matriculas");
        } catch (Exception e) {
            System.out.println("Error al listar cierta informacion de la tabla de matriculas: " + e.getMessage());
        }
    }

    public String verHorario(Long idMatricula) {
        StringBuilder sb = new StringBuilder();
        String SQL_CONSULTA = "SELECT m.id_matricula, "
                + "m.fecha_matricula, "
                + "e.codigo_estudiante, "
                + "e.email_educativo, "
                + "p.id_persona, "
                + "p.nombre, "
                + "p.apellido_paterno, "
                + "p.apellido_materno, "
                + "p.fecha_nacimiento, "
                + "p.telefono, p.email_personal, d.numero_dni, dir.distrito, dir.calle, dir.numero_cale, "
                + "dir.provincia, c.id_curso, c.codigo_curso, c.nombre_curso, c.descripcion, c.grado, "
                + "c.nivel, h.id_horario, h.dia_semana, h.hora_inicio, h.hora_fin, h.turno, "
                + "s.id_salon, s.nombre_salon, s.capacidad, s.referencia "
                + "FROM matricula m "
                + "JOIN estudiante e ON m.id_estudiante = e.id_estudiante "
                + "JOIN persona p ON e.id_estudiante = p.id_persona "
                + "JOIN direccion dir ON p.id_direccion = dir.id_direccion "
                + "JOIN dni d ON p.id_dni = d.id_dni "
                + "JOIN asignacion a ON m.id_asignacion = a.id_asignacion "
                + "JOIN curso c ON a.id_curso = c.id_curso "
                + "JOIN horario h ON a.id_horario = h.id_horario "
                + "JOIN salon s ON a.id_salon = s.id_salon "
                + "WHERE m.id_estudiante = ?";
        try (
                Connection con = getConnection(); PreparedStatement stMatricula = con.prepareStatement(SQL_CONSULTA);) {
            stMatricula.setLong(1, idMatricula);
            ResultSet rs = stMatricula.executeQuery();
            while (rs.next()) {
                sb.append("ID Matricula: ").append(rs.getInt("id_matricula")).append("\n");
                sb.append("Fecha Matricula: ").append(rs.getDate("fecha_matricula")).append("\n");
                sb.append("Codigo Estudiante: ").append(rs.getString("codigo_estudiante")).append("\n");
                sb.append("Email Educativo: ").append(rs.getString("email_educativo")).append("\n");
                sb.append("Nombre Estudiante: ").append(rs.getString("nombre")).append("\n");
                sb.append("Apellido Paterno: ").append(rs.getString("apellido_paterno")).append("\n");
                sb.append("Apellido Materno: ").append(rs.getString("apellido_materno")).append("\n");
                sb.append("Fecha Nacimiento: ").append(rs.getDate("fecha_nacimiento")).append("\n");
                sb.append("Telefono: ").append(rs.getString("telefono")).append("\n");
                sb.append("DNI: ").append(rs.getString("numero_dni")).append("\n");
                sb.append("Distrito: ").append(rs.getString("distrito")).append("\n");
                sb.append("Calle: ").append(rs.getString("calle")).append("\n");
                sb.append("Numero Calle: ").append(rs.getString("numero_cale")).append("\n");
                sb.append("Provincia: ").append(rs.getString("provincia")).append("\n");
                sb.append("Curso: ").append(rs.getString("nombre_curso")).append("\n");
                sb.append("Horario: ").append(rs.getString("dia_semana")).append(" de ")
                        .append(rs.getTime("hora_inicio")).append(" a ").append(rs.getTime("hora_fin")).append("\n");
                sb.append("Salon: ").append(rs.getString("nombre_salon")).append("\n");
                sb.append("--------------------\n");
            }
        } catch (Exception e) {
            System.out.println("Error al Buscar Matricula: " + e.getMessage());
        }
        return sb.toString();
    }
}
