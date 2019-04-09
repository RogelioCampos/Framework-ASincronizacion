package thismother;
import  java.util.*;

public class Agente extends Problema{
    int i;   //variables donde guardarémos los numeros generados aleatoriamente
    Algoritmo [] mesa; //creamos un objeto de tipo MiMutex
    Random r;   //declaramos una variable para generar valores aleatorios

    public Agente (Algoritmo [] mesa) {  //Inicializamos las varibles en el constructor
        this.mesa = mesa;
        r = new Random();
    }

    public void run () {
        while(ejecutando){
            i = r.nextInt (3);
            mesa[i].Unlock();              //Usamos el mutex haciendo uso del método poner.
            try{
                sleep(500);
            }catch(InterruptedException e){}
        }
    }

    @Override
    public int getEstado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
