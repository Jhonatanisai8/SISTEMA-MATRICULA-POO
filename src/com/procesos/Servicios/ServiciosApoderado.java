package com.procesos.Servicios;

import com.vista.frmRegistrarApoderadoView;

public class ServiciosApoderado {

    public static void limpiarDatos(frmRegistrarApoderadoView frmRegistrarApoderadoView) {
        frmRegistrarApoderadoView.txtApMaterno.setText("");
        frmRegistrarApoderadoView.txtApPaterno.setText("");
        frmRegistrarApoderadoView.txtCalle.setText("");
        frmRegistrarApoderadoView.txtDistrito.setText("");
        frmRegistrarApoderadoView.txtEmailpersonal.setText("");
        frmRegistrarApoderadoView.txtNombre.setText("");
        frmRegistrarApoderadoView.txtNumeroCalle.setText("");
        frmRegistrarApoderadoView.txtNumeroDocumento.setText("");
        frmRegistrarApoderadoView.txtTelefono.setText("");
        frmRegistrarApoderadoView.txtNombre.requestFocus();

        frmRegistrarApoderadoView.cbxEstadoCivil.setSelectedIndex(0);
        frmRegistrarApoderadoView.cbxOcupacion.setSelectedIndex(0);
        frmRegistrarApoderadoView.cbxProvincia.setSelectedIndex(0);
        frmRegistrarApoderadoView.cbxRelacion.setSelectedIndex(0);
        frmRegistrarApoderadoView.cbxTipoDocumento.setSelectedIndex(0);
        frmRegistrarApoderadoView.dtcFechaNacimiento.setDate(null);

    }
}
