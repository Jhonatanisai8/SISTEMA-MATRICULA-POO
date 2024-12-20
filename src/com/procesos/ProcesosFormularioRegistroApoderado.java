package com.procesos;

import com.Modelo.entidades.Apoderado;
import com.Modelo.entidades.Direccion;
import com.Modelo.entidades.Dni;
import com.Utelerias.Constantes.ConstantesFormularioRegistroApoderado;
import com.procesos.Validaciones.ValidacionesFrmRegistroApoderado;
import com.vista.frmRegistrarApoderadoView;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

public class ProcesosFormularioRegistroApoderado
        implements ConstantesFormularioRegistroApoderado {

    private static void rellenarComboBox(frmRegistrarApoderadoView frmRegistrarApoderadoView) {
        //eliminamos los elementos
        frmRegistrarApoderadoView.cbxEstadoCivil.removeAllItems();
        frmRegistrarApoderadoView.cbxOcupacion.removeAllItems();
        frmRegistrarApoderadoView.cbxProvincia.removeAllItems();
        frmRegistrarApoderadoView.cbxRelacion.removeAllItems();
        frmRegistrarApoderadoView.cbxTipoDocumento.removeAllItems();

        //rellenamos los comboz
        for (String estado : ESTADO_CIVIL) {
            frmRegistrarApoderadoView.cbxEstadoCivil.addItem(estado);
        }
        for (String ocupacion : OCUPACIONES) {
            frmRegistrarApoderadoView.cbxOcupacion.addItem(ocupacion);
        }
        for (String provincia : PROVINCIAS) {
            frmRegistrarApoderadoView.cbxProvincia.addItem(provincia);
        }
        for (String rela : RELACION_ESTUDIANTE) {
            frmRegistrarApoderadoView.cbxRelacion.addItem(rela);
        }
        for (String tipoDoc : TIPO_DOCUMENTO) {
            frmRegistrarApoderadoView.cbxTipoDocumento.addItem(tipoDoc);
        }

    }

    public static void presentarFormulario(JDesktopPane escritorio, frmRegistrarApoderadoView frmApoderadoVie) {
        rellenarComboBox(frmApoderadoVie);
        frmApoderadoVie.btnGuardar.setIcon(ICONO_BOTON_GUARDAR);
        frmApoderadoVie.setTitle("Datos del apoderado");
        escritorio.removeAll();
        escritorio.add(frmApoderadoVie);
        frmApoderadoVie.toFront();
        frmApoderadoVie.setVisible(true);
    }

    //metodo que se llama en caso de quiera modificar 
    public static void presentarFormulario(JDesktopPane dsktEscritorio, frmRegistrarApoderadoView frmRegistrarApoderadoView, Apoderado apoderadoModificar) {
        rellenarComboBox(frmRegistrarApoderadoView);
        frmRegistrarApoderadoView.btnGuardar.setIcon(ICONO_BOTON_GUARDAR);
        frmRegistrarApoderadoView.setTitle("Moficacion de datos del apoderado.");
        dsktEscritorio.removeAll();
        cargarInformacionApoderadoFormulario(frmRegistrarApoderadoView, apoderadoModificar);
        dsktEscritorio.add(frmRegistrarApoderadoView);
        frmRegistrarApoderadoView.setVisible(true);
    }

    public static Apoderado crearApoderadoDesdeFormulario(frmRegistrarApoderadoView frmView) {
        Apoderado apoderado = null;
        String validacion = ValidacionesFrmRegistroApoderado.validarCamposFrmRegistroEstudiante(frmView);
        if (!validacion.equals("")) {
            JOptionPane.showMessageDialog(null, "Revisar el campo " + validacion, "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        try {
            // Creando el DNI
            Dni dni = new Dni();
            dni.setTipoDocumentoDni(frmView.cbxTipoDocumento.getSelectedItem().toString());
            dni.setNumeroDni(frmView.txtNumeroDocumento.getText());

            // Creando la dirección
            Direccion direccion = new Direccion();
            direccion.setDistrito(frmView.txtDistrito.getText());
            direccion.setCalle(frmView.txtCalle.getText());
            direccion.setNumero(frmView.txtNumeroCalle.getText());
            direccion.setProvincia(frmView.cbxProvincia.getSelectedItem().toString());

            apoderado = new Apoderado();
            apoderado.setNombre(frmView.txtNombre.getText());
            apoderado.setApellidoPaterno(frmView.txtApPaterno.getText());
            apoderado.setApellidoMaterno(frmView.txtApMaterno.getText());
            apoderado.setFechaNacimiento(frmView.dtcFechaNacimiento.getDate());
            apoderado.setDni(dni);
            apoderado.setDireccion(direccion);
            apoderado.setTelefono(frmView.txtTelefono.getText());
            apoderado.setEmailPersonal(frmView.txtEmailpersonal.getText());
            apoderado.setRelacionEstudiante(frmView.cbxRelacion.getSelectedItem().toString());
            apoderado.setOcupacion(frmView.cbxOcupacion.getSelectedItem().toString());
            apoderado.setEstadoCivil(frmView.cbxEstadoCivil.getSelectedItem().toString());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al crear el Apoderado.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return apoderado;
    }

    private static void cargarInformacionApoderadoFormulario(frmRegistrarApoderadoView frmRegistrarApoderadoView, Apoderado apoderadoModificar) {
        //ponemos la informacion del apoderado en los campos correspondientes
        frmRegistrarApoderadoView.txtNombre.setText(apoderadoModificar.getNombre());
        frmRegistrarApoderadoView.txtApPaterno.setText(apoderadoModificar.getApellidoPaterno());
        frmRegistrarApoderadoView.txtApMaterno.setText(apoderadoModificar.getApellidoMaterno());
        frmRegistrarApoderadoView.dtcFechaNacimiento.setDate(apoderadoModificar.getFechaNacimiento());
        frmRegistrarApoderadoView.cbxTipoDocumento.setSelectedItem(apoderadoModificar.getDni().getTipoDocumentoDni());
        frmRegistrarApoderadoView.txtNumeroDocumento.setText(apoderadoModificar.getDni().getNumeroDni());
        frmRegistrarApoderadoView.txtCalle.setText(apoderadoModificar.getDireccion().getNumero());
        frmRegistrarApoderadoView.txtDistrito.setText(apoderadoModificar.getDireccion().getDistrito());
        frmRegistrarApoderadoView.cbxProvincia.setSelectedItem(apoderadoModificar.getDireccion().getProvincia());
        frmRegistrarApoderadoView.txtNumeroCalle.setText(apoderadoModificar.getDireccion().getNumero());
        frmRegistrarApoderadoView.txtTelefono.setText(apoderadoModificar.getTelefono());
        frmRegistrarApoderadoView.txtEmailpersonal.setText(apoderadoModificar.getEmailPersonal());
        frmRegistrarApoderadoView.cbxRelacion.setSelectedItem(apoderadoModificar.getRelacionEstudiante());
        frmRegistrarApoderadoView.cbxOcupacion.setSelectedItem(apoderadoModificar.getOcupacion());
        frmRegistrarApoderadoView.cbxEstadoCivil.setSelectedItem(apoderadoModificar.getEstadoCivil());
    }
}
