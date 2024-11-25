package com.procesos;

import com.Modelo.entidades.Direccion;
import com.Modelo.entidades.Dni;
import com.Modelo.entidades.Docente;
import com.Utelerias.Constantes.ConstantesFormularioRegistroEstudianteDocente;
import com.procesos.Servicios.ServiciosEstudianteDocente;
import com.procesos.Validaciones.ValidacionesFrmRegistroDocente;
import com.vista.frmRegistrarDocenteView;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

public class ProcesosFormularioRegistroDocente
        implements ConstantesFormularioRegistroEstudianteDocente {

    private static void rellenarComboBox(frmRegistrarDocenteView frmRegistrarDocenteView1) {
        frmRegistrarDocenteView1.cbxProvincia.removeAllItems();
        frmRegistrarDocenteView1.cbxTipoDocumento.removeAllItems();
        frmRegistrarDocenteView1.cbxTituloAcademico.removeAllItems();
        //rellamos los combo box
        for (String provincia : PROVINCIAS) {
            frmRegistrarDocenteView1.cbxProvincia.addItem(provincia);
        }
        for (String titulo : TITULOS_ACADEMICOS) {
            frmRegistrarDocenteView1.cbxTituloAcademico.addItem(titulo);
        }
        for (String documento : TIPO_DOCUMENTO) {
            frmRegistrarDocenteView1.cbxTipoDocumento.addItem(documento);
        }

    }

    private static void ponerIconosFormulario(frmRegistrarDocenteView frmRegistrarDocenteView1) {
        frmRegistrarDocenteView1.btnGuardar.setIcon(ICONO_BOTON_GUARDAR);
    }

    public static Docente crearDocenteFormulario(frmRegistrarDocenteView frmRegistrarDocenteView1) {
        Docente docente = null;
        //llamamos al metodo de las validaciones 
        String validacion = ValidacionesFrmRegistroDocente.validarCamposFrmRegistroEstudiante(frmRegistrarDocenteView1);
        if (!validacion.equals("")) {
            JOptionPane.showMessageDialog(null, "Revisar el Campo." + validacion, "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        try {
            //creamos el dni 
            Dni dni = new Dni();
            dni.setTipoDocumentoDni(frmRegistrarDocenteView1.cbxTipoDocumento.getSelectedItem().toString());
            dni.setNumeroDni(frmRegistrarDocenteView1.txtNumeroDocumento.getText().trim());

            //creamos la direccion 
            Direccion direccion = new Direccion();
            direccion.setDistrito(frmRegistrarDocenteView1.txtDistrito.getText());
            direccion.setCalle(frmRegistrarDocenteView1.txtCalle.getText());
            direccion.setNumero(frmRegistrarDocenteView1.txtNumeroCalle.getText());
            direccion.setProvincia(frmRegistrarDocenteView1.cbxProvincia.getSelectedItem().toString());
            //creamos al docente 
            docente = new Docente();
            docente.setNombre(frmRegistrarDocenteView1.txtNombre.getText());
            docente.setApellidoPaterno(frmRegistrarDocenteView1.txtApPaterno.getText());
            docente.setApellidoMaterno(frmRegistrarDocenteView1.txtApMaterno.getText());
            docente.setFechaNacimiento(frmRegistrarDocenteView1.dtcFechaNacimiento.getDate());
            docente.setDni(dni);
            docente.setDireccion(direccion);
            docente.setTelefono(frmRegistrarDocenteView1.txtTelefono.getText());
            docente.setEmailPersonal(frmRegistrarDocenteView1.txtEmailpersonal.getText());
            docente.setAniosExperiencia(Integer.parseInt(frmRegistrarDocenteView1.spnAniosExperiencia.getValue().toString()));
            docente.setTituloAcademico(frmRegistrarDocenteView1.cbxTituloAcademico.getSelectedItem().toString());

            String nombre = frmRegistrarDocenteView1.txtNombre.getText();
            String ap01 = frmRegistrarDocenteView1.txtApPaterno.getText();
            String ap02 = frmRegistrarDocenteView1.txtApMaterno.getText();
            //establecemos el codigo y el email educativo 
            docente.setCodigoDocente(ServiciosEstudianteDocente.generarCodigo(nombre, ap02));
            docente.setEmailEducativoDocente(ServiciosEstudianteDocente.generarCorreoEducatico(nombre, ap01, ap02));

        } catch (NumberFormatException e) {
            System.out.println("Error al crear un estudiante desde el formulario: " + e.getMessage());
            return null;
        }
        //retornamos 
        return docente;
    }

    public static void presentarFormulario(JDesktopPane desktopPane, frmRegistrarDocenteView frmRegistrarDocenteView1) {
        rellenarComboBox(frmRegistrarDocenteView1);
        ponerIconosFormulario(frmRegistrarDocenteView1);
        frmRegistrarDocenteView1.setTitle("Datos del Docente: ");
        desktopPane.removeAll();
        desktopPane.add(frmRegistrarDocenteView1);
        frmRegistrarDocenteView1.toFront();
        frmRegistrarDocenteView1.setVisible(true);
    }

    //para cuando se va a modificar
    public static void presentarFormulario(JDesktopPane desktopPane, frmRegistrarDocenteView frmRegistrarDocenteView1, Docente docente) {
        rellenarComboBox(frmRegistrarDocenteView1);
        ponerIconosFormulario(frmRegistrarDocenteView1);
        frmRegistrarDocenteView1.setTitle("Datos del Docente: ");
        desktopPane.removeAll();
        //para los texFields
        frmRegistrarDocenteView1.txtNombre.setText(docente.getNombre());
        frmRegistrarDocenteView1.txtApPaterno.setText(docente.getApellidoPaterno());
        frmRegistrarDocenteView1.txtApMaterno.setText(docente.getApellidoMaterno());
        frmRegistrarDocenteView1.dtcFechaNacimiento.setDate(docente.getFechaNacimiento());

        frmRegistrarDocenteView1.cbxTipoDocumento.setSelectedItem(docente.getDni().getTipoDocumentoDni());
        frmRegistrarDocenteView1.txtNumeroDocumento.setText(docente.getDni().getNumeroDni());
        frmRegistrarDocenteView1.cbxTituloAcademico.setSelectedItem(docente.getTituloAcademico());
        frmRegistrarDocenteView1.spnAniosExperiencia.setValue(docente.getAniosExperiencia());

        frmRegistrarDocenteView1.txtDistrito.setText(docente.getDireccion().getDistrito());
        frmRegistrarDocenteView1.txtCalle.setText(docente.getDireccion().getCalle());
        frmRegistrarDocenteView1.txtNumeroCalle.setText(docente.getDireccion().getNumero());
        frmRegistrarDocenteView1.cbxProvincia.setSelectedItem(docente.getDireccion().getProvincia());

        frmRegistrarDocenteView1.txtTelefono.setText(docente.getTelefono());
        frmRegistrarDocenteView1.txtEmailpersonal.setText(docente.getEmailPersonal());
        //para los combobis

        desktopPane.add(frmRegistrarDocenteView1);
        frmRegistrarDocenteView1.toFront();
        frmRegistrarDocenteView1.setVisible(true);
    }

}
