package jdijkstraswing.algorithms;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.table.TableModel;
import jdijkstraswing.Const;
import jdijkstraswing.graph.Edge;
import jdijkstraswing.graph.Graph;
import jdijkstraswing.graph.SpanningTree;
import jdijkstraswing.graph.Vertice;
import jdijkstraswing.graph.WeightComparator;

public class KruskalMST implements Runnable {
    private final Graph G;
    private final Thread hilo;
    private final TableModel t;
    private final Random rnd;
    
    public KruskalMST(TableModel t, Graph G) {
        this.t = t;
        this.G = G;
        hilo = new Thread(this);
        rnd = new Random();
        this.G.setDirected(true);
    }
    
    public void doKruskal() {
        hilo.start();
    }

    @Override
    public void run() {
        ArrayList<Edge> A = new ArrayList<>();
        ArrayList<SpanningTree> set = new ArrayList<>();
        ArrayList<Edge> edges = new ArrayList<>();
        
        // Lineas 2-3
        for(Vertice v: G.V()) {
            set.add(new SpanningTree(v));
        }
        
        // Un peque/no inter para agregar pesos aleatorios
        // a cada una de las aristas
        for(Edge e: G.E()) {
            int weight = rnd.nextInt(Const.RND_MAX);
            
            while(weight < 1) weight = rnd.nextInt(Const.RND_MAX);
            e.setWeight(weight);
            /*System.out.println("Arista de " + e.getOrig().getKey() 
                    + " -> " + e.getDest().getKey() + " y un peso " + e.getWeight());*/
            edges.add(e);
        }
        
        // Sorting
        // Linea 4
        edges.sort(new WeightComparator());
        
        // Lineas 5-8
        for(int i = 0; i < edges.size(); i++) {
            Vertice u = edges.get(i).getOrig();
            Vertice v = edges.get(i).getDest();
            
            System.out.println("Arista de peso " + edges.get(i).getWeight()
                    + " (" + edges.get(i).getOrig().getKey() + ", "
                    + edges.get(i).getDest().getKey() + ")");
            
            SpanningTree tu = find_set(set, u);
            SpanningTree tv = find_set(set, v);
            
            System.out.println("st-u tiene " + tu.getLeafs().size() + " hojas");
            System.out.println("st-v tiene " + tv.getLeafs().size() + " hojas");
            
            if(!tu.equals(tv)) { // Linea 6
                System.out.println("st-u y st-v no son iguales!");
                A.add(edges.get(i)); // Linea 7
                set.remove(tu);
                set.remove(tv);
                SpanningTree union = SpanningTree.union(tu, tv);
                set.add(union); // Linea 8
            }
            
            System.out.println("=====\n");
        }
        
        // Vamos a recorrer el grafo con estas nuevas aristas
        for(Edge arista : A) {
            Vertice u = arista.getOrig();
            Vertice v = arista.getDest();
            
            t.setValueAt(Const.VISITED, u.getX(), u.getY());
            t.setValueAt(Const.VISITED, v.getX(), v.getY());
            Const.sleep();
        }
    }
    
    private SpanningTree find_set(ArrayList<SpanningTree> trees, Vertice u) {
        for(SpanningTree tree : trees) {
            System.out.println("Arbol para " + u.getKey() + ": " + tree);
            boolean inU = tree.hasLeaf(u);
            if(inU) return tree;
        }
        
        return null;
    }
}
