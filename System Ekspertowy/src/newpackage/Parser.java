package newpackage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPath;



public class Parser {
    public static ArrayList<Model> modelsList = new ArrayList<Model>();
    public static ArrayList<Rules> rulesList = new ArrayList<Rules>();
    public static ArrayList<Constraints> restrictionsList = new ArrayList<Constraints>();
    
    public void toParse(String modell, String reguly, String ograniczenia) {
       try {
            // TODO code application logic here
            System.out.println("[ Ścieżki do plików ]\n");
            String modelsDir = modell;//System.getProperty("user.dir")+"/sample files/models.xml";
            String restrictionsDir = ograniczenia;//System.getProperty("user.dir")+"/sample files/restrictions.xml";
            String rulesDir = reguly;//System.getProperty("user.dir")+"/sample files/rules.xml";
            System.out.println("Models dir: "+modelsDir);
            System.out.println("Restrictions dir: "+restrictionsDir);
            System.out.println("Rules dir: "+rulesDir+"\n");
            
            SAXBuilder builder = new SAXBuilder();
            File modelsXML = new File(modelsDir);
            File restrictionsXML = new File(restrictionsDir);
            File rulesXML = new File(rulesDir);
            
            // Model - START
            System.out.println("[ Modele ]\n");
            Document modelsDocument = (Document) builder.build(modelsXML);
            Element modelsRoot = modelsDocument.getRootElement();
            List modelsChildren = modelsRoot.getChildren("model");
            
            for (int i=0; i<modelsChildren.size(); i++) {
                ArrayList<String> operatorsList = new ArrayList();
                ArrayList<Float> parametersList = new ArrayList();
                Element model = (Element) modelsChildren.get(i);
                String conclusion = model.getChildText("wniosek");
                String argument = model.getChildText("argument");             
                // Operatory
                List operators = model.getChildren("operatory");
                List operator;
                for(int j=0; j<operators.size(); j++) {
                        operator = ((Element)operators.get(j)).getChildren("operator");                           
                        for(int k=0; k<operator.size(); k++) {
                            operatorsList.add(((Element)operator.get(k)).getText().replaceAll(" ", ""));
                        }                     
                }               
                // Parametry
                List parameters = model.getChildren("parametry");
                List parameter;
                for(int j=0; j<parameters.size(); j++) {
                        parameter = ((Element)parameters.get(j)).getChildren("parametr");                           
                        for(int k=0; k<parameter.size(); k++) {
                            parametersList.add(Float.parseFloat(((Element)parameter.get(k)).getText().replaceAll(" ", "")));
                        }                     
                }
                System.out.println(conclusion);
                modelsList.add(new Model(conclusion, argument, parametersList, operatorsList));
            }
            // Model - KONIEC
            
            // Rule - START
            System.out.println("[ Reguły ]\n");
            Document rulesDocument = (Document) builder.build(rulesXML);
            Element rulesRoot = rulesDocument.getRootElement();
            List rulesChildren = rulesRoot.getChildren("regula");
            
            for (int i=0; i<rulesChildren.size(); i++) {
                ArrayList<String> symptomsList = new ArrayList();
                Element rule = (Element) rulesChildren.get(i);
                String conclusion = rule.getChildText("wniosek");
                String cf = rule.getChildText("cf");
                boolean cumulative = false;
                if(rule.getChildText("kumulatywna")!=null) {
                     System.out.println(rule.getChildText("kumulatywna"));
                     System.out.println(rule.getChildText("kumulatywna").equals("true"));
                 }
                if(rule.getChildText("kumulatywna")!=null && rule.getChildText("kumulatywna").equals("true")) {
                    cumulative = true;
                } 
                // Objawy
                List symptoms = rule.getChildren("objawy");
                List symptom;
                for(int j=0; j<symptoms.size(); j++) {
                        symptom = ((Element)symptoms.get(j)).getChildren("objaw");                           
                        for(int k=0; k<symptom.size(); k++) {
                            symptomsList.add(((Element)symptom.get(k)).getText());
                        }                     
                }               
                rulesList.add(new Rules(conclusion, Float.parseFloat(cf), cumulative, symptomsList));
                
            }
            // Rule - KONIEC
            
            // Ograniczenia - START
            System.out.println("[ Ograniczenia ]\n");
            Document restrictionsDocument = (Document) builder.build(restrictionsXML);
            Element restrictionsRoot = restrictionsDocument.getRootElement();
            List restrictionsChildren = restrictionsRoot.getChildren("ograniczenie");
            
            for (int i=0; i<restrictionsChildren.size(); i++) {
                ArrayList<String> exclusionsList = new ArrayList();
                Element restriction = (Element) restrictionsChildren.get(i);
                String name = restriction.getChildText("nazwa");
                // Wykluczenia
                List exclusions = restriction.getChildren("wykluczenia");
                List exclusion;
                for(int j=0; j<exclusions.size(); j++) {
                        exclusion = ((Element)exclusions.get(j)).getChildren("wykluczenie");                           
                        for(int k=0; k<exclusion.size(); k++) {
                            exclusionsList.add(((Element)exclusion.get(k)).getText());
                        }                     
                }               
                System.out.println(name);
                restrictionsList.add(new Constraints(name, exclusionsList));
            }
            // Ograniczenia - KONIEC
        } catch (JDOMException ex) {
            //Logger.getLogger(InferenceMechanism.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            //Logger.getLogger(InferenceMechanism.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
