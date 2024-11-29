package com.principal;

import com.controlador.ControladorInicioSesion;
import com.vista.frmInicioSesionView;

public class Principal {

    public static void main(String[] args) {
        llamarFormularioPrincipal();
    }

    public static void llamarFormularioPrincipal() {
        frmInicioSesionView frm = new frmInicioSesionView();
        ControladorInicioSesion cis = new ControladorInicioSesion(frm);
    }

}
