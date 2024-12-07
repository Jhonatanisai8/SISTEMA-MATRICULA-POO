package com.principal;

import com.Utelerias.Constantes.ConstantesFormularioAdmCursos;
import com.controlador.ControladorInicioSesion;
import com.vista.frmInicioSesionView;

public class Principal
        implements ConstantesFormularioAdmCursos {

    public static void main(String[] args) {
        llamarFormularioPrincipal();
    }

    public static void llamarFormularioPrincipal() {
        frmInicioSesionView frm = new frmInicioSesionView();
        ControladorInicioSesion cis = new ControladorInicioSesion(frm);
    }
}
