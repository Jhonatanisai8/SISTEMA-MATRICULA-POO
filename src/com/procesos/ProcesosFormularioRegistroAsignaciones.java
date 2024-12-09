package com.procesos;

import com.Modelo.entidades.Asignacion;
import com.Modelo.entidades.Curso;
import com.Modelo.entidades.DaoImplementacion.CursoReposiImple;
import com.Modelo.entidades.DaoImplementacion.DocenteReposioImple;
import com.Modelo.entidades.DaoImplementacion.HorarioRepoImple;
import com.Modelo.entidades.DaoImplementacion.SalonReposiImple;
import com.Modelo.entidades.Docente;
import com.Modelo.entidades.Horario;
import com.Modelo.entidades.InterfaceDao.Repositorio;
import com.Modelo.entidades.Salon;
import static com.Utelerias.Constantes.ConstantesFormularioAdmCursos.FUENTE_TEXT_PRESENTACION;
import com.Utelerias.Constantes.ConstantesFormularioAdmHorarios;
import com.Utelerias.Constantes.ConstantesFormularioMenu;
import com.Utelerias.Constantes.ConstantesFormularioRegistrarAsignacion;
import com.procesos.Servicios.ServiciosAdmAsignaciones;
import com.vista.frmRegistrarAsignacionesView;
import javax.swing.JDesktopPane;

public class ProcesosFormularioRegistroAsignaciones
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
        frmAdministrarAsignacionesView.tblCursos.setFont(FUENTE_TEXT_PRESENTACION);
        frmAdministrarAsignacionesView.tblDocentes.setFont(FUENTE_TEXT_PRESENTACION);
        frmAdministrarAsignacionesView.tblHorarios.setFont(FUENTE_TEXT_PRESENTACION);
        frmAdministrarAsignacionesView.tblSalones.setFont(FUENTE_TEXT_PRESENTACION);
    }

    public static Asignacion crearAsignacionDesdeFormulario(frmRegistrarAsignacionesView frmAsignacionesVie) {
        Asignacion asignacion = new Asignacion();
        DocenteReposioImple docenteReposioImple = new DocenteReposioImple();
        CursoReposiImple cursoReposiImple = new CursoReposiImple();
        SalonReposiImple salonReposiImple = new SalonReposiImple();
        HorarioRepoImple horarioRepoImple = new HorarioRepoImple();
        //primero obtenemos la fila seleccionada de las tablas del frm
        int filaSeleccionadaDocente = frmAsignacionesVie.tblDocentes.getSelectedRow();
        int filaSeleccionadaCurso = frmAsignacionesVie.tblCursos.getSelectedRow();
        int filaSeleccionadaSalon = frmAsignacionesVie.tblSalones.getSelectedRow();
        int filaSeleccionadaHorario = frmAsignacionesVie.tblHorarios.getSelectedRow();
        //ahora los ids
        Long idDocente = (Long) frmAsignacionesVie.tblDocentes.getValueAt(filaSeleccionadaDocente, 0);
        Long idCurso = (Long) frmAsignacionesVie.tblCursos.getValueAt(filaSeleccionadaCurso, 0);
        Long idSalon = (Long) frmAsignacionesVie.tblSalones.getValueAt(filaSeleccionadaSalon, 0);
        Long idHorario = (Long) frmAsignacionesVie.tblHorarios.getValueAt(filaSeleccionadaHorario, 0);
        //creamos el docente
        Docente docente = docenteReposioImple.porDni(idDocente);
        Curso curso = cursoReposiImple.porDni(idCurso);
        Salon salon = salonReposiImple.porDni(idSalon);
        Horario horario = horarioRepoImple.porDni(idHorario);
        //asignamos al abjeto asignacin 
        asignacion.setDocente(docente);
        asignacion.setCurso(curso);
        asignacion.setSalon(salon);
        asignacion.setHorario(horario);
        return asignacion;
    }
}
