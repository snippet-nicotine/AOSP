package planning.service.planning;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import planning.dao.IDao;
import planning.entity.Follower;
import planning.entity.Planning;
import planning.exception.DaoException;
import planning.exception.ServiceException;

/**
 * EJB session bean de type Stateless, LocalBean : Controleur de
 * la couche service qui gère la partie crud d'un planning.
 * Permet de rediriger l'action dans la couche dao.
 * @author Didier
 *
 */
@Stateless
@LocalBean
public class ControleurServiceCrudPlanning {

	@EJB
	private IDao iDao;

	public void creerPlanning(Planning planning) throws ServiceException {
		try {
			iDao.creerPlanning(planning);
		} catch (DaoException e) {
			throw new ServiceException("ControleurServiceCrudPlanning creerPlanning : Erreur de création de planning");
		}
	}
	
	public void supprimerPlanning(int idPlanning) throws ServiceException{
		try {
			iDao.supprimerPlanning(idPlanning);
		} catch (DaoException e) {
			throw new ServiceException("ControleurServiceCrudPlanning supprimerPlanning : Erreur de suppression de planning");
		}
	}
	
	public Planning getPlanning(int idPlanning) throws ServiceException {
		try {
			return iDao.getPlanning(idPlanning);
		} catch (Exception e) {
			throw new ServiceException("ControleurServiceCrudPlanning getPlanning : Erreur sur la recherche d'un planning");
		}
	}
	
	public void modifierPlanning(Planning planning) throws ServiceException{
		try {
			iDao.modifierPlanning(planning);
		} catch (DaoException e) {
			throw new ServiceException("ControleurServiceCrudPlanning modifierPlanning : Erreur de modification de planning");
		}
	}
	
	public Planning creationPlanning(Planning planning) throws ServiceException {
		// TODO
		return null;
		
	}
	
	public Planning creationPlanning(String nom, String prenom) {
		// TODO
		return null;
	}
}
