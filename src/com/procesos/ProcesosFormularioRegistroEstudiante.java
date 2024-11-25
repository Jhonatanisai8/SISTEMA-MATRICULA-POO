package com.procesos;

import com.Modelo.entidades.Direccion;
import com.Modelo.entidades.Dni;
import com.Modelo.entidades.Estudiante;
import com.procesos.Servicios.ServiciosEstudiante;
import com.procesos.Validaciones.ValidacionesFrmRegistroEstudiante;
import com.vista.frmRegistrarEstudianteView;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import com.Utelerias.Constantes.ConstantesFormularioRegistroEstudianteDocente;

public class ProcesosFormularioRegistroEstudiante
        implements ConstantesFormularioRegistroEstudianteDocente {
    
    private static void rellenarComboBox(frmRegistrarEstudianteView frEstudiante) {
        frEstudiante.cbxProvincia.removeAllItems();
        for (String string : PROVINCIAS) {
            frEstudiante.cbxProvincia.addItem(string);
        }
        frEstudiante.cbxTipoDocumento.removeAllItems();
        for (String string : TIPO_DOCUMENTO) {
            frEstudiante.cbxTipoDocumento.addItem(string);
        }
    }
    
    private static void ponerIconosFormulario(frmRegistrarEstudianteView frEstudiante) {
        frEstudiante.btnGuardar.setIcon(ICONO_BOTON_GUARDAR);
    }
    
    public static void presentarFormulario(JDesktopPane desktopPane, frmRegistrarEstudianteView fr) {
        rellenarComboBox(fr);
        ponerIconosFormulario(fr);
        fr.setTitle("Datos del estudiante");
        desktopPane.removeAll();
        desktopPane.add(fr);
        fr.toFront();
        fr.setVisible(true);
    }

    public static void presentarFormulario(JDesktopPane desktopPane, frmRegistrarEstudianteView fr, Estudiante estudiante) {
        rellenarComboBox(fr);
        ponerIconosFormulario(fr);
        fr.setTitle("Moficacion de Informacion del Estudiante");
        desktopPane.removeAll();
        //ponemos la informacion
        fr.txtNombre.setText(estudiante.getNombre());
        fr.txtApPaterno.setText(estudiante.getApellidoPaterno());
        fr.txtApMaterno.setText(estudiante.getApellidoMaterno());
        fr.dtcFechaNacimiento.setDate(estudiante.getFechaNacimiento());
        fr.cbxTipoDocumento.setSelectedItem(estudiante.getDni().getTipoDocumentoDni());
        fr.txtNumeroDocumento.setText(estudiante.getDni().getNumeroDni());
        fr.txtDistrito.setText(estudiante.getDireccion().getDistrito());
        fr.txtCalle.setText(estudiante.getDireccion().getCalle());
        fr.txtNumeroCalle.setText(estudiante.getDireccion().getNumero());
        fr.cbxProvincia.setSelectedItem(estudiante.getDireccion().getProvincia());
        fr.txtTelefono.setText(estudiante.getTelefono());
        fr.txtEmailpersonal.setText(estudiante.getEmailPersonal());
        desktopPane.add(fr);
        fr.toFront();
        fr.setVisible(true);
    }

    //metodo que lee la categoria 
    public static Estudiante crearEstudiante(frmRegistrarEstudianteView frmEstudianteView) {
        Dni dni = null;
        Direccion direccion = null;
        Estudiante e = null;
        String validacion = ValidacionesFrmRegistroEstudiante.validarCamposFrmRegistroEstudiante(frmEstudianteView);
        if (!validacion.equals("")) {
            System.out.println("Observacion....");
            JOptionPane.showMessageDialog(null, "Revisar el campo " + validacion, "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
        } else {
            System.out.println("Hola Todo paso correctamente");

            //creando el dni
            dni = new Dni();
            dni.setTipoDocumentoDni(frmEstudianteView.cbxTipoDocumento.getSelectedItem().toString());
            dni.setNumeroDni(frmEstudianteView.txtNumeroDocumento.getText());

            //creando la direcion
            direccion = new Direccion();
            direccion.setDistrito(frmEstudianteView.txtDistrito.getText());
            direccion.setCalle(frmEstudianteView.txtCalle.getText());
            direccion.setNumero(frmEstudianteView.txtNumeroCalle.getText());
            direccion.setProvincia(frmEstudianteView.cbxProvincia.getSelectedItem().toString());

            //creando el estudiante
            e = new Estudiante();
            e.setNombre(frmEstudianteView.txtNombre.getText());
            e.setApellidoPaterno(frmEstudianteView.txtApPaterno.getText());
            e.setApellidoMaterno(frmEstudianteView.txtApMaterno.getText());
            e.setFechaNacimiento(frmEstudianteView.dtcFechaNacimiento.getDate());
            e.setDni(dni);
            e.setDireccion(direccion);
            e.setTelefono(frmEstudianteView.txtTelefono.getText());
            e.setEmailPersonal(frmEstudianteView.txtEmailpersonal.getText());
            e.setCodigoEstudiante(ServiciosEstudiante.generarCodigoEstudiante(frmEstudianteView.txtNombre.getText(), frmEstudianteView.txtApPaterno.getText()));
            e.setEmailEducativo(ServiciosEstudiante.generarCorreoEducatico(frmEstudianteView.txtNombre.getText(), frmEstudianteView.txtApPaterno.getText(), frmEstudianteView.txtApMaterno.getText()));
        }
        return e;
    }
}
