package com.Modelo.entidades.DaoImplementacion;

import com.Modelo.entidades.BaseDatos.ConexionBaseDatos;
import com.Modelo.entidades.InterfaceDao.ConsultasSQLSalon;
import com.Modelo.entidades.InterfaceDao.Repositorio;
import com.Modelo.entidades.Salon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
        String SQL_BUSCAR_SALON = "SELECT id_salon,nombre_salon,capacidad,referencia,vacantes_disponibles FROM salon WHERE id_salon = " + id;
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
            stmt.setInt(4, t.getCapacidadEstudiantes());
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
            stmt.setInt(4, t.getVacantes());
            stmt.setLong(5, t.getIdSalon());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al modificar un salon en la bd: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(Long id) {
        boolean huboExcepcion = false;
        try (Connection con = getConection(); PreparedStatement stmt = con.prepareStatement(SQL_DELETE_SALON)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            huboExcepcion = true;
        }
        if (!huboExcepcion) {
            JOptionPane.showMessageDialog(null, "Salon Eliminado Correctamente.", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "El Salon esta en uso en una Asignacion, No se Puede Eliminar.", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private Salon crearSalon(final ResultSet rs) throws SQLException {
        Salon salon = new Salon();
        salon.setIdSalon(rs.getLong("id_salon"));
        salon.setNombreSalon(rs.getString("nombre_salon"));
        salon.setCapacidadEstudiantes(rs.getInt("capacidad"));
        salon.setReferencia(rs.getString("referencia"));
        salon.setVacantes(rs.getInt("vacantes_disponibles"));
        return salon;
    }

    public DefaultTableModel listarCursosDefaultTableModel(DefaultTableModel defaultTableModel, String nombre) {
        defaultTableModel.setRowCount(0);
        final String SQL_SELECT_RONALDO = "SELECT id_salon,nombre_salon,capacidad,referencia,vacantes_disponibles FROM salon WHERE LIKE '%" + nombre + "%'";
        try (
                Connection con = getConection(); PreparedStatement stSalon = con.prepareStatement(SQL_SELECT_RONALDO); ResultSet rs = stSalon.executeQuery();) {
            ResultSetMetaData data = rs.getMetaData();
            int columnas = data.getColumnCount();
            while (rs.next()) {
                Object[] fila = new Object[columnas];
                for (int i = 1; i <= columnas; i++) {
                    fila[i - 1] = rs.getObject(i);
                }
                defaultTableModel.addRow(fila);
            }
        } catch (Exception e) {
            System.out.println("Error al listar ciertos cursos buscados: " + e.getMessage());
        }
        return defaultTableModel;
    }
}
