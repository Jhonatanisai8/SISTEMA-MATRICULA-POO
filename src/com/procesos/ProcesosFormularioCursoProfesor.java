package com.procesos;

import com.Modelo.entidades.DaoImplementacion.CursoReposiImple;
import com.Utelerias.Constantes.ConstantesFormularioAdmCursos;
import com.procesos.Servicios.ServiciosCurso;
import com.vista.frmCursoProfesorView;
import javax.swing.JDesktopPane;
import javax.swing.table.DefaultTableModel;

public class ProcesosFormularioCursoProfesor
        implements ConstantesFormularioAdmCursos {

    public static void presentarFormulario(JDesktopPane desktopPane, frmCursoProfesorView frmCursoProfesorView) {
        CursoReposiImple cri = new CursoReposiImple();
        ServiciosCurso curso = new ServiciosCurso();
        desktopPane.removeAll();
        desktopPane.add(frmCursoProfesorView);
        frmCursoProfesorView.tblDatos.setFont(FUENTE_TEXT_PRESENTACION);
        frmCursoProfesorView.setTitle("Listado de Cursos Asociados Con Profesores.");
        frmCursoProfesorView.toFront();
        frmCursoProfesorView.setVisible(true);
        DefaultTableModel model = new DefaultTableModel(ENCABEZADOS_TABLA_CURSO, 0);
        frmCursoProfesorView.tblDatos.setModel(model);
        model = (DefaultTableModel) frmCursoProfesorView.tblDatos.getModel();
        frmCursoProfesorView.tblDatos.setModel(cri.listarCursosProcesos(model, "", 0));
        curso.establecerAnchoColumnasTabla(frmCursoProfesorView.tblDatos, ANCHO_CURSO_PROFESOR);
    }
}
