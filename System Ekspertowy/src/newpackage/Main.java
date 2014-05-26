package newpackage;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Silnik engine = new Silnik();

        //załadowanie danych wejściowych do silnika:
        ArrayList<DaneWejsciowe> lista = new ArrayList<DaneWejsciowe>();
        engine.daneWejscioweArray = lista;


        engine.read(System.getProperty("user.dir")+"/model.xml", System.getProperty("user.dir")+"/reguly.xml", System.getProperty("user.dir")+"/ograniczenia.xml"); //ścieżki do plików: modelu, zasad i ograniczeń
        engine.parse(); //parsowanie xmla
        engine.runn(); //uruchomienie wnioskowania

        //wyświetlenie co z czego zostało wywnioskowane:
        
        for (Rules r : engine.kroki) {
            for (String str : r.warunki) {
                System.out.print(str + " + ");
            }
            System.out.println("=> " + r.wniosek + ", CF=" + r.CF);
        }
        
        for (Fact dane  : engine.baza.lista) {
            System.out.println(dane.value+" -  "+dane.CF);
        }

    }
}
