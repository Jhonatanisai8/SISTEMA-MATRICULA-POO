package com.procesos.Servicios;

import com.Modelo.entidades.Salon;
import com.Utelerias.Constantes.Utelerias;
import com.vista.frmAdmistrarSalonesView;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class ServiciosAdmSalones
        extends Utelerias<Salon> {

    @Override
    public void establecerAnchoColumnasTabla(JTable tblTabla, int[] anchoColumnas) {
        for (int i = 0; i < anchoColumnas.length && i < tblTabla.getColumnCount(); i++) {
            TableColumn column = tblTabla.getColumnModel().getColumn(i);
            column.setPreferredWidth(anchoColumnas[i]);
        }
    }

    @Override
    public void mostrarRegistrosEnTabla(JTable tblData, String[] nombreColumnas, List<Salon> listaSalones) {
        Object[][] data = new Object[listaSalones.size()][nombreColumnas.length];
        for (int i = 0; i < listaSalones.size(); i++) {
            Salon miSalon = listaSalones.get(i);
            data[i][0] = miSalon.getIdSalon();
            data[i][1] = miSalon.getNombreSalon();
            data[i][2] = miSalon.getCapacidadEstudiantes();
            data[i][3] = miSalon.getReferencia();
            data[i][4] = miSalon.getVacantes();
        }
        //creamo el modelo 
        DefaultTableModel modelo = new DefaultTableModel(data, nombreColumnas);
        tblData.setModel(modelo);
        System.out.println("Mostrando todos los salones.....");
    }

    @Override
    public void mostrarRegistroSoloTabla(JTable tblData, String[] nombreColumnas, Salon miSalon) {
        Object data[] = new Object[nombreColumnas.length];
        data[0] = miSalon.getIdSalon();
        data[1] = miSalon.getNombreSalon();
        data[2] = miSalon.getCapacidadEstudiantes();
        data[3] = miSalon.getReferencia();
        data[4] = miSalon.getCapacidadEstudiantes();

        DefaultTableModel modeloTabla = new DefaultTableModel(new Object[][]{data}, nombreColumnas);
        tblData.setModel(modeloTabla);
        System.out.println("Mostrando un solo salon...");
    }

    public static void limpiarCampos(frmAdmistrarSalonesView frmAdmistrarSalonesView) {
        frmAdmistrarSalonesView.txtNombreSalon.setText("");
        frmAdmistrarSalonesView.txtReferenciaSalon.setText("");
        frmAdmistrarSalonesView.spnCapacidad.setValue(0);
        frmAdmistrarSalonesView.txtNombreSalon.requestFocus();
    }
}
