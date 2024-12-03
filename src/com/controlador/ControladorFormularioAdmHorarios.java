package com.controlador;

import com.Modelo.entidades.DaoImplementacion.HorarioRepoImple;
import com.Modelo.entidades.Horario;
import static com.Utelerias.Constantes.ConstantesFormularioAdmHorarios.ENCABEZADOS_TABLA;
import static com.Utelerias.Constantes.ConstantesFormularioAdmHorarios.TAMANIO_COLUMNAS;
import com.procesos.ProcesosFormularioAdmHorarios;
import com.procesos.Servicios.ServiciosAdmHorarios;
import com.vista.frmAdmistrarHorariosView;
import com.vista.frmMenuView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorFormularioAdmHorarios
        implements ActionListener {

    private final frmMenuView frmMenuView;
    private final frmAdmistrarHorariosView frmAdmistrarHorariosView;
    private Horario miHorario;

    public ControladorFormularioAdmHorarios(frmMenuView frmMenuView, frmAdmistrarHorariosView frmAdmistrarHorariosView) {
        this.frmMenuView = frmMenuView;
        this.frmAdmistrarHorariosView = frmAdmistrarHorariosView;
        this.frmAdmistrarHorariosView.btnGuardarHorario.addActionListener(this);
        ProcesosFormularioAdmHorarios.presentarFormulario(this.frmMenuView.dsktEscritorio, this.frmAdmistrarHorariosView);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        HorarioRepoImple repo = new HorarioRepoImple();
        ServiciosAdmHorarios admHorarios = new ServiciosAdmHorarios();
        if (e.getSource() == this.frmAdmistrarHorariosView.btnGuardarHorario) {
            miHorario = ProcesosFormularioAdmHorarios.crearHorarioFormulario(this.frmAdmistrarHorariosView);
            if (miHorario == null) {
                JOptionPane.showMessageDialog(null, "Ocurrio un error al registrar el horario. Revisar Campos", "ATENCION", JOptionPane.WARNING_MESSAGE);
            } else {
                repo.guardar(miHorario);
                JOptionPane.showMessageDialog(null, "Horario Guardado Correctamente", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
                admHorarios.mostrarRegistrosEnTabla(frmAdmistrarHorariosView.tblDataHorarios, ENCABEZADOS_TABLA, repo.listar());
                admHorarios.establecerAnchoColumnasTabla(frmAdmistrarHorariosView.tblDataHorarios, TAMANIO_COLUMNAS);
                ServiciosAdmHorarios.limpiarCampos(this.frmAdmistrarHorariosView);
            }
            System.out.println("click sobre el boton guardar.....");
        }
    }

}
