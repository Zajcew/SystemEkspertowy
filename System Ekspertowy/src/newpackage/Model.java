package newpackage;
import java.util.ArrayList;
import java.util.List;

public class Model {

    public String argument;
    public String wniosek;
    public ArrayList<String> operatory = new ArrayList<String>();
    public ArrayList<Float> parametry = new ArrayList<Float>();

    public boolean is(float a, String operator, float parametr) {
     // System.out.println(operator+"   "+parametr);
        if (operator.equals(">")) {
            return a > parametr;
        } else if (operator.equals("&gt=")) {
            return a >= parametr;
        } else if (operator.equals("<")) {
            return a < parametr;
        } else if (operator.equals("&lt=")) {
            return a <= parametr;
        } else if (operator.equals("=")) {
            return a == parametr;
        } else {
            return false;
        }

    }

    public String oblicz(float a) {
        boolean result = true;
        for (int i = 0; i < operatory.size(); i++) {
            result = result && is(a, operatory.get(i), parametry.get(i));
        }
        return result ? wniosek : null;
    }
    
        public Model(String conclusion, String argument, ArrayList<Float> parametersList, ArrayList<String> operatorsList) {
        this.wniosek = conclusion;
        this.argument = argument;
        this.parametry = parametersList;
        this.operatory = operatorsList;
    }
}
