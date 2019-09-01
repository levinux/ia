package jdijkstraswing.graph;

public class Vertice<T> implements Comparable {
    private int d;
    private int f;
    private T key;
    private Color color;
    private Vertice father;
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    private void init(int d, int f, T key, Color color, Vertice father) {
        this.d = d;
        this.f = f;
        this.key = key;
        this.color = color;
        this.father = father;
    }
    
    public Vertice() {
        init(0, 0, null, Color.WHITE, null);
    }
    
    public Vertice(T key) {
        init(0, 0, key, Color.WHITE, null);
    }
    
    public Vertice(T key, Color color) {
        init(0, 0, key, color, null);
    }
    
    public Vertice(T key, Color color, Vertice father) {
        init(0, 0, key, color, father);
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Vertice getFather() {
        return father;
    }

    public void setFather(Vertice father) {
        this.father = father;
    }

    @Override
    public int compareTo(Object o) {
        int ud = this.d;
        int vd = ((Vertice) o).d;
        
        if(ud == vd) return 0;
        if(ud < vd) return -1;
        if(ud > vd) return 1;
        return -1;
    }
}
