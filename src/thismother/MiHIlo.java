package thismother;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.geom.*;
import static java.lang.Thread.State.*;

public class MiHIlo extends Problema{
    private MiPanel panel;
    private MiTabla tabla;
    private ArrayList<Estado> estados;
    private String matriz[][];
    private int id, cont=0;
    private int X=0, Y=0;
    
    public MiHIlo(MiPanel panel, MiTabla tabla, int id){
        this.panel=panel;
        this.tabla=tabla;
        this.id=id;
        Y=(id*40)+20;
        matriz=tabla.getMatriz();
        estados=new ArrayList<Estado>();
        panel.addEstados(estados);
    }
    
    public void run(){
        while(ejecutando){
            Random rand = new Random();
            int n = rand.nextInt(3);
            switch (n) {
                case 0:
                    estados.add(new Estado(new Rectangle2D.Double(X,Y,60,20),Color.RED));
                    tabla.actualizaTabla("estado rojo",cont,id);
                    break;
                case 1:
                    estados.add(new Estado(new Rectangle2D.Double(X,Y,60,20),Color.BLUE));
                    tabla.actualizaTabla("estado azul",cont,id);
                    break;
                case 2:
                    estados.add(new Estado(new Rectangle2D.Double(X,Y,60,20),Color.GREEN));
                    tabla.actualizaTabla("estado verde",cont,id);
                    break;
            }
            panel.setEstados(estados,id);
            panel.repaint();
            panel.setPreferredSize(new Dimension(450+X,500));
            X+=65;
            cont++;
            tabla.repaint();
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                System.err.println("");
            }
        }
    }


    @Override
    public int getEstado() {
        return 0;
    }
}
