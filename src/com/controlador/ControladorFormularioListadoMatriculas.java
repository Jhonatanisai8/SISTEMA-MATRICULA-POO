package com.controlador;

import com.procesos.ProcesosFormularioListadoMatriculas;
import com.vista.frmListadoMatriculasView;
import com.vista.frmMenuView;
import com.vista.frmVerInformacionMatriculaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorFormularioListadoMatriculas
        implements ActionListener {

    private final frmMenuView frmMenuView;
    private final frmListadoMatriculasView frmListadoMatriculasView;

    public ControladorFormularioListadoMatriculas(frmMenuView frmMenuView, frmListadoMatriculasView frmListadoMatriculasView) {
        this.frmMenuView = frmMenuView;
        this.frmListadoMatriculasView = frmListadoMatriculasView;
        this.frmListadoMatriculasView.btnVerInformacionCompleta.addActionListener(this);
        this.frmListadoMatriculasView.btnBuscarMatricula.addActionListener(this);
        ProcesosFormularioListadoMatriculas.presentarFormulario(this.frmMenuView.dsktEscritorio, this.frmListadoMatriculasView);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.frmListadoMatriculasView.btnVerInformacionCompleta) {
            int fila = frmListadoMatriculasView.tblDatos.getSelectedRow();
            Long idEstu;
            if (fila < 0) {
                JOptionPane.showMessageDialog(null, "Por favor seleccione una fila.", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
                return;
            } else {
                idEstu = Long.valueOf(frmListadoMatriculasView.tblDatos.getValueAt(fila, 1).toString());
                frmVerInformacionMatriculaView informacionMatriculaView = new frmVerInformacionMatriculaView();
                ControladorFormularioVerInformacionMatricula cfvim = new ControladorFormularioVerInformacionMatricula(this.frmMenuView, informacionMatriculaView, idEstu);
            }
            System.out.println("Id: => " + idEstu);
            System.out.println("Click sobre el boton de ver informacion completa...");
        }
    }

}
