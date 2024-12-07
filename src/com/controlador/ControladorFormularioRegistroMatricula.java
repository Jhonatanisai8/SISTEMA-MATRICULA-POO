package com.controlador;

import com.Modelo.entidades.DaoImplementacion.MatriculaRepoImple;
import com.Modelo.entidades.Matricula;
import static com.Utelerias.Constantes.ConstantesFormularioRegistroMatricula.ANCHO_COLUMAS;
import com.procesos.ProcesosFormularioRegistroMatricula;
import com.procesos.Servicios.ServiciosMatricula;
import com.procesos.Validaciones.ValidacionesFormularioRegistroMatricula;
import com.vista.frmMenuView;
import com.vista.frmRegistrarMatriculasView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorFormularioRegistroMatricula
        implements ActionListener {

    private final frmMenuView frmMenuView;
    private final frmRegistrarMatriculasView frmRegistrarMatriculasView;
    private Matricula matricula;

    public ControladorFormularioRegistroMatricula(frmMenuView frmMenuView, frmRegistrarMatriculasView frmRegistrarMatriculasView) {
        this.frmMenuView = frmMenuView;
        this.frmRegistrarMatriculasView = frmRegistrarMatriculasView;
        this.frmRegistrarMatriculasView.btnBuscarAsignacion.addActionListener(this);
        this.frmRegistrarMatriculasView.btnBuscarEstudent.addActionListener(this);
        this.frmRegistrarMatriculasView.btnRegistrarMatricula.addActionListener(this);
        ProcesosFormularioRegistroMatricula.presentarFormulario(this.frmMenuView.dsktEscritorio, this.frmRegistrarMatriculasView);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MatriculaRepoImple matriculaRepoImple = new MatriculaRepoImple();
        if (e.getSource() == this.frmRegistrarMatriculasView.btnRegistrarMatricula) {
            String validacion = ValidacionesFormularioRegistroMatricula.validarFilasSelecionadas(frmRegistrarMatriculasView.tblEstudiantes, frmRegistrarMatriculasView.tblAsignaciones);
            if (!validacion.equals("")) {
                System.out.println("Selecionar fila de: " + validacion);
                JOptionPane.showMessageDialog(null, "Debe ser selecionar una fila " + validacion, "ATENCION", JOptionPane.WARNING_MESSAGE);
                return;
            } else {
                matricula = ProcesosFormularioRegistroMatricula.crearMatriculaDesdeFormulario(this.frmRegistrarMatriculasView);
                matriculaRepoImple.guardar(matricula);
                matriculaRepoImple.listarInformacion(frmRegistrarMatriculasView.tblAsignaciones);
                ServiciosMatricula.establecerAnchoColumnasTabla(frmRegistrarMatriculasView.tblAsignaciones, ANCHO_COLUMAS);
                JOptionPane.showMessageDialog(null, "Matricula con Exito.!", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
            }
            System.out.println("Click sobre el boton Registrar Matricula....");
        }
    }

}
