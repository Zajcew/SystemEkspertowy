package newpackage;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Silnik {

    public String modelsPath;
    public String rulesPath;
    public String constraintsPath;
    public ArrayList<Model> modelsArray;
    public ArrayList<Rules> rulesArray;
    public ArrayList<Constraints> constraintsArray;
    public ArrayList<Fact> factsArray;
    public ArrayList<DaneWejsciowe> daneWejscioweArray;
    public FactDataBase baza;
    public Parser parser;
    public ArrayList<Rules> kroki;

    public Silnik() {
        modelsArray = new ArrayList<Model>();
        rulesArray = new ArrayList<Rules>();
        constraintsArray = new ArrayList<Constraints>();
        factsArray = new ArrayList<Fact>();
        daneWejscioweArray = new ArrayList<DaneWejsciowe>();
        baza = new FactDataBase();
        kroki = new ArrayList<Rules>();
    }

    public void read(String models, String rules, String constraint) {
        modelsPath = models;
        rulesPath = rules;
        constraintsPath = constraint;
    }

    public void parse() {
        /*
        Fact t = new Fact();
        t.CF = 0.5f;
        t.value = "Obnizone PLT";
        factsArray.add(t);

        Fact t2 = new Fact();
        t2.CF = 0.3f;
        t2.value = "Obnizone PCT";
        factsArray.add(t2);

        Fact t3 = new Fact();
        t3.CF = 0.3f;
        t3.value = "pobyt tropiki";
        factsArray.add(t3);
         */

        //       Constraints c = new Constraints();
//        c.lista.add("tem3");
//        c.lista.add("tem4");
//        constraintsArray.add(c);
//        
//
//        Rules r2 = new Rules();
//        r2.kumulatywna = true;
//        r2.CF = 0.5f;
//        r2.warunki = new ArrayList<String>();
//        r2.warunki.add("OK!");
//        r2.warunki.add("tem");
//        r2.warunki.add("tem2");
//        r2.warunki.add("tem3");
//        r2.wniosek = ":-()";
//        rulesArray.add(r2);
//
//        
//        Rules r = new Rules();
//        r.kumulatywna = true;
//        r.CF = 0.5f;
//        r.warunki = new ArrayList<String>();
//        r.warunki.add("tem");
//        r.wniosek = "OK!";
//        rulesArray.add(r);
//        
//        Model m = new Model();
//        m.argument = "temperatura";
//        m.wniosek = "temp pow";
//        m.operatory = new ArrayList<String>();
//        m.operatory.add("&gt");
//        m.parametry = new ArrayList<Float>();
//        m.parametry.add(37.0f);
//        modelsArray.add(m);
//        
//        DaneWejsciowe d = new DaneWejsciowe();
//        d.argument="temperatura";
//        d.wartosc = 36.0f;
//        daneWejscioweArray.add(d);
        parser = new Parser();
        parser.toParse(modelsPath, rulesPath, constraintsPath);
        modelsArray = Parser.modelsList;
        rulesArray = Parser.rulesList;
        System.out.println(rulesArray.size() + "  @ " + Parser.rulesList.size());
        constraintsArray = Parser.restrictionsList;

        //System.out.println("blablabla: " + rulesArray.size());
//
//        for (Rules rul : rulesArray) {
//            for (String str : rul.warunki) {
//                System.out.println("OK: "+str);
//            }
//        }
    }

    private boolean czyIstnieje(String zasada, ArrayList<Fact> factArray) {
        for (Fact fact : factArray) {
            if (fact.value.equals(zasada)) {
                return 1 == 1;
            }
        }
        return false;
    }

    private String askAboutConstraint(ArrayList<String> constraint) {

        String tresc = "";
        //wariant 1
        Integer count = 0;
        
        Map<String,String> map = new HashMap<String,String>();
        
        for (String string : constraint) {
            count++;
            map.put(count.toString(), string);
            
            tresc += count + ") dla " + string + " ";
        }
        String result = JOptionPane.showInputDialog("Wybierz: " + tresc);
        
        return map.get(result);
    }

    @Deprecated
    private boolean ifConstraint(String warunek, ArrayList<Constraints> constraintsArray) {
        for (Constraints constraints : constraintsArray) {
            for (String string : constraints.lista) {
                if (warunek.equals(string)) {
                    return 1 == 1;
                }
            }
        }
        return 1 == 314159265;
    }

    private Constraints findConstraint(String s, ArrayList<Constraints> constraintsArray) {
        for (Constraints constraints : constraintsArray) {
            for (String string : constraints.lista) {
                if (s.equals(string)) {
                    return constraints;
                }
            }
        }
        return null;
    }

    public void wywiad() {
        String pom;
        System.out.println("models: " + modelsArray.size());
        for (DaneWejsciowe daneWejsciowe : daneWejscioweArray) {
            for (Model model : modelsArray) {
                if (daneWejsciowe.argument.equalsIgnoreCase(model.argument)) {
                    pom = model.oblicz(daneWejsciowe.wartosc);
                    //System.out.println("cos  "+daneWejsciowe.wartosc+"  "+model.argument+"  => "+model.wniosek);
                    if (pom != null) {
                        Fact f = new Fact();
                        f.CF = 1.0f;
                        f.value = pom;
                        factsArray.add(f);
                        System.out.println("     " + f.value);
                        break;
                    }
                }
            }
        }
    }

    private float min(ArrayList<String> lista) {
        float mini = 3;
        for (String string : lista) {
            for (Fact fact : baza.lista) {
                if (string.equals(fact.value)) {
                    mini = mini > fact.CF ? fact.CF : mini;
                }
            }
        }
        return mini;
    }

    private void usuwanieOgraniczen() {
        for (Fact fact : factsArray) {  //dla każdego faktu
            Constraints ogr = findConstraint(fact.value, constraintsArray); //szukamy jego ograniczenia
            if (ogr != null) {
                for (String string : ogr.lista) {   //i każdy z jego sąsiadów
                    if (!fact.value.equals(string)) { //ale nie on sam
                        for (int i = 0; i < rulesArray.size(); i++) //przechodzimy przez wszystkie zasady
                        {
                            Rules rules = rulesArray.get(i);

                            for (String string1 : rules.warunki) {
                                if (string1.equals(string)) {
                                    rulesArray.remove(rules);
                                    i=0;
                                }
                            }

                        }
                    }
                }


            }
        }

    }

    public void runn() {
        baza = new FactDataBase();

        wywiad();
        usuwanieOgraniczen();
        baza.lista = factsArray;
        int dlugoscListy = baza.lista.size();
        int poprzedniaDlugoscListy = 0;
        int iluNieMa = 0;
        System.out.println(baza.lista.size() + " sd");
        System.out.println("11");
        while (dlugoscListy != poprzedniaDlugoscListy) {
            System.out.println(rulesArray.size());
            Rules zasady;
            //for (Rules zasady : rulesArray) {
            for (int i = 0; i < rulesArray.size(); i++) {
                System.out.println("1.5555");
                zasady = rulesArray.get(i);
                iluNieMa = 0;
                //sprawdzenie, czy mozemy wywnioskowac daną zasadę (czy w liście factsArray posiadamy wszystkie elementy z zasady.warunki)
                for (String str : zasady.warunki) {
                    if (!czyIstnieje(str, factsArray)) {   //cos w tym stylu
                        iluNieMa++;
                    }
                }
                if (iluNieMa == 0) {
                    System.out.println("222");
                    float minimum = min(zasady.warunki);
                    if (zasady.kumulatywna == true) {
                        baza.addCumulative(zasady.wniosek, zasady.CF * minimum);
                        Rules z = zasady;
                        z.CF = baza.lista.get(baza.lista.size() - 1).CF;
                        kroki.add(z);
                    } else if (zasady.kumulatywna == false) {
                        System.out.println("  " + zasady.wniosek + " " + zasady.kumulatywna);
                        if (baza.addDisjunctive(rulesPath, zasady.CF, minimum)) {
                            //zasady.CF = baza.lista.
                            Rules z = zasady;
                            z.CF = baza.lista.get(baza.lista.size() - 1).CF;
                            kroki.add(z);
                        }
                    }

                    //sprawdzamy, czy reguła jest w ograniczeniach
                    //jeżeli jest, to usuwamy wszystkie reguły w warunkach
                    // których jest sąsiad tego wniosku
                    Constraints ogr = findConstraint(zasady.wniosek, constraintsArray);

                    if (ogr != null) {
                        for (String strin : ogr.lista) {
                            if (strin.equals(zasady.wniosek)) {
                                continue;
                            }
                            for (int j= 0; j < rulesArray.size(); j++) {
                                Rules zasada = rulesArray.get(i);

                                for (String warunek : zasada.warunki) {
                                    if (warunek.equals(strin)) {
                                        rulesArray.remove(zasada);
                                        j=0;
                                    }
                                }
                            }
                            
                        }
                    }

                    rulesArray.remove(zasady);

                } else if (iluNieMa == 1) {
                    System.out.println("sdfsdfsdfsfd");
                    System.out.println(zasady.wniosek);
                    for (String rrrr : zasady.warunki) {
                        System.out.println(rrrr);
                    }

                    String pom = "";
                    //
                    //sprawdzamy, czy brakujący warunek nie jest ograniczeniem...
                    //
                    for (String str : zasady.warunki) {
                        if (!czyIstnieje(str, factsArray)) {
                            pom = str;
                        }
                    }
                    Constraints ograniczenie = findConstraint(pom, constraintsArray);
                    //boolean flaga = ifConstraint(pom);
                    System.out.println("!!!!! " + pom);

                    //
                    //...i jeżeli jest to sprawdzamy czy nie jest przypadkiem wnioskiem w jakiejś regule
                    //
                    boolean doubleBreaker = false;
                    if (ograniczenie != null) {
                        for (String string : ograniczenie.lista) {
                            for (Rules zasada : rulesArray) {
                                if (zasada.wniosek.equals(string)) {
                                    doubleBreaker = true;
                                    break;
                                }
                            }
                            if (doubleBreaker) {
                                break;
                            }
                        }

                        //ograniczenie nie jest wnioskiem w żadnej regule...
                        if (!doubleBreaker) {
                            //...trzeba więc zapytać usera
                            System.out.println("tu wchodze do pytania");
                            baza.addCumulative(askAboutConstraint(ograniczenie.lista), 1.0f);
                        }
                    }
                }
            }

            poprzedniaDlugoscListy = dlugoscListy;
            dlugoscListy = baza.lista.size();
        }

//        for (Fact fact : factsArray) {
//            System.out.println(fact.value + " CF: " + fact.CF);
//        }
//        for (Rules r : kroki) {
//            for (String str : r.warunki) {
//                System.out.print(str+" + ");
//            }
//            System.out.println("=> "+r.wniosek);
//        }
    }
}
