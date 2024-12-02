package com.procesos.Validaciones;

import com.vista.frmAdmistrarHorariosView;

public class ValidacionesFrmAdmHorarios {

    public static String validarCampos(frmAdmistrarHorariosView frmAdmistrarHorariosView) {
        if (frmAdmistrarHorariosView.cbxDiaSemana.getSelectedIndex() == 0) {
            return "Dia de Semana";
        }
        if (frmAdmistrarHorariosView.cbxHoraInicio.getSelectedIndex() == 0) {
            return "Hora de Inicio.";
        }
        if (frmAdmistrarHorariosView.cbxHoraFin.getSelectedIndex() == 0) {
            return "Hora de Fin.";
        }
        if (frmAdmistrarHorariosView.cbxTurno.getSelectedIndex() == 0) {
            return "Turno.";
        }
        return "";
    }
}
