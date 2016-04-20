package potager.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import potager.clientServeur.ServiceGestionPotager;
import potager.dao.exception.DaoPotagerAjoutException;
import potager.dao.exception.DaoPotagerGetException;
import potager.dao.exception.DaoPotagerModificationException;
import potager.dao.exception.DaoPotagerQueryException;
import potager.dao.exception.DaoPotagerSuppressionException;
import potager.entity.Carre;
import potager.entity.Potager;
import potager.service.command.Historique;
import potager.service.controlleurs.ControlleurCarre;
import potager.service.controlleurs.ControlleurJardinage;
import potager.service.controlleurs.ControlleurPotager;
import potager.service.exception.CPPotagerException;
import potager.service.exception.DimensionPotagerException;
import potager.service.exception.NomPotagerException;
import potager.service.exception.ProprietairePotagerException;
import utilisateur.entity.Jardinier;

@Stateless
@Remote(ServiceGestionPotager.class)
public class FacadeServiceGestionPotager implements ServiceGestionPotager{
	
	@EJB
	ControlleurJardinage controlleurJardinage;
	@EJB
	ControlleurPotager   controlleurPotager;
	@EJB
	Historique historique;
	@EJB
	ControlleurCarre controlleurCarre;

	@Override
	public Potager getPotager(int idPotager) throws DaoPotagerGetException {	
		
		Potager potager = controlleurPotager.getPotager(idPotager);
		potager.clean();
		return potager;
		
	}

	@Override
	public Potager modifierPotager(Potager potager) throws DaoPotagerModificationException, NomPotagerException, CPPotagerException, ProprietairePotagerException, DimensionPotagerException {	
		
		potager = controlleurPotager.modifierPotager(potager);
		potager.clean();
		return potager;
		
	}

	@Override
	public List<Potager> listerPotager() throws DaoPotagerQueryException {	
		
		ArrayList<Potager> potagers = (ArrayList<Potager>) controlleurPotager.listerPotager();
		clean(potagers);
		return potagers;
				
	}

	@Override
	public List<Potager> listerPotager(Jardinier proprietaire) throws DaoPotagerQueryException {
		ArrayList<Potager> potagers = (ArrayList<Potager>) controlleurPotager.listerPotager(proprietaire);
		clean(potagers);
		return potagers;
	}

	@Override
	public List<Potager> listerPotager(String nomPropriete, String valeurPropriete, boolean isExact) {
		// TODO Lister les potagers par propriétaire et par la valeur d'une propriété
		return null;
	}
	
	@Override
	public List<Potager> listerPotager(String codePostal) throws DaoPotagerQueryException {
		ArrayList<Potager> potagers = (ArrayList<Potager>) controlleurPotager.listerPotager(codePostal);
		clean(potagers);
		return potagers;
	}

	@Override
	public void supprimerPotager(int idPotager) throws DaoPotagerSuppressionException, DaoPotagerGetException {
		
		controlleurPotager.supprimerPotager(idPotager);		
		
	}

	@Override
	public Potager ajouterPotager(Potager potager)
			throws NomPotagerException, CPPotagerException, ProprietairePotagerException, 
			       DimensionPotagerException, DaoPotagerAjoutException 
	{
		Potager newPotager =  controlleurPotager.ajouterPotager(potager);
		newPotager.clean();
		return newPotager;
	}

	@Override
	public void annuler() throws DaoPotagerAjoutException, DaoPotagerModificationException {
		historique.annuler();
	}

	@Override
	public int getNombreAnnulations() {
		return controlleurPotager.getNombreAnnulations();
	}

	@Override
	public Potager getPotager() {
		return controlleurPotager.getPotager();
	}
	
	/**
	 * Permet de renvoyer des entities dépourvuues de persistenceBag
	 * @param potagers
	 */
	public void clean(List<Potager> potagers){
		
		for(Potager potager : potagers){
			potager.clean();
		}
	}

	@Override
	public Carre creerCarre(Carre carre) throws DaoPotagerAjoutException {
		return controlleurCarre.creerCarre(carre);
	}

	
	

}
