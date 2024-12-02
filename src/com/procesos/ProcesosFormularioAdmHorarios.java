package com.procesos;

import com.Modelo.entidades.Horario;
import com.Utelerias.Constantes.ConstantesFormularioAdmHorarios;
import com.procesos.Validaciones.ValidacionesFrmAdmHorarios;
import com.vista.frmAdmistrarHorariosView;
import java.awt.HeadlessException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

public class ProcesosFormularioAdmHorarios
        implements ConstantesFormularioAdmHorarios {

    public static void presentarFormulario(JDesktopPane esDesktopPane, frmAdmistrarHorariosView frmAdmistrarHorariosView) {
        rellenarComboBox(frmAdmistrarHorariosView);
        esDesktopPane.removeAll();
        esDesktopPane.add(frmAdmistrarHorariosView);
        frmAdmistrarHorariosView.toFront();
        frmAdmistrarHorariosView.setVisible(true);
    }

    public static Horario crearHorarioFormulario(frmAdmistrarHorariosView frmAdmistrarHorariosView) {
        Horario miHorario = null;
        String validacion = ValidacionesFrmAdmHorarios.validarCampos(frmAdmistrarHorariosView);
        if (!validacion.equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor revisar el campo de: " + validacion, "ATENCIÓN ", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        try {
            miHorario = new Horario();
            miHorario.setDiaSemana(frmAdmistrarHorariosView.cbxDiaSemana.getSelectedItem().toString());
            DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime horaInicio = LocalTime.parse(frmAdmistrarHorariosView.cbxHoraInicio.getSelectedItem().toString().trim(), df);
            LocalTime horaFin = LocalTime.parse(frmAdmistrarHorariosView.cbxHoraFin.getSelectedItem().toString().trim(), df);
            miHorario.setHoraInicio(horaInicio);
            miHorario.setHoraFin(horaFin);
            miHorario.setTurno(frmAdmistrarHorariosView.cbxTurno.getSelectedItem().toString());
        } catch (HeadlessException e) {
            System.out.println("error al crear un apoderado: " + e.getMessage());
            return null;
        }
        return miHorario;
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
