package com.procesos.Servicios;

import com.Modelo.entidades.Salon;
import com.vista.frmAdmistrarSalonesView;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class ServiciosAdmSalones {

    public static void establecerAnchoColumnasTabla(JTable table, int[] widths) {
        for (int i = 0; i < widths.length && i < table.getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth(widths[i]);
        }
    }

    public static void mostrarSalonesEnTabla(JTable tblData,
            String[] COLUMNAS, List<Salon> listsSalon) {
        Object[][] data = new Object[listsSalon.size()][COLUMNAS.length];
        for (int i = 0; i < listsSalon.size(); i++) {
            Salon miSalon = listsSalon.get(i);
            data[i][0] = miSalon.getIdSalon();
            data[i][1] = miSalon.getNombreSalon();
            data[i][2] = miSalon.getCapacidadEstudiantes();
            data[i][3] = miSalon.getReferencia();
            data[i][4] = miSalon.getCapacidadEstudiantes();
        }
        //creamo el modelo 
        DefaultTableModel modelo = new DefaultTableModel(data, COLUMNAS);
        tblData.setModel(modelo);
        System.out.println("Mostrando todos los salones.....");
    }

    public static void mostrarSalonEnTabla(JTable tblData,
            String[] COLUMNAS, Salon miSalon) {
        Object data[] = new Object[COLUMNAS.length];
        data[0] = miSalon.getIdSalon();
        data[1] = miSalon.getNombreSalon();
        data[2] = miSalon.getCapacidadEstudiantes();
        data[3] = miSalon.getReferencia();
        data[4] = miSalon.getCapacidadEstudiantes();

        DefaultTableModel modeloTabla = new DefaultTableModel(new Object[][]{data}, COLUMNAS);
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
