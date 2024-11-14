package com.Utelerias.Constantes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.ImageIcon;

public interface ConstantesFormularioInicioSesion {

    //usuario administrador 
    final String USUARIO = "admin";
    final String PASSWORD = "admin123";
    //rutas para las imagenes
    String RUTA_IMAGEN_LOGO = "C:\\Users\\User\\Music\\CUARTO CICLO\\08 LABORATORIOS POO\\ProyectoMatriculaPOO\\src\\com\\imgs\\EdificioPequeño.png";
    String RUTA_IMAGEN_FONDO = "C:\\Users\\User\\Music\\CUARTO CICLO\\08 LABORATORIOS POO\\ProyectoMatriculaPOO\\src\\com\\imgs\\iconoColegio02.jpg";
    //fuentes
    final Font FUENTE_LBL_USUARIO = new Font("Montserrat", Font.BOLD, 14);
    final Font FUENTE_LBL_INICIO_SESION = new Font("Montserrat", Font.BOLD, 18);
    final Font FUENTE_LBL_BTN_INICIO_SESION = new Font("Montserrat", Font.CENTER_BASELINE, 25);

    //colores
    final Color BLANCO = Color.WHITE;
    final Color GRIS = Color.GRAY;
    final Color COLOR_BOTON = new Color(0, 77, 123);
    
    //cursores
    final Cursor CURSOR_MANO = new Cursor(Cursor.HAND_CURSOR);
    
    //iconos 
    final ImageIcon ICONO_LOGO = new ImageIcon(RUTA_IMAGEN_LOGO);
    final ImageIcon ICONO_FONDO_IE = new ImageIcon(RUTA_IMAGEN_FONDO);
    
}
