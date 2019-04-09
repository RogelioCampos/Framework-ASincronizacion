package thismother;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import org.jfree.chart.ChartPanel;

public class DibujaHilo extends JFrame implements ActionListener  {
    
    private MiPanel panel;
    private MiTabla tabla;
    private MiGrafica graficas;
    ChartPanel panelGrafica;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenu jMenu3;
    private JMenu jMenu4;
    private JMenuItem Mutex,Semaforo,Monitores,Variables;
    private JMenuItem ProductorConsumidor,Filosofos,Prueba,Barberia,LectoresEscritores,Fumadores;
    private JMenuBar jMenuBar1;
    private JScrollPane scrollPanel;
    private JScrollPane scrollTabla;
    private JScrollPane scrollGrafica;
    private ArrayList<Problema> hilos;
    private int algoritmo=1;    //1:Mutex, 2:Semaforo, 3:Monitores, 4:Variables
    private int problema=1;     //1:Prueba, 2:ProductorConsumidor, 3:Filosofos, 4:Barberia, 5:LectoresEscritores, 6:Fumadores
    private boolean cambio = false;
    
    //Método principal
    
    public DibujaHilo(){
        MisComponentes();
        hilos = new ArrayList<>();
        MiHilo();
    }
    
    //Componentes gráficos
    
    private void MisComponentes(){
        setSize(800,800);
        setLocation(300,10);
        setLayout(null);
        
        panel = new MiPanel();
        scrollPanel = new JScrollPane(panel);
        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPanel.setBounds(0,0,400,300);
        scrollPanel.setAutoscrolls(true);

        
        String headers[]=new String [] {
            "Thread 1", "Thread 2", "Thread 3", "Thread 4"
        };
        tabla = new MiTabla(headers);

        scrollTabla = new JScrollPane(tabla);
        scrollTabla.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollTabla.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollTabla.setBounds(400,0,400,300);
        scrollTabla.setViewportView(tabla);
        
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        setJMenuBar(jMenuBar1);
        
        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Algoritmos");
        jMenuBar1.add(jMenu3);
        Mutex=new JMenuItem("Mutex");
        jMenu3.add(Mutex);
        Mutex.addActionListener(this);
        Semaforo=new JMenuItem("Semaforo");
        jMenu3.add(Semaforo);
        Semaforo.addActionListener(this);
        Monitores=new JMenuItem("Monitores");
        jMenu3.add(Monitores);
        Monitores.addActionListener(this);
        Variables=new JMenuItem("Variables de condicion");
        jMenu3.add(Variables);
        Variables.addActionListener(this);
        
        jMenu4.setText("Problema");
        jMenuBar1.add(jMenu4);
        Prueba=new JMenuItem("Prueba");
        jMenu4.add(Prueba);
        Prueba.addActionListener(this);
        ProductorConsumidor=new JMenuItem("ProductorConsumidor");
        jMenu4.add(ProductorConsumidor);
        ProductorConsumidor.addActionListener(this);
        Filosofos=new JMenuItem("Filosofos");
        jMenu4.add(Filosofos);
        Filosofos.addActionListener(this);
        Barberia=new JMenuItem("Barberia");
        jMenu4.add(Barberia);
        Barberia.addActionListener(this);
        LectoresEscritores=new JMenuItem("LesctoresEscritores");
        jMenu4.add(LectoresEscritores);
        LectoresEscritores.addActionListener(this);
        Fumadores=new JMenuItem("Fumadores");
        jMenu4.add(Fumadores);
        Fumadores.addActionListener(this);
        
        graficas = new MiGrafica("Prueba");
        panelGrafica = graficas.getPanelGrafica();
        scrollGrafica = new JScrollPane(panelGrafica);
        scrollGrafica.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollGrafica.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollGrafica.setBounds(0,300,800,380);
        scrollGrafica.setAutoscrolls(true);
        
        add(scrollPanel);        
        add(scrollTabla);
        add(scrollGrafica);
    }

    
    //Opciones para escoger entre algoritmos
    
