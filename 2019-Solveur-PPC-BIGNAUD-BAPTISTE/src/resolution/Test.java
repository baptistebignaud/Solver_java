package resolution;

import java.util.ArrayList;
import java.util.List;

import definition.Constraint;
import definition.Constraint_different;
import definition.Constraint_max;
import definition.Constraint_different;
import definition.Constraint_under;
import definition.Constraint_under_or_equal;
import definition.Csp;
import definition.Variable;
import resolution.SearchV1;

public class Test {



	public static void main (String[] args) {
		// Commentaire 
		// Il faut décommenter au début de backtrack2 dans Search v2: //System.out.println("La solution numéro "+ (compteur+1) +" "+ "est " +csp.getDom());
		
		
		//Question 1
		// Il faut  commenter l'affichage des solutions dans backtrack2 pour que ce soit lisible
		//for (int valMax=3; valMax<=8; valMax++) {
			//Question1.resolutionPb(valMax);
		//}

		//Question 1.3 Il y a 199 solutions
		//Question 1.4 Il y a 2126 solutions
		//Question 1.5 Il y a 14172 solutions
		//Question 1.8 Il y a 69284 solutions



		//Question 2.1
		//MonteeEnCharge.circuitInferieurs(10);//Temps<1s
		//MonteeEnCharge.circuitInferieurs(100); //Temps<5s
		//MonteeEnCharge.circuitInferieurs(1000); //Temps<1min
		//MonteeEnCharge.circuitInferieurs(10000); //Overflow
		//MonteeEnCharge.circuitInferieurs(100000);  //Overflow


		//Question 2.2
		//MonteeEnCharge.circuitInferieursEtDifferents(10);//Temps<1s
		//MonteeEnCharge.circuitInferieursEtDifferents(100); //Temps<1s
		//MonteeEnCharge.circuitInferieursEtDifferents(1000); //Temps<5s
		//MonteeEnCharge.circuitInferieursEtDifferents(10000); //Overflow
		//MonteeEnCharge.circuitInferieursEtDifferents(100000);  //Overflow
		
		//Question 2.3
		//MonteeEnCharge.circuitInferieursStricts(10);//Temps<1s
		//MonteeEnCharge.circuitInferieursStricts(100); //Temps<1s
		//MonteeEnCharge.circuitInferieursStricts(1000); //Temps<5s
		//MonteeEnCharge.circuitInferieursStricts(10000); /Temps<10s
		//MonteeEnCharge.circuitInferieursStricts(100000);  //Temps<10s
		
		//Question 3.3
		//Commentaire
		//Il faut décommenter au début de backtrack2 dans Search v2:    System.out.println("La solution numéro "+ (compteur+1) +" "+ "est "+csp.getConstraints().get(0).getVars().get(2) );
		//List<Variable> vars = new ArrayList<Variable>();
		//List<Constraint> cons = new ArrayList<Constraint>();
		//Variable x = new Variable(6,10,"x");
		//vars.add(x);
		//Variable y = new Variable(1,5, "y");
		//vars.add(y);
		//Variable m = new Variable(4,7,"m");
		//vars.add(m);
		//Constraint c1 = new Constraint_max(x,y,m);
		//cons.add(c1);
		//Csp cspQuestion_3_3 = new Csp(vars,cons);
		//SearchV2.backtrack2(cspQuestion_3_3);
		//System.out.println("Le nombre de solutions est "+ SearchV2.compteur + "\n" + "Le nombre d'instantiation est "+SearchV2.comptInstantiate);


	}

}

