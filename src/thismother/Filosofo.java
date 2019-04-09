package thismother;

import java.awt.*;
import java.util.*;

public class Filosofo extends Problema{
    private int estado=1;
    private Algoritmo a1,a2;
   
    public Filosofo (int x, MiPanel panel, MiTabla tabla, Algoritmo A1, Algoritmo A2){
        this.id = x;
        this.a1 = A1;
        this.a2 = A2;
        this.panel = panel;
        this.tabla = tabla;
        this.Y = (x*40)+20;
        estados = new ArrayList<Estado>();
        this.panel.addEstados(estados);
    }
    
    protected void leerEstado(){
        switch (estado) {
            case 1:
                actualizaPanel(Color.RED);
                actualizaTabla("Hambriento");
                break;
            case 2:
                actualizaPanel(Color.BLUE);
                actualizaTabla("Comiendo");
                break;
            case 3:
                actualizaPanel(Color.GREEN);
                actualizaTabla("Pensando");
                break;
        }
    }

    @Override
    public void run(){
        while(ejecutando){
            if(!(a1.getEstado())&&!(a2.getEstado())){
                try{
                a1.Lock();                
                a2.Lock();}catch(Exception e1){
                a1.Lock();                
                a2.Lock();}
                estado=2;
                leerEstado();
                try{
                    sleep(500);
                }catch(InterruptedException e){}
                a1.Unlock();
                a2.Unlock();
                estado=3;
                leerEstado();
                try{
                    sleep(500);
                }catch(InterruptedException e){}
            }
            estado=1;
            leerEstado();
            try{
                sleep(500);
            }catch(InterruptedException e){}
        }
    }
       
    @Override
    public int getEstado(){
        return estado;
    }  

}