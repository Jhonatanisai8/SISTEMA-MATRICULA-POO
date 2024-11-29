package com.controlador;

import com.Modelo.entidades.Apoderado;
import com.Modelo.entidades.DaoImplementacion.ApoderadoReposiImple;
import com.Modelo.entidades.InterfaceDao.Repositorio;
import com.procesos.ProcesosFormularioRegistroApoderado;
import com.procesos.Servicios.ServiciosApoderado;
import com.vista.frmMenuView;
import com.vista.frmRegistrarApoderadoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorFormularioRegistroApoderado
        implements ActionListener {

    private final frmRegistrarApoderadoView frmRegistrarApoderadoView;
    private final frmMenuView frmMenuView;
    private Apoderado miApoderado;
    private Apoderado apoderadoModificar;

    public ControladorFormularioRegistroApoderado(frmRegistrarApoderadoView frmRegistrarApoderadoView, frmMenuView frmMenuView) {
        this.frmRegistrarApoderadoView = frmRegistrarApoderadoView;
        this.frmMenuView = frmMenuView;
        this.frmRegistrarApoderadoView.btnGuardar.addActionListener(this);
        ProcesosFormularioRegistroApoderado.presentarFormulario(this.frmMenuView.dsktEscritorio, this.frmRegistrarApoderadoView);
    }

    //constructor para la funcionalidad de modificar 
    public ControladorFormularioRegistroApoderado(frmRegistrarApoderadoView frmRegistrarApoderadoView, frmMenuView frmMenuView, Apoderado apoderadoModificar) {
        this.frmRegistrarApoderadoView = frmRegistrarApoderadoView;
        this.frmMenuView = frmMenuView;
        this.apoderadoModificar = apoderadoModificar;
        this.frmRegistrarApoderadoView.btnGuardar.addActionListener(this);
        this.frmRegistrarApoderadoView.btnGuardar.setText("Modificar");
        ProcesosFormularioRegistroApoderado.presentarFormulario(this.frmMenuView.dsktEscritorio, this.frmRegistrarApoderadoView, this.apoderadoModificar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Repositorio<Apoderado> repositorio = new ApoderadoReposiImple();
        if (e.getSource() == this.frmRegistrarApoderadoView.btnGuardar) {
            if (frmRegistrarApoderadoView.btnGuardar.getText().equalsIgnoreCase("guardar")) {
                miApoderado = ProcesosFormularioRegistroApoderado.crearApoderadoDesdeFormulario(frmRegistrarApoderadoView);
                if (miApoderado != null) {
                    repositorio.guardar(miApoderado);
                    ServiciosApoderado.limpiarDatos(frmRegistrarApoderadoView);
                    JOptionPane.showMessageDialog(null, "Apoderado con nombre: " + miApoderado.getNombre(), "Atención", 3);
                } else {
                    JOptionPane.showMessageDialog(null, "Error, no se guardo el Apoderado.", "Atención", 3);
                }
                System.out.println("Click para guardar un apoderado....");
            } else {
                Long idApoderado = this.apoderadoModificar.getIdApoderado();
                Apoderado apoderadoModificado = ProcesosFormularioRegistroApoderado.crearApoderadoDesdeFormulario(this.frmRegistrarApoderadoView);
                apoderadoModificado.setIdApoderado(idApoderado);
                repositorio.modificar(apoderadoModificado);
                JOptionPane.showMessageDialog(null, "Apoderado con ID: " + apoderadoModificado.getIdApoderado() + " \nModificado Correctamente!.", "Atencion", 3);
                ServiciosApoderado.limpiarDatos(frmRegistrarApoderadoView);
            }
            System.out.println("Clicl en el boton para modificar....");
        }
    }

}
