package jdijkstraswing;

import java.awt.Color;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import jdijkstraswing.algorithms.BreadthFirstSearch;
import jdijkstraswing.algorithms.DepthFirstSearch;
import jdijkstraswing.algorithms.Dijkstra;
import jdijkstraswing.algorithms.KruskalMST;
import jdijkstraswing.graph.Graph;
import jdijkstraswing.graph.GraphMaker;
import jdijkstraswing.graph.Vertice;

public class MainForm extends javax.swing.JFrame {
    private static int N = 0;
    
    private Graph g;
    private Object[][] data;
    
    private Object[][] getGrid() {
        Object[][] matrix;
        
        String strW = JOptionPane.showInputDialog(this, "Tama/no del mapa:",
                "N", JOptionPane.INFORMATION_MESSAGE);
        
        N = Integer.parseInt(strW);
        matrix = new Object[N][N];
        Random rnd = new Random();
        int div = rnd.nextInt(5);
        
        while(div <= 1) div = rnd.nextInt(10);
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                int block = rnd.nextInt() % div;
                
                if(block == 0)
                    matrix[i][j] = Const.BLOCK;
                else
                    matrix[i][j] = Const.TILE;
            }
        }
        
        return matrix;
    }
    
    private void askForMap() {
        int decision = JOptionPane.showConfirmDialog(this, "Deseas un mapa predefinido?", "", JOptionPane.YES_NO_OPTION);
        
        if(decision == JOptionPane.YES_OPTION) {
            data = PreloadedMaps.loadFromFile();
            
            if(data == null) {
                data = getGrid();
            } else{
                N = data.length;
            }
        }
        if(decision == JOptionPane.NO_OPTION){
            data = getGrid();
        }
    }
    
    private void initData() {
        TableColumn column;
        Object[] columns = null;
        
        columns = new Object[N];
        for(int i = 0; i < N; i++) {
            columns[i] = "";
        }
        
        dataTable.setModel(new DefaultTableModel(data, columns));
        MapaRender render = new MapaRender();
        
        for(int i = 0; i < N; i++) {
            column = dataTable.getColumnModel().getColumn(i);
            column.setResizable(false);
            column.setMaxWidth(15);
            column.setCellRenderer(render);
        }
    }
    
    private void makeGraph() {
        g = GraphMaker.doIt(data, false);
    }
    
    public MainForm() {
        initComponents();
        this.setTitle("Busquedas by Levinux");
        this.setSize(800, 600);
        
        askForMap();
        initData();
        dataTable.setEnabled(false);
        dataTable.setBackground(Color.BLACK);
        dataTable.setDragEnabled(false);
        makeGraph();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        btn_bfs = new javax.swing.JButton();
        btn_dfs = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btn_kruskal = new javax.swing.JButton();
        btn_prim = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btn_dijkstra = new javax.swing.JButton();
        btn_astar = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btn_clear = new javax.swing.JButton();
        btn_speed = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btn_about = new javax.swing.JButton();
        jmenubar = new javax.swing.JMenuBar();
        jmenu_maps = new javax.swing.JMenu();
        jmenuitem_nuevo = new javax.swing.JMenuItem();
        jmenuitem_cargarm = new javax.swing.JMenuItem();
        jmenuitem_guardar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmenuitem_exit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(dataTable);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btn_bfs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jdijkstraswing/imgs/bfs.png"))); // NOI18N
        btn_bfs.setToolTipText("Breadth-First Search");
        btn_bfs.setFocusable(false);
        btn_bfs.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_bfs.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_bfs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bfsActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_bfs);

        btn_dfs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jdijkstraswing/imgs/dfs.png"))); // NOI18N
        btn_dfs.setToolTipText("Depth-First Search");
        btn_dfs.setFocusable(false);
        btn_dfs.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_dfs.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_dfs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dfsActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_dfs);
        jToolBar1.add(jSeparator3);

        btn_kruskal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jdijkstraswing/imgs/kruskal.png"))); // NOI18N
        btn_kruskal.setToolTipText("Kruskal's Minimum Spanning Tree");
        btn_kruskal.setFocusable(false);
        btn_kruskal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_kruskal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_kruskal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kruskalActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_kruskal);

        btn_prim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jdijkstraswing/imgs/prim.png"))); // NOI18N
        btn_prim.setToolTipText("Prim's Minimum Spanning Tree");
        btn_prim.setFocusable(false);
        btn_prim.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_prim.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_prim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_primActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_prim);
        jToolBar1.add(jSeparator4);

        btn_dijkstra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jdijkstraswing/imgs/dijkstra.png"))); // NOI18N
        btn_dijkstra.setToolTipText("Dijkstra's Shortest Path");
        btn_dijkstra.setFocusable(false);
        btn_dijkstra.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_dijkstra.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_dijkstra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dijkstraActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_dijkstra);

        btn_astar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jdijkstraswing/imgs/astar.png"))); // NOI18N
        btn_astar.setToolTipText("A* Shortest Path");
        btn_astar.setFocusable(false);
        btn_astar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_astar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_astar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_astarActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_astar);
        jToolBar1.add(jSeparator5);

        btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jdijkstraswing/imgs/clear.png"))); // NOI18N
        btn_clear.setToolTipText("Limpiar camino");
        btn_clear.setFocusable(false);
        btn_clear.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_clear.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_clear);

        btn_speed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jdijkstraswing/imgs/jump.png"))); // NOI18N
        btn_speed.setToolTipText("Cambiar velocidad");
        btn_speed.setFocusable(false);
        btn_speed.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_speed.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_speed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_speedActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_speed);
        jToolBar1.add(jSeparator2);

        btn_about.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jdijkstraswing/imgs/face-glasses.png"))); // NOI18N
        btn_about.setToolTipText("Acerca de...");
        btn_about.setFocusable(false);
        btn_about.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_about.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aboutActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_about);

        jmenu_maps.setText("Mapas");

        jmenuitem_nuevo.setText("Nuevo mapa aleatorio");
        jmenuitem_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuitem_nuevoActionPerformed(evt);
            }
        });
        jmenu_maps.add(jmenuitem_nuevo);

        jmenuitem_cargarm.setText("Cargar mapa");
        jmenuitem_cargarm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuitem_cargarmActionPerformed(evt);
            }
        });
        jmenu_maps.add(jmenuitem_cargarm);

        jmenuitem_guardar.setText("Guardar mapa");
        jmenuitem_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuitem_guardarActionPerformed(evt);
            }
        });
        jmenu_maps.add(jmenuitem_guardar);
        jmenu_maps.add(jSeparator1);

        jmenuitem_exit.setText("Salir");
        jmenuitem_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuitem_exitActionPerformed(evt);
            }
        });
        jmenu_maps.add(jmenuitem_exit);

        jmenubar.add(jmenu_maps);

        setJMenuBar(jmenubar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmenuitem_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuitem_guardarActionPerformed
        PreloadedMaps.saveFile(data);
    }//GEN-LAST:event_jmenuitem_guardarActionPerformed

    private void jmenuitem_cargarmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuitem_cargarmActionPerformed
        Object[][] tmp = PreloadedMaps.loadFromFile();
        if(tmp != null) {
            data = tmp;
        }
        
        N = data.length;
        initData();
        makeGraph();
    }//GEN-LAST:event_jmenuitem_cargarmActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                dataTable.getModel().setValueAt(data[i][j], i, j);
            }
        }
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_speedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_speedActionPerformed
        String snum = JOptionPane.showInputDialog(this, "Que tan rapido se mostraran las visitas? (default: 250ms)", Const.MILIS);
        if(snum.isEmpty()) return;
        
        Const.MILIS = Integer.parseInt(snum);
    }//GEN-LAST:event_btn_speedActionPerformed

    private void btn_aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aboutActionPerformed
        String message = "Desarrollado por M.C. Levi Ismael Sandoval,\npara mis alumnos de I.A. de VIII semestre.\n\nSolo para fines educativos!";
        java.net.URL imgurl = getClass().getResource("imgs/face-glasses.png");
        ImageIcon icon = new ImageIcon(imgurl);
        JOptionPane.showMessageDialog(this, message, "Geek behind this...", JOptionPane.INFORMATION_MESSAGE, icon);
    }//GEN-LAST:event_btn_aboutActionPerformed

    private void jmenuitem_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuitem_nuevoActionPerformed
        data = getGrid();
        initData();
        makeGraph();
    }//GEN-LAST:event_jmenuitem_nuevoActionPerformed

    private void jmenuitem_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuitem_exitActionPerformed
        this.setVisible(false);
        System.exit(0);
    }//GEN-LAST:event_jmenuitem_exitActionPerformed

    private void btn_bfsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bfsActionPerformed
        Vertice v = g.V().get(0);
        g.setDirected(false);
        BreadthFirstSearch bfs = new BreadthFirstSearch(dataTable.getModel(), g, v);
        bfs.doBfs();
    }//GEN-LAST:event_btn_bfsActionPerformed

    private void btn_dfsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dfsActionPerformed
        g.setDirected(true);
        DepthFirstSearch dfs = new DepthFirstSearch(dataTable.getModel(), g);
        dfs.doDfs();
    }//GEN-LAST:event_btn_dfsActionPerformed

    private void btn_kruskalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kruskalActionPerformed
        g.setDirected(false);
        KruskalMST k = new KruskalMST(dataTable.getModel(), g);
        k.doKruskal();
    }//GEN-LAST:event_btn_kruskalActionPerformed

    private void btn_primActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_primActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_primActionPerformed

    private void btn_dijkstraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dijkstraActionPerformed
        g.setDirected(true);
        Dijkstra d = new Dijkstra(dataTable.getModel(), g, g.V().get(0));
        d.doDijkstra();
    }//GEN-LAST:event_btn_dijkstraActionPerformed

    private void btn_astarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_astarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_astarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_about;
    private javax.swing.JButton btn_astar;
    private javax.swing.JButton btn_bfs;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_dfs;
    private javax.swing.JButton btn_dijkstra;
    private javax.swing.JButton btn_kruskal;
    private javax.swing.JButton btn_prim;
    private javax.swing.JButton btn_speed;
    private javax.swing.JTable dataTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenu jmenu_maps;
    private javax.swing.JMenuBar jmenubar;
    private javax.swing.JMenuItem jmenuitem_cargarm;
    private javax.swing.JMenuItem jmenuitem_exit;
    private javax.swing.JMenuItem jmenuitem_guardar;
    private javax.swing.JMenuItem jmenuitem_nuevo;
    // End of variables declaration//GEN-END:variables
}
