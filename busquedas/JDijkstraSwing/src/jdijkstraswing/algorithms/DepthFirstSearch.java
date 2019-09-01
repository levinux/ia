package jdijkstraswing.algorithms;

import java.util.ArrayList;
import javax.swing.table.TableModel;
import jdijkstraswing.Const;
import jdijkstraswing.graph.Color;
import jdijkstraswing.graph.Graph;
import jdijkstraswing.graph.Vertice;

public class DepthFirstSearch implements Runnable {
    private final Graph G;
    private final Thread hilo;
    private final TableModel t;
    
    private int time;
    
    public DepthFirstSearch(TableModel t, Graph G) {
        this.t = t;
        this.G = G;
        time = 0;
        
        hilo = new Thread(this);
    }
    
    public void doDfs() {
        hilo.start();
    }
    
    private void dfs_visit(Vertice u) {
        time++;
        u.setD(time);
        u.setColor(Color.GRAY);
        Const.sleep();
        
        // Not enough approach
        // Because closed (confined) vertices still gets painted
        ArrayList<Vertice> adj = G.getAdjVertices(u);
        if(adj.isEmpty()) t.setValueAt(Const.TILE, u.getX(), u.getY());
        else t.setValueAt(Const.VISITED, u.getX(), u.getY());
        
        for(Vertice v: adj) {
            t.setValueAt(Const.VISITED, u.getX(), u.getY());
            if(v.getColor() == Color.WHITE) {
                v.setFather(u);
                dfs_visit(v);
            }
        }
        
        u.setColor(Color.BLACK);
        time++;
        u.setF(time);
    }

    @Override
    public void run() {
        for(Vertice u : G.V()) {
            u.setColor(Color.WHITE);
            u.setFather(null);
        }
        
        time = 0;
        for(Vertice v : G.V()) {
            if(v.getColor() == Color.WHITE)
                dfs_visit(v);
        }
    }
}
