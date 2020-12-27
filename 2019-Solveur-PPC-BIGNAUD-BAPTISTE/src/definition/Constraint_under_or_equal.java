package definition;

import java.util.ArrayList;
import java.util.List;

public class Constraint_under_or_equal extends Constraint_abs implements Constraint{
	

	
	public Constraint_under_or_equal(Variable vars1, Variable vars2) {
		super();
		this.vars1 = vars1;
		this.vars2 = vars2;
	}

	public List<Variable> getVars() {
		List <Variable> vars= new ArrayList<Variable>();
		vars.add(vars1);
		vars.add(vars2);
		return vars;
	}
	

	@Override
	public boolean isSatisfied() {
		//System.out.println(vars1.getDomain().toString()+ vars2.getDomain());
		
		if (vars1.isInstantiated() && vars2.isInstantiated()) {
			if (vars1.getValue() <= vars2.getValue()) {
				
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isNecessary() {
		if ((vars2.getSup()<vars1.getInf())){
			//System.out.println("isNecessary " + false+" "+ this);
			
			return false;
			}
			//System.out.println("isNecessary " + true+" "+ this);
			return true;
	}

	



	@Override
	public String toString() {
		return (vars1+" ≤ " + vars2);
	}



	@Override
	public Filter_result filter() {
		//System.out.println("début filter "+ this);
		if (vars1.getInf()>vars2.getSup()) {
			//System.out.println("probleme");
			return Filter_result.Vide;
			
		}
		
		else if (vars1.getSup()>vars2.getSup()) {
			vars1.getDomain().remove(vars2.getSup()+1, vars1.getSup());
			return Filter_result.Modifié;
		}
		
		else if (vars1.getInf()> vars2.getInf()) {
			vars2.getDomain().remove(vars2.getInf(),vars1.getInf()-1);
			return Filter_result.Modifié;
		}
		
		 return Filter_result.NonModifié;
		
	}

}
