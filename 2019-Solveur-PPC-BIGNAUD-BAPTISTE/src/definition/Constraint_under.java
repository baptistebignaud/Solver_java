package definition;

import java.util.ArrayList;

import java.util.List;

public class Constraint_under extends Constraint_abs implements Constraint{
	
	
	
	public Constraint_under(Variable vars1, Variable vars2) {
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
		if (vars1.isInstantiated() && vars2.isInstantiated()) {
			if (vars1.getValue() < vars2.getValue()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isNecessary() {
		if ((vars2.getSup()<=vars1.getInf())){
		return false;
		}
		return true;
	}

	
	@Override
	public String toString() {
		
		return (vars1.getDomain()+"<" + vars2.getDomain());
	}


	@Override
	
		public Filter_result filter() {
		
			if (vars1.getInf()>=vars2.getSup()) {
				return Filter_result.Vide;
			}
			if (vars1.getSup()>=vars2.getSup()) {
				vars1.getDomain().remove(vars2.getSup(), vars1.getSup()) ;
				return Filter_result.Modifié;
			}
			
			if (vars1.getInf()>= vars2.getInf()) {
				vars2.getDomain().remove(vars2.getInf(), vars1.getInf());
				return Filter_result.Modifié;
			}
			
			return Filter_result.NonModifié;
			
		
	}

}
