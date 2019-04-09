package thismother;

public class MiSemaforo extends Algoritmo{
    
    public int valor;
    private MiMutex m;
    public int esperando = 0;
    
    public MiSemaforo(MiMutex m){
        this.m = m;
        valor = 1;
    }

    @Override
    public void Lock() {
        try{m.Lock();}catch(Exception e1){m.Lock();}
        if(valor==0){
            m.Unlock();
            System.out.println("Esperando");
        }
        while(valor<=0){
            try{m.Lock();}catch(Exception e1){m.Lock();}
        }
        valor--;
        m.Unlock();
    }

    @Override
    public void Unlock() {
        try{m.Lock();}catch(Exception e1){m.Lock();}
        valor++;
        m.Unlock();
    }
    
    @Override
    public boolean getEstado(){
        return valor==0;
    }
}