package com.procesos;

import com.Modelo.entidades.DaoImplementacion.DocenteReposioImple;
import com.Modelo.entidades.Docente;
import com.Modelo.entidades.InterfaceDao.Repositorio;
import com.Utelerias.Constantes.ConstantesFormularioListadoEstudiantesDocentes;
import com.procesos.Servicios.ServiciosDocente;
import com.vista.frmListadoDocentesView;
import java.util.List;
import javax.swing.JDesktopPane;

public class ProcesosFormularioListadoDocentes
        implements ConstantesFormularioListadoEstudiantesDocentes {

    //para obtener la lista 
    private static List<Docente> obtenerListaDocente() {
        Repositorio<Docente> repo = new DocenteReposioImple();
        return repo.listar();
    }

    private static void ponerIconosFormulario(frmListadoDocentesView frmListadoDocentesView) {
        frmListadoDocentesView.btnBuscar.setIcon(ICONO_BUSCAR);
        frmListadoDocentesView.btnModificar.setIcon(ICONO_MODIFICAR);
        frmListadoDocentesView.btnEliminar.setIcon(ICONO_ELIMINAR);
    }

    public static void presentarFormulario(JDesktopPane desktopPane, frmListadoDocentesView frmListadoDocentesView) {
        ponerIconosFormulario(frmListadoDocentesView);
        ServiciosDocente.mostrarDocentesEnTabla(frmListadoDocentesView, TITULOS_COLUMNAS, obtenerListaDocente());
        frmListadoDocentesView.setTitle("Listado de Docentes");
        desktopPane.removeAll();
        desktopPane.add(frmListadoDocentesView);
        frmListadoDocentesView.toFront();
        frmListadoDocentesView.setVisible(true);
    }

}