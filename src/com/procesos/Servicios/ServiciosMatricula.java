package com.procesos.Servicios;

import com.Modelo.entidades.Estudiante;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class ServiciosMatricula {

    public static void establecerAnchoColumnasTabla(JTable table, int[] columnas) {
        for (int i = 0; i < columnas.length && i < table.getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnas[i]);
        }
    }

    public static void mostrarEstudiantesEnTabla(
            JTable tblEstudiantes, String Columnas[], List<Estudiante> listaEstudiantes
    ) {
        Object data[][] = new Object[listaEstudiantes.size()][Columnas.length];
        for (int i = 0; i < listaEstudiantes.size(); i++) {
            Estudiante estudiante = listaEstudiantes.get(i);
            data[i][0] = estudiante.getIdEstudiante();
            //para mostrar el nombre completo
            data[i][1] = estudiante.getNombre() + " " + estudiante.getApellidoPaterno() + " " + estudiante.getApellidoMaterno();
            data[i][2] = estudiante.getCodigoEstudiante();
        }
        DefaultTableModel defaultTableModel = new DefaultTableModel(data, Columnas);
        tblEstudiantes.setModel(defaultTableModel);
        System.out.println("Listando en tabla los estudiantes.....");
    }
}
