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
        ServiciosAdmSalones admSalones = new ServiciosAdmSalones();
        ServiciosAdmHorarios admHorarios = new ServiciosAdmHorarios();
        HorarioRepoImple horarioRepoImple = new HorarioRepoImple();
        admHorarios.mostrarRegistrosEnTabla(frmView.tblHorarios, ENCABEZADOS_TABLA, horarioRepoImple.listar());
        SalonReposiImple imple = new SalonReposiImple();
        admSalones.mostrarRegistrosEnTabla(frmView.tblSalones, ConstantesFormularioAdmSalones.TITULOS_COLUMNAS, imple.listar());
    }
}
