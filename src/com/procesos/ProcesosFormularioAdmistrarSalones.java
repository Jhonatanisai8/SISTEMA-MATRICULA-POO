package com.procesos;

import com.Modelo.entidades.DaoImplementacion.SalonReposiImple;
import com.Modelo.entidades.InterfaceDao.Repositorio;
import com.Modelo.entidades.Salon;
import com.Utelerias.Constantes.ConstantesFormularioAdmSalones;
import com.procesos.Servicios.ServiciosAdmSalones;
import com.procesos.Validaciones.ValidacionesFrmAdmSalones;
import com.vista.frmAdmistrarSalonesView;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

public class ProcesosFormularioAdmistrarSalones
        implements ConstantesFormularioAdmSalones {

    private static List<Salon> obtenerListaDocente() {
        Repositorio<Salon> repo = new SalonReposiImple();
        return repo.listar();
    }

    public static void presentarFormulario(JDesktopPane desktopPane, frmAdmistrarSalonesView frmSalonesView) {
        frmSalonesView.tblData.setFont(FUENTE_TEXT_PRESENTACION);
        frmSalonesView.setTitle("Administracion de Salones.");
        desktopPane.removeAll();
        desktopPane.add(frmSalonesView);
        frmSalonesView.toFront();
        frmSalonesView.setVisible(true);
        ServiciosAdmSalones.mostrarSalonesEnTabla(frmSalonesView, TITULOS_COLUMNAS, obtenerListaDocente());
        ServiciosAdmSalones.establecerAnchoColumnasTabla(frmSalonesView.tblData, ANCHO_COLUMAS);
    }

    public static Salon creaSalonFormulario(frmAdmistrarSalonesView frmSalonesView) {
        Salon miSalon = null;
        //llamamos al metodo de las validaciones 
        String validacion = ValidacionesFrmAdmSalones.validarCampos(frmSalonesView);
        if (!validacion.equals("")) {
            JOptionPane.showMessageDialog(null, "Revisar el Campo." + validacion, "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        try {
            miSalon = new Salon();
            miSalon.setNombreSalon(frmSalonesView.txtNombreSalon.getText());
            miSalon.setCapacidadEstudiantes(Integer.parseInt(frmSalonesView.spnCapacidad.getValue().toString()));
            miSalon.setReferencia(frmSalonesView.txtReferenciaSalon.getText());

        } catch (NumberFormatException e) {
            System.out.println("Error al crear un Salon desde el formulario: " + e.getMessage());
            return null;
        }
        //retornamos 
        return miSalon;
    }
}
