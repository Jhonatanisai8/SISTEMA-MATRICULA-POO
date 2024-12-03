package com.controlador;

import com.Modelo.entidades.Curso;
import com.Modelo.entidades.DaoImplementacion.CursoReposiImple;
import com.Modelo.entidades.InterfaceDao.Repositorio;
import static com.Utelerias.Constantes.ConstantesFormularioAdmCursos.ENCABEZADO_COLUMNAS_TABLA;
import static com.Utelerias.Constantes.ConstantesFormularioAdmCursos.ANCH0_COLUMNAS;
import com.procesos.ProcesosFormularioAdmistrarCursos;
import com.procesos.Servicios.ServiciosCurso;
import com.vista.frmAdmistrarCursos;
import com.vista.frmMenuView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorFormularioAdmCursos
        implements ActionListener {

    private final frmMenuView frmMenuView;
    private final frmAdmistrarCursos frmAdmistrarCursos;
    private Curso miCurso;

    public ControladorFormularioAdmCursos(frmMenuView frmMenuView, frmAdmistrarCursos frmAdmistrarCursos) {
        this.frmMenuView = frmMenuView;
        this.frmAdmistrarCursos = frmAdmistrarCursos;
        this.frmAdmistrarCursos.btnGuardarCurso.addActionListener(this);
        ProcesosFormularioAdmistrarCursos.presentarFormulario(this.frmMenuView.dsktEscritorio, this.frmAdmistrarCursos);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Repositorio<Curso> repo = new CursoReposiImple();
        ServiciosCurso admCurso = new ServiciosCurso();
        //clik sobre guardar 
        if (e.getSource() == this.frmAdmistrarCursos.btnGuardarCurso) {
            miCurso = ProcesosFormularioAdmistrarCursos.creaCursoFormulario(this.frmAdmistrarCursos);
            if (miCurso != null) {
                repo.guardar(miCurso);
                admCurso.mostrarRegistrosEnTabla(frmAdmistrarCursos.tblDatosCursos, ENCABEZADO_COLUMNAS_TABLA, repo.listar());
                admCurso.establecerAnchoColumnasTabla(this.frmAdmistrarCursos.tblDatosCursos, ANCH0_COLUMNAS);
                ServiciosCurso.limpiarCampos(this.frmAdmistrarCursos);
                JOptionPane.showMessageDialog(null, "Curso Registrado Correctamente", "ATENCIÓN", 3);
            }
        }
    }

}
