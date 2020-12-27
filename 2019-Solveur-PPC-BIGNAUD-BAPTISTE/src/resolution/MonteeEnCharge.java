package resolution;

import java.util.ArrayList;
import java.util.List;

import definition.Constraint;
import definition.Constraint_different;
import definition.Constraint_under;
import definition.Constraint_under_or_equal;
import definition.Csp;
import definition.Variable;

public class MonteeEnCharge {
	
	public static void circuitInferieurs(int nb) {
		List<Variable> vars = new ArrayList<Variable>();
		List<Constraint> cons = new ArrayList<Constraint>();
		Variable x0= new Variable(1,10,"x"+0);
		vars.add(x0);
		
		for (int i=1; i <= nb-1; i++){
			Variable xi_1= vars.get(i-1);
			Variable xi= new Variable(1,10,"x"+(i-1));
			vars.add(xi);
			Constraint ci= new Constraint_under_or_equal(xi_1,xi);
			cons.add(ci);
			
		}
		
		Constraint cn= new Constraint_under_or_equal(vars.get(nb-1),x0);
		cons.add(cn);
		
		Csp cspMEC = new Csp(vars,cons);

		SearchV2.backtrack2(cspMEC);
		System.out.println("Le nombre de solutions est "+ SearchV2.compteur + "\n" + "Le nombre d'instantiation est "+SearchV2.comptInstantiate);

		}
	
	public static void circuitInferieursEtDifferents(int nb) {
		List<Variable> vars = new ArrayList<Variable>();
		List<Constraint> cons = new ArrayList<Constraint>();
		Variable x0= new Variable(1,10,"x"+0);
		vars.add(x0);
		
		for (int i=1; i <= nb-1; i++){
			Variable xi_1= vars.get(i-1);
			Variable xi= new Variable(1,10,"x"+(i-1));
			vars.add(xi);
			Constraint ci= new Constraint_under_or_equal(xi_1,xi);
			Constraint cd= new Constraint_under_or_equal(xi_1,xi);
			cons.add(ci);
			cons.add(cd);
			
		}
		
		Constraint cn= new Constraint_under_or_equal(vars.get(nb-1),x0);
		Constraint cnb= new Constraint_different(vars.get(nb-1),x0);
		cons.add(cnb);
		cons.add(cn);
		
		Csp cspMEC = new Csp(vars,cons);

		SearchV2.backtrack2(cspMEC);
		System.out.println("Le nombre de solutions est "+ SearchV2.compteur + "\n" + "Le nombre d'instantiation est "+SearchV2.comptInstantiate);

		}
	
	public static void circuitInferieursStricts(int nb) {
		List<Variable> vars = new ArrayList<Variable>();
		List<Constraint> cons = new ArrayList<Constraint>();
		Variable x0= new Variable(1,10,"x"+0);
		vars.add(x0);
		
		for (int i=1; i <= nb-1; i++){
			Variable xi_1= vars.get(i-1);
			Variable xi= new Variable(1,10,"x"+(i-1));
			vars.add(xi);
			Constraint ci= new Constraint_under(xi_1,xi);
			cons.add(ci);
			
		}
		
		Constraint cn= new Constraint_under(vars.get(nb-1),x0);
		cons.add(cn);
		
		Csp cspMEC = new Csp(vars,cons);

		SearchV2.backtrack2(cspMEC);
		System.out.println("Le nombre de solutions est "+ SearchV2.compteur + "\n" + "Le nombre d'instantiation est "+SearchV2.comptInstantiate);

		}

	}
		
	
	
