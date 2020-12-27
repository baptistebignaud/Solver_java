package resolution;

import java.util.ArrayList;

import definition.Constraint;
import definition.Csp;
import definition.Domain;
import definition.Variable;


public class SearchV1 {
	
	public static int compteur;
	
	public SearchV1() {
		compteur=0;
	}
	
	
    
    //---------------------------------------------------------------------------------------------------
    // bruteForceSearch : on génère toutes les instanciations possibles :
    // aucune contrainte : toute instanciation complète est une solution
    //---------------------------------------------------------------------------------------------------

    public static void bruteForceSearch(Csp csp) {
        
        if (csp.allInstanciated()) {
        	ArrayList<Integer> liste = new ArrayList<Integer>();
        	for (Variable v : csp.getVars()) {liste.add(v.getValue());}
        	System.out.println( "La solution numéro "+(compteur+1)+ " " + "est "+ liste);
        	compteur+=1;
            }
        
        else {
            Variable y = csp.nextVarToInstantiate();
            
           
           Domain domaine_2= y.getDomain().clone();
            for (int val : domaine_2) {
                // à compléter
                Domain domaine_1= y.getDomain().clone();
                y.instantiate(val);
                bruteForceSearch(csp);
                y.SetDomain(domaine_1);
               

            }
        }
    }

    //---------------------------------------------------------------------------------------------------
    // generateAndTest : on ajoute un test pour vérifier si une instanciation complète est une solution
    // Note : si le csp n'a aucune contrainte, c'est le même comportement que bruteForceSearch
    //---------------------------------------------------------------------------------------------------

    public static void generateAndTest(Csp csp) {
    	ArrayList<Integer> liste = new ArrayList<Integer>();
    	for (Variable v : csp.getVars()) {
    		liste.add(v.getValue());}
    	if (csp.allInstanciated()) {
            if (csp.hasSolution()) {
                // traitement du cas où une solution a été trouvée :
                // instanciation complète ET vérification que c'est une solution
            			System.out.println("La solution numéro "+ (compteur+1) +" "+ "est " +liste);
            			compteur+=1;
            	}
            		
            	}
            
        else {
            Variable y = csp.nextVarToInstantiate();
            
           
           Domain domaine_2= y.getDomain().clone();
            for (int val : domaine_2) {
                // à compléter
                Domain domaine_1= y.getDomain().clone();
                y.instantiate(val);
                generateAndTest(csp);
                y.SetDomain(domaine_1);
            }
        }
        }
}
        
    
    
    

