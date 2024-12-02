package com.procesos;

import com.Modelo.entidades.DaoImplementacion.HorarioRepoImple;
import com.Modelo.entidades.Horario;
import com.Modelo.entidades.InterfaceDao.Repositorio;
import com.Utelerias.Constantes.ConstantesFormularioAdmHorarios;
import com.vista.frmAdministrarAsignacionesView;
import javax.swing.JDesktopPane;

public class ProcesosFormularioAdmAsignaciones
        implements ConstantesFormularioAdmHorarios {

    public static void presentarFormulario(JDesktopPane desktopPane, frmAdministrarAsignacionesView frmAdministrarAsignacionesView) {
        Repositorio<Horario> repo = new HorarioRepoImple();
        desktopPane.removeAll();
        desktopPane.add(frmAdministrarAsignacionesView);
        frmAdministrarAsignacionesView.setTitle("Registro de asignaciones".toUpperCase());
        frmAdministrarAsignacionesView.toFront();
        frmAdministrarAsignacionesView.setVisible(true);
        System.out.println("Haciendo visible el registor de asiganaciones....");
    }
}
