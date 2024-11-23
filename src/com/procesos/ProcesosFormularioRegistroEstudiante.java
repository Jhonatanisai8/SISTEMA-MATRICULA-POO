package com.procesos;

import com.Utelerias.Constantes.ConstantesFormularioRegistroEstudiante;
import com.vista.frmRegistrarEstudianteView;
import javax.swing.JDesktopPane;

public class ProcesosFormularioRegistroEstudiante
        implements ConstantesFormularioRegistroEstudiante {

    private static void rellenarComboBox(frmRegistrarEstudianteView frEstudiante) {
        frEstudiante.cbxProvincia.removeAllItems();
        for (String string : PROVINCIAS) {
            frEstudiante.cbxProvincia.addItem(string);
        }
        frEstudiante.cbxTipoDocumento.removeAllItems();
        for (String string : TIPO_DOCUMENTO) {
            frEstudiante.cbxTipoDocumento.addItem(string);
        }
    }

    private static void ponerIconosFormulario(frmRegistrarEstudianteView frEstudiante) {
        frEstudiante.btnGuardar.setIcon(ICONO_BOTON_GUARDAR);
    }

    public static void presentarFormulario(JDesktopPane desktopPane, frmRegistrarEstudianteView fr) {
        rellenarComboBox(fr);
        ponerIconosFormulario(fr);
        fr.setTitle("Datos del estudiante");
        desktopPane.add(fr);
        fr.toFront();
        fr.setVisible(true);
    }
}
