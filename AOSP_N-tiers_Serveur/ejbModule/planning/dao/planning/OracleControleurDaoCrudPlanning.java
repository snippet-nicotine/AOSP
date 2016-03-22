package planning.dao.planning;

import planning.dao.ressource.AccesBdd;
import planning.entity.Planning;
import planning.exception.DaoException;

/**
 * Ne sert pas pour l'instant
 * @author Didier
 *
 */
public class OracleControleurDaoCrudPlanning {

	/**
	 * Initialisation de la base
	 */
	public void init() {
		AccesBdd connect    = new AccesBdd();
	}
	
	public void creerPlanning(Planning planning) throws DaoException {
	}
	public void supprimerPlanning(int idPlanning) throws DaoException {
	}
	public void modifierPlanning(Planning planning) throws DaoException {
	}
	
}
