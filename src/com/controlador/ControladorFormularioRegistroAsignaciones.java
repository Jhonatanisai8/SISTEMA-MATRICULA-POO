package com.controlador;

import com.Modelo.entidades.Asignacion;
import com.Modelo.entidades.Curso;
import com.Modelo.entidades.DaoImplementacion.AsignacionRepoImple;
import com.Modelo.entidades.DaoImplementacion.CursoReposiImple;
import com.Modelo.entidades.DaoImplementacion.DocenteReposioImple;
import com.Modelo.entidades.DaoImplementacion.HorarioRepoImple;
import com.Modelo.entidades.DaoImplementacion.SalonReposiImple;
import com.Modelo.entidades.Docente;
import com.Modelo.entidades.Horario;
import com.Modelo.entidades.Salon;
import static com.Utelerias.Constantes.ConstantesFormularioAdmHorarios.ENCABEZADOS_TABLA;
import com.Utelerias.Constantes.ConstantesFormularioAdmSalones;
import com.Utelerias.Constantes.ConstantesFormularioRegistrarAsignacion;
import com.procesos.ProcesosFormularioRegistroAsignaciones;
import com.procesos.Servicios.ServiciosAdmAsignaciones;
import com.procesos.Servicios.ServiciosAdmHorarios;
import com.procesos.Servicios.ServiciosAdmSalones;
import com.procesos.Validaciones.ValidacionesFormularioRegistrarAsignacion;
import com.vista.frmRegistrarAsignacionesView;
import com.vista.frmMenuView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

