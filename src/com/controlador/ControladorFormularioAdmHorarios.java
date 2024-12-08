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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorFormularioAdmHorarios
        implements ActionListener {
    
    private final frmMenuView frmMenuView;
    private final frmAdmistrarHorariosView frmAdmistrarHorariosView;
    private Horario miHorario;
    private Long id;
    
    public ControladorFormularioAdmHorarios(frmMenuView frmMenuView, frmAdmistrarHorariosView frmAdmistrarHorariosView) {
        this.frmMenuView = frmMenuView;
        this.frmAdmistrarHorariosView = frmAdmistrarHorariosView;
        this.frmAdmistrarHorariosView.btnGuardarHorario.addActionListener(this);
        this.frmAdmistrarHorariosView.btnEliminar.addActionListener(this);
        this.frmAdmistrarHorariosView.btnModificar.addActionListener(this);
        this.frmAdmistrarHorariosView.btnBuscarHorario.addActionListener(this);
        ProcesosFormularioAdmHorarios.presentarFormulario(this.frmMenuView.dsktEscritorio, this.frmAdmistrarHorariosView);
        clickSobreTabla();
    }
    
    private void clickSobreTabla() {
        frmAdmistrarHorariosView.tblDataHorarios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = frmAdmistrarHorariosView.tblDataHorarios.getSelectedRow();
                id = Long.valueOf(frmAdmistrarHorariosView.tblDataHorarios.getValueAt(fila, 0).toString());
                Horario horarioModificado = ProcesosFormularioAdmHorarios.obtenerHorario(id);
                ProcesosFormularioAdmHorarios.presentarInformacionHorario(frmAdmistrarHorariosView, horarioModificado);
                System.out.println("Click sobre la tabla..");
            }
        });
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
        
        if (e.getSource() == this.frmAdmistrarHorariosView.btnModificar) {
            int fila = frmAdmistrarHorariosView.tblDataHorarios.getSelectedRow();
            if (fila < 0) {
                JOptionPane.showMessageDialog(null, "Por favor seleccione un horario para poder modificar.", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            int op = JOptionPane.showConfirmDialog(null, "¿Estas seguro de modificar el Horario?", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
            if (op == 0) {
                this.miHorario = ProcesosFormularioAdmHorarios.crearHorarioFormulario(frmAdmistrarHorariosView);
                this.miHorario.setIdHorario(id);
                repo.modificar(this.miHorario);
                admHorarios.mostrarRegistrosEnTabla(frmAdmistrarHorariosView.tblDataHorarios, ENCABEZADOS_TABLA, repo.listar());
                admHorarios.establecerAnchoColumnasTabla(frmAdmistrarHorariosView.tblDataHorarios, TAMANIO_COLUMNAS);
                ServiciosAdmHorarios.limpiarCampos(this.frmAdmistrarHorariosView);
                JOptionPane.showMessageDialog(null, "Horario Modificado Correctamente.", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
            }
            System.out.println("Click sobre el boton modificar....");
        }
        
        if (e.getSource() == this.frmAdmistrarHorariosView.btnEliminar) {
            int fila = frmAdmistrarHorariosView.tblDataHorarios.getSelectedRow();
            if (fila < 0) {
                JOptionPane.showMessageDialog(null, "Por favor selecine un curso a eliminar.", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            repo.eliminar(id);
            admHorarios.mostrarRegistrosEnTabla(frmAdmistrarHorariosView.tblDataHorarios, ENCABEZADOS_TABLA, repo.listar());
            admHorarios.establecerAnchoColumnasTabla(frmAdmistrarHorariosView.tblDataHorarios, TAMANIO_COLUMNAS);
            ServiciosAdmHorarios.limpiarCampos(frmAdmistrarHorariosView);
            frmAdmistrarHorariosView.btnGuardarHorario.setEnabled(true);
            System.out.println("Click sobre el boton eliminar..");
            
        }
        
        if (e.getSource() == this.frmAdmistrarHorariosView.btnBuscarHorario) {
            if (frmAdmistrarHorariosView.txtBuscar.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Por ingrese el dia de la semana de el/los horario.", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
                admHorarios.mostrarRegistrosEnTabla(frmAdmistrarHorariosView.tblDataHorarios, ENCABEZADOS_TABLA, repo.listar());
                admHorarios.establecerAnchoColumnasTabla(frmAdmistrarHorariosView.tblDataHorarios, TAMANIO_COLUMNAS);
                ServiciosAdmHorarios.limpiarCampos(frmAdmistrarHorariosView);
                return;
            }
            DefaultTableModel modelo = (DefaultTableModel) frmAdmistrarHorariosView.tblDataHorarios.getModel();
            frmAdmistrarHorariosView.tblDataHorarios.setModel(repo.listarHorariosDefaultTableModel(modelo, frmAdmistrarHorariosView.txtBuscar.getText()));
        }
    }
    
}
