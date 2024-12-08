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
        ProcesosFormularioAdmistrarSalones.presentarFormulario(this.frmMenuView.dsktEscritorio, this.frmAdmistrarSalonesView);
        clickSobreTabla();
    }

    public void clickSobreTabla() {
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
        Repositorio<Salon> repo = new SalonReposiImple();
        ServiciosAdmSalones admSalones = new ServiciosAdmSalones();
        //clik sobre guardar 
        if (e.getSource() == this.frmAdmistrarSalonesView.btnGuardarSalon) {
            miSalon = ProcesosFormularioAdmistrarSalones.creaSalonFormulario(this.frmAdmistrarSalonesView);
            repo.guardar(miSalon);
            admSalones.mostrarRegistrosEnTabla(this.frmAdmistrarSalonesView.tblData, TITULOS_COLUMNAS, repo.listar());
            admSalones.establecerAnchoColumnasTabla(this.frmAdmistrarSalonesView.tblData, ANCHO_COLUMAS);
            JOptionPane.showMessageDialog(null, "Salon Guardado Correctamente", "ATENCIÓN", 3);
            ServiciosAdmSalones.limpiarCampos(this.frmAdmistrarSalonesView);
        }
    }

}
