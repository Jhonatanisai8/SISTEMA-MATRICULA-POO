package com.procesos;

import com.Utelerias.Constantes.ConstantesFormularioInicio;
import com.vista.frmInicioView;
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

    private static void estilosFormulario(frmInicioView frInicioView) {

        frInicioView.lblAdministrador.setText("Ad. : " + NOMBRE_ADMIN);
        frInicioView.txaDescripcion.setText(TEXTO_PRESENTACION);
        frInicioView.txaDescripcion.setEditable(false);

        //para poner el icono
        frInicioView.lblIconoInicio.setIcon(ICONO_IE);
        //para el borde
        frInicioView.txaDescripcion.setBorder(null);
        frInicioView.txaDescripcion.setFont(FUENTE_TEXT_PRESENTACION);
        frInicioView.lblAdministrador.setFont(FUENTE_TEXT_ADMIN);
        frInicioView.lblFecha.setFont(FUENTE_TEXT_FECHA);
        //fondo
        frInicioView.pnlFondo.setBackground(COLOR_FONDO_BLANCO);

    }

    public static void presentarFormulario(JDesktopPane desktopPane, frmInicioView frInicioView) {
        //llamamos a los metodos de esta misma clase
        establecerFecha(frInicioView);
        estilosFormulario(frInicioView);
        desktopPane.removeAll();
        desktopPane.add(frInicioView);
        frInicioView.toFront();
        frInicioView.setVisible(true);
    }
}
