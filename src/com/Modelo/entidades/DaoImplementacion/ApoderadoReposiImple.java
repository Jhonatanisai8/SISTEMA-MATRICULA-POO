package com.Modelo.entidades.DaoImplementacion;

import com.Modelo.entidades.Apoderado;
import com.Modelo.entidades.BaseDatos.ConexionBaseDatos;
import com.Modelo.entidades.Direccion;
import com.Modelo.entidades.Dni;
import com.Modelo.entidades.InterfaceDao.ConsultasSQLApoderado;
import com.Modelo.entidades.InterfaceDao.Repositorio;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class ApoderadoReposiImple
        implements Repositorio<Apoderado>,
        ConsultasSQLApoderado {

    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }

    @Override

    public List<Apoderado> listar() {
        List<Apoderado> listaApoderados = new ArrayList<>();
        try (Connection con = getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(SQL_SELECT_APODERADOS)) {
            while (rs.next()) {
                Apoderado apoderado = crearApoderado(rs);
                listaApoderados.add(apoderado);
            }
        } catch (Exception e) {
            System.out.println("Error al listar los apoderados: " + e.getMessage());
        }
        return listaApoderados;
    }

    @Override
    public Apoderado porDni(Long dni) {
        Apoderado apoderado = null;
        final String SQL_SELECT_APODERADO = "SELECT "
                + "             	p.id_persona AS 'ID', "
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
                + "                a.relacion_estudiante AS 'Relacion Con Estudiante', "
                + "                a.ocupacion AS 'Ocupacion' ,"
                + "                a.estado_civil as 'Estado Civil' "
                + "            FROM persona AS p "
                + "            INNER JOIN dni AS d ON d.id_dni = p.id_dni "
                + "            INNER JOIN direccion AS di ON di.id_direccion = p.id_direccion "
                + "            INNER JOIN apoderado AS a ON a.id_apoderado = p.id_persona "
                + "            WHERE d.numero_dni LIKE  '%" + dni + "%'";
        try (Connection con = getConnection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(SQL_SELECT_APODERADO)) {
            if (rs.next()) {
                apoderado = crearApoderado(rs);
            }
        } catch (Exception e) {
            System.out.println("Erro al buscar por id: " + e.getMessage());
        }
        return apoderado;
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
    public void modificar(Apoderado apoderado) {
        try (Connection con = getConnection(); PreparedStatement stmtDni = con.prepareStatement(SQL_UPDATE_DNI); PreparedStatement stmtDirecion = con.prepareStatement(SQL_UPDATE_DIRECCION); PreparedStatement stmtPersona = con.prepareStatement(SQL_UPDATE_PERSONA); PreparedStatement stmtApoderado = con.prepareStatement(SQL_UPDATE_APODERADO)) {
            //le pasamos los parametros para el dni
            stmtDni.setString(1, apoderado.getDni().getTipoDocumentoDni());
            stmtDni.setString(2, apoderado.getDni().getNumeroDni());
            stmtDni.setLong(3, apoderado.getIdApoderado());

            //le pasamos los parametros para el direccion
            stmtDirecion.setString(1, apoderado.getDireccion().getDistrito());
            stmtDirecion.setString(2, apoderado.getDireccion().getCalle());
            stmtDirecion.setString(3, apoderado.getDireccion().getNumero());
            stmtDirecion.setString(4, apoderado.getDireccion().getProvincia());
            stmtDirecion.setLong(5, apoderado.getIdApoderado());

            //le pasamos los parametros para el persona
            stmtPersona.setString(1, apoderado.getNombre());
            stmtPersona.setString(2, apoderado.getApellidoPaterno());
            stmtPersona.setString(3, apoderado.getApellidoMaterno());
            stmtPersona.setDate(4, new Date(apoderado.getFechaNacimiento().getTime()));
            stmtPersona.setLong(5, apoderado.getIdApoderado()); //id de dni
            stmtPersona.setLong(6, apoderado.getIdApoderado());// id de direccion
            stmtPersona.setString(7, apoderado.getTelefono());
            stmtPersona.setString(8, apoderado.getEmailPersonal());
            stmtPersona.setLong(9, apoderado.getIdApoderado());

            //le passamos los parametros a consulta que actualiza el apoderado
            stmtApoderado.setString(1, apoderado.getRelacionEstudiante());
            stmtApoderado.setString(2, apoderado.getOcupacion());
            stmtApoderado.setString(3, apoderado.getEstadoCivil());
            stmtApoderado.setLong(4, apoderado.getIdApoderado());

            //ejecutamos las cunsultas 
            stmtDni.executeUpdate();
            stmtDirecion.executeUpdate();
            stmtPersona.executeUpdate();
            stmtApoderado.executeUpdate();
            System.out.println("Apoderado Modificado..");
        } catch (Exception e) {
            System.out.println("Error al modificar: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(Long id) {
        try (Connection con = getConnection(); PreparedStatement stsmPersona = con.prepareStatement(SQL_DELETE_PERSONA); PreparedStatement stsmDireccion = con.prepareStatement(SQL_DELETE_DIRECCION); PreparedStatement stsmDni = con.prepareStatement(SQL_DELETE_DNI);) {
            //le pasamos los parametros
            stsmPersona.setLong(1, id);
            stsmDireccion.setLong(1, id);
            stsmDni.setLong(1, id);
            //ejecutamos en este orden para evitar errores
            stsmPersona.executeUpdate();
            stsmDireccion.executeUpdate();
            stsmDni.executeUpdate();
            System.out.println("Eliminando apoderado.......");
        } catch (Exception e) {
            System.out.println("Error al eliminar un apoderado: " + e.getMessage());
        }
    }

    private Apoderado crearApoderado(final ResultSet rs) throws SQLException {
        Apoderado apoderado = new Apoderado();
        Dni dni = new Dni();
        Direccion direccion = new Direccion();
        //le establecemos los datos al estudiantes
        apoderado.setIdApoderado(rs.getLong("ID"));
        apoderado.setIdPersona(rs.getLong("ID"));
        apoderado.setNombre(rs.getString("Nombre"));
        apoderado.setApellidoPaterno(rs.getString("Apellido Paterno"));
        apoderado.setApellidoMaterno(rs.getString("Apellido Materno"));
        apoderado.setFechaNacimiento(rs.getDate("Fecha Nacimiento"));
        apoderado.setTelefono(rs.getString("Telefono"));
        apoderado.setEmailPersonal(rs.getString("Email Personal"));
        apoderado.setRelacionEstudiante(rs.getString("Relacion Con Estudiante"));
        apoderado.setOcupacion(rs.getString("Ocupacion"));
        apoderado.setEstadoCivil(rs.getString("Estado Civil"));
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
        apoderado.setDni(dni);
        apoderado.setDireccion(direccion);
        return apoderado;
    }
}
