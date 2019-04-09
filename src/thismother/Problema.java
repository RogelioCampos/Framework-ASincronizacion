package thismother;

import java.awt.*;
import java.util.*;
import java.awt.geom.*;

public abstract class Problema extends Thread{
    protected ArrayList<Estado> estados;
    protected MiPanel panel;
    protected MiTabla tabla;
    protected int id;
    protected int X=0, Y=0;
    protected boolean ejecutando=true;
    
    @Override
    public abstract void run();
    
    public abstract int getEstado();
    
    public void actualizaPanel(Color color){
        estados.add(new Estado(new Rectangle2D.Double(X,Y,60,20),color));
        panel.setEstados(estados, id);
        panel.repaint();
        panel.setPreferredSize(new Dimension(450+X,500));
        X+=65;
    }
    
    public void actualizaTabla(String estado){
        tabla.actualizaTabla(estado,estados.size()-1,id);
        tabla.repaint();
    }
    
    public void agregaEstado(Color color, String estado) {
        estados.add(new Estado(new Rectangle2D.Double(X,Y,60,20),color));
        X+=65;
    }
    
    public void detener(){
        ejecutando=false;
    }
    
    public ArrayList<Estado> getEstados(){
        return estados;
    }

}
