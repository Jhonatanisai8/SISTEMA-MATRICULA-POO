package com.procesos;

import com.Utelerias.Constantes.ConstantesFormularioRegistroEstudianteDocente;
import com.vista.frmRegistrarDocenteView;

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
}
