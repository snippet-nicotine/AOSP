package potager.service.command;

import java.util.LinkedList;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import potager.dao.exception.DaoPotagerAjoutException;
import potager.dao.exception.DaoPotagerModificationException;

/**
 * 
 * @author Nicolas Lambert
 *
 *	Classe qui s'occupe de g�rer les commandes.
 *  Annuler() annule la derni�re commande ex�cut�e.
 *
 */
@Stateless
@LocalBean
public class Historique {

	private LinkedList<IUndoCommand> commandes;
	
	@PostConstruct
	public void initialiser(){
		commandes = new LinkedList<IUndoCommand>();
	}

	
	public void annuler() throws DaoPotagerAjoutException, DaoPotagerModificationException{
		
		System.out.println("commandes: " + commandes);
		IUndoCommand derniereCommande = commandes.pop();
		
		if( commandes.size() != 0 && derniereCommande != null){
			derniereCommande.undo();
		}
				
	}
	
	public void ajouter(IUndoCommand commande){
		System.out.println("commandes: " + commandes);
		commandes.push(commande);
		System.out.println("commandes size: " + commandes.size() );
	}


	public int getNbAnnulations() {
		return commandes.size();
	}
	
	
	
}
