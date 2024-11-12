package com.principal;

import com.controlador.ControladorInicioSesion;
import com.vista.frmInicioSesion;

public class Principal {
    
    public static void main(String[] args) {
        // TODO code application logic here
        frmInicioSesion frm = new frmInicioSesion();
        ControladorInicioSesion cis = new ControladorInicioSesion(frm);
    }
    
}
