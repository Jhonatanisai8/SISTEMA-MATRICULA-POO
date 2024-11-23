package com.principal;

import com.controlador.ControladorInicioSesion;
import com.vista.frmInicioSesionView;
import java.util.Random;

public class Principal {

    public static void main(String[] args) {
        llamarFormularioPrincipal();
    }

    public static void llamarFormularioPrincipal() {
        // TODO code application logic here
        frmInicioSesionView frm = new frmInicioSesionView();
        ControladorInicioSesion cis = new ControladorInicioSesion(frm);
    }

}
