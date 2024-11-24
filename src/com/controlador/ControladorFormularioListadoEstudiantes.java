package com.controlador;

import static com.Utelerias.Constantes.ConstantesFormularioListadoEstudiantes.TITULOS_COLUMNAS;
import com.procesos.ProcesosFormularioListadoEstudiantes;
import static com.procesos.ProcesosFormularioListadoEstudiantes.listaEstudiantes;
import com.procesos.Servicios.ServiciosEstudiante;
import com.vista.frmListadoEstudiantesView;
import com.vista.frmMenuView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorFormularioListadoEstudiantes
        implements ActionListener {

    private final frmListadoEstudiantesView frmEstudiantesView;
    private final frmMenuView frmMenuView1;

    public ControladorFormularioListadoEstudiantes(frmListadoEstudiantesView frmEstudiantesView, frmMenuView frmMenuView1) {
        this.frmEstudiantesView = frmEstudiantesView;
        this.frmMenuView1 = frmMenuView1;
        this.frmEstudiantesView.btnBuscar.addActionListener(this);
        this.frmEstudiantesView.btnEliminar.addActionListener(this);
        ProcesosFormularioListadoEstudiantes.presentarFormulario(this.frmMenuView1.dsktEscritorio, this.frmEstudiantesView);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.frmEstudiantesView.btnBuscar) {
            if (frmEstudiantesView.txtBuscar.getText().isBlank()) {
                ServiciosEstudiante.mostrarEstudiantesEnTabla(frmEstudiantesView, TITULOS_COLUMNAS, listaEstudiantes());
            } else {
                ProcesosFormularioListadoEstudiantes.enviarEstudiante(this.frmEstudiantesView.btlData, Long.valueOf(frmEstudiantesView.txtBuscar.getText()));
            }
            System.out.println("Has dado click en el boton buscar....");
        }

        if (e.getSource() == this.frmEstudiantesView.btnEliminar) {
            ProcesosFormularioListadoEstudiantes.seleccionarDatosEliminar(this.frmEstudiantesView);
            System.out.println("Has dado click en el boton eliminar....");
        }

    }

}
