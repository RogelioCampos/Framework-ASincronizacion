package thismother;

public class MisVariables extends Algoritmo{
    
    private MiMutex m;
    
    public MisVariables(MiMutex m){
        this.m=m;
    }

    @Override
    public  void Lock() {
        synchronized(this){
        try{
            m.Unlock();
            wait();
        }catch(InterruptedException e){
        }finally{
           m.Lock();
        }}
    }

    @Override
    public void Unlock() {
       synchronized(this){ notify();}
    }
}
