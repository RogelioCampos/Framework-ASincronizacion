/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thismother;
import java.awt.*;
import java.util.ArrayList;

public class barbero extends Problema {

        private Algoritmo silla;
        private barberia barberia;
        private int estado = 1;
	
        public barbero(barberia Barberia, int id, MiPanel panel, MiTabla tabla,Algoritmo al) {
            this.barberia = Barberia;
            this.silla=al;
            this.id = id;
            this.panel=panel;
            this.tabla=tabla;
            Y=(id*40)+20;
            estados=new ArrayList<Estado>();
            panel.addEstados(estados);
	}

    protected void leerEstado(){
        switch (estado) {
            case 1:
                actualizaPanel(Color.GREEN);
                actualizaTabla("Usando la silla");
                break;
            case 2:
                actualizaPanel(Color.BLUE);
                actualizaTabla("Cortando");
                break;
        }
    }    


    @Override
    public void run() {
        while (ejecutando) {
            if(silla.getEstado()&&barberia.getEstado()==0){
                estado=1;
                leerEstado();
                try{
                    sleep(500);
                }catch(InterruptedException e){}
            } else {
                estado=2;
                leerEstado();
                try{
                    sleep(500);
                }catch(InterruptedException e){}
            }
        }
    }
    
    @Override
    public int getEstado() {
        return estado;
    }
}
