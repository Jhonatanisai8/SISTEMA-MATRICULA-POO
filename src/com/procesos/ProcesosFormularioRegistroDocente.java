package com.procesos;

import com.Modelo.entidades.Docente;
import com.Utelerias.Constantes.ConstantesFormularioRegistroEstudianteDocente;
import com.vista.frmRegistrarDocenteView;
import javax.swing.JDesktopPane;

public class ProcesosFormularioRegistroDocente
        implements ConstantesFormularioRegistroEstudianteDocente {

    public static void rellenarComboBox(frmRegistrarDocenteView frmRegistrarDocenteView1) {
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

    public static void ponerIconosFormulario(frmRegistrarDocenteView frmRegistrarDocenteView1) {
        frmRegistrarDocenteView1.btnGuardar.setIcon(ICONO_BOTON_GUARDAR);
    }

    public static Docente crearDocente(frmRegistrarDocenteView frmRegistrarDocenteView1) {
        return null;
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

}
