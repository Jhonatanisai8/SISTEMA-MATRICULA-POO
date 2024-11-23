package com.procesos.Servicios;

import com.vista.frmListadoEstudiantesView;
import java.util.Random;
import javax.swing.table.DefaultTableModel;

public class ServiciosEstudiante {

    public static String generarCorreoEducatico(String nombre, String apellido1, String apellido2) {
        return nombre.substring(0, 3).concat(apellido1.substring(0, 3)).concat(apellido2.substring(0, 3)).concat("@jndvirtual.edu.pe").toLowerCase();
    }

    public static String generarCodigoEstudiante(String nombre, String apellido) {
        Random numeroRandon = new Random();
        int n = numeroRandon.nextInt(900) + 100;
        return String.valueOf(n).concat(nombre.substring(0, 3)).concat(apellido.substring(0, 3)).concat("EST2402").toUpperCase();
    }

    public static void mostrarEstudiantesEnTabla(frmListadoEstudiantesView frmEstudiantesView, String titulosColumnas[]) {
        DefaultTableModel modeloTabla = new DefaultTableModel(null, titulosColumnas);
        frmEstudiantesView.btlData.setModel(modeloTabla);
    }
}
