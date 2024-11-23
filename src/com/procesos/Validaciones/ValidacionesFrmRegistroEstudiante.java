package com.procesos.Validaciones;

import com.vista.frmRegistrarEstudiante;
import java.util.Date;
import java.util.regex.Pattern;

public class ValidacionesFrmRegistroEstudiante {

    private static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[a-zA-Z]{2,4}$";

    private static boolean emailValido(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);//rea un objeto Pattern utilizando la expresión regular definida anteriormente.
        return pattern.matcher(email).matches();//crea un objeto Matcher que compara la cadena email con el patrón definido. 
    }

    private static boolean esNumerico(String cadena) {
        Pattern patron = Pattern.compile("\\d+"); // Solo dígitos
        return patron.matcher(cadena).matches(); //comparar la cadena de entrada con el patrón.
    }

    public static String validarCamposFrmRegistroEstudiante(frmRegistrarEstudiante frmEstudiante) {

        //para el campo de nombre
        if (frmEstudiante.txtNombre.getText().isBlank()
                || frmEstudiante.txtNombre.getText().length() >= 55
                || frmEstudiante.txtNombre.getText().contains("123456789")) {
            return "Nombre.";
        }
        //para el campo de ap-Paterno
        if (frmEstudiante.txtApPaterno.getText().isBlank()
                || frmEstudiante.txtApPaterno.getText().length() >= 55
                || frmEstudiante.txtApPaterno.getText().contains("123456789")) {
            return "Apellido Paterno.";
        }

        //para el campo de ap-Materno
        if (frmEstudiante.txtApMaterno.getText().isBlank()
                || frmEstudiante.txtApMaterno.getText().length() >= 55
                || frmEstudiante.txtApMaterno.getText().contains("123456789")) {
            return "Apellido Materno.";
        }
        //para la fecha 
        if (frmEstudiante.dtcFechaNacimiento.getDate() == null
                || frmEstudiante.dtcFechaNacimiento.getDate().after(new Date())) {
            return "Fecha De Nacimiento.";
        }
        //para el tipo de documento de identidad
        if (frmEstudiante.cbxTipoDocumento.getSelectedIndex() == 0) {
            return "Tipo de Documento.";
        }
        //para el numero de documento de identidad
        if (frmEstudiante.txtNumeroDocumento.getText().isBlank()
                || frmEstudiante.txtNumeroDocumento.getText().length() > 10
                || frmEstudiante.txtNumeroDocumento.getText().length() < 10
                || esNumerico(frmEstudiante.txtNumeroDocumento.getText().trim()) == false) {
            return "Numero de Documento de Identidad.";
        }
        //para el distrito 
        if (frmEstudiante.txtDistrito.getText().isBlank()
                || frmEstudiante.txtDistrito.getText().length() > 50) {
            return "Distrito.";
        }
        //para la calle
        if (frmEstudiante.txtCalle.getText().isBlank()
                || frmEstudiante.txtCalle.getText().length() > 50) {
            return "Calle.";
        }
        //para el numero de calle
        if (frmEstudiante.txtNumeroCalle.getText().isBlank()
                || frmEstudiante.txtNumeroCalle.getText().length() > 55
                || esNumerico(frmEstudiante.txtNumeroCalle.getText().trim()) == false) {
            return "Nº de Calle.";
        }
        //para la provincia
        if (frmEstudiante.cbxProvincia.getSelectedIndex() == 0) {
            return "Provincia.";
        }
        //para el telefono 
        if (frmEstudiante.txtTelefono.getText().isBlank()
                || frmEstudiante.txtTelefono.getText().length() > 9) {
            return "Telefono.";
        }
        //para el correo personal 
        if (frmEstudiante.txtEmailpersonal.getText().isBlank()
                || emailValido(frmEstudiante.txtEmailpersonal.getText().trim()) == false) {
            return "Email Personal.";
        }

        return "";
    }
}
