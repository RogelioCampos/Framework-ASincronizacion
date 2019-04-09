package thismother;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class cliente extends Problema {
    private Algoritmo silla;
    private int estado = 1;
    private barberia barberia;
    private Random r = new Random();

    public cliente(barberia Barberia, int clienteId,MiPanel panel, MiTabla tabla,Algoritmo al) {
        this.barberia = Barberia;
        this.id = clienteId;
        this.silla=al;
        this.panel=panel;
        this.tabla=tabla;
        Y=(clienteId*40)+20;
        estados=new ArrayList<Estado>();
        panel.addEstados(estados);
    }

    protected void leerEstado(){
        switch (estado) {
            case 1:
                actualizaPanel(Color.RED);
                actualizaTabla("Formado");
                break;
            case 2:
                actualizaPanel(Color.GREEN);
                actualizaTabla("Usando la silla");
                break;
            case 3:
                actualizaPanel(Color.YELLOW);
                actualizaTabla("Fuera");
                break;
        }
    }    


    @Override
    public void run() {
        while (ejecutando) {
            estado=3;
            for (int i = 0; i < r.nextInt(4)+1; i++) {
                leerEstado();
                try{
                    sleep(500);
                }catch(InterruptedException e){}
            }
            estado=1;
            barberia.aumentaLista();
            while(silla.getEstado()){
                leerEstado();
                try{
                    sleep(500);
                }catch(InterruptedException e){}
            }
            silla.Lock();
            estado=2;
            leerEstado();
            barberia.disminuyeLista();
            try{
                sleep(500);
            }catch(InterruptedException e){}
        }
    }
        
    @Override
    public int getEstado() {
        return 0;
    }
}
