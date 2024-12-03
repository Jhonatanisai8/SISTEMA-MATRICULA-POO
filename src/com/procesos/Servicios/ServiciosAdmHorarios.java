package com.procesos.Servicios;

import com.Modelo.entidades.Horario;
import com.Utelerias.Constantes.Utelerias;
import com.vista.frmAdmistrarHorariosView;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class ServiciosAdmHorarios
        extends Utelerias<Horario> {

    @Override
    public void establecerAnchoColumnasTabla(JTable tblTabla, int[] anchoColumnas) {
        for (int i = 0; i < anchoColumnas.length && i < tblTabla.getColumnCount(); i++) {
            TableColumn column = tblTabla.getColumnModel().getColumn(i);
            column.setPreferredWidth(anchoColumnas[i]);
        }
    }

    @Override
    public void mostrarRegistrosEnTabla(JTable tblData, String[] nombreColumnas, List<Horario> listaHorarios) {
        Object data[][] = new Object[listaHorarios.size()][nombreColumnas.length];
        for (int i = 0; i < listaHorarios.size(); i++) {
            Horario miHorario = listaHorarios.get(i);
            data[i][0] = miHorario.getIdHorario();
            data[i][1] = miHorario.getDiaSemana();
            data[i][2] = miHorario.getHoraInicio();
            data[i][3] = miHorario.getHoraFin();
            data[i][4] = miHorario.getTurno();
        }
        DefaultTableModel miModel = new DefaultTableModel(data, nombreColumnas);
        tblData.setModel(miModel);
        System.out.println("mostrando todos los horarios...");
    }

    @Override
    public void mostrarRegistroSoloTabla(JTable tblData, String[] nombreColumnas, Horario object) {
        
    }

    public static void limpiarCampos(frmAdmistrarHorariosView frmAdmistrarHorariosView) {
        frmAdmistrarHorariosView.cbxDiaSemana.setSelectedIndex(0);
        frmAdmistrarHorariosView.cbxHoraFin.setSelectedIndex(0);
        frmAdmistrarHorariosView.cbxHoraInicio.setSelectedIndex(0);
        frmAdmistrarHorariosView.cbxTurno.setSelectedIndex(0);
        frmAdmistrarHorariosView.cbxDiaSemana.requestFocus();
    }
}
