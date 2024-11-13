package com.principal;

import com.controlador.ControladorInicioSesion;
import com.vista.frmInicioSesionView;

public class Principal {
    
    public static void main(String[] args) {
        // TODO code application logic here
        frmInicioSesionView frm = new frmInicioSesionView();
        ControladorInicioSesion cis = new ControladorInicioSesion(frm);
    }
    
}
