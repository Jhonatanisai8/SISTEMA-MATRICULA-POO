package com.procesos.Servicios;

import com.Modelo.entidades.Apoderado;
import com.vista.frmListadoApoderadosView;
import com.vista.frmRegistrarApoderadoView;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ServiciosApoderado {

    public static void limpiarDatos(frmRegistrarApoderadoView frmRegistrarApoderadoView) {
        frmRegistrarApoderadoView.txtApMaterno.setText("");
        frmRegistrarApoderadoView.txtApPaterno.setText("");
        frmRegistrarApoderadoView.txtCalle.setText("");
        frmRegistrarApoderadoView.txtDistrito.setText("");
        frmRegistrarApoderadoView.txtEmailpersonal.setText("");
        frmRegistrarApoderadoView.txtNombre.setText("");
        frmRegistrarApoderadoView.txtNumeroCalle.setText("");
        frmRegistrarApoderadoView.txtNumeroDocumento.setText("");
        frmRegistrarApoderadoView.txtTelefono.setText("");
        frmRegistrarApoderadoView.txtNombre.requestFocus();

        frmRegistrarApoderadoView.cbxEstadoCivil.setSelectedIndex(0);
        frmRegistrarApoderadoView.cbxOcupacion.setSelectedIndex(0);
        frmRegistrarApoderadoView.cbxProvincia.setSelectedIndex(0);
        frmRegistrarApoderadoView.cbxRelacion.setSelectedIndex(0);
        frmRegistrarApoderadoView.cbxTipoDocumento.setSelectedIndex(0);
        frmRegistrarApoderadoView.dtcFechaNacimiento.setDate(null);

    }

    public static void mostrarEstudiantesEnTabla(frmListadoApoderadosView frListadoApoderadosVie, String titulosColumnas[], List<Apoderado> listaApoderados) {
        Object data[][] = new Object[listaApoderados.size()][titulosColumnas.length];

        for (int i = 0; i < listaApoderados.size(); i++) {
            Apoderado apoderado = listaApoderados.get(i);  // Obtener el apoderado correspondiente a la fila i
            data[i][0] = apoderado.getIdApoderado();
            data[i][1] = apoderado.getNombre();
            data[i][2] = apoderado.getApellidoPaterno();
            data[i][3] = apoderado.getApellidoMaterno();
            data[i][4] = apoderado.getFechaNacimiento();
            data[i][5] = apoderado.getDni().getTipoDocumentoDni();
            data[i][6] = apoderado.getDni().getNumeroDni();
            data[i][7] = apoderado.getDireccion().getCalle();
            data[i][8] = apoderado.getDireccion().getNumero();
            data[i][9] = apoderado.getDireccion().getDistrito();
            data[i][10] = apoderado.getDireccion().getProvincia();
            data[i][11] = apoderado.getTelefono();
            data[i][12] = apoderado.getEmailPersonal();
            data[i][13] = apoderado.getRelacionEstudiante();
            data[i][14] = apoderado.getOcupacion();
            data[i][15] = apoderado.getEstadoCivil();
        }

        DefaultTableModel modeloTabla = new DefaultTableModel(data, titulosColumnas);
        frListadoApoderadosVie.tblDatos.setModel(modeloTabla);
        // Imprimir mensaje de confirmación
        System.out.println("Listando en tabla todos los apoderados.....");
    }

}
