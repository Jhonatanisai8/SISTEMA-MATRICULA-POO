package com.procesos.Servicios;

import com.Modelo.entidades.Docente;
import com.Utelerias.Constantes.Utelerias;
import com.vista.frmRegistrarDocenteView;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class ServiciosDocente
        extends Utelerias<Docente> {

    @Override
    public void establecerAnchoColumnasTabla(JTable tblTabla, int[] anchoColumnas) {
        for (int i = 0; i < anchoColumnas.length && i < tblTabla.getColumnCount(); i++) {
            TableColumn column = tblTabla.getColumnModel().getColumn(i);
            column.setPreferredWidth(anchoColumnas[i]);
        }
    }

    @Override
    public void mostrarRegistrosEnTabla(JTable tblData, String[] nombreColumnas, List<Docente> listaDocentes) {
        Object[][] data = new Object[listaDocentes.size()][nombreColumnas.length];
        for (int i = 0; i < listaDocentes.size(); i++) {
            Docente docente = listaDocentes.get(i);
            data[i][0] = docente.getIdDocente();
            data[i][1] = docente.getNombre();
            data[i][2] = docente.getApellidoPaterno();
            data[i][3] = docente.getApellidoMaterno();
            data[i][4] = docente.getFechaNacimiento();
            data[i][5] = docente.getDni().getTipoDocumentoDni();
            data[i][6] = docente.getDni().getNumeroDni().toString();
            data[i][7] = docente.getDireccion().getCalle();
            data[i][8] = docente.getDireccion().getNumero();
            data[i][9] = docente.getDireccion().getDistrito();
            data[i][10] = docente.getDireccion().getProvincia();
            data[i][11] = docente.getTelefono();
            data[i][12] = docente.getEmailPersonal();
            data[i][13] = docente.getCodigoDocente();
            data[i][14] = docente.getTituloAcademico();
            data[i][15] = docente.getAniosExperiencia();
            data[i][16] = docente.getEmailEducativoDocente();
        }
        DefaultTableModel modelo = new DefaultTableModel(data, nombreColumnas);
        tblData.setModel(modelo);
        System.out.println("Mostrando todos los docentes.....");
    }

    @Override
    public void mostrarRegistroSoloTabla(JTable tblData, String[] nombreColumnas, Docente docente) {
        Object[] datos = new Object[nombreColumnas.length];
        datos[0] = docente.getIdDocente();
        datos[1] = docente.getNombre();
        datos[2] = docente.getApellidoPaterno();
        datos[3] = docente.getApellidoMaterno();
        datos[4] = docente.getFechaNacimiento();
        datos[5] = docente.getDni().getTipoDocumentoDni();
        datos[6] = docente.getDni().getNumeroDni();
        datos[7] = docente.getDireccion().getCalle();
        datos[8] = docente.getDireccion().getNumero();
        datos[9] = docente.getDireccion().getDistrito();
        datos[10] = docente.getDireccion().getProvincia();
        datos[11] = docente.getTelefono();
        datos[12] = docente.getEmailPersonal();
        datos[13] = docente.getCodigoDocente();
        datos[14] = docente.getTituloAcademico();
        datos[15] = docente.getAniosExperiencia();
        datos[16] = docente.getEmailEducativoDocente();

        DefaultTableModel modeloTabla = new DefaultTableModel(new Object[][]{datos}, nombreColumnas);
        tblData.setModel(modeloTabla);
        System.out.println("Mostrando un solo estudiante en la tabla.....");
    }

    public static void limpiarDatos(frmRegistrarDocenteView frView) {
        //JTextField
        frView.txtApMaterno.setText("");
        frView.txtApPaterno.setText("");
        frView.txtCalle.setText("");
        frView.txtDistrito.setText("");
        frView.txtEmailpersonal.setText("");
        frView.txtNombre.setText("");
        frView.txtNumeroCalle.setText("");
        frView.txtNumeroDocumento.setText("");
        frView.txtTelefono.setText("");
        //combobox
        frView.cbxProvincia.setSelectedIndex(0);
        frView.cbxTipoDocumento.setSelectedIndex(0);
        frView.cbxTituloAcademico.setSelectedIndex(0);
        //fecha
        frView.dtcFechaNacimiento.setDate(null);
        frView.spnAniosExperiencia.setValue(0);
    }
}