    public void actionPerformed(ActionEvent e) {
    	Container f=this.getContentPane();
        if (e.getSource()==Prueba) {
            problema=1;
            cambio = true;
        }
        if (e.getSource()==ProductorConsumidor) {
            problema=2;
            cambio = true;
        }
        if (e.getSource()==Filosofos) {
            problema=3;
            cambio = true;
        }  
        if (e.getSource()==Barberia) {
            problema=4;
            cambio = true;
        } 
        if (e.getSource()==LectoresEscritores) {
            problema=5;
            cambio = true;
        }
        if (e.getSource()==Fumadores) {
            problema=6;
            cambio = true;
        }
        if (e.getSource()==Mutex) {
            algoritmo=1;
        }
        if (e.getSource()==Semaforo) {
            algoritmo=2;
        }
        if (e.getSource()==Monitores) {
            algoritmo=3;
        }
        if (e.getSource()==Variables) {
            algoritmo=4;
        }
        Ejecutar();
    }
    
    public void Ejecutar(){
        switch(problema){
            case 1:
                if(cambio){
                    graficas.clear();
                    graficas.setChart("Prueba");
                    cambio=false;
                }
                MiHilo();
                break;
            case 2:
                if(cambio){
                    graficas.clear();
                    graficas.setChart("Productor - Comsumidor");
                    cambio=false;
                }
                ProductorConsumidor(algoritmo);
                break;
            case 3:
                if(cambio){
                    graficas.clear();
                    graficas.setChart("Cena de los filósofos");
                    cambio=false;
                }
                Filosofos(algoritmo);
                break;
            case 4:
                if(cambio){
                    graficas.clear();
                    graficas.setChart("Barbero dormilón");
                    cambio=false;
                }
                Barberia(algoritmo);
                break;
            case 5:
                if(cambio){
                    graficas.clear();
                    graficas.setChart("Lectores - Escritores");
                    cambio=false;
                }
                LecEsc(algoritmo);
                break;
            case 6:
                if(cambio){
                    graficas.clear();
                    graficas.setChart("Fumadores");
                    cambio=false;
                }
                Fumadores(algoritmo);
                break;
        }
    }
    
    //Metodos que corren silla cada algoritmo
    
    private void MiHilo(){
        detenerHilos();
        
        hilos.clear();
        panel.clear();
        for (int i = 0; i < 4; i++) {
            hilos.add(new MiHIlo(panel,tabla,i));
        }
        for (Problema hilo : hilos) {
            hilo.start();
        }
    }
        
    private void ProductorConsumidor(int algoritmo){
        detenerHilos();
        
        hilos.clear();
        panel.clear();
        String headers[]=new String [] {
            "Productor", "Consumidor"
        };
        tabla.clear(headers);
        RecursoCompartido rc = new RecursoCompartido();
        
        Algoritmo a;
        MiMutex m;
        switch(algoritmo){
            case 1:
                a = new MiMutex();
                break;
            case 2:
                m = new MiMutex();
                a = new MiSemaforo(m);
                break;
            case 3:
                a = new MiMonitor();
                break;
            case 4:
                m = new MiMutex();
                a = new MisVariables(m); 
                break;
            default:
                a = new MiMutex();
        }
        
        Productor p = new Productor(panel,tabla,rc,a,0);
        Consumidor c = new Consumidor(panel,tabla,rc,a,1);
        Errores e = new Errores(tabla,graficas,problema,algoritmo);
        
        hilos.add(p);
        hilos.add(c);
        hilos.add(e);
        
        try{ 
            p.start();
            c.start();
            e.start();
        }catch(IllegalThreadStateException exe){}
    }
    
