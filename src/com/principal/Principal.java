package com.principal;

import com.controlador.ControladorInicioSesion;
import com.vista.frmInicioSesionView;

public class Principal {

    public static void main(String[] args) {
        llamarFormularioPrincipal();
//        Repositorio<Estudiante> repo = new EstudianteReposioImple();
//        System.out.println("Lista de estudiantes");
//        repo.listar().forEach(System.out::println);
    }

    public static void llamarFormularioPrincipal() {
        // TODO code application logic here
        frmInicioSesionView frm = new frmInicioSesionView();
        ControladorInicioSesion cis = new ControladorInicioSesion(frm);
    }

}
