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

    @Override
    public Curso porDni(Long dni) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Long curso) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
