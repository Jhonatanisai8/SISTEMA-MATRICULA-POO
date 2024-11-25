package com.procesos.Servicios;

import com.Modelo.entidades.Docente;
import com.vista.frmListadoDocentesView;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ServiciosDocente {

    public static void mostrarDocentesEnTabla(frmListadoDocentesView frmListadoDocentesView, String columnas[], List<Docente> listaDocentes) {
        Object[][] data = new Object[listaDocentes.size()][columnas.length];
        for (int i = 0; i < listaDocentes.size(); i++) {
            Docente docente = listaDocentes.get(i);
            data[i][0] = docente.getIdDocente();
            data[i][1] = docente.getNombre();
            data[i][2] = docente.getApellidoPaterno();
            data[i][3] = docente.getApellidoMaterno();
            data[i][4] = docente.getFechaNacimiento();
            data[i][5] = docente.getDni().getTipoDocumentoDni();
            data[i][6] = docente.getDni().getNumeroDni();
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
        //creamo el modelo 
        DefaultTableModel modelo = new DefaultTableModel(data, columnas);
        frmListadoDocentesView.btlData.setModel(modelo);
        System.out.println("Mostrando todos los docentes.....");
    }
}
