package thismother;

public class GestorBD {
private int nLectores= 0;               //si le mueves a 1 ya sirven los lectores
private boolean hayEscritor = false;
private int nEscritor = 0;              //ese truco no funciona aquí
private Algoritmo m;

public GestorBD(Algoritmo m){                      //no se porque crea este constructor, Auli me dijo
    this.m = m;             //pero almenos no truena
}

//public synchronized void openE(int id) throws InterruptedException{
public void openE(int id){
    while(hayEscritor||nLectores>0){ //mientras no haya un lector (no me hace sentido lo del nLectores)   
            //wait();
            try{m.Lock();}catch(Exception e1){m.Lock();}                //uso el recurso
        }
        hayEscritor = true;         //un escritor esta
        System.out.print("Escritor "+ id + " entra a BD \n");

    }

//public synchronized void closeE(int id) throws InterruptedException{
public void closeE(int id){
    System.out.print("Escritor "+ id + " sale de la BD \n");
        hayEscritor = false;        //escritor ya no esta
        //notifyAll();
        m.Unlock();                 //deja el recurso
    }

//public synchronized void openL(int id) throws InterruptedException{
public void openL(int id){
    while(hayEscritor){             //mientras no este un escritor
            //wait();
            try{m.Lock();}catch(Exception e1){m.Lock();}               //usa recurso
        }
            nLectores++;            //llego un nuevo lector
        System.out.print("Lector "+ id + " entra a BD \n");
    }
   

//public synchronized void closeL(int id) throws InterruptedException{
public void closeL(int id){
    System.out.print("Lector "+ id + " sale de BD \n");
        nLectores--;                //se fue un viejo lector
        if(nLectores==0)            //si ya no hay lectores 
            //notify();
            m.Unlock();             //dejo el recurso
    }
}
