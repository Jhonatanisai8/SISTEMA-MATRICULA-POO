package com.procesos;

import com.Modelo.entidades.DaoImplementacion.AsignacionRepoImple;
import static com.Utelerias.Constantes.ConstantesFormularioAdmCursos.FUENTE_TEXT_PRESENTACION;
import com.Utelerias.Constantes.ConstantesFormularioRegistrarAsignacion;
import com.procesos.Servicios.ServiciosAdmAsignaciones;
import com.vista.frmListarAsignacionesView;
import javax.swing.JDesktopPane;

public class ProcesosFormularioListadoAsignaciones
        implements ConstantesFormularioRegistrarAsignacion {

    public static void presentarFormulario(JDesktopPane desktopPane, frmListarAsignacionesView frmAsignacionesVie) {
        ServiciosAdmAsignaciones admAsignaciones = new ServiciosAdmAsignaciones();
        frmAsignacionesVie.tblData.setFont(FUENTE_TEXT_PRESENTACION);
        AsignacionRepoImple ari = new AsignacionRepoImple();
        desktopPane.removeAll();
        desktopPane.add(frmAsignacionesVie);
        frmAsignacionesVie.setTitle("Listado de Asignaciones");
        frmAsignacionesVie.setVisible(true);
        admAsignaciones.mostrarRegistrosEnTabla(frmAsignacionesVie.tblData, ENCABEZADO_ASIGNACIONES, ari.listar());
        admAsignaciones.establecerAnchoColumnasTabla(frmAsignacionesVie.tblData, TAMANIO_COLUMNAS);
    }
}
