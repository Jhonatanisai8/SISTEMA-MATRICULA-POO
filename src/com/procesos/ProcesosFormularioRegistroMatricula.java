package com.procesos;

import com.Modelo.entidades.Asignacion;
import com.Modelo.entidades.DaoImplementacion.EstudianteReposioImple;
import com.Modelo.entidades.DaoImplementacion.MatriculaRepoImple;
import com.Modelo.entidades.Estudiante;
import com.Modelo.entidades.Matricula;
import static com.Utelerias.Constantes.ConstantesFormularioListadoEstudiantesDocentes.FUENTE_TEXT_PRESENTACION;
import com.Utelerias.Constantes.ConstantesFormularioRegistroMatricula;
import com.procesos.Servicios.ServiciosMatricula;
import com.vista.frmRegistrarMatriculasView;
import java.util.Date;
import javax.swing.JDesktopPane;

public class ProcesosFormularioRegistroMatricula
        implements ConstantesFormularioRegistroMatricula {

    static void ponerIconosFormulario(frmRegistrarMatriculasView frmRegistrarMatriculasView) {

    }

    public static void presentarFormulario(JDesktopPane escritorio, frmRegistrarMatriculasView frmRegistrarMatriculasView) {
        EstudianteReposioImple estudianteReposioImple = new EstudianteReposioImple();
        MatriculaRepoImple matriculaRepoImple = new MatriculaRepoImple();
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
        matriculaRepoImple.listarInformacion(frmRegistrarMatriculasView.tblAsignaciones);
        ServiciosMatricula.establecerAnchoColumnasTabla(frmRegistrarMatriculasView.tblAsignaciones, ANCHO_COLUMAS);
    }

    public static Matricula crearMatriculaDesdeFormulario(frmRegistrarMatriculasView frmRegistrarMatriculasVie) {
        Matricula matricula = new Matricula();
        Asignacion asignacion = new Asignacion();
        Estudiante estudiante = new Estudiante();
        //obetenemos los ids
        int filaSelecEstudiante = frmRegistrarMatriculasVie.tblEstudiantes.getSelectedRow();
        int filaSelecAsignacion = frmRegistrarMatriculasVie.tblAsignaciones.getSelectedRow();
        Long idEstudiante = (Long) frmRegistrarMatriculasVie.tblEstudiantes.getValueAt(filaSelecEstudiante, 0);
        Long idAsgnacion = (Long) frmRegistrarMatriculasVie.tblEstudiantes.getValueAt(filaSelecAsignacion, 0);
        //le establcemos los ids a los objetos que conforman la matricula
        asignacion.setIdAsignacion(idAsgnacion);
        estudiante.setIdEstudiante(idEstudiante);
        //establcemos los objetos que conforman la matricula
        matricula.setEstudiante(estudiante);
        matricula.setAsignacion(asignacion);
        matricula.setFechaEmision(new Date());
        return matricula;
    }
}
