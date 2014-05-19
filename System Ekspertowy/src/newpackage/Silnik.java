package newpackage;

import java.util.ArrayList;
import java.util.Random;

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

//        Fact t = new Fact();
//        t.CF = 0.5f;
//        t.value = "goraczka";
//        factsArray.add(t);
//
//        Fact t2 = new Fact();
//        t2.CF = 0.3f;
//        t2.value = "bolglowy";
//        factsArray.add(t2);
//
//        Fact t3 = new Fact();
//        t3.CF = 0.3f;
//        t3.value = "pobyt tropiki";
//        factsArray.add(t3);
        

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
        constraintsArray = Parser.restrictionsList;
        
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

        Random rand = new Random();
        return constraint.get(rand.nextInt() % constraint.size());
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
        for (DaneWejsciowe daneWejsciowe : daneWejscioweArray) {
            for (Model model : modelsArray) {
                if (daneWejsciowe.argument.equals(model.argument)) {
                    pom = model.oblicz(daneWejsciowe.wartosc);
                    if (pom != null) {
                        Fact f = new Fact();
                        f.CF = 1.0f;
                        f.value = pom;
                        factsArray.add(f);
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
                if (string.equals(fact.value))
                    mini = mini>fact.CF ? fact.CF : mini;
            }
        }
        return mini;
    }
    

    public void runn() {
        baza = new FactDataBase();
        baza.lista = factsArray;
        int dlugoscListy = baza.lista.size();
        int poprzedniaDlugoscListy = 0;
        int iluNieMa = 0;


        wywiad();
        while (dlugoscListy != poprzedniaDlugoscListy) {

            Rules zasady;
            //for (Rules zasady : rulesArray) {
            for (int i = 0; i < rulesArray.size(); i++) {
                zasady = rulesArray.get(i);
                iluNieMa = 0;
                //sprawdzenie, czy mozemy wywnioskowac daną zasadę (czy w liście factsArray posiadamy wszystkie elementy z zasady.warunki)
                for (String str : zasady.warunki) {
                    if (!czyIstnieje(str, factsArray)) {   //cos w tym stylu
                        iluNieMa++;
                    }
                }
                if (iluNieMa == 0) {
                    
                    float minimum = min(zasady.warunki);
                    if (zasady.kumulatywna == true) {
                        baza.addCumulative(zasady.wniosek, zasady.CF*minimum);
                        kroki.add(zasady);
                    } else if (zasady.kumulatywna == false) {
                        System.out.println("  "+zasady.wniosek+" "+zasady.kumulatywna);
                        if (baza.addDisjunctive(rulesPath, zasady.CF, minimum)) {
                            kroki.add(zasady);
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
                            for (Rules zasada : rulesArray) {
                                for (String warunek : zasada.warunki) {
                                    if (warunek.equals(strin)) {
                                        rulesArray.remove(zasada);
                                    }
                                }
                            }
                        }
                    }

                    rulesArray.remove(zasady);

                } else if (iluNieMa == 1) {

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
                            baza.addCumulative(askAboutConstraint(ograniczenie.lista),1.0f);
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
