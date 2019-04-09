package thismother;

import java.awt.BasicStroke;
import java.awt.Color;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class MiGrafica{
    ChartPanel panelGrafica;
    JFreeChart grafica;
    private XYSeries mutex = new XYSeries("Mutex");
    private XYSeries semaforos = new XYSeries("Semaforos");
    private XYSeries monitores = new XYSeries("Monitores");
    private XYSeries variables = new XYSeries("Variables de Condición");
    private XYSeriesCollection dataset = new XYSeriesCollection();
    private String nombre;
    
    public MiGrafica(String nombre) {
        this.nombre = nombre;
        repaint();
    }
    
    public void repaint() {
        clear();
        dataset.addSeries(mutex);
        dataset.addSeries(semaforos);
        dataset.addSeries(monitores);
        dataset.addSeries(variables);
        grafica = ChartFactory.createXYLineChart(nombre, "Tiempo", "Errores", dataset, PlotOrientation.VERTICAL, true, true, false);
        XYPlot plot = grafica.getXYPlot();
        XYLineAndShapeRenderer renderizador = new XYLineAndShapeRenderer();
        renderizador.setSeriesPaint(0, Color.BLUE);
        renderizador.setSeriesPaint(1, Color.GREEN);
        renderizador.setSeriesPaint(2, Color.RED);
        renderizador.setSeriesStroke(0, new BasicStroke(4.0f));
        renderizador.setSeriesStroke(1, new BasicStroke(3.0f));
        renderizador.setSeriesStroke(2, new BasicStroke(2.0f));
        plot.setRenderer(renderizador);
        
        panelGrafica = new ChartPanel(grafica);
    }
    
    public void setChart(String nombre){
        grafica.setTitle(nombre);
        panelGrafica.setChart(grafica);
    }

    public void addValue(int algoritmo, double tiempo){
        switch(algoritmo){
            case 1:
                mutex.add(tiempo, mutex.getItemCount());
                break;
            case 2:
                semaforos.add(tiempo, semaforos.getItemCount());
                break;
            case 3:
                monitores.add(tiempo, monitores.getItemCount());
                break;    
            case 4:
                variables.add(tiempo, variables.getItemCount());
                break;    
        }
    }
    
    public void clear(){
        mutex.clear();
        mutex.add(0.0,0.0);
        semaforos.clear();
        semaforos.add(0.0,0.0);
        monitores.clear();
        monitores.add(0.0,0.0);
        variables.clear();
        variables.add(0.0,0.0);
    }
    
    public ChartPanel getPanelGrafica(){
        return panelGrafica;
    }
}
