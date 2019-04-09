package thismother;

import org.jfree.chart.ChartPanel;

public class Errores extends Problema{
    private MiGrafica graficas;
    private String matriz[][];
    private int problema;
    private int algoritmo;
    private int cont = 0;

    public Errores(MiTabla tabla, MiGrafica graficas, int problema, int algoritmo) {
        this.tabla = tabla;
        this.graficas = graficas;
        this.problema = problema;
        this.algoritmo = algoritmo;
    }
    
    @Override
    public void run() {
        try{
            sleep(500);
        }catch(InterruptedException e){}
        while (ejecutando) {            
            boolean error;
            switch(problema){
                case 2:
                    error = ProductorConsumidor();
                    break;
                case 3:
                    error = Filosofos();
                    break;
                case 4:
                    error = Barberia();
                    break;
                case 5:
                    error = LecEsc();
                    break;
                case 6:
                    error = Fumadores();
                    break;
                default:
                    error = false;
            }
            if(error){
                graficas.addValue(algoritmo, cont*0.5);
            } else {
                System.out.println("No hay error "+cont);
            }
            cont++;
            try{
                sleep(500);
            }catch(InterruptedException e){}
        }
    }
    
    public boolean ProductorConsumidor(){
        boolean band=false;
        if((tabla.getValor(cont, 0).equals("Produciendo")&&tabla.getValor(cont, 1).equals("Consumiendo"))||tabla.getValor(cont, 0).equals(tabla.getValor(cont, 1)))
            band = true;
        return band;
    }
    
    public boolean Filosofos(){
        boolean band=false;
        String w = "Comiendo";
        if(w.equals(tabla.getValor(cont, 0))&&w.equals(tabla.getValor(cont, 1)))
            band = true;
        else if(w.equals(tabla.getValor(cont, 1))&&w.equals(tabla.getValor(cont, 2)))
            band = true;
        else if(w.equals(tabla.getValor(cont, 2))&&w.equals(tabla.getValor(cont, 3)))
            band = true;
        else if(w.equals(tabla.getValor(cont, 3))&&w.equals(tabla.getValor(cont, 4)))
            band = true;
        else if(w.equals(tabla.getValor(cont, 4))&&w.equals(tabla.getValor(cont, 0)))
            band = true;
        return band;
    }
    
    public boolean Barberia(){
        boolean band=false;
        String w = "Usando la silla";
        int c = 0;
        if(w.equals(tabla.getValor(cont, 0)))
            c++;
        if(w.equals(tabla.getValor(cont, 1)))
            c++;
        if(w.equals(tabla.getValor(cont, 2)))
            c++;
        if(w.equals(tabla.getValor(cont, 3)))
            c++;
        if(w.equals(tabla.getValor(cont, 4)))
            c++;
        if(c>1)
            band = true;
        return band;
    }
    
    public boolean LecEsc(){
        return false;
    }
    
    public boolean Fumadores(){
        boolean band=false;
        String w = "Fumando";
        int c = 0;
        if(w.equals(tabla.getValor(cont, 0)))
            c++;
        if(w.equals(tabla.getValor(cont, 1)))
            c++;
        if(w.equals(tabla.getValor(cont, 2)))
            c++;
        if(c>1)
            band = true;
        return band;
    }

    @Override
    public int getEstado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
