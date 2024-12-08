package com.Modelo.entidades.DaoImplementacion;

import com.Modelo.entidades.BaseDatos.ConexionBaseDatos;
import com.Modelo.entidades.Curso;
import com.Modelo.entidades.InterfaceDao.ConsultasSQLCurso;
import com.Modelo.entidades.InterfaceDao.Repositorio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
    public void eliminar(Long curso) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

}
