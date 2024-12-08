package com.Modelo.entidades.DaoImplementacion;

import com.Modelo.entidades.BaseDatos.ConexionBaseDatos;
import com.Modelo.entidades.Curso;
import com.Modelo.entidades.InterfaceDao.ConsultasSQLCurso;
import com.Modelo.entidades.InterfaceDao.Repositorio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CursoReposiImple
        implements Repositorio<Curso>,
        ConsultasSQLCurso {
    
    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }
    
    @Override
    public List<Curso> listar() {
        List<Curso> listaCursos = new ArrayList<>();
        try (
                Connection con = getConnection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(SQL_SELECT_CURSOS)) {
            while (rs.next()) {
                Curso miCurso = crearCurso(rs);
                listaCursos.add(miCurso);
            }
        } catch (Exception e) {
            System.out.println("Error al listar cursos: " + e.getMessage());
        }
        return listaCursos;
    }
    
    @Override
    public Curso porDni(Long dni) {
        Curso curso = null;
        final String CONSULTA_SQL_SELECT_CURSO = "SELECT  "
                + "id_curso AS ID,  "
                + "codigo_curso AS CODIGO,  "
                + "nombre_curso AS NOMBRE_CURSO,  "
                + "descripcion AS DESCRIPCION,  "
                + "grado AS GRADO,  "
                + "nivel  AS NIVEL "
                + "from curso WHERE id_curso = " + dni;
        try (
                Connection con = getConnection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(CONSULTA_SQL_SELECT_CURSO);) {
            if (rs.next()) {
                curso = crearCurso(rs);
            }
        } catch (Exception e) {
            System.out.println("Error al buscar Curso: " + e.getMessage());
        }
        return curso;
    }
    
    @Override
    public void guardar(Curso curso) {
        try (
                Connection con = getConnection(); PreparedStatement st = con.prepareStatement(SQL_INSERT_CURSO);) {
            //le establecemos los parametros 
            st.setString(1, curso.getCodigoCurso());
            st.setString(2, curso.getNombreCurso());
            st.setString(3, curso.getDescripcion());
            st.setInt(4, curso.getGrado());
            st.setString(5, curso.getNivel());
            //ejecutamos
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("error al insertar un curso: " + e.getMessage());
        }
    }
    
    @Override
    public void modificar(Curso curso) {
        try (
                Connection con = getConnection(); PreparedStatement st = con.prepareStatement(SQL_UPDATE_CURSO);) {
            //le establecemos los parametros 
            st.setString(1, curso.getCodigoCurso());
            st.setString(2, curso.getNombreCurso());
            st.setString(3, curso.getDescripcion());
            st.setInt(4, curso.getGrado());
            st.setLong(5, curso.getIdCurso());
            //ejecutamos
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("error al modificar un curso: " + e.getMessage());
        }
    }
    
    @Override
    public void eliminar(Long id) {
        boolean huboExcepcion = false;
        try (
                Connection con = getConnection(); PreparedStatement stEliminar = con.prepareStatement(SQL_DELETE_CURSO);) {
            stEliminar.setLong(1, id);
            stEliminar.executeUpdate();
        } catch (Exception e) {
            huboExcepcion = true;
            System.out.println("Hubo Excepcion");
        }
        
        if (!huboExcepcion) {
            JOptionPane.showMessageDialog(null, "Curso Eliminado Correctamente.", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "El curso esta en uso en una Asignacion, No se Puede Eliminar.", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    private Curso crearCurso(final ResultSet rs) throws SQLException {
        Curso miCurso = new Curso();
        miCurso.setIdCurso(rs.getLong("ID"));
        miCurso.setCodigoCurso(rs.getString("CODIGO"));
        miCurso.setNombreCurso(rs.getString("NOMBRE_CURSO"));
        miCurso.setDescripcion(rs.getString("DESCRIPCION"));
        miCurso.setGrado(rs.getInt("GRADO"));
        miCurso.setNivel(rs.getString("NIVEL"));
        return miCurso;
    }
    
    public DefaultTableModel listarCursosDefaultTableModel(DefaultTableModel defaultTableModel, String nombre) {
        defaultTableModel.setRowCount(0);
        String SQL_BUSCAR = "SELECT id_curso,codigo_curso,nombre_curso,descripcion,grado,nivel FROM curso WHERE nombre_curso  LIKE '%" + nombre + "%'";
        try (
                Connection con = getConnection(); PreparedStatement stCurso = con.prepareStatement(SQL_BUSCAR); ResultSet rs = stCurso.executeQuery();) {
            ResultSetMetaData data = rs.getMetaData();
            int columnas = data.getColumnCount();
            while (rs.next()) {
                Object[] fila = new Object[columnas];
                for (int i = 1; i <= columnas; i++) {
                    fila[i - 1] = rs.getObject(i);
                }
                defaultTableModel.addRow(fila);
            }
        } catch (Exception e) {
            System.out.println("Error al listar ciertos cursos buscados: " + e.getMessage());
        }
        return defaultTableModel;
    }
    
}
