/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JFrame;
import org.jgraph.JGraph;
import org.jgraph.graph.DefaultEdge;
import org.jgraph.graph.DefaultGraphCell;
import org.jgraph.graph.GraphConstants;
import org.jgrapht.ListenableGraph;
import org.jgrapht.ext.JGraphModelAdapter;
import org.jgrapht.graph.ListenableDirectedGraph;

/**
 *
 * @author soldyy
 */
public class Wizualizacja extends javax.swing.JFrame {

    /**
     * Creates new form Wizualizacja
     */
    private static final Color DEFAULT_BG_COLOR = Color.decode("#FAFBFF");
    private static final Dimension DEFAULT_SIZE = new Dimension(1024, 768);
    HashMap<String, ArrayList<String>> graphMap;

    public Wizualizacja(HashMap<String, ArrayList<String>> graphMap) {
        this.graphMap = graphMap;
        initComponents();
        JGraphAdapterDemo d = new JGraphAdapterDemo();
        d.init();
        d.show();
    }

    public Wizualizacja() {
        initComponents();
    }

    private void paintGraph() {
        new JGraphAdapterDemo().init();
    }

    public class JGraphAdapterDemo extends JFrame {

        // 
        private JGraphModelAdapter m_jgAdapter;

        
        public void init() {
            // create a JGraphT graph
            ListenableGraph g = new ListenableDirectedGraph(DefaultEdge.class);

            // create a visualization using JGraph, via an adapter
            m_jgAdapter = new JGraphModelAdapter(g);

            JGraph jgraph = new JGraph(m_jgAdapter);

            adjustDisplaySettings(jgraph);
            getContentPane().add(jgraph);
            resize(DEFAULT_SIZE);
            
            Point p = new Point(1,1);
            Iterator<String> iterator = graphMap.keySet().iterator();
            int i=0;
            while (iterator.hasNext()) {
                String key = iterator.next();
                g.addVertex(key);
                positionVertexAt(key, p.x, p.y);
                for (String s : graphMap.get(key)) {
                    g.addVertex(s);
                    g.addEdge(key, s);
                    positionVertexAt(s, p.x+i, p.y+50);
                    i+=100;
                }
                i=0;
                p.y+=100;
            }

        }

        private void adjustDisplaySettings(JGraph jg) {
            jg.setPreferredSize(DEFAULT_SIZE);
            jg.setSize(1024, 768);
            Color c = DEFAULT_BG_COLOR;
            Color colorStr = null;

            try {
                colorStr = Color.BLUE;//getParameter( "bgcolor" );
            } catch (Exception e) {
            }

            jg.setBackground(c);
        }

        private void positionVertexAt(Object vertex, int x, int y) {
            DefaultGraphCell cell = m_jgAdapter.getVertexCell(vertex);
            Map attr = cell.getAttributes();
            Rectangle2D b = GraphConstants.getBounds(attr);

            GraphConstants.setBounds(attr, new Rectangle(x, y, (int) b.getWidth(), (int) b.getHeight()));
            Map cellAttr = new HashMap();
            cellAttr.put(cell, attr);
            m_jgAdapter.edit(cellAttr, null, null, null);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Wizualizacja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Wizualizacja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Wizualizacja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Wizualizacja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Wizualizacja().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
