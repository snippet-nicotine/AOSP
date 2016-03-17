package planning.dao.planning;

import planning.dao.ressource.AccesBdd;
import planning.entity.Carre;
import planning.entity.Planning;
import planning.exception.DaoException;

/**
 * Ne sert pas pour l'instant
 * @author Didier
 *
 */
public class OracleControleurDaoListerPlanning {
	
	/**
	 * Initialisation de la base
	 */
	public void init() {
		AccesBdd connect    = new AccesBdd();
	}

	public Planning rechercherPlanning(Carre carre) throws DaoException {
		return null;
	}
	
}
