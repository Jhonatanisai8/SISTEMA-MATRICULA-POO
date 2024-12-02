package com.procesos;

import com.Utelerias.Constantes.ConstantesFormularioAdmHorarios;
import com.vista.frmAdmistrarHorariosView;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;

public class ProcesosFormularioAdmHorarios
        implements ConstantesFormularioAdmHorarios {

    public static void presentarFormulario(JDesktopPane esDesktopPane, frmAdmistrarHorariosView frmAdmistrarHorariosView) {
        rellenarComboBox(frmAdmistrarHorariosView);
        esDesktopPane.removeAll();
        esDesktopPane.add(frmAdmistrarHorariosView);
        frmAdmistrarHorariosView.toFront();
        frmAdmistrarHorariosView.setVisible(true);
    }

    private static void rellenarComboBox(frmAdmistrarHorariosView frmAdmistrarHorariosView) {
        frmAdmistrarHorariosView.cbxDiaSemana.removeAllItems();
        frmAdmistrarHorariosView.cbxHoraFin.removeAllItems();
        frmAdmistrarHorariosView.cbxTurno.removeAllItems();
        frmAdmistrarHorariosView.cbxHoraInicio.removeAllItems();
        frmAdmistrarHorariosView.cbxDiaSemana.setModel(new DefaultComboBoxModel<>(DIA_SEMANA));
        frmAdmistrarHorariosView.cbxHoraFin.setModel(new DefaultComboBoxModel<>(HORA_FIN));
        frmAdmistrarHorariosView.cbxHoraInicio.setModel(new DefaultComboBoxModel<>(HORA_INICIO));
        frmAdmistrarHorariosView.cbxTurno.setModel(new DefaultComboBoxModel<>(TURNO));
    }
}
