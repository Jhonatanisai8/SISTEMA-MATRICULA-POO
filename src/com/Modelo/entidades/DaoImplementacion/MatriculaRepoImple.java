package com.Modelo.entidades.DaoImplementacion;

import com.Modelo.entidades.BaseDatos.ConexionBaseDatos;
import com.Modelo.entidades.InterfaceDao.ConsultasSQLMatricula;
import com.Modelo.entidades.InterfaceDao.Repositorio;
import com.Modelo.entidades.Matricula;
import java.util.List;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.Utelerias.Constantes.ConstantesFormulariosMatricula;

public class MatriculaRepoImple
        implements ConsultasSQLMatricula,
        Repositorio<Matricula>,
        ConstantesFormulariosMatricula {

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

    public void listarInformacion(JTable tblData) {
        try (Connection con = getConnection(); PreparedStatement pr = con.prepareStatement(SQL_SELECT_ASIGNACIONES); ResultSet rs = pr.executeQuery();) {
            //obtenemos las columnas 
            DefaultTableModel modelo = new DefaultTableModel(ENCABEZADOS_TABLA_ASIGNACIONES, 0);
            tblData.setModel(modelo);
            ResultSetMetaData data = rs.getMetaData();
            int nColumnas = data.getColumnCount();
            while (rs.next()) {
                Object[] fila = new Object[nColumnas];
                for (int i = 1; i <= nColumnas; i++) {
                    fila[i - 1] = rs.getObject(i);
                }
                modelo.addRow(fila);
            }
            System.out.println("Listando informacion de asignaciones");
        } catch (Exception e) {
            System.out.println("Error al listar cierta informacion de la tabla de asiganciones: " + e.getMessage());
        }

    }
}
