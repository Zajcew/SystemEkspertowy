/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.awt.HeadlessException;
import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author student
 */
public class AddLimit extends javax.swing.JFrame {

    /**
     * Creates new form AddRule
     */
    File wykluczeniaXML;
    ArrayList<String> wykluczenia;

    public AddLimit(String title) throws HeadlessException {
        super(title);
    }

    public AddLimit(File wykluczeniaXML) {
        this.wykluczeniaXML = wykluczeniaXML;

        initComponents();
        setVisible(true);
        jTextField2.setText("");
        jTextArea1.setText("");
        wykluczenia = new ArrayList<String>();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Nazwa:");

        jLabel2.setText("Wykluczenia:");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("Dodaj wykluczenie");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Dodaj ograniczenie");
        jButton2.setActionCommand("Dodaj ograniczenie");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jTextField2))))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //dodawanie objawów
        if (jTextField2.getText().length()>1) {

            wykluczenia.add(jTextField2.getText());
            jTextArea1.setText((jTextArea1.getText() + "\r\n" + jTextField2.getText()).trim());
            jTextField2.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Wpisz wykluczenie");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int last = findLastRule(wykluczeniaXML);
        String plik = "";
        String wykluczenie = "";
        int limitCount = 1;

        //dopisywanie modelu do pliku
        try {
            Scanner s = new Scanner(wykluczeniaXML);
            System.out.println(plik);
            String linia;
            for (int i = 0; i < last; i++) {
                linia = s.nextLine();
                plik += linia;
                if (linia.contains("</nr>")) {
                    linia=linia.replaceAll("</nr>", "");
                    linia=linia.replaceAll("<nr>", "");
                    limitCount=Integer.parseInt(linia.trim());
                    limitCount++;
                }
                plik += "\r\n";
                plik += wykluczenie;
            }
            plik += "\r\n";


            System.out.println(plik);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Nie można odczytać pliku");
            Logger.getLogger(AddModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        //dodanie reguly do stringa
        wykluczenie += "  <ograniczenie>\r\n";
        wykluczenie += "	<nr>" + limitCount + "</nr>\r\n";
        wykluczenie += "	<nazwa>" + jTextField1.getText() + "</nazwa>\r\n";
        wykluczenie += "	<wykluczenia>\r\n";
        //dodawanie objawów
        for (String objaw : wykluczenia) {
            wykluczenie += "		<wykluczenie>" + objaw + "</wykluczenie>\r\n";
        }
        wykluczenie += "	</wykluczenia>\r\n";
        wykluczenie += "  </ograniczenie>\r\n";
        wykluczenie += "</ograniczenia>\r\n";


        plik += wykluczenie;

        //dodanie stringa do bnazy
        //System.out.println(plik);
        try {
            FileWriter f = new FileWriter(wykluczeniaXML);
            f.write(plik);
            f.close();
            JOptionPane.showMessageDialog(null, "Pomyślnie dodano model");
            setVisible(false);
            dispose();
        } catch (IOException ex) {
            Logger.getLogger(AddModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private int findLastRule(File regulyXML) {// znajdowanie lini ostatniego modelu
        int lastLine = 0;
        try {
            Scanner s = new Scanner(regulyXML);
            int i = 0;
            while (s.hasNextLine()) {
                i++;
                if (s.nextLine().contains("</ograniczenie>")) {
                    lastLine = i;
                }
            }
        } catch (FileNotFoundException ex) {

            Logger.getLogger(AddModel.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Nie można odczytać pliku");
        }

        return lastLine;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
