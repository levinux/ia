package jdijkstraswing.graph;

import java.util.List;
import java.util.ArrayList;

public class Graph {
    private int V;
    private int E;
    private boolean directed;
    private final ArrayList<Edge> edges;
    private final ArrayList<Vertice> vertices;
    
    public Graph(boolean directed) {
        V = 0;
        E = 0;
        this.directed = directed;
        edges = new ArrayList<>();
        vertices = new ArrayList<>();
    }
    
    public void addVertice(Vertice v) {
        if(v == null)
            throw new UnsupportedOperationException("El vertice v es nulo!");
        
        if(!vertices.contains(v)) {
            vertices.add(v);
            V++;
        }
    }
    
    public void addEdge(Vertice orig, Vertice dest) {
        addEdge(orig, dest, 0);
    }
    
    public void addEdge(Vertice orig, Vertice dest, int weight) {
        if(orig == null || dest == null)
            throw new UnsupportedOperationException("Uno de los vertices es nulo!");
        
        if(!vertices.contains(orig))
            this.addVertice(orig);
        if(!vertices.contains(dest))
            this.addVertice(dest);
        
        edges.add(new Edge(orig, dest, weight));
        E++;
    }
    
    public ArrayList<Vertice> getAdjVertices(Vertice u) {
        ArrayList<Vertice> adj = new ArrayList<>();
        
        for(Edge e : edges)
            if(e.getOrig() == u)
                adj.add(e.getDest());
        
        return adj;
    }
    
    public Edge getEdge(Vertice orig, Vertice dest) {
        for(Edge e: edges) {
            if(e.getOrig() == orig && e.getDest() == dest) {
                return e;
            }
            
            if(directed)
                if(e.getOrig() == dest && e.getDest() == orig) {
                    return new Edge(dest, orig);
                }
        }
        
        return null;
    }
    
    public void setWeight(Vertice orig, Vertice dest, int weight) {
        getEdge(orig, dest).setWeight(weight);
    }
    
    public int numV() {
        return V;
    }
    
    public int numE() {
        return E;
    }
    
    public List<Vertice> V() {
        return vertices;
    }
    
    public List<Edge> E() {
        return edges;
    }
    
    public void setDirected(boolean directed) {
        System.out.println("Grafo direccionado? " + Boolean.toString(directed));
        this.directed = directed;
    }
}
