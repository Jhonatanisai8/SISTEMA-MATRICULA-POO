package com.procesos;

import com.Utelerias.Constantes.ConstantesFormularioListadoEstudiantesDocentes;
import com.vista.frmListadoDocentesView;

public class ProcesosFormularioListadoDocentes
        implements ConstantesFormularioListadoEstudiantesDocentes {

    private static void ponerIconosFormulario(frmListadoDocentesView frmListadoDocentesView) {
        frmListadoDocentesView.btnBuscar.setIcon(ICONO_BUSCAR);
        frmListadoDocentesView.btnModificar.setIcon(ICONO_MODIFICAR);
        frmListadoDocentesView.btnEliminar.setIcon(ICONO_ELIMINAR);
    }
    
    
}
