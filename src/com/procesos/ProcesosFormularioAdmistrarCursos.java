package com.procesos;

import com.Modelo.entidades.Curso;
import com.Modelo.entidades.DaoImplementacion.CursoReposiImple;
import com.Modelo.entidades.InterfaceDao.Repositorio;
import com.Utelerias.Constantes.ConstantesFormularioAdmCursos;
import com.procesos.Servicios.ServiciosCurso;
import com.procesos.Validaciones.ValidacionesFrmAdmCursos;
import com.vista.frmAdmistrarCursos;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

public class ProcesosFormularioAdmistrarCursos
        implements ConstantesFormularioAdmCursos {

    private static List<Curso> obtenerListaCursos() {
        Repositorio<Curso> repo = new CursoReposiImple();
        return repo.listar();
    }

    public static Curso obtenerCurso(Long id) {
        CursoReposiImple cursoReposiImple = new CursoReposiImple();
        return cursoReposiImple.porDni(id);
    }

    private static void rellenarComboBox(frmAdmistrarCursos frmAdmistrarCursos) {
        frmAdmistrarCursos.cbxGrado.removeAllItems();
        for (String string : LISTA_GRADOS) {
            frmAdmistrarCursos.cbxGrado.addItem(string);
        }
    }

    public static void presentarFormulario(JDesktopPane desktopPane, frmAdmistrarCursos frmAdmistrarCursos) {
        ServiciosCurso admCurso = new ServiciosCurso();
        rellenarComboBox(frmAdmistrarCursos);
        frmAdmistrarCursos.tblDatosCursos.setFont(FUENTE_TEXT_PRESENTACION);
        frmAdmistrarCursos.setTitle("Administracion de Cursos.");
        desktopPane.removeAll();
        desktopPane.add(frmAdmistrarCursos);
        frmAdmistrarCursos.toFront();
        frmAdmistrarCursos.setVisible(true);
        admCurso.mostrarRegistrosEnTabla(frmAdmistrarCursos.tblDatosCursos, ENCABEZADO_COLUMNAS_TABLA, obtenerListaCursos());
        admCurso.establecerAnchoColumnasTabla(frmAdmistrarCursos.tblDatosCursos, ANCH0_COLUMNAS);
    }

    public static Curso creaCursoFormulario(frmAdmistrarCursos frmAdmistrarCursos) {
        Curso miCurso = null;
        //llamamos al metodo de las validaciones 
        String validacion = ValidacionesFrmAdmCursos.validarCampos(frmAdmistrarCursos);
        if (!validacion.equals("")) {
            JOptionPane.showMessageDialog(null, "Revisar el Campo." + validacion, "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        try {
            miCurso = new Curso();
            miCurso.setNombreCurso(frmAdmistrarCursos.txtNombreCurso.getText().trim());
            miCurso.setCodigoCurso(ServiciosCurso.generarCodigoCurso(frmAdmistrarCursos.txtNombreCurso.getText().trim()));
            miCurso.setDescripcion(frmAdmistrarCursos.txtDiscripcion.getText().trim());
            miCurso.setGrado(Integer.parseInt(frmAdmistrarCursos.cbxGrado.getSelectedItem().toString()));
            miCurso.setNivel("Primaria");
        } catch (NumberFormatException e) {
            System.out.println("Error al crear un Salon desde el formulario: " + e.getMessage());
            return null;
        }
        //retornamos 
        return miCurso;
    }

    public static void presentarInformacionCurso(frmAdmistrarCursos frmAdmistrarCursos, Curso curso) {
        //ponemos la informacion del objeto en los campos de informacion 
        frmAdmistrarCursos.txtNombreCurso.setText(curso.getNombreCurso());
        frmAdmistrarCursos.txtDiscripcion.setText(curso.getDescripcion());
        frmAdmistrarCursos.cbxGrado.setSelectedItem(String.valueOf(curso.getGrado()));
        frmAdmistrarCursos.btnGuardarCurso.setEnabled(false);
    }
}
