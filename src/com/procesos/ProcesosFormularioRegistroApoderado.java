package com.procesos;

import com.Utelerias.Constantes.ConstantesFormularioRegistroApoderado;
import com.vista.frmRegistrarApoderadoView;

public class ProcesosFormularioRegistroApoderado
        implements ConstantesFormularioRegistroApoderado {

    private static void rellenarComboBox(frmRegistrarApoderadoView frmRegistrarApoderadoView) {
        //eliminamos los elementos
        frmRegistrarApoderadoView.cbxEstadoCivil.removeAllItems();
        frmRegistrarApoderadoView.cbxOcupacion.removeAllItems();
        frmRegistrarApoderadoView.cbxProvincia.removeAllItems();
        frmRegistrarApoderadoView.cbxRelacion.removeAllItems();
        frmRegistrarApoderadoView.cbxTipoDocumento.removeAllItems();

        //rellenamos los comboz
        for (String estado : ESTADO_CIVIL) {
            frmRegistrarApoderadoView.cbxEstadoCivil.addItem(estado);
        }
        for (String ocupacion : OCUPACIONES) {
            frmRegistrarApoderadoView.cbxOcupacion.addItem(ocupacion);
        }
        for (String provincia : PROVINCIAS) {
            frmRegistrarApoderadoView.cbxProvincia.addItem(provincia);
        }
        for (String rela : RELACION_ESTUDIANTE) {
            frmRegistrarApoderadoView.cbxRelacion.addItem(rela);
        }
        for (String tipoDoc : TIPO_DOCUMENTO) {
            frmRegistrarApoderadoView.cbxTipoDocumento.addItem(tipoDoc);
        }

    }
}
