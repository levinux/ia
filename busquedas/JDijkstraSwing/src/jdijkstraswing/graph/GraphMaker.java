package jdijkstraswing.graph;

import jdijkstraswing.Const;

public class GraphMaker {
    private static int N;
    
    public static Graph doIt(Object[][] data, boolean directed) {
        int k = 0;
        N = data.length;
        Graph g = new Graph(directed);
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                String tile = (String) data[i][j];
                if(tile.equals(Const.TILE)) {
                    Vertice<String> v = newVertice(g, Integer.toString(k));
                    v.setXY(i, j);
                    
                    String left = hasLeft(data, i, j, k);
                    String right = hasRight(data, i, j, k);
                    String up = hasUp(data, i, j, k);
                    String down = hasDown(data, i, j, k);
                    
                    if(left != null)  addEdge(g, v, newVertice(g, left));
                    if(right != null) addEdge(g, v, newVertice(g, right));
                    if(up != null)    addEdge(g, v, newVertice(g, up));
                    if(down != null)  addEdge(g, v, newVertice(g, down));
                }
                
                k++;
            }
        }
        
        System.out.println("El grafo tiene " + g.numV() + " vertices");
        for(Vertice v : g.V()) {
            System.out.print(v.getKey() + " tiene " + g.getAdjVertices(v).size() + " vecinos\n");
        }
        
        System.out.println();
        return g;
    }
    
    private static void addEdge(Graph g, Vertice u, Vertice v) {
        Edge e = g.getEdge(u, v);
        if(e == null) g.addEdge(u, v);
    }
    
    private static Vertice<String> newVertice(Graph g, String tile) {
        for(Vertice v : g.V()) {
            if(v.getKey().equals(tile)) {
                return v;
            }
        }
        
        Vertice<String> v = new Vertice<>(tile);
        g.addVertice(v);
        return v;
    }
    
    private static String hasLeft(Object[][] data, int x, int y, int k) {
        int ny = y - 1;
        int nk = k - 1;
        
        if(ny < 0 || (k % N) == 0) return null;
        String tile = (String) data[x][ny];
        
        if(tile.equals(Const.BLOCK)) return null;
        return Integer.toString(nk);
    }
    
    private static String hasRight(Object[][] data, int x, int y, int k) {
        int ny = y + 1;
        int nk = k + 1;
        
        if(ny >= N || ((k + 1) % N) == 0) return null;
        String tile = (String) data[x][ny];
        
        if(tile.equals(Const.BLOCK)) return null;
        return Integer.toString(nk);
    }
    
    private static String hasUp(Object[][] data, int x, int y, int k) {
        int nx = x - 1;
        int nk = k - N;
        
        if(nx < 0 || nk < 0) return null;
        String tile = (String) data[nx][y];
        
        if(tile.equals(Const.BLOCK)) return null;
        return Integer.toString(nk);
    }
    
    private static String hasDown(Object[][] data, int x, int y, int k) {
        int nx = x + 1;
        int nk = k + N;
        
        if(nx >= N || nk >= N*N) return null;
        String tile = (String) data[nx][y];
        
        if(tile.equals(Const.BLOCK)) return null;
        return Integer.toString(nk);
    }
}
