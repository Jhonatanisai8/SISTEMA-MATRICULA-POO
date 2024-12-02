package com.procesos;

import com.Modelo.entidades.DaoImplementacion.DocenteReposioImple;
import com.Modelo.entidades.Docente;
import com.Modelo.entidades.InterfaceDao.Repositorio;
import com.Utelerias.Constantes.ConstantesFormularioListadoEstudiantesDocentes;
import com.procesos.Servicios.ServiciosDocente;
import com.vista.frmListadoDocentesView;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

public class ProcesosFormularioListadoDocentes
        implements ConstantesFormularioListadoEstudiantesDocentes {

    //para obtener la lista 
    private static List<Docente> obtenerListaDocente() {
        Repositorio<Docente> repo = new DocenteReposioImple();
        return repo.listar();
    }

    public static Docente obtenerDocente(Long dni) {
        Repositorio<Docente> repo = new DocenteReposioImple();
        return repo.porDni(dni);
    }

    private static void ponerIconosFormulario(frmListadoDocentesView frmListadoDocentesView) {
        frmListadoDocentesView.btlData.setFont(FUENTE_TEXT_PRESENTACION);
        frmListadoDocentesView.setFont(FUENTE_TEXT_PRESENTACION);
        frmListadoDocentesView.btnBuscar.setIcon(ICONO_BUSCAR);
        frmListadoDocentesView.btnModificar.setIcon(ICONO_MODIFICAR);
        frmListadoDocentesView.btnEliminar.setIcon(ICONO_ELIMINAR);
    }

    public static void presentarFormulario(JDesktopPane desktopPane, frmListadoDocentesView frmListadoDocentesView) {
        frmListadoDocentesView.btlData.setFont(FUENTE_TEXT_PRESENTACION);
        ponerIconosFormulario(frmListadoDocentesView);
        ServiciosDocente.mostrarDocentesEnTabla(frmListadoDocentesView.btlData, TITULOS_COLUMNAS_DOCENTE, obtenerListaDocente());
        ServiciosDocente.establecerAnchoColumnasTabla(frmListadoDocentesView.btlData, ANCHO_COLUMAS_TABLA_DOCENTE);
        frmListadoDocentesView.setTitle("Listado de Docentes");
        desktopPane.removeAll();
        desktopPane.add(frmListadoDocentesView);
        frmListadoDocentesView.toFront();
        frmListadoDocentesView.setVisible(true);
    }

    public static void mostarSoloDocente(frmListadoDocentesView frmistadoDocentesView, String text) {
        if (text.isBlank()) {
            ServiciosDocente.mostrarDocentesEnTabla(frmistadoDocentesView.btlData, TITULOS_COLUMNAS_DOCENTE, obtenerListaDocente());
        } else {
            ServiciosDocente.mostrarDocenteEntabla(frmistadoDocentesView.btlData, TITULOS_COLUMNAS_DOCENTE, obtenerDocente(Long.valueOf(text)));
        }
    }

    public static void seleccionarDatosEliminar(frmListadoDocentesView frmistadoDocentesView) {
        Repositorio<Docente> repo = new DocenteReposioImple();
        int filasSelecionadas[] = frmistadoDocentesView.btlData.getSelectedRows();
        if (filasSelecionadas.length == 0) {
            JOptionPane.showMessageDialog(null, "Por favor selecciona una o más filas para eliminar.", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
            return;
        }

        StringBuilder contIds = new StringBuilder();
        for (int i = 0; i < filasSelecionadas.length; i++) {
            String idDocente = frmistadoDocentesView.btlData.getValueAt(filasSelecionadas[i], 0).toString();
            if (contIds.length() > 0) {
                contIds.append(",");
            }
            contIds.append(idDocente);
        }

        //preguntamos al admin si desea elimar dichos datos 
        int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar los registros con ID: " + contIds + "?", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
        if (opcion == JOptionPane.YES_OPTION) {
            for (int i = filasSelecionadas.length - 1; i >= 0; i--) {
                Long idEstudiante = (Long) frmistadoDocentesView.btlData.getValueAt(filasSelecionadas[i], 0);
                repo.eliminar(idEstudiante);
            }
            //avtualizamos la tabla
            ServiciosDocente.mostrarDocentesEnTabla(frmistadoDocentesView.btlData, TITULOS_COLUMNAS_DOCENTE, obtenerListaDocente());

        }
        System.out.println("Borrando datos......");
    }
}
