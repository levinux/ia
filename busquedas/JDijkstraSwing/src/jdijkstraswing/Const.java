package jdijkstraswing;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Const {
    public static final String BLOCK = "B";
    public static final String TILE = ".";
    public static final String VISITED = "-";
    public static long MILIS = 250;
    public static final int RND_MAX = 20;
    
    public static void sleep() {
        try {
            Thread.sleep(MILIS);
        } catch (InterruptedException ex) {
            Logger.getLogger(Const.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
