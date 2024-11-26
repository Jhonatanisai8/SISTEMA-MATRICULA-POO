package com.procesos;

import com.Modelo.entidades.DaoImplementacion.SalonReposiImple;
import com.Modelo.entidades.InterfaceDao.Repositorio;
import com.Modelo.entidades.Salon;
import com.Utelerias.Constantes.ConstantesFormularioAdmSalones;
import com.procesos.Servicios.ServiciosAdmSalones;
import com.vista.frmAdmistrarSalonesView;
import java.util.List;
import javax.swing.JDesktopPane;

public class ProcesosFormularioAdmistrarSalones
        implements ConstantesFormularioAdmSalones {
    
    private static List<Salon> obtenerListaDocente() {
        Repositorio<Salon> repo = new SalonReposiImple();
        return repo.listar();
    }
    
    public static void presentarFormulario(JDesktopPane desktopPane, frmAdmistrarSalonesView frmSalonesView) {
        frmSalonesView.setTitle("Administracion de Salones.");
        desktopPane.removeAll();
        desktopPane.add(frmSalonesView);
        frmSalonesView.toFront();
        frmSalonesView.setVisible(true);
        ServiciosAdmSalones.mostrarSalonesEnTabla(frmSalonesView, TITULOS_COLUMNAS, obtenerListaDocente());
    }
}
