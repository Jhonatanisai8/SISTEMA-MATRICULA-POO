package com.procesos;

import com.Utelerias.Constantes.ConstantesFormularioRegistroEstudiante;
import com.vista.frmRegistrarEstudiante;
import javax.swing.JDesktopPane;

public class ProcesosFormularioRegistroEstudiante
        implements ConstantesFormularioRegistroEstudiante {

    private static void rellenarComboBox(frmRegistrarEstudiante frEstudiante) {
        frEstudiante.cbxProvincia.removeAllItems();
        for (String string : PROVINCIAS) {
            frEstudiante.cbxProvincia.addItem(string);
        }
        frEstudiante.cbxTipoDocumento.removeAllItems();
        for (String string : TIPO_DOCUMENTO) {
            frEstudiante.cbxTipoDocumento.addItem(string);
        }
    }

    private static void ponerIconosFormulario(frmRegistrarEstudiante frEstudiante) {
        frEstudiante.jButton1.setIcon(ICONO_BOTON_GUARDAR);
    }

    public static void presentarFormulario(JDesktopPane desktopPane, frmRegistrarEstudiante fr) {
        rellenarComboBox(fr);
        ponerIconosFormulario(fr);
        fr.setTitle("Presentando");
        desktopPane.add(fr);
        fr.toFront();
        fr.setVisible(true);
    }
}
