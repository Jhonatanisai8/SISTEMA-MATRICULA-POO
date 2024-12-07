package com.procesos;

import com.Modelo.entidades.DaoImplementacion.MatriculaRepoImple;
import static com.Utelerias.Constantes.ConstantesFormularioListadoEstudiantesDocentes.FUENTE_TEXT_PRESENTACION;
import com.Utelerias.Constantes.ConstantesFormulariosMatricula;
import com.procesos.Servicios.ServiciosMatricula;
import com.vista.frmListadoMatriculasView;
import javax.swing.JDesktopPane;

public class ProcesosFormularioListadoMatriculas
        implements ConstantesFormulariosMatricula {

    public static void presentarFormulario(JDesktopPane escritorio, frmListadoMatriculasView frmListadoMatriculasView) {
        MatriculaRepoImple matriculaRepoImple = new MatriculaRepoImple();
        escritorio.removeAll();
        escritorio.add(frmListadoMatriculasView);
        frmListadoMatriculasView.toFront();
        frmListadoMatriculasView.setTitle("Listado de Matriculas.");
        frmListadoMatriculasView.setVisible(true);
        frmListadoMatriculasView.tblDatos.setFont(FUENTE_TEXT_PRESENTACION);
        matriculaRepoImple.listarInformacionMatriculas(frmListadoMatriculasView.tblDatos);
        ServiciosMatricula.establecerAnchoColumnasTabla(frmListadoMatriculasView.tblDatos, ANCHO_COLUMNAS_TABLA_MATRICULAS);
    }
}
