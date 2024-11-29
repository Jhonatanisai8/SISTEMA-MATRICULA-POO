package com.controlador;

import com.Utelerias.Constantes.ConstantesFormularioInicioSesion;
import com.vista.frmInicioSesionView;
import com.procesos.ProcesoInicioSesion;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ControladorInicioSesion
        implements ConstantesFormularioInicioSesion, MouseMotionListener, MouseListener {

    private final frmInicioSesionView frmInitSesion;
    private int xEje;
    private int yEje;

    public ControladorInicioSesion(frmInicioSesionView frmInitSesion) {
        this.frmInitSesion = frmInitSesion;
        System.out.println("Iniciando Sistema....");
        // agregar listeners al panel de navegación para detectar los eventos de mouse
        this.frmInitSesion.pnlBarraNavegacion.addMouseListener(this);
        this.frmInitSesion.pnlBarraNavegacion.addMouseMotionListener(this);
        this.frmInitSesion.lblOpcionCerrar.addMouseListener(this);
        this.frmInitSesion.InicioSesionBtn.addMouseListener(this);
        this.frmInitSesion.txtContraseña.addMouseListener(this);
        this.frmInitSesion.txtUsuario.addMouseListener(this);

        // lblOpcionCerrar  y InicioSesionBtn permita cambiar su color de fondo
        this.frmInitSesion.lblOpcionCerrar.setOpaque(true);
        this.frmInitSesion.InicioSesionBtn.setOpaque(true);

        // llamando al método que presenta el formulario
        ProcesoInicioSesion.presentarFormulario(this.frmInitSesion);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        xEje = e.getX();
        yEje = e.getY();

        if (e.getSource() == this.frmInitSesion.txtUsuario) {
            if (this.frmInitSesion.txtUsuario.getText().equals("Ingrese su Usuario")) {
                this.frmInitSesion.txtUsuario.setText("");
                this.frmInitSesion.txtUsuario.setForeground(COLOR_NEGRO);
            }
            if (String.valueOf(this.frmInitSesion.txtContraseña.getPassword()).isEmpty()) {
                this.frmInitSesion.txtContraseña.setText("******************");
                this.frmInitSesion.txtContraseña.setForeground(COLOR_GRIS);
            }
        } else if (e.getSource() == this.frmInitSesion.txtContraseña) {
            if (String.valueOf(this.frmInitSesion.txtContraseña.getPassword()).equals("******************")) {
                this.frmInitSesion.txtContraseña.setText("");
                this.frmInitSesion.txtContraseña.setForeground(COLOR_NEGRO);
            }
            if (this.frmInitSesion.txtUsuario.getText().isEmpty()) {
                this.frmInitSesion.txtUsuario.setForeground(COLOR_GRIS);
                this.frmInitSesion.txtUsuario.setText("Ingrese su Usuario");
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e
    ) {
    }

    @Override
    public void mouseExited(MouseEvent e
    ) {
        // cambia de color cuando se sale de lblOpcionCerrar
        if (e.getSource() == this.frmInitSesion.lblOpcionCerrar) {
            this.frmInitSesion.lblOpcionCerrar.setForeground(COLOR_NEGRO);
            this.frmInitSesion.lblOpcionCerrar.setBackground(BLANCO);
        } //para el cambio de color de fondo del boton 
        else if (e.getSource() == this.frmInitSesion.InicioSesionBtn) {
            this.frmInitSesion.InicioSesionBtn.setBackground(COLOR_BOTON);
            this.frmInitSesion.lblOpcionCerrar.setForeground(BLANCO);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e
    ) {
        this.frmInitSesion.setLocation(e.getXOnScreen() - xEje, e.getYOnScreen() - yEje);
    }

    @Override
    public void mouseMoved(MouseEvent e
    ) {
    }

    @Override
    public void mouseEntered(MouseEvent e
    ) {
        // cambia el color de fondo cuando el mouse entra en lblOpcionCerrar
        if (e.getSource() == this.frmInitSesion.lblOpcionCerrar) {
            this.frmInitSesion.lblOpcionCerrar.setForeground(BLANCO);
            this.frmInitSesion.lblOpcionCerrar.setBackground(COLOR_ROJO);
        } //para el cambio de color de fondo del boton 
        else if (e.getSource() == this.frmInitSesion.InicioSesionBtn) {
            this.frmInitSesion.InicioSesionBtn.setBackground(COLOR_BOTON_01);
            this.frmInitSesion.lblOpcionCerrar.setForeground(BLANCO);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e
    ) {
        // cierra la aplicación si el clic ocurre en lblOpcionCerrar
        if (e.getSource() == this.frmInitSesion.lblOpcionCerrar) {
            System.exit(0);
        } //para el boton iniciarSesion
        else if (e.getSource() == this.frmInitSesion.InicioSesionBtn) {
            ProcesoInicioSesion.entrarFormulario(this.frmInitSesion);
        }
    }
}
