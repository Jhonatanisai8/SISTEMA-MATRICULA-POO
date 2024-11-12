package com.controlador;

import com.vista.frmInicioSesion;
import com.procesos.ProcesoInicioSesion;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ControladorInicioSesion implements MouseMotionListener, MouseListener {

    private frmInicioSesion frmInitSesion;
    private JPanel panelNavegacion;
    private int xEje;
    private int yEje;

    public ControladorInicioSesion(frmInicioSesion frmInitSesion) {
        this.frmInitSesion = frmInitSesion;

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
                this.frmInitSesion.txtUsuario.setForeground(Color.black);
            }
            if (String.valueOf(this.frmInitSesion.txtContraseña.getPassword()).isEmpty()) {
                this.frmInitSesion.txtContraseña.setText("******************");
                this.frmInitSesion.txtContraseña.setForeground(Color.gray);
            }
        } else if (e.getSource() == this.frmInitSesion.txtContraseña) {
            if (String.valueOf(this.frmInitSesion.txtContraseña.getPassword()).equals("******************")) {
                this.frmInitSesion.txtContraseña.setText("");
                this.frmInitSesion.txtContraseña.setForeground(Color.black);
            }
            if (this.frmInitSesion.txtUsuario.getText().isEmpty()) {
                this.frmInitSesion.txtUsuario.setForeground(Color.gray);
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
            this.frmInitSesion.lblOpcionCerrar.setForeground(Color.BLACK);
            this.frmInitSesion.lblOpcionCerrar.setBackground(Color.white);
        } //para el cambio de color de fondo del boton 
        else if (e.getSource() == this.frmInitSesion.InicioSesionBtn) {
            this.frmInitSesion.InicioSesionBtn.setBackground(new Color(0, 77, 123));
            this.frmInitSesion.lblOpcionCerrar.setForeground(Color.WHITE);
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
            this.frmInitSesion.lblOpcionCerrar.setForeground(Color.WHITE);
            this.frmInitSesion.lblOpcionCerrar.setBackground(Color.red);
        } //para el cambio de color de fondo del boton 
        else if (e.getSource() == this.frmInitSesion.InicioSesionBtn) {
            this.frmInitSesion.InicioSesionBtn.setBackground(new Color(0, 134, 125));
            this.frmInitSesion.lblOpcionCerrar.setForeground(Color.WHITE);
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
