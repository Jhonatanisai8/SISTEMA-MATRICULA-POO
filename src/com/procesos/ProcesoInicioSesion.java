package com.procesos;

import com.constantes.ConstantesInicioSesion;
import com.controlador.ControladorFormularioMenuView;
import com.vista.frmInicioSesionView;
import com.vista.frmMenuView;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ProcesoInicioSesion
        implements ConstantesInicioSesion {

    private static void ponerImagenLogos(frmInicioSesionView fr) {
        String rutaImagenLogo = "C:\\Users\\User\\Music\\CUARTO CICLO\\08 LABORATORIOS POO\\ProyectoMatriculaPOO\\src\\com\\imgs\\EdificioPequeño.png";
        String rutaImagenFondo = "C:\\Users\\User\\Music\\CUARTO CICLO\\08 LABORATORIOS POO\\ProyectoMatriculaPOO\\src\\com\\imgs\\iconoColegio02.jpg";
        ImageIcon imgIconoLogo = new ImageIcon(rutaImagenLogo);
        fr.lblLogo.setIcon(imgIconoLogo);
        fr.lblLogo.setText("Jhonatan's");
        ImageIcon imgIconoFondo = new ImageIcon(rutaImagenFondo);
        fr.lblImagenFondo.setIcon(imgIconoFondo);
    }

    private static void estilosInicioSesion(frmInicioSesionView fr) {
        //bordes y fondos de los texfiedl
        fr.txtUsuario.setBorder(null);
        fr.txtContraseña.setBorder(null);
        fr.txtContraseña.setBackground(Color.white);
        fr.txtUsuario.setBackground(Color.white);

        //fondos
        fr.pnlBackground.setBackground(Color.WHITE);
        //texto por defecto
        fr.txtUsuario.setText("Ingrese su Usuario");
        fr.txtContraseña.setText("******************");
        fr.InicioSesionBtn.setText("Iniciar Sesión");
        fr.InicioSesionBtn.setHorizontalAlignment(0);
        //estilos de fuentes
        fr.lblUsuario.setFont(new Font("Montserrat", Font.BOLD, 14));
        fr.lblContraseña.setFont(new Font("Montserrat", Font.BOLD, 14));
        fr.lblInicioSesion.setFont(new Font("Montserrat", Font.BOLD, 18));
        fr.btnIniciarSesion.setFont(new Font("Montserrat", Font.CENTER_BASELINE, 25));

        //color de fuente
        fr.txtUsuario.setForeground(Color.GRAY);
        fr.txtContraseña.setForeground(Color.GRAY);
        fr.InicioSesionBtn.setForeground(Color.white);

        //color del boton (formato rgb)
        fr.btnIniciarSesion.setBackground(new Color(0, 77, 123));
        fr.InicioSesionBtn.setBackground(new Color(0, 77, 123));

        //cursor
        fr.InicioSesionBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        //para evitar el cambio de tamaño
        fr.setResizable(false);

        //para la barra de opciones
        fr.pnlBarraNavegacion.setBackground(Color.white);
        fr.lblOpcionCerrar.setText("X");
        fr.lblOpcionCerrar.setHorizontalAlignment(0);
        fr.lblOpcionCerrar.setCursor(new Cursor(Cursor.HAND_CURSOR) {
        });
        fr.lblOpcionCerrar.setBackground(Color.WHITE);
    }

    public static void presentarFormulario(frmInicioSesionView fr) {
        ponerImagenLogos(fr);
        estilosInicioSesion(fr);

        fr.setTitle("Bienvenido al sistema".toUpperCase());

        fr.setVisible(true);
        fr.setLocationRelativeTo(null);
    }

    public static void entrarFormulario(frmInicioSesionView fr) {
        if (fr.txtUsuario.getText().isBlank() && fr.txtContraseña.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor completar los campos.", "Campos Vacios", JOptionPane.WARNING_MESSAGE);
        } else {
            if (fr.txtUsuario.getText().equals(ConstantesInicioSesion.usuario)
                    && fr.txtContraseña.getText().equals(ConstantesInicioSesion.password)) {
                //JOptionPane.showMessageDialog(null, "Hola Bienvenido", "Bienvenido al Sistema", JOptionPane.INFORMATION_MESSAGE);
                //hacemos visible el menu 
                fr.dispose();
                frmMenuView frMenu = new frmMenuView();
                frMenu.setVisible(true);
                ControladorFormularioMenuView cfmv = new ControladorFormularioMenuView(frMenu);
            } else {
                JOptionPane.showMessageDialog(null, "Usuario O Contraseña Incorrecta.", "Credenciales Incorrectas", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
