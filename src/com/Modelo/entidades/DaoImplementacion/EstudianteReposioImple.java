package com.Modelo.entidades.DaoImplementacion;

import com.Modelo.entidades.BaseDatos.ConexionBaseDatos;
import com.Modelo.entidades.Direccion;
import com.Modelo.entidades.Dni;
import com.Modelo.entidades.Estudiante;
import com.Modelo.entidades.InterfaceDao.ConsultasSQLEstudiante;
import com.Modelo.entidades.InterfaceDao.Repositorio;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class EstudianteReposioImple
        implements Repositorio<Estudiante>,
        ConsultasSQLEstudiante {

    private Connection getConection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }

    @Override
    public List<Estudiante> listar() {
        List<Estudiante> listaEstudiantes = new ArrayList<>();
        try (Connection con = getConection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(SQL_SELECT_ESTUDIANTES)) {
            while (rs.next()) {
                Estudiante e = crearEstudiante(rs);
                //agregamos al arraylist
                listaEstudiantes.add(e);
            }
        } catch (Exception e) {
            System.out.println("Error al listar estudiantes: "+e.getMessage());
        }
        return listaEstudiantes;
    }

    private Estudiante crearEstudiante(final ResultSet rs) throws SQLException {
        Estudiante e = new Estudiante();
        Dni dni = new Dni();
        Direccion direccion = new Direccion();
        //le establecemos los datos al estudiantes
        e.setIdEstudiante(rs.getLong("ID"));
        e.setIdPersona(rs.getLong("ID"));
        e.setNombre(rs.getString("Nombre"));
        e.setApellidoPaterno(rs.getString("Apellido Paterno"));
        e.setApellidoMaterno(rs.getString("Apellido Materno"));
        e.setFechaNacimiento(rs.getDate("Fecha Nacimiento"));
        e.setTelefono(rs.getString("Telefono"));
        e.setEmailPersonal(rs.getString("Email Personal"));
        e.setEmailEducativo(rs.getString("Email Educativo"));
        e.setCodigoEstudiante(rs.getString("Cod Estudiante"));
        //le establecemos los datos al dni
        dni.setIdDni(rs.getLong("ID"));
        dni.setTipoDocumentoDni(rs.getString("Tipo Documento"));
        dni.setNumeroDni(rs.getString("Nº de Dni"));
        //le establecemos los datos a la direccion
        direccion.setIdDireccion(rs.getLong("ID"));
        direccion.setCalle(rs.getString("Calle"));
        direccion.setNumero(rs.getString("Nº Calle"));
        direccion.setDistrito(rs.getString("Distrito"));
        direccion.setProvincia(rs.getString("Provincia"));
        //le establecemos dni y la direccion al estudiante
        e.setDni(dni);
        e.setDireccion(direccion);
        return e;
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