    private void Filosofos(int algoritmo){
        detenerHilos();
        
        hilos.clear();
        panel.clear();
        String headers[]=new String [] {
            "Pensante 1", "Pensante 2", "Pensante 3", "Pensante 4", "Pensante 5",
        };
        tabla.clear(headers);

        int parametro=5;
        Algoritmo tenedores [];
        MiMutex m [];
        switch(algoritmo){
            case 1:
                tenedores = new MiMutex[parametro];
                for(int i=0; i<5; i++){
                    tenedores[i] = new MiMutex();
                }
                break;
            case 2:
                m = new MiMutex[parametro];
                for(int i=0; i<5; i++){
                    m[i] = new MiMutex();
                }
                tenedores = new MiSemaforo[parametro];
                for(int i=0; i<5; i++){
                    tenedores[i] = new MiSemaforo(m[i]);
                }
                break;
            case 3:
                tenedores = new MiMonitor[parametro];
                for(int i=0; i<5; i++){
                    tenedores[i] = new MiMonitor();
                }
                break;
            case 4:
                m = new MiMutex[parametro];
                for(int i=0; i<5; i++){
                    m[i] = new MiMutex();
                }
                tenedores = new MisVariables[parametro];
                for(int i=0; i<5; i++){
                    tenedores[i] = new MisVariables(m[i]);
                }
                break;
            default:
                tenedores = new MiMutex[parametro];
                for(int i=0; i<5; i++){
                    tenedores[i] = new MiMutex();
                }
        }
        Filosofo pensante1 = new Filosofo(0, panel, tabla, tenedores[0], tenedores[1]);
        Filosofo pensante2 = new Filosofo(1, panel, tabla, tenedores[1], tenedores[2]);
        Filosofo pensante3 = new Filosofo(2, panel, tabla, tenedores[2], tenedores[3]);
        Filosofo pensante4 = new Filosofo(3, panel, tabla, tenedores[3], tenedores[4]);
        Filosofo pensante5 = new Filosofo(4, panel, tabla, tenedores[4], tenedores[0]);
        Errores e = new Errores(tabla,graficas,problema,algoritmo);
        
        hilos.add(pensante1);
        hilos.add(pensante2);
        hilos.add(pensante3);
        hilos.add(pensante4);
        hilos.add(pensante5);
        hilos.add(e);
        
        pensante1.start();
        pensante2.start();
        pensante3.start();
        pensante4.start();
        pensante5.start();
        e.start();
    }
    
    private void Fumadores(int algoritmo){
        detenerHilos();
        
        hilos.clear();
        panel.clear();
        String headers[]=new String [] {
            "Fumadores 1", "Fumadores 2", "Fumadores 3"
        };
        tabla.clear(headers);
        
        int parametro = 3;
        Algoritmo ingredientes [];
        MiMutex m [];
        switch(algoritmo){
            case 1:
                ingredientes = new MiMutex[parametro];
                for(int i=0; i<3; i++){
                    ingredientes[i] = new MiMutex();
                }
                break;
            case 2:
                m = new MiMutex[parametro];
                for(int i=0; i<3; i++){
                    m[i] = new MiMutex();
                }
                ingredientes = new MiSemaforo[parametro];
                for(int i=0; i<3; i++){
                    ingredientes[i] = new MiSemaforo(m[i]);
                }
                break;
            case 3:
                ingredientes = new MiMonitor[parametro];
                for(int i=0; i<3; i++){
                    ingredientes[i] = new MiMonitor();
                }
                break;
            case 4:
                m = new MiMutex[parametro];
                for(int i=0; i<3; i++){
                    m[i] = new MiMutex();
                }
                ingredientes = new MisVariables[parametro];
                for(int i=0; i<3; i++){
                    ingredientes[i] = new MisVariables(m[i]);
                }
                break;
            default:
                ingredientes = new MiMutex[parametro];
                for(int i=0; i<5; i++){
                    ingredientes[i] = new MiMutex();
                }
        }
        Fumador fumador1 = new Fumador(0, panel, tabla, ingredientes[0]);
        Fumador fumador2 = new Fumador(1, panel, tabla, ingredientes[1]);
        Fumador fumador3 = new Fumador(2, panel, tabla, ingredientes[2]);
        Agente agente = new Agente(ingredientes);
        Errores e = new Errores(tabla,graficas,problema,algoritmo);
        
        hilos.add(fumador1);
        hilos.add(fumador2);
        hilos.add(fumador3);
        hilos.add(agente);
        hilos.add(e);
        
        fumador1.start();
        fumador2.start();
        fumador3.start();
        agente.start();
        e.start();
    }

