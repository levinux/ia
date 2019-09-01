package jdijkstraswing.graph;

import java.util.ArrayList;

public class SpanningTree {
    private final ArrayList<Vertice> leafs;
    
    public SpanningTree() {
        leafs = new ArrayList<>();
    }
    
    public SpanningTree(Vertice v) {
        leafs = new ArrayList<>();
        leafs.add(v);
    }
    
    public void addLeaf(Vertice u) {
        leafs.add(u);
    }
    
    public boolean hasLeaf(Vertice u) {
        return leafs.contains(u);
    }
    
    public ArrayList<Vertice> getLeafs() {
        return leafs;
    }
    
    public static SpanningTree union(SpanningTree u, SpanningTree v) {
        SpanningTree w = new SpanningTree();
        for(Vertice s : u.getLeafs()) {
            w.addLeaf(s);
        }
        
        for(Vertice s : v.getLeafs()) {
            w.addLeaf(s);
        }
        
        return w;
    }
}
