package com.procesos.Servicios;

import com.Modelo.entidades.Salon;
import com.vista.frmAdmistrarSalonesView;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ServiciosAdmSalones {

    public static void mostrarSalonesEnTabla(frmAdmistrarSalonesView frAdmistrarSalonesView,
            String[] COLUMNAS, List<Salon> listsSalon) {
        Object[][] data = new Object[listsSalon.size()][COLUMNAS.length];
        for (int i = 0; i < listsSalon.size(); i++) {
            Salon miSalon = listsSalon.get(i);
            data[i][0] = miSalon.getIdSalon();
            data[i][1] = miSalon.getNombreSalon();
            data[i][2] = miSalon.getCapacidadEstudiantes();
            data[i][3] = miSalon.getReferencia();
        }
        //creamo el modelo 
        DefaultTableModel modelo = new DefaultTableModel(data, COLUMNAS);
        frAdmistrarSalonesView.tblData.setModel(modelo);
        System.out.println("Mostrando todos los salones.....");
    }

    public static void mostrarSalonEnTabla(frmAdmistrarSalonesView frAdmistrarSalonesView,
            String[] COLUMNAS, Salon miSalon) {
        Object data[] = new Object[COLUMNAS.length];
        data[0] = miSalon.getIdSalon();
        data[1] = miSalon.getNombreSalon();
        data[2] = miSalon.getCapacidadEstudiantes();
        data[3] = miSalon.getReferencia();

        DefaultTableModel modeloTabla = new DefaultTableModel(new Object[][]{data}, COLUMNAS);
        frAdmistrarSalonesView.tblData.setModel(modeloTabla);
        System.out.println("Mostrando un solo salon...");
    }
}
