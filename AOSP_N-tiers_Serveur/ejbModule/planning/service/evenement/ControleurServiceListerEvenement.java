package planning.service.evenement;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import planning.dao.IDao;
import planning.entity.Evenement;
import planning.exception.DaoException;
import planning.exception.ServiceException;
import planning.util.Utilitaire;

/**
 * EJB session bean de type Stateless, LocalBean : Controleur de
 * la couche service qui gère la partie lister d'un évènement.
 * Permet de rediriger l'action dans la couche dao.
 * @author Didier
 *
 */
@Stateless
@LocalBean
public class ControleurServiceListerEvenement {

	@EJB
	private IDao iDao;

	public List<Evenement> rechercherAllEvenement(int idPlanning) throws ServiceException {
		List<Evenement> le = null;
		if (!Utilitaire.isEntierPositifNonNull(idPlanning)) {
			throw new ServiceException("ControleurServiceListerEvenement rechercherAllEvenement : la valeur est négative ou nul");
		}
		try {
			le = iDao.rechercherAllEvenement(idPlanning);
		} catch (DaoException e) {
			throw new ServiceException("ControleurServiceListerEvenement rechercherAllEvenement : Erreur de recherche tous les evenements");
		}
		return le;
	}
}
