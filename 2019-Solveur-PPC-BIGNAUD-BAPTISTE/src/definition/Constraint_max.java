package definition;

import java.util.ArrayList;
import java.util.List;

public class Constraint_max extends Constraint_abs implements Constraint { 

	public Variable vars3;

	public Constraint_max(Variable vars1, Variable vars2, Variable vars3) {
		super();
		this.vars1 = vars1;
		this.vars2 = vars2;
		this.vars3 =  vars3;
	}


	public List<Variable> getVars() {
		List <Variable> vars= new ArrayList<Variable>();
		vars.add(vars1);
		vars.add(vars2);
		vars.add(vars3);
		return vars;
	}


	public boolean isSatisfied() {
		if (vars1.isInstantiated() && vars2.isInstantiated() && vars3.isInstantiated()) {
			if (vars3.getValue()== Math.max(vars1.getValue(), vars2.getValue())) {

				return true;
			}
		}
		return false;
	}




	public boolean isNecessary() {
		if (vars3.getInf()>vars1.getSup() && vars3.getInf()>vars2.getSup()
				|| vars3.getSup()<vars1.getInf() && vars3.getSup()<vars2.getInf()) {
			return false;
		}

		return true;
	}




	public Filter_result filter() {
		

		return Filter_result.NonModifié;

	}

	public String toString() {
		return (vars3+" = max(" + vars1+ " , "+ vars2 + " )");
	}


}
