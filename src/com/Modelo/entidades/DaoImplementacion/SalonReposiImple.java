package com.Modelo.entidades.DaoImplementacion;

import com.Modelo.entidades.BaseDatos.ConexionBaseDatos;
import com.Modelo.entidades.InterfaceDao.ConsultasSQLSalon;
import com.Modelo.entidades.InterfaceDao.Repositorio;
import com.Modelo.entidades.Salon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SalonReposiImple
        implements Repositorio<Salon>, ConsultasSQLSalon {

    private Connection getConection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }

    @Override
    public List<Salon> listar() {
        List<Salon> listSalones = new ArrayList<>();
        try (Connection con = getConection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(SQL_SELECT_RONALDO)) {
            while (rs.next()) {
                Salon salon = crearSalon(rs);
                listSalones.add(salon);
            }
        } catch (Exception e) {
            System.out.println("Error al listar salones: " + e.getMessage());
        }
        return listSalones;
    }

    @Override
    public Salon porDni(Long id) {
        String SQL_BUSCAR_SALON = "SELECT id_salon,nombre_salon,capacidad,referencia FROM salon WHERE id_salon = " + id;
        Salon miSalon = null;
        try (Connection con = getConection(); Statement stnt = con.createStatement(); ResultSet rs = stnt.executeQuery(SQL_BUSCAR_SALON)) {
            if (rs.next()) {
                miSalon = crearSalon(rs);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener un salon: " + e.getMessage());
        }
        return miSalon;
    }

    @Override
    public void guardar(Salon t) {
        try (Connection con = getConection(); PreparedStatement stmt = con.prepareStatement(SQL_INSERT_SALON)) {
            stmt.setString(1, t.getNombreSalon());
            stmt.setInt(2, t.getCapacidadEstudiantes());
            stmt.setString(3, t.getReferencia());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al insertar un salon en la bd: " + e.getMessage());
        }
    }

    @Override
    public void modificar(Salon t) {
        try (Connection con = getConection(); PreparedStatement stmt = con.prepareStatement(SQL_UPDATE_SALON)) {
            stmt.setString(1, t.getNombreSalon());
            stmt.setInt(2, t.getCapacidadEstudiantes());
            stmt.setString(3, t.getReferencia());
            stmt.setLong(4, t.getIdSalon());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al modificar un salon en la bd: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(Long id) {
        try (Connection con = getConection(); PreparedStatement stmt = con.prepareStatement(SQL_DELETE_SALON)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar un salon en la bd: " + e.getMessage());
        }
    }

    private Salon crearSalon(final ResultSet rs) throws SQLException {
        Salon salon = new Salon();
        salon.setIdSalon(rs.getLong("id_salon"));
        salon.setNombreSalon(rs.getString("nombre_salon"));
        salon.setCapacidadEstudiantes(rs.getInt("capacidad"));
        salon.setReferencia(rs.getString("referencia"));
        return salon;
    }
}
