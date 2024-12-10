package com.procesos.Servicios;

import com.Modelo.entidades.Asignacion;
import com.Modelo.entidades.Curso;
import com.Modelo.entidades.DaoImplementacion.HorarioRepoImple;
import com.Modelo.entidades.DaoImplementacion.SalonReposiImple;
import com.Modelo.entidades.Docente;
import com.Utelerias.Constantes.ConstantesFormularioAdmHorarios;
import com.Utelerias.Constantes.ConstantesFormularioAdmSalones;
import com.Utelerias.Constantes.Utelerias;
import com.vista.frmRegistrarAsignacionesView;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class ServiciosAdmAsignaciones
        extends Utelerias<Asignacion>
        implements ConstantesFormularioAdmHorarios,
        ConstantesFormularioAdmSalones {

    public static void mostrarRegistrosEnTablas(frmRegistrarAsignacionesView frmView) {
        ServiciosAdmSalones admSalones = new ServiciosAdmSalones();
        ServiciosAdmHorarios admHorarios = new ServiciosAdmHorarios();
        HorarioRepoImple horarioRepoImple = new HorarioRepoImple();
        admHorarios.mostrarRegistrosEnTabla(frmView.tblHorarios, ENCABEZADOS_TABLA, horarioRepoImple.listar());
        SalonReposiImple imple = new SalonReposiImple();
        admSalones.mostrarRegistrosEnTabla(frmView.tblSalones, ConstantesFormularioAdmSalones.TITULOS_COLUMNAS, imple.listar());
    }

    public static void listarEnTablaCursos(JTable tblData, String nombreColumas[], List<Curso> listaCursos) {
        Object[][] data = new Object[listaCursos.size()][nombreColumas.length];
        for (int i = 0; i < listaCursos.size(); i++) {
            Curso curso = listaCursos.get(i);
            data[i][0] = curso.getIdCurso();
            data[i][1] = curso.getCodigoCurso();
            data[i][2] = curso.getNombreCurso();
            data[i][3] = curso.getGrado();
        }
        DefaultTableModel tableModel = new DefaultTableModel(data, nombreColumas);
        tblData.setModel(tableModel);
    }

    public static void listarEnTablaDocentes(JTable tblData, String[] nombreColumas, List<Docente> listaDocentes) {
        Object[][] data = new Object[listaDocentes.size()][nombreColumas.length];
        for (int i = 0; i < listaDocentes.size(); i++) {
            Docente docente = listaDocentes.get(i);
            data[i][0] = docente.getIdDocente();
            data[i][1] = docente.getNombre();
            data[i][2] = docente.getApellidoPaterno();
            data[i][3] = docente.getApellidoMaterno();
            data[i][4] = docente.getEmailEducativoDocente();
        }
        DefaultTableModel tableModel = new DefaultTableModel(data, nombreColumas);
        tblData.setModel(tableModel);
    }

    @Override
    public void establecerAnchoColumnasTabla(JTable tblTabla, int[] anchoColumnas) {
        for (int i = 0; i < anchoColumnas.length && i < tblTabla.getColumnCount(); i++) {
            TableColumn column = tblTabla.getColumnModel().getColumn(i);
            column.setPreferredWidth(anchoColumnas[i]);
        }
    }

    @Override
    public void mostrarRegistrosEnTabla(JTable tblData, String[] nombreColumnas, List<Asignacion> listaObjetos) {
        Object data[][] = new Object[listaObjetos.size()][nombreColumnas.length];
        for (int i = 0; i < listaObjetos.size(); i++) {
            Asignacion a = listaObjetos.get(i);
            data[i][0] = a.getIdAsignacion();
            data[i][1] = a.getCurso().getCodigoCurso();
            data[i][2] = a.getCurso().getNombreCurso();
            data[i][3] = a.getCurso().getGrado();
            data[i][4] = a.getCurso().getNivel();
            data[i][5] = a.getDocente().getNombre();
            data[i][6] = a.getDocente().getApellidoPaterno();
            data[i][7] = a.getDocente().getApellidoMaterno();
            data[i][8] = a.getSalon().getNombreSalon();
            data[i][9] = a.getSalon().getCapacidadEstudiantes();
            data[i][10] = a.getSalon().getReferencia();
            data[i][11] = a.getHorario().getDiaSemana();
            data[i][12] = a.getHorario().getHoraInicio();
            data[i][13] = a.getHorario().getHoraFin();
            data[i][14] = a.getHorario().getTurno();
        }
        DefaultTableModel defaultTableModel = new DefaultTableModel(data, nombreColumnas);
        tblData.setModel(defaultTableModel);
    }

    @Override
    public void mostrarRegistroSoloTabla(JTable tblData, String[] nombreColumnas, Asignacion object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
