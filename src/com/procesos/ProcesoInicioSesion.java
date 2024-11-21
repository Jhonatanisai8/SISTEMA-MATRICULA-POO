package com.procesos;

import com.controlador.ControladorFormularioMenuView;
import com.vista.frmInicioSesionView;
import com.vista.frmMenuView;
import javax.swing.JOptionPane;
import com.Utelerias.Constantes.ConstantesFormularioInicioSesion;

public class ProcesoInicioSesion
        implements ConstantesFormularioInicioSesion {

    private static void ponerIconosFormulario(frmInicioSesionView fr) {
        fr.lblLogo.setIcon(ICONO_LOGO);
        fr.lblLogo.setText("Jhonatan's");
        fr.lblImagenFondo.setIcon(ICONO_FONDO_IE);
    }

    private static void estilosInicioSesion(frmInicioSesionView fr) {
        //bordes y fondos de los texfiedl
        fr.txtUsuario.setBorder(null);
        fr.txtContraseña.setBorder(null);
        fr.txtContraseña.setBackground(BLANCO);
        fr.txtUsuario.setBackground(BLANCO);

        //fondos
        fr.pnlBackground.setBackground(BLANCO);
        //texto por defecto
        fr.txtUsuario.setText("Ingrese su Usuario");
        fr.txtContraseña.setText("******************");
        fr.InicioSesionBtn.setText("Iniciar Sesión");
        fr.InicioSesionBtn.setHorizontalAlignment(0);
        //estilos de fuentes
        fr.lblUsuario.setFont(FUENTE_LBL_USUARIO);
        fr.lblContraseña.setFont(FUENTE_LBL_USUARIO);
        fr.lblInicioSesion.setFont(FUENTE_LBL_INICIO_SESION);
        fr.btnIniciarSesion.setFont(FUENTE_LBL_BTN_INICIO_SESION);

        //color de fuente
        fr.txtUsuario.setForeground(COLOR_GRIS);
        fr.txtContraseña.setForeground(COLOR_GRIS);
        fr.InicioSesionBtn.setForeground(BLANCO);

        //color del boton (formato rgb)
        fr.btnIniciarSesion.setBackground(COLOR_BOTON);
        fr.InicioSesionBtn.setBackground(COLOR_BOTON);

        //cursor
        fr.InicioSesionBtn.setCursor(CURSOR_MANO);

        //para evitar el cambio de tamaño
        fr.setResizable(false);

        //para la barra de opciones
        fr.pnlBarraNavegacion.setBackground(BLANCO);
        fr.lblOpcionCerrar.setText("X");
        fr.lblOpcionCerrar.setHorizontalAlignment(0);
        fr.lblOpcionCerrar.setCursor(CURSOR_MANO);
        fr.lblOpcionCerrar.setBackground(BLANCO);
    }

    public static void presentarFormulario(frmInicioSesionView fr) {
        ponerIconosFormulario(fr);
        estilosInicioSesion(fr);

        fr.setTitle("Bienvenido al sistema".toUpperCase());

        fr.setVisible(true);
        fr.setLocationRelativeTo(null);
    }

    public static void entrarFormulario(frmInicioSesionView fr) {
        if (fr.txtUsuario.getText().isBlank() && fr.txtContraseña.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor completar los campos.", "Campos Vacios", JOptionPane.WARNING_MESSAGE);
        } else {
            if (fr.txtUsuario.getText().equals(ConstantesFormularioInicioSesion.USUARIO)
                    && fr.txtContraseña.getText().equals(ConstantesFormularioInicioSesion.PASSWORD)) {
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
