package com.Modelo.entidades.DaoImplementacion;

import com.Modelo.entidades.BaseDatos.ConexionBaseDatos;
import com.Modelo.entidades.Docente;
import com.Modelo.entidades.InterfaceDao.ConsultasSQLDocente;
import com.Modelo.entidades.InterfaceDao.ConsultasSQLEstudiante;
import com.Modelo.entidades.InterfaceDao.Repositorio;
import java.util.List;
import java.sql.*;

public class DocenteReposioImple
        implements Repositorio<Docente>, ConsultasSQLEstudiante, ConsultasSQLDocente {

    private Connection getConection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }

    @Override
    public List<Docente> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Docente porDni(Long dni) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void guardar(Docente t) {
        try (Connection con = getConection(); PreparedStatement stmtDireccion = con.prepareStatement(SQL_INSERT_DIRECCION); PreparedStatement stmtDni = con.prepareStatement(SQL_INSERT_DNI); PreparedStatement stmtPersona = con.prepareStatement(SQL_INSERT_PERSONA); PreparedStatement stmtDocente = con.prepareStatement(SQL_INSERT_DOCENTE);) {
            //pasamos los parametros a las consultas 
//le pasamos los parametros para el dni
            stmtDni.setString(1, t.getDni().getTipoDocumentoDni());
            stmtDni.setString(2, t.getDni().getNumeroDni());

            //le pasamos los parametros para el direccion
            stmtDireccion.setString(1, t.getDireccion().getDistrito());
            stmtDireccion.setString(2, t.getDireccion().getCalle());
            stmtDireccion.setString(3, t.getDireccion().getNumero());
            stmtDireccion.setString(4, t.getDireccion().getProvincia());

            //le pasamos los parametros para el persona
            stmtPersona.setString(1, t.getNombre());
            stmtPersona.setString(2, t.getApellidoPaterno());
            stmtPersona.setString(3, t.getApellidoMaterno());
            stmtPersona.setDate(4, new Date(t.getFechaNacimiento().getTime()));
            stmtPersona.setString(5, t.getTelefono());
            stmtPersona.setString(6, t.getEmailPersonal());
            //le pasamos los parametros para el docente
            stmtDocente.setString(1, t.getCodigoDocente());
            stmtDocente.setString(2, t.getTituloAcademico());
            stmtDocente.setInt(3, t.getAniosExperiencia());
            stmtDocente.setString(4, t.getEmailEducativoDocente());

            //ejecutamos las sentencias 
            stmtDireccion.executeUpdate();
            stmtDni.executeUpdate();
            stmtPersona.executeUpdate();
            stmtDocente.executeUpdate();
            System.out.println("Docente se guardo en la base de datos...");
        } catch (Exception e) {
            System.out.println("Error al insertar un docente: " + e.getMessage());
        }
    }

    @Override
    public void modificar(Docente t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
