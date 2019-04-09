package thismother;

public class MiMonitor extends Algoritmo{
    
    private int valor;
    private MiMutex m;
    

    @Override
    public synchronized void Lock() {
        if(!bandera){
            while (bandera){    
                try{
                    wait();
                }catch(InterruptedException e){}
            }
        }
        bandera = true;
    }

    @Override
    public synchronized void Unlock() {
        
            if(bandera){
                while(!bandera){
                    notify();
                }
            }
            bandera = false;
    }
    /*@Override
    public synchronized void Lock() {
        if(bandera==false){
            try{
                wait();
            }catch(InterruptedException e){}
        }
        notify();
        bandera = false;
    }

    @Override
    public synchronized void Unlock() {
        if(bandera==true){
            try{
                wait();
            }catch(InterruptedException e){}
        }
        notify();
        bandera=true;
    }*/
    
    /*
        public void Lock() {
        synchronized(this) {
        if(bandera==false){
            try{
                wait();
            }catch(InterruptedException e){}
        }
        notify();
        bandera = false;}
    }

    @Override
    public void Unlock() {
        synchronized(this) {
        if(bandera==true){
            try{
                wait();
            }catch(InterruptedException e){}
        }
        notify();
        bandera=true;}
    } */
    
}
