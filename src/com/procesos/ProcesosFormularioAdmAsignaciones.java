package com.procesos;

import com.Modelo.entidades.Curso;
import com.Modelo.entidades.DaoImplementacion.CursoReposiImple;
import com.Modelo.entidades.DaoImplementacion.HorarioRepoImple;
import com.Modelo.entidades.Horario;
import com.Modelo.entidades.InterfaceDao.Repositorio;
import com.Utelerias.Constantes.ConstantesFormularioAdmHorarios;
import com.Utelerias.Constantes.ConstantesFormularioRegistrarAsignacion;
import com.procesos.Servicios.ServiciosAdmAsignaciones;
import com.vista.frmAdministrarAsignacionesView;
import javax.swing.JDesktopPane;

public class ProcesosFormularioAdmAsignaciones
        implements ConstantesFormularioAdmHorarios, ConstantesFormularioRegistrarAsignacion {

    public static void presentarFormulario(JDesktopPane desktopPane, frmAdministrarAsignacionesView frmAdministrarAsignacionesView) {
        Repositorio<Horario> repo = new HorarioRepoImple();
        Repositorio<Curso> repositorio = new CursoReposiImple();

        desktopPane.removeAll();
        desktopPane.add(frmAdministrarAsignacionesView);
        frmAdministrarAsignacionesView.setTitle("Registro de asignaciones".toUpperCase());
        frmAdministrarAsignacionesView.toFront();
        frmAdministrarAsignacionesView.setVisible(true);
        System.out.println("Haciendo visible el registor de asiganaciones....");
        ServiciosAdmAsignaciones.mostrarRegistrosEnTablas(frmAdministrarAsignacionesView);
        ServiciosAdmAsignaciones.listarEnTablaCursos(frmAdministrarAsignacionesView.tblCursos, ENCABEZADO_CURSO, repositorio.listar());
    }
}
