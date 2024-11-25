package com.controlador;

import com.Modelo.entidades.Docente;
import com.procesos.ProcesosFormularioListadoDocentes;
import com.vista.frmListadoDocentesView;
import com.vista.frmMenuView;
import com.vista.frmRegistrarDocenteView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorFormularioListadoDocentes
        implements ActionListener {
    
    private final frmListadoDocentesView frmDocentesView;
    private final frmMenuView frmMenuView;
    
    public ControladorFormularioListadoDocentes(frmListadoDocentesView lfrmistadoDocentesView, frmMenuView frmMenuView) {
        this.frmDocentesView = lfrmistadoDocentesView;
        this.frmMenuView = frmMenuView;
        this.frmDocentesView.btnBuscar.addActionListener(this);
        this.frmDocentesView.btnModificar.addActionListener(this);
        ProcesosFormularioListadoDocentes.presentarFormulario(this.frmMenuView.dsktEscritorio, this.frmDocentesView);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //clik en el boton buscar
        if (e.getSource() == this.frmDocentesView.btnBuscar) {
            ProcesosFormularioListadoDocentes.mostarSoloDocente(frmDocentesView, frmDocentesView.txtBuscar.getText());
        }
        //click en el boton modificar
        if (e.getSource() == this.frmDocentesView.btnModificar) {
            int filaSelecionada = frmDocentesView.btlData.getSelectedRow();
            if (filaSelecionada >= 0) {
                //creamos el objeto de tipo docente 
                Docente docente = ProcesosFormularioListadoDocentes.obtenerDocente(Long.valueOf(frmDocentesView.btlData.getValueAt(filaSelecionada, 6).toString()));
                frmRegistrarDocenteView frmDocenteView = new frmRegistrarDocenteView(docente);
                this.frmDocentesView.dispose();
                ControladorFormularioRegistroDocente cfrd = new ControladorFormularioRegistroDocente(frmDocenteView, this.frmMenuView, docente);
            } else {
                JOptionPane.showMessageDialog(null, "Por favor selecione una fila para poder modificar.", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
}
