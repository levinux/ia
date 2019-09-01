package jdijkstraswing.graph;

//HECHO POR: Ing. Levi I. Sandoval Medina. Maestria en Ciencias de la Computacion

import java.util.Comparator;


public class Edge {
    private int weight;
    private Vertice orig;
    private Vertice dest;
    
    public Edge() {
        weight = 0;
        orig = null;
        dest = null;
    }
    
    public Edge(Vertice orig, Vertice dest) {
        weight = 0;
        this.orig = orig;
        this.dest = dest;
    }
    
    public Edge(Vertice orig, Vertice dest, int weight) {
        this.weight = weight;
        this.orig = orig;
        this.dest = dest;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Vertice getOrig() {
        return orig;
    }

    public void setOrig(Vertice orig) {
        this.orig = orig;
    }

    public Vertice getDest() {
        return dest;
    }

    public void setDest(Vertice dest) {
        this.dest = dest;
    }
}
