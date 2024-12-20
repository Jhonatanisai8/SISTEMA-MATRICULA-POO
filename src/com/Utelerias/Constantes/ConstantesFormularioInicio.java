package com.Utelerias.Constantes;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public interface ConstantesFormularioInicio {

    final String TEXTO_PRESENTACION = "Bienvenido al Sistema de Matrícula Escolar."
            + " \n Aquí puedes gestionar fácilmente estudiantes, "
            + "\n docentes,  cursos y horarios para llevar un "
            + "\n registro organizado y eficiente de "
            + "\n tu institución.";
    final String NOMBRE_ADMIN = "Jhon Doe";
    final String RUTA_IMAGEN_LOGO_IE = "C:\\Users\\User\\Music\\CUARTO CICLO\\08 LABORATORIOS POO\\ProyectoMatriculaPOO\\src\\com\\imgs\\iconoColegio02.jpg";
    final Font FUENTE_TEXT_PRESENTACION = new Font("Montserrat", Font.BOLD, 25);
    final Font FUENTE_TEXT_FECHA = new Font("Montserrat", Font.BOLD, 20);
    final Font FUENTE_TEXT_ADMIN = new Font("Montserrat", Font.CENTER_BASELINE, 20);
    final ImageIcon ICONO_IE = new ImageIcon(RUTA_IMAGEN_LOGO_IE);
    final Color COLOR_FONDO_BLANCO = new Color(254, 254, 254);

}
