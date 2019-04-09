package thismother;

public class MiMutex extends Algoritmo{

    boolean hayIngredientes =false;
    int ingred1=0, ingred2=0;
    boolean bandera2;

    
    public void Lock(){
        if(bandera==false){
            while (bandera){    
                try{
                    wait();
                }catch(InterruptedException e){}
            }
        }
        bandera = true;
    }
    
    public void Unlock(){
            if(bandera==true){
                while(!bandera){
                //bandera = false;
                notify();
                }
            }
            bandera = false;
    }
    
}

