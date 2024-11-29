package com.Modelo.entidades.DaoImplementacion;

import com.Modelo.entidades.Apoderado;
import com.Modelo.entidades.BaseDatos.ConexionBaseDatos;
import com.Modelo.entidades.InterfaceDao.ConsultasSQLApoderado;
import com.Modelo.entidades.InterfaceDao.Repositorio;
import java.util.List;
import java.sql.*;

public class ApoderadoReposiImple
        implements Repositorio<Apoderado>,
        ConsultasSQLApoderado {

    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }

    @Override

    public List<Apoderado> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Apoderado porDni(Long dni) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void guardar(Apoderado apoderado) {
        try (Connection con = getConnection(); PreparedStatement stmtDni = con.prepareStatement(SQL_INSERT_DNI); PreparedStatement stmDireccion = con.prepareStatement(SQL_INSERT_DIRECCION); PreparedStatement stmtPersona = con.prepareStatement(SQL_INSERT_PERSONA); PreparedStatement stmtApoderado = con.prepareStatement(SQL_INSERT_APODERADO);) {

            //le pasamos los parametros para el dni
            stmtDni.setString(1, apoderado.getDni().getTipoDocumentoDni());
            stmtDni.setString(2, apoderado.getDni().getNumeroDni());

            //le pasamos los parametros para el direccion
            stmDireccion.setString(1, apoderado.getDireccion().getDistrito());
            stmDireccion.setString(2, apoderado.getDireccion().getCalle());
            stmDireccion.setString(3, apoderado.getDireccion().getNumero());
            stmDireccion.setString(4, apoderado.getDireccion().getProvincia());

            //le pasamos los parametros para el persona
            stmtPersona.setString(1, apoderado.getNombre());
            stmtPersona.setString(2, apoderado.getApellidoPaterno());
            stmtPersona.setString(3, apoderado.getApellidoMaterno());
            stmtPersona.setDate(4, new Date(apoderado.getFechaNacimiento().getTime()));
            stmtPersona.setString(5, apoderado.getTelefono());
            stmtPersona.setString(6, apoderado.getEmailPersonal());

            //le pasamos parametros al apoderado
            stmtApoderado.setString(1, apoderado.getRelacionEstudiante());
            stmtApoderado.setString(2, apoderado.getOcupacion());
            stmtApoderado.setString(3, apoderado.getEstadoCivil());

            //ejecutamos en orden las sentencias sql 
            stmtDni.executeUpdate();
            stmDireccion.executeUpdate();
            stmtPersona.executeUpdate();
            stmtApoderado.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al insertar un apoderado: " + e.getMessage());
        }
    }

    @Override
    public void modificar(Apoderado t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
