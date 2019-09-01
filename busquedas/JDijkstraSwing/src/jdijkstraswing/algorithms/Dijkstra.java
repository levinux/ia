package jdijkstraswing.algorithms;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;
import javax.swing.table.TableModel;
import jdijkstraswing.Const;
import jdijkstraswing.graph.Edge;
import jdijkstraswing.graph.Graph;
import jdijkstraswing.graph.Vertice;

public class Dijkstra implements Runnable {
    private final Graph G;
    private final Vertice s;
    private final Thread hilo;
    private final TableModel t;
    
    public Dijkstra(TableModel t, Graph g, Vertice s) {
        this.G = g;
        this.s = s;
        this.t = t;
        
        hilo = new Thread(this);
    }
    
    public void doDijkstra() {
        Random rnd = new Random();
        for(Edge e: G.E()) {
            e.setWeight(rnd.nextInt(Const.RND_MAX));
            /*System.out.println("Arista de " + e.getOrig().getKey() 
                    + " -> " + e.getDest().getKey() + " y un peso " + e.getWeight());*/
        }
        
        hilo.start();
    }
    
    private void InitializeSingleSource() {
        for(Vertice v : G.V()) {
            v.setD(Integer.MAX_VALUE);
            v.setFather(null);
        }
        
        s.setD(0);
    }
    
    private void Relax(Vertice u, Vertice v) {
        if(v.getD() > (u.getD() + weight(u, v))) {
            v.setD(u.getD() + weight(u, v));
            v.setFather(u);
            t.setValueAt(Const.VISITED, v.getX(), v.getY());
        }
    }
    
    private int weight(Vertice u, Vertice v) {
        return G.getEdge(u, v).getWeight();
    }
    
    @Override
    public void run() {
        InitializeSingleSource();
        ArrayList<Vertice> S = new ArrayList<>();
        PriorityQueue<Vertice> Q = new PriorityQueue<>(G.V());
        
        while(!Q.isEmpty()) {
            Vertice u = Q.poll();
            S.add(u);
            
            for(Vertice v : G.getAdjVertices(u)) {
                Relax(u, v);
            }
        }
    }
}
