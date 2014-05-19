package newpackage;

import java.util.ArrayList;

public class FactDataBase {

    public ArrayList<Fact> lista = new ArrayList<Fact>();

    private Fact czyIstnieje(String nazwa) {
        for (Fact fact : lista) {
            if (fact.value.equals(nazwa)) {
                return fact;
            }
        }
        return null;
    }

    private float abs(float x) {
        return x < 0 ? -x : x;
    }

    public void addCumulative(String nazwa, float CF) { //użwana w przypadku reguł kumulatywnych
        Fact pom;

        pom = czyIstnieje(nazwa);

        if (pom != null) {//sprawdzenie czy lista zawiera element o takiej nazwie
            lista.remove(pom);
            if (CF >= 0 && pom.CF >= 0) {
                pom.CF = CF + pom.CF - CF * pom.CF;
            } else if (CF >= 0 && pom.CF <= 0 || CF <= 0 && pom.CF >= 0) {
                pom.CF = (CF + pom.CF) / (1 - (abs(CF) < abs(pom.CF) ? abs(CF) : abs(pom.CF)));
            } else {
                pom.CF = CF + pom.CF + CF * pom.CF;
            }

            lista.add(pom);


        } else {
            pom = new Fact();
            pom.value = nazwa;
            pom.CF = CF;
            lista.add(pom);
        }

    }

    public boolean addDisjunctive(String nazwa, float CF, float CFMin) { //użwana w przypadku reguł dysjunktywnych
        Fact pom; //= new Fact();

        pom = czyIstnieje(nazwa);


        if (pom != null) {//sprawdzenie czy lista zawiera element o takiej nazwie

            if ((CF < 0 && CFMin < 0) || (pom.CF > CF * CFMin)) {
                return false;
            } else {
                lista.remove(pom);
                pom.CF = CF * CFMin;

                lista.add(pom);
            }

        } else {
            pom = new Fact();
            pom.value = nazwa;
            pom.CF = CF;
            lista.add(pom);
        }
        
        return true;
    }
}
