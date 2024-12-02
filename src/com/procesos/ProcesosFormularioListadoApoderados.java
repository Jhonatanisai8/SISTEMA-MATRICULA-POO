package com.procesos;

import com.Modelo.entidades.Apoderado;
import com.Modelo.entidades.DaoImplementacion.ApoderadoReposiImple;
import com.Modelo.entidades.InterfaceDao.Repositorio;
import static com.Utelerias.Constantes.ConstantesFormularioListadoEstudiantesDocentes.FUENTE_TEXT_PRESENTACION;
import static com.Utelerias.Constantes.ConstantesFormularioListadoEstudiantesDocentes.ICONO_BUSCAR;
import static com.Utelerias.Constantes.ConstantesFormularioListadoEstudiantesDocentes.ICONO_ELIMINAR;
import static com.Utelerias.Constantes.ConstantesFormularioListadoEstudiantesDocentes.ICONO_MODIFICAR;
import com.Utelerias.Constantes.ConstantesFormularioRegistroApoderado;
import com.procesos.Servicios.ServiciosApoderado;
import com.vista.frmListadoApoderadosView;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ProcesosFormularioListadoApoderados
        implements ConstantesFormularioRegistroApoderado {

    private static void ponerIconosFormulario(frmListadoApoderadosView frmListadoApoderadosView) {
        frmListadoApoderadosView.tblDatos.setFont(FUENTE_TEXT_PRESENTACION);
        frmListadoApoderadosView.btnBuscar.setIcon(ICONO_BUSCAR);
        frmListadoApoderadosView.btnModificar.setIcon(ICONO_MODIFICAR);
        frmListadoApoderadosView.btnEliminar.setIcon(ICONO_ELIMINAR);
    }

    public static List<Apoderado> listaApoderados() {
        Repositorio<Apoderado> lisRepositorio = new ApoderadoReposiImple();
        return lisRepositorio.listar();
    }

    public static Apoderado obtenerDocente(Long dni) {
        Repositorio<Apoderado> lisRepositorio = new ApoderadoReposiImple();
        return lisRepositorio.porDni(dni);
    }

    public static void presentarFormulario(JDesktopPane escritorio, frmListadoApoderadosView frmListadoApoderadosView) {
        ponerIconosFormulario(frmListadoApoderadosView);
        ServiciosApoderado.mostrarEstudiantesEnTabla(frmListadoApoderadosView.tblDatos, ENCABEZADOS_TABLA, listaApoderados());
        ServiciosApoderado.establecerAnchoColumnasTabla(frmListadoApoderadosView.tblDatos, ANCHO_COLUMNAS);
        frmListadoApoderadosView.setTitle("Listado de Estudiantes.");
        escritorio.removeAll();
        escritorio.add(frmListadoApoderadosView);
        frmListadoApoderadosView.toFront();
        frmListadoApoderadosView.setVisible(true);
    }

    public static void seleccionarDatosEliminar(frmListadoApoderadosView frmListadoApoderadosView) {
        Repositorio<Apoderado> repo = new ApoderadoReposiImple();
        int filasSelecionadas[] = frmListadoApoderadosView.tblDatos.getSelectedRows();
        if (filasSelecionadas.length == 0) {
            JOptionPane.showMessageDialog(null, "Por favor selecciona una o más filas para eliminar.", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
            return;
        }

        StringBuilder contIds = new StringBuilder();
        for (int i = 0; i < filasSelecionadas.length; i++) {
            String idEstudiante = frmListadoApoderadosView.tblDatos.getValueAt(filasSelecionadas[i], 0).toString();
            if (contIds.length() > 0) {
                contIds.append(",");
            }
            contIds.append(idEstudiante);
        }

        //preguntamos al admin si desea elimar dichos datos 
        int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar los registros con ID: " + contIds + "?", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
        if (opcion == JOptionPane.YES_OPTION) {
            for (int i = filasSelecionadas.length - 1; i >= 0; i--) {
                Long idEstudiante = (Long) frmListadoApoderadosView.tblDatos.getValueAt(filasSelecionadas[i], 0);
                repo.eliminar(idEstudiante);
            }
            //avtualizamos la tabla
            ServiciosApoderado.mostrarEstudiantesEnTabla(frmListadoApoderadosView.tblDatos, ENCABEZADOS_TABLA, listaApoderados());
            System.out.println("Eli inando..");
        }
        System.out.println("Borrando datos......");
    }

    public static void enviarApoderado(JTable tblDatos, Long dni) {
        if (obtenerDocente(dni) == null) {
            JOptionPane.showMessageDialog(null, "Apoderdo con Dni: " + dni + " no fue encontrado.", "Atención", 3);
            return;
        }
        System.out.println("Eviando apoderadoo.......");
        ServiciosApoderado.mostrarApoderadoEnTabla(tblDatos, ENCABEZADOS_TABLA, obtenerDocente(dni));
    }

}
