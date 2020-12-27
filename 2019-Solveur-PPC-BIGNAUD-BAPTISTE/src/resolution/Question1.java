package resolution;

import java.util.ArrayList;
import java.util.List;

import definition.Constraint;
import definition.Constraint_different;
import definition.Constraint_under;
import definition.Constraint_under_or_equal;
import definition.Csp;
import definition.Variable;

public class Question1 {
	
	public static void  resolutionPb(int valMax) {
		List<Variable> vars = new ArrayList<Variable>();
		int valmax = valMax;
		Variable x0 = new Variable(1,valMax,"x0");
		vars.add(x0);
		Variable x1 = new Variable(1,valMax, "x1");
		vars.add(x1);
		Variable x2 = new Variable(1,valMax,"x2");
		vars.add(x2);
		Variable x3 = new Variable(1,valMax,"x3");
		vars.add(x3);
		Variable x4 = new Variable(1,valMax,"x4");
		vars.add(x4);
		Variable x5 = new Variable(1,valMax,"x5");
		vars.add(x5);
		Variable x6 = new Variable(1,valMax,"x6");
		vars.add(x6);
		Variable x7 = new Variable(1,valMax,"x7");
		vars.add(x7);
		Variable x8 = new Variable(1,valMax,"x8");
		vars.add(x8);
		Variable x9 = new Variable(1,valMax,"x9");
		vars.add(x9);
		
		
		List<Constraint> cons = new ArrayList<Constraint>();
		Constraint c1 = new Constraint_under(x0,x9);
		Constraint c2 = new Constraint_under_or_equal(x0,x3);
		Constraint c3 = new Constraint_different(x0,x7);
		Constraint c4 = new Constraint_under(x1,x4);
		Constraint c5 = new Constraint_under(x2,x3);
		Constraint c6 = new Constraint_different(x2,x4);
		Constraint c7 = new Constraint_under_or_equal(x8,x3);
		Constraint c8 = new Constraint_under(x6,x4);
		Constraint c9 = new Constraint_different(x4,x7);
		Constraint c10 = new Constraint_under(x4,x9);
		Constraint c11 = new Constraint_under(x5,x9);
		Constraint c12 = new Constraint_under_or_equal(x6,x8);
		Constraint c13 = new Constraint_under(x6,x9);
		Constraint c14 = new Constraint_under(x9,x7);
		Constraint c15 = new Constraint_under(x9,x8);
		cons.add(c1);
		cons.add(c2);
		cons.add(c3);
		cons.add(c4);
		cons.add(c5);
		cons.add(c6);
		cons.add(c7);
		cons.add(c8);
		cons.add(c9);
		cons.add(c10);
		cons.add(c11);
		cons.add(c12);
		cons.add(c13);
		cons.add(c14);
		cons.add(c15);

		
		Csp cspEval = new Csp(vars,cons);
		
		SearchV2.backtrack2(cspEval);
		System.out.println("Le nombre de solutions est "+ SearchV2.compteur + "\n" + "Le nombre d'instantiation est "+SearchV2.comptInstantiate);
		
	
	}
	

}


	

	
	
	
	