public class ControladorFormularioRegistroAsignaciones
        implements ActionListener {

    private final frmMenuView frmMenuView;
    private final frmRegistrarAsignacionesView frmAdministrarAsignacionesView;
    private Asignacion asignacion;

    public ControladorFormularioRegistroAsignaciones(frmMenuView frmMenuView, frmRegistrarAsignacionesView frmAdministrarAsignacionesView) {
        this.frmMenuView = frmMenuView;
        this.frmAdministrarAsignacionesView = frmAdministrarAsignacionesView;
        this.frmAdministrarAsignacionesView.btnBuscarCurso.addActionListener(this);
        this.frmAdministrarAsignacionesView.btnBuscarDocente.addActionListener(this);
        this.frmAdministrarAsignacionesView.btnBuscarHorarios.addActionListener(this);
        this.frmAdministrarAsignacionesView.btnBuscarSalones.addActionListener(this);
        this.frmAdministrarAsignacionesView.btnRegistrarAsignacion.addActionListener(this);
        ProcesosFormularioRegistroAsignaciones.presentarFormulario(this.frmMenuView.dsktEscritorio, this.frmAdministrarAsignacionesView);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AsignacionRepoImple asignacionRepoImple = new AsignacionRepoImple();
        DocenteReposioImple docenteReposioImple = new DocenteReposioImple();
        CursoReposiImple cursoReposiImple = new CursoReposiImple();
        HorarioRepoImple horarioRepoImple = new HorarioRepoImple();
        SalonReposiImple salonReposiImple = new SalonReposiImple();

        if (e.getSource() == this.frmAdministrarAsignacionesView.btnBuscarCurso) {
            if (!frmAdministrarAsignacionesView.txtBuscarCursos.getText().isBlank()) {
                List<Curso> listaCursoMismoNombre = cursoReposiImple.listar().stream().
                        filter(curs -> curs.getNombreCurso().trim().equalsIgnoreCase(frmAdministrarAsignacionesView.txtBuscarCursos.getText()))
                        .collect(Collectors.toList());
                ServiciosAdmAsignaciones.listarEnTablaCursos(frmAdministrarAsignacionesView.tblCursos, ConstantesFormularioRegistrarAsignacion.ENCABEZADO_CURSO, listaCursoMismoNombre);
            } else {
                JOptionPane.showMessageDialog(null, "Por favor ingresar el nombre del curso a buscar.", "ATENCION", JOptionPane.WARNING_MESSAGE);
                ServiciosAdmAsignaciones.listarEnTablaCursos(frmAdministrarAsignacionesView.tblCursos, ConstantesFormularioRegistrarAsignacion.ENCABEZADO_CURSO, cursoReposiImple.listar());
            }
            System.out.println("Click sobre el boton Buscar Curso....");
        }

        if (e.getSource() == this.frmAdministrarAsignacionesView.btnBuscarDocente) {
            if (!frmAdministrarAsignacionesView.txtBuscarDocente.getText().isBlank()) {
                List<Docente> listaDocenteMismoNombre = docenteReposioImple.listar().stream()
                        .filter(docente -> docente.getNombre().trim().equalsIgnoreCase(frmAdministrarAsignacionesView.txtBuscarDocente.getText().trim()))
                        .collect(Collectors.toList());
                ServiciosAdmAsignaciones.listarEnTablaDocentes(frmAdministrarAsignacionesView.tblDocentes, ConstantesFormularioRegistrarAsignacion.ENCABEZADO_DOCENTE, listaDocenteMismoNombre);
            } else {
                JOptionPane.showMessageDialog(null, "Por favor ingrese el nombre del docente a buscar.", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
                ServiciosAdmAsignaciones.listarEnTablaDocentes(frmAdministrarAsignacionesView.tblDocentes, ConstantesFormularioRegistrarAsignacion.ENCABEZADO_DOCENTE, docenteReposioImple.listar());
            }
            System.out.println("Click sobre el boton Buscar Docente....");
        }

        if (e.getSource() == this.frmAdministrarAsignacionesView.btnBuscarHorarios) {
            ServiciosAdmHorarios admHorarios = new ServiciosAdmHorarios();
            if (!frmAdministrarAsignacionesView.txtBuscarHorarios.getText().isBlank()) {
                List<Horario> listaHorarioMismoNombre = horarioRepoImple.listar().stream()
                        .filter(hor -> hor.getDiaSemana().toLowerCase().contains(frmAdministrarAsignacionesView.txtBuscarHorarios.getText().toLowerCase()))
                        .collect(Collectors.toList());
                admHorarios.mostrarRegistrosEnTabla(frmAdministrarAsignacionesView.tblHorarios, ENCABEZADOS_TABLA, listaHorarioMismoNombre);
            } else {
                admHorarios.mostrarRegistrosEnTabla(frmAdministrarAsignacionesView.tblHorarios, ENCABEZADOS_TABLA, horarioRepoImple.listar());
                JOptionPane.showMessageDialog(null, "Por favor ingrese el dia de la semana de los cursos a buscar.", "ATENCION", JOptionPane.WARNING_MESSAGE);
            }
            System.out.println("Click sobre el boton Buscar Horario....");
        }

        if (e.getSource() == this.frmAdministrarAsignacionesView.btnBuscarSalones) {
            ServiciosAdmSalones admSalones = new ServiciosAdmSalones();
            if (!frmAdministrarAsignacionesView.txtBuscarSalon.getText().isBlank()) {
                List<Salon> listaSalonMismoNombre = salonReposiImple.listar().stream()
                        .filter(sa -> sa.getNombreSalon().toLowerCase().contains(frmAdministrarAsignacionesView.txtBuscarSalon.getText().toLowerCase().trim()))
                        .collect(Collectors.toList());
                admSalones.mostrarRegistrosEnTabla(frmAdministrarAsignacionesView.tblSalones, ConstantesFormularioAdmSalones.TITULOS_COLUMNAS, listaSalonMismoNombre);
            } else {
                JOptionPane.showMessageDialog(null, "Por favor ingresar el nombre de los salones a buscar.", "ATENCION", JOptionPane.WARNING_MESSAGE);
                admSalones.mostrarRegistrosEnTabla(frmAdministrarAsignacionesView.tblSalones, ConstantesFormularioAdmSalones.TITULOS_COLUMNAS, salonReposiImple.listar());
            }
            System.out.println("Click sobre el boton Buscar Salon....");
        }

        if (e.getSource() == this.frmAdministrarAsignacionesView.btnRegistrarAsignacion) {
            String validacion = ValidacionesFormularioRegistrarAsignacion.validarSeleccionFilaTablas(frmAdministrarAsignacionesView.tblCursos, frmAdministrarAsignacionesView.tblDocentes, frmAdministrarAsignacionesView.tblHorarios, frmAdministrarAsignacionesView.tblSalones);
            if (!validacion.equals("")) {
                System.out.println("Selecionar Fila " + validacion);
                JOptionPane.showMessageDialog(null, "Seleccionar una fila de " + validacion, "ATENCION", JOptionPane.WARNING_MESSAGE);
                return;
            } else {
                asignacion = ProcesosFormularioRegistroAsignaciones.crearAsignacionDesdeFormulario(this.frmAdministrarAsignacionesView);
                asignacionRepoImple.guardar(asignacion);
                JOptionPane.showMessageDialog(null, "Asignacion Registrada Corectamente", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
                ProcesosFormularioRegistroAsignaciones.presentarFormulario(this.frmMenuView.dsktEscritorio, this.frmAdministrarAsignacionesView);
            }
            System.out.println("Click sobre el boton Registrar Asigacion....");
        }

    }

}
