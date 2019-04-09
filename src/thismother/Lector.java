package thismother;

import java.awt.*;
import java.awt.geom.*;
import java.util.*;

public class Lector extends Problema{
    private GestorBD gestor;
    private int cont=0;
    private int estado = 1;
    
    public Lector(GestorBD gestor, int id, MiPanel panel, MiTabla tabla){
        this.gestor = gestor;
        this.id = id;
        Y=(id*40)+20;
        estados=new ArrayList<Estado>();
        panel.addEstados(estados);
    }
    
    protected void leerEstado(){
        switch (estado) {
            case 1:
                actualizaPanel(Color.RED);
                actualizaTabla("Esperando");
                break;
            case 2:
                actualizaPanel(Color.GREEN);
                actualizaTabla("Leyendo");
                break;
        }
    }
    
    public void run(){
        while(ejecutando){
            
        }
    }


    @Override
    public int getEstado() {
        return 0;
    }
}