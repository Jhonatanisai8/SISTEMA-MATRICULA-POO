package com.procesos.Validaciones;

import com.vista.frmRegistrarDocenteView;
import java.util.Date;
import java.util.regex.Pattern;

public class ValidacionesFrmRegistroDocente {

    private static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[a-zA-Z]{2,4}$";

    private static boolean emailValido(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);//rea un objeto Pattern utilizando la expresión regular definida anteriormente.
        return pattern.matcher(email).matches();//crea un objeto Matcher que compara la cadena email con el patrón definido. 
    }

    private static boolean esNumerico(String cadena) {
        Pattern patron = Pattern.compile("\\d+"); // Solo dígitos
        return patron.matcher(cadena).matches(); //comparar la cadena de entrada con el patrón.
    }

    public static String validarCamposFrmRegistroEstudiante(frmRegistrarDocenteView frmDocenteView) {

        //para el campo de nombre
        if (frmDocenteView.txtNombre.getText().isBlank()
                || frmDocenteView.txtNombre.getText().length() >= 55
                || frmDocenteView.txtNombre.getText().contains("123456789")) {
            return "Nombre.";
        }
        //para el campo de ap-Paterno
        if (frmDocenteView.txtApPaterno.getText().isBlank()
                || frmDocenteView.txtApPaterno.getText().length() >= 55
                || frmDocenteView.txtApPaterno.getText().contains("123456789")) {
            return "Apellido Paterno.";
        }

        //para el campo de ap-Materno
        if (frmDocenteView.txtApMaterno.getText().isBlank()
                || frmDocenteView.txtApMaterno.getText().length() >= 55
                || frmDocenteView.txtApMaterno.getText().contains("123456789")) {
            return "Apellido Materno.";
        }
        //para la fecha 
        if (frmDocenteView.dtcFechaNacimiento.getDate() == null
                || frmDocenteView.dtcFechaNacimiento.getDate().after(new Date())) {
            return "Fecha De Nacimiento.";
        }
        //para el tipo de documento de identidad
        if (frmDocenteView.cbxTipoDocumento.getSelectedIndex() == 0) {
            return "Tipo de Documento.";
        }
        //para el numero de documento de identidad
        if (frmDocenteView.txtNumeroDocumento.getText().isBlank()
                || frmDocenteView.txtNumeroDocumento.getText().length() > 10
                || esNumerico(frmDocenteView.txtNumeroDocumento.getText().trim()) == false) {
            return "Numero de Documento de Identidad.";
        }
        //para el distrito 
        if (frmDocenteView.txtDistrito.getText().isBlank()
                || frmDocenteView.txtDistrito.getText().length() > 50) {
            return "Distrito.";
        }
        //para la calle
        if (frmDocenteView.txtCalle.getText().isBlank()
                || frmDocenteView.txtCalle.getText().length() > 50) {
            return "Calle.";
        }
        //para el numero de calle
        if (frmDocenteView.txtNumeroCalle.getText().isBlank()
                || frmDocenteView.txtNumeroCalle.getText().length() > 55
                || esNumerico(frmDocenteView.txtNumeroCalle.getText().trim()) == false) {
            return "Nº de Calle.";
        }
        //para la provincia
        if (frmDocenteView.cbxProvincia.getSelectedIndex() == 0) {
            return "Provincia.";
        }
        //para el telefono 
        if (frmDocenteView.txtTelefono.getText().isBlank()
                || frmDocenteView.txtTelefono.getText().length() > 9) {
            return "Telefono.";
        }
        //para el correo personal 
        if (frmDocenteView.txtEmailpersonal.getText().isBlank()
                || emailValido(frmDocenteView.txtEmailpersonal.getText().trim()) == false) {
            return "Email Personal.";
        }

        //para el titulo academico 
        if (frmDocenteView.cbxTituloAcademico.getSelectedIndex() == 0) {
            return "Titulo Academico.";
        }

        //para los añis de experiencia 
        if (Integer.parseInt(frmDocenteView.spnAniosExperiencia.getValue().toString()) <= 0) {
            return "Años de Experiencia.";
        }
        return "";
    }
}
