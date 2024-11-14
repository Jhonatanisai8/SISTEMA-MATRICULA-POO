package com.procesos;

import com.vista.frmMenuView;
import javax.swing.ImageIcon;

public class ProcesosFrmMenuView {
    
    public static void ponerIconosMenus(frmMenuView frenuView) {
        frenuView.mnInicio.setIcon(new ImageIcon("C:\\Users\\User\\Music\\CUARTO CICLO\\08 LABORATORIOS POO\\ProyectoMatriculaPOO\\src\\com\\imgs\\Inicio.png"));
        frenuView.mnEstudiantes.setIcon(new ImageIcon("C:\\Users\\User\\Music\\CUARTO CICLO\\08 LABORATORIOS POO\\ProyectoMatriculaPOO\\src\\com\\imgs\\Estudiante.png"));
        frenuView.mnDocentes.setIcon(new ImageIcon("C:\\Users\\User\\Music\\CUARTO CICLO\\08 LABORATORIOS POO\\ProyectoMatriculaPOO\\src\\com\\imgs\\Profesor.png"));
        frenuView.mnSalones.setIcon(new ImageIcon("C:\\Users\\User\\Music\\CUARTO CICLO\\08 LABORATORIOS POO\\ProyectoMatriculaPOO\\src\\com\\imgs\\Aula.png"));
        frenuView.mnMatricula.setIcon(new ImageIcon("C:\\Users\\User\\Music\\CUARTO CICLO\\08 LABORATORIOS POO\\ProyectoMatriculaPOO\\src\\com\\imgs\\Matricula.png"));
        frenuView.mnListados.setIcon(new ImageIcon("C:\\Users\\User\\Music\\CUARTO CICLO\\08 LABORATORIOS POO\\ProyectoMatriculaPOO\\src\\com\\imgs\\Listados.png"));
        frenuView.mnSalir.setIcon(new ImageIcon("C:\\Users\\User\\Music\\CUARTO CICLO\\08 LABORATORIOS POO\\ProyectoMatriculaPOO\\src\\com\\imgs\\CerrarSesion.png"));
        frenuView.mnHorarios.setIcon(new ImageIcon("C:\\Users\\User\\Music\\CUARTO CICLO\\08 LABORATORIOS POO\\ProyectoMatriculaPOO\\src\\com\\imgs\\Horario.png"));
        frenuView.mnCursos.setIcon(new ImageIcon("C:\\Users\\User\\Music\\CUARTO CICLO\\08 LABORATORIOS POO\\ProyectoMatriculaPOO\\src\\com\\imgs\\Curso.png"));
    }
    
    public static void presentarFormularioMenu(frmMenuView frenuView) {
        ponerIconosMenus(frenuView);
        frenuView.setResizable(false);
    }
}
