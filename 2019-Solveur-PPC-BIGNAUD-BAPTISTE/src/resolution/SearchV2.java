package resolution;

import java.util.ArrayList;
import definition.Constraint;
import java.util.Iterator;

import definition.Constraint;
import definition.Csp;
import definition.Domain;
import definition.Filter_result;
import definition.Variable;
import definition.Filter_result;
import definition.Constraint_abs;


public class SearchV2 {
	public static int compteur=0;
	public static int iteratioon=0;
	public static int noeud=0;
	public static int comptInstantiate=0;




	public static boolean verif(Csp csp) {
		for (Constraint c: csp.getConstraints()) {
			if (c.allInstantiated()) {
				boolean nom = c.isSatisfied();
				if (!(nom)) {
					return false;
				}
			}
		}
		return true;
	}

	public static void backtrack1(Csp csp) {
		iteratioon+=1;

		if (csp.allInstanciated()) {
			//System.out.println("La solution" +csp.getDom());
			if (csp.hasSolution()) {
				// traitement du cas où une solution a été trouvée :
				// instanciation complète ET vérification que c'est une solution
				System.out.println("La solution numéro "+ (compteur+1) +" "+ "est "+csp.getDom() );
				
				
				compteur+=1;
				//System.out.println(noeud);

			}

		}



		else {
			Variable y = csp.nextVarToInstantiate();


			Domain domaine_2= y.getDomain().clone();
			for (int val : domaine_2) {
				// à compléter
				Domain domaine_1= y.getDomain().clone();
				y.instantiate(val);
				noeud+=1;

				if (verif(csp)){
					backtrack1(csp);
				}
				y.SetDomain(domaine_1);

			}
		}
	}


	public static void backtrack2(Csp csp) {
		//iteratioon+=1;

		if (csp.allInstanciated()) {
			//System.out.println("La solution" +csp.getDom());
			if (csp.hasSolution()) {
				// traitement du cas où une solution a été trouvée :
				// instanciation complète ET vérification que c'est une solution
				//System.out.println("La solution numéro "+ (compteur+1) +" "+ "est " +csp.getDom());
				//System.out.println("La solution numéro "+ (compteur+1) +" "+ "est "+csp.getConstraints().get(0).getVars().get(2) );
				compteur+=1;


			}

		}



		else {

			Variable y = csp.nextVarToInstantiate();
			//System.out.println("Domaine de y au début"+ "\n"+ y.getDomain()+"\n" + "\n");



			Domain domaine_2= y.getDomain().clone();
			for (int val : domaine_2) {
				//System.out.println("Renvoie val "+val);
				ArrayList<Domain> domaines = new ArrayList<Domain>();
				// fonction copy de csp
				for (Variable vi : csp.getVars()) {
					Domain di= vi.getDomain().clone();
					domaines.add(di);

				}
				//System.out.println(domaines);
				y.instantiate(val);
				comptInstantiate+=1;
				//System.out.println("Avant propagation"+ "\n"+ y +"\n" + "\n");
				//for( Variable vi: csp.getVars()) {
					//System.out.println(vi);}
				propagation(csp,y);
				//System.out.println("Après propagation");
				//for( Variable vi: csp.getVars()) {
					//System.out.println(vi);}
				
				//
				
				//if (!(propagation(csp,y)==Filter_result.Vide)) {

				//System.out.println("instanciation de y"+"\n" +y.getDomain());


				//}


				boolean isNecessary=true;
				Iterator<Constraint> iterator=csp.getConstraints().iterator();
				while (iterator.hasNext() && isNecessary) {
					isNecessary=iterator.next().isNecessary();
				}
				//System.out.println("après boucle necessary "+"\n"+isNecessary+"\n");

				if (isNecessary){
					//System.out.println("\n"+"boucle necessary");
					backtrack2(csp);

				}

				for (int i= 0; i<csp.getVars().size(); i++) {
					csp.getVars().get(i).SetDomain(domaines.get(i).clone());
					//System.out.println("Après restauration  "+ csp.getVars().get(i));
				}
				

				//for(Domain di: domaines) {
				//	int i=0;
				//	csp.getVars().get(i).SetDomain(di);
				//i+=1;
			}

			//}
			//}

			//else {
			//	System.out.println("Il n'y a pas de solution");
			//}

		}
	}


	public static Filter_result propagation (Csp csp, Variable var) {
		for (Constraint c: csp.getConstraints()) {
			if (c.getVars().contains(var)) {
				Filter_result fr= c.filter();
				//System.out.println(c);
				if (fr==Filter_result.Modifié) {
					if (c.getVars().get(0)==var) {
						return propagation(csp,c.getVars().get(1));

					}
					else {
						return propagation(csp,c.getVars().get(0));
					}
				}

				else if (fr==Filter_result.Vide){
					return fr;
				}
			}

		}
		//System.out.println("\n"+"non modifié");
		return Filter_result.NonModifié;

	}

}



