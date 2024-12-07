package com.Modelo.entidades.DaoImplementacion;

import com.Modelo.entidades.BaseDatos.ConexionBaseDatos;
import com.Modelo.entidades.InterfaceDao.ConsultasSQLMatricula;
import com.Modelo.entidades.InterfaceDao.Repositorio;
import com.Modelo.entidades.Matricula;
import java.util.List;
import java.sql.*;

public class MatriculaRepoImple
        implements ConsultasSQLMatricula,
        Repositorio<Matricula> {

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

}
