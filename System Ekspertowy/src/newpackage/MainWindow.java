/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;


import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.accessibility.AccessibleRole;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Emil
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     */
    File regulyXML;
    File modeleXML;
    File wykluczeniaXML;

    ArrayList<DaneWejsciowe> objawyList = new ArrayList<>();

    public MainWindow() {
        initComponents();
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

    jMenuBar1 = new javax.swing.JMenuBar();
    jMenu1 = new javax.swing.JMenu();
    jMenu2 = new javax.swing.JMenu();
    jMenuBar2 = new javax.swing.JMenuBar();
    jMenu3 = new javax.swing.JMenu();
    jMenuItem1 = new javax.swing.JMenuItem();
    jMenuItem10 = new javax.swing.JMenuItem();
    jMenuItem2 = new javax.swing.JMenuItem();
    jMenuItem7 = new javax.swing.JMenuItem();
    jMenu4 = new javax.swing.JMenu();
    jMenuItem3 = new javax.swing.JMenuItem();
    jMenuItem4 = new javax.swing.JMenuItem();
    jMenuItem8 = new javax.swing.JMenuItem();
    jMenu5 = new javax.swing.JMenu();
    jMenuItem5 = new javax.swing.JMenuItem();
    jMenuItem6 = new javax.swing.JMenuItem();
    jMenuItem9 = new javax.swing.JMenuItem();
    jMenu6 = new javax.swing.JMenu();
    jMenuItem11 = new javax.swing.JMenuItem();
    jMenuItem12 = new javax.swing.JMenuItem();

    jMenu1.setText("File");
    jMenuBar1.add(jMenu1);

    jMenu2.setText("Edit");
    jMenuBar1.add(jMenu2);

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jMenu3.setText("Baza reguł");

    jMenuItem1.setText("Wczytaj");
    jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem1ActionPerformed(evt);
      }
    });
    jMenu3.add(jMenuItem1);

    jMenuItem10.setText("Wyświetl reguły");
    jMenuItem10.setEnabled(false);
    jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem10ActionPerformed(evt);
      }
    });
    jMenu3.add(jMenuItem10);

    jMenuItem2.setText("Dodaj regułe");
    jMenuItem2.setEnabled(false);
    jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem2ActionPerformed(evt);
      }
    });
    jMenu3.add(jMenuItem2);

    jMenuItem7.setText("Usuń regułe");
    jMenuItem7.setEnabled(false);
    jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem7ActionPerformed(evt);
      }
    });
    jMenu3.add(jMenuItem7);

    jMenuBar2.add(jMenu3);

    jMenu4.setText("Baza modeli");

    jMenuItem3.setText("Wczytaj");
    jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem3ActionPerformed(evt);
      }
    });
    jMenu4.add(jMenuItem3);

    jMenuItem4.setText("Dodaj model");
    jMenuItem4.setEnabled(false);
    jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem4ActionPerformed(evt);
      }
    });
    jMenu4.add(jMenuItem4);

    jMenuItem8.setText("Usuń model");
    jMenuItem8.setEnabled(false);
    jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem8ActionPerformed(evt);
      }
    });
    jMenu4.add(jMenuItem8);

    jMenuBar2.add(jMenu4);

    jMenu5.setText("Baza wykluczeń");

    jMenuItem5.setText("Wczytaj");
    jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem5ActionPerformed(evt);
      }
    });
    jMenu5.add(jMenuItem5);

    jMenuItem6.setText("Dodaj wykluczenie");
    jMenuItem6.setEnabled(false);
    jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem6ActionPerformed(evt);
      }
    });
    jMenu5.add(jMenuItem6);

    jMenuItem9.setText("Usun wykluczenie");
    jMenuItem9.setEnabled(false);
    jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem9ActionPerformed(evt);
      }
    });
    jMenu5.add(jMenuItem9);

    jMenuBar2.add(jMenu5);

    jMenu6.setText("Wyswietlanie");
    jMenu6.setEnabled(false);

    jMenuItem11.setText("Wprowadz objawy");
    jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem11ActionPerformed(evt);
      }
    });
    jMenu6.add(jMenuItem11);

    jMenuItem12.setText("Wnioskowanie");
    jMenuItem12.setEnabled(false);
    jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem12ActionPerformed(evt);
      }
    });
    jMenu6.add(jMenuItem12);

    jMenuBar2.add(jMenu6);

    setJMenuBar(jMenuBar2);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 400, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 279, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JFileChooser wczytaj = new JFileChooser();
        wczytaj.setMultiSelectionEnabled(false);
        wczytaj.setFileFilter(new FileNameExtensionFilter(".xml", "xml"));
        wczytaj.showOpenDialog(jMenu1);

        regulyXML = wczytaj.getSelectedFile();
        try {

            if (regulyXML.canRead() && regulyXML.getAbsolutePath().endsWith(".xml")) {
                JOptionPane.showMessageDialog(null, "Wczytano poprawny plik");
                jMenuItem2.setEnabled(true);
                jMenuItem7.setEnabled(true); // usun regule
                jMenuItem10.setEnabled(true); // wyswietl reguly
                jMenu6.setEnabled(true);      //wprowadz objawy
            } else {
                JOptionPane.showMessageDialog(null, "Wybrany plik jest nie poprawny");
            }
        } catch (HeadlessException | NullPointerException NuException) {
            JOptionPane.showMessageDialog(null, "Wybrany plik jest nie poprawny");
        }

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        AddRule rule = new AddRule(regulyXML);


    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        JFileChooser wczytaj = new JFileChooser();
        wczytaj.setMultiSelectionEnabled(false);
        wczytaj.setFileFilter(new FileNameExtensionFilter(".xml", "xml"));
        wczytaj.showOpenDialog(jMenu1);
        try {
            modeleXML = wczytaj.getSelectedFile();
            if (modeleXML.canRead() && modeleXML.getAbsolutePath().endsWith(".xml")) {
                JOptionPane.showMessageDialog(null, "Wczytano poprawny plik");
                jMenuItem4.setEnabled(true);
                jMenuItem8.setEnabled(true); // usun model
            } else {
                JOptionPane.showMessageDialog(null, "Wybrany plik jest nie poprawny");
            }
        } catch (Exception NuException) {
            JOptionPane.showMessageDialog(null, "Wybrany plik jest nie poprawny");
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        System.out.println("ff " + modeleXML.getName());
        AddModel model = new AddModel(modeleXML);

    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        JFileChooser wczytaj = new JFileChooser();
        wczytaj.setMultiSelectionEnabled(false);
        wczytaj.setFileFilter(new FileNameExtensionFilter(".xml", "xml"));
        wczytaj.showOpenDialog(jMenu1);
        try {
            wykluczeniaXML = wczytaj.getSelectedFile();
            if (wykluczeniaXML.canRead() && wykluczeniaXML.getAbsolutePath().endsWith(".xml")) {
                JOptionPane.showMessageDialog(null, "Wczytano poprawny plik");
                jMenuItem6.setEnabled(true);
                jMenuItem9.setEnabled(true); // usun wykluczenie
            } else {
                JOptionPane.showMessageDialog(null, "Wybrany plik jest nie poprawny");
            }
        } catch (Exception NuException) {
            JOptionPane.showMessageDialog(null, "Wybrany plik jest nie poprawny");
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        AddLimit limit = new AddLimit(wykluczeniaXML);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        RemoveRule rRule = new RemoveRule(regulyXML);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        RemoveModel rModel = new RemoveModel(modeleXML);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        RemoveLimit rLimit = new RemoveLimit(wykluczeniaXML);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        ShowRule sRule = new ShowRule(regulyXML);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

  private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed

      int isWoman = JOptionPane.showConfirmDialog(rootPane, "Czy jsteś kobietą?");
      System.out.println(isWoman);

      if (isWoman == 2) {
          return;
      }
      JFrame objawy = new JFrame("Wprowadz objawy");    //tworzenie frame
      JButton zatwierdz = new JButton("zatwierdz");
      objawy.setVisible(true);
      objawy.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      objawy.setSize(720, 480);
      objawy.setLocationRelativeTo(null);
      objawy.setAlwaysOnTop(true);

      GridLayout gridLayout = new GridLayout(0, 2);
      objawyList.clear();
      setObjawy(wykluczeniaXML, objawyList, isWoman == 1);

      ArrayList<JLabel> jLabels = new ArrayList<>();
      final ArrayList<JTextField> jFields = new ArrayList<>();

      JPanel panel = new JPanel();
      JScrollPane jsp = new JScrollPane(panel);
      objawy.add(jsp);
      panel.setLayout(gridLayout);
      gridLayout.setVgap(10);

      for (int i = 0; i < objawyList.size(); i++) {
          jLabels.add(new JLabel(objawyList.get(i).argument));
          jFields.add(new JTextField());
          panel.add(jLabels.get(i));
          panel.add(jFields.get(i));

      }
      final JLabel blad = new JLabel("");
      panel.add(zatwierdz);
      panel.add(blad);
      zatwierdz.addActionListener(new java.awt.event.ActionListener() {
          @Override
          public void actionPerformed(java.awt.event.ActionEvent evt) {
              zatwierdzActionPerformed(evt);
          }

      //rbc
          //hgb      kobieta/man
          //hct
          //mcv
          private void zatwierdzActionPerformed(ActionEvent evt) {     //reakcja na ztwierdz
              blad.setText("");
              try {
                  float d;

                  for (int i = 0; i < objawyList.size(); i++) {
                      if (jFields.get(i).getText().isEmpty()) {
                          JOptionPane.showMessageDialog(null, "Wprowadz wszystkie dane");
                          return;
                      }
                      d = Float.parseFloat(jFields.get(i).getText());

                      objawyList.set(i, new DaneWejsciowe(objawyList.get(i).argument, d));
                      System.out.println(objawyList.get(i).argument + " " + objawyList.get(i).wartosc);
                  }
                  jMenuItem12.setEnabled(true);
              } catch (NumberFormatException | NullPointerException n) {
                  blad.setText("Wprowadzono bledny format danych");
              }
          }
      });


  }//GEN-LAST:event_jMenuItem11ActionPerformed

  private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
      //Wnioskowanie
      Silnik engine = new Silnik();
      System.out.println("Objawy list size: " + objawyList.size());
      engine.daneWejscioweArray = objawyList;

      engine.read(modeleXML.getPath(), regulyXML.getPath(), wykluczeniaXML.getPath()); //ścieżki do plików: modelu, zasad i ograniczeń
      engine.parse(); //parsowanie xmla
      System.out.println("Models array size: "+engine.modelsArray.size());
      System.out.println("Rules array size: "+engine.rulesArray.size());
      System.out.println("Const. array size: "+engine.constraintsArray.size());
      engine.runn(); //uruchomienie wnioskowania
      System.out.println(engine.kroki.size());
    //wyświetlenie co z czego zostało wywnioskowane:
      for (Rules r : engine.kroki) {
          for (String str : r.warunki) {
              System.out.print(str + " + ");
          }
          System.out.println("=> " + r.wniosek + " CF: "+r.CF);
          
      }

        
  }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void setObjawy(File oganiczeniaXML, ArrayList<DaneWejsciowe> objList, boolean czyMan) {
        try (Scanner sc = new Scanner(oganiczeniaXML)) {

            String linia;
            String objaw = "";
            while (sc.hasNext()) {
                linia = sc.nextLine();
                if (linia.contains("<nazwa>")) {

                    for (int i = linia.indexOf(">") + 1; i < linia.lastIndexOf("<"); i++) {

                        objaw += linia.charAt(i);

                    }

                    if (!objaw.contains("Kobieta") && czyMan) {
                        objList.add(new DaneWejsciowe(objaw, 0));
                    } else if (!objaw.contains("Mezczyzna") && !czyMan) {
                        objList.add(new DaneWejsciowe(objaw, 0));
                    }

                    objaw = "";

                }
            }
            sc.close();
            //return objawy;
        } catch (FileNotFoundException | NullPointerException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "nie wybrano pliku");
        }
        //return null;
    }

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JMenu jMenu1;
  private javax.swing.JMenu jMenu2;
  private javax.swing.JMenu jMenu3;
  private javax.swing.JMenu jMenu4;
  private javax.swing.JMenu jMenu5;
  private javax.swing.JMenu jMenu6;
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JMenuBar jMenuBar2;
  private javax.swing.JMenuItem jMenuItem1;
  private javax.swing.JMenuItem jMenuItem10;
  private javax.swing.JMenuItem jMenuItem11;
  private javax.swing.JMenuItem jMenuItem12;
  private javax.swing.JMenuItem jMenuItem2;
  private javax.swing.JMenuItem jMenuItem3;
  private javax.swing.JMenuItem jMenuItem4;
  private javax.swing.JMenuItem jMenuItem5;
  private javax.swing.JMenuItem jMenuItem6;
  private javax.swing.JMenuItem jMenuItem7;
  private javax.swing.JMenuItem jMenuItem8;
  private javax.swing.JMenuItem jMenuItem9;
  // End of variables declaration//GEN-END:variables
}
