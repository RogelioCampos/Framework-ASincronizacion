package thismother;

public abstract class Algoritmo {
    protected boolean bandera;
    
    public abstract void Lock();
    public abstract void Unlock();

    
    public boolean getEstado(){
        return bandera;
    }
    
    public void setEstado(boolean a){
        bandera=a;
    }
}
