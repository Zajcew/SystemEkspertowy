package newpackage;

import java.util.ArrayList;

public class Rules {

    public ArrayList<String> warunki = new ArrayList<String>();
    public String wniosek;
    public float CF;
    public boolean kumulatywna;

    public Rules() {
    }

    public Rules(String conclusion, Float cf, boolean cumulative, ArrayList<String> symptomsList) {
        this.wniosek = conclusion;
        this.CF = cf;
        this.kumulatywna = cumulative;
        this.warunki = symptomsList;
    }
}
