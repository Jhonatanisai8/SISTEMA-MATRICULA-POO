package com.procesos.Servicios;

import com.Modelo.entidades.Estudiante;
import com.vista.frmListadoEstudiantesView;
import java.util.List;
import java.util.Random;
import javax.swing.JTable;
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

    public static void mostrarEstudiantesEnTabla(frmListadoEstudiantesView frmEstudiantesView, String titulosColumnas[], List<Estudiante> listaEstudiantes) {
        Object data[][] = new Object[listaEstudiantes.size()][titulosColumnas.length];

        for (int i = 0; i < listaEstudiantes.size(); i++) {
            Estudiante estudiante = listaEstudiantes.get(i);  // Obtener el estudiante correspondiente a la fila i
            data[i][0] = estudiante.getIdEstudiante();
            data[i][1] = estudiante.getNombre();
            data[i][2] = estudiante.getApellidoPaterno();
            data[i][3] = estudiante.getApellidoMaterno();
            data[i][4] = estudiante.getFechaNacimiento();
            data[i][5] = estudiante.getDni().getTipoDocumentoDni();
            data[i][6] = estudiante.getDni().getNumeroDni();
            data[i][7] = estudiante.getDireccion().getCalle();
            data[i][8] = estudiante.getDireccion().getNumero();
            data[i][9] = estudiante.getDireccion().getDistrito();
            data[i][10] = estudiante.getDireccion().getProvincia();
            data[i][11] = estudiante.getTelefono();
            data[i][12] = estudiante.getEmailPersonal();
            data[i][13] = estudiante.getCodigoEstudiante();
            data[i][14] = estudiante.getEmailEducativo();
        }

        DefaultTableModel modeloTabla = new DefaultTableModel(data, titulosColumnas);
        frmEstudiantesView.btlData.setModel(modeloTabla);

        // Imprimir mensaje de confirmación
        System.out.println("Listando en tabla todos los estudiantes.....");
    }

    public static void mostrarEstudiantesEnTabla(JTable tblData, String titulosColumnas[], Estudiante estudiante) {
        Object[] data = new Object[titulosColumnas.length];

        data[0] = estudiante.getIdEstudiante();
        data[1] = estudiante.getNombre();
        data[2] = estudiante.getApellidoPaterno();
        data[3] = estudiante.getApellidoMaterno();
        data[4] = estudiante.getFechaNacimiento();
        data[5] = estudiante.getDni().getTipoDocumentoDni();
        data[6] = estudiante.getDni().getNumeroDni();
        data[7] = estudiante.getDireccion().getCalle();
        data[8] = estudiante.getDireccion().getNumero();
        data[9] = estudiante.getDireccion().getDistrito();
        data[10] = estudiante.getDireccion().getProvincia();
        data[11] = estudiante.getTelefono();
        data[12] = estudiante.getEmailPersonal();
        data[13] = estudiante.getCodigoEstudiante();
        data[14] = estudiante.getEmailEducativo();

        DefaultTableModel modeloTabla = new DefaultTableModel(new Object[][]{data}, titulosColumnas);

        tblData.setModel(modeloTabla);

        System.out.println("Listando en tabla un solo estudiante.....");
    }

}
