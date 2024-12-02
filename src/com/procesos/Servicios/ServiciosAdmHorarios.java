package com.procesos.Servicios;

import com.Modelo.entidades.Horario;
import com.vista.frmAdmistrarHorariosView;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class ServiciosAdmHorarios {

    public static void establecerAnchoColumnasTabla(JTable table, int[] widths) {
        for (int i = 0; i < widths.length && i < table.getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth(widths[i]);
        }
    }

    public static void mostrarHorarios(frmAdmistrarHorariosView frmAdmistrarHorariosView,
            String[] COLUMNAS, List<Horario> listaHorarios) {
        Object data[][] = new Object[listaHorarios.size()][COLUMNAS.length];
        for (int i = 0; i < listaHorarios.size(); i++) {
            Horario miHorario = listaHorarios.get(i);
            data[i][0] = miHorario.getIdHorario();
            data[i][1] = miHorario.getDiaSemana();
            data[i][2] = miHorario.getHoraInicio();
            data[i][3] = miHorario.getHoraFin();
            data[i][4] = miHorario.getTurno();
        }
        DefaultTableModel miModel = new DefaultTableModel(data, COLUMNAS);
        frmAdmistrarHorariosView.tblDataHorarios.setModel(miModel);
        System.out.println("mostrando todos los horarios...");
    }

    public static void limpiarCampos(frmAdmistrarHorariosView frmAdmistrarHorariosView) {
        frmAdmistrarHorariosView.cbxDiaSemana.setSelectedIndex(0);
        frmAdmistrarHorariosView.cbxHoraFin.setSelectedIndex(0);
        frmAdmistrarHorariosView.cbxHoraInicio.setSelectedIndex(0);
        frmAdmistrarHorariosView.cbxTurno.setSelectedIndex(0);
        frmAdmistrarHorariosView.cbxDiaSemana.requestFocus();
    }
}
