package com.procesos;

import com.Modelo.entidades.ApoderadoDatos;
import com.Modelo.entidades.DaoImplementacion.EstudianteReposioImple;
import com.Modelo.entidades.Direccion;
import com.Modelo.entidades.Dni;
import com.Modelo.entidades.Estudiante;
import static com.Utelerias.Constantes.ConstantesFormularioListadoEstudiantesDocentes.FUENTE_TEXT_PRESENTACION;
import com.procesos.Servicios.ServiciosEstudianteDocente;
import com.procesos.Validaciones.ValidacionesFrmRegistroEstudiante;
import com.vista.frmRegistrarEstudianteView;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import com.Utelerias.Constantes.ConstantesFormularioRegistroEstudianteDocente;
import java.util.List;

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

    public static List<ApoderadoDatos> obtenerLista() {
        EstudianteReposioImple e = new EstudianteReposioImple();
        return e.listarApoderadoDatos();
    }

    private static void ponerIconosFormulario(frmRegistrarEstudianteView frEstudiante) {
        frEstudiante.tblApoderados.setFont(FUENTE_TEXT_PRESENTACION);
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
        ServiciosEstudianteDocente.mostrarDatosApoderadoTabla(fr, ENCABEZADOS_APODERADO_TABLA, obtenerLista());
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

    public static Estudiante crearEstudiante(frmRegistrarEstudianteView frmEstudianteView) {
        Estudiante e = null;
        String validacion = ValidacionesFrmRegistroEstudiante.validarCamposFrmRegistroEstudiante(frmEstudianteView);
        if (!validacion.equals("")) {
            JOptionPane.showMessageDialog(null, "Revisar el campo " + validacion, "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
            return null;
        }

        try {
            // Creando el DNI
            Dni dni = new Dni();
            dni.setTipoDocumentoDni(frmEstudianteView.cbxTipoDocumento.getSelectedItem().toString());
            dni.setNumeroDni(frmEstudianteView.txtNumeroDocumento.getText());

            // Creando la dirección
            Direccion direccion = new Direccion();
            direccion.setDistrito(frmEstudianteView.txtDistrito.getText());
            direccion.setCalle(frmEstudianteView.txtCalle.getText());
            direccion.setNumero(frmEstudianteView.txtNumeroCalle.getText());
            direccion.setProvincia(frmEstudianteView.cbxProvincia.getSelectedItem().toString());

            // Creando el estudiante
            e = new Estudiante();
            e.setNombre(frmEstudianteView.txtNombre.getText());
            e.setApellidoPaterno(frmEstudianteView.txtApPaterno.getText());
            e.setApellidoMaterno(frmEstudianteView.txtApMaterno.getText());
            e.setFechaNacimiento(frmEstudianteView.dtcFechaNacimiento.getDate());
            e.setDni(dni);
            e.setDireccion(direccion);
            e.setTelefono(frmEstudianteView.txtTelefono.getText());
            e.setEmailPersonal(frmEstudianteView.txtEmailpersonal.getText());

            // Generando código y correo educativo
            String nombre = frmEstudianteView.txtNombre.getText();
            String apPaterno = frmEstudianteView.txtApPaterno.getText();
            String apMaterno = frmEstudianteView.txtApMaterno.getText();
            e.setCodigoEstudiante(ServiciosEstudianteDocente.generarCodigo(nombre, apPaterno));
            e.setEmailEducativo(ServiciosEstudianteDocente.generarCorreoEducatico(nombre, apPaterno, apMaterno));

        } catch (Exception ex) {
            // Manejo de excepciones, como un error al obtener los datos de los campos
            ex.printStackTrace();  // O usar un logger
            JOptionPane.showMessageDialog(null, "Ocurrió un error al crear el estudiante.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return e;
    }

}
