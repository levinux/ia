package jdijkstraswing.graph;

import java.util.Comparator;

public class WeightComparator implements Comparator {
    @Override
    public int compare(Object u, Object v) {
        Edge e = (Edge) u;
        Edge f = (Edge) v;
        
        if(e.getWeight() == f.getWeight()) return 0;
        if(e.getWeight() > f.getWeight()) return 1;
        if(e.getWeight() < f.getWeight()) return -1;
        return -1;
    }
}
