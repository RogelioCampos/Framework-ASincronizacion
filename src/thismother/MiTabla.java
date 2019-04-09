package thismother;

import javax.swing.*;
import javax.swing.table.*;

public class MiTabla extends JTable{
    DefaultTableModel model;
    String matriz[][];
    String headers[];

    public MiTabla(String[] heads) {
        headers=heads;
        matriz=new String [1][heads.length];
        model=new DefaultTableModel(matriz, headers);
        super.setModel(model);
        setRowHeight(30);
    }

    public String[][] getMatriz() {
        return matriz;
    }
    
    public Object getValor(int fila, int columna) {
        return model.getValueAt(fila, columna);
    }

    public void actualizaTabla(String dato, int cont, int id){
        model.setValueAt(dato, cont, id);
        model.setRowCount(cont+5);
        this.repaint();
    }

    public void clear(String[] heads){
        headers=heads;
        matriz=new String [1][headers.length];
        model=new DefaultTableModel(matriz, headers);
        super.setModel(model);
        setRowHeight(30);
    }
}
