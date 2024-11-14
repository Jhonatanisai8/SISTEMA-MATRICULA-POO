package com.procesos;

import com.Utelerias.Constantes.ConstantesFormularioInicio;
import com.vista.frmInicioView;
import com.vista.frmMenuView;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JDesktopPane;

public class ProcesosFormularioInicio
        implements ConstantesFormularioInicio {

    private static void establecerFecha(frmInicioView fr) {
        LocalDate now = LocalDate.now();
        Locale spanishLocale = new Locale("es", "ES");
        fr.lblFecha.setText(now.format(DateTimeFormatter.ofPattern("'Hoy es' EEEE dd 'de' MMMM 'de' yyyy", spanishLocale)));
    }

    public static void presentarFormulario(JDesktopPane desktopPane, frmInicioView frInicioView) {
        frInicioView.lblAdministrador.setText(nombreAdmin);
        establecerFecha(frInicioView);
        frInicioView.txaDescripcion.setText("Bienvenido al Sistema de Matrícula Escolar."
                + " \n Aquí puedes gestionar fácilmente estudiantes, docentes, "
                + "\n cursos y horarios para llevar un registro organizado"
                + "\n y eficiente de tu institución.");
        desktopPane.add(frInicioView);
        frInicioView.toFront();
        frInicioView.setVisible(true);
    }
}