    private void Barberia(int algoritmo){
        detenerHilos();
        
        panel.clear();
        String headers[]=new String [] {
            "Barbero", "Cliente 1", "Cliente 2", "Cliente 3", "Cliente 4", 
        };
        tabla.clear(headers);
        hilos.clear();
        
        Algoritmo silla;
        MiMutex m;
                
        switch(algoritmo){
            case 1:
                silla = new MiMutex();
                break;
            case 2:
                m = new MiMutex();
                silla = new MiSemaforo(m);
                break;
            case 3:
                silla = new MiMonitor();
                break;
            case 4:
                m = new MiMutex();
                silla = new MisVariables(m);
                break;
            default:
                silla = new MiMutex();
        }
	barberia laBarberia = new barberia(silla);
        barbero elBarbero = new barbero(laBarberia, 0, panel, tabla,silla);
        cliente cliente1 = new cliente(laBarberia, 1, panel, tabla,silla);
        cliente cliente2 = new cliente(laBarberia, 2, panel, tabla,silla);
        cliente cliente3 = new cliente(laBarberia, 3, panel, tabla,silla);
        cliente cliente4 = new cliente(laBarberia, 4, panel, tabla,silla);
        Errores e = new Errores(tabla,graficas,problema,algoritmo);
        
        hilos.add(laBarberia);
        hilos.add(elBarbero);
        hilos.add(cliente1);
        hilos.add(cliente2);
        hilos.add(cliente3);
        hilos.add(cliente4);
        hilos.add(e);
        
        laBarberia.start();
        elBarbero.start();
        cliente1.start();
        cliente2.start();
        cliente3.start();
        cliente4.start();
        e.start();
    }
    
    private void LecEsc(int algoritmo){
        detenerHilos();
        
        panel.clear();
        String headers[]=new String [] {
            "Escritor 1", "Escritor 2", "Lector 1", "Lector 2", "Lector 3"
        };
        tabla.clear(headers);
        
      
        Algoritmo a;
        MiMutex m;
                
         switch(algoritmo){
            case 1:
                a = new MiMutex();
                break;
            case 2:
                m = new MiMutex();
                a = new MiSemaforo(m);
                break;
            case 3:
                a = new MiMonitor();
                break;
            case 4:
                m = new MiMutex();
                a = new MisVariables(m);
                break;
            default:
                a = new MiMutex();
        }
        //RecursoCompartido bd = new RecursoCompartido();
        GestorBD gestor = new GestorBD(a);
        Escritor[] esc = new Escritor[2];
        Lector[] lector = new Lector[3];
        
        for(int i = 0; i<esc.length; i++){
            esc[i] = new Escritor(gestor, i, panel, tabla, a);
        }
        for(int i = 0; i<lector.length; i++){
            lector[i] = new Lector(gestor, i+2, panel, tabla);
        }
        Errores e = new Errores(tabla,graficas,problema,algoritmo);
        
        hilos.add(esc[0]);
        hilos.add(esc[1]);
        hilos.add(lector[0]);
        hilos.add(lector[1]);
        hilos.add(lector[2]);
        hilos.add(e);
        
        esc[0].start();
        esc[1].start();
        
        lector[0].start();
        lector[1].start();
        lector[2].start();
        e.start();
    }
    
    public void detenerHilos(){
        try{
            for (Problema hilo : hilos) {
                hilo.detener();
            }
            try{
                for (Problema hilo : hilos) {
                    hilo.interrupt();
                }
            }catch(SecurityException e){
                System.out.println("Error al interrumpir");
            }
        }catch (Exception e){
            System.out.println("Error al detener");
        }
    }
        
    public static void main(String[] args) {
        DibujaHilo fr = new DibujaHilo();
        fr.setTitle("Framework diagramas de hilos");
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
