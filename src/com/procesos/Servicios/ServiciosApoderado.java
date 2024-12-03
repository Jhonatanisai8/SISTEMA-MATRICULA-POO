package com.procesos.Servicios;

import com.Modelo.entidades.Apoderado;
import com.Utelerias.Constantes.Utelerias;
import com.vista.frmRegistrarApoderadoView;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class ServiciosApoderado
        extends Utelerias<Apoderado> {

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

    @Override
    public void establecerAnchoColumnasTabla(JTable tblTabla, int[] anchoColumnas) {
        for (int i = 0; i < anchoColumnas.length && i < tblTabla.getColumnCount(); i++) {
            TableColumn column = tblTabla.getColumnModel().getColumn(i);
            column.setPreferredWidth(anchoColumnas[i]);
        }
    }

    @Override
    public void mostrarRegistrosEnTabla(JTable tblData, String[] nombreColumnas, List<Apoderado> listaApoderados) {
        Object data[][] = new Object[listaApoderados.size()][nombreColumnas.length];
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
        DefaultTableModel modeloTabla = new DefaultTableModel(data, nombreColumnas);
        tblData.setModel(modeloTabla);
        System.out.println("Listando en tabla todos los apoderados.....");
    }

    @Override
    public void mostrarRegistroSoloTabla(JTable tblData, String[] nombreColumnas, Apoderado apoderado) {
        Object[] data = new Object[nombreColumnas.length];
        data[0] = apoderado.getIdApoderado();
        data[1] = apoderado.getNombre();
        data[2] = apoderado.getApellidoPaterno();
        data[3] = apoderado.getApellidoMaterno();
        data[4] = apoderado.getFechaNacimiento();
        data[5] = apoderado.getDni().getTipoDocumentoDni();
        data[6] = apoderado.getDni().getNumeroDni();
        data[7] = apoderado.getDireccion().getCalle();
        data[8] = apoderado.getDireccion().getNumero();
        data[9] = apoderado.getDireccion().getDistrito();
        data[10] = apoderado.getDireccion().getProvincia();
        data[11] = apoderado.getTelefono();
        data[12] = apoderado.getEmailPersonal();
        data[13] = apoderado.getRelacionEstudiante();
        data[14] = apoderado.getOcupacion();
        data[15] = apoderado.getEstadoCivil();

        DefaultTableModel modeloTabla = new DefaultTableModel(new Object[][]{data}, nombreColumnas);
        tblData.setModel(modeloTabla);
        System.out.println("Mostrando un solo estudiante en la tabla.....");
    }

}
