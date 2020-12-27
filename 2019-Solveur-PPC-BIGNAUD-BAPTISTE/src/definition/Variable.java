package definition;

public class Variable {
    private Domain dom; // le domaine associe
    private String id;
  
    public Variable(int min, int max, String id) {
		super();
		this.dom = new DomainBitSet(min,max);
		this.id=id;
	}

	public Domain getDomain() {
        return this.dom;
    }
	
	public String toString() {
		return id+" "+dom+"";
	}
    
    // retourne vrai ssi la variable est instanciee
    public boolean isInstantiated() {
        if (dom.size()==1){
        	return true;
        }
        return false;
    }

    // retourne vrai ssi le domaine de la variable contient la valeur v
    public boolean canBeInstantiatedTo(int v) {
    	if (dom.contains(v)){
    		return true;
    		
    	}
        return false;
    }
    
    public void SetDomain (Domain domaine) {
    	this.dom=domaine;
    }

    // retourne le nombre de valeurs dans le domaine de la variable
    public int getDomainSize() {
    	return (dom.size());
        
    }

    // supprime la valeur v du domaine de la variable
    public void remValue(int v) {
    	dom.remove(v);
    }

    // supprime toutes les valeurs entre min (inclus) et max (inclus)
    public void remValues(int min, int max) {
    	dom.remove(min, max);
    }

    // vide le domaine : supprime toutes ses valeurs
    public void remAllValues() {
    	dom.removeAll();
    }

    // instantie la variable a la valeur v
    public void instantiate(int v) {
    	dom.instantiate(v);;
    }

    // retourne la plus petite valeur du domaine
    public int getInf() {
        return dom.firstValue();
    }

    // retourne la plus grande valeur du domaine
    public int getSup() {
        return dom.lastValue();
    }

    // retourne la valeur affectee a la variable ssi la variable est effectivement instanciee, sinon -1
    public int getValue() {
    	if (this.isInstantiated()==true) {
    		return dom.firstValue();
    	}
        return -1;
    }

    public boolean isEmpty() {
    	if (dom.size()==0){
    		return true;
    	}
        return false;
    }

}