package com.controlador;

import com.Modelo.entidades.DaoImplementacion.CursoReposiImple;
import static com.Utelerias.Constantes.ConstantesFormularioAdmCursos.ANCHO_CURSO_PROFESOR;
import static com.Utelerias.Constantes.ConstantesFormularioAdmCursos.FUENTE_TEXT_PRESENTACION;
import com.procesos.ProcesosFormularioCursoProfesor;
import com.procesos.Servicios.ServiciosCurso;
import com.vista.frmCursoProfesorView;
import com.vista.frmMenuView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorFormularioCursoProfesor
        implements ActionListener {

    private final frmMenuView frmMenuView;
    private final frmCursoProfesorView frmCursoProfesorView;

    public ControladorFormularioCursoProfesor(frmMenuView frmMenuView, frmCursoProfesorView frmCursoProfesorView) {
        this.frmMenuView = frmMenuView;
        this.frmCursoProfesorView = frmCursoProfesorView;
        this.frmCursoProfesorView.btnBuscarCurso.addActionListener(this);
        ProcesosFormularioCursoProfesor.presentarFormulario(this.frmMenuView.dsktEscritorio, this.frmCursoProfesorView);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CursoReposiImple cri = new CursoReposiImple();
        ServiciosCurso curso = new ServiciosCurso();
        frmCursoProfesorView.tblDatos.setFont(FUENTE_TEXT_PRESENTACION);
        if (e.getSource() == this.frmCursoProfesorView.btnBuscarCurso) {
            if (frmCursoProfesorView.txtBuscarProfesor.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese el nombre del profesor a buscar.", "ATENCION", JOptionPane.WARNING_MESSAGE);
                DefaultTableModel model = (DefaultTableModel) frmCursoProfesorView.tblDatos.getModel();
                frmCursoProfesorView.tblDatos.setModel(cri.listarCursosProcesos(model, ""));
                curso.establecerAnchoColumnasTabla(frmCursoProfesorView.tblDatos, ANCHO_CURSO_PROFESOR);
            } else {
                DefaultTableModel model = (DefaultTableModel) frmCursoProfesorView.tblDatos.getModel();
                frmCursoProfesorView.tblDatos.setModel(cri.listarCursosProcesos(model, frmCursoProfesorView.txtBuscarProfesor.getText()));
                curso.establecerAnchoColumnasTabla(frmCursoProfesorView.tblDatos, ANCHO_CURSO_PROFESOR);
            }
        }
    }

}
