package com.Modelo.entidades.DaoImplementacion;

import com.Modelo.entidades.BaseDatos.ConexionBaseDatos;
import com.Modelo.entidades.Direccion;
import com.Modelo.entidades.Dni;
import com.Modelo.entidades.Docente;
import com.Modelo.entidades.InterfaceDao.ConsultasSQLDocente;
import com.Modelo.entidades.InterfaceDao.ConsultasSQLEstudiante;
import com.Modelo.entidades.InterfaceDao.Repositorio;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class DocenteReposioImple
        implements Repositorio<Docente>, ConsultasSQLEstudiante, ConsultasSQLDocente {

    private Connection getConection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }

    @Override
    public List<Docente> listar() {
        List<Docente> listaDocentes = new ArrayList<>();
        try (Connection con = getConection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(SQL_SELECT_DOCENTES)) {
            while (rs.next()) {
                Docente docente = crearDocente(rs);
                listaDocentes.add(docente);
            }
        } catch (Exception e) {
            System.out.println("Error al listar los docentes: " + e.getMessage());
        }
        return listaDocentes;
    }

    @Override
    public Docente porDni(Long dni) {
        Docente docente = null;
        String parametroBusqueda = "";
        String parametroObjeto = "";
        //validacion
        if (dni <= 100) {
            parametroBusqueda = "id_docente";
            parametroObjeto = "doc";
        } else {
            parametroBusqueda = "numero_dni";
            parametroObjeto = "d";
        }
        System.out.println(parametroBusqueda);
        String SQL_BUSCAR_POR_DNI = "SELECT "
                + "    p.id_dni AS 'ID', "
                + "    p.nombre AS 'Nombre', "
                + "    p.apellido_paterno AS 'Apellido Paterno', "
                + "    p.apellido_materno AS 'Apellido Materno', "
                + "    p.fecha_nacimiento AS 'Fecha Nacimiento', "
                + "    d.tipo_documento AS 'Tipo Documento', "
                + "    d.numero_dni AS 'Numero Dni', "
                + "    di.calle AS 'Calle', "
                + "    di.numero_cale AS 'Numero Calle', "
                + "    di.distrito AS 'Distrito', "
                + "    di.provincia AS 'Provincia', "
                + "    p.telefono AS 'Telefono', "
                + "    p.email_personal AS 'Email Personal', "
                + "    doc.codigo_docente AS 'Cod Docente', "
                + "    doc.titulo_academico AS 'Titulo Academico', "
                + "    doc.anios_esperiencia AS 'Anios Exp', "
                + "    doc.email_educativo_docente AS 'Email Educativo' "
                + "FROM persona AS p "
                + "INNER JOIN dni AS d ON d.id_dni = p.id_dni  "
                + "INNER JOIN direccion AS di ON di.id_direccion = p.id_direccion  "
                + "INNER JOIN docente AS doc ON  doc.id_docente = p.id_persona "
                + "WHERE  " + parametroObjeto + "." + parametroBusqueda + "   LIKE '%" + String.valueOf(dni) + "%' ";
        try (Connection con = getConection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(SQL_BUSCAR_POR_DNI)) {
            if (rs.next()) {
                docente = crearDocente(rs);
            }
        } catch (SQLException exception) {
            System.out.println("Error al buscar docente por id: " + exception.getMessage());
        }
        System.out.println(dni);
        return docente;
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
        try (Connection con = getConection(); PreparedStatement stmtDireccion = con.prepareStatement(SQL_UPDATE_DIRECCION); PreparedStatement stmtDni = con.prepareStatement(SQL_UPDATE_DNI); PreparedStatement stmtPersona = con.prepareStatement(SQL_UPDATE_PERSONA); PreparedStatement stmtDocente = con.prepareStatement(SQL_UPDATE_DOCENTE);) {
            //pasamos los parametros a las consultas 
            //le pasamos los parametros para el dni
            stmtDni.setString(1, t.getDni().getTipoDocumentoDni());
            stmtDni.setString(2, t.getDni().getNumeroDni());
            stmtDni.setLong(3, t.getIdDocente());

            //le pasamos los parametros para el direccion
            stmtDireccion.setString(1, t.getDireccion().getDistrito());
            stmtDireccion.setString(2, t.getDireccion().getCalle());
            stmtDireccion.setString(3, t.getDireccion().getNumero());
            stmtDireccion.setString(4, t.getDireccion().getProvincia());
            stmtDireccion.setLong(5, t.getIdDocente());

            //le pasamos los parametros para el persona
            stmtPersona.setString(1, t.getNombre());
            stmtPersona.setString(2, t.getApellidoPaterno());
            stmtPersona.setString(3, t.getApellidoMaterno());
            stmtPersona.setDate(4, new Date(t.getFechaNacimiento().getTime()));
            stmtPersona.setLong(5, t.getIdDocente()); //id de dni
            stmtPersona.setLong(6, t.getIdDocente());// id de direccion
            stmtPersona.setString(7, t.getTelefono());
            stmtPersona.setString(8, t.getEmailPersonal());
            stmtPersona.setLong(9, t.getIdDocente());

            //le pasamos los parametros para el docente
            stmtDocente.setString(1, t.getCodigoDocente());
            stmtDocente.setString(2, t.getTituloAcademico());
            stmtDocente.setInt(3, t.getAniosExperiencia());
            stmtDocente.setString(4, t.getEmailEducativoDocente());
            stmtDocente.setLong(5, t.getIdDocente());

            //ejecutamos las sentencias 
            stmtDireccion.executeUpdate();
            stmtDni.executeUpdate();
            stmtPersona.executeUpdate();
            stmtDocente.executeUpdate();
            System.out.println("Docente modificado....");
        } catch (Exception e) {
            System.out.println("Error al modificar un docente: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(Long id) {
        try (Connection con = getConection(); PreparedStatement stmtDocente = con.prepareStatement(SQL_DELETE_DOCENTE); PreparedStatement stmtPersona = con.prepareStatement(SQL_DELETE_PERSONA); PreparedStatement stmtDireccion = con.prepareStatement(SQL_DELETE_DIRECCION); PreparedStatement stmtDni = con.prepareStatement(SQL_DELETE_DNI);) {
            //le asiganamos el parametro a cada sentencia
            stmtDocente.setLong(1, id);
            stmtPersona.setLong(1, id);
            stmtDireccion.setLong(1, id);
            stmtDni.setLong(1, id);
            //ejecutamos cada sentencia en orden para que no halla errores
            stmtDocente.executeUpdate();
            stmtPersona.executeUpdate();
            stmtDireccion.executeUpdate();
            stmtDni.executeUpdate();
            System.out.println("Docente eliminado....");
        } catch (Exception e) {
            System.out.println("Error al eliminar un docente: " + e.getMessage());
        }
    }

    private Docente crearDocente(final ResultSet rs) throws SQLException {
        Docente docente = new Docente();
        Dni dni = new Dni();
        Direccion direccion = new Direccion();
        docente.setIdDocente(rs.getLong("ID"));
        docente.setIdPersona(rs.getLong("ID"));
        docente.setNombre(rs.getString("Nombre"));
        docente.setApellidoPaterno(rs.getString("Apellido Paterno"));
        docente.setApellidoMaterno(rs.getString("Apellido Materno"));
        docente.setFechaNacimiento(rs.getDate("Fecha Nacimiento"));
        docente.setTelefono(rs.getString("Telefono"));
        docente.setEmailPersonal(rs.getString("Email Personal"));
        docente.setCodigoDocente(rs.getString("Cod Docente"));
        docente.setTituloAcademico(rs.getString("Titulo Academico"));
        docente.setAniosExperiencia(rs.getInt("Anios Exp"));
        docente.setEmailEducativoDocente(rs.getString("Email Educativo"));
        //dni
        dni.setIdDni(rs.getLong("ID"));
        dni.setTipoDocumentoDni(rs.getString("Tipo Documento"));
        dni.setNumeroDni(rs.getString("Numero Dni"));
        //direccion
        direccion.setIdDireccion(rs.getLong("ID"));
        direccion.setCalle(rs.getString("Calle"));
        direccion.setNumero(rs.getString("Numero Calle"));
        direccion.setDistrito(rs.getString("Distrito"));
        direccion.setProvincia(rs.getString("Provincia"));
        //establemos al docente
        docente.setDni(dni);
        docente.setDireccion(direccion);
        return docente;
    }

}
