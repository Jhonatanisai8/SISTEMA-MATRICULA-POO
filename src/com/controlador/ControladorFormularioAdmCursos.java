package com.controlador;

import com.Modelo.entidades.DaoImplementacion.SalonReposiImple;
import com.Modelo.entidades.InterfaceDao.Repositorio;
import com.Modelo.entidades.Salon;
import static com.Utelerias.Constantes.ConstantesFormularioAdmSalones.TITULOS_COLUMNAS;
import com.procesos.ProcesosFormularioAdmistrarCursos;
import com.procesos.ProcesosFormularioAdmistrarSalones;
import com.procesos.Servicios.ServiciosAdmSalones;
import com.vista.frmAdmistrarCursos;
import com.vista.frmMenuView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorFormularioAdmCursos
        implements ActionListener {

    private final frmMenuView frmMenuView;
    private final frmAdmistrarCursos frmAdmistrarCursos;

    public ControladorFormularioAdmCursos(frmMenuView frmMenuView, frmAdmistrarCursos frmAdmistrarCursos) {
        this.frmMenuView = frmMenuView;
        this.frmAdmistrarCursos = frmAdmistrarCursos;
        ProcesosFormularioAdmistrarCursos.presentarFormulario(this.frmMenuView.dsktEscritorio, this.frmAdmistrarCursos);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        Repositorio<Salon> repo = new SalonReposiImple();
//        //clik sobre guardar 
//        if (e.getSource() == this.frmAdmistrarSalonesView.btnGuardarSalon) {
//            miSalon = ProcesosFormularioAdmistrarSalones.creaSalonFormulario(this.frmAdmistrarSalonesView);
//            repo.guardar(miSalon);
//            ServiciosAdmSalones.mostrarSalonesEnTabla(this.frmAdmistrarSalonesView, TITULOS_COLUMNAS, repo.listar());
//            JOptionPane.showMessageDialog(null, "Salon Guardado Correctamente", "ATENCIÓN", 3);
//        }
    }

}
