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
import javax.swing.JOptionPane;

public class ControladorFormularioAdmSalones
        implements ActionListener {

    private final frmMenuView frmMenuView;
    private final frmAdmistrarSalonesView frmAdmistrarSalonesView;
    private Salon miSalon;

    public ControladorFormularioAdmSalones(frmMenuView frmMenuView, frmAdmistrarSalonesView frmAdmistrarSalonesView) {
        this.frmMenuView = frmMenuView;
        this.frmAdmistrarSalonesView = frmAdmistrarSalonesView;
        this.frmAdmistrarSalonesView.btnGuardarSalon.addActionListener(this);
        ProcesosFormularioAdmistrarSalones.presentarFormulario(this.frmMenuView.dsktEscritorio, this.frmAdmistrarSalonesView);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Repositorio<Salon> repo = new SalonReposiImple();
        //clik sobre guardar 
        if (e.getSource() == this.frmAdmistrarSalonesView.btnGuardarSalon) {
            miSalon = ProcesosFormularioAdmistrarSalones.creaSalonFormulario(this.frmAdmistrarSalonesView);
            repo.guardar(miSalon);
            ServiciosAdmSalones.mostrarSalonesEnTabla(this.frmAdmistrarSalonesView.tblData, TITULOS_COLUMNAS, repo.listar());
            ServiciosAdmSalones.establecerAnchoColumnasTabla(this.frmAdmistrarSalonesView.tblData, ANCHO_COLUMAS);
            JOptionPane.showMessageDialog(null, "Salon Guardado Correctamente", "ATENCIÓN", 3);
            ServiciosAdmSalones.limpiarCampos(this.frmAdmistrarSalonesView);
        }
    }

}
