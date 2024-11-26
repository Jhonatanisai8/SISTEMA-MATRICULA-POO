package com.procesos.Validaciones;

import com.vista.frmAdmistrarSalonesView;

public class ValidacionesFrmAdmSalones {

    public static String validarCampos(frmAdmistrarSalonesView frAdmistrarSalonesVie) {
        if (frAdmistrarSalonesVie.txtNombreSalon.getText().isBlank()
                || frAdmistrarSalonesVie.txtNombreSalon.getText().length() > 50) {
            return "Nombre del Salón";
        }

        if (Integer.parseInt(frAdmistrarSalonesVie.spnCapacidad.getValue().toString()) <= 0) {
            return "Capacidad del Salón";
        }
        if (frAdmistrarSalonesVie.txtReferenciaSalon.getText().isBlank()
                || frAdmistrarSalonesVie.txtReferenciaSalon.getText().length() > 45) {
            return "Referencia";
        }

        return "";
    }
}
