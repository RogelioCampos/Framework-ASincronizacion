
package thismother;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;

public class MiPanel extends JPanel {
    private ArrayList<ArrayList<Estado>> estadost;
    
    MiPanel(){
        estadost = new ArrayList<ArrayList<Estado>>();
        setBackground(Color.WHITE);
        setBounds(0,0,500,500);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        for (ArrayList<Estado> lestados : estadost) {
            for (Estado estado : lestados) {
                g2.setColor(estado.getColor());
                g2.fill(estado.getForma());
            }
        }
    }
    
    public void addEstados(ArrayList<Estado> estados){
        estadost.add(estados);
   }

    public void setEstados(ArrayList<Estado> estados, int n) {
        this.estadost.set(n, estados);
    }
    
    public void setEstadosT(ArrayList<ArrayList<Estado>> estadosT) {
        this.estadost=estadosT;
    }

    public ArrayList<Estado> getEstados(int n) {
        return estadost.get(n);
    }
    
    public void clear(){
        estadost.clear();
    }
}
