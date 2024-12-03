package com.Utelerias.Constantes;

import java.util.List;
import javax.swing.JTable;

abstract public class Utelerias<T> {

    abstract public void establecerAnchoColumnasTabla(JTable tblTabla, int[] anchoColumnas);

    abstract public void mostrarRegistrosEnTabla(JTable tblData, String[] nombreColumnas, List<T> listaObjetos);

    abstract public void mostrarRegistroSoloTabla(JTable tblData, String[] nombreColumnas, T object);

}
