package com.procesos;

import com.Utelerias.Constantes.ConstantesFormularioMenu;
import com.controlador.ControladorFormularioInicio;
import com.vista.frmInicioView;
import com.vista.frmMenuView;

public class ProcesosFormularioMenuView
        implements ConstantesFormularioMenu {

    public static void ponerIconosMenus(frmMenuView frenuView) {
        frenuView.mnInicio.setIcon(ICONO_MN_INICIO);
        frenuView.mnEstudiantes.setIcon(ICONO_MN_ESTUDIANTES);
        frenuView.mnDocentes.setIcon(ICONO_MN_DOCENTES);
        frenuView.mnSalones.setIcon(ICONO_MN_SALONES);
        frenuView.mnMatricula.setIcon(ICONO_MN_MATRICULA);
        frenuView.mnListados.setIcon(ICONO_MN_LISTADOS);
        frenuView.mnSalir.setIcon(ICONO_MN_SALIR);
        frenuView.mnHorarios.setIcon(ICONO_MN_HORARIOS);
        frenuView.mnCursos.setIcon(ICONO_MN_CURSOS);
    }

    public static void presentarFormularioMenu(frmMenuView frenuView) {
        ponerIconosMenus(frenuView);
        frenuView.setResizable(false);
        frmInicioView frInicioView = new frmInicioView();
        ControladorFormularioInicio cfi = new ControladorFormularioInicio(frInicioView, frenuView);
    }
}
