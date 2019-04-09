package thismother;
import java.awt.*;
import java.util.ArrayList;

public class Consumidor extends Problema {
    private RecursoCompartido rc;
    private Algoritmo a;
    private int estado=1;
    
    public Consumidor(MiPanel panel, MiTabla tabla,RecursoCompartido rc, Algoritmo a, int id){
        this.panel=panel;
        this.tabla=tabla;
        this.rc=rc;
        this.a=a;
        this.id=id;
        this.Y=(id*40)+20;
        estados=new ArrayList<Estado>();
        panel.addEstados(estados);
    }
     
    @Override
    public void run(){
        while(ejecutando){
            try{
                a.Lock();}
                catch(Exception e1){a.Lock();}
            estado=2;
            rc.setRc((rc.getRc()+1));
            actualizaPanel(Color.RED);
            actualizaTabla("Bloqueado");
            //a.Unlock();
            try{
                a.Unlock();}
                catch(Exception e1){a.Unlock();}
            estado=1;
            actualizaPanel(Color.BLUE);
            actualizaTabla("Consumiendo");
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){

            }
        }
        estados.clear();
    }

    public int getEstado(){
        return estado;
    }  
}
