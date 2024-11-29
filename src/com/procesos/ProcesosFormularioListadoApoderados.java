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
    
    public static void presentarFormulario(JDesktopPane escritorio, frmListadoApoderadosView frmListadoApoderadosView) {
        ponerIconosFormulario(frmListadoApoderadosView);
        ServiciosApoderado.mostrarEstudiantesEnTabla(frmListadoApoderadosView, ENCABEZADOS_TABLA, listaApoderados());
        frmListadoApoderadosView.setTitle("Listado de Estudiantes.");
        escritorio.removeAll();
        escritorio.add(frmListadoApoderadosView);
        frmListadoApoderadosView.toFront();
        frmListadoApoderadosView.setVisible(true);
    }
    
}
