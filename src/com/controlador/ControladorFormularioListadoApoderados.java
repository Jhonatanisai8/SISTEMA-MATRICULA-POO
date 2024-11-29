package com.controlador;

import com.procesos.ProcesosFormularioListadoApoderados;
import com.procesos.Servicios.ServiciosApoderado;
import com.vista.frmListadoApoderadosView;
import com.vista.frmMenuView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static com.Utelerias.Constantes.ConstantesFormularioRegistroApoderado.*;
import static com.procesos.ProcesosFormularioListadoApoderados.listaApoderados;
import javax.swing.JOptionPane;

public class ControladorFormularioListadoApoderados
        implements ActionListener {

    private final frmMenuView frmMenuView;
    private final frmListadoApoderadosView frmListadoApoderadosView;

    public ControladorFormularioListadoApoderados(frmMenuView frmMenuView, frmListadoApoderadosView frmListadoApoderadosView) {
        this.frmMenuView = frmMenuView;
        this.frmListadoApoderadosView = frmListadoApoderadosView;
        this.frmListadoApoderadosView.btnEliminar.addActionListener(this);
        this.frmListadoApoderadosView.btnBuscar.addActionListener(this);
        ProcesosFormularioListadoApoderados.presentarFormulario(this.frmMenuView.dsktEscritorio, this.frmListadoApoderadosView);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //boton eliminar
        if (e.getSource() == this.frmListadoApoderadosView.btnEliminar) {
            ProcesosFormularioListadoApoderados.seleccionarDatosEliminar(this.frmListadoApoderadosView);
            System.out.println("Click en el boton eliminar.....");
        }
        //boton buscar 
        if (e.getSource() == this.frmListadoApoderadosView.btnBuscar) {
            if (this.frmListadoApoderadosView.txtBuscar.getText().isBlank()) {
                ServiciosApoderado.mostrarEstudiantesEnTabla(this.frmListadoApoderadosView, ENCABEZADOS_TABLA, listaApoderados());
            } else {
                boolean dniValido = true;
                Long dni = null;
                try {
                    dni = Long.valueOf(this.frmListadoApoderadosView.txtBuscar.getText());
                    dniValido = false;
                } catch (NumberFormatException es) {
                    JOptionPane.showMessageDialog(null, "Por favor debe ingresar un numero de dni valido!.", "Atención", 3);
                    return;
                }
                if (!dniValido) {
                    ProcesosFormularioListadoApoderados.enviarApoderado(this.frmListadoApoderadosView.tblDatos, dni);
                }
            }
            System.out.println("Click sobre el boton Buscar.....");
        }
    }

}
