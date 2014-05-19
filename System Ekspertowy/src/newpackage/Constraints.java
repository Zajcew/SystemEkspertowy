package newpackage;

import java.util.ArrayList;

public class Constraints {
    public ArrayList<String> lista = new ArrayList<String>();
    public String name;
    
        public Constraints(String name, ArrayList<String> exclusionsList) {
        this.name = name;
        this.lista = exclusionsList;
    }

}
