package com.procesos.Servicios;

import com.Modelo.entidades.DaoImplementacion.HorarioRepoImple;
import com.Modelo.entidades.DaoImplementacion.SalonReposiImple;
import com.Utelerias.Constantes.ConstantesFormularioAdmHorarios;
import com.Utelerias.Constantes.ConstantesFormularioAdmSalones;
import com.vista.frmAdministrarAsignacionesView;

public class ServiciosAdmAsignaciones
        implements ConstantesFormularioAdmHorarios,
        ConstantesFormularioAdmSalones {

    public static void mostrarRegistrosEnTablas(frmAdministrarAsignacionesView frmView) {
        HorarioRepoImple horarioRepoImple = new HorarioRepoImple();
        ServiciosAdmHorarios.mostrarHorarios(frmView.tblHorarios, ENCABEZADOS_TABLA, horarioRepoImple.listar());
        SalonReposiImple imple = new SalonReposiImple();
        ServiciosAdmSalones.mostrarSalonesEnTabla(frmView.tblSalones, ConstantesFormularioAdmSalones.TITULOS_COLUMNAS, imple.listar());
        
    }
}
