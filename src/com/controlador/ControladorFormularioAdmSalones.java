package com.controlador;

import com.Modelo.entidades.DaoImplementacion.SalonReposiImple;
import com.Modelo.entidades.InterfaceDao.Repositorio;
import com.Modelo.entidades.Salon;
import static com.Utelerias.Constantes.ConstantesFormularioAdmSalones.TITULOS_COLUMNAS;
import static com.Utelerias.Constantes.ConstantesFormularioAdmSalones.ANCHO_COLUMAS;
import com.procesos.ProcesosFormularioAdmistrarSalones;
import com.procesos.Servicios.ServiciosAdmSalones;
import com.vista.frmAdmistrarSalonesView;
import com.vista.frmMenuView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorFormularioAdmSalones
        implements ActionListener {
    
    private final frmMenuView frmMenuView;
    private final frmAdmistrarSalonesView frmAdmistrarSalonesView;
    private Salon miSalon;
    private Long id;
    
    public ControladorFormularioAdmSalones(frmMenuView frmMenuView, frmAdmistrarSalonesView frmAdmistrarSalonesView) {
        this.frmMenuView = frmMenuView;
        this.frmAdmistrarSalonesView = frmAdmistrarSalonesView;
        this.frmAdmistrarSalonesView.btnGuardarSalon.addActionListener(this);
        this.frmAdmistrarSalonesView.btnModificar.addActionListener(this);
        this.frmAdmistrarSalonesView.btnEliminar.addActionListener(this);
        this.frmAdmistrarSalonesView.btnBuscar.addActionListener(this);
        ProcesosFormularioAdmistrarSalones.presentarFormulario(this.frmMenuView.dsktEscritorio, this.frmAdmistrarSalonesView);
        clickSobreTabla();
    }
    
    private void clickSobreTabla() {
        frmAdmistrarSalonesView.tblData.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = frmAdmistrarSalonesView.tblData.getSelectedRow();
                //obtenemos el id
                id = Long.valueOf(frmAdmistrarSalonesView.tblData.getValueAt(fila, 0).toString());
                Salon salonModificado = ProcesosFormularioAdmistrarSalones.obtenerSalon(id);
                ProcesosFormularioAdmistrarSalones.presentarInformacionCurso(frmAdmistrarSalonesView, salonModificado);
            }
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        SalonReposiImple repo = new SalonReposiImple();
        ServiciosAdmSalones admSalones = new ServiciosAdmSalones();
        //clik sobre guardar 
        if (e.getSource() == this.frmAdmistrarSalonesView.btnGuardarSalon) {
            miSalon = ProcesosFormularioAdmistrarSalones.creaSalonFormulario(this.frmAdmistrarSalonesView);
            repo.guardar(miSalon);
            admSalones.mostrarRegistrosEnTabla(this.frmAdmistrarSalonesView.tblData, TITULOS_COLUMNAS, repo.listar());
            admSalones.establecerAnchoColumnasTabla(this.frmAdmistrarSalonesView.tblData, ANCHO_COLUMAS);
            ServiciosAdmSalones.limpiarCampos(this.frmAdmistrarSalonesView);
            JOptionPane.showMessageDialog(null, "Salon Guardado Correctamente", "ATENCIÓN", 3);
        }

        //click sobre modificaar
        if (e.getSource() == this.frmAdmistrarSalonesView.btnModificar) {
            int filaSelecionada = this.frmAdmistrarSalonesView.tblData.getSelectedRow();
            if (filaSelecionada < 0) {
                JOptionPane.showMessageDialog(null, "Por favor selecione una fila.", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            int opcion = JOptionPane.showConfirmDialog(null, "¿ESTAS SEGURO DE MODICAR DICHO SALON?", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
            if (opcion == 0) {
                this.miSalon = ProcesosFormularioAdmistrarSalones.creaSalonFormulario(this.frmAdmistrarSalonesView);
                this.miSalon.setIdSalon(id);
                repo.modificar(this.miSalon);
                admSalones.mostrarRegistrosEnTabla(this.frmAdmistrarSalonesView.tblData, TITULOS_COLUMNAS, repo.listar());
                admSalones.establecerAnchoColumnasTabla(this.frmAdmistrarSalonesView.tblData, ANCHO_COLUMAS);
                ServiciosAdmSalones.limpiarCampos(this.frmAdmistrarSalonesView);
                this.frmAdmistrarSalonesView.btnGuardarSalon.setEnabled(true);
                JOptionPane.showMessageDialog(null, "Salon Modificado Correctamente", "ATENCIÓN", 3);
            }
            System.out.println("Click sobre el boton modificar.....");
        }
        
        if (e.getSource() == this.frmAdmistrarSalonesView.btnEliminar) {
            int fila = this.frmAdmistrarSalonesView.tblData.getSelectedRow();
            if (fila < 0) {
                JOptionPane.showMessageDialog(null, "Por favor seleccione un Salon para poder eliminar.", "ATENCION", JOptionPane.WARNING_MESSAGE);
                return;
            }
            repo.eliminar(id);
            admSalones.mostrarRegistrosEnTabla(this.frmAdmistrarSalonesView.tblData, TITULOS_COLUMNAS, repo.listar());
            admSalones.establecerAnchoColumnasTabla(this.frmAdmistrarSalonesView.tblData, ANCHO_COLUMAS);
            ServiciosAdmSalones.limpiarCampos(this.frmAdmistrarSalonesView);
            frmAdmistrarSalonesView.btnGuardarSalon.setEnabled(true);
            System.out.println("Click sobre eliminar salon.....");
        }
        
        if (e.getSource() == this.frmAdmistrarSalonesView.btnBuscar) {
            if (this.frmAdmistrarSalonesView.txtBuscar.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese el nombre del salon a buscar.", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
                admSalones.mostrarRegistrosEnTabla(this.frmAdmistrarSalonesView.tblData, TITULOS_COLUMNAS, repo.listar());
                admSalones.establecerAnchoColumnasTabla(this.frmAdmistrarSalonesView.tblData, ANCHO_COLUMAS);
                return;
            }
            DefaultTableModel model = (DefaultTableModel) frmAdmistrarSalonesView.tblData.getModel();
            frmAdmistrarSalonesView.tblData.setModel(repo.listarCursosDefaultTableModel(model, frmAdmistrarSalonesView.txtBuscar.getText()));
            System.out.println("Click sobre el boton buscar curso...");
        }
    }
}
