package com.procesos;

import com.Modelo.entidades.DaoImplementacion.EstudianteReposioImple;
import com.Modelo.entidades.Estudiante;
import com.Modelo.entidades.InterfaceDao.Repositorio;
import com.Utelerias.Constantes.ConstantesFormularioListadoEstudiantes;
import com.procesos.Servicios.ServiciosEstudiante;
import com.vista.frmListadoEstudiantesView;
import java.util.List;
import javax.swing.JDesktopPane;

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

    public static void presentarFormulario(JDesktopPane desktopPane, frmListadoEstudiantesView frmEstudiantesView) {
        ponerIconosFormulario(frmEstudiantesView);
        ServiciosEstudiante.mostrarEstudiantesEnTabla(frmEstudiantesView, TITULOS_COLUMNAS, listaEstudiantes());
        frmEstudiantesView.setTitle("Listado de Estudiantes");
        desktopPane.removeAll();
        desktopPane.add(frmEstudiantesView);
        frmEstudiantesView.toFront();
        frmEstudiantesView.setVisible(true);

    }
}
