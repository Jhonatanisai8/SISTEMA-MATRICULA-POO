package com.controlador;

import com.Modelo.entidades.Estudiante;
import static com.Utelerias.Constantes.ConstantesFormularioListadoEstudiantesDocentes.TITULOS_COLUMNAS;
import com.procesos.ProcesosFormularioListadoEstudiantes;
import static com.procesos.ProcesosFormularioListadoEstudiantes.listaEstudiantes;
import com.procesos.Servicios.ServiciosEstudianteDocente;
import com.vista.frmListadoEstudiantesView;
import com.vista.frmMenuView;
import com.vista.frmRegistrarEstudianteView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorFormularioListadoEstudiantes
        implements ActionListener {

    private final frmListadoEstudiantesView frmEstudiantesView;
    private final frmMenuView frmMenuView1;

    public ControladorFormularioListadoEstudiantes(frmListadoEstudiantesView frmEstudiantesView, frmMenuView frmMenuView1) {
        this.frmEstudiantesView = frmEstudiantesView;
        this.frmMenuView1 = frmMenuView1;
        this.frmEstudiantesView.btnBuscar.addActionListener(this);
        this.frmEstudiantesView.btnEliminar.addActionListener(this);
        this.frmEstudiantesView.btnModificar.addActionListener(this);
        ProcesosFormularioListadoEstudiantes.presentarFormulario(this.frmMenuView1.dsktEscritorio, this.frmEstudiantesView);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ServiciosEstudianteDocente serviciosEstudianteDocente = new ServiciosEstudianteDocente();
        //evento en el boton buscar
        if (e.getSource() == this.frmEstudiantesView.btnBuscar) {
            if (frmEstudiantesView.txtBuscar.getText().isBlank()) {
                serviciosEstudianteDocente.mostrarEstudiantesEnTabla(frmEstudiantesView.btlData, TITULOS_COLUMNAS, listaEstudiantes());
            } else {
                boolean dniValido = true;
                Long dni = null;
                try {
                    dni = Long.valueOf(frmEstudiantesView.txtBuscar.getText());
                    dniValido = false;
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor debe ingresar un numero de dni valido!.", "Atención", 3);
                    return;
                }
                if (!dniValido) {
                    ProcesosFormularioListadoEstudiantes.enviarEstudiante(this.frmEstudiantesView.btlData, dni);
                }
            }
            System.out.println("Has dado click en el boton buscar....");
        }

        //evento en el boton eliminar
        if (e.getSource() == this.frmEstudiantesView.btnEliminar) {
            ProcesosFormularioListadoEstudiantes.seleccionarDatosEliminar(this.frmEstudiantesView);
            System.out.println("Has dado click en el boton eliminar....");
        }
        //evento en el boton modificar
        if (e.getSource() == this.frmEstudiantesView.btnModificar) {
            int filaSelecionada = frmEstudiantesView.btlData.getSelectedRow();
            if (filaSelecionada >= 0) {
                Estudiante estudiante = ProcesosFormularioListadoEstudiantes.obtenerEstudiante(Long.valueOf(frmEstudiantesView.btlData.getValueAt(filaSelecionada, 6).toString()));
                frmRegistrarEstudianteView frmRegistrarEstudianteView1 = new frmRegistrarEstudianteView(estudiante);
                this.frmEstudiantesView.dispose();
                ControladorFormularioRegistroEstudiantes cfre = new ControladorFormularioRegistroEstudiantes(this.frmMenuView1, frmRegistrarEstudianteView1, estudiante);
            } else {
                JOptionPane.showMessageDialog(null, "Por favor debe seleccionar un estudiante para poder Modificar su Informacion", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
            }
            System.out.println("Has dado click el boton Modificar");
        }

    }

}
