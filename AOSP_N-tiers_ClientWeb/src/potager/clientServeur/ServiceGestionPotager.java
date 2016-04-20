package potager.clientServeur;

import java.util.List;

import potager.entity.Potager;
import potager.service.exception.CPPotagerException;
import potager.service.exception.DaoPotagerAjoutException;
import potager.service.exception.DaoPotagerGetException;
import potager.service.exception.DaoPotagerModificationException;
import potager.service.exception.DaoPotagerQueryException;
import potager.service.exception.DaoPotagerSuppressionException;
import potager.service.exception.DimensionPotagerException;
import potager.service.exception.NomPotagerException;
import potager.service.exception.ProprietairePotagerException;
import utilisateur.entity.Jardinier;

public interface ServiceGestionPotager {
	
	public Potager ajouterPotager(Potager potager)
			throws NomPotagerException, CPPotagerException, ProprietairePotagerException, DimensionPotagerException, DaoPotagerAjoutException;;
	
	public Potager getPotager();
	
	public Potager getPotager(int idPotager) throws DaoPotagerGetException;
	
	public Potager modifierPotager(Potager potager) throws DaoPotagerModificationException, NomPotagerException, CPPotagerException, ProprietairePotagerException, DimensionPotagerException;
	
	public void    supprimerPotager(int idPotager) throws DaoPotagerSuppressionException, DaoPotagerGetException;
	
	public void annuler() throws DaoPotagerAjoutException, DaoPotagerModificationException;
	
	public int getNombreAnnulations();
	
	/**
	 * Renvoie tout les potagers de l'application
	 * @return
	 * @throws DaoPotagerQueryException 
	 */
	public List<Potager> listerPotager() throws DaoPotagerQueryException;
	
	/**
	 * Renvoie tout les potagers d'un jardinier
	 * @param proprietaire
	 * @return
	 * @throws DaoPotagerQueryException 
	 */
	public List<Potager> listerPotager(Jardinier proprietaire) throws DaoPotagerQueryException;
		
	/**
	 * Renvoie une liste de potager, en recherchant par une propriï¿½tï¿½ du potager
	 * Ex: listerPotager("nom", "mon Potager", false)
	 * 
	 * @param nomPropriete     Nom de la propriété recherchï¿½e ex: "nom"
	 * @param valeurPropriete  Valeur recherchée ex: "mon potager"
	 * @param isExact          Si true, la valeur recherchï¿½e doit correspondre exactement
	 * @return
	 */
	public List<Potager> listerPotager(String nomPropriete, String valeurPropriete, boolean isExact);

	public List<Potager> listerPotager(String codePostal) throws DaoPotagerQueryException;
	
}
