package com.Modelo.entidades.DaoImplementacion;

import com.Modelo.entidades.BaseDatos.ConexionBaseDatos;
import com.Modelo.entidades.Estudiante;
import com.Modelo.entidades.InterfaceDao.ConsultasSQLEstudiante;
import com.Modelo.entidades.InterfaceDao.Repositorio;
import java.util.List;
import java.sql.*;

public class EstudianteReposioImple
        implements Repositorio<Estudiante>,
        ConsultasSQLEstudiante {

    private Connection getConection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }

    @Override
    public List<Estudiante> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Estudiante porDni(Long dni) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void guardar(Estudiante t) {
        try (Connection con = getConection(); PreparedStatement stmt_dni = con.prepareStatement(SQL_INSERT_DNI); PreparedStatement stmt_direccion = con.prepareStatement(SQL_INSERT_DIRECCION); PreparedStatement stmt_persona = con.prepareStatement(SQL_INSERT_PERSONA); PreparedStatement stmt_estudiante = con.prepareStatement(SQL_INSERT_ESTUDIANTE);) {
            //le pasamos los parametros para el dni
            stmt_dni.setString(1, t.getDni().getTipoDocumentoDni());
            stmt_dni.setString(2, t.getDni().getNumeroDni());

            //le pasamos los parametros para el direccion
            stmt_direccion.setString(1, t.getDireccion().getDistrito());
            stmt_direccion.setString(2, t.getDireccion().getCalle());
            stmt_direccion.setString(3, t.getDireccion().getNumero());
            stmt_direccion.setString(4, t.getDireccion().getProvincia());

            //le pasamos los parametros para el persona
            stmt_persona.setString(1, t.getNombre());
            stmt_persona.setString(2, t.getApellidoPaterno());
            stmt_persona.setString(3, t.getApellidoMaterno());
            stmt_persona.setDate(4, new Date(t.getFechaNacimiento().getTime()));
            stmt_persona.setString(5, t.getTelefono());
            stmt_persona.setString(6, t.getEmailPersonal());

            //le pasamos los parametros para el estudiante
            stmt_estudiante.setString(1, t.getCodigoEstudiante());
            stmt_estudiante.setString(2, t.getEmailEducativo());

            //ejecutamos las sentencias 
            stmt_dni.executeUpdate();
            stmt_direccion.executeUpdate();
            stmt_persona.executeUpdate();
            stmt_estudiante.executeUpdate();
            System.out.println("Guardado Correctamente");
        } catch (Exception e) {
            System.out.println("Error al insertar un estudiante: " + e.getMessage());
        }
    }

    @Override
    public void modificar(Estudiante t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
