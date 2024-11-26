package com.controlador;

import com.Modelo.entidades.DaoImplementacion.DocenteReposioImple;
import com.Modelo.entidades.Docente;
import com.Modelo.entidades.InterfaceDao.Repositorio;
import com.procesos.ProcesosFormularioRegistroDocente;
import com.procesos.Servicios.ServiciosDocente;
import com.vista.frmMenuView;
import com.vista.frmRegistrarDocenteView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorFormularioRegistroDocente
        implements ActionListener {

    private final frmRegistrarDocenteView frmRegistrarDocenteView;
    private final frmMenuView frmMenuView;
    private Docente miDocente;
    private Docente docenteModificar;

    public ControladorFormularioRegistroDocente(frmRegistrarDocenteView frmRegistrarDocenteView, frmMenuView frmMenuView) {
        this.frmRegistrarDocenteView = frmRegistrarDocenteView;
        this.frmMenuView = frmMenuView;
        this.frmRegistrarDocenteView.btnGuardar.addActionListener(this);
        ProcesosFormularioRegistroDocente.presentarFormulario(this.frmMenuView.dsktEscritorio, this.frmRegistrarDocenteView);
    }

    //controlafor para editar
    public ControladorFormularioRegistroDocente(frmRegistrarDocenteView frmRegistrarDocenteView, frmMenuView frmMenuView, Docente docente) {
        this.frmRegistrarDocenteView = frmRegistrarDocenteView;
        this.frmMenuView = frmMenuView;
        this.docenteModificar = docente;
        this.frmRegistrarDocenteView.btnGuardar.addActionListener(this);
        this.frmRegistrarDocenteView.btnGuardar.setText("Modificar");
        ProcesosFormularioRegistroDocente.presentarFormulario(this.frmMenuView.dsktEscritorio, this.frmRegistrarDocenteView, this.docenteModificar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Repositorio<Docente> repo = new DocenteReposioImple();
        //si el usuario da clik sobre guardar 
        if (e.getSource() == this.frmRegistrarDocenteView.btnGuardar) {
            //si esta en guardar
            if (!frmRegistrarDocenteView.btnGuardar.getText().equalsIgnoreCase("Modificar")) {
                miDocente = ProcesosFormularioRegistroDocente.crearDocenteFormulario(this.frmRegistrarDocenteView);
                repo.guardar(miDocente);
                ServiciosDocente.limpiarDatos(frmRegistrarDocenteView);
                System.out.println("Has dado click para guardar.....");
            } else { //si esta en modificar
                Long idDocente = this.docenteModificar.getIdDocente(); // obtenemos el id
                Docente midocente = ProcesosFormularioRegistroDocente.crearDocenteFormulario(this.frmRegistrarDocenteView);
                midocente.setIdDocente(idDocente);
                repo.modificar(midocente);
                ServiciosDocente.limpiarDatos(frmRegistrarDocenteView);
                System.out.println("Has dado click para modificar.....");
            }
        }
    }

}
