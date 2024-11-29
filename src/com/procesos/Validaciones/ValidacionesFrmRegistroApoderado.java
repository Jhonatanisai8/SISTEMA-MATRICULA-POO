package com.procesos.Validaciones;

import com.vista.frmRegistrarApoderadoView;
import java.util.Date;
import java.util.regex.Pattern;

public class ValidacionesFrmRegistroApoderado {

    private static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[a-zA-Z]{2,4}$";

    private static boolean emailValido(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);//rea un objeto Pattern utilizando la expresión regular definida anteriormente.
        return pattern.matcher(email).matches();//crea un objeto Matcher que compara la cadena email con el patrón definido. 
    }

    private static boolean esNumerico(String cadena) {
        Pattern patron = Pattern.compile("\\d+"); // Solo dígitos
        return patron.matcher(cadena).matches(); //comparar la cadena de entrada con el patrón.
    }

    public static String validarCamposFrmRegistroEstudiante(frmRegistrarApoderadoView frmRegistrarApoderadoView) {

        //para el campo de nombre
        if (frmRegistrarApoderadoView.txtNombre.getText().isBlank()
                || frmRegistrarApoderadoView.txtNombre.getText().length() >= 55
                || frmRegistrarApoderadoView.txtNombre.getText().contains("123456789")) {
            return "Nombre.";
        }
        //para el campo de ap-Paterno
        if (frmRegistrarApoderadoView.txtApPaterno.getText().isBlank()
                || frmRegistrarApoderadoView.txtApPaterno.getText().length() >= 55
                || frmRegistrarApoderadoView.txtApPaterno.getText().contains("123456789")) {
            return "Apellido Paterno.";
        }

        //para el campo de ap-Materno
        if (frmRegistrarApoderadoView.txtApMaterno.getText().isBlank()
                || frmRegistrarApoderadoView.txtApMaterno.getText().length() >= 55
                || frmRegistrarApoderadoView.txtApMaterno.getText().contains("123456789")) {
            return "Apellido Materno.";
        }
        //para la fecha 
        if (frmRegistrarApoderadoView.dtcFechaNacimiento.getDate() == null
                || frmRegistrarApoderadoView.dtcFechaNacimiento.getDate().after(new Date())) {
            return "Fecha De Nacimiento.";
        }
        //para el tipo de documento de identidad
        if (frmRegistrarApoderadoView.cbxTipoDocumento.getSelectedIndex() == 0) {
            return "Tipo de Documento.";
        }
        //para el numero de documento de identidad
        if (frmRegistrarApoderadoView.txtNumeroDocumento.getText().isBlank()
                || frmRegistrarApoderadoView.txtNumeroDocumento.getText().length() > 10
                || esNumerico(frmRegistrarApoderadoView.txtNumeroDocumento.getText().trim()) == false) {
            return "Numero de Documento de Identidad.";
        }
        //para el distrito 
        if (frmRegistrarApoderadoView.txtDistrito.getText().isBlank()
                || frmRegistrarApoderadoView.txtDistrito.getText().length() > 50) {
            return "Distrito.";
        }
        //para la calle
        if (frmRegistrarApoderadoView.txtCalle.getText().isBlank()
                || frmRegistrarApoderadoView.txtCalle.getText().length() > 50) {
            return "Calle.";
        }
        //para el numero de calle
        if (frmRegistrarApoderadoView.txtNumeroCalle.getText().isBlank()
                || frmRegistrarApoderadoView.txtNumeroCalle.getText().length() > 55
                || esNumerico(frmRegistrarApoderadoView.txtNumeroCalle.getText().trim()) == false) {
            return "Nº de Calle.";
        }
        //para la provincia
        if (frmRegistrarApoderadoView.cbxProvincia.getSelectedIndex() == 0) {
            return "Provincia.";
        }
        //para el telefono 
        if (frmRegistrarApoderadoView.txtTelefono.getText().isBlank()
                || frmRegistrarApoderadoView.txtTelefono.getText().length() > 9) {
            return "Telefono.";
        }
        //para el correo personal 
        if (frmRegistrarApoderadoView.txtEmailpersonal.getText().isBlank()
                || emailValido(frmRegistrarApoderadoView.txtEmailpersonal.getText().trim()) == false) {
            return "Email Personal.";
        }
        //para la relacion con el estudiante 
        if (frmRegistrarApoderadoView.cbxRelacion.getSelectedIndex() == 0) {
            return "Relacion con el estudiante..";
        }

        //para la ocupacion
        if (frmRegistrarApoderadoView.cbxOcupacion.getSelectedIndex() == 0) {
            return "Ocupacion.";
        }
        //para el estado civil
        if (frmRegistrarApoderadoView.cbxEstadoCivil.getSelectedIndex() == 0) {
            return "Estado Civil.";
        }

        return "";
    }
}
