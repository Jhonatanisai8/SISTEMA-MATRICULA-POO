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
            System.out.println("Error al listar estudiantes: " + e.getMessage());
        }
        return listaEstudiantes;
    }

    @Override
    public Estudiante porDni(Long dni) {
        Estudiante estudiante = null;
        String SQL_SELECT_BUSCAR_ESTUDIANTE = "SELECT "
                + "            	p.id_persona AS 'ID', "
                + "                p.nombre AS 'Nombre', "
                + "                p.apellido_paterno AS 'Apellido Paterno', "
                + "                p.apellido_materno AS 'Apellido Materno', "
                + "                p.fecha_nacimiento AS 'Fecha Nacimiento', "
                + "                d.tipo_documento AS 'Tipo Documento', "
                + "                d.numero_dni AS 'Nº de Dni', "
                + "                di.calle AS 'Calle', "
                + "                di.numero_cale AS 'Nº Calle', "
                + "                di.distrito AS 'Distrito', "
                + "                di.provincia AS 'Provincia', "
                + "                p.telefono AS 'Telefono', "
                + "                p.email_personal AS 'Email Personal', "
                + "                e.codigo_estudiante AS 'Cod Estudiante', "
                + "                e.email_educativo AS 'Email Educativo' "
                + "            FROM persona AS p "
                + "            INNER JOIN dni AS d ON d.id_dni = p.id_dni "
                + "            INNER JOIN direccion AS di ON di.id_direccion = p.id_direccion "
                + "            INNER JOIN estudiante AS e ON e.id_estudiante = p.id_persona "
                + "            WHERE d.numero_dni LIKE  '%" + String.valueOf(dni) + "%' ";
        try (Connection con = getConection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(SQL_SELECT_BUSCAR_ESTUDIANTE)) {
            if (rs.next()) {
                estudiante = crearEstudiante(rs);
            }
        } catch (SQLException exception) {
            System.out.println("Error al buscar por id: " + exception.getMessage());
        }
        return estudiante;
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
        try (Connection con = getConection(); PreparedStatement stmtEstudiante = con.prepareStatement(SQL_DELETE_ESTUDIANTE); PreparedStatement stmtPersona = con.prepareStatement(SQL_DELETE_PERSONA); PreparedStatement stmtDireccion = con.prepareStatement(SQL_DELETE_DIRECCION); PreparedStatement stmtDni = con.prepareStatement(SQL_DELETE_DNI);) {
            //le asiganamos el parametro a cada sentencia
            stmtEstudiante.setLong(1, id);
            stmtPersona.setLong(1, id);
            stmtDireccion.setLong(1, id);
            stmtDni.setLong(1, id);
            //ejecutamos cada sentencia en orden para que no halla errores
            stmtEstudiante.executeUpdate();
            stmtPersona.executeUpdate();
            stmtDireccion.executeUpdate();
            stmtDni.executeUpdate();
            System.out.println("Eliminando.....");
        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
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
}
