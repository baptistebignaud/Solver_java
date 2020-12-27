package definition;

import java.util.ArrayList;
import java.util.List;

public class Csp {

    List<Variable> vars; // l'ensemble des variables du CSP. Note: les domaines sont connus au travers des variables
    List<Constraint> cons; // l'ensemble des contraintes du CSP
    
    
    public Csp(List<Variable> variable) {
    	vars=variable;
    }
    
    
    public Csp(List<Variable> variable,List<Constraint> constraint) {
    	vars=variable;
    	cons=constraint;
    	
    }


    public List<Variable> getVars() {
        return vars;
    }
    
    public List<Constraint> getConstraints() {
	return this.cons;
    }
    
    // retourne la premiere variable non instanciee du csp
    public Variable nextVarToInstantiate() {
    	for (int i=0; i<=vars.size()-1;i++) {
    		if (vars.get(i).isInstantiated()==false) {
    			return vars.get(i);
    		}
    	}
        return null;
    }

    // retourne vrai ssi toutes les variables sont instanciées
    public boolean allInstanciated() {
    	for (Variable x : vars) {
    		if (!(x.isInstantiated())) {return false;}
    	}
        return true;
    }

    // retourne vrai ssi le CSP possède (au moins) une solution : 
    // l'ensemble des contraintes du CSP est vérifié
    // ATTENTION : ce n'est pas la seule condition
    public boolean hasSolution() {
         for (Constraint c: cons) {
        	 if (!(c.isSatisfied())){
        		 return false;
        	 }
         }
         return true;
    }
    
    public List<Domain> getDom(){
    	List <Domain> s= new ArrayList<Domain>();
    	for (Variable v: this.getVars()) {
    		s.add(v.getDomain());
    	}
    	return s;
    }

 
}
