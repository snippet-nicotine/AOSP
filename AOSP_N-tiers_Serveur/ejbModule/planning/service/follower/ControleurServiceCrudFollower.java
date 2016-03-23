package planning.service.follower;

import java.time.LocalDate;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import planning.dao.IDao;
import planning.entity.Evenement;
import planning.entity.Follower;
import planning.entity.Nutrition;
import planning.entity.Planning;
import planning.entity.Plante;
import planning.exception.DaoException;
import planning.exception.ServiceException;
import planning.util.Action;

/**
 * EJB session bean de type Stateless, LocalBean : Controleur de
 * la couche service qui gère la partie crud d'un follower.
 * Permet de rediriger l'action dans la couche dao.
 * @author Didier
 *
 */
@Stateless
@LocalBean
public class ControleurServiceCrudFollower {

	@EJB
	private IDao iDao;

	public void creerFollower(Follower follower) throws ServiceException {
		try {
			iDao.creerFollower(follower);
		} catch (DaoException e) {
			throw new ServiceException("ControleurServiceCrudFollower creerFollower : Erreur de création de follower");
		}
	}
	
	public void supprimerFollower(int idFollower) throws ServiceException{
		try {
			iDao.supprimerFollower(idFollower);
		} catch (DaoException e) {
			throw new ServiceException("ControleurServiceCrudFollower supprimerFollower : Erreur de suppression de Follower");
		}
	}
	
	public Follower getFollower(int idFollower) throws ServiceException {
		try {
			return iDao.getFollower(idFollower);
		} catch (Exception e) {
			throw new ServiceException("ControleurServiceCrudFollower getFollower : Erreur sur la recherche d'un Follower");
		}
	}
	
	public void modifierFollower(Follower follower) throws ServiceException{
		try {
			iDao.modifierFollower(follower);
		} catch (DaoException e) {
			throw new ServiceException("ControleurServiceCrudFollower modifierFollower : Erreur de modification de Follower");
		}
	}
	
	public Follower creationFollower() throws ServiceException {
		// TODO
		return null;
		
	}
	
	public Follower creationFollower(String nom, String prenom) {
		// TODO
		return null;
	}
}
