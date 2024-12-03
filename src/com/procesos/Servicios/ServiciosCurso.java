package com.procesos.Servicios;

import com.Modelo.entidades.Curso;
import com.Utelerias.Constantes.Utelerias;
import com.vista.frmAdmistrarCursos;
import java.util.List;
import java.util.Random;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class ServiciosCurso
        extends Utelerias<Curso> {

    @Override
    public void establecerAnchoColumnasTabla(JTable tblTabla, int[] anchoColumnas) {
        for (int i = 0; i < anchoColumnas.length && i < tblTabla.getColumnCount(); i++) {
            TableColumn column = tblTabla.getColumnModel().getColumn(i);
            column.setPreferredWidth(anchoColumnas[i]);
        }
    }

    @Override
    public void mostrarRegistrosEnTabla(JTable tblData, String[] nombreColumnas, List<Curso> listaCursos) {
        Object data[][] = new Object[listaCursos.size()][nombreColumnas.length];
        for (int i = 0; i < listaCursos.size(); i++) {
            Curso miCurso = listaCursos.get(i);
            data[i][0] = miCurso.getIdCurso();
            data[i][1] = miCurso.getCodigoCurso();
            data[i][2] = miCurso.getNombreCurso();
            data[i][3] = miCurso.getDescripcion();
            data[i][4] = miCurso.getGrado();
            data[i][5] = miCurso.getNivel();
        }
        DefaultTableModel miModel = new DefaultTableModel(data, nombreColumnas);
        tblData.setModel(miModel);
        System.out.println("MOstrando los cursos en tabla...");
    }

    @Override
    public void mostrarRegistroSoloTabla(JTable tblData, String[] nombreColumnas, Curso object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static String generarCodigoCurso(String curso) {
        Random r = new Random();
        int n = r.nextInt(10) + 1;
        String letras = "QWERTYUIOPASDFGHJKLÑZXCVBNM";
        char letra = letras.charAt(n);
        return String.valueOf(curso.substring(0, 5).toUpperCase().concat(String.valueOf(letra + "00")).concat(String.valueOf(n)));
    }

    public static void limpiarCampos(frmAdmistrarCursos frmAdmistrarCursos) {
        frmAdmistrarCursos.txtBuscar.setText("");
        frmAdmistrarCursos.txtDiscripcion.setText("");
        frmAdmistrarCursos.txtNombreCurso.setText("");
        frmAdmistrarCursos.cbxGrado.setSelectedIndex(0);
        frmAdmistrarCursos.txtNombreCurso.requestFocus();
    }

}
