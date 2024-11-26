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
        this.miDocente = docente;
        this.frmRegistrarDocenteView.btnGuardar.addActionListener(this);
        this.frmRegistrarDocenteView.btnGuardar.setText("Modificar");
        ProcesosFormularioRegistroDocente.presentarFormulario(this.frmMenuView.dsktEscritorio, this.frmRegistrarDocenteView, this.miDocente);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Repositorio<Docente> repo = new DocenteReposioImple();
        //si el usuario da clik sobre guardar 
        if (e.getSource() == this.frmRegistrarDocenteView.btnGuardar) {
            miDocente = ProcesosFormularioRegistroDocente.crearDocenteFormulario(this.frmRegistrarDocenteView);
            repo.guardar(miDocente);
            ServiciosDocente.limpiarDatos(frmRegistrarDocenteView);
        }
    }
    
}
