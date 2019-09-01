package jdijkstraswing.algorithms;

import java.util.LinkedList;
import javax.swing.table.TableModel;
import jdijkstraswing.Const;
import jdijkstraswing.graph.Color;
import jdijkstraswing.graph.Graph;
import jdijkstraswing.graph.Vertice;

public class BreadthFirstSearch implements Runnable {
    private final Graph G;
    private final Vertice s;
    private final Thread hilo;
    private final TableModel t;
    
    public BreadthFirstSearch(TableModel t, Graph G, Vertice s) {
        this.G = G;
        this.s = s;
        this.t = t;
        
        hilo = new Thread(this);
    }
    
    public void doBfs() {
        hilo.start();
    }

    @Override
    public void run() {
        for(Vertice v : G.V()) {
            v.setColor(Color.WHITE);
            v.setD(Integer.MAX_VALUE);
            v.setFather(null);
        }
        
        s.setColor(Color.GRAY);
        s.setD(0);
        s.setFather(null);
        t.setValueAt(Const.VISITED, s.getX(), s.getY());
        
        LinkedList<Vertice> Q = new LinkedList<>();
        Q.add(s);
        
        while(!Q.isEmpty()) {
            Vertice u = Q.poll();
            for(Vertice v : G.getAdjVertices(u)) {
                if(v.getColor() == Color.WHITE) {
                    v.setColor(Color.GRAY);
                    v.setD(u.getD() + 1);
                    v.setFather(u);
                    Q.add(v);
                    t.setValueAt(Const.VISITED, v.getX(), v.getY());
                    Const.sleep();
                }
            }
            
            u.setColor(Color.BLACK);
        }
    }
}
