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

    public static Salon obtenerSalon(Long id) {
        SalonReposiImple imple = new SalonReposiImple();
        return imple.porDni(id);
    }

    public static void presentarFormulario(JDesktopPane desktopPane, frmAdmistrarSalonesView frmSalonesView) {
        ServiciosAdmSalones serviciosAdmSalones = new ServiciosAdmSalones();
        frmSalonesView.tblData.setFont(FUENTE_TEXT_PRESENTACION);
        frmSalonesView.setTitle("Administracion de Salones.");
        desktopPane.removeAll();
        desktopPane.add(frmSalonesView);
        frmSalonesView.toFront();
        frmSalonesView.setVisible(true);
        frmSalonesView.txtNombreSalon.requestFocus();
        serviciosAdmSalones.mostrarRegistrosEnTabla(frmSalonesView.tblData, TITULOS_COLUMNAS, obtenerListaDocente());
        serviciosAdmSalones.establecerAnchoColumnasTabla(frmSalonesView.tblData, ANCHO_COLUMAS);
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

    public static void presentarInformacionCurso(frmAdmistrarSalonesView frmAdmistrarSalonesView, Salon salon) {
        //ponemos la informacion del objeto en los respectivos campos de informacion
        frmAdmistrarSalonesView.txtNombreSalon.setText(salon.getNombreSalon());
        frmAdmistrarSalonesView.txtReferenciaSalon.setText(salon.getReferencia());
        frmAdmistrarSalonesView.spnCapacidad.setValue(String.valueOf(salon.getCapacidadEstudiantes()));
        frmAdmistrarSalonesView.btnGuardarSalon.setEnabled(false);
    }
}
