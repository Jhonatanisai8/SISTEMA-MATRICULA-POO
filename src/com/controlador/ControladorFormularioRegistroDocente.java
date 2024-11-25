package com.controlador;

import com.Modelo.entidades.DaoImplementacion.DocenteReposioImple;
import com.Modelo.entidades.Docente;
import com.Modelo.entidades.InterfaceDao.Repositorio;
import com.procesos.ProcesosFormularioRegistroDocente;
import com.vista.frmMenuView;
import com.vista.frmRegistrarDocenteView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorFormularioRegistroDocente
        implements ActionListener {
    
    private frmRegistrarDocenteView frmRegistrarDocenteView;
    private frmMenuView frmMenuView;
    private Docente miDocente;
    
    public ControladorFormularioRegistroDocente(frmRegistrarDocenteView frmRegistrarDocenteView, frmMenuView frmMenuView) {
        this.frmRegistrarDocenteView = frmRegistrarDocenteView;
        this.frmMenuView = frmMenuView;
        this.frmRegistrarDocenteView.btnGuardar.addActionListener(this);
        ProcesosFormularioRegistroDocente.presentarFormulario(this.frmMenuView.dsktEscritorio, this.frmRegistrarDocenteView);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Repositorio<Docente> repo = new DocenteReposioImple();
        //si el usuario da clik sobre guardar 
        if (e.getSource() == this.frmRegistrarDocenteView.btnGuardar) {
            miDocente = ProcesosFormularioRegistroDocente.crearDocenteFormulario(this.frmRegistrarDocenteView);
            repo.guardar(miDocente);
        }
    }
    
}
