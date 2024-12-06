package com.procesos;

import com.Utelerias.Constantes.ConstantesFormularioMenu;
import com.controlador.ControladorFormularioInicio;
import com.vista.frmInicioView;
import com.vista.frmMenuView;

public class ProcesosFormularioMenuView
        implements ConstantesFormularioMenu {
    
    public static void ponerIconosFormulario(frmMenuView frenuView) {
        frenuView.jmnInicio.setIcon(ICONO_MN_INICIO);
        frenuView.jmnnInicio.setIcon(ICONO_MN_INICIO);
        frenuView.mnEstudiantes.setIcon(ICONO_MN_ESTUDIANTES);
        frenuView.mnDocentes.setIcon(ICONO_MN_DOCENTES);
        frenuView.mnSalones.setIcon(ICONO_MN_SALONES);
        frenuView.mnMatricula.setIcon(ICONO_MN_MATRICULA);
        frenuView.mnListados.setIcon(ICONO_MN_LISTADOS);
        frenuView.mnSalir.setIcon(ICONO_MN_SALIR);
        frenuView.mnHorarios.setIcon(ICONO_MN_HORARIOS);
        frenuView.mnCursos.setIcon(ICONO_MN_CURSOS);
        frenuView.mnApoderados.setIcon(ICONO_MN_APODERADO);
        //para los submenus
        frenuView.jmnAdministrarApoderados.setIcon(ICONO_MN_ADMINISTRAR_APODERADOS);
        frenuView.jmnRegistroApoderados.setIcon(ICONO_MN_ADMINISTRAR_APODERADOS);
        frenuView.jmnRegistroApoderados.setIcon(ICONO_JMN_REGISTRAR_APODERADO);
        frenuView.jmnRegistrarEstudiante.setIcon(ICONO_JMN_REGISTRAR_ESTUDIANTE);
        frenuView.jmnAdministrarEstudiantes.setIcon(ICONO_JMN_ADMINISTRAR_ESTUDIANTE);
        frenuView.jmnRegistrarDocente.setIcon(ICONO_JMN_REGISTRAR_DOCENTE);
        frenuView.jmnAdministrarDocentes.setIcon(ICONO_JMN_ADMINISTRAR_DOCENTES);
        frenuView.jmnAdmistrarSalones.setIcon(ICONO_JMN_REGISTRAR_SALON);
        frenuView.jmnRegistrarCurso.setIcon(ICONO_JMN_REGISTRAR_CURSO);
        frenuView.jmnAdministrarCursos.setIcon(ICONO_JMN_ADMINISTRAR_CURSOS);
        frenuView.jmnAdministrarHorarios.setIcon(ICONO_JMN_ADMINISTRAR_HORARIOS);
        frenuView.jmnEstudiantesMatriculados.setIcon(ICONO_JMN_LISTAR_ESTUDIANTES_MATRICULADOS);
        frenuView.jmnDocentesAsignados.setIcon(ICONO_JMN_LISTAR_DOCENTES_ASIGNADOS);
        frenuView.jmnCerrarSesion.setIcon(ICONO_MN_SALIR);
        frenuView.jmnRegistrarAsignacion.setIcon(ICONO_MN_MATRICULA);
        
    }
    
    public static void presentarFormulario(frmMenuView frenuView) {
        ponerIconosFormulario(frenuView);
        frenuView.setResizable(false);
        frenuView.setLocationRelativeTo(null);
        frmInicioView frInicioView = new frmInicioView();
        ControladorFormularioInicio cfi = new ControladorFormularioInicio(frInicioView, frenuView);
    }
}
