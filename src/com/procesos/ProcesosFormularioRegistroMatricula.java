package com.procesos;

import com.Modelo.entidades.DaoImplementacion.EstudianteReposioImple;
import static com.Utelerias.Constantes.ConstantesFormularioListadoEstudiantesDocentes.FUENTE_TEXT_PRESENTACION;
import com.Utelerias.Constantes.ConstantesFormularioRegistroMatricula;
import com.procesos.Servicios.ServiciosMatricula;
import com.vista.frmRegistrarMatriculasView;
import javax.swing.JDesktopPane;

public class ProcesosFormularioRegistroMatricula
        implements ConstantesFormularioRegistroMatricula {

    static void ponerIconosFormulario(frmRegistrarMatriculasView frmRegistrarMatriculasView) {

    }

    public static void presentarFormulario(JDesktopPane escritorio, frmRegistrarMatriculasView frmRegistrarMatriculasView) {
        EstudianteReposioImple estudianteReposioImple = new EstudianteReposioImple();
        ponerIconosFormulario(frmRegistrarMatriculasView);
        escritorio.removeAll();
        escritorio.add(frmRegistrarMatriculasView);
        frmRegistrarMatriculasView.toFront();
        frmRegistrarMatriculasView.setTitle("REGISTRO DE MATRICULA.");
        frmRegistrarMatriculasView.setVisible(true);
        ServiciosMatricula.mostrarEstudiantesEnTabla(frmRegistrarMatriculasView.tblEstudiantes, COLUMNAS_TABLA_ESTUDIANTES, estudianteReposioImple.listar());
        ServiciosMatricula.establecerAnchoColumnasTabla(frmRegistrarMatriculasView.tblEstudiantes, TAMANIO_COLUMNAS);
        frmRegistrarMatriculasView.tblAsignaciones.setFont(FUENTE_TEXT_PRESENTACION);
        frmRegistrarMatriculasView.tblEstudiantes.setFont(FUENTE_TEXT_PRESENTACION);
    }

}
