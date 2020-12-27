package definition;

import java.util.ArrayList;
import java.util.List;

public abstract class Constraint_abs implements Constraint {
	public Variable vars1;
	public Variable vars2;
	

	
	
	public abstract boolean isSatisfied();
	public abstract boolean isNecessary();
	
	public abstract Filter_result filter();
	public boolean allInstantiated(){
		if (vars1.isInstantiated() && vars2.isInstantiated()) {
			return true;
		}
		return false;
	}
	
	public abstract String toString() ;
	
		
	


}
