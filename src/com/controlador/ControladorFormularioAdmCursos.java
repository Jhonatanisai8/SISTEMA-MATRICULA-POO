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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class ControladorFormularioAdmCursos
        implements ActionListener {

    private final frmMenuView frmMenuView;
    private final frmAdmistrarCursos frmAdmistrarCursos;
    private Curso miCurso;
    private Long id;

    public ControladorFormularioAdmCursos(frmMenuView frmMenuView, frmAdmistrarCursos frmAdmistrarCursos) {
        this.frmMenuView = frmMenuView;
        this.frmAdmistrarCursos = frmAdmistrarCursos;
        this.frmAdmistrarCursos.btnGuardarCurso.addActionListener(this);
        this.frmAdmistrarCursos.btnModificar.addActionListener(this);
        this.frmAdmistrarCursos.btnEliminar.addActionListener(this);
        ProcesosFormularioAdmistrarCursos.presentarFormulario(this.frmMenuView.dsktEscritorio, this.frmAdmistrarCursos);
        clicksobreTabla();
    }

    private void clicksobreTabla() {
        frmAdmistrarCursos.tblDatosCursos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSelecionada = frmAdmistrarCursos.tblDatosCursos.getSelectedRow();
                //obetnemos el id del curso de la fila seleccionada
                id = Long.valueOf(frmAdmistrarCursos.tblDatosCursos.getValueAt(filaSelecionada, 0).toString());
                Curso cursoModificado = ProcesosFormularioAdmistrarCursos.obtenerCurso(id);
                ProcesosFormularioAdmistrarCursos.presentarInformacionCurso(frmAdmistrarCursos, cursoModificado);
            }
        });
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

        if (e.getSource() == this.frmAdmistrarCursos.btnModificar) {
            int filaSelecionada = frmAdmistrarCursos.tblDatosCursos.getSelectedRow();
            if (filaSelecionada < 0) {
                JOptionPane.showMessageDialog(null, "Por favor selecione una fila.", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            this.miCurso = ProcesosFormularioAdmistrarCursos.creaCursoFormulario(this.frmAdmistrarCursos);
            this.miCurso.setIdCurso(id);
            repo.modificar(this.miCurso);
            admCurso.mostrarRegistrosEnTabla(frmAdmistrarCursos.tblDatosCursos, ENCABEZADO_COLUMNAS_TABLA, repo.listar());
            admCurso.establecerAnchoColumnasTabla(this.frmAdmistrarCursos.tblDatosCursos, ANCH0_COLUMNAS);
            ServiciosCurso.limpiarCampos(this.frmAdmistrarCursos);
            this.frmAdmistrarCursos.btnGuardarCurso.setEnabled(true);
            JOptionPane.showMessageDialog(null, "Curso Modificado Correctamente", "ATENCIÓN", 3);
            System.out.println("Click sobre el boton modificar....");
        }

        if (e.getSource() == this.frmAdmistrarCursos.btnEliminar) {
            int fila = frmAdmistrarCursos.tblDatosCursos.getSelectedRow();
            if (fila < 0) {
                JOptionPane.showMessageDialog(null, "Por favor seleccione un curso para poder eliminar.", "ATENCION", JOptionPane.WARNING_MESSAGE);
                return;
            }
            repo.eliminar(id);
            admCurso.mostrarRegistrosEnTabla(frmAdmistrarCursos.tblDatosCursos, ENCABEZADO_COLUMNAS_TABLA, repo.listar());
            admCurso.establecerAnchoColumnasTabla(this.frmAdmistrarCursos.tblDatosCursos, ANCH0_COLUMNAS);
            ServiciosCurso.limpiarCampos(this.frmAdmistrarCursos);
            this.frmAdmistrarCursos.btnGuardarCurso.setEnabled(true);
        }
    }

}
