package thismother;
import java.awt.*;
import java.util.ArrayList;

public class Escritor extends Problema{
    private GestorBD gestor;
    private final int id;
    private Algoritmo al;
    private int estado = 1;
    
    public Escritor(GestorBD gestor, int id, MiPanel panel, MiTabla tabla, Algoritmo al){
        this.gestor = gestor;
        this.id = id;
        this.panel=panel;
        this.tabla=tabla;
        Y=(id*40)+20;
        estados=new ArrayList<Estado>();
        panel.addEstados(estados);
        this.al=al;
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