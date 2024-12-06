package com.procesos;

import com.Modelo.entidades.Curso;
import com.Modelo.entidades.DaoImplementacion.CursoReposiImple;
import com.Modelo.entidades.DaoImplementacion.DocenteReposioImple;
import com.Modelo.entidades.DaoImplementacion.HorarioRepoImple;
import com.Modelo.entidades.Docente;
import com.Modelo.entidades.Horario;
import com.Modelo.entidades.InterfaceDao.Repositorio;
import com.Utelerias.Constantes.ConstantesFormularioAdmHorarios;
import com.Utelerias.Constantes.ConstantesFormularioMenu;
import com.Utelerias.Constantes.ConstantesFormularioRegistrarAsignacion;
import com.procesos.Servicios.ServiciosAdmAsignaciones;
import com.vista.frmRegistrarAsignacionesView;
import javax.swing.JDesktopPane;

public class ProcesosFormularioAdmAsignaciones
        implements ConstantesFormularioAdmHorarios, ConstantesFormularioRegistrarAsignacion,
        ConstantesFormularioMenu {

    public static void ponerIconosFormularios(frmRegistrarAsignacionesView frmAdministrarAsignacionesView) {
        frmAdministrarAsignacionesView.btnBuscarCurso.setIcon(ICONO_LUPA);
        frmAdministrarAsignacionesView.btnBuscarDocente.setIcon(ICONO_LUPA);
        frmAdministrarAsignacionesView.btnBuscarHorarios.setIcon(ICONO_LUPA);
        frmAdministrarAsignacionesView.btnBuscarSalones.setIcon(ICONO_LUPA);
        frmAdministrarAsignacionesView.btnRegistrarAsignacion.setIcon(ICONO_MN_MATRICULA);

    }

    public static void presentarFormulario(JDesktopPane desktopPane, frmRegistrarAsignacionesView frmAdministrarAsignacionesView) {
        ponerIconosFormularios(frmAdministrarAsignacionesView);
        Repositorio<Horario> repo = new HorarioRepoImple();
        Repositorio<Curso> repositorio = new CursoReposiImple();
        Repositorio<Docente> repoDocente = new DocenteReposioImple();

        desktopPane.removeAll();
        desktopPane.add(frmAdministrarAsignacionesView);
        frmAdministrarAsignacionesView.setTitle("Registro de asignaciones".toUpperCase());
        frmAdministrarAsignacionesView.toFront();
        frmAdministrarAsignacionesView.setVisible(true);
        System.out.println("Haciendo visible el registor de asiganaciones....");
        ServiciosAdmAsignaciones.mostrarRegistrosEnTablas(frmAdministrarAsignacionesView);
        ServiciosAdmAsignaciones.listarEnTablaCursos(frmAdministrarAsignacionesView.tblCursos, ENCABEZADO_CURSO, repositorio.listar());
        ServiciosAdmAsignaciones.listarEnTablaDocentes(frmAdministrarAsignacionesView.tblDocentes, ENCABEZADO_DOCENTE, repoDocente.listar());
    }
}
