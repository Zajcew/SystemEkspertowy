/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Artur
 */
public class RemoveRule extends javax.swing.JFrame {

    DefaultComboBoxModel reguly;

    public class Rule {

        public int nr;
        public int startLine;
        public int endLine;
        public String wniosek;
        public String objawy;
        public String cf;

        public Rule(int n, int s, int e, String wniosek, String objawy, String cf) {
            this.nr = n;
            this.startLine = s;
            this.endLine = e;
            this.wniosek = wniosek;
            this.objawy = objawy;
            this.cf = cf;
        }

        @Override
        public String toString() {
            return Integer.toString(nr);
        }
    }
    File fileName;
    ArrayList<Rule> rules;
    
    public RemoveRule(File fileName) {
        this.fileName = fileName;
        //System.out.println(" " + fileName.getPath());
        this.rules = new ArrayList<>();
        loadList();
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void removeLines(File fileName, int p, int k) {
        //System.out.println("p k " + p + " " + k);
        String plik = "";
        try {
            Scanner s = new Scanner(fileName);
            int i = 0;
            while (s.hasNextLine()) {
                i++;
                String currentLine = s.nextLine();
                //System.out.println("i " + i);
                if (!(i >= p && i <= k)) { // zapisz wszystko oprocz tego
                    plik += currentLine + "\n";
                }
            }
            s.close();
        } catch (FileNotFoundException ex) {
        }
        //System.out.println(plik);
        //System.out.println("1,5");
        try {
            FileWriter f = new FileWriter(fileName);
            f.write(plik);
            f.close();
            //System.out.println("1.5.1");
            JOptionPane.showMessageDialog(null, "Pomyślnie usunieto regule");
        } catch (IOException ex) {
            Logger.getLogger(RemoveRule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadList() {
        try {
            Scanner s = new Scanner(fileName);
            int i = 0;
            int nr = -1, p = -1, k = -1;
            String wniosek = "";
            String objawy = "";
            String cf = "";
            while (s.hasNextLine()) {
                i++;
                String currentLine = s.nextLine();
                if (currentLine.contains("<regula>")) { // poczatek modelu
                    p = i;
                } else if (currentLine.contains("<nr>")) { // nr modelu
                    currentLine = currentLine.replaceAll("</nr>", "");
                    currentLine = currentLine.replaceAll("<nr>", "");
                    nr = Integer.parseInt(currentLine.trim());
                } else if (currentLine.contains("<wniosek>")) { // wniosek modelu
                    currentLine = currentLine.replaceAll("</wniosek>", "");
                    currentLine = currentLine.replaceAll("<wniosek>", "");
                    wniosek = currentLine.trim();
                } else if (currentLine.contains("<cf>")) { // cf modelu
                    currentLine = currentLine.replaceAll("</cf>", "");
                    currentLine = currentLine.replaceAll("<cf>", "");
                    cf = currentLine.trim();
                } else if (currentLine.contains("<objaw>")) { // objaw modelu
                    currentLine = currentLine.replaceAll("</objaw>", "");
                    currentLine = currentLine.replaceAll("<objaw>", "");
                    objawy += currentLine.trim() + " ";
                } else if (currentLine.contains("</regula>")) { // koniec modelu
                    k = i;

                    // dodaj do listy
                    if (nr != -1 && p != -1 && k != -1) {
                        Rule newRule = new Rule(nr, p, k, wniosek, objawy, cf);
                        rules.add(newRule);
                        objawy = "";
                        cf = "";
                        wniosek = "";
                        //jComboBox1.addItem(newModel);
                        //System.out.println(nr + " " + " " + p + " " + k);
                    }

                    nr = -1;
                    p = -1;
                    k = -1;
                }
            }
            s.close();
            // combo box
            Vector comboBoxItems = new Vector();
            for (int ii = 0; ii < rules.size(); ii++) {
                comboBoxItems.add("Nr: " + Integer.toString(rules.get(ii).nr) + ", Wniosek: " + rules.get(ii).wniosek);
            }
            reguly = new DefaultComboBoxModel(comboBoxItems);
        } catch (FileNotFoundException ex) {
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

        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBox1.setModel(reguly);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setText("Usun");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("CF");

        jLabel2.setText("Objawy");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        jLabel1.getAccessibleContext().setAccessibleName("jLabelCF");
        jLabel2.getAccessibleContext().setAccessibleName("jLabelObjawy");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jComboBox1.getSelectedIndex() != -1) {
            int selectedIndex = jComboBox1.getSelectedIndex();
            jComboBox1.removeItemAt(selectedIndex);

            // zapisz nowy plik
            //System.out.println("1");
            removeLines(fileName, rules.get(selectedIndex).startLine, rules.get(selectedIndex).endLine);
            //System.out.println("2");
            rules.remove(selectedIndex);
            //System.out.println("3");
            setVisible(false);
            dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
         if (jComboBox1.getSelectedIndex() != -1) {
             int selectedIndex = jComboBox1.getSelectedIndex();
             jLabel1.setText(rules.get(selectedIndex).cf); // cf
             jLabel2.setText(rules.get(selectedIndex).objawy);// objawy
         }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
