package com.procesos;

import com.Modelo.entidades.DaoImplementacion.EstudianteReposioImple;
import com.Modelo.entidades.Estudiante;
import com.Modelo.entidades.InterfaceDao.Repositorio;
import com.Utelerias.Constantes.ConstantesFormularioListadoEstudiantes;
import com.procesos.Servicios.ServiciosEstudianteDocente;
import com.vista.frmListadoEstudiantesView;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ProcesosFormularioListadoEstudiantes
        implements ConstantesFormularioListadoEstudiantes {

    private static void ponerIconosFormulario(frmListadoEstudiantesView frmEstudiantesView) {
        frmEstudiantesView.btnBuscar.setIcon(ICONO_BUSCAR);
        frmEstudiantesView.btnModificar.setIcon(ICONO_MODIFICAR);
        frmEstudiantesView.btnEliminar.setIcon(ICONO_ELIMINAR);
    }

    public static List<Estudiante> listaEstudiantes() {
        Repositorio<Estudiante> repo = new EstudianteReposioImple();
        return repo.listar();
    }

    public static Estudiante obtenerEstudiante(Long dni) {
        Repositorio<Estudiante> repo = new EstudianteReposioImple();
        return repo.porDni(dni);
    }

    public static void presentarFormulario(JDesktopPane desktopPane, frmListadoEstudiantesView frmEstudiantesView) {
        ponerIconosFormulario(frmEstudiantesView);
        ServiciosEstudianteDocente.mostrarEstudiantesEnTabla(frmEstudiantesView, TITULOS_COLUMNAS, listaEstudiantes());
        frmEstudiantesView.setTitle("Listado de Estudiantes");
        desktopPane.removeAll();
        desktopPane.add(frmEstudiantesView);
        frmEstudiantesView.toFront();
        frmEstudiantesView.setVisible(true);
    }

    public static void enviarEstudiante(JTable tblData, Long dni) {
        if (obtenerEstudiante(dni) == null) {
            JOptionPane.showMessageDialog(null, "Estudiante con el Dni: " + dni + " no fue encontrado", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
            return;
        }
        System.out.println("Enviando estudiante....");
        ServiciosEstudianteDocente.mostrarEstudiantesEnTabla(tblData, TITULOS_COLUMNAS, obtenerEstudiante(dni));
    }

    public static void seleccionarDatosEliminar(frmListadoEstudiantesView frmEstudiantesView) {
        Repositorio<Estudiante> repo = new EstudianteReposioImple();
        int filasSelecionadas[] = frmEstudiantesView.btlData.getSelectedRows();
        if (filasSelecionadas.length == 0) {
            JOptionPane.showMessageDialog(null, "Por favor selecciona una o más filas para eliminar.", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
            return;
        }

        StringBuilder contIds = new StringBuilder();
        for (int i = 0; i < filasSelecionadas.length; i++) {
            String idEstudiante = frmEstudiantesView.btlData.getValueAt(filasSelecionadas[i], 0).toString();
            if (contIds.length() > 0) {
                contIds.append(",");
            }
            contIds.append(idEstudiante);
        }

        //preguntamos al admin si desea elimar dichos datos 
        int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar los registros con ID: " + contIds + "?", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
        if (opcion == JOptionPane.YES_OPTION) {
            for (int i = filasSelecionadas.length - 1; i >= 0; i--) {
                Long idEstudiante = (Long) frmEstudiantesView.btlData.getValueAt(filasSelecionadas[i], 0);
                repo.eliminar(idEstudiante);
            }
            ServiciosEstudianteDocente.mostrarEstudiantesEnTabla(frmEstudiantesView, TITULOS_COLUMNAS, listaEstudiantes());
            //avtualizamos la tabla
        }
        System.out.println("Borrando datos......");
    }

}
