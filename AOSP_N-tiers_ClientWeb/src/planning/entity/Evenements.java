package planning.entity;

import java.util.ArrayList;
import java.util.Iterator;

public class Evenements {

	public ArrayList<Evenement> evenements;
	
	public Evenements() {
		evenements = new ArrayList<Evenement>();
	}

	public Evenements(ArrayList<Evenement> evenements) {
		if (evenements == null) {
			this.evenements = new ArrayList<Evenement>();
		}
		else {
			this.evenements = evenements;
		}
	}

	public Object[] toArray() {
		return evenements.toArray();
	}

	/*
	 * Retourne l'�v�nement de la liste d'�v�nement situ�  � la position ind
	 */
	public Evenement getInstanceAt(int ind) {
		Evenement evenement = null;
		if (ind < evenements.size())
			evenement = evenements.get(ind);
		return evenement;
	}

	/*
	 * Recherche l'�v�nement dans la liste et renvoie son instance (la r�f�rence) 
	 */
	public Evenement getInstance(Evenement evenement) {
		Iterator<Evenement> i  = this.getIterator();
		Evenement evenementTrouve = null;
		while (i.hasNext()) {
			Evenement a = i.next();
			if (a.equals(evenement)) {
				evenementTrouve = a;
			}
		}
		return evenementTrouve;
	}

	/*
	 * Test l'existance d'un �v�nement dans la liste 
	 * return : true / false
	 */
	public boolean find(Evenement evenement) {
		boolean rep = false;
		Iterator<Evenement> thisI = this.getIterator();
		while (thisI.hasNext()) {
			if (thisI.next().equals(evenement)) rep = true;
		}
		return rep;
	}

	@Override
	public boolean equals(Object obj) {
		boolean rep = true;
		Iterator<Evenement> thisI = this.getIterator();

		if (obj instanceof Evenement) {

			Iterator<Evenement> i = ((Evenements) obj).getIterator();

			while (i.hasNext() && thisI.hasNext()) {
				Evenement a = i.next();		// �v�nement suivant de la liste pass�e en param�tre
				Evenement b = thisI.next();	// �v�nement suivant de l'instance

				if (!(a.equals(b))) rep = false;
			}
			// si on a pas fini une des 2 listes
			if (i.hasNext()||thisI.hasNext()) {
				// System.out.println("une des listes n'est pas finie");
				rep = false;
			}
		}
		else rep = false;
		return rep;

	}

	public Iterator<Evenement> getIterator() {
		return evenements.iterator();
	}


	public void addEvenement(Evenement newEvenement) {
		if (newEvenement != null && !this.evenements.contains(newEvenement))
			this.evenements.add(newEvenement);
	}

	public void removeEvenement(Evenement oldEvenement) {
		if (oldEvenement != null && this.evenements != null)
			if (this.evenements.contains(oldEvenement))
				this.evenements.remove(oldEvenement);
	}

	public void removeAllEvenements() {
		evenements.clear();
	}

	public ArrayList<Evenement> getEvenements() {
		return evenements;
	}

	public void setEvenements(ArrayList<Evenement> evenements) {
		if (evenements != null) {
			removeAllEvenements();
			for (Iterator<Evenement> iter = evenements.iterator(); iter.hasNext();) {
				Evenement a = (Evenement)iter.next();
				if (!find(a)) addEvenement(a);  // pas de doublons
			}
		}
	}

	@Override
	public String toString() {
		return evenements.toString();
	}
}
