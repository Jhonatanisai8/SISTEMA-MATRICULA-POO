package com.procesos.Servicios;

import com.Modelo.entidades.Curso;
import com.Modelo.entidades.DaoImplementacion.HorarioRepoImple;
import com.Modelo.entidades.DaoImplementacion.SalonReposiImple;
import com.Utelerias.Constantes.ConstantesFormularioAdmHorarios;
import com.Utelerias.Constantes.ConstantesFormularioAdmSalones;
import com.vista.frmAdministrarAsignacionesView;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ServiciosAdmAsignaciones
        implements ConstantesFormularioAdmHorarios,
        ConstantesFormularioAdmSalones {

    public static void mostrarRegistrosEnTablas(frmAdministrarAsignacionesView frmView) {
        ServiciosAdmSalones admSalones = new ServiciosAdmSalones();
        ServiciosAdmHorarios admHorarios = new ServiciosAdmHorarios();
        HorarioRepoImple horarioRepoImple = new HorarioRepoImple();
        admHorarios.mostrarRegistrosEnTabla(frmView.tblHorarios, ENCABEZADOS_TABLA, horarioRepoImple.listar());
        SalonReposiImple imple = new SalonReposiImple();
        admSalones.mostrarRegistrosEnTabla(frmView.tblSalones, ConstantesFormularioAdmSalones.TITULOS_COLUMNAS, imple.listar());
    }

    public static void listarEnTablaCursos(JTable tblData, String nombreColumas[], List<Curso> listaCursos) {
        Object[][] data = new Object[listaCursos.size()][nombreColumas.length];
        for (int i = 0; i < listaCursos.size(); i++) {
            Curso curso = listaCursos.get(i);
            data[i][0] = curso.getIdCurso();
            data[i][1] = curso.getCodigoCurso();
            data[i][2] = curso.getNombreCurso();
            data[i][3] = curso.getGrado();
        }
        DefaultTableModel tableModel = new DefaultTableModel(data, nombreColumas);
        tblData.setModel(tableModel);
    }
}
