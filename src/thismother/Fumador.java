package thismother;

import java.awt.Color;
import java.util.ArrayList;

public class Fumador extends Problema{
   
    Algoritmo al;
    private int estado = 1;

    public Fumador (int i, MiPanel panel, MiTabla tabla, Algoritmo mesa){
        this.id=i;                             //Inicializamos las variables en el constructor.
        this.al = mesa;
        this.panel = panel;
        this.tabla = tabla;
        this.Y = (i*40)+20;
        estados = new ArrayList<Estado>();
        this.panel.addEstados(estados);
    }
    
    protected void leerEstado(){
        switch (estado) {
            case 1:
                actualizaPanel(Color.RED);
                actualizaTabla("Esperando");
                break;
            case 2:
                actualizaPanel(Color.BLUE);
                actualizaTabla("Fumando");
                break;
        }
    }

    public void run (){
        while(ejecutando){
            while(!al.getEstado()){
                al.Lock(); 
                estado=2;
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
    public int getEstado() {
        return estado;
    }
}
