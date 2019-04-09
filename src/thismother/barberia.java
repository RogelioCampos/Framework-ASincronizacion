package thismother;

public class barberia extends Problema{

    private Algoritmo silla;
    private int listaEspera;

    public barberia(Algoritmo silla) {
        this.silla = silla;
        this.listaEspera = 0;
    }

    @Override
    public void run() {
        silla.Unlock();
        while(ejecutando){
            if(listaEspera>0){
                silla.Unlock();
                try{
                    sleep(500);
                }catch(InterruptedException e){}
            } else {
                silla.Lock();
                try{
                    sleep(500);
                }catch(InterruptedException e){}
            }
        }
    }
    
    public void aumentaLista(){
        listaEspera++;
    }
    
    public void disminuyeLista(){
        listaEspera--;
    }

    @Override
    public int getEstado() {
        return listaEspera;
    }
}

