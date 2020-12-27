package definition;

import java.util.ArrayList;
import java.util.List;

public class Constraint_different extends Constraint_abs implements Constraint {
	
	public List<Variable> getVars() {
		List <Variable> vars= new ArrayList<Variable>();
		vars.add(vars1);
		vars.add(vars2);
		return vars;
	}

	public boolean isSatisfied() {
		if (vars1.isInstantiated() && vars2.isInstantiated()) {
			if (vars1.getValue() != vars2.getValue()) {
				return true;
			}
		}
		
		return false;
	}

	
	public boolean isNecessary() {
		if ((vars2.isInstantiated() && vars1.isInstantiated() && vars1.getValue()==vars2.getValue())) {
			
			return false;
			}
			return true;
		}

	public Constraint_different(Variable vars1, Variable vars2) {
		super();
		this.vars1 = vars1;
		this.vars2 = vars2;
	}


	@Override
	public String toString() {
	
		return (vars1+"!="+vars2);
	}


	@Override
	public Filter_result filter() {
		if (vars1.isInstantiated() && vars2.isInstantiated()) {
			return Filter_result.Vide;
		}
		
		if (vars1.isInstantiated() && vars2.getDomain().contains(vars1.getValue())){
			vars2.getDomain().remove(vars1.getValue());
			return Filter_result.Modifié;
		}
		if (vars2.isInstantiated() && vars1.getDomain().contains(vars2.getValue())){
			vars1.getDomain().remove(vars2.getValue());
			return Filter_result.Modifié;
		}
		
		return Filter_result.NonModifié;
		
	}

}
