package com.procesos.Servicios;

import com.Modelo.entidades.Curso;
import com.vista.frmAdmistrarCursos;
import java.util.List;
import java.util.Random;
import javax.swing.table.DefaultTableModel;

public class ServiciosCurso {

    public static String generarCodigoCurso(String curso) {
        Random r = new Random();
        int n = r.nextInt(10) + 1;
        String letras = "QWERTYUIOPASDFGHJKLÑZXCVBNM";
        char letra = letras.charAt(n);
        return String.valueOf(curso.substring(0, 5).toUpperCase().concat(String.valueOf(letra + "00")).concat(String.valueOf(n)));
    }

    public static void mostrarCursosEnTabla(
            frmAdmistrarCursos frmAdmistrarCursos,
            String columnas[],
            List<Curso> listaCurso) {
        Object data[][] = new Object[listaCurso.size()][columnas.length];
        for (int i = 0; i < listaCurso.size(); i++) {
            Curso miCurso = listaCurso.get(i);
            data[i][0] = miCurso.getIdCurso();
            data[i][1] = miCurso.getCodigoCurso();
            data[i][2] = miCurso.getNombreCurso();
            data[i][3] = miCurso.getDescripcion();
            data[i][4] = miCurso.getGrado();
            data[i][5] = miCurso.getNivel();
        }
        DefaultTableModel miModel = new DefaultTableModel(data, columnas);
        frmAdmistrarCursos.tblDatosCursos.setModel(miModel);
        System.out.println("MOstrando los cursos en tabla...");
    }

}